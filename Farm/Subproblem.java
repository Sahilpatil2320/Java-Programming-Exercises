// Base class representing a generic Farm
class Farm {
    protected int farmId;
    protected String ownerName;
    protected double landUsed;

    public Farm(int farmId, String ownerName, double landUsed) {
        this.farmId = farmId;
        this.ownerName = ownerName;
        this.landUsed = landUsed;
    }

    public void display() {
        System.out.println("Farm ID: " + farmId + ", Owner: " + ownerName + ", Land Used: " + landUsed + " acres");
    }
}

// Interface declaring a method to return production
interface Productive {
    String getProduction();
}

// VegetableFarm class inherits from Farm and implements Productive
class VegetableFarm extends Farm implements Productive {
    public VegetableFarm(int farmId, String ownerName, double landUsed) {
        super(farmId, ownerName, landUsed);
    }

    public String getProduction() {
        return landUsed * 10 + " kg of vegetables"; // Example production rate
    }
}

// FruitFarm class inherits from Farm and implements Productive
class FruitFarm extends Farm implements Productive {
    public FruitFarm(int farmId, String ownerName, double landUsed) {
        super(farmId, ownerName, landUsed);
    }

    public String getProduction() {
        return landUsed * 5 + " kg of fruits"; // Example production rate
    }
}

// Main class
public class Subproblem1 {
    public static void main(String[] args) {
        VegetableFarm vf = new VegetableFarm(101, "Ramesh", 2.5);
        vf.display();
        System.out.println("Production: " + vf.getProduction());

        FruitFarm ff = new FruitFarm(102, "Suresh", 3.0);
        ff.display();
        System.out.println("Production: " + ff.getProduction());
    }
}
