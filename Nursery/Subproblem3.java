import java.io.*;

// TreeSample class reused here
class TreeSample {
    protected int id;
    protected String speciesName;
    protected int quantity;

    public TreeSample(int id, String speciesName, int quantity) {
        this.id = id;
        this.speciesName = speciesName;
        this.quantity = quantity;
    }
}

// FileManager class for file operations
class FileManager {
    public static void saveTree(TreeSample tree) {
        try (FileWriter fw = new FileWriter("trees.txt", true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(tree.id + "," + tree.speciesName + "," + tree.quantity + "\n");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

    public static void readTrees() {
        try (BufferedReader br = new BufferedReader(new FileReader("trees.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("Record: " + line);
            }
        } catch (IOException e) {
            System.out.println("Error reading from file.");
        }
    }
}

// Main class for testing Subproblem 3
public class Subproblem3 {
    public static void main(String[] args) {
        TreeSample t1 = new TreeSample(101, "Apple", 40);
        TreeSample t2 = new TreeSample(102, "Maple", 20);

        FileManager.saveTree(t1);
        FileManager.saveTree(t2);

        System.out.println("All Trees:");
        FileManager.readTrees();
    }
}
