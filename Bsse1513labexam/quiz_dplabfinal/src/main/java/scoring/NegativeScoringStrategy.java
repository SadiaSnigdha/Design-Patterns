package scoring;

public class NegativeScoringStrategy implements ScoringStrategy {
    @Override
    public int calculateScore(String selectedAnswer, String correctAnswer) {
        return selectedAnswer.equalsIgnoreCase(correctAnswer) ? 10 : -2;
    }
}
