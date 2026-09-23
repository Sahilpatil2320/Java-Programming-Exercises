import java.io.*;

class Artwork {
    protected String title;
    protected double price;
    protected int quantity;

    public Artwork(String title, double price, int quantity) {
        this.title = title;
        this.price = price;
        this.quantity = quantity;
    }
}

class FileManager {
    public static void saveArtwork(Artwork a) {
        try (FileWriter fw = new FileWriter("gallery.txt", true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(a.title + "," + a.price + "," + a.quantity + "\n");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

    public static void readArtworks() {
        try (BufferedReader br = new BufferedReader(new FileReader("gallery.txt"))) {
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
        Artwork a1 = new Artwork("Eiffel Sunset", 300.0, 3);
        FileManager.saveArtwork(a1);
        System.out.println("All Artworks:");
        FileManager.readArtworks();
    }
}
