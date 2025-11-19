package labmid.Prototype;
import labmid.Builder.RecordBuilder;
public abstract class PatientRecord implements Cloneable {
    protected int id;
    protected String patientName;
    protected String department;

    public abstract void display();

    public String buildRecord(RecordBuilder builder) {
        builder.addHeader(patientName, id, department);
        builder.addTests();
        builder.addDiagnosis();
        builder.addNotes();
        return builder.build();
    }

    @Override
    public PatientRecord clone() {
        try {
            return (PatientRecord) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setPatientName(String name) {
        this.patientName = name;
    }
}