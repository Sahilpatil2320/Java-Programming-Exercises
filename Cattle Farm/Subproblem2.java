// Custom exception for stock limit
class StockLimitExceededException extends Exception {
    public StockLimitExceededException(String message) {
        super(message);
    }
}

// Validator class for stock checking
class StockValidator {
    public static void validateStock(double orderQty, double availableQty) throws StockLimitExceededException {
        if (orderQty > availableQty) {
            throw new StockLimitExceededException("Order exceeds available stock.");
        }
    }
}

// Main class
public class Subproblem2 {
    public static void main(String[] args) {
        double availableStock = 10.0; // 10 liters available
        double[] orders = {5, 12, 7};

        for (double order : orders) {
            try {
                StockValidator.validateStock(order, availableStock);
                System.out.println("Order placed: " + order + "L");
            } catch (StockLimitExceededException e) {
                System.out.println("Exception: " + e.getMessage());
            }
        }
    }
}
