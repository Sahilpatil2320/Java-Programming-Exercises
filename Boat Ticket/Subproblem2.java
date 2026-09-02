// Custom Exception
class InvalidPassengerException extends Exception {
    public InvalidPassengerException(String message) {
        super(message);
    }
}

// Validator class
class TicketValidator {
    public static void validatePassengers(int passengers) throws InvalidPassengerException {
        if (passengers <= 0) {
            throw new InvalidPassengerException("Passenger count must be greater than 0.");
        }
    }
}

// Main class to test
public class Subproblem2 {
    public static void main(String[] args) {
        int[] testCounts = {3, 0, -1};

        for (int count : testCounts) {
            try {
                TicketValidator.validatePassengers(count);
                System.out.println("Valid passenger count: " + count);
            } catch (InvalidPassengerException e) {
                System.out.println("Exception: " + e.getMessage());
            }
        }
    }
}
