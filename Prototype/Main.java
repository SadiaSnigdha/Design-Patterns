package Prototype;

public class Main {
    public static void main(String[] args) {

        Document invoice = new InvoiceTemplate();
        Document report = new ReportTemplate();

        Document clonedInvoice = invoice.clone();
        ((InvoiceTemplate) clonedInvoice).setStyle("Custom");
        clonedInvoice.display();

        Document clonedReport = report.clone();
        ((ReportTemplate) clonedReport).setContent("Updated Content");
        clonedReport.display();
    }
}
