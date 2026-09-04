import javax.swing.*;
import java.awt.event.*;

public class Subproblem4 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Milk Order System");
        frame.setSize(400, 300);
        frame.setLayout(null);

        JLabel l1 = new JLabel("Milk Type (Cow/Buffalo):");
        l1.setBounds(30, 30, 150, 30);
        JTextField tf1 = new JTextField();
        tf1.setBounds(200, 30, 150, 30);

        JLabel l2 = new JLabel("Quantity (L):");
        l2.setBounds(30, 70, 100, 30);
        JTextField tf2 = new JTextField();
        tf2.setBounds(200, 70, 150, 30);

        JLabel l3 = new JLabel("Rate per Liter:");
        l3.setBounds(30, 110, 100, 30);
        JTextField tf3 = new JTextField();
        tf3.setBounds(200, 110, 150, 30);

        JButton addBtn = new JButton("Order");
        addBtn.setBounds(50, 160, 100, 30);

        JButton viewBtn = new JButton("View Orders");
        viewBtn.setBounds(200, 160, 120, 30);

        addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String type = tf1.getText();
                    double qty = Double.parseDouble(tf2.getText());
                    double rate = Double.parseDouble(tf3.getText());

                    StockValidator.validateStock(qty, 50); // Assume 50L stock

                    Milk milk;
                    if (type.equalsIgnoreCase("Cow")) {
                        milk = new CowMilk(qty, rate);
                    } else if (type.equalsIgnoreCase("Buffalo")) {
                        milk = new BuffaloMilk(qty, rate);
                    } else {
                        throw new Exception("Invalid Milk Type!");
                    }

                    double cost = ((Billable) milk).getTotalCost();
                    MilkOrder order = new MilkOrder(type + " Milk", qty, cost);
                    FileManager.saveOrder(order);

                    JOptionPane.showMessageDialog(frame, "Order placed! Total: ₹" + cost);
                } catch (StockLimitExceededException ex) {
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
        frame.add(addBtn); frame.add(viewBtn);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
