package OIBSIP_Java_Task1.gui;
import OIBSIP_Java_Task1.dao.UserDAO;
import OIBSIP_Java_Task1.model.User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class LoginFrame {
    private JFrame frame = new JFrame();
    private JPanel mainPanel = new JPanel();
    private JLabel titleLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField usernameTextField;
    private JPasswordField passwordTextField;
    private JButton loginButton;
    private GridBagConstraints gbc = new GridBagConstraints();
    public LoginFrame() {
        frame.setTitle("Online Reservation System - Login");
        frame.setSize(500, 350);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        // Main Panel
        mainPanel.setBackground(new Color(247, 244, 238));
        mainPanel.setLayout(new GridBagLayout());
        // Title
        titleLabel = new JLabel("Online Reservation System");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setForeground(new Color(48, 48, 48));
        // Username Label
        usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        usernameLabel.setForeground(new Color(55, 55, 55));
        usernameTextField = new JTextField(20);
        usernameTextField.setPreferredSize(new Dimension(200, 30));
        // Password Label
        passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        passwordLabel.setForeground(new Color(55, 55, 55));
        passwordTextField = new JPasswordField(20);
        passwordTextField.setPreferredSize(new Dimension(200, 30));
        // Login Button
        loginButton = new JButton("Login");
        loginButton.setBackground(new Color(39, 103, 73));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Arial", Font.BOLD, 15));
        loginButton.setPreferredSize(new Dimension(120, 35));
        loginButton.setFocusPainted(false);
        // GridBag settings
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        // Title
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        mainPanel.add(titleLabel, gbc);
        // Username Label
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        mainPanel.add(usernameLabel, gbc);
        // Username Field
        gbc.gridx = 1;
        gbc.gridy = 1;
        mainPanel.add(usernameTextField, gbc);
        // Password Label
        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(passwordLabel, gbc);
        // Password Field
        gbc.gridx = 1;
        gbc.gridy = 2;
        mainPanel.add(passwordTextField, gbc);
        // Login Button
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        mainPanel.add(loginButton, gbc);
        frame.add(mainPanel);
        // Press Enter in username field
        usernameTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                passwordTextField.requestFocusInWindow();
            }
        });
        // Press Enter in password field
        passwordTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginButton.doClick();
            }
        });
        // Login Button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredUserName=usernameTextField.getText().trim();
                String enteredPassword=new String(passwordTextField.getPassword());
                // Username validation
                if (enteredUserName.isEmpty()) {
                    JOptionPane.showMessageDialog(
                            frame,
                            "Username cannot be empty.",
                            "Validation Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                    usernameTextField.requestFocus();
                    return;
                }
                // Password validation
                if (enteredPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(
                            frame,
                            "Password cannot be empty.",
                            "Validation Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                    passwordTextField.requestFocus();
                    return;
                }
                // Create User object
                User user=new User(enteredUserName,enteredPassword);
                // Check credentials through database
                UserDAO userDAO = new UserDAO();
                if (userDAO.login(user)) {
                    JOptionPane.showMessageDialog(
                            frame,
                            "Login Successful!",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    new ReservationFrame(user);                   
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(
                            frame,
                            "Invalid Username or Password.",
                            "Login Failed",
                            JOptionPane.ERROR_MESSAGE
                    );
                    passwordTextField.setText("");
                    usernameTextField.setText("");
                    usernameTextField.requestFocus();
                }
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        LoginFrame start=new LoginFrame();
    }
}
