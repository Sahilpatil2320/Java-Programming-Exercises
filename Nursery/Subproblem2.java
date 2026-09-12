// Custom exception class for invalid quantity
class InvalidQuantityException extends Exception {
    public InvalidQuantityException(String message) {
        super(message);
    }
}

// Validator class for tree samples
class TreeValidator {
    public static void validateQuantity(int quantity) throws InvalidQuantityException {
        if (quantity < 0) {
            throw new InvalidQuantityException("Quantity must be 0 or more.");
        }
    }
}

// Main class for testing Subproblem 2
public class Subproblem2 {
    public static void main(String[] args) {
        int[] testQuantities = {30, -5, 10};

        for (int q : testQuantities) {
            try {
                TreeValidator.validateQuantity(q);
                System.out.println("Valid Quantity: " + q);
            } catch (InvalidQuantityException e) {
                System.out.println("Exception: " + e.getMessage());
            }
        }
    }
}
