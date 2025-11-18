package Composite;

public class Main {
    public static void main(String[] args) {

        Course mainCourse = new Course();
        mainCourse.addComponent(new Lesson(10));
        mainCourse.addComponent(new Quiz(5));
        mainCourse.addComponent(new Project(20));

        Course subCourse = new Course();
        subCourse.addComponent(new Lesson(8));
        subCourse.addComponent(new Quiz(3));

        mainCourse.addComponent(subCourse);

        System.out.println("Total Course Duration: " + mainCourse.computeDuration() + " hours");
    }
}
