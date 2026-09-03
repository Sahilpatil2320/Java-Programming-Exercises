import javax.swing.*;
import java.awt.event.*;

public class Subproblem4 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Cake Shop");
        frame.setSize(400, 300);
        frame.setLayout(null);

        JLabel l1 = new JLabel("Order ID:");
        l1.setBounds(30, 30, 100, 30);
        JTextField tf1 = new JTextField();
        tf1.setBounds(150, 30, 150, 30);

        JLabel l2 = new JLabel("Flavor:");
        l2.setBounds(30, 70, 100, 30);
        JTextField tf2 = new JTextField();
        tf2.setBounds(150, 70, 150, 30);

        JLabel l3 = new JLabel("Price:");
        l3.setBounds(30, 110, 100, 30);
        JTextField tf3 = new JTextField();
        tf3.setBounds(150, 110, 150, 30);

        JButton addBtn = new JButton("Add");
        addBtn.setBounds(50, 160, 100, 30);
        JButton viewBtn = new JButton("View All");
        viewBtn.setBounds(200, 160, 100, 30);

        addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int orderId = Integer.parseInt(tf1.getText());
                    String flavor = tf2.getText();
                    double price = Double.parseDouble(tf3.getText());

                    CakeValidator.validateWeight(1); // Simulating validation
                    Cake c = new Cake(orderId, flavor, price);
                    FileManager.saveCake(c);

                    JOptionPane.showMessageDialog(frame, "Cake order saved!");
                } catch (InvalidWeightException ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input!");
                }
            }
        });

        viewBtn.addActionListener(e -> FileManager.readCakes());

        frame.add(l1); frame.add(tf1);
        frame.add(l2); frame.add(tf2);
        frame.add(l3); frame.add(tf3);
        frame.add(addBtn); frame.add(viewBtn);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
