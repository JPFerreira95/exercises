package banking;

import java.util.*;

/**
 * The Bank implementation.
 */
public class Bank implements BankInterface {
    private LinkedHashMap<Long, Account> accounts;
    private long currentAccountNumber;

    public Bank() {
        this.accounts = new LinkedHashMap<>();
        this.currentAccountNumber = 0L;
    }

    private Account getAccount(Long accountNumber) {

        if(this.accounts != null && this.accounts.containsKey(accountNumber)){
            return this.accounts.get(accountNumber);
        }

        //throw new RuntimeException("Account with number " + accountNumber + " not found.");
        return null;
    }

    public Long openCommercialAccount(Company company, int pin, double startingDeposit) {

        Long accountNumber = this.nextAccountNumber();
        CommercialAccount commercialAccount = new CommercialAccount(company, accountNumber, pin, startingDeposit);
        this.addAccount(commercialAccount);

        return accountNumber;
    }

    public Long openConsumerAccount(Person person, int pin, double startingDeposit) {

        Long accountNumber = this.nextAccountNumber();
        ConsumerAccount consumerAccount = new ConsumerAccount(person, accountNumber, pin, startingDeposit);
        this.addAccount(consumerAccount);

        return accountNumber;
    }

    public double getBalance(Long accountNumber) {
        Account currentAccount = this.getAccount(accountNumber);
        if (currentAccount == null) {
            return -1;
        } else {
            return currentAccount.getBalance();
        }
    }

    public void credit(Long accountNumber, double amount) {
        Account currentAccount = this.getAccount(accountNumber);
        currentAccount.creditAccount(amount);
    }

    public boolean debit(Long accountNumber, double amount) {
        Account currentAccount = this.getAccount(accountNumber);
        return currentAccount.debitAccount(amount);
    }

    public boolean authenticateUser(Long accountNumber, int pin) {
        Account currentAccount = this.getAccount(accountNumber);
        return currentAccount.validatePin(pin);
    }
    
    public void addAuthorizedUser(Long accountNumber, Person authorizedPerson) {
        if (this.accounts == null)
            this.accounts = new LinkedHashMap<>();

        Account account = this.getAccount(accountNumber);

        if (account instanceof CommercialAccount){
            ((CommercialAccount) account).addAuthorizedUser(authorizedPerson);
        } else {
            throw new RuntimeException("Unexpected account type.");
        }
    }

    public boolean checkAuthorizedUser(Long accountNumber, Person authorizedPerson) {

        if (!this.accounts.containsKey(accountNumber)) {
            return false;
        }

        Account account = this.getAccount(accountNumber);

        if (account instanceof CommercialAccount){
            return ((CommercialAccount) account).isAuthorizedUser(authorizedPerson);
        } else {
            return false;
        }
    }

    public Map<String, Double> getAverageBalanceReport() {

        final String COMMERCIAL_ACCOUNT = CommercialAccount.class.getSimpleName();
        final String CONSUMER_ACCOUNT = ConsumerAccount.class.getSimpleName();
        Map<String, Double> resultMap = new HashMap<>(2);
        resultMap.put(COMMERCIAL_ACCOUNT, 0.0);
        resultMap.put(CONSUMER_ACCOUNT, 0.0);

        if (this.accounts == null || this.accounts.isEmpty())
            return resultMap;

        int countCommercialAccount = 0;
        int countConsumerAccount = 0;

        for (Account account : this.accounts.values()) {

            if (account instanceof CommercialAccount) {
                Double newBalance = resultMap.get(COMMERCIAL_ACCOUNT) + account.getBalance();
                countCommercialAccount++;
                resultMap.put(COMMERCIAL_ACCOUNT, newBalance);
            } else if (account instanceof ConsumerAccount) {
                Double newBalance = resultMap.get(CONSUMER_ACCOUNT) + account.getBalance();
                countConsumerAccount++;
                resultMap.put(CONSUMER_ACCOUNT, newBalance);
            } else {
                throw new RuntimeException("Unexpected account type.");
            }
        }

        // Update result map summed values with average value
        resultMap.put(COMMERCIAL_ACCOUNT, resultMap.get(COMMERCIAL_ACCOUNT)/countCommercialAccount);
        resultMap.put(CONSUMER_ACCOUNT, resultMap.get(CONSUMER_ACCOUNT)/countConsumerAccount);

        return resultMap;
    }

    private void addAccount(Account account){
        if(this.accounts == null){
            this.accounts = new LinkedHashMap<>();
        }

        this.accounts.put(account.getAccountNumber(), account);
    }

    private long nextAccountNumber(){
        currentAccountNumber += 1;
        return this.currentAccountNumber;
    }

}
