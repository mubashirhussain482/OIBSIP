import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
class ExamFrame{
    private JFrame frame=new JFrame();
    private JPanel mainPanel=new JPanel();
    private JLabel titleLabel;
    private JLabel timerLabel;
    private JLabel questionLabel;
    private JRadioButton option1;
    private JRadioButton option2;
    private JRadioButton option3;
    private JRadioButton option4;
    private ButtonGroup buttonGroup;
    private JButton previousButton;
    private JButton nextButton;
    private JButton submitButton;
    private GridBagConstraints gbc=new GridBagConstraints();
    private User user;
    private ArrayList<Question> questions=new ArrayList<>();
    private int currentQuestionIndex=0;
    private Timer timer;
    private int totalTime=600;
    private int timeRemaining=600;
    
    private void loadQuestion(){
        Question currentQuestion = questions.get(currentQuestionIndex);
        questionLabel.setText("Question "+(currentQuestionIndex+1)+": "+currentQuestion.getQuestionText());
        String[] options = currentQuestion.getOptions();
        option1.setText(options[0]);
        option2.setText(options[1]);
        option3.setText(options[2]);
        option4.setText(options[3]);
        buttonGroup.clearSelection();
        int selectedAnswer=currentQuestion.getSelectedAnswer();
        if(selectedAnswer==0){
            option1.setSelected(true);
        }
        else if(selectedAnswer==1){
            option2.setSelected(true);
        }
        else if(selectedAnswer==2){
            option3.setSelected(true);
        }
        else if(selectedAnswer==3){
            option4.setSelected(true);
        }
        previousButton.setEnabled(currentQuestionIndex!=0);
        nextButton.setEnabled(currentQuestionIndex!=questions.size()-1);
    }
    private void saveAnswer(){
        Question currentQuestion = questions.get(currentQuestionIndex);
        if(option1.isSelected()){
            currentQuestion.setSelectedAnswer(0);
        }
        else if(option2.isSelected()){
            currentQuestion.setSelectedAnswer(1);
        }
        else if(option3.isSelected()){
            currentQuestion.setSelectedAnswer(2);
        }
        else if(option4.isSelected()){
            currentQuestion.setSelectedAnswer(3);
        }
        else{
            currentQuestion.setSelectedAnswer(-1);
        }    
    }
    private int calculateScore() {
        int score=0;
        for (Question currentQuestion:questions){
            if(currentQuestion.isCorrect()){
                score++;
            }
        }
        return score;
    }
    private void startTimer() {
        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timeRemaining--;
                int minutes = timeRemaining / 60;
                int seconds = timeRemaining % 60;
                timerLabel.setText(
                    String.format("Time Remaining: %02d:%02d", minutes, seconds)
                );
                if(timeRemaining == 0){
                    timer.stop();
                    saveAnswer();    
                    int score = calculateScore();
                    JOptionPane.showMessageDialog(
                        frame,
                        "Time is over!\nYour Score: " + score + " / " + questions.size(),
                        "Exam Finished",
                        JOptionPane.INFORMATION_MESSAGE
                    );
                }
            }
        });
        timer.start();
    }
    private int getTimeTaken(){
        return totalTime-timeRemaining;
    }
    public ExamFrame(User user){
        this.user=user;
        frame.setTitle("Online Examination System");
        frame.setSize(700,500);
        frame.setLocationRelativeTo(null);        
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setResizable(false);
        mainPanel.setBackground(new Color(245,245,245));
        mainPanel.setLayout(new GridBagLayout());
        
        titleLabel=new JLabel("Online Examination System");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setForeground(new Color(25,118,210));
        
        timerLabel=new JLabel("Time Remaining: 01:00");
        timerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        timerLabel.setForeground(Color.RED);
        questionLabel=new JLabel("Question will appear here.");
        questionLabel.setHorizontalAlignment(SwingConstants.LEFT);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        questionLabel.setForeground(new Color(60,60,60));
        
        option1=new JRadioButton("Option 1");    
        option1.setBackground(new Color(245,245,245));
        option1.setFont(new Font("Arial", Font.PLAIN, 15));
        
        option2=new JRadioButton("Option 2");       
        option2.setBackground(new Color(245,245,245));
        option2.setFont(new Font("Arial", Font.PLAIN, 15));
        
        option3=new JRadioButton("Option 3");       
        option3.setBackground(new Color(245,245,245));
        option3.setFont(new Font("Arial", Font.PLAIN, 15));
        
        option4=new JRadioButton("Option 4");
        option4.setBackground(new Color(245,245,245));
        option4.setFont(new Font("Arial", Font.PLAIN, 15));        
        buttonGroup=new ButtonGroup();
        buttonGroup.add(option1);
        buttonGroup.add(option2);
        buttonGroup.add(option3);
        buttonGroup.add(option4);
        
        previousButton=new JButton("Previous");
        previousButton.setBackground(new Color(25,118,210));
        previousButton.setForeground(Color.WHITE);
        previousButton.setFont(new Font("Arial", Font.BOLD, 15));
        previousButton.setPreferredSize(new Dimension(120,35));

        nextButton=new JButton("Next");
        nextButton.setBackground(new Color(25,118,210));
        nextButton.setForeground(Color.WHITE);
        nextButton.setFont(new Font("Arial", Font.BOLD, 15));
        nextButton.setPreferredSize(new Dimension(120,35));

        submitButton=new JButton("Submit");
        submitButton.setBackground(new Color(25,118,210));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFont(new Font("Arial", Font.BOLD, 15));
        submitButton.setPreferredSize(new Dimension(120,35));
        
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        // Title
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        mainPanel.add(titleLabel, gbc);

        // Timer Label
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        mainPanel.add(timerLabel, gbc);

        // Question
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        mainPanel.add(questionLabel, gbc);

        // Option1
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        mainPanel.add(option1, gbc);

        // Option2
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        mainPanel.add(option2, gbc);

        // Option3
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 3;
        mainPanel.add(option3, gbc);
        
        // Option4
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 3;
        mainPanel.add(option4, gbc);
        
        // Previous Button
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        mainPanel.add(previousButton, gbc);
        
        // Next Button
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        mainPanel.add(nextButton, gbc);
        
        // Submit Button
        gbc.gridx = 2;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        mainPanel.add(submitButton, gbc);
        
        questions.add(new Question("What is the capital of Pakistan?",
        new String[]{"Islamabad","Lahore","Karachi","Peshawar"},0));
        
        questions.add(new Question("Which planet is known as the Red Planet?",
        new String[]{"Earth", "Mars", "Jupiter", "Venus"}, 1));

        questions.add(new Question("What is the primary function of the CPU?",
        new String[]{"Store data permanently", "Execute instructions", "Display graphics", "Provide internet access"}, 1));

        questions.add(new Question("Which language is primarily used for Android app development?",
        new String[]{"Swift", "Kotlin", "C#", "PHP"}, 1));

        questions.add(new Question("How many continents are there on Earth?",
        new String[]{"5", "6", "7", "8"}, 2));

        questions.add(new Question("What is the chemical symbol for Water?",
        new String[]{"CO2", "O2", "H2O", "NaCl"}, 2));

        questions.add(new Question("Which data structure uses LIFO (Last In First Out)?",
        new String[]{"Queue", "Stack", "Array", "Linked List"}, 1));

        questions.add(new Question("Who wrote the play 'Romeo and Juliet'?",
        new String[]{"William Shakespeare", "Charles Dickens", "Mark Twain", "Jane Austen"}, 0));

        questions.add(new Question("Which protocol is used to securely transfer web pages?",
        new String[]{"HTTP", "HTTPS", "FTP", "SMTP"}, 1));

        questions.add(new Question("What is the largest ocean on Earth?",
        new String[]{"Atlantic Ocean", "Indian Ocean", "Arctic Ocean", "Pacific Ocean"}, 3));
        
        loadQuestion();
        startTimer();
        
        frame.add(mainPanel);
        
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveAnswer();
                if(currentQuestionIndex < questions.size() - 1){
                    currentQuestionIndex++;
                    loadQuestion();
                }
            }
        });
        
        previousButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {  
                saveAnswer();
                if(currentQuestionIndex!=0){
                    currentQuestionIndex--;
                    loadQuestion();
                }
            }
        });
        
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int choice=JOptionPane.showConfirmDialog(
                        frame,
                        "Are you sure you want to submit the exam?",
                        "Confirm Submission",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );
                if(choice==JOptionPane.YES_OPTION){
                    timer.stop();
                    saveAnswer();
                    int score = calculateScore();
                    frame.dispose();
                    new ResultFrame(user,score,questions.size(),getTimeTaken());
                }

            }
        });
        
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int choice = JOptionPane.showConfirmDialog(
                        frame,
                        "Do you want to submit the exam and exit?",
                        "Confirm Exit",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (choice == JOptionPane.YES_OPTION) {
                    saveAnswer();
                    int score = calculateScore();
                    frame.dispose();
                    new ResultFrame(user, score, questions.size(),getTimeTaken());
                }
            }
        });
        
        frame.setVisible(true);
    }  
}
