package universitymanagement;

class Student {
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private String phoneNumber;
    private String emergencyContact;
    private int age;
    private double tuitionBalance;
    private boolean hasScholarship;
    private int attendanceCount;
    
    public Student(String firstName, String lastName, String email, String major, String phoneNumber, String emergencyContact, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.major = major;
        this.phoneNumber = phoneNumber;
        this.emergencyContact = emergencyContact;
        this.age = age;
        this.tuitionBalance = 0.0;
        this.hasScholarship = false;
        this.attendanceCount = 0;
    }
    
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getMajor() { return major; }
    public int getAge() { return age; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getEmergencyContact() { return emergencyContact; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public double getTuitionBalance() { return tuitionBalance; }
    public int getAttendanceCount() { return attendanceCount; }
    public boolean hasScholarship() { return hasScholarship; }
    
    public void incrementAttendance() {
        attendanceCount++;
    }
    
    public void makeTuitionPayment(double amount) {
        tuitionBalance = Math.max(0, tuitionBalance - amount);
    }
    
    public void addTuitionCharge(double amount) {
        tuitionBalance += amount;
    }
    
    public void awardScholarship() {
        hasScholarship = true;
    }
    
    public void attendClass() {
        incrementAttendance();
    }
}
