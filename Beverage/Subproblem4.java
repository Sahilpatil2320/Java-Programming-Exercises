import javax.swing.*;
import java.awt.event.*;

public class Subproblem4 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("CafeShop Billing System");
        frame.setSize(450, 350);
        frame.setLayout(null);

        JLabel l1 = new JLabel("Order ID:");
        l1.setBounds(30, 30, 100, 30);
        JTextField tf1 = new JTextField();
        tf1.setBounds(150, 30, 200, 30);

        JLabel l2 = new JLabel("Customer Name:");
        l2.setBounds(30, 70, 100, 30);
        JTextField tf2 = new JTextField();
        tf2.setBounds(150, 70, 200, 30);

        JLabel l3 = new JLabel("Quantity:");
        l3.setBounds(30, 110, 100, 30);
        JTextField tf3 = new JTextField();
        tf3.setBounds(150, 110, 200, 30);

        JLabel l4 = new JLabel("Unit Price:");
        l4.setBounds(30, 150, 100, 30);
        JTextField tf4 = new JTextField();
        tf4.setBounds(150, 150, 200, 30);

        JButton addBtn = new JButton("Add Order");
        addBtn.setBounds(50, 200, 130, 30);

        JButton viewBtn = new JButton("View All Orders");
        viewBtn.setBounds(220, 200, 150, 30);

        addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int orderId = Integer.parseInt(tf1.getText());
                    String customerName = tf2.getText();
                    int quantity = Integer.parseInt(tf3.getText());
                    double unitPrice = Double.parseDouble(tf4.getText());

                    // Validate order
                    OrderValidator.validateOrder(quantity, unitPrice);

                    Beverage order = new Beverage(orderId, customerName, quantity, unitPrice);
                    FileManager.saveOrder(order);

                    JOptionPane.showMessageDialog(frame, "Order added successfully!");
                    // Clear fields
                    tf1.setText("");
                    tf2.setText("");
                    tf3.setText("");
                    tf4.setText("");
                } catch (InvalidOrderException ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input!");
                }
            }
        });

        viewBtn.addActionListener(e -> FileManager.readOrders());

        frame.add(l1); frame.add(tf1);
        frame.add(l2); frame.add(tf2);
        frame.add(l3); frame.add(tf3);
        frame.add(l4); frame.add(tf4);
        frame.add(addBtn); frame.add(viewBtn);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
