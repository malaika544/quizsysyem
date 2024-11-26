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

// Main class to launch the application
public class ZoomStyledApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> LoginFrame.getInstance().setVisible(true));
    }
}

// Singleton LoginFrame class
class LoginFrame extends JFrame {
    private static LoginFrame instance;

    // Private constructor to enforce Singleton
    private LoginFrame() {
        setTitle("Login");
        setSize(350, 400); // Adjusted size to fit content
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        // Set background color to light grey
        getContentPane().setBackground(Color.LIGHT_GRAY);
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gradient = new GradientPaint(0, 0, Color.LIGHT_GRAY, 0, getHeight(), new Color(192, 192, 192)); // Light grey gradient
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panel.setLayout(new GridBagLayout());
        setContentPane(panel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;

        // Add title
        JLabel titleLabel = new JLabel("Welcome to Quiz App");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(titleLabel, gbc);

        gbc.gridwidth = 1; // Reset grid width
        gbc.gridy++;

        // Create text fields using Factory pattern
        JTextField emailField = UIComponentFactory.createTextField();
        JPasswordField passwordField = UIComponentFactory.createPasswordField();

        // Add components
        add(new JLabel("Email:"), gbc);
        gbc.gridy++;
        add(emailField, gbc);
        gbc.gridy++;
        add(new JLabel("Password:"), gbc);
        gbc.gridy++;
        add(passwordField, gbc);

        // Create buttons and align them horizontally
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS)); // Align buttons vertically

        // Create horizontal button panel for "Login" and "Sign Up"
        JPanel horizontalButtonPanel = new JPanel();
        horizontalButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // FlowLayout for horizontal alignment
        JButton loginButton = UIComponentFactory.createButton("Login");
        JButton signupButton = UIComponentFactory.createButton("Sign Up");
        horizontalButtonPanel.add(loginButton);
        horizontalButtonPanel.add(signupButton);

        // Create the "Forgot Password" button
        JButton forgotPasswordButton = UIComponentFactory.createButton("Forgot Password");

        // Add horizontal panel first, followed by "Forgot Password"
        buttonPanel.add(horizontalButtonPanel);
        buttonPanel.add(forgotPasswordButton);

        gbc.gridy++;
        add(buttonPanel, gbc);

        // Action listeners
        loginButton.addActionListener(new LoginAction(emailField, passwordField));
        signupButton.addActionListener(e -> SignupFrame.getInstance().setVisible(true));
        forgotPasswordButton.addActionListener(e -> ForgotPasswordFrame.getInstance().setVisible(true));
    }

    // Singleton getInstance method
    public static LoginFrame getInstance() {
        if (instance == null) {
            instance = new LoginFrame();
        }
        return instance;
    }
}

// Singleton SignupFrame class
class SignupFrame extends JFrame {
    private static SignupFrame instance;

    // Private constructor to enforce Singleton
    private SignupFrame() {
        setTitle("Sign Up");
        setSize(350, 400); // Adjusted size to fit content
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        // Set background color to light grey
        getContentPane().setBackground(Color.LIGHT_GRAY);
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gradient = new GradientPaint(0, 0, Color.LIGHT_GRAY, 0, getHeight(), new Color(192, 192, 192)); // Light grey gradient
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panel.setLayout(new GridBagLayout());
        setContentPane(panel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;

        // Add title
        JLabel titleLabel = new JLabel("Create an Account");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(titleLabel, gbc);

        gbc.gridwidth = 1; // Reset grid width
        gbc.gridy++;

        // Create text fields and buttons using Factory pattern
        JTextField emailField = UIComponentFactory.createTextField();
        JPasswordField passwordField = UIComponentFactory.createPasswordField();
        JPasswordField confirmPasswordField = UIComponentFactory.createPasswordField();
        JButton signupButton = UIComponentFactory.createButton("Sign Up");

        // Add components
        add(new JLabel("Email:"), gbc);
        gbc.gridy++;
        add(emailField, gbc);
        gbc.gridy++;
        add(new JLabel("Password:"), gbc);
        gbc.gridy++;
        add(passwordField, gbc);
        gbc.gridy++;
        add(new JLabel("Confirm Password:"), gbc);
        gbc.gridy++;
        add(confirmPasswordField, gbc);
        gbc.gridy++;
        add(signupButton, gbc);

        signupButton.addActionListener(new SignupAction(emailField, passwordField, confirmPasswordField));
    }

    // Singleton getInstance method
    public static SignupFrame getInstance() {
        if (instance == null) {
            instance = new SignupFrame();
        }
        return instance;
    }
}

// ForgotPasswordFrame class with left alignment and vertical buttons
class ForgotPasswordFrame extends JFrame {
    private static ForgotPasswordFrame instance;

