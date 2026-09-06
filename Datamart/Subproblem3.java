import java.io.*;

// Product class reused
class Product {
    protected int productId;
    protected String name;
    protected double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }
}

// FileManager handles saving and loading
class FileManager {
    public static void saveProduct(Product p) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("products.txt", true))) {
            bw.write(p.productId + "," + p.name + "," + p.price + "\n");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

    public static void readProducts() {
        try (BufferedReader br = new BufferedReader(new FileReader("products.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("Record: " + line);
            }
        } catch (IOException e) {
            System.out.println("Error reading from file.");
        }
    }
}

// Main for testing
public class Subproblem3 {
    public static void main(String[] args) {
        Product p1 = new Product(1, "Milk", 45.0);
        FileManager.saveProduct(p1);

        Product p2 = new Product(2, "Laptop", 45000.0);
        FileManager.saveProduct(p2);

        System.out.println("All Products:");
        FileManager.readProducts();
    }
}
