import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MainFrame extends JFrame {
    private JPanel mainPanel;
    private Map<String, String> roomBookings;
    private Map<String, Integer> roomAvailability;
    private Map<String, Integer> foodOrders;

    public MainFrame() {
        roomBookings = new HashMap<>();
        roomAvailability = new HashMap<>();
        foodOrders = new HashMap<>();

        // Initialize room availability
        roomAvailability.put("Luxury Double Room", 10);
        roomAvailability.put("Deluxe Double Room", 10);
        roomAvailability.put("Luxury Single Room", 10);
        roomAvailability.put("Deluxe Single Room", 10);

        setTitle("Hotel Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        mainPanel = createMainPanel();
        add(mainPanel, BorderLayout.CENTER);
    }

    private JPanel createMainPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Title
        JLabel titleLabel = new JLabel("Hotel Management System", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Adjust font size and style
        panel.add(titleLabel, BorderLayout.NORTH);

        // Button panel
        JPanel buttonPanel = new JPanel();
        // buttonPanel.setLayout(new GridLayout(3, 2, 20, 20));  // GridLayout with gaps

        Dimension buttonSize = new Dimension(200, 100);  // Set preferred button size

        JButton roomDetailsButton = new JButton("Room Details");
        JButton availabilityButton = new JButton("Room Availability");
        JButton bookRoomButton = new JButton("Book Room");
        JButton orderFoodButton = new JButton("Order Food");
        JButton checkoutButton = new JButton("Checkout");
        JButton exitButton = new JButton("Exit");

        // Set button sizes
        roomDetailsButton.setPreferredSize(buttonSize);
        availabilityButton.setPreferredSize(buttonSize);
        bookRoomButton.setPreferredSize(buttonSize);
        orderFoodButton.setPreferredSize(buttonSize);
        checkoutButton.setPreferredSize(buttonSize);
        exitButton.setPreferredSize(buttonSize);

        roomDetailsButton.addActionListener(e -> showPanel(new RoomDetailsPanel(this)));
        availabilityButton.addActionListener(e -> showPanel(new AvailabilityPanel(this)));
        bookRoomButton.addActionListener(e -> showPanel(new BookRoomPanel(this)));
        orderFoodButton.addActionListener(e -> showPanel(new OrderFoodPanel(this)));
        checkoutButton.addActionListener(e -> showPanel(new CheckoutPanel(this)));
        exitButton.addActionListener(e -> System.exit(0));

        buttonPanel.add(roomDetailsButton);
        buttonPanel.add(availabilityButton);
        buttonPanel.add(bookRoomButton);
        buttonPanel.add(orderFoodButton);
        buttonPanel.add(checkoutButton);
        buttonPanel.add(exitButton);

        panel.add(buttonPanel, BorderLayout.CENTER);

        return panel;
    }

    public void showPanel(JPanel panel) {
        getContentPane().removeAll();
        add(panel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public void showMainPanel() {
        showPanel(mainPanel);
    }

    public Map<String, String> getRoomBookings() {
        return roomBookings;
    }

    public Map<String, Integer> getRoomAvailability() {
        return roomAvailability;
    }

    public Map<String, Integer> getFoodOrders() {
        return foodOrders;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}
