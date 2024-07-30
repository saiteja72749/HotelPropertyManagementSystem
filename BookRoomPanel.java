import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class BookRoomPanel extends JPanel {
    private MainFrame mainFrame;

    public BookRoomPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new GridLayout(10, 2, 10, 10)); // Set horizontal and vertical gaps

        // Font size settings
        Font labelFont = new Font("Serif", Font.BOLD, 16);
        Font fieldFont = new Font("Serif", Font.PLAIN, 14);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(labelFont);
        JTextField nameField = new JTextField();
        nameField.setFont(fieldFont);

        JLabel contactLabel = new JLabel("Contact:");
        contactLabel.setFont(labelFont);
        JTextField contactField = new JTextField();
        contactField.setFont(fieldFont);

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setFont(labelFont);

        // Create radio buttons for gender
        JRadioButton maleButton = new JRadioButton("Male");
        JRadioButton femaleButton = new JRadioButton("Female");
        JRadioButton otherButton = new JRadioButton("Other");

        // Group radio buttons
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        genderGroup.add(otherButton);

        JPanel genderPanel = new JPanel();
        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);
        genderPanel.add(otherButton);

        JLabel roomTypeLabel = new JLabel("Room Type:");
        roomTypeLabel.setFont(labelFont);
        String[] roomTypes = {"Luxury Double Room", "Deluxe Double Room", "Luxury Single Room", "Deluxe Single Room"};
        JComboBox<String> roomTypeBox = new JComboBox<>(roomTypes);
        roomTypeBox.setFont(fieldFont);

        JLabel person2NameLabel = new JLabel("Second Person's Name:");
        person2NameLabel.setFont(labelFont);
        JTextField person2NameField = new JTextField();
        person2NameField.setFont(fieldFont);
        person2NameLabel.setVisible(false);
        person2NameField.setVisible(false);

        JLabel person2GenderLabel = new JLabel("Second Person's Gender:");
        person2GenderLabel.setFont(labelFont);
        // Add radio buttons for second person gender if needed
        JPanel person2GenderPanel = new JPanel();
        JRadioButton person2MaleButton = new JRadioButton("Male");
        JRadioButton person2FemaleButton = new JRadioButton("Female");
        JRadioButton person2OtherButton = new JRadioButton("Other");

        ButtonGroup person2GenderGroup = new ButtonGroup();
        person2GenderGroup.add(person2MaleButton);
        person2GenderGroup.add(person2FemaleButton);
        person2GenderGroup.add(person2OtherButton);

        person2GenderPanel.add(person2MaleButton);
        person2GenderPanel.add(person2FemaleButton);
        person2GenderPanel.add(person2OtherButton);
        person2GenderPanel.setVisible(false);

        JLabel roomNumberLabel = new JLabel("Room Number:");
        roomNumberLabel.setFont(labelFont);
        JTextField roomNumberField = new JTextField();
        roomNumberField.setFont(fieldFont);

        JButton bookButton = new JButton("Book Room");
        bookButton.setFont(fieldFont);

        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String contact = contactField.getText();
                String gender = maleButton.isSelected() ? "Male" : 
                                femaleButton.isSelected() ? "Female" : 
                                otherButton.isSelected() ? "Other" : "";
                String roomType = (String) roomTypeBox.getSelectedItem();
                String roomNumber = roomNumberField.getText();
                String person2Name = person2NameField.getText();
                String person2Gender = person2MaleButton.isSelected() ? "Male" : 
                                       person2FemaleButton.isSelected() ? "Female" : 
                                       person2OtherButton.isSelected() ? "Other" : "";

                if (name.isEmpty() || contact.isEmpty() || gender.isEmpty() || roomNumber.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all fields");
                    return;
                }

                if ((roomType.contains("Double") && (person2Name.isEmpty() || person2Gender.isEmpty()))) {
                    JOptionPane.showMessageDialog(null, "Please fill all fields for second person");
                    return;
                }

                Map<String, String> roomBookings = mainFrame.getRoomBookings();
                Map<String, Integer> roomAvailability = mainFrame.getRoomAvailability();

                if (roomAvailability.get(roomType) <= 0) {
                    JOptionPane.showMessageDialog(null, "No rooms available for selected type");
                    return;
                }

                String bookingDetails = "Name: " + name + "\nContact: " + contact + "\nGender: " + gender + "\nRoom Type: " + roomType + "\nRoom Number: " + roomNumber;

                if (roomType.contains("Double")) {
                    bookingDetails += "\nSecond Person's Name: " + person2Name + "\nSecond Person's Gender: " + person2Gender;
                }

                roomBookings.put(roomNumber, bookingDetails);
                roomAvailability.put(roomType, roomAvailability.get(roomType) - 1);

                JOptionPane.showMessageDialog(null, "Room booked successfully!");

                mainFrame.showMainPanel();
            }
        });

        roomTypeBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedRoomType = (String) roomTypeBox.getSelectedItem();
                if (selectedRoomType != null && selectedRoomType.contains("Double")) {
                    person2NameLabel.setVisible(true);
                    person2NameField.setVisible(true);
                    person2GenderLabel.setVisible(true);
                    person2GenderPanel.setVisible(true);
                } else {
                    person2NameLabel.setVisible(false);
                    person2NameField.setVisible(false);
                    person2GenderLabel.setVisible(false);
                    person2GenderPanel.setVisible(false);
                }
            }
        });

        // Add components to panel
        add(nameLabel);
        add(nameField);
        add(contactLabel);
        add(contactField);
        add(genderLabel);
        add(genderPanel);
        add(roomTypeLabel);
        add(roomTypeBox);
        add(person2NameLabel);
        add(person2NameField);
        add(person2GenderLabel);
        add(person2GenderPanel);
        add(roomNumberLabel);
        add(roomNumberField);
        add(new JLabel()); // Empty cell
        add(bookButton);
    }
}
