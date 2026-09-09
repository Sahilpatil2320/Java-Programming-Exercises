import java.io.*;

// IceCreamOrder class to hold order data
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

// FileManager class to handle file operations
class FileManager {
    public static void saveOrder(IceCreamOrder order) {
        try (FileWriter fw = new FileWriter("icecream_orders.txt", true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(order.type + "," + order.flavor + "," + order.quantity + "," + order.totalPrice + "\n");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

    public static void readOrders() {
        try (BufferedReader br = new BufferedReader(new FileReader("icecream_orders.txt"))) {
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
        // Create sample orders
        IceCreamOrder order1 = new IceCreamOrder("Cup", "Mango", 3, 90.0);
        IceCreamOrder order2 = new IceCreamOrder("Candy", "Chocolate", 4, 100.0);

        // Save orders to file
        FileManager.saveOrder(order1);
        FileManager.saveOrder(order2);

        // Read and display all orders
        System.out.println("All Orders:");
        FileManager.readOrders();
    }
}
