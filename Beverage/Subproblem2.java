// Custom exception class for invalid price
class InvalidPriceException extends Exception {
    // Constructor that accepts a custom error message
    public InvalidPriceException(String message) {
        // Pass the message to the superclass constructor
        super(message);
    }
}

// Class to validate beverage order input
class OrderValidator {
    // Method to validate if the price is within the range 1 to 500
    public static void validatePrice(double price) throws InvalidPriceException {
        // Check if price is outside the valid range
        if (price <= 0 || price > 500) {
            // If invalid, throw custom exception with a descriptive message
            throw new InvalidPriceException("Price must be between 1 and 500.");
        }
    }
}

// Main class to test price validation
public class Subproblem2 {
    public static void main(String[] args) {
        // Test array with a mix of valid and invalid prices
        double[] testPrices = {120, -5, 0, 550, 200};

        // Iterate through each price in the array
        for (double price : testPrices) {
            try {
                // Attempt to validate the current price
                OrderValidator.validatePrice(price);
                // If no exception is thrown, the price is valid
                System.out.println("Valid Price: ₹" + price);
            } catch (InvalidPriceException e) {
                // If an InvalidPriceException is caught, print the error message
                System.out.println("Exception: " + e.getMessage());
            }
        }
    }
}
