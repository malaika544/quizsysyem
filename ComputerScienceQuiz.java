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

public class ComputerScienceQuiz {
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
            // True/False Questions
            "The first computer programmer was Ada Lovelace.",
            "The 'www' in a website address stands for 'World Wide Web'.",
            "The 'Linux' operating system was developed by Bill Gates.",
            "A byte consists of 16 bits.",
            "The 'father' of modern computer science is Alan Turing.",
            "The C programming language was developed by Dennis Ritchie.",
            "In binary, the number 100 represents the number 4.",
            "An algorithm is a step-by-step procedure for solving a problem.",
            "The primary function of the CPU is to store data.",
            "HTML stands for Hyper Text Markup Language.",

            // Open-ended Questions
            "What is the full form of CPU?",
            "Who developed the first high-level programming language?",
            "What is the main purpose of an operating system?",
            "What is the main difference between RAM and ROM?",
            "What does 'URL' stand for in the context of the internet?",
            "What is the primary function of an operating system?",
            "What does DNS stand for?",
            "Which language is used for web development in the frontend?",
            "What is the difference between HTTP and HTTPS?",
            "What is the purpose of a compiler?",

            // Multiple Choice Questions
            "Which of the following is not an operating system?",
            "Which language is primarily used for web development?",
            "What does 'GUI' stand for?",
            "Which of the following is an open-source operating system?",
            "What is the function of a database?",
            "Which of the following is a high-level programming language?",
            "Who invented the first mechanical computer?",
            "Which of these is not a type of computer network?",
            "What is the primary function of a computer's memory?",
            "Which is the fastest memory in a computer system?"
    };

    private String[] correctAnswers = {
            "true", "true", "false", "false", "true", "true", "false", "true", "false", "true",
            "Central Processing Unit", "John Backus", "To manage hardware and software resources", "RAM is volatile, ROM is non-volatile", "Uniform Resource Locator", 
            "To manage hardware resources and provide a user interface", "Domain Name System", "HTML/CSS/JavaScript", "HTTPS is secure, HTTP is not", "To translate high-level code to machine code",
            "Excel", "JavaScript", "Graphical User Interface", "Ubuntu", "To store and manage data", "Python", "Charles Babbage", "VPN", "To store data temporarily", "Cache"
    };

    private String[][] mcqOptions = {
            {"Windows", "Linux", "Excel", "MacOS"},
            {"JavaScript", "Python", "C#", "Ruby"},
            {"Graphical User Interface", "General User Interface", "Global User Interface", "Graphics User Interface"},
            {"Ubuntu", "Windows", "MacOS", "Android"},
            {"To store and manage data", "To execute programs", "To browse the internet", "To store files"},
            {"Java", "Python", "C++", "Assembly"},
            {"Charles Babbage", "Alan Turing", "Ada Lovelace", "Bill Gates"},
            {"LAN", "WAN", "VPN", "USB"},
            {"To store data", "To process data", "To execute programs", "To provide output"},
            {"RAM", "Cache", "Hard Drive", "CD-ROM"}
    };

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ComputerScienceQuiz().createAndShow();
            }
        });
    }

    // Creates and shows the GUI
    private void createAndShow() {
        frame = new JFrame("Computer Science Quiz");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);

        // Panel setup
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(216, 191, 216)); // light pink color

        // Title
        JLabel titleLabel = new JLabel("Computer Science Quiz", SwingConstants.CENTER);
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

