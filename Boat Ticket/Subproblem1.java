// Base class representing a generic Boat Ticket
class Ticket {
    protected String customerName;
    protected int numberOfPassengers;

    public Ticket(String customerName, int numberOfPassengers) {
        this.customerName = customerName;
        this.numberOfPassengers = numberOfPassengers;
    }

    public void display() {
        System.out.println("Customer: " + customerName + ", Passengers: " + numberOfPassengers);
    }
}

// Interface for fare calculation
interface FareCalculator {
    double calculateFare();
}

// StandardRide subclass
class StandardRide extends Ticket implements FareCalculator {
    private final double farePerPassenger = 50.0;

    public StandardRide(String customerName, int numberOfPassengers) {
        super(customerName, numberOfPassengers);
    }

    public double calculateFare() {
        return farePerPassenger * numberOfPassengers;
    }
}

// LuxuryRide subclass
class LuxuryRide extends Ticket implements FareCalculator {
    private final double farePerPassenger = 100.0;

    public LuxuryRide(String customerName, int numberOfPassengers) {
        super(customerName, numberOfPassengers);
    }

    public double calculateFare() {
        return farePerPassenger * numberOfPassengers;
    }
}

// Main class
public class Subproblem1 {
    public static void main(String[] args) {
        StandardRide standard = new StandardRide("Amit", 3);
        standard.display();
        System.out.println("Total Fare (Standard): ₹" + standard.calculateFare());

        LuxuryRide luxury = new LuxuryRide("Riya", 2);
        luxury.display();
        System.out.println("Total Fare (Luxury): ₹" + luxury.calculateFare());
    }
}
