package labmid.Factory;

import labmid.Prototype.OrthopedicsRecord;
import labmid.Prototype.PatientRecord;

public class OrthopedicsFactory implements DepartmentFactory {
    @Override
    public PatientRecord createRecord() {
        return new OrthopedicsRecord();
    }
}
