// Scenario:
// This `Customer` class only contains fields and getters/setters, but no behavior. It's just a passive data holder, 
// making it vulnerable to misuse. Business logic related to the customer ends up scattered elsewhere, 
// violating encapsulation.
//
// Task for Students:
// Refactor the class by moving related logic (e.g., full name formatting, validation) into the `Customer` class 
// so that it encapsulates its behavior.
// Apply the **Encapsulate Field** and **Move Method** refactoring techniques.

public class Customer {
    private String firstName;
    private String lastName;
    private String email;

    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        setEmail(email); 
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String name) {
        this.lastName = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email format");
        }
        this.email = email;
    }

    public String getFullName() {
        return String.format("%s %s" , firstName != null ? firstName : " " , lastName != null? lastName : " ").trim();
    }

    private boolean isValidEmail(String email) {
        //return email != null && এখনে যেই condition  হবে তা জানি না
        return true;
    }

}
