// Scenario:
// The `AuditLogger` class was introduced to encapsulate logging logic, but it only contains one trivial method. 
// Maintaining such a class adds unnecessary complexity and overhead without delivering meaningful value.
//
// Task for Students:
// Refactor the code by inlining the class or moving the method to a more appropriate existing class.
// Apply the **Inline Class** refactoring technique.

public class OrderManager {
    
    public void processOrder(Order order) {
        log("Order processed: " + order.getOrderId());
    }
    
    private void log(String message) {
        System.out.println("Audit Log: " + message);
    }
}

