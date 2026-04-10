import java.util.*;

/**
 * ============================================
 * MAIN CLASS - TrainConsistMgmt
 *
 * Use Case 12: Safety Compliance Check for Goods Bogies
 *
 * Description:
 * This use case validates safety rules for goods bogies
 * using Java Streams and allMatch().
 *
 * Business Rule:
 * - Cylindrical bogies → ONLY carry "Petroleum"
 * - Other bogies → can carry any cargo
 *
 * Key Concepts:
 * - Stream API
 * - allMatch() terminal operation
 * - Lambda expressions
 * - Short-circuit evaluation
 * - Domain rule enforcement
 *
 * @author Ramesh Harisabapathi Chettiar
 * @version 12.1
 * ============================================
 */
public class TrainConsistMgmt {

    /**
     * Inner Class - GoodsBogie
     * Represents goods bogie with type and cargo
     */
    static class GoodsBogie {
        String type;
        String cargo;

        GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }

        @Override
        public String toString() {
            return type + " -> " + cargo;
        }
    }

    /**
     * Core Business Logic
     * Validates safety compliance using allMatch()
     */
    public static boolean isTrainSafe(List<GoodsBogie> bogies) {
        return bogies.stream()
                .allMatch(b ->
                        !b.type.equalsIgnoreCase("Cylindrical") ||
                                b.cargo.equalsIgnoreCase("Petroleum")
                );
    }

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("UC12 - Safety Compliance Check");
        System.out.println("========================================\n");

        // Create goods bogies
        List<GoodsBogie> goodsBogies = new ArrayList<>();
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Open", "Coal"));
        goodsBogies.add(new GoodsBogie("Box", "Grain"));
        goodsBogies.add(new GoodsBogie("Cylindrical", "Coal")); // violation

        System.out.println("Goods Bogies in Train:");
        goodsBogies.forEach(System.out::println);

        boolean isSafe = isTrainSafe(goodsBogies);

        System.out.println("\nSafety Compliance Status: " + isSafe);

        if (isSafe) {
            System.out.println("Train formation is SAFE.");
        } else {
            System.out.println("Train formation is NOT SAFE.");
        }

        System.out.println("\nUC12 safety validation completed...");
    }
}