package observer;

// Implements Observer to display score updates
public class ScoreBoard implements Observer {
    private int score;

    @Override
    public void update(int score) {
        this.score = score;
        // Example: update scoreboard display
        System.out.println("Score updated: " + score);
    }

    public int getScore() {
        return score;
    }
}
