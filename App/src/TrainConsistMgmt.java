import java.util.*;

/**
 * ============================================
 * MAIN CLASS - TrainConsistMgmt
 *
 * Use Case 20: Exception Handling During Search
 *
 * Description:
 * This use case prevents searching when no bogies
 * exist using fail-fast validation (exception).
 *
 * Key Concepts:
 * - Defensive Programming
 * - IllegalStateException
 * - Fail-fast principle
 * - State validation
 *
 * @author Ramesh Harisabapathi Chettiar
 * @version 20.0
 * ============================================
 */
public class TrainConsistMgmt {

    /**
     * Search with fail-fast validation
     */
    public static boolean searchBogie(String[] bogieIds, String searchId) {

        // ---- FAIL-FAST VALIDATION ----
        if (bogieIds == null || bogieIds.length == 0) {
            throw new IllegalStateException(
                    "No bogies available in train. Cannot perform search."
            );
        }

        // ---- LINEAR SEARCH ----
        for (String id : bogieIds) {
            if (id.equals(searchId)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("UC20 - Exception Handling During Search");
        System.out.println("========================================\n");

        // Example: Empty train scenario
        String[] bogieIds = {};

        String searchId = "BG101";

        try {
            boolean found = searchBogie(bogieIds, searchId);

            if (found) {
                System.out.println("Bogie " + searchId + " found.");
            } else {
                System.out.println("Bogie " + searchId + " NOT found.");
            }

        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nUC20 execution completed...");
    }
}