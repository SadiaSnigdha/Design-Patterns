package Bridge;

class SalesReport extends Report {
    public SalesReport(Formatter formatter) {
        super(formatter);
    }

    public void generate(String content) {
        formatter.format("Sales Report", content);
    }
}