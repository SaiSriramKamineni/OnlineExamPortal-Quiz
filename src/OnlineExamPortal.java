import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

class Question {
    String question, option1, option2, option3, option4, answer;

    public Question(String question, String o1, String o2, String o3, String o4, String answer) {
        this.question = question;
        this.option1 = o1;
        this.option2 = o2;
        this.option3 = o3;
        this.option4 = o4;
        this.answer = answer;
    }
}

public class OnlineExamPortal extends JFrame implements ActionListener {
    ArrayList<Question> questions = new ArrayList<>();
    int index = 0, score = 0, timeLeft = 60; // 60 seconds
    JLabel questionLabel, timerLabel;
    JRadioButton[] options = new JRadioButton[4];
    ButtonGroup group = new ButtonGroup();
    JButton nextBtn, submitBtn;
    Timer timer; // Explicitly javax.swing.Timer

    public OnlineExamPortal() {
        setTitle("Online Exam Portal");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Timer
        timerLabel = new JLabel("Time left: 60", SwingConstants.RIGHT);
        timerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(timerLabel, BorderLayout.NORTH);

        // Question Panel
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(5, 1));
        questionLabel = new JLabel("Question", SwingConstants.LEFT);
        centerPanel.add(questionLabel);

        for (int i = 0; i < 4; i++) {
            options[i] = new JRadioButton();
            group.add(options[i]);
            centerPanel.add(options[i]);
        }

        add(centerPanel, BorderLayout.CENTER);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        nextBtn = new JButton("Next");
        submitBtn = new JButton("Submit");
        nextBtn.addActionListener(this);
        submitBtn.addActionListener(this);
        buttonPanel.add(nextBtn);
        buttonPanel.add(submitBtn);

        add(buttonPanel, BorderLayout.SOUTH);

        loadQuestionsFromDB();
        displayQuestion(index);

        timer = new javax.swing.Timer(1000, e -> updateTimer());
        timer.start();

        setVisible(true);
    }

    private void updateTimer() {
        timeLeft--;
        timerLabel.setText("Time left: " + timeLeft);
        if (timeLeft <= 0) {
            timer.stop();
            finishExam();
        }
    }

    private void loadQuestionsFromDB() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam", "root", "password");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM questions");
            while (rs.next()) {
                questions.add(new Question(
                        rs.getString("question"),
                        rs.getString("option1"),
                        rs.getString("option2"),
                        rs.getString("option3"),
                        rs.getString("option4"),
                        rs.getString("answer")
                ));
            }
            Collections.shuffle(questions);
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error connecting to database: " + e);
        }
    }

    private void displayQuestion(int idx) {
        if (idx >= questions.size()) {
            finishExam();
            return;
        }
        group.clearSelection();
        Question q = questions.get(idx);
        questionLabel.setText("Q" + (idx + 1) + ": " + q.question);
        options[0].setText(q.option1);
        options[1].setText(q.option2);
        options[2].setText(q.option3);
        options[3].setText(q.option4);
    }

    private String getSelectedOption() {
        for (JRadioButton btn : options) {
            if (btn.isSelected()) return btn.getText();
        }
        return "";
    }

    private void finishExam() {
        JOptionPane.showMessageDialog(this, "Your score is: " + score + "/" + questions.size());
        System.exit(0);
    }

    public void actionPerformed(ActionEvent e) {
        String selected = getSelectedOption();
        if (!selected.equals(questions.get(index).answer)) {
            // incorrect, no score increment
        } else {
            score++;
        }
        index++;
        if (e.getSource() == nextBtn) {
            displayQuestion(index);
        } else if (e.getSource() == submitBtn) {
            timer.stop();
            finishExam();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new OnlineExamPortal());
    }
}
