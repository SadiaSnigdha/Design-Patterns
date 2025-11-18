package model;

import java.util.List;

abstract public class Question {
    private String type; // MCQ, TF, FILL
    private String text;
    private List<String> options;
    private String answer;

    public Question(String type, String text, List<String> options, String answer) {
        this.type = type;
        this.text = text;
        this.options = options;
        this.answer = answer;
    }

    public String getType() { return type; }
    public String getText() { return text; }
    public List<String> getOptions() { return options; }
    public String getAnswer() { return answer; }

    // done: Students can add methods to support Factory or Prototype if needed
}

