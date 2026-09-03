// Custom exception for invalid cake weight
class InvalidWeightException extends Exception {
    public InvalidWeightException(String message) {
        super(message);
    }
}

// Validator class
class CakeValidator {
    public static void validateWeight(double weight) throws InvalidWeightException {
        if (weight <= 0) {
            throw new InvalidWeightException("Weight must be greater than 0 kg.");
        }
    }
}

// Test class
public class Subproblem2 {
    public static void main(String[] args) {
        double[] weights = {1.5, 0, -1.2, 2.0};

        for (double w : weights) {
            try {
                CakeValidator.validateWeight(w);
                System.out.println("Valid Weight: " + w + " kg");
            } catch (InvalidWeightException e) {
                System.out.println("Exception: " + e.getMessage());
            }
        }
    }
}
