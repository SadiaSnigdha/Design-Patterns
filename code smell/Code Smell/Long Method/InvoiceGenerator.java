// Scenario:
// Imagine you need to add a new feature that applies different tax rates based on the region. 
// However, since the `generateInvoice()` method is already long and complex, adding this 
// new tax logic would require modifying this massive block of code. This makes it error-prone, 
// difficult to test, and hard to maintain in the long term.
//
// Task for Students:
// Refactor the `generateInvoice()` method by breaking it into smaller, more manageable methods.
// Apply the Extract Method refactoring technique.

public class InvoiceGenerator {

    public void generateInvoice(Order order) {
        double total = 0;
        for (Item item : order.getItems()) {
            total += item.getPrice();
        }
        double discount = total * 0.1;
        double tax = total * 0.2;
        double finalAmount = total - discount + tax;

        System.out.println("Invoice for Order ID: " + order.getId());
        System.out.println("Items:");
        for (Item item : order.getItems()) {
            System.out.println(item.getName() + ": " + item.getPrice());
        }
        System.out.println("Total: " + total);
        System.out.println("Discount: " + discount);
        System.out.println("Tax: " + tax);
        System.out.println("Final Amount: " + finalAmount);
    }
}
