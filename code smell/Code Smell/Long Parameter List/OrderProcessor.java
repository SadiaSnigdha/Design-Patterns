// Scenario:
// When the `processOrder()` method is called, it's passing around a large number of parameters. 
// This makes it hard to understand and use correctly, and any future changes in the way we store customer information 
// or order details will require us to update every method that uses this signature. If you introduce a new property for 
// `Customer`, such as `email`, every method call must be updated. This increases the risk of errors and increases the 
// maintenance burden.
//
// Task for Students:
// Refactor the `processOrder()` method by grouping related parameters into appropriate objects 
// (e.g., `Customer`, `Product`, `ShippingDetails`).
// Apply the Introduce Parameter Object refactoring technique.

public class OrderProcessor {

    public void processOrder(String customerName, String customerAddress, String customerPhone, 
                             String productName, int quantity, double price, double discount, 
                             String paymentMethod, String shippingMethod) {
        // Order processing logic
    }
}
