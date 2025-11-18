package exam;

import observer.Observer;
import observer.Subject;
import java.util.ArrayList;
import java.util.List;
import model.Quiz;

// Central exam manager using Singleton and Observer patterns
public class ExamManager implements Subject {
    private static ExamManager instance;
    private List<Quiz> quizzes = new ArrayList<>();
    private int currentQuizIndex = 0;
    private int currentQuestionIndex = 0;
    private int score = 0;
    private List<Observer> observers = new ArrayList<>();

    private ExamManager() {}

    public static ExamManager getInstance() {
        if (instance == null) {
            instance = new ExamManager();
        }
        return instance;
    }

    // Methods to manage quizzes
    public void addQuiz(Quiz quiz) {
        quizzes.add(quiz);
    }

    public Quiz getCurrentQuiz() {
        if (quizzes.isEmpty()) return null;
        return quizzes.get(currentQuizIndex);
    }

    public void nextQuestion() {
        currentQuestionIndex++;
    }

    public int getCurrentQuestionIndex() {
        return currentQuestionIndex;
    }

    // Score management
    public void setScore(int score) {
        this.score = score;
        notifyObservers();
    }

    public int getScore() {
        return score;
    }

    // Observer methods
    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(score);
        }
    }
}
