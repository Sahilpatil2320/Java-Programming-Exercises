import java.io.*;

class Cake {
    protected int orderId;
    protected String flavor;
    protected double price;

    public Cake(int orderId, String flavor, double price) {
        this.orderId = orderId;
        this.flavor = flavor;
        this.price = price;
    }
}

class FileManager {
    public static void saveCake(Cake c) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("cakes.txt", true))) {
            bw.write(c.orderId + "," + c.flavor + "," + c.price + "\n");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

    public static void readCakes() {
        try (BufferedReader br = new BufferedReader(new FileReader("cakes.txt"))) {
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
        Cake c1 = new Cake(101, "Red Velvet", 950.0);
        FileManager.saveCake(c1);

        System.out.println("All Cakes:");
        FileManager.readCakes();
    }
}
