package Composite;

class Lesson implements CourseComponent {
    private int duration;

    public Lesson(int duration) {
        this.duration = duration;
    }

    public int computeDuration() {
        return duration;
    }
}