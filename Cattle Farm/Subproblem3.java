import java.io.*;

// Order class for saving milk orders
class MilkOrder {
    protected String type;
    protected double quantity;
    protected double cost;

    public MilkOrder(String type, double quantity, double cost) {
        this.type = type;
        this.quantity = quantity;
        this.cost = cost;
    }
}

// File manager for orders
class FileManager {
    public static void saveOrder(MilkOrder order) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("orders.txt", true))) {
            bw.write(order.type + "," + order.quantity + "," + order.cost + "\n");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

    public static void readOrders() {
        try (BufferedReader br = new BufferedReader(new FileReader("orders.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("Order: " + line);
            }
        } catch (IOException e) {
            System.out.println("Error reading from file.");
        }
    }
}

// Main class
public class Subproblem3 {
    public static void main(String[] args) {
        MilkOrder order = new MilkOrder("Cow Milk", 4, 200);
        FileManager.saveOrder(order);
        System.out.println("Saved Orders:");
        FileManager.readOrders();
    }
}
