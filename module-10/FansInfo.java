import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FanInfo {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/databasedb";
    private static final String USER = "student1";
    private static final String PASSWORD = "pass";

    private JFrame frame;
    private JTextField idField, firstNameField, lastNameField, favoriteTeamField;
    private JButton displayButton, updateButton;

    public FanInfo() {
        frame = new JFrame("Fan Information");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(20, 20, 80, 25);
        frame.add(idLabel);

        idField = new JTextField();
        idField.setBounds(100, 20, 165, 25);
        frame.add(idField);

        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setBounds(20, 60, 80, 25);
        frame.add(firstNameLabel);

        firstNameField = new JTextField();
        firstNameField.setBounds(100, 60, 165, 25);
        frame.add(firstNameField);

        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setBounds(20, 100, 80, 25);
        frame.add(lastNameLabel);

        lastNameField = new JTextField();
        lastNameField.setBounds(100, 100, 165, 25);
        frame.add(lastNameField);

        JLabel favoriteTeamLabel = new JLabel("Favorite Team:");
        favoriteTeamLabel.setBounds(20, 140, 100, 25);
        frame.add(favoriteTeamLabel);

        favoriteTeamField = new JTextField();
        favoriteTeamField.setBounds(120, 140, 165, 25);
        frame.add(favoriteTeamField);

        displayButton = new JButton("Display");
        displayButton.setBounds(20, 180, 100, 25);
        displayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayFanInfo();
            }
        });
        frame.add(displayButton);

        updateButton = new JButton("Update");
        updateButton.setBounds(150, 180, 100, 25);
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateFanInfo();
            }
        });
        frame.add(updateButton);

        frame.setVisible(true);
    }

    private void displayFanInfo() {
        int id = Integer.parseInt(idField.getText());
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM fans WHERE ID = ?")) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                firstNameField.setText(rs.getString("firstname"));
                lastNameField.setText(rs.getString("lastname"));
                favoriteTeamField.setText(rs.getString("favoriteteam"));
            } else {
                JOptionPane.showMessageDialog(frame, "No record found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateFanInfo() {
        int id = Integer.parseInt(idField.getText());
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String favoriteTeam = favoriteTeamField.getText();
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("UPDATE fans SET firstname = ?, lastname = ?, favoriteteam = ? WHERE ID = ?")) {
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, favoriteTeam);
            stmt.setInt(4, id);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(frame, "Record updated successfully.");
            } else {
                JOptionPane.showMessageDialog(frame, "No record found to update.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new FanInfo();
    }
}
