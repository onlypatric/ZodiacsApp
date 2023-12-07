import javax.swing.*;
import javax.swing.border.EmptyBorder;

import swingdate.JDateChooser;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.awt.Color;
 
public class Application extends JFrame {

    private JLabel titleLabel;
    private JLabel zodiacLabel;

    public static EmptyBorder getPadding(int paddingValue) {
        return new EmptyBorder(paddingValue, paddingValue, paddingValue, paddingValue);
    }

    public Application() {
        // Set up the main frame
        this.setLayout(new BorderLayout());
        this.setTitle("Zodiac Sign Finder");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add a navigation title
        titleLabel = new JLabel("Zodiac Sign Finder");
        titleLabel.setBorder(getPadding(10));
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        this.add(titleLabel, BorderLayout.NORTH);

        // Add a label for displaying the zodiac sign
        zodiacLabel = new JLabel("No date inserted...");
        zodiacLabel.setBorder(getPadding(10));
        zodiacLabel.setFont(new Font("Arial", Font.BOLD, 20));
        zodiacLabel.setHorizontalAlignment(JLabel.CENTER);
        this.add(zodiacLabel, BorderLayout.CENTER);

        // Add a button to show the date chooser
        JButton showDateChooserButton = new JButton("Choose Date");
        showDateChooserButton.setBorder(getPadding(10));
        showDateChooserButton.setFont(new Font("Arial", Font.BOLD, 16));
        showDateChooserButton.setHorizontalAlignment(JButton.CENTER);
        showDateChooserButton.setVerticalAlignment(JButton.CENTER);
        showDateChooserButton.setFocusable(false);
        showDateChooserButton.setHorizontalTextPosition(JButton.CENTER);
        showDateChooserButton.setVerticalTextPosition(JButton.CENTER);
        showDateChooserButton.setBorderPainted(false);
        showDateChooserButton.setOpaque(true);
        showDateChooserButton.setBackground(new Color(0x008080));
        showDateChooserButton.setForeground(Color.WHITE);
        showDateChooserButton.setFocusPainted(false);
        showDateChooserButton.addActionListener(this::showDateChooser);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(showDateChooserButton);
        this.add(buttonPanel, BorderLayout.SOUTH);

        // Set the frame visibility
        this.setVisible(true);
    }

    private void showDateChooser(ActionEvent e) {
        JDateChooser dateChooser = new JDateChooser(date -> {
            if (date != null) {
                String zodiacSign = getZodiacSign(date);
                zodiacLabel.setText(date + " is "  + zodiacSign);
            }
        });
        dateChooser.setVisible(true);
    }

    private String getZodiacSign(LocalDate date) {
        int month = date.getMonthValue();
        int day = date.getDayOfMonth();

        switch (month) {
            case 1: // January
                return (day >= 20) ? "Aquarius" : "Capricorn";
            case 2: // February
                return (day >= 19) ? "Pisces" : "Aquarius";
            case 3: // March
                return (day >= 21) ? "Aries" : "Pisces";
            case 4: // April
                return (day >= 20) ? "Taurus" : "Aries";
            case 5: // May
                return (day >= 21) ? "Gemini" : "Taurus";
            case 6: // June
                return (day >= 21) ? "Cancer" : "Gemini";
            case 7: // July
                return (day >= 23) ? "Leo" : "Cancer";
            case 8: // August
                return (day >= 23) ? "Virgo" : "Leo";
            case 9: // September
                return (day >= 23) ? "Libra" : "Virgo";
            case 10: // October
                return (day >= 23) ? "Scorpio" : "Libra";
            case 11: // November
                return (day >= 22) ? "Sagittarius" : "Scorpio";
            case 12: // December
                return (day >= 22) ? "Capricorn" : "Sagittarius";
            default:
                return "Unknown";
        }
    }
}
