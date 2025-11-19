// Scenario:
// You have two inheritance hierarchies: one for `Employee` and another for `Contractor`. Each hierarchy has 
// its own specific classes for different roles (e.g., `Manager`, `Developer`, etc.). However, the hierarchies are 
// completely parallel, which causes duplication and makes the system harder to extend. 
// If you need to add a new common method to both `Employee` and `Contractor` classes, you'll need to modify both 
// hierarchies, leading to redundant changes and inconsistencies.
//
// Task for Students:
// Refactor the code by extracting common behavior between `Employee` and `Contractor` into a shared superclass, 
// or use interfaces to ensure that common functionality is shared between the two hierarchies. 
// Apply the **Consolidate Inheritance Hierarchies** refactoring technique.

public class Employee {
    private String name;
    private int salary;

    public void giveRaise(int raiseAmount) {
        salary += raiseAmount;
    }
}

public class Manager extends Employee {
    private int bonus;

    public void assignBonus(int bonusAmount) {
        bonus = bonusAmount;
    }
}

public class Contractor {
    private String name;
    private int hourlyRate;

    public void increaseHourlyRate(int increment) {
        hourlyRate += increment;
    }
}

public class ContractorManager extends Contractor {
    private int bonus;

    public void assignBonus(int bonusAmount) {
        bonus = bonusAmount;
    }
}
