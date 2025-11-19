package Prototype;

public class InvoiceTemplate implements Document , Cloneable{
    private String header = "Invoice Header";
    private String style = "Standard";

    @Override
    public Document clone() {
        try {
            return (Document) super.clone();
        } catch (CloneNotSupportedException e) {
            return new InvoiceTemplate();
        }
    }

    @Override
    public void display() {
        System.out.println("Invoice - Header: " + header + ", Style: " + style);
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
