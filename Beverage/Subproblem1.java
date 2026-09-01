class Beverage {
    protected String name;
    protected double basePrice;

    public Beverage(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }

    public void display() {
        System.out.println("Beverage: " + name + ", Base Price: " + basePrice);
    }
}

// Interface with a method to calculate final price
interface Taxable {
    double calculatePriceWithTax();
}

// Tea class
class Tea extends Beverage implements Taxable {
    public Tea(String name, double basePrice) {
        super(name, basePrice);
    }

    public double calculatePriceWithTax() {
        return basePrice + (basePrice * 0.05); // 5% tax
    }
}

// Coffee class
class Coffee extends Beverage implements Taxable {
    public Coffee(String name, double basePrice) {
        super(name, basePrice);
    }

    public double calculatePriceWithTax() {
        return basePrice + (basePrice * 0.10); // 10% tax
    }
}

public class Subproblem1 {
    public static void main(String[] args) {
        Tea t = new Tea("Green Tea", 50);
        Coffee c = new Coffee("Espresso", 80);

        t.display();
        System.out.println("Final Price: " + t.calculatePriceWithTax());

        c.display();
        System.out.println("Final Price: " + c.calculatePriceWithTax());
    }
}