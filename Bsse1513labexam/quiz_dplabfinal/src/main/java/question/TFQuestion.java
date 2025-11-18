package question;

import java.util.Arrays;
import model.Question;

public class TFQuestion extends Question {
    public TFQuestion(String text, String answer) {
        super("TF", text, Arrays.asList("true", "false"), answer);
    }
}
