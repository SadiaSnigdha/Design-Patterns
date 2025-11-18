package universitymanagement;

import java.util.*;

class StudentService {
    private Map<String, Student> students = new HashMap<>();
    private Logger logger = new Logger();
    
    public void addStudent(String firstName, String lastName, String email, 
                          String major, int age, String phoneNumber, String emergencyContact) {
        Student student = new Student(firstName, lastName, email, major, phoneNumber, emergencyContact, age);
        students.put(email, student);
        logger.log("Student added: " + email);
    }
    
    public Student getStudent(String email) {
        return students.get(email);
    }
    
    public List<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }
    
    public void updateAttendance(String email) {
        Student student = students.get(email);
        if (student != null) {
            student.incrementAttendance();
        }
    }
    
    public void makeTuitionPayment(String email, double amount) {
        Student student = students.get(email);
        if (student != null) {
            student.makeTuitionPayment(amount);
        }
    }
}

