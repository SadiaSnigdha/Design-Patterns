package labmid.Builder;

public interface RecordBuilder {
    void addHeader(String patientName, int recordId, String department);
    void addTests();
    void addDiagnosis();
    void addNotes();
    String build();
}


