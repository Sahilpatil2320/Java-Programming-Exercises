// Base class representing a generic Machine
class Machine {
    protected String name;
    protected double temperature;

    // Constructor to initialize machine details
    public Machine(String name, double temperature) {
        this.name = name;
        this.temperature = temperature;
    }

    // Method to display machine details
    public void display() {
        System.out.println("Machine: " + name + ", Temperature: " + temperature + "°C");
    }
}

// Interface declaring a method to check if machine can operate
interface Heatable {
    boolean canOperate();  // All implementing classes must define this method
}

// CoffeeMachine class inherits from Machine and implements Heatable
class CoffeeMachine extends Machine implements Heatable {
    public CoffeeMachine(double temperature) {
        super("Coffee Machine", temperature);
    }

    // If temperature <= 35, it can operate
    public boolean canOperate() {
        return temperature <= 35;
    }
}

// PizzaMachine class inherits from Machine and implements Heatable
class PizzaMachine extends Machine implements Heatable {
    public PizzaMachine(double temperature) {
        super("Pizza Machine", temperature);
    }

    // If temperature <= 35, it can operate
    public boolean canOperate() {
        return temperature <= 35;
    }
}

// Main class containing the main method
public class Subproblem1 {
    public static void main(String[] args) {
        // Create CoffeeMachine and PizzaMachine objects
        CoffeeMachine coffee = new CoffeeMachine(30);
        PizzaMachine pizza = new PizzaMachine(38);

        // Display Coffee Machine info and whether it can operate
        coffee.display();
        System.out.println("Can operate: " + (coffee.canOperate() ? "Yes" : "No"));

        // Display Pizza Machine info and whether it can operate
        pizza.display();
        System.out.println("Can operate: " + (pizza.canOperate() ? "Yes" : "No"));
    }
}
