// Scenario:
// The `OrderManager` class is responsible for too many tasks — from order creation to shipping, 
// payment processing, and email notification. If a bug occurs in the `createOrder()` method, 
// there’s a risk that it might inadvertently affect other methods like `processPayment()` or `shipOrder()`. 
// As the system grows, maintaining and testing this class will become increasingly difficult.
//
// Task for Students:
// Refactor the `OrderManager` class by extracting responsibility into separate classes 
// (e.g., `PaymentProcessor`, `ShippingService`, `EmailService`, etc.).
// Apply the Extract Class refactoring technique.

public class OrderManager {
    private List<Order> orders = new ArrayList<>();

    public void createOrder(Order order) {
        orders.add(order);
    }
}

public class PaymentProcessor {
    public void processPayment(Order order, PaymentDetails paymentDetails) {
        // Payment processing logic
    }
}

public class ShippingService {
    public void shipOrder(Order order, Address address) {
         // Shipping logic
    }
}

public class EmailService {
    public void sendConfirmationEmail(Order order) {
        // Email logic
    }
}

public class InvoiceCalculator {
    public void calculateInvoice(Order order) {
        double total = 0;
        for (Item item : order.getItems()) {
            total += item.getPrice();
        }
        System.out.println("Total for Order: " + total);
    }
}
