// Base class representing a generic Product
class Product {
    protected int productId;
    protected String name;
    protected double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public void display() {
        System.out.println("Product ID: " + productId + ", Name: " + name + ", Price: " + price);
    }
}

// Interface to declare method getCategory
interface Priced {
    String getCategory(); // Each product type must return its category
}

// Grocery class
class Grocery extends Product implements Priced {
    public Grocery(int productId, String name, double price) {
        super(productId, name, price);
    }

    public String getCategory() {
        return "Grocery";
    }
}

// Electronics class
class Electronics extends Product implements Priced {
    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    public String getCategory() {
        return "Electronics";
    }
}

// Main class
public class Subproblem1 {
    public static void main(String[] args) {
        Grocery g = new Grocery(1, "Rice", 500.0);
        g.display();
        System.out.println("Category: " + g.getCategory());

        Electronics e = new Electronics(2, "TV", 15000.0);
        e.display();
        System.out.println("Category: " + e.getCategory());
    }
}
