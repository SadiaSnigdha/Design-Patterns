// Scenario:
// Java's `LocalDate` class doesn't have a method to calculate age directly from a birth date. 
// Since we can’t modify the library class, the logic ends up scattered throughout the code.
//
// Task for Students:
// Create a utility/helper class with a well-named method to encapsulate the missing functionality.
// Apply **Introduce Foreign Method** or **Introduce Extension Method** (in languages that support it).


import java.time.LocalDate;
import java.time.Period;

public class DateUtils {

    public static int calculateAge(LocalDate birthDate) {
        if (birthDate == null) {
            throw new IllegalArgumentException("Birth date cannot be null");
        }
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
}

public class Employee {
    private LocalDate birthDate;

    public Employee(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge() {
        return DateUtils.calculateAge(birthDate);
    }
}
