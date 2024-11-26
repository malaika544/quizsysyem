/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author SHC
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PhysicsQuiz {
    private int score = 0;
    private JFrame frame;
    private JPanel panel;
    private JTextArea questionArea;
    private JButton nextButton;
    private JTextField answerField;
    private JLabel scoreLabel;

    private int currentQuestionIndex = 0;

    // Questions and answers
    private String[] questions = {
            "Newton's first law states that an object at rest will stay at rest unless acted upon by a force.",
            "The speed of light in a vacuum is approximately 3 × 10^8 m/s.",
            "Einstein's theory of relativity applies only to objects moving at low speeds.",
            "The gravitational force is proportional to the mass of the objects and inversely proportional to the square of the distance between them.",
            "Energy can be created and destroyed according to the law of conservation of energy."
    };
    
    private String[] correctAnswers = {
            "true", "true", "false", "true", "false"
    };

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PhysicsQuiz().createAndShow();
            }
        });
    }

    // Creates and shows the GUI
    private void createAndShow() {
        frame = new JFrame("Physics Quiz");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);

        // Panel setup
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(216, 191, 216)); // light pink color

        // Title
        JLabel titleLabel = new JLabel("Physics Quiz", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setForeground(Color.white);
        titleLabel.setBackground(new Color(128, 0, 128)); // purple color
        titleLabel.setOpaque(true);
        panel.add(titleLabel, BorderLayout.NORTH);

        // Main content panel for question and answer input
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridBagLayout());
        contentPanel.setBackground(new Color(216, 191, 216)); // light pink color
        GridBagConstraints gbc = new GridBagConstraints();

        // Question area
        questionArea = new JTextArea();
        questionArea.setText(questions[currentQuestionIndex]);
        questionArea.setFont(new Font("Arial", Font.PLAIN, 30));
        questionArea.setLineWrap(true);
        questionArea.setWrapStyleWord(true);
        questionArea.setEditable(false);
        questionArea.setBackground(null); // Remove background color
        questionArea.setPreferredSize(new Dimension(500, 80)); // Adjust size to fit well

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        contentPanel.add(questionArea, gbc);

        // Answer input field
        JLabel answerLabel = new JLabel("Enter your answer (true/false):");
        answerLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        answerField = new JTextField(10);
        JPanel answerPanel = new JPanel();
        answerPanel.setLayout(new FlowLayout());
        answerPanel.setBackground(new Color(216, 191, 216)); // light pink color
        answerPanel.add(answerLabel);
        answerPanel.add(answerField);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        contentPanel.add(answerPanel, gbc);

        panel.add(contentPanel, BorderLayout.CENTER);

        // Score label
        scoreLabel = new JLabel("Score: 0", SwingConstants.CENTER);
        scoreLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        scoreLabel.setForeground(Color.white);
        scoreLabel.setBackground(new Color(128, 0, 128)); // purple color
        scoreLabel.setOpaque(true);
        panel.add(scoreLabel, BorderLayout.WEST);

        // Next button
        nextButton = new JButton("Next Question");
        nextButton.setFont(new Font("Arial", Font.PLAIN, 16));
        nextButton.setBackground(new Color(128, 0, 128)); // purple color
        nextButton.setForeground(Color.white);
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer();
                currentQuestionIndex++;
                if (currentQuestionIndex < questions.length) {
                    loadNextQuestion();
                } else {
                    endQuiz();
                }
            }
        });
        panel.add(nextButton, BorderLayout.SOUTH);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    // Check the answer and update the score
    private void checkAnswer() {
        String userAnswer = answerField.getText().trim().toLowerCase();
        if (userAnswer.equals(correctAnswers[currentQuestionIndex])) {
            score++;
        }
        scoreLabel.setText("Score: " + score);
    }

    // Load the next question
    private void loadNextQuestion() {
        if (currentQuestionIndex < questions.length) {
            questionArea.setText(questions[currentQuestionIndex]);
            answerField.setText("");
        }
    }

    // End the quiz and show the final score
    private void endQuiz() {
        // Set the question area text to display final score
        questionArea.setText("Quiz Over!\nYour final score is: " + score + " out of " + questions.length);
        
        // Disable the answer input field and next button
        answerField.setEditable(false);
        nextButton.setEnabled(false);

        // Optionally, you could show a dialog with the final score
        JOptionPane.showMessageDialog(frame, "Quiz Over!\nYour final score is: " + score + " out of " + questions.length);
    }
}

