// Scenario:
// The `OrderHelper` class accesses and modifies internal fields of the `Order` class directly.
// This makes `OrderHelper` too familiar with the internals of `Order`, violating encapsulation.
//
// Task for Students:
// Refactor the code to reduce coupling by using public methods in `Order` instead of accessing fields directly.
// Apply **Encapsulate Field**, **Move Method**, or **Hide Delegate** as needed.

public class Order {
    private List<Item> items = new ArrayList<>();
    private double discount = 0.0;

    public void addItem(Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }

    public double getDiscount() {
        return discount;
    }

    public void applyDiscount(double rate) {
        double total = 0;
        for (Item item : items) {
            total += item.getPrice();
        }
        this.discount = total * rate;
    }
}
public class OrderHelper {
    public void applyDiscount(Order order, double rate) {
        order.applyDiscount(rate);
    }
}
