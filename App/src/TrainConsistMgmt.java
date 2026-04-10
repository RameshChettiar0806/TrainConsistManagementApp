import java.util.Arrays;

/**
 * ============================================
 * MAIN CLASS - TrainConsistMgmt
 *
 * Use Case 17: Sort Bogie Names Using Arrays.sort()
 *
 * Description:
 * This use case demonstrates sorting of bogie type
 * names alphabetically using Java's built-in
 * Arrays.sort() method.
 *
 * Key Concepts:
 * - Arrays.sort()
 * - Natural ordering (String)
 * - Library optimization (O(n log n))
 * - Clean and maintainable code
 *
 * @author Ramesh Harisabapathi Chettiar
 * @version 17.1
 * ============================================
 */
public class TrainConsistMgmt {

    /**
     * Sorting Logic using Arrays.sort()
     */
    public static void sortBogieNames(String[] bogieNames) {
        Arrays.sort(bogieNames);
    }

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("UC17 - Sort Bogie Names Using Arrays.sort()");
        System.out.println("========================================\n");

        String[] bogieNames = {
                "Sleeper", "AC Chair", "First Class", "General", "Luxury"
        };

        System.out.println("Original Bogie Names:");
        System.out.println(Arrays.toString(bogieNames));

        // Sorting
        sortBogieNames(bogieNames);

        System.out.println("\nSorted Bogie Names (Alphabetical):");
        System.out.println(Arrays.toString(bogieNames));

        System.out.println("\nUC17 sorting completed...");
    }
}