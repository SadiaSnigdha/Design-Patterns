// Scenario:
// The `Employee` class is undergoing changes for two distinct reasons: salary adjustments and tax calculations. 
// However, both of these changes are handled in the same class, which violates the Single Responsibility Principle. 
// As a result, if you need to add more logic related to either salary adjustments or tax calculations, 
// you will be forced to modify the `Employee` class, increasing the risk of introducing errors and making the system 
// harder to maintain in the long term.
//
// Task for Students:
// Refactor the `Employee` class by moving salary-related logic to a `SalaryManager` class and tax-related logic 
// to a `TaxCalculator` class. This will ensure that each class has one reason to change. 
// Apply the **Extract Class** and **Move Method** refactoring techniques.


public class Employee {
    private String name;
    private int salary;
    private double taxRate;

    private SalaryManager salaryManager;
    private TaxCalculator taxCalculator;

    public Employee(String name, int salary, double taxRate) {
        this.name = name;
        this.salary = salary;
        this.taxRate = taxRate;
        this.salaryManager = new SalaryManager();
        this.taxCalculator = new TaxCalculator();
    }

    public void applyRaise(int raiseAmount) {
        salary = salaryManager.applyRaise(salary, raiseAmount);
    }

    public double calculateTax() {
        return taxCalculator.calculateTax(salary, taxRate);
    }

    public int getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }
}


public class SalaryManager {
    public int applyRaise(int currentSalary, int raiseAmount) {
        return currentSalary + raiseAmount;
    }
}

public class TaxCalculator {
    public double calculateTax(int salary, double taxRate) {
        return salary * taxRate;
    }
}
