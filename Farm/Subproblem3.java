import java.io.*;

// Reuse the exception class
class InvalidFarmInputException extends Exception {
    public InvalidFarmInputException(String message) {
        super(message);
    }
}

// Base Farm class
class Farm {
    protected int farmId;
    protected String ownerName;
    protected double landUsed;

    public Farm(int farmId, String ownerName, double landUsed) throws InvalidFarmInputException {
        if (landUsed < 0) {
            throw new InvalidFarmInputException("Land used cannot be negative!");
        }
        this.farmId = farmId;
        this.ownerName = ownerName;
        this.landUsed = landUsed;
    }

    public String getDetails() {
        return "Farm ID: " + farmId + ", Owner: " + ownerName + ", Land Used: " + landUsed + " acres";
    }
}

// Productive interface
interface Productive {
    String getProduction();
}

// VegetableFarm
class VegetableFarm extends Farm implements Productive {
    public VegetableFarm(int farmId, String ownerName, double landUsed) throws InvalidFarmInputException {
        super(farmId, ownerName, landUsed);
    }

    public String getProduction() {
        return landUsed * 10 + " kg of vegetables";
    }
}

// FruitFarm
class FruitFarm extends Farm implements Productive {
    public FruitFarm(int farmId, String ownerName, double landUsed) throws InvalidFarmInputException {
        super(farmId, ownerName, landUsed);
    }

    public String getProduction() {
        return landUsed * 5 + " kg of fruits";
    }
}

// Main class for File I/O
public class Subproblem3 {
    public static void main(String[] args) {
        try {
            // Create farm objects
            VegetableFarm vf = new VegetableFarm(301, "Rita", 6.0);
            FruitFarm ff = new FruitFarm(302, "Sunil", 3.5);

            // Write to file
            FileWriter fw = new FileWriter("farm_data.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("== Farm Report ==\n");
            bw.write(vf.getDetails() + "\n");
            bw.write("Production: " + vf.getProduction() + "\n\n");
            bw.write(ff.getDetails() + "\n");
            bw.write("Production: " + ff.getProduction() + "\n");
            bw.close();

            System.out.println("Farm data written to file.");

            // Read from file
            BufferedReader br = new BufferedReader(new FileReader("farm_data.txt"));
            String line;
            System.out.println("\n== Reading from file ==");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();

        } catch (InvalidFarmInputException e) {
            System.out.println("Input Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("File Error: " + e.getMessage());
        }
    }
}
