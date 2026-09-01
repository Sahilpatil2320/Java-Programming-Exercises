import java.io.*;

// Beverage class same as in Subproblem1 but simplified here for file storage
class Beverage {
    protected int orderId;
    protected String customerName;
    protected int quantity;
    protected double unitPrice;

    public Beverage(int orderId, String customerName, int quantity, double unitPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }
}

class FileManager {
    public static void saveOrder(Beverage order) {
        try (FileWriter fw = new FileWriter("orders.txt", true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(order.orderId + "," + order.customerName + "," + order.quantity + "," + order.unitPrice + "\n");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

    public static void readOrders() {
        try (BufferedReader br = new BufferedReader(new FileReader("orders.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("Record: " + line);
            }
        } catch (IOException e) {
            System.out.println("Error reading from file.");
        }
    }
}

public class Subproblem3 {
    public static void main(String[] args) {
        Beverage order1 = new Beverage(101, "Alice", 2, 20.0);
        Beverage order2 = new Beverage(102, "Bob", 3, 30.0);

        FileManager.saveOrder(order1);
        FileManager.saveOrder(order2);

        System.out.println("All Orders:");
        FileManager.readOrders();
    }
}
