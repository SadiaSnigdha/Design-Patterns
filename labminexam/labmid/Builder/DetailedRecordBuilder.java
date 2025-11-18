package labmid.Builder;

    public class DetailedRecordBuilder implements RecordBuilder {
        private StringBuilder record;

        @Override
        public void addHeader(String patientName, int recordId, String department) {
            record = new StringBuilder();
            record.append("Record ID: ").append(recordId).append("\n");
            record.append(department).append(" Detailed Report for ").append(patientName).append("\n");
        }

        @Override
        public void addTests() {
            record.append("Tests: ECG, MRI, X-ray depending on department.\n");
        }

        @Override
        public void addDiagnosis() {
            record.append("Diagnosis: Detailed condition report based on test results.\n");
        }

        @Override
        public void addNotes() {
            record.append("Doctor's Notes: Prescription.\n");
        }

        @Override
        public String build() {
            return record.toString();
        }
    }

