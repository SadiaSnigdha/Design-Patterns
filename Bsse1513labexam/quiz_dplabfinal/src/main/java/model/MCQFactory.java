package model;

import java.util.List;

public class MCQFactory implements QuestionFactory {
    @Override
    public Question createQuestion(String text, List<String> options, String answer) {
        return new MCQ(text, options, answer);
    }
}
