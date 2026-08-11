import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class LoginFrame{
    private JFrame frame=new JFrame();
    private JPanel mainPanel=new JPanel();
    private JLabel titleLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField usernameTextField;
    private JPasswordField passwordTextField;
    private JButton loginButton;
    GridBagConstraints gbc=new GridBagConstraints();
    private User user=new User("mubashir", "2006", "Mubashir Hussain");
    public LoginFrame(){
        frame.setTitle("Online Examination System");
        frame.setSize(500,400);
        frame.setLocationRelativeTo(null);        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        mainPanel.setBackground(new Color(245,245,245));
        mainPanel.setLayout(new GridBagLayout());
        titleLabel=new JLabel("Online Examination System");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setForeground(new Color(25,118,210));
        usernameLabel=new JLabel("Username");
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        usernameLabel.setForeground(new Color(60,60,60));
        usernameTextField=new JTextField(20);
        usernameTextField.setPreferredSize(new Dimension(200,30));
        passwordLabel=new JLabel("Password");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        passwordLabel.setForeground(new Color(60,60,60));
        passwordTextField=new JPasswordField(20);
        passwordTextField.setPreferredSize(new Dimension(200,30));
        loginButton=new JButton("Login");
        loginButton.setBackground(new Color(25,118,210));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Arial", Font.BOLD, 15));
        loginButton.setPreferredSize(new Dimension(120,35));
        
        
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

        // Username Text Field
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
        
        usernameTextField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                passwordTextField.requestFocusInWindow();
            }
        });
        passwordTextField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loginButton.doClick();
            }
        });
        loginButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String enteredUserName = usernameTextField.getText().trim();
                String enteredPassword = new String(passwordTextField.getPassword());
                
                if (enteredUserName.isEmpty()){
                    JOptionPane.showMessageDialog(frame,
                        "Username cannot be empty.",
                        "Validation Error",
                        JOptionPane.ERROR_MESSAGE
                    );
                    usernameTextField.requestFocus();
                    return;
                }

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

                if(enteredUserName.equals(user.getUserName())&&enteredPassword.equals(user.getPassword())){
                    JOptionPane.showMessageDialog(
                        frame,
                        "Login Successful!",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE
                    );
                    frame.dispose();
                    new ProfileFrame(user);
                }else{
                    JOptionPane.showMessageDialog(
                        frame,
                        "Invalid Username or Password",
                        "Login Failed",
                        JOptionPane.ERROR_MESSAGE
                    );
                    usernameTextField.setText("");
                    passwordTextField.setText("");
                    usernameTextField.requestFocus();
                }
                
            }
        });
        
        frame.setVisible(true);
        
    } 
}
