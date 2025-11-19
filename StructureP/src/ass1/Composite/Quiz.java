package Composite;

class Quiz implements CourseComponent {
    private int duration;

    public Quiz(int duration) {
        this.duration = duration;
    }

    public int computeDuration() {
        return duration;
    }
}