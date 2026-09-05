// Custom exception class for overheat or invalid temperature
class OverheatException extends Exception {
    // Constructor that accepts a custom error message
    public OverheatException(String message) {
        super(message);
    }
}

// Class to validate machine temperature
class MachineValidator {
    // Method to validate temperature range and max operating limit
    public static void validateTemperature(double temperature) throws OverheatException {
        if (temperature < 0 || temperature > 100) {
            throw new OverheatException("Temperature must be between 0°C and 100°C.");
        } else if (temperature > 35) {
            throw new OverheatException("Overheat! Machine cannot operate above 35°C.");
        }
    }
}

// Main class to test temperature validation
public class Subproblem2 {
    public static void main(String[] args) {
        // Test temperatures: one valid, one overheated, one out of range
        double[] testTemps = {30, 40, 105, -5};

        for (double temp : testTemps) {
            try {
                // Validate temperature
                MachineValidator.validateTemperature(temp);
                System.out.println("Temperature " + temp + "°C is valid. Machine can operate.");
            } catch (OverheatException e) {
                System.out.println("Exception for " + temp + "°C: " + e.getMessage());
            }
        }
    }
}
