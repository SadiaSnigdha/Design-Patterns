package model;

import java.util.List;

public interface QuestionFactory {
    Question createQuestion(String text, List<String> options, String answer);
}
