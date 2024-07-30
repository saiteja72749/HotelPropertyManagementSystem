import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class AvailabilityPanel extends JPanel {
    private MainFrame mainFrame;

    public AvailabilityPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new BorderLayout());

        // Title label with increased font size
        JLabel availabilityLabel = new JLabel("Room Availability", SwingConstants.CENTER);
        availabilityLabel.setFont(new Font("Serif", Font.BOLD, 24)); // Increased font size

        // Text area with increased font size
        JTextArea availabilityArea = new JTextArea(10, 50);
        availabilityArea.setText(getAvailability());
        availabilityArea.setEditable(false);
        availabilityArea.setFont(new Font("Serif", Font.PLAIN, 16)); // Increased font size

        JScrollPane scrollPane = new JScrollPane(availabilityArea);

        // Back button with increased font size
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Serif", Font.PLAIN, 16)); // Increased font size
        backButton.addActionListener(e -> mainFrame.showMainPanel());

        add(availabilityLabel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(backButton, BorderLayout.SOUTH);
    }

    private String getAvailability() {
        StringBuilder availability = new StringBuilder();
        Map<String, Integer> roomAvailability = mainFrame.getRoomAvailability();

        for (Map.Entry<String, Integer> entry : roomAvailability.entrySet()) {
            availability.append(entry.getKey()).append(": ").append(entry.getValue()).append(" available\n");
        }

        return availability.toString();
    }
}

