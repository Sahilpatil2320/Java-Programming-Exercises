// Base class representing a generic Player
class Player {
    protected int playerId;
    protected String name;
    protected double auctionPrice;

    public Player(int playerId, String name, double auctionPrice) {
        this.playerId = playerId;
        this.name = name;
        this.auctionPrice = auctionPrice;
    }

    public void display() {
        System.out.println("Player ID: " + playerId + ", Name: " + name + ", Auction Price: ₹" + auctionPrice + " Lakhs");
    }
}

// Interface declaring method to get category
interface Categorized {
    String getCategory();
}

// Batsman class inherits from Player and implements Categorized
class Batsman extends Player implements Categorized {
    public Batsman(int playerId, String name, double auctionPrice) {
        super(playerId, name, auctionPrice);
    }

    public String getCategory() {
        if (auctionPrice >= 100) return "Platinum";
        else if (auctionPrice >= 70) return "Gold";
        else return "Silver";
    }
}

// Bowler class inherits from Player and implements Categorized
class Bowler extends Player implements Categorized {
    public Bowler(int playerId, String name, double auctionPrice) {
        super(playerId, name, auctionPrice);
    }

    public String getCategory() {
        if (auctionPrice >= 90) return "Platinum";
        else if (auctionPrice >= 60) return "Gold";
        else return "Silver";
    }
}

// Main class
public class Subproblem1 {
    public static void main(String[] args) {
        Batsman b = new Batsman(101, "Virat Kohli", 120);
        b.display();
        System.out.println("Category: " + b.getCategory());

        Bowler bw = new Bowler(202, "Jasprit Bumrah", 85);
        bw.display();
        System.out.println("Category: " + bw.getCategory());
    }
}
