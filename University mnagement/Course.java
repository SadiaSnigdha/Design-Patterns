package universitymanagement;

class Course {
    private String courseName;
    private String courseDept;
    private String courseID;
    private double courseCredit;
    
    public Course(String courseName, String courseDept, String courseID, double courseCredit) {
        this.courseName = courseName;
        this.courseDept = courseDept;
        this.courseID = courseID;
        this.courseCredit = courseCredit;
    }
    
    public String getCourseName() { return courseName; }
    public String getCourseDept() { return courseDept; }
    public String getCourseID() { return courseID; }
    public double getCourseCredit() { return courseCredit; }
}
