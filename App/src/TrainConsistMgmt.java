import java.util.*;

/**
 * ============================================
 * MAIN CLASS - TrainConsistMgmt
 *
 * Use Case 19: Binary Search for Bogie ID
 *
 * Description:
 * This use case demonstrates searching for a specific
 * bogie ID using Binary Search on sorted data.
 *
 * Key Concepts:
 * - Binary Search (Divide & Conquer)
 * - Sorted data precondition
 * - compareTo() for String comparison
 * - O(log n) performance
 *
 * @author Ramesh Harisabapathi Chettiar
 * @version 19.
 * ============================================
 */
public class TrainConsistMgmt {

    /**
     * Binary Search Logic
     */
    public static boolean binarySearch(String[] bogieIds, String key) {

        if (bogieIds == null || bogieIds.length == 0) {
            return false;
        }

        // Ensure sorted (important precondition)
        Arrays.sort(bogieIds);

        int low = 0;
        int high = bogieIds.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int comparison = bogieIds[mid].compareTo(key);

            if (comparison == 0) {
                return true; // found
            } else if (comparison < 0) {
                low = mid + 1; // search right
            } else {
                high = mid - 1; // search left
            }
        }

        return false; // not found
    }

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("UC19 - Binary Search for Bogie ID");
        System.out.println("========================================\n");

        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        String key = "BG309";

        // Ensure sorted before display
        Arrays.sort(bogieIds);

        System.out.println("Sorted Bogie IDs:");
        for (String id : bogieIds) {
            System.out.println(id);
        }

        boolean found = binarySearch(bogieIds, key);

        if (found) {
            System.out.println("\nBogie " + key + " found using Binary Search.");
        } else {
            System.out.println("\nBogie " + key + " NOT found.");
        }

        System.out.println("\nUC19 search completed...");
    }
}