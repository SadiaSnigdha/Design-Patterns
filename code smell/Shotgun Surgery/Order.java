// Scenario:
// The `Order` class is responsible for several operations, including validating the order, processing payment, 
// and handling shipping. If you need to add a new feature to any of these operations (for example, updating payment 
// processing), you will have to touch multiple parts of the code in several different classes. This shotgun approach 
// increases the risk of errors and makes it harder to maintain and extend the system.
//
// Task for Students:
// Refactor the code by moving each responsibility into its own class. Create classes like `OrderValidator`, `PaymentProcessor`, 
// and `ShippingHandler`, and delegate responsibility for these operations to those classes. 
// Apply the **Extract Class** and **Move Method** refactoring techniques.

public class OrderValidator {
    public void validate(Order order) {
        System.out.println("Validating order for " + order.getCustomerName());
        // Add real validation logic here (e.g., item count > 0)
    }
}

public class PaymentProcessor {
    public void process(Order order) {
        System.out.println("Processing payment for " + order.getCustomerName());
        // Add payment logic here
    }
}



public class Order {
    private String customerName;
    private List<Item> items;

    private OrderValidator validator = new OrderValidator();
    private PaymentProcessor paymentProcessor = new PaymentProcessor();
    private ShippingHandler shippingHandler = new ShippingHandler();

    public Order(String customerName, List<Item> items) {
        this.customerName = customerName;
        this.items = items;
    }

    public void processOrder() {
        validator.validate(this);
        paymentProcessor.process(this);
        shippingHandler.ship(this);
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<Item> getItems() {
        return items;
    }
}