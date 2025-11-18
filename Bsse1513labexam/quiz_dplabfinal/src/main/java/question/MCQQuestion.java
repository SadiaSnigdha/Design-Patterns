package question;

import java.util.List;
import model.Question;

public class MCQQuestion extends Question {
    public MCQQuestion(String text, List<String> options, String answer) {
        super("MCQ", text, options, answer);
    }
}
