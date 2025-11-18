package universitymanagement;

class Enrollment {
	private Student student;
    private Course course;
    private Integer grade;
    
    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
        this.grade = null;
    }
    
    public Student getStudent() { return student; }
    public Course getCourse() { return course; }
    public Integer getGrade() { return grade; }
    public void setGrade(Integer grade) { this.grade = grade; }
}
