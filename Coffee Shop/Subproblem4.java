import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

// GUI Class
public class Subproblem4GUI extends JFrame implements ActionListener {

    private JButton coffeeBtn, pizzaBtn, showRecordsBtn;
    private JTextArea outputArea;

    public Subproblem4GUI() {
        // Set up frame
        setTitle("Coffee Shop Machine GUI");
        setSize(500, 400);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Buttons Panel
        JPanel buttonPanel = new JPanel();
        coffeeBtn = new JButton("Start Coffee Machine");
        pizzaBtn = new JButton("Start Pizza Machine");
        showRecordsBtn = new JButton("Show Records");

        coffeeBtn.addActionListener(this);
        pizzaBtn.addActionListener(this);
        showRecordsBtn.addActionListener(this);

        buttonPanel.add(coffeeBtn);
        buttonPanel.add(pizzaBtn);
        buttonPanel.add(showRecordsBtn);

        // Output Area
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        // Add to Frame
        add(buttonPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == coffeeBtn) {
            CoffeeMachine cm = new CoffeeMachine("CoffeeMachine");
            cm.operate();
            MachineFileManager.saveMachineOperation(cm);
            outputArea.append("Started Coffee Machine at " + cm.temperature + "°C\n");
        } else if (e.getSource() == pizzaBtn) {
            PizzaMachine pm = new PizzaMachine("PizzaMachine");
            pm.operate();
            MachineFileManager.saveMachineOperation(pm);
            outputArea.append("Started Pizza Machine at " + pm.temperature + "°C\n");
        } else if (e.getSource() == showRecordsBtn) {
            outputArea.append("\n--- All Operation Records ---\n");
            try (BufferedReader br = new BufferedReader(new FileReader("machines.txt"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    outputArea.append(line + "\n");
                }
            } catch (IOException ex) {
                outputArea.append("Error reading from file.\n");
            }
        }
    }

    // Entry point
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Subproblem4GUI gui = new Subproblem4GUI();
            gui.setVisible(true);
        });
    }
}

// Reuse same Machine classes from earlier
class Machine {
    protected String machineName;
    protected double temperature;

    public Machine(String machineName) {
        this.machineName = machineName;
    }
}

class CoffeeMachine extends Machine {
    public CoffeeMachine(String machineName) {
        super(machineName);
    }

    public void operate() {
        this.temperature = 30.5;
        System.out.println(machineName + " running at " + temperature + "°C");
    }
}

class PizzaMachine extends Machine {
    public PizzaMachine(String machineName) {
        super(machineName);
    }

    public void operate() {
        this.temperature = 32.0;
        System.out.println(machineName + " running at " + temperature + "°C");
    }
}

// File Manager class
class MachineFileManager {
    public static void saveMachineOperation(Machine m) {
        try (FileWriter fw = new FileWriter("machines.txt", true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(m.machineName + "," + m.temperature + "°C\n");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }
}
