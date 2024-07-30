import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class RoomDetailsPanel extends JPanel {
    public RoomDetailsPanel(MainFrame mainFrame) {
        setLayout(new BorderLayout());

        String[] columnNames = {"Room Type", "Details"};
        Object[][] data = {
                {"Luxury Double Room", "Number of double beds: 1; \n AC: Yes; \n Free breakfast: Yes; \n Charge per day: 4000"},
                {"Deluxe Double Room", "Number of double beds: 1; \n AC: No; \n Free breakfast: Yes; \n Charge per day: 3000"},
                {"Luxury Single Room", "Number of single beds: 1; \n AC: Yes; \n Free breakfast: Yes; \n Charge per day: 2200"},
                {"Deluxe Single Room", "Number of single beds: 1; \n AC: No; \n Free breakfast: Yes; \n Charge per day: 1200"},
        };

        JTable table = new JTable(data, columnNames);
        table.setFont(new Font("Arial", Font.PLAIN, 14)); // Set font size for table content
        table.setRowHeight(30); // Adjust row height to fit font size

        // Set preferred column widths
        table.getColumnModel().getColumn(0).setPreferredWidth(200);
        table.getColumnModel().getColumn(1).setPreferredWidth(400);

        // Center align the text in the table
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);

        JScrollPane scrollPane = new JScrollPane(table);

        // Back button to return to the main panel
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> mainFrame.showMainPanel()); // Make sure showMainPanel() exists in MainFrame

        add(scrollPane, BorderLayout.CENTER);
        add(backButton, BorderLayout.SOUTH);
    }
}
