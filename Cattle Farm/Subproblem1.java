// Base class representing generic Milk
class Milk {
    protected String type;
    protected double quantity; // in liters
    protected double ratePerLiter;

    public Milk(String type, double quantity, double ratePerLiter) {
        this.type = type;
        this.quantity = quantity;
        this.ratePerLiter = ratePerLiter;
    }

    public void display() {
        System.out.println("Type: " + type + ", Quantity: " + quantity + "L, Rate: ₹" + ratePerLiter + "/L");
    }
}

// Interface defining cost calculation
interface Billable {
    double getTotalCost();
}

// Cow Milk subclass
class CowMilk extends Milk implements Billable {
    public CowMilk(double quantity, double ratePerLiter) {
        super("Cow Milk", quantity, ratePerLiter);
    }

    public double getTotalCost() {
        return quantity * ratePerLiter;
    }
}

// Buffalo Milk subclass
class BuffaloMilk extends Milk implements Billable {
    public BuffaloMilk(double quantity, double ratePerLiter) {
        super("Buffalo Milk", quantity, ratePerLiter);
    }

    public double getTotalCost() {
        return quantity * ratePerLiter;
    }
}

// Main class
public class Subproblem1 {
    public static void main(String[] args) {
        CowMilk cow = new CowMilk(5, 50);
        cow.display();
        System.out.println("Total Cost: ₹" + cow.getTotalCost());

        BuffaloMilk buffalo = new BuffaloMilk(3, 60);
        buffalo.display();
        System.out.println("Total Cost: ₹" + buffalo.getTotalCost());
    }
}
