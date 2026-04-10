import java.util.*;

/**
 * ============================================
 * MAIN CLASS - TrainConsistMgmt
 *
 * Use Case 15: Safe Cargo Assignment Using try-catch-finally
 *
 * Description:
 * This use case safely assigns cargo to goods bogies
 * using runtime exception handling (try-catch-finally).
 *
 * Business Rule:
 * - Rectangular bogie cannot carry Petroleum
 *
 * Key Concepts:
 * - Runtime Exception
 * - try-catch-finally
 * - Graceful failure handling
 * - Defensive runtime validation
 *
 * @author Ramesh Harisabapathi Chettiar
 * @version 15.1
 * ============================================
 */
public class TrainConsistMgmt {

    /**
     * Custom Runtime Exception
     */
    public static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }

    /**
     * Goods Bogie Model
     */
    public static class GoodsBogie {
        String shape;
        String cargo;

        public GoodsBogie(String shape) {
            this.shape = shape;
        }

        /**
         * Assign cargo with validation
         */
        public void assignCargo(String cargo) {
            try {
                // Safety Rule
                if (shape.equalsIgnoreCase("Rectangular") &&
                        cargo.equalsIgnoreCase("Petroleum")) {

                    throw new CargoSafetyException("Unsafe cargo assignment!");
                }

                this.cargo = cargo;
                System.out.println("Cargo assigned successfully -> " + cargo);

            } catch (CargoSafetyException e) {
                System.out.println("Error: " + e.getMessage());

            } finally {
                System.out.println("Cargo validation completed for " + shape + " bogie");
            }
        }

        @Override
        public String toString() {
            return shape + " -> " + cargo;
        }
    }

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("UC15 - Safe Cargo Assignment");
        System.out.println("========================================\n");

        // Safe case
        GoodsBogie b1 = new GoodsBogie("Cylindrical");
        b1.assignCargo("Petroleum");

        System.out.println();

        // Unsafe case
        GoodsBogie b2 = new GoodsBogie("Rectangular");
        b2.assignCargo("Petroleum");

        System.out.println("\nUC15 runtime handling completed...");
    }
}