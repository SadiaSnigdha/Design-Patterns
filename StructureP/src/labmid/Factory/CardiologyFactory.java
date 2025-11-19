package labmid.Factory;

import labmid.Prototype.CardiologyRecord;
import labmid.Prototype.PatientRecord;

public class CardiologyFactory implements DepartmentFactory {
    @Override
    public PatientRecord createRecord() {
        return new CardiologyRecord();
    }
}
