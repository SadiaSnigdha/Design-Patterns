package labmid.Prototype;

public class NeurologyRecord extends PatientRecord {
    @Override
    public void display() {
        System.out.println("Record ID: " + id);
        System.out.println("Neurology Record for " + patientName);
        System.out.println("Includes MRI, Cognitive Assessment");
    }
}