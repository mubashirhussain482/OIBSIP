package OIBSIP_Java_Task1.gui;
import OIBSIP_Java_Task1.dao.ReservationDAO;
import OIBSIP_Java_Task1.model.Reservation;
import OIBSIP_Java_Task1.model.User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class ReservationFrame {
    private JFrame frame=new JFrame();
    private JPanel mainPanel=new JPanel();
    private JLabel titleLabel;
    private JLabel passengerNameLabel;
    private JLabel trainNoLabel;
    private JLabel trainNameLabel;
    private JLabel classTypeLabel;
    private JLabel journeyDateLabel;
    private JLabel sourceLabel;
    private JLabel destinationLabel;
    private JTextField passengerNameTextField;
    private JTextField trainNoTextField;
    private JTextField trainNameTextField;
    private JComboBox<String> classTypeComboBox;
    private JTextField journeyDateTextField;
    private JTextField sourceTextField;
    private JTextField destinationTextField;
    private JButton bookButton;
    private JButton cancelButton;
    private JButton logoutButton;
    private GridBagConstraints gbc = new GridBagConstraints();
    private User user;

    public ReservationFrame(User user) {
        this.user = user;
        frame.setTitle("Online Reservation System - Reservation");
        frame.setSize(650, 550);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        mainPanel.setBackground(new Color(247, 244, 238));
        mainPanel.setLayout(new GridBagLayout());
        // Title
        titleLabel = new JLabel("Train Reservation");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(48, 48, 48));
        // Passenger Name
        passengerNameLabel = new JLabel("Passenger Name:");
        passengerNameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        passengerNameTextField = new JTextField(20);
        passengerNameTextField.setPreferredSize(new Dimension(220, 30));
        // Train Number
        trainNoLabel = new JLabel("Train Number:");
        trainNoLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        trainNoTextField = new JTextField(20);
        trainNoTextField.setPreferredSize(new Dimension(220, 30));
        // Train Name
        trainNameLabel = new JLabel("Train Name:");
        trainNameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        trainNameTextField = new JTextField(20);
        trainNameTextField.setPreferredSize(new Dimension(220, 30));
        trainNameTextField.setEditable(false);
        // Class Type
        classTypeLabel = new JLabel("Class Type:");
        classTypeLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        classTypeComboBox=new JComboBox<>(new String[]{"Economy", "Business", "First Class"});
        classTypeComboBox.setPreferredSize(new Dimension(220, 30));
        // Journey Date
        journeyDateLabel = new JLabel("Journey Date:");
        journeyDateLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        journeyDateTextField = new JTextField(20);
        journeyDateTextField.setPreferredSize(new Dimension(220, 30));
        // Source
        sourceLabel = new JLabel("Source Station:");
        sourceLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        sourceTextField = new JTextField(20);
        sourceTextField.setPreferredSize(new Dimension(220, 30));
        // Destination
        destinationLabel = new JLabel("Destination Station:");
        destinationLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        destinationTextField = new JTextField(20);
        destinationTextField.setPreferredSize(new Dimension(220, 30));
        // Book Button
        bookButton = new JButton("Book Reservation");
        bookButton.setBackground(new Color(39, 103, 73));
        bookButton.setForeground(Color.WHITE);
        bookButton.setFont(new Font("Arial", Font.BOLD, 14));
        bookButton.setFocusPainted(false);
        // Cancel Button
        cancelButton = new JButton("Cancel Reservation");
        cancelButton.setBackground(new Color(130, 45, 45));
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFont(new Font("Arial", Font.BOLD, 14));
        cancelButton.setFocusPainted(false);
        // Logout Button
        logoutButton = new JButton("Logout");
        logoutButton.setBackground(new Color(90, 90, 90));
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setFont(new Font("Arial", Font.BOLD, 14));
        logoutButton.setFocusPainted(false);
        // GridBag settings
        gbc.insets = new Insets(8, 10, 8, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        // Title
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        mainPanel.add(titleLabel, gbc);
        // PassengerName Label
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        mainPanel.add(passengerNameLabel, gbc);
        // PassengerName Field
        gbc.gridx = 1;
        mainPanel.add(passengerNameTextField, gbc);
        // TrainNumber Label
        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(trainNoLabel, gbc);
        // TrainNumber Field
        gbc.gridx = 1;
        mainPanel.add(trainNoTextField, gbc);
        // TrainName Label
        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(trainNameLabel, gbc);
        // TrainName Field
        gbc.gridx = 1;
        mainPanel.add(trainNameTextField, gbc);
        // ClassType Label
        gbc.gridx = 0;
        gbc.gridy = 4;
        mainPanel.add(classTypeLabel, gbc);
        // ClassType Field
        gbc.gridx = 1;
        mainPanel.add(classTypeComboBox, gbc);
        // JourneyDate Label
        gbc.gridx = 0;
        gbc.gridy = 5;
        mainPanel.add(journeyDateLabel, gbc);
        // JourneyDate Field
        gbc.gridx = 1;
        mainPanel.add(journeyDateTextField, gbc);
        // Source Label
        gbc.gridx = 0;
        gbc.gridy = 6;
        mainPanel.add(sourceLabel, gbc);
        // Source Field
        gbc.gridx = 1;
        mainPanel.add(sourceTextField, gbc);
        // Destination Label
        gbc.gridx = 0;
        gbc.gridy = 7;
        mainPanel.add(destinationLabel, gbc);
        // Destination Field
        gbc.gridx = 1;
        mainPanel.add(destinationTextField, gbc);
        // Book Button
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        mainPanel.add(bookButton, gbc);
        // Cancel Button
        gbc.gridy = 9;
        mainPanel.add(cancelButton, gbc);
        // Logout Button
        gbc.gridy = 10;
        mainPanel.add(logoutButton, gbc);

        frame.add(mainPanel);
        // Press Enter in passengername field
        passengerNameTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trainNoTextField.requestFocusInWindow();
            }
        });
        // Press Enter in journy date field
        journeyDateTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sourceTextField.requestFocusInWindow();
            }
        });
        // Press Enter in source field
        sourceTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                destinationTextField.requestFocusInWindow();
            }
        });
        // Press Enter in train number and fetch train name automatically
        trainNoTextField.addActionListener(new ActionListener() {
        @Override
            public void actionPerformed(ActionEvent e){
                String trainNoText=trainNoTextField.getText().trim();
                if(trainNoText.isEmpty()){
                    JOptionPane.showMessageDialog(
                            frame,
                            "Train number cannot be empty.",
                            "Validation Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                    trainNoTextField.requestFocus();
                    return;
                }
                int trainNo;
                try{
                    trainNo=Integer.parseInt(trainNoText);
                } catch (NumberFormatException ex) {

                            JOptionPane.showMessageDialog(
                            frame,
                            "Train number must be numeric.",
                            "Validation Error",
                            JOptionPane.ERROR_MESSAGE
                    );

                    trainNoTextField.selectAll();
                    trainNoTextField.requestFocus();
                    return;
                }
                ReservationDAO reservationDAO = new ReservationDAO();
                String trainName = reservationDAO.getTrainName(trainNo);
                if (trainName != null) {
                    trainNameTextField.setText(trainName);
                } else {
                    JOptionPane.showMessageDialog(
                            frame,
                            "No train found with train number: " + trainNo,
                            "Train Not Found",
                            JOptionPane.ERROR_MESSAGE
                    );
                    trainNameTextField.setText("");
                    trainNoTextField.selectAll();
                    trainNoTextField.requestFocus();
                }
            }
        });
              
        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String passengerName=passengerNameTextField.getText().trim();
                String trainNoText=trainNoTextField.getText().trim();
                String trainName=trainNameTextField.getText().trim();
                String classType = (String) classTypeComboBox.getSelectedItem();
                String journeyDateText = journeyDateTextField.getText().trim();
                String source = sourceTextField.getText().trim();
                String destination = destinationTextField.getText().trim();
                // Passenger Name validation
                if (passengerName.isEmpty()) {
                    JOptionPane.showMessageDialog(
                            frame,
                            "Passenger name cannot be empty.",
                            "Validation Error",
                            JOptionPane.ERROR_MESSAGE
                   );
                    passengerNameTextField.requestFocus();
                    return;
                }
                // Train Number validation
                if (trainNoText.isEmpty()) {
                    JOptionPane.showMessageDialog(
                            frame,
                            "Train number cannot be empty.",
                            "Validation Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                    trainNoTextField.requestFocus();
                    return;
                }
                int trainNo;
                try {
                    trainNo = Integer.parseInt(trainNoText);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(
                            frame,
                            "Train number must be numeric.",
                            "Validation Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                    trainNoTextField.selectAll();
                    trainNoTextField.requestFocus();
                    return;
                }
                // Train existence validation
                ReservationDAO reservationDAO = new ReservationDAO();
                String databaseTrainName=reservationDAO.getTrainName(trainNo);
                if (databaseTrainName == null) {
                    JOptionPane.showMessageDialog(
                            frame,
                            "No train found with train number: " + trainNo,
                            "Train Not Found",
                            JOptionPane.ERROR_MESSAGE
                    );
                    trainNameTextField.setText("");
                    trainNoTextField.requestFocus();
                    return;
                }
                trainName = databaseTrainName;
                trainNameTextField.setText(trainName);
                // Journey date validation
                if (journeyDateText.isEmpty()) {
                    JOptionPane.showMessageDialog(
                            frame,
                            "Journey date cannot be empty.",
                            "Validation Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                    journeyDateTextField.requestFocus();
                    return;
                }
                Date journeyDate;
                try {
                    journeyDate = Date.valueOf(journeyDateText);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(
                            frame,
                            "Invalid date format.\nUse YYYY-MM-DD.",
                            "Validation Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                    journeyDateTextField.selectAll();
                    journeyDateTextField.requestFocus();
                    return;
                }
                // Source validation
                if (source.isEmpty()) {
                    JOptionPane.showMessageDialog(
                            frame,
                            "Source station cannot be empty.",
                            "Validation Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                    sourceTextField.requestFocus();
                    return;
                }
                // Destination validation
                if (destination.isEmpty()) {
                    JOptionPane.showMessageDialog(
                            frame,
                            "Destination station cannot be empty.",
                            "Validation Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                    destinationTextField.requestFocus();
                    return;
                }      
                // Source and destination should be different
                if (source.equalsIgnoreCase(destination)) {
                    JOptionPane.showMessageDialog(
                            frame,
                            "Source and destination stations cannot be the same.",
                            "Validation Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                    destinationTextField.requestFocus();
                    return;
                }
                // Create Reservation object
                Reservation reservation = new Reservation(0,passengerName,trainNo,trainName,
                classType,journeyDate,source,destination);
                // Save reservation
                int pnr = reservationDAO.bookReservation(reservation);
                if (pnr > 0) {
                    JOptionPane.showMessageDialog(
                            frame,
                            "Reservation Successful!\n\n"
                            + "PNR: " + pnr + "\nPassenger: " + passengerName + "\nTrain: " + trainName
                            + "\nClass: " + classType + "\nJourney Date: " + journeyDate + "\nFrom: " 
                            + source + "\nTo: " + destination, "Booking Confirmation",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    // Clear form
                    passengerNameTextField.setText("");
                    trainNoTextField.setText("");
                    trainNameTextField.setText("");
                    classTypeComboBox.setSelectedIndex(0);
                    journeyDateTextField.setText("");
                    sourceTextField.setText("");
                    destinationTextField.setText("");
                    passengerNameTextField.requestFocus();
                } else {
                    JOptionPane.showMessageDialog(
                            frame,
                            "Reservation could not be completed.",
                            "Booking Failed",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });
        
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

               new CancellationFrame(user);

                frame.dispose();
            }
        });
        
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(
                        frame,
                        "Are you sure you want to logout?",
                        "Confirm Logout",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );
                if (choice == JOptionPane.YES_OPTION) {
                    frame.dispose();
                    new LoginFrame();
                }
            }
        });
        
        frame.setVisible(true);
    }
}
