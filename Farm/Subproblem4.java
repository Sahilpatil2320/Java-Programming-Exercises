import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Reuse the Farm classes, Productive interface, and exception
class InvalidFarmInputException extends Exception {
    public InvalidFarmInputException(String message) {
        super(message);
    }
}

abstract class Farm {
    protected int farmId;
    protected String ownerName;
    protected double landUsed;

    public Farm(int farmId, String ownerName, double landUsed) throws InvalidFarmInputException {
        if (landUsed < 0) throw new InvalidFarmInputException("Land used must be non-negative!");
        this.farmId = farmId;
        this.ownerName = ownerName;
        this.landUsed = landUsed;
    }

    public String getDetails() {
        return "Farm ID: " + farmId + ", Owner: " + ownerName + ", Land: " + landUsed + " acres";
    }

    public abstract String getProduction();
}

class VegetableFarm extends Farm {
    public VegetableFarm(int farmId, String ownerName, double landUsed) throws InvalidFarmInputException {
        super(farmId, ownerName, landUsed);
    }

    public String getProduction() {
        return landUsed * 10 + " kg of vegetables";
    }
}

class FruitFarm extends Farm {
    public FruitFarm(int farmId, String ownerName, double landUsed) throws InvalidFarmInputException {
        super(farmId, ownerName, landUsed);
    }

    public String getProduction() {
        return landUsed * 5 + " kg of fruits";
    }
}

// GUI Class
public class Subproblem4 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Farm Management System");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Components
        JLabel labelType = new JLabel("Farm Type:");
        String[] types = {"Vegetable", "Fruit"};
        JComboBox<String> comboType = new JComboBox<>(types);

        JLabel labelId = new JLabel("Farm ID:");
        JTextField fieldId = new JTextField(10);

        JLabel labelOwner = new JLabel("Owner Name:");
        JTextField fieldOwner = new JTextField(10);

        JLabel labelLand = new JLabel("Land Used (acres):");
        JTextField fieldLand = new JTextField(10);

        JButton submitBtn = new JButton("Submit");
        JTextArea output = new JTextArea(6, 30);
        output.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(output);

        // Layout
        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(labelType);
        panel.add(comboType);
        panel.add(labelId);
        panel.add(fieldId);
        panel.add(labelOwner);
        panel.add(fieldOwner);
        panel.add(labelLand);
        panel.add(fieldLand);
        panel.add(submitBtn);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);

        // Action
        submitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(fieldId.getText());
                    String owner = fieldOwner.getText();
                    double land = Double.parseDouble(fieldLand.getText());
                    Farm farm;

                    if (comboType.getSelectedItem().equals("Vegetable")) {
                        farm = new VegetableFarm(id, owner, land);
                    } else {
                        farm = new FruitFarm(id, owner, land);
                    }

                    output.setText("Farm Created Successfully!\n");
                    output.append(farm.getDetails() + "\n");
                    output.append("Production: " + farm.getProduction());

                } catch (InvalidFarmInputException ex) {
                    output.setText("Error: " + ex.getMessage());
                } catch (NumberFormatException ex) {
                    output.setText("Please enter valid numbers for ID and Land.");
                }
            }
        });
    }
}
