package model;

import java.util.List;

public class FillQuestionFactory implements QuestionFactory {
    @Override
    public Question createQuestion(String text, List<String> options, String answer) {
        return new question.FillQuestion(text, answer);
    }
}
