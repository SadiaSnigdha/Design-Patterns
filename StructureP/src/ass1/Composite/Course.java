package Composite;

import java.util.ArrayList;
import java.util.List;

class Course implements CourseComponent {
    private List<CourseComponent> components = new ArrayList<>();

    public void addComponent(CourseComponent component) {
        components.add(component);
    }

    public int computeDuration() {
        int total = 0;
        for (CourseComponent comp : components) {
            total += comp.computeDuration();
        }
        return total;
    }
}