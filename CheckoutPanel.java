import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class CheckoutPanel extends JPanel {
    private MainFrame mainFrame;

    public CheckoutPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new GridLayout(5, 2, 10, 10)); // Set horizontal and vertical gaps

        // Font size settings
        Font labelFont = new Font("Serif", Font.BOLD, 16);
        Font fieldFont = new Font("Serif", Font.PLAIN, 14);

        JLabel roomNumberLabel = new JLabel("Room Number:");
        roomNumberLabel.setFont(labelFont);
        JTextField roomNumberField = new JTextField();
        roomNumberField.setFont(fieldFont);

        JButton checkoutButton = new JButton("Checkout");
        checkoutButton.setFont(fieldFont);

        JTextArea billArea = new JTextArea(5, 20);
        billArea.setFont(fieldFont);
        billArea.setEditable(false);
        JScrollPane billScrollPane = new JScrollPane(billArea);

        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String roomNumber = roomNumberField.getText();
                if (roomNumber.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter a room number");
                    return;
                }

                Map<String, String> roomBookings = mainFrame.getRoomBookings();
                Map<String, Integer> roomAvailability = mainFrame.getRoomAvailability();
                Map<String, Integer> foodOrders = mainFrame.getFoodOrders();

                if (!roomBookings.containsKey(roomNumber)) {
                    JOptionPane.showMessageDialog(null, "Room number not found");
                    return;
                }

                String bookingDetails = roomBookings.get(roomNumber);
                String roomType = bookingDetails.contains("Luxury Double Room") ? "Luxury Double Room" :
                                  bookingDetails.contains("Deluxe Double Room") ? "Deluxe Double Room" :
                                  bookingDetails.contains("Luxury Single Room") ? "Luxury Single Room" :
                                  "Deluxe Single Room";

                int roomCharge = roomType.equals("Luxury Double Room") ? 4000 :
                                 roomType.equals("Deluxe Double Room") ? 3000 :
                                 roomType.equals("Luxury Single Room") ? 2200 : 1200;

                int foodCharge = foodOrders.getOrDefault(roomNumber, 0);

                int totalCharges = roomCharge + foodCharge;

                billArea.setText("Booking Details:\n" + bookingDetails + "\n\nRoom Charges: Rs. " + roomCharge + 
                                 "\nFood Charges: Rs. " + foodCharge + "\n\nTotal Charges: Rs. " + totalCharges);

                roomBookings.remove(roomNumber);
                roomAvailability.put(roomType, roomAvailability.get(roomType) + 1);
                foodOrders.remove(roomNumber);

                JOptionPane.showMessageDialog(null, "Checkout successful!");
            }
        });

        JButton backButton = new JButton("Back");
        backButton.setFont(fieldFont);
        backButton.addActionListener(e -> mainFrame.showMainPanel());

        // Add components to panel
        add(roomNumberLabel);
        add(roomNumberField);
        add(new JLabel()); // Empty cell
        add(checkoutButton);
        add(new JLabel("Bill:"));
        add(billScrollPane);
        add(new JLabel()); // Empty cell
        add(backButton);
    }
}
