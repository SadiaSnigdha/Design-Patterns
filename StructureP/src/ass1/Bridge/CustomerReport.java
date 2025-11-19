package Bridge;

class CustomerReport extends Report {
    public CustomerReport(Formatter formatter) {
        super(formatter);
    }

    public void generate(String content) {
        formatter.format("Customer Report", content);
    }
}