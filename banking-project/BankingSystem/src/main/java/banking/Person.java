package banking;

import java.util.Objects;

/**
 * The concrete Account holder of Person type.
 */
public class Person extends AccountHolder {
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName, int idNumber) {
        super(idNumber);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return super.equals(o) && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName);
    }

}
