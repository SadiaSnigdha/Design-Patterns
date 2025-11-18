// Scenario:
// The `InvoicePrinter` class accesses many details of the `Invoice` class (e.g., lineItems, totals) and performs logic
// that arguably belongs to `Invoice`. This violates encapsulation and creates tight coupling.
// 
// Task for Students:
// Refactor the code by moving relevant logic (like total and tax calculation) into the `Invoice` class.
// Apply the **Move Method** refactoring technique.

public class Invoice {
    private List<LineItem> items;

    public List<LineItem> getItems() {
        return items;
    }

    public double calculateSubtotal() {
        double subtotal = 0;
        for (LineItem item : items) {
            subtotal += item.getPrice();
        }
        return subtotal;
    }

    public double calculateTax() {
        return calculateSubtotal() * 0.2;
    }

    public double calculateTotal() {
        return calculateSubtotal() + calculateTax();
    }
}


public class InvoicePrinter {
    public void printInvoice(Invoice invoice) {
        System.out.println("Subtotal: " + invoice.calculateSubtotal());
        System.out.println("Tax: " + invoice.calculateTax());
        System.out.println("Total: " + invoice.calculateTotal());
    }
}
