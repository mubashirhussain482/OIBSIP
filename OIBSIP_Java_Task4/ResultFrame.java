import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class ResultFrame{
    private JFrame frame = new JFrame();
    private JPanel mainPanel = new JPanel();
    private JLabel titleLabel;
    private JLabel resultLabel;
    private JLabel nameLabel;
    private JLabel scoreLabel;   
    private JLabel percentageLabel;
    private JLabel statusLabel;
    private JLabel correctLabel;
    private JLabel incorrectLabel;
    private JLabel timeLabel;
    private JButton exitButton;
    private GridBagConstraints gbc = new GridBagConstraints();
    private User user;
    private int score;
    private int totalQuestions;
    private int timeTaken;
  
    public ResultFrame(User user, int score, int totalQuestions,int timeTaken){
        this.user=user;
        this.score=score;
        this.totalQuestions=totalQuestions;
        this.timeTaken=timeTaken;
        int minutes = timeTaken / 60;
        int seconds = timeTaken % 60;
        frame.setTitle("Exam Result");
        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        mainPanel.setBackground(new Color(245,245,245));
        mainPanel.setLayout(new GridBagLayout());
        titleLabel = new JLabel("Online Examination System");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setForeground(new Color(25,118,210));
        resultLabel = new JLabel("Exam Completed");               
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 18));
        nameLabel = new JLabel("Candidate: " + user.getDisplayName());
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        scoreLabel = new JLabel("Score: " + score + " / "+totalQuestions);
        scoreLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        correctLabel=new JLabel("Correct Answers: "+score);
        correctLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        incorrectLabel=new JLabel("Incorrect Answers: "+(totalQuestions-score));
        incorrectLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        timeLabel = new JLabel(String.format("Time Taken: %02d:%02d", minutes, seconds));
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        double percentage = (score * 100.0)/totalQuestions;
        percentageLabel = new JLabel(String.format("Percentage: %.2f%%",percentage));
        percentageLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        if(percentage>=50){
            statusLabel=new JLabel("Status: Pass");
            statusLabel.setForeground(new Color(0,128,0));
        }
        else{
            statusLabel=new JLabel("Status: Fail");
            statusLabel.setForeground(Color.RED);
        }
        statusLabel.setFont(new Font("Arial", Font.BOLD, 16));       
        exitButton = new JButton("Exit");
        exitButton.setBackground(new Color(25,118,210));
        exitButton.setForeground(Color.WHITE);
        exitButton.setFont(new Font("Arial", Font.BOLD, 15));
        exitButton.setPreferredSize(new Dimension(120,35));
        
        gbc.insets = new Insets(10,10,10,10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Title
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(titleLabel, gbc);

        // Result
        gbc.gridy = 1;
        mainPanel.add(resultLabel, gbc);

        // Candidate Name
        gbc.gridy = 2;
        mainPanel.add(nameLabel, gbc);

        // Score
        gbc.gridy = 3;
        mainPanel.add(scoreLabel, gbc);
        
         // Correct
        gbc.gridy = 4;
        mainPanel.add(correctLabel, gbc);
        
         // Score
        gbc.gridy = 5;
        mainPanel.add(incorrectLabel, gbc);
        
        
         // Time Taken
        gbc.gridy = 6;
        mainPanel.add(timeLabel, gbc);

        // Percentage
        gbc.gridy = 7;
        mainPanel.add(percentageLabel, gbc);

        // Status
        gbc.gridy = 8;
        mainPanel.add(statusLabel, gbc);

        // Exit Button
        gbc.gridy = 9;
        mainPanel.add(exitButton, gbc);
        
        frame.add(mainPanel);
        
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        frame.setVisible(true); 
    }   
}
