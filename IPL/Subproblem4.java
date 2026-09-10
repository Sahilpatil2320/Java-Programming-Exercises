import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Subproblem4 extends JFrame {
    JTextField idField, nameField, priceField;
    JTextArea outputArea;

    public Subproblem4() {
        setTitle("IPL Auction Management");
        setSize(400, 350);
        setLayout(new FlowLayout());

        add(new JLabel("Player ID:"));
        idField = new JTextField(10); add(idField);

        add(new JLabel("Name:"));
        nameField = new JTextField(10); add(nameField);

        add(new JLabel("Auction Price:"));
        priceField = new JTextField(10); add(priceField);

        JButton submitBtn = new JButton("Submit");
        add(submitBtn);

        outputArea = new JTextArea(10, 30);
        add(new JScrollPane(outputArea));

        submitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    String name = nameField.getText();
                    double price = Double.parseDouble(priceField.getText());

                    PlayerInputValidator.validateAuctionPrice(price);

                    // Choose Batsman for demo
                    Batsman batsman = new Batsman(id, name, price);
                    outputArea.setText("Player Details:\n");
                    outputArea.append("ID: " + id + "\n");
                    outputArea.append("Name: " + name + "\n");
                    outputArea.append("Auction Price: ₹" + price + " Lakhs\n");
                    outputArea.append("Category: " + batsman.getCategory() + "\n");

                } catch (InvalidAuctionPriceException ex) {
                    outputArea.setText("Validation Error: " + ex.getMessage());
                } catch (NumberFormatException ex) {
                    outputArea.setText("Please enter valid numeric values.");
                }
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Subproblem4();
    }
}
