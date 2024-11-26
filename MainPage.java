import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage extends JFrame {

    public MainPage() {
        // Set title and size for MainPage
        setTitle("Main Page");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main Panel with Gradient Background
        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Color color1 = new Color(75, 0, 130); // Purple color
                Color color2 = new Color(255, 182, 193); // Light Pink color
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gradient = new GradientPaint(0, 0, color1, getWidth(), getHeight(), color2);
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        mainPanel.setLayout(new BorderLayout());
        getContentPane().add(mainPanel);

        // Header Label
        JLabel headerLabel = new JLabel("Welcome to the Quiz App", JLabel.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 30));
        headerLabel.setForeground(Color.WHITE);
        mainPanel.add(headerLabel, BorderLayout.NORTH);

        // Button Panel for navigation
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 1, 20, 20));  // 5 buttons, spaced evenly
        buttonPanel.setOpaque(false);

        // Buttons for navigation
        JButton loginButton = new JButton("Login");
        JButton signupButton = new JButton("Sign Up");
        JButton forgotPasswordButton = new JButton("Forgot Password");
        JButton categoriesButton = new JButton("Categories");
        JButton exitButton = new JButton("Exit");

        // Style Buttons
        loginButton.setFont(new Font("Arial", Font.BOLD, 20));
        signupButton.setFont(new Font("Arial", Font.BOLD, 20));
        forgotPasswordButton.setFont(new Font("Arial", Font.BOLD, 20));
        categoriesButton.setFont(new Font("Arial", Font.BOLD, 20));
        exitButton.setFont(new Font("Arial", Font.BOLD, 20));

        loginButton.setBackground(new Color(0, 123, 255)); // Blue color
        signupButton.setBackground(new Color(0, 123, 255)); // Blue color
        forgotPasswordButton.setBackground(new Color(0, 123, 255)); // Blue color
        categoriesButton.setBackground(new Color(0, 123, 255)); // Blue color
        exitButton.setBackground(new Color(0, 123, 255)); // Blue color

        loginButton.setForeground(Color.WHITE);
        signupButton.setForeground(Color.WHITE);
        forgotPasswordButton.setForeground(Color.WHITE);
        categoriesButton.setForeground(Color.WHITE);
        exitButton.setForeground(Color.WHITE);

        // Add buttons to the panel
        buttonPanel.add(loginButton);
        buttonPanel.add(signupButton);
        buttonPanel.add(forgotPasswordButton);
        buttonPanel.add(categoriesButton);
        buttonPanel.add(exitButton);

        // Add button panel to the center of the main panel
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        // Action Listeners for each button

        // Login Button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open Login Page
                LoginFrame.getInstance().setVisible(true);
                setVisible(false); // Hide MainPage when Login is clicked
            }
        });

        // Sign Up Button
        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open Sign Up Page
                SignupFrame.getInstance().setVisible(true);
                setVisible(false); // Hide MainPage when Sign Up is clicked
            }
        });

        // Forgot Password Button
        forgotPasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open Forgot Password Page
                ForgotPasswordFrame.getInstance().setVisible(true);
                setVisible(false); // Hide MainPage when Forgot Password is clicked
            }
        });

        // Categories Button
        categoriesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open Categories Page
                new CategoryPage();
                setVisible(false); // Hide MainPage when Categories is clicked
            }
        });

        // Exit Button
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Exit application
            }
        });
    }

    // Main method to launch the MainPage
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainPage().setVisible(true);  // Initialize and show MainPage
            }
        });
    }
}
