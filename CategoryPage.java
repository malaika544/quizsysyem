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

public class CategoryPage extends JFrame {

    public  CategoryPage() {
        // Set title and size
        setTitle("Categories");
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
        JLabel headerLabel = new JLabel("Categories", JLabel.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 30));
        headerLabel.setForeground(Color.WHITE);
        mainPanel.add(headerLabel, BorderLayout.NORTH);

        // Button Panel for category selection
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 1, 20, 20));  // 5 buttons, spaced evenly
        buttonPanel.setOpaque(false);
        buttonPanel.setBackground(new Color(255, 255, 255, 100)); // Light semi-transparent background for the buttons

        // Quiz category options
        String[] quizCategories = {
            "General Knowledge", 
            "Physics", 
            "Computer Science", 
            "Chemistry", 
            "History"
        };
        
        // Create a button for each quiz category
        for (String category : quizCategories) {
            JButton categoryButton = new JButton(category);
            categoryButton.setFont(new Font("Arial", Font.BOLD, 20));  // Set font size for buttons
            categoryButton.setForeground(Color.BLACK);  // Button text color
            categoryButton.setBackground(new Color(240, 240, 255));  // Button background color (Light Blue)
            categoryButton.setFocusPainted(false);
            categoryButton.setPreferredSize(new Dimension(200, 60));  // Button size

            // ActionListener for button click
            categoryButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Display message for demonstration purposes
                    JOptionPane.showMessageDialog(null, category + " category selected!");
                }
            });

            buttonPanel.add(categoryButton);  // Add each button to the panel
        }

        // Add the button panel to the center of the main panel
        mainPanel.add(buttonPanel, BorderLayout.CENTER);  

        // Make window visible
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new  CategoryPage();  // Initialize the main quiz window
            }
        });
    }
}
