import java.io.*; // For file handling

// Base class for machines (used for storing in file)
class Machine {
    protected String machineName;
    protected double temperature;

    public Machine(String machineName, double temperature) {
        this.machineName = machineName;
        this.temperature = temperature;
    }
}

// FileManager class to handle file operations for Machine data
class MachineFileManager {
    // Method to save a machine operation to file
    public static void saveMachineOperation(Machine m) {
        try (FileWriter fw = new FileWriter("machines.txt", true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(m.machineName + "," + m.temperature + "°C\n");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

    // Method to read and display all machine operation records
    public static void readMachineOperations() {
        try (BufferedReader br = new BufferedReader(new FileReader("machines.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("Operation Record: " + line);
            }
        } catch (IOException e) {
            System.out.println("Error reading from file.");
        }
    }
}

// Main class for testing file I/O
public class Subproblem3 {
    public static void main(String[] args) {
        // Create two machine records
        Machine coffeeMachine = new Machine("CoffeeMachine", 30.5);
        Machine pizzaMachine = new Machine("PizzaMachine", 32.0);

        // Save the machines to file
        MachineFileManager.saveMachineOperation(coffeeMachine);
        MachineFileManager.saveMachineOperation(pizzaMachine);

        // Read and display all records
        System.out.println("All Machine Operation Records:");
        MachineFileManager.readMachineOperations();
    }
}
