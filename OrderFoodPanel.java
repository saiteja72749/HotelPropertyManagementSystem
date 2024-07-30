import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class OrderFoodPanel extends JPanel {
    private MainFrame mainFrame;

    public OrderFoodPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new GridLayout(6, 2, 10, 10)); // Set horizontal and vertical gaps

        // Font size settings
        Font labelFont = new Font("Serif", Font.BOLD, 16);
        Font fieldFont = new Font("Serif", Font.PLAIN, 14);

        JLabel roomNumberLabel = new JLabel("Room Number:");
        roomNumberLabel.setFont(labelFont);
        JTextField roomNumberField = new JTextField();
        roomNumberField.setFont(fieldFont);

        JLabel itemLabel = new JLabel("Item:");
        itemLabel.setFont(labelFont);
        String[] items = {"Sandwich - Rs.50", "Pasta - Rs.60", "Noodles - Rs.70", "Coke - Rs.30"};
        JComboBox<String> itemBox = new JComboBox<>(items);
        itemBox.setFont(fieldFont);

        JLabel quantityLabel = new JLabel("Quantity:");
        quantityLabel.setFont(labelFont);
        JTextField quantityField = new JTextField();
        quantityField.setFont(fieldFont);

        JButton orderButton = new JButton("Order Food");
        orderButton.setFont(fieldFont);

        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String roomNumber = roomNumberField.getText();
                String selectedItem = (String) itemBox.getSelectedItem();
                int quantity;

                try {
                    quantity = Integer.parseInt(quantityField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid quantity");
                    return;
                }

                if (roomNumber.isEmpty() || selectedItem == null || quantity <= 0) {
                    JOptionPane.showMessageDialog(null, "Please fill all fields");
                    return;
                }

                Map<String, String> roomBookings = mainFrame.getRoomBookings();
                if (!roomBookings.containsKey(roomNumber)) {
                    JOptionPane.showMessageDialog(null, "Room number not found");
                    return;
                }

                int price = Integer.parseInt(selectedItem.split("- Rs.")[1].trim());
                int totalCost = price * quantity;

                Map<String, Integer> foodOrders = mainFrame.getFoodOrders();
                foodOrders.put(roomNumber, foodOrders.getOrDefault(roomNumber, 0) + totalCost);

                JOptionPane.showMessageDialog(null, "Food ordered successfully!");

                mainFrame.showMainPanel();
            }
        });

        // Add components to panel
        add(roomNumberLabel);
        add(roomNumberField);
        add(itemLabel);
        add(itemBox);
        add(quantityLabel);
        add(quantityField);
        add(new JLabel()); // Empty cell
        add(orderButton);
    }
}
