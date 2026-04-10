import java.util.*;

/**
 * ============================================
 * MAIN CLASS - TrainConsistMgmt
 *
 * Use Case 14: Handle Invalid Bogie Capacity
 *
 * Description:
 * This use case enforces capacity validation using
 * a custom checked exception to prevent invalid
 * passenger bogie creation.
 *
 * Business Rule:
 * - Capacity must be > 0
 *
 * Key Concepts:
 * - Custom Exception
 * - Fail-fast validation
 * - throws & throw
 * - Defensive programming
 *
 * @author Ramesh Harisabapathi Chettiar
 * @version 14.1
 * ============================================
 */
public class TrainConsistMgmt {

    /**
     * Custom Exception
     */
    public static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    /**
     * Passenger Bogie Model
     */
    public static class PassengerBogie {
        String type;
        int capacity;

        public PassengerBogie(String type, int capacity) throws InvalidCapacityException {

            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }

            this.type = type;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return type + " -> " + capacity;
        }
    }

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("UC14 - Handle Invalid Bogie Capacity");
        System.out.println("========================================\n");

        try {
            PassengerBogie b1 = new PassengerBogie("Sleeper", 72);
            System.out.println("Created Bogie: " + b1);

            // Invalid case
            PassengerBogie b2 = new PassengerBogie("AC Chair", 0);
            System.out.println("Created Bogie: " + b2);

        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nUC14 exception handling completed...");
    }
}