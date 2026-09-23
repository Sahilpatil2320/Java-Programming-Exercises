import javax.swing.*;
import java.awt.event.*;

public class Subproblem4 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Paris Art Gallery");
        frame.setSize(400, 300);
        frame.setLayout(null);

        JLabel l1 = new JLabel("Title:");
        l1.setBounds(30, 30, 100, 30);
        JTextField tf1 = new JTextField();
        tf1.setBounds(150, 30, 150, 30);

        JLabel l2 = new JLabel("Price:");
        l2.setBounds(30, 70, 100, 30);
        JTextField tf2 = new JTextField();
        tf2.setBounds(150, 70, 150, 30);

        JLabel l3 = new JLabel("Quantity:");
        l3.setBounds(30, 110, 100, 30);
        JTextField tf3 = new JTextField();
        tf3.setBounds(150, 110, 150, 30);

        JButton addBtn = new JButton("Add");
        addBtn.setBounds(50, 160, 100, 30);
        JButton viewBtn = new JButton("View All");
        viewBtn.setBounds(200, 160, 100, 30);

        addBtn.addActionListener(e -> {
            try {
                String title = tf1.getText();
                double price = Double.parseDouble(tf2.getText());
                int qty = Integer.parseInt(tf3.getText());

                ArtworkValidator.validateArtwork(price, qty);
                Artwork art = new Artwork(title, price, qty);
                FileManager.saveArtwork(art);
                JOptionPane.showMessageDialog(frame, "Artwork added successfully!");
            } catch (InvalidArtworkException ex) {
                JOptionPane.showMessageDialog(frame, ex.getMessage());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Invalid input!");
            }
        });

        viewBtn.addActionListener(e -> FileManager.readArtworks());

        frame.add(l1); frame.add(tf1);
        frame.add(l2); frame.add(tf2);
        frame.add(l3); frame.add(tf3);
        frame.add(addBtn); frame.add(viewBtn);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
