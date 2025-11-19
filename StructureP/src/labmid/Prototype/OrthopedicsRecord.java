package labmid.Prototype;

public class OrthopedicsRecord extends PatientRecord {
    @Override
    public void display() {
        System.out.println("Record ID: " + id);
        System.out.println("Orthopedics Record for " + patientName);
        System.out.println("Includes X-ray, Bone Density Test");
    }
}