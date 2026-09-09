// Custom exception class for invalid ice cream orders
class InvalidOrderException extends Exception {
    // Constructor that accepts a custom error message
    public InvalidOrderException(String message) {
        // Pass the message to the superclass constructor (Exception)
        super(message);
    }
}

// Class to validate ice cream orders
class IceCreamValidator {
    // Method to validate if the flavor is valid and quantity is greater than 0
    public static void validateOrder(String flavor, int quantity) throws InvalidOrderException {
        // Check if quantity is less than or equal to 0
        if (quantity <= 0) {
            // If invalid, throw custom exception with a descriptive message
            throw new InvalidOrderException("Quantity must be greater than 0.");
        }
        // Check if flavor is not Mango or Chocolate
        if (!flavor.equalsIgnoreCase("Mango") && !flavor.equalsIgnoreCase("Chocolate")) {
            // If invalid, throw custom exception with a descriptive message
            throw new InvalidOrderException("Flavor must be either Mango or Chocolate.");
        }
    }
}

// Main class to test ice cream order validation
public class Subproblem2 {
    public static void main(String[] args) {
        // Test orders with a mix of valid and invalid entries (flavor, quantity)
        String[] flavors = {"Mango", "Strawberry", "Chocolate", "Vanilla"};
        int[] quantities = {2, 1, -3, 0};

        // Iterate through each test order
        for (int i = 0; i < flavors.length; i++) {
            String flavor = flavors[i];
            int quantity = quantities[i];

            try {
                // Attempt to validate the current order
                IceCreamValidator.validateOrder(flavor, quantity);
                // If no exception is thrown, the order is valid
                System.out.println("Valid Order - Flavor: " + flavor + ", Quantity: " + quantity);
            } catch (InvalidOrderException e) {
                // If an InvalidOrderException is caught, print the error message
                System.out.println("Exception: " + e.getMessage());
            }
        }
    }
}
