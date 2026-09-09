import javax.swing.*;
import java.awt.event.*;

// Reuse IceCreamValidator, FileManager, IceCreamOrder classes from previous subproblems

// For simplicity, redefine IceCreamValidator and FileManager here (or import if multiple files)
class InvalidQuantityException extends Exception {
    public InvalidQuantityException(String message) {
        super(message);
    }
}

class IceCreamValidator {
    public static void validateQuantity(int quantity) throws InvalidQuantityException {
        if (quantity < 1 || quantity > 20) {
            throw new InvalidQuantityException("Quantity must be between 1 and 20.");
        }
    }
}

class FileManager {
    public static void saveOrder(IceCreamOrder order) {
        try (java.io.FileWriter fw = new java.io.FileWriter("icecream_orders.txt", true);
             java.io.BufferedWriter bw = new java.io.BufferedWriter(fw)) {
            bw.write(order.type + "," + order.flavor + "," + order.quantity + "," + order.totalPrice + "\n");
        } catch (java.io.IOException e) {
            System.out.println("Error writing to file.");
        }
    }

    public static void readOrders() {
        try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader("icecream_orders.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("Order: " + line);
            }
        } catch (java.io.IOException e) {
            System.out.println("Error reading from file.");
        }
    }
}

class IceCreamOrder {
    protected String type;
    protected String flavor;
    protected int quantity;
    protected double totalPrice;

    public IceCreamOrder(String type, String flavor, int quantity, double totalPrice) {
        this.type = type;
        this.flavor = flavor;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }
}

// To calculate price same as Subproblem1
class Cup extends IceCreamOrder {
    private double unitPrice;

    public Cup(String flavor, int quantity) {
        super("Cup", flavor, quantity, 0);
        if (flavor.equalsIgnoreCase("Mango")) unitPrice = 30.0;
        else if (flavor.equalsIgnoreCase("Chocolate")) unitPrice = 40.0;
        else unitPrice = 35.0;
        this.totalPrice = unitPrice * quantity;
    }
}

class Candy extends IceCreamOrder {
    private double unitPrice;

    public Candy(String flavor, int quantity) {
        super("Candy", flavor, quantity, 0);
        if (flavor.equalsIgnoreCase("Mango")) unitPrice = 20.0;
        else if (flavor.equalsIgnoreCase("Chocolate")) unitPrice = 25.0;
        else unitPrice = 22.5;
        this.totalPrice = unitPrice * quantity;
    }
}

public class Subproblem4 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ice Cream Shop Billing System");
        frame.setSize(400, 350);
        frame.setLayout(null);

        JLabel lType = new JLabel("Type (Cup/Candy):");
        lType.setBounds(30, 30, 150, 30);
        JTextField tfType = new JTextField();
        tfType.setBounds(180, 30, 150, 30);

        JLabel lFlavor = new JLabel("Flavor:");
        lFlavor.setBounds(30, 70, 150, 30);
        JTextField tfFlavor = new JTextField();
        tfFlavor.setBounds(180, 70, 150, 30);

        JLabel lQuantity = new JLabel("Quantity:");
        lQuantity.setBounds(30, 110, 150, 30);
        JTextField tfQuantity = new JTextField();
        tfQuantity.setBounds(180, 110, 150, 30);

        JButton addBtn = new JButton("Add Order");
        addBtn.setBounds(50, 160, 120, 30);

        JButton viewBtn = new JButton("View All Orders");
        viewBtn.setBounds(200, 160, 150, 30);

        addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String type = tfType.getText().trim();
                    String flavor = tfFlavor.getText().trim();
                    int quantity = Integer.parseInt(tfQuantity.getText().trim());

                    IceCreamValidator.validateQuantity(quantity);

                    IceCreamOrder order;
                    if (type.equalsIgnoreCase("Cup")) {
                        order = new Cup(flavor, quantity);
                    } else if (type.equalsIgnoreCase("Candy")) {
                        order = new Candy(flavor, quantity);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Invalid type. Enter 'Cup' or 'Candy'.");
                        return;
                    }

                    FileManager.saveOrder(order);
                    JOptionPane.showMessageDialog(frame, "Order added successfully!");

                } catch (InvalidQuantityException ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Quantity must be a valid number.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid Input!");
                }
            }
        });

        viewBtn.addActionListener(e -> FileManager.readOrders());

        frame.add(lType);
        frame.add(tfType);
        frame.add(lFlavor);
        frame.add(tfFlavor);
        frame.add(lQuantity);
        frame.add(tfQuantity);
        frame.add(addBtn);
        frame.add(viewBtn);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
