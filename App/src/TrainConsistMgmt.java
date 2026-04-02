import java.util.LinkedHashSet;
import java.util.Set;

/**
 * ===
 * MAIN CLASS - TrainConsistMgmt
 *
 * Use Case 5: Preserve Insertion Order of Bogies
 *
 * Description:
 * This class maintains the exact attachment order of bogies
 * while preventing duplicate entries using LinkedHashSet.
 *
 * @author Ramesh
 * @version 5.0
 */
public class TrainConsistMgmt {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("UC5 - Preserve Insertion Order of Bogies");
        System.out.println("========================================");

        // LinkedHashSet preserves insertion order and ensures uniqueness
        Set<String> formation = new LinkedHashSet<>();

        // Add bogies
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");

        // Attempt to add duplicate
        formation.add("Sleeper"); // will be ignored

        // Display final formation
        System.out.println("\nFinal Train Formation:");
        System.out.println(formation);

        System.out.println("\nNote:");
        System.out.println("LinkedHashSet preserves insertion order and removes duplicates automatically.");

        System.out.println("\nUC5 formation setup completed...");
    }
}