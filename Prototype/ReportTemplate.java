package Prototype;

public class ReportTemplate implements Document, Cloneable {
    private String header = "Report Header";
    private String content = "Dynamic Content";

    @Override
    public Document clone() {
        try {
            return (Document) super.clone();
        } catch (CloneNotSupportedException e) {
            return new ReportTemplate();
        }
    }
    @Override
    public void display() {
        System.out.println("Report - Header: " + header + ", Content: " + content);
    }

    public void setContent(String content) {
        this.content = content;
    }
}
