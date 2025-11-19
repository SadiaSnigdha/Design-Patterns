package labmid.Factory;

import labmid.Prototype.NeurologyRecord;
import labmid.Prototype.PatientRecord;

public class NeurologyFactory  implements DepartmentFactory {
    @Override
    public PatientRecord createRecord() {
        return new NeurologyRecord();
    }
}
