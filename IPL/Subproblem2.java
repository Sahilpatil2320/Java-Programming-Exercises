// Custom Exception for invalid auction price
class InvalidAuctionPriceException extends Exception {
    public InvalidAuctionPriceException(String message) {
        super(message);
    }
}

class PlayerInputValidator {
    public static void validateAuctionPrice(double price) throws InvalidAuctionPriceException {
        if (price < 10 || price > 200) {
            throw new InvalidAuctionPriceException("Auction price must be between ₹10 and ₹200 Lakhs.");
        }
    }
}

public class Subproblem2 {
    public static void main(String[] args) {
        try {
            double auctionPrice = 250; // Example wrong input
            PlayerInputValidator.validateAuctionPrice(auctionPrice);

            // Create a player if validation passes
            Batsman batsman = new Batsman(103, "Shubman Gill", auctionPrice);
            batsman.display();
            System.out.println("Category: " + batsman.getCategory());
        } catch (InvalidAuctionPriceException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
