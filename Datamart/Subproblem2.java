// Custom exception for invalid price
class InvalidPriceException extends Exception {
    public InvalidPriceException(String message) {
        super(message);
    }
}

// Validator class
class ProductValidator {
    public static void validatePrice(double price) throws InvalidPriceException {
        if (price < 0 || price > 100000) {
            throw new InvalidPriceException("Price must be between 0 and 100000.");
        }
    }
}

// Test main
public class Subproblem2 {
    public static void main(String[] args) {
        double[] testPrices = { 1500.0, -10, 100001, 70000 };

        for (double price : testPrices) {
            try {
                ProductValidator.validatePrice(price);
                System.out.println("Valid Price: " + price);
            } catch (InvalidPriceException e) {
                System.out.println("Exception: " + e.getMessage());
            }
        }
    }
}
