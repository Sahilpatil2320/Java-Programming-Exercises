import java.io.*;

public class Subproblem3 {
    public static void main(String[] args) {
        Batsman player = new Batsman(104, "Rohit Sharma", 95.0);

        // Writing to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("auction_data.txt", true))) {
            writer.write(player.playerId + "," + player.name + "," + player.auctionPrice + "," + player.getCategory());
            writer.newLine();
            System.out.println("Player auction details saved to file.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        // Reading from file
        try (BufferedReader reader = new BufferedReader(new FileReader("auction_data.txt"))) {
            System.out.println("\n--- Auction Player Records ---");
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                System.out.println("ID: " + data[0] + ", Name: " + data[1] +
                        ", Price: ₹" + data[2] + " Lakhs, Category: " + data[3]);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
