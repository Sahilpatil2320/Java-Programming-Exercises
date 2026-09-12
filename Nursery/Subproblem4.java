import javax.swing.*;
import java.awt.event.*;

public class Subproblem4 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Nursery Inventory System");
        frame.setSize(400, 300);
        frame.setLayout(null);

        JLabel l1 = new JLabel("Tree ID:");
        l1.setBounds(30, 30, 100, 30);
        JTextField tf1 = new JTextField();
        tf1.setBounds(150, 30, 150, 30);

        JLabel l2 = new JLabel("Species Name:");
        l2.setBounds(30, 70, 100, 30);
        JTextField tf2 = new JTextField();
        tf2.setBounds(150, 70, 150, 30);

        JLabel l3 = new JLabel("Quantity:");
        l3.setBounds(30, 110, 100, 30);
        JTextField tf3 = new JTextField();
        tf3.setBounds(150, 110, 150, 30);

        JButton addBtn = new JButton("Add Tree");
        addBtn.setBounds(50, 160, 100, 30);

        JButton viewBtn = new JButton("View All");
        viewBtn.setBounds(200, 160, 100, 30);

        addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(tf1.getText());
                    String species = tf2.getText();
                    int quantity = Integer.parseInt(tf3.getText());

                    TreeValidator.validateQuantity(quantity);

                    TreeSample tree = new FruitTree(id, species, quantity);
                    FileManager.saveTree(tree);

                    JOptionPane.showMessageDialog(frame, "Tree added successfully!");
                } catch (InvalidQuantityException ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid Input!");
                }
            }
        });

        viewBtn.addActionListener(e -> FileManager.readTrees());

        frame.add(l1); frame.add(tf1);
        frame.add(l2); frame.add(tf2);
        frame.add(l3); frame.add(tf3);
        frame.add(addBtn); frame.add(viewBtn);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
