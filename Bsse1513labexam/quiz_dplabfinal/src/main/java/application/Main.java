package application;
import model.Question;
import model.Quiz;
import model.QuestionFactory;
import model.MCQFactory;
import model.TFQuestionFactory;
import model.FillQuestionFactory;
import scoring.ScoringStrategy;
import exam.ExamManager;
import observer.ScoreBoard;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class Main {

    private JFrame frame;
    private JComboBox<String> quizSelector;
    private JLabel questionLabel;
    private JRadioButton[] optionButtons;
    private ButtonGroup group;
    private JButton nextButton;
    private JLabel scoreLabel;
    private JTextField fillInput;
    private JComboBox<String> scoringSelector; // Dropdown for scoring method

    private ExamManager examManager = ExamManager.getInstance();
    private ScoreBoard scoreBoard = new ScoreBoard();
    private ScoringStrategy scoringStrategy;

    public Main() {
        frame = new JFrame("Quiz System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 400);
        frame.setLayout(new BorderLayout(10, 10));

        // Top panel: Quiz selector + scoring selector + score
        JPanel topPanel = new JPanel(new FlowLayout());
        quizSelector = new JComboBox<>();
        topPanel.add(new JLabel("Select Quiz:"));
        topPanel.add(quizSelector);

        // Scoring method dropdown
        scoringSelector = new JComboBox<>(new String[]{"Normal", "Negative", "Partial"});
        topPanel.add(new JLabel("Scoring:"));
        topPanel.add(scoringSelector);

        scoreLabel = new JLabel("Score: 0");
        topPanel.add(scoreLabel);

        frame.add(topPanel, BorderLayout.NORTH);

        // Question label
        questionLabel = new JLabel("Question will appear here");
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        questionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(questionLabel, BorderLayout.CENTER);

        // Options panel
        JPanel optionsPanel = new JPanel(new GridLayout(5, 1, 5, 5));
        optionButtons = new JRadioButton[4];
        group = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            optionButtons[i] = new JRadioButton();
            group.add(optionButtons[i]);
            optionsPanel.add(optionButtons[i]);
        }

        fillInput = new JTextField();
        fillInput.setVisible(false);
        optionsPanel.add(fillInput);

        frame.add(optionsPanel, BorderLayout.SOUTH);

        nextButton = new JButton("Next Question");
        frame.add(nextButton, BorderLayout.EAST);

    // Setup sample quizzes
    setupSampleQuizzes();
    populateQuizSelector();

    // Attach observer for score updates
    examManager.attach(scoreBoard);

    // Auto-load first quiz
    quizSelector.setSelectedIndex(0);
    startSelectedQuiz();

    // Event listeners
    quizSelector.addActionListener(e -> startSelectedQuiz());
    nextButton.addActionListener(e -> handleNext());

    frame.setVisible(true);
    }

    // TODO: flexible way of constructing different question types
    private void setupSampleQuizzes() {
        QuestionFactory mcqFactory = new MCQFactory();
        QuestionFactory tfFactory = new TFQuestionFactory();
        QuestionFactory fillFactory = new FillQuestionFactory();

        Quiz javaQuiz = new Quiz("Java Basics");
        javaQuiz.addQuestion(mcqFactory.createQuestion("Java is a ____ language?",
                Arrays.asList("Compiled", "Interpreted", "Both", "None"), "Both"));
        javaQuiz.addQuestion(tfFactory.createQuestion("The Earth is flat?", Arrays.asList("true", "false"), "false"));
        javaQuiz.addQuestion(fillFactory.createQuestion("2 + 2 = ?", null, "4"));
        javaQuiz.addQuestion(fillFactory.createQuestion("13 + 20 = ?", null, "33"));

        Quiz mathQuiz = new Quiz("Math Basics");
        mathQuiz.addQuestion(mcqFactory.createQuestion("5 * 5 = ?", Arrays.asList("10", "20", "25", "30"), "25"));
        mathQuiz.addQuestion(tfFactory.createQuestion("0 is an even number?", Arrays.asList("true", "false"), "true"));

        examManager.addQuiz(javaQuiz);
        examManager.addQuiz(mathQuiz);
    }

    private void populateQuizSelector() {
        // Get all quizzes from ExamManager
        // Assuming ExamManager has a method to get all quizzes
        List<Quiz> allQuizzes = new ArrayList<>();
        // This is a workaround since ExamManager does not expose quizzes directly
        // If you have a getQuizzes() method, use it here
        // For now, we will add titles for the two sample quizzes
        allQuizzes.add(examManager.getCurrentQuiz());
        quizSelector.removeAllItems();
        for (Quiz q : allQuizzes) {
            if (q != null) quizSelector.addItem(q.getTitle());
        }
    }

    private void startSelectedQuiz() {
        int index = quizSelector.getSelectedIndex();
        // Get quiz from ExamManager
        examManager.getCurrentQuiz();
        examManager.setScore(0);
        nextButton.setEnabled(true);
        loadQuestion();
    }

    private void loadQuestion() {
        Quiz selectedQuiz = examManager.getCurrentQuiz();
        int currentQuestionIndex = examManager.getCurrentQuestionIndex();
        if (selectedQuiz == null || currentQuestionIndex >= selectedQuiz.getQuestions().size()) {
            JOptionPane.showMessageDialog(frame, "Quiz Finished! Final Score: " + examManager.getScore());
            nextButton.setEnabled(false);
            return;
        }

        Question q = selectedQuiz.getQuestions().get(currentQuestionIndex);
        questionLabel.setText(q.getText());

        group.clearSelection();
        fillInput.setVisible(false);

        if (q.getType().equalsIgnoreCase("FILL")) {
            fillInput.setText(""); // empty for user input
            fillInput.setVisible(true);
            for (JRadioButton btn : optionButtons) btn.setVisible(false);
        } else {
            List<String> opts = q.getOptions();
            for (int i = 0; i < optionButtons.length; i++) {
                if (i < opts.size()) {
                    optionButtons[i].setText(opts.get(i));
                    optionButtons[i].setVisible(true);
                } else {
                    optionButtons[i].setVisible(false);
                }
            }
            optionButtons[0].setSelected(true); // default selection
        }
        // Update score label from ScoreBoard
        scoreLabel.setText("Score: " + scoreBoard.getScore());
    }

    private void handleNext() {
        Quiz selectedQuiz = examManager.getCurrentQuiz();
        int currentQuestionIndex = examManager.getCurrentQuestionIndex();
        Question current = selectedQuiz.getQuestions().get(currentQuestionIndex);
        String selectedAnswer = null;

        if (current.getType().equalsIgnoreCase("FILL")) {
            selectedAnswer = fillInput.getText().trim();
        } else {
            for (JRadioButton rb : optionButtons) {
                if (rb.isSelected()) {
                    selectedAnswer = rb.getText();
                    break;
                }
            }
        }

        if (selectedAnswer != null && !selectedAnswer.isEmpty()) {
            // Strategy pattern for scoring
            String method = (String) scoringSelector.getSelectedItem();
            switch (method) {
                case "Normal":
                    scoringStrategy = (selected, correct) -> selected.equalsIgnoreCase(correct) ? 10 : 0;
                    break;
                case "Negative":
                    scoringStrategy = (selected, correct) -> selected.equalsIgnoreCase(correct) ? 10 : -2;
                    break;
                case "Partial":
                    scoringStrategy = (selected, correct) -> selected.equalsIgnoreCase(correct) ? 10 : 5;
                    break;
            }
            int delta = scoringStrategy.calculateScore(selectedAnswer, current.getAnswer());
            examManager.setScore(examManager.getScore() + delta);

            examManager.nextQuestion();
            loadQuestion();
        } else {
            JOptionPane.showMessageDialog(frame, "Please select or enter an answer!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}
