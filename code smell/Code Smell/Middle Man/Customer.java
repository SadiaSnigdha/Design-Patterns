// Scenario:
// The `CustomerManager` class just delegates every method to the `Customer` object without adding logic.
// This is unnecessary indirection and makes the design more complex.
//
// Task for Students:
// Refactor the code to remove the middle man. Use the `Customer` object directly where needed.
// Apply **Remove Middle Man** refactoring.

public class Customer {
    private String name;
    private String email;

    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
}

public class CustomerManager {
    private Customer customer;

    public String getCustomerName() {
        return customer.getName();
    }

    public String getCustomerEmail() {
        return customer.getEmail();
    }
}
