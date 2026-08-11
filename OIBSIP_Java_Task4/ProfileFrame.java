import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class ProfileFrame{
    private JFrame frame=new JFrame();
    private JPanel mainPanel=new JPanel();
    private JLabel profileLabel;
    private JLabel displayNameLabel;
    private JLabel passwordLabel;
    private JTextField displayNameTextField;
    private JPasswordField passwordTextField;
    private JButton updateButton;
    private JButton continueButton;
    private User user;
    GridBagConstraints gbc=new GridBagConstraints();
    
    public ProfileFrame(User user){
        this.user=user;
        frame.setTitle("Profile Update");
        frame.setSize(500,400);
        frame.setLocationRelativeTo(null);        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        mainPanel.setBackground(new Color(245,245,245));
        mainPanel.setLayout(new GridBagLayout());
        profileLabel = new JLabel("Update Your Profile");
        profileLabel.setHorizontalAlignment(SwingConstants.CENTER);
        profileLabel.setFont(new Font("Arial", Font.BOLD, 22));
        profileLabel.setForeground(new Color(25,118,210));
        displayNameLabel=new JLabel("Display Name");
        displayNameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        displayNameLabel.setForeground(new Color(60,60,60));
        displayNameTextField=new JTextField(20);
        displayNameTextField.setPreferredSize(new Dimension(200,30));
        displayNameTextField.setText(user.getDisplayName());
        passwordLabel=new JLabel("New Password");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        passwordLabel.setForeground(new Color(60,60,60));
        passwordTextField=new JPasswordField(20);
        passwordTextField.setPreferredSize(new Dimension(200,30));
        updateButton=new JButton("Update Profile");
        updateButton.setBackground(new Color(25,118,210));
        updateButton.setForeground(Color.WHITE);
        updateButton.setFont(new Font("Arial", Font.BOLD, 15));
        updateButton.setPreferredSize(new Dimension(120,35));
        
        continueButton=new JButton("Continue to Exam");
        continueButton.setBackground(new Color(25,118,210));
        continueButton.setForeground(Color.WHITE);
        continueButton.setFont(new Font("Arial", Font.BOLD, 15));
        continueButton.setPreferredSize(new Dimension(120,35));
               
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        // Title
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        mainPanel.add(profileLabel, gbc);

        // Display Name Label
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        mainPanel.add(displayNameLabel, gbc);

        // Display Name TextField
        gbc.gridx = 1;
        gbc.gridy = 1;
        mainPanel.add(displayNameTextField, gbc);

        // Password Label
        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(passwordLabel, gbc);

        // Password TextField
        gbc.gridx = 1;
        gbc.gridy = 2;
        mainPanel.add(passwordTextField, gbc);

        // Update Profile Button
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        mainPanel.add(updateButton, gbc);
        
        // Continue Button
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        mainPanel.add(continueButton, gbc);
        
        frame.add(mainPanel);
        
        updateButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String enteredDisplayName = displayNameTextField.getText().trim();
                String enteredPassword = new String(passwordTextField.getPassword());
                
                if (enteredDisplayName.isEmpty()) {
                    JOptionPane.showMessageDialog(
                        frame,
                        "Display Name cannot be empty.",
                        "Validation Error",
                        JOptionPane.ERROR_MESSAGE
                    );
                    displayNameTextField.requestFocus();
                    return;
}
               
                user.setDisplayName(enteredDisplayName);
                
                if (!enteredPassword.isEmpty()) {
                    user.setPassword(enteredPassword);
                }
                JOptionPane.showMessageDialog(
                        frame,
                        "Profile updated successfully!",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE
                    );
                passwordTextField.setText("");
            }
        });
        
        continueButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                new ExamFrame(user);
            }
        });
        
        frame.setVisible(true);
        continueButton.requestFocusInWindow();
    }
}
