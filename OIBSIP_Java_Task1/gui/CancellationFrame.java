package OIBSIP_Java_Task1.gui;
import OIBSIP_Java_Task1.dao.ReservationDAO;
import OIBSIP_Java_Task1.model.Reservation;
import OIBSIP_Java_Task1.model.User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CancellationFrame {
    private JFrame frame = new JFrame();
    private JPanel mainPanel = new JPanel();
    private JLabel titleLabel;
    private JLabel pnrLabel;
    private JTextField pnrTextField;
    private JButton fetchButton;
    private JButton confirmCancelButton;
    private JButton backButton;
    private JTextArea bookingDetailsArea;
    private GridBagConstraints gbc = new GridBagConstraints();
    private User user;
    private Reservation reservation;
    public CancellationFrame(User user) {
        this.user = user;
        frame.setTitle("Online Reservation System - Cancellation");
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        mainPanel.setBackground(new Color(247, 244, 238));
        mainPanel.setLayout(new GridBagLayout());
        // Title
        titleLabel = new JLabel("Cancel Reservation");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(48, 48, 48));
        // PNR Label
        pnrLabel = new JLabel("PNR Number:");
        pnrLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        // PNR Field
        pnrTextField = new JTextField(15);
        pnrTextField.setPreferredSize(new Dimension(180, 30));
        // Fetch Button
        fetchButton = new JButton("Fetch Booking");
        fetchButton.setBackground(new Color(39, 103, 103));
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setFont(new Font("Arial", Font.BOLD, 14));
        fetchButton.setFocusPainted(false);
        // Booking Details Area
        bookingDetailsArea = new JTextArea(10, 35);
        bookingDetailsArea.setEditable(false);
        bookingDetailsArea.setFont(new Font("Arial", Font.PLAIN, 14));
        bookingDetailsArea.setBackground(Color.WHITE);
        bookingDetailsArea.setLineWrap(true);
        bookingDetailsArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(bookingDetailsArea);
        // Confirm Cancellation Button
        confirmCancelButton =new JButton("Confirm Cancellation");
        confirmCancelButton.setBackground(new Color(130, 45, 45));
        confirmCancelButton.setForeground(Color.WHITE);
        confirmCancelButton.setFont(new Font("Arial", Font.BOLD, 14));
        confirmCancelButton.setFocusPainted(false);
        // Back Button
        backButton = new JButton("Back");
        backButton.setBackground(new Color(90, 90, 90));
        backButton.setForeground(Color.WHITE);
        backButton.setFont(new Font("Arial", Font.BOLD, 14));
        backButton.setFocusPainted(false);
        // Initially disable cancellation
        confirmCancelButton.setEnabled(false);
        // GridBag settings
        gbc.insets = new Insets(8, 10, 8, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        // Title
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        mainPanel.add(titleLabel, gbc);
        // PNR Label
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        mainPanel.add(pnrLabel, gbc);
        // PNR Field
        gbc.gridx = 1;
        gbc.gridy = 1;
        mainPanel.add(pnrTextField, gbc);
        // Fetch Button
        gbc.gridx = 2;
        gbc.gridy = 1;
        mainPanel.add(fetchButton, gbc);
        // Booking Details
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        mainPanel.add(scrollPane, gbc);
        // Confirm Cancellation
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(confirmCancelButton, gbc);
        // Back
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        mainPanel.add(backButton, gbc);
        frame.add(mainPanel);
        // Fetch booking
        fetchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pnrText = pnrTextField.getText().trim();
                if (pnrText.isEmpty()) {
                    JOptionPane.showMessageDialog(
                            frame,
                            "PNR number cannot be empty.",
                            "Validation Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                    pnrTextField.requestFocus();
                    return;
                }
                int pnr;
                try {
                    pnr = Integer.parseInt(pnrText);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(
                            frame,
                            "PNR number must be numeric.",
                            "Validation Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                    pnrTextField.selectAll();
                    pnrTextField.requestFocus();
                    return;
                }
                ReservationDAO reservationDAO = new ReservationDAO();
                reservation = reservationDAO.getReservation(pnr);
                if (reservation != null) {
                    bookingDetailsArea.setText(
                            "PNR: " + reservation.getPnr()
                            + "\nPassenger Name: "
                            + reservation.getPassengerName()
                            + "\nTrain Number: "
                            + reservation.getTrainNo()
                            + "\nTrain Name: "
                            + reservation.getTrainName()
                            + "\nClass Type: "
                            + reservation.getClassType()
                            + "\nJourney Date: "
                            + reservation.getJourneyDate()
                            + "\nSource Station: "
                            + reservation.getSourceStation()
                            + "\nDestination Station: "
                            + reservation.getDestinationStation()
                    );
                    confirmCancelButton.setEnabled(true);
                } else {
                    bookingDetailsArea.setText("");
                    confirmCancelButton.setEnabled(false);
                    JOptionPane.showMessageDialog(
                            frame,
                            "No reservation found with PNR: "
                            + pnr,
                            "Reservation Not Found",
                            JOptionPane.ERROR_MESSAGE
                    );
                    pnrTextField.selectAll();
                    pnrTextField.requestFocus();
                }
            }
        });
        // Confirm cancellation
        confirmCancelButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (reservation == null) {
                    return;
                }
                int choice = JOptionPane.showConfirmDialog(
                        frame,
                        "Are you sure you want to cancel this reservation?",
                        "Confirm Cancellation",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE
                );
                if (choice == JOptionPane.YES_OPTION) {
                    ReservationDAO reservationDAO = new ReservationDAO();
                    boolean cancelled = reservationDAO.cancelReservation(
                                    reservation.getPnr()
                            );
                    if (cancelled) {
                        JOptionPane.showMessageDialog(
                                frame,
                                "Reservation cancelled successfully.",
                                "Cancellation Successful",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                        bookingDetailsArea.setText("");
                        pnrTextField.setText("");
                        confirmCancelButton.setEnabled(false);
                        reservation = null;
                    } else {
                        JOptionPane.showMessageDialog(
                                frame,
                                "Reservation could not be cancelled.",
                                "Cancellation Failed",
                                JOptionPane.ERROR_MESSAGE
                        );
                    }
                }
            }
        });
        // Back button
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new ReservationFrame(user);
            }
        });
        frame.setVisible(true);
    }
}
