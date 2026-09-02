import java.io.*;

// Ticket class (reused here)
class Ticket {
    protected String customerName;
    protected int numberOfPassengers;
    protected double totalFare;

    public Ticket(String customerName, int numberOfPassengers, double totalFare) {
        this.customerName = customerName;
        this.numberOfPassengers = numberOfPassengers;
        this.totalFare = totalFare;
    }
}

// FileManager class
class FileManager {
    public static void saveTicket(Ticket t) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("tickets.txt", true))) {
            bw.write(t.customerName + "," + t.numberOfPassengers + "," + t.totalFare + "\n");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

    public static void readTickets() {
        try (BufferedReader br = new BufferedReader(new FileReader("tickets.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("Ticket: " + line);
            }
        } catch (IOException e) {
            System.out.println("Error reading from file.");
        }
    }
}

// Main class
public class Subproblem3 {
    public static void main(String[] args) {
        Ticket t1 = new Ticket("Amit", 3, 150.0);
        FileManager.saveTicket(t1);
        System.out.println("All Tickets:");
        FileManager.readTickets();
    }
}
