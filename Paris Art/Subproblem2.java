// Custom exception for invalid artwork attributes
class InvalidArtworkException extends Exception {
    public InvalidArtworkException(String message) {
        super(message);
    }
}

// Validator class
class ArtworkValidator {
    public static void validateArtwork(double price, int quantity) throws InvalidArtworkException {
        if (price < 0 || quantity < 0) {
            throw new InvalidArtworkException("Price and quantity must be non-negative.");
        }
    }
}

// Test class
public class Subproblem2 {
    public static void main(String[] args) {
        double[] testPrices = {500, -200, 1200};
        int[] testQuantities = {2, 3, -1};

        for (int i = 0; i < testPrices.length; i++) {
            try {
                ArtworkValidator.validateArtwork(testPrices[i], testQuantities[i]);
                System.out.println("Valid Artwork: Price = " + testPrices[i] + ", Quantity = " + testQuantities[i]);
            } catch (InvalidArtworkException e) {
                System.out.println("Exception: " + e.getMessage());
            }
        }
    }
}
