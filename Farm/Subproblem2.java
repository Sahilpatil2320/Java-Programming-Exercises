// Custom exception for invalid farm input
class InvalidFarmInputException extends Exception {
    public InvalidFarmInputException(String message) {
        super(message);
    }
}

// Base Farm class (from Subproblem 1)
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

    public void display() {
        System.out.println("Farm ID: " + farmId + ", Owner: " + ownerName + ", Land Used: " + landUsed + " acres");
    }
}

// Interface remains the same
interface Productive {
    String getProduction();
}

// VegetableFarm with exception handling
class VegetableFarm extends Farm implements Productive {
    public VegetableFarm(int farmId, String ownerName, double landUsed) throws InvalidFarmInputException {
        super(farmId, ownerName, landUsed);
    }

    public String getProduction() {
        return landUsed * 10 + " kg of vegetables";
    }
}

// FruitFarm with exception handling
class FruitFarm extends Farm implements Productive {
    public FruitFarm(int farmId, String ownerName, double landUsed) throws InvalidFarmInputException {
        super(farmId, ownerName, landUsed);
    }

    public String getProduction() {
        return landUsed * 5 + " kg of fruits";
    }
}

// Main class with try-catch
public class Subproblem2 {
    public static void main(String[] args) {
        try {
            VegetableFarm vf = new VegetableFarm(201, "Kiran", 4.0);
            vf.display();
            System.out.println("Production: " + vf.getProduction());

            // Invalid input test
            FruitFarm ff = new FruitFarm(202, "Anil", -3.0); // This should throw an exception
            ff.display();
            System.out.println("Production: " + ff.getProduction());
        } catch (InvalidFarmInputException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
