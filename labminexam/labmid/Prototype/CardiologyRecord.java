package labmid.Prototype;
import labmid.Builder.RecordBuilder;
import labmid.Builder.DetailedRecordBuilder;
import labmid.Builder.SummaryRecordBuilder;
public class CardiologyRecord extends PatientRecord {
    public CardiologyRecord() {
        this.department = "Cardiology";
    }

    @Override
    public void display() {
        RecordBuilder builder = new DetailedRecordBuilder();
        String output = buildRecord(builder);
        System.out.println(output);
    }
}