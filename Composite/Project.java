package Composite;

class Project implements CourseComponent {
    private int duration;

    public Project(int duration) {
        this.duration = duration;
    }

    public int computeDuration() {
        return duration;
    }
}