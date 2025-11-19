// Scenario:
// The logic for calculating and printing invoice totals is duplicated across two classes (`InvoiceService` and `ReceiptService`). 
// If you need to change the tax rate or formatting, you'll need to update it in both places, risking inconsistencies.
//
// Task for Students:
// Refactor the code to extract the duplicated logic into a shared method or utility class.
// Apply Extract Method and Pull Up Method (or use composition via a helper class) to eliminate redundancy.


public class OrderUtils {
    public static double calculateTotalWithTax(Order order) {
        double total = 0;
        for (Item item : order.getItems()) {
            total += item.getPrice();
        }
        double tax = total * 0.2;
        return total + tax;
    }
}


public class InvoiceService {
    public void printInvoice(Order order) {
        double totalWithTax = OrderUtils.calculateTotalWithTax(order);
        System.out.println("Invoice Total: " + totalWithTax);
    }
}

public class ReceiptService {
    public void printReceipt(Order order) {
        double totalWithTax = OrderUtils.calculateTotalWithTax(order);
        System.out.println("Receipt Total: " + totalWithTax);
    }
}
