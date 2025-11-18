package model;

import java.util.List;

public class TFQuestionFactory implements QuestionFactory {
    @Override
    public Question createQuestion(String text, List<String> options, String answer) {
        return new question.TFQuestion(text, answer);
    }
}
