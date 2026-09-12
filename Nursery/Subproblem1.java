// Base class representing a generic Tree Sample
class TreeSample {
    protected int id;
    protected String speciesName;
    protected int quantity;

    public TreeSample(int id, String speciesName, int quantity) {
        this.id = id;
        this.speciesName = speciesName;
        this.quantity = quantity;
    }

    public void display() {
        System.out.println("ID: " + id + ", Species: " + speciesName + ", Quantity: " + quantity);
    }
}

// Interface declaring method to categorize tree sample
interface Categorized {
    String getCategory();
}

// FruitTree subclass categorizing trees by quantity
class FruitTree extends TreeSample implements Categorized {
    public FruitTree(int id, String speciesName, int quantity) {
        super(id, speciesName, quantity);
    }

    public String getCategory() {
        if (quantity >= 50) return "High Yield";
        else if (quantity >= 20) return "Moderate Yield";
        else return "Low Yield";
    }
}

// ShadeTree subclass categorizing trees by quantity differently
class ShadeTree extends TreeSample implements Categorized {
    public ShadeTree(int id, String speciesName, int quantity) {
        super(id, speciesName, quantity);
    }

    public String getCategory() {
        if (quantity >= 30) return "Mature Shade";
        else if (quantity >= 10) return "Young Shade";
        else return "Sparse Shade";
    }
}

// Main class for testing Subproblem 1
public class Subproblem1 {
    public static void main(String[] args) {
        FruitTree ft = new FruitTree(1, "Mango", 45);
        ft.display();
        System.out.println("Category: " + ft.getCategory());

        ShadeTree st = new ShadeTree(2, "Oak", 15);
        st.display();
        System.out.println("Category: " + st.getCategory());
    }
}
