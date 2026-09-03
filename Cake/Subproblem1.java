// Base class representing a generic Cake
class Cake {
    protected int orderId;
    protected String flavor;
    protected double pricePerKg;
    protected double weight;

    public Cake(int orderId, String flavor, double pricePerKg, double weight) {
        this.orderId = orderId;
        this.flavor = flavor;
        this.pricePerKg = pricePerKg;
        this.weight = weight;
    }

    public void display() {
        System.out.println("Order ID: " + orderId + ", Flavor: " + flavor +
                           ", Price/Kg: " + pricePerKg + ", Weight: " + weight);
    }
}

// Interface to calculate total price
interface Billable {
    double getTotalPrice();
}

// Egg Cake class
class EggCake extends Cake implements Billable {
    public EggCake(int orderId, String flavor, double pricePerKg, double weight) {
        super(orderId, flavor, pricePerKg, weight);
    }

    public double getTotalPrice() {
        return pricePerKg * weight;
    }
}

// Eggless Cake class
class EgglessCake extends Cake implements Billable {
    public EgglessCake(int orderId, String flavor, double pricePerKg, double weight) {
        super(orderId, flavor, pricePerKg, weight);
    }

    public double getTotalPrice() {
        return pricePerKg * weight + 50; // Extra charge for eggless
    }
}

// Main class
public class Subproblem1 {
    public static void main(String[] args) {
        EggCake ec = new EggCake(101, "Chocolate", 500, 1.5);
        ec.display();
        System.out.println("Total Price: ₹" + ec.getTotalPrice());

        EgglessCake elc = new EgglessCake(102, "Vanilla", 550, 2.0);
        elc.display();
        System.out.println("Total Price: ₹" + elc.getTotalPrice());
    }
}