    // Private constructor to enforce Singleton
    private ForgotPasswordFrame() {
        setTitle("Forgot Password");
        setSize(350, 250); // Adjusted size
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        // Set background color to light grey
        getContentPane().setBackground(Color.LIGHT_GRAY);
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gradient = new GradientPaint(0, 0, Color.LIGHT_GRAY, 0, getHeight(), new Color(192, 192, 192)); // Light grey gradient
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panel.setLayout(new GridBagLayout());
        setContentPane(panel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST; // Align components to the left

        // Add title
        JLabel titleLabel = new JLabel("Forgot Password");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(titleLabel, gbc);

        gbc.gridwidth = 1; // Reset grid width
        gbc.gridy++;

        // Create text field for email input
        JTextField emailField = UIComponentFactory.createTextField();
        add(new JLabel("Enter your Email:"), gbc);
        gbc.gridy++;
        add(emailField, gbc);

        JButton resetButton = UIComponentFactory.createButton("Reset Password");
        gbc.gridy++;
        add(resetButton, gbc);

        // Add left-alignment for the "Forgot Password" button
        resetButton.setAlignmentX(Component.LEFT_ALIGNMENT);

        resetButton.addActionListener(e -> {
            String email = emailField.getText();
            JOptionPane.showMessageDialog(this, "Password reset instructions sent to: " + email);
        });
    }

    // Singleton getInstance method
    public static ForgotPasswordFrame getInstance() {
        if (instance == null) {
            instance = new ForgotPasswordFrame();
        }
        return instance;
    }
}

// ActionListener for Login Button
class LoginAction implements ActionListener {
    private final JTextField emailField;
    private final JPasswordField passwordField;

    public LoginAction(JTextField emailField, JPasswordField passwordField) {
        this.emailField = emailField;
        this.passwordField = passwordField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());

        // Dummy validation
        if ("test@example.com".equals(email) && "password123".equals(password)) {
            JOptionPane.showMessageDialog(null, "Login successful!");
        } else {
            JOptionPane.showMessageDialog(null, "Invalid credentials");
        }
    }
}

// ActionListener for Signup Button
class SignupAction implements ActionListener {
    private final JTextField emailField;
    private final JPasswordField passwordField;
    private final JPasswordField confirmPasswordField;

    public SignupAction(JTextField emailField, JPasswordField passwordField, JPasswordField confirmPasswordField) {
        this.emailField = emailField;
        this.passwordField = passwordField;
        this.confirmPasswordField = confirmPasswordField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());

        if (password.length() < 8) {
            JOptionPane.showMessageDialog(null, "Password must be at least 8 characters long.");
        } else if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(null, "Passwords do not match.");
        } else {
            JOptionPane.showMessageDialog(null, "Signup successful!");
        }
    }
}

// Factory Class to create common components
class UIComponentFactory {
    public static JTextField createTextField() {
        JTextField textField = new JTextField(20);
        textField.setBackground(Color.WHITE); // White background for text fields
        textField.setForeground(Color.BLACK); // Black text color
        return textField;
    }

    public static JPasswordField createPasswordField() {
        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setBackground(Color.WHITE); // White background for password fields
        passwordField.setForeground(Color.BLACK); // Black text color
        return passwordField;
    }

    public static JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(0, 123, 255)); // Blue color
        button.setForeground(Color.WHITE); // White text
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setPreferredSize(new Dimension(100, 40));
        return button;
    }
}

