package universitymanagement;

class Internship{
	private String companyName;
    private String position;
    private String term;
    
    public Internship(String companyName) {
        this.companyName = companyName;
        this.position = "Intern";
        this.term = "Current";
    }
    
    public Internship(String companyName, String position, String term) {
        this.companyName = companyName;
        this.position = position;
        this.term = term;
    }
    
    public String getCompanyName() { return companyName; }
    public String getPosition() { return position; }
    public String getTerm() { return term; }
}