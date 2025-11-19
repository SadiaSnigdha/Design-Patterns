// Scenario:
// The code accesses multiple objects in a chain (e.g., `order.getCustomer().getAddress().getZipCode()`).
// This makes the code fragile — any change in the structure requires updates in many places.
//
// Task for Students:
// Refactor the code to hide the internal structure by adding delegation methods in the parent classes.
// Apply **Hide Delegate** or **Move Method** to simplify calls.

public class Order {
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }
}

public class Customer {
    private Address address;

    public Address getAddress() {
        return address;
    }
}

public class Address {
    private String zipCode;

    public String getZipCode() {
        return zipCode;
    }
}

// Somewhere in your code:
String zip = order.getCustomer().getAddress().getZipCode();
