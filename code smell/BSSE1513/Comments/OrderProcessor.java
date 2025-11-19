// Scenario:
// This class uses comments to explain complex logic instead of writing self-explanatory code. 
// Overreliance on comments may indicate unclear code structure or poor naming. When code is changed, 
// comments may become outdated and misleading.
//
// Task for Students:
// Refactor the code by replacing comments with clearer method names and logic. Use Extract Method and Rename Method 
// to make the code more self-documenting so that the comments become unnecessary.

public class OrderProcessor {
    double taxPercentage = 0.2;

    private boolean isOrderEmpty(Order order) {
        return order.getItems().isEmpty();
    }

    private double calculateTotalPrice(Order order) {
        double total = 0;
        for (Item item : order.getItems()) {
            total += item.getPrice();
        }
        return total;
    }

    private double applyTax(double amount) {
        return amount * (1+ taxPercentage); 
    }

    public void processOrder(Order order) {
    
        if (isOrderEmpty(order)) {
            System.out.println("Order is empty");
            return;
        }

        double totalPrice = calculateTotalPrice(order);

        double totalWithTax = applyTax(totalPrice);

        System.out.println("Total with tax: " + totalWithTax);
    }
}
