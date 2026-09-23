// Base class representing a generic Artwork
class Artwork {
    protected String title;
    protected double price;
    protected int quantity;

    public Artwork(String title, double price, int quantity) {
        this.title = title;
        this.price = price;
        this.quantity = quantity;
    }

    public void display() {
        System.out.println("Title: " + title + ", Price: " + price + ", Quantity: " + quantity);
    }
}

// Interface to calculate total sales value
interface Sellable {
    double calculateTotalSales(); // price * quantity
}

// Painting class extends Artwork and implements Sellable
class Painting extends Artwork implements Sellable {
    public Painting(String title, double price, int quantity) {
        super(title, price, quantity);
    }

    public double calculateTotalSales() {
        return price * quantity;
    }
}

// Sculpture class extends Artwork and implements Sellable
class Sculpture extends Artwork implements Sellable {
    public Sculpture(String title, double price, int quantity) {
        super(title, price, quantity);
    }

    public double calculateTotalSales() {
        return price * quantity;
    }
}

// Main class
public class Subproblem1 {
    public static void main(String[] args) {
        Painting painting = new Painting("Sunset", 500.0, 2);
        painting.display();
        System.out.println("Total Sales: €" + painting.calculateTotalSales());

        Sculpture sculpture = new Sculpture("The Thinker", 1200.0, 1);
        sculpture.display();
        System.out.println("Total Sales: €" + sculpture.calculateTotalSales());
    }
}
