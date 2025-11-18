package question;

import java.util.Collections;
import java.util.List;
import model.Question;

public class FillQuestion extends Question {
    public FillQuestion(String text, String answer) {
        super("FILL", text, Collections.emptyList(), answer);
    }
}
