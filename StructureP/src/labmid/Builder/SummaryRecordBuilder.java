package labmid.Builder;

public class SummaryRecordBuilder implements RecordBuilder {
    private StringBuilder record;

    @Override
    public void addHeader(String patientName, int recordId, String department) {
        record = new StringBuilder();
        record.append("Record ID: ").append(recordId).append("\n");
        record.append(department).append(" Summary for ").append(patientName).append("\n");
    }

    @Override
    public void addTests() {
    }

    @Override
    public void addDiagnosis() {
        record.append("Diagnosis: Brief summary available.\n");
    }

    @Override
    public void addNotes() {
    }

    @Override
    public String build() {
        return record.toString();
    }
}

