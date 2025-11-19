package labmid;

import labmid.Factory.CardiologyFactory;
import labmid.Factory.DepartmentFactory;
import labmid.Factory.NeurologyFactory;
import labmid.Factory.OrthopedicsFactory;
import labmid.Prototype.PatientRecord;

import java.util.HashMap;
import java.util.Map;

    public class PatientRecordService {

        private Map<String, DepartmentFactory> factoryMap = new HashMap<>();

        public PatientRecordService() {
            factoryMap.put("cardiology", new CardiologyFactory());
            factoryMap.put("neurology", new NeurologyFactory());
            factoryMap.put("orthopedics", new OrthopedicsFactory());
        }

        public void generateRecord(String department, String patientName) {
            DepartmentFactory factory = factoryMap.get(department.toLowerCase());
            if (factory == null) {
                System.out.println("Unknown department");
                return;
            }

            PatientRecord record = factory.createRecord().clone();
            record.setId(RecordIdGenerator.getInstance().getNextId());
            record.setPatientName(patientName);
            record.display();
        }

        public static void main(String[] args) {
            PatientRecordService service = new PatientRecordService();
            service.generateRecord("cardiology", "Rahim");
            System.out.println();
            service.generateRecord("neurology", "Karim");
        }
    }


