package banking;

/**
 * Abstract bank account.
 */
public abstract class Account implements AccountInterface {
    private AccountHolder accountHolder;
    private Long accountNumber;
    private int pin;
    private double balance;

    protected Account(AccountHolder accountHolder, Long accountNumber, int pin, double startingDeposit) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = startingDeposit;
        this.pin = pin;
    }

    public AccountHolder getAccountHolder() {
        return this.accountHolder;
    }

    public boolean validatePin(int attemptedPin) {
        return attemptedPin == this.pin;
    }

    public double getBalance() {
        return this.balance;
    }

    public Long getAccountNumber() {
        return this.accountNumber;
    }

    public void creditAccount(double amount) {
        this.balance += amount;
    }

    public boolean debitAccount(double amount) {

        double currentBalance = this.balance - amount;
        if (currentBalance >= 0){
            this.balance = currentBalance;
            return true;
        } else {
            return false;
        }
    }
}
