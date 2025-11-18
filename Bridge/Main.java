package Bridge;

public class Main {
    public static void main(String[] args) {
        Formatter pdfFormatter = new PDFformatter();
        Formatter csvFormatter = new CSVformatter();

        Report salesReport = new SalesReport(pdfFormatter);
        salesReport.generate("Sales increased by 20%");

        Report customerReport = new CustomerReport(csvFormatter);
        customerReport.generate("Customer satisfaction is 95%");
    }
}
