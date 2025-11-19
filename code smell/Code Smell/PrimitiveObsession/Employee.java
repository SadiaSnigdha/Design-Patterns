// Scenario:
    // The Employee class uses primitive types like int and String for complex concepts 
    // like salary and hire date. The salary is just an int representing cents, 
    // and the hire date is a simple string. Over time, as new features are added 
    // (like currency conversion or date-based queries), this will cause confusion 
    // and errors. Additionally, it makes the system difficult to extend or 
    // maintain, as logic related to salary or date could be scattered all over the application.

// Task for Students:
    // Refactor the Employee class by introducing proper value objects, like a Money class for salary and a Date class for hire date.

    // Apply the Replace Primitive with Object refactoring technique.


public class Employee {
    private String name;
    private int salary;
    private int hireYear;
    private int hireMonth;
    private int hireDay;
    
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}