import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * ============================================
 * MAIN CLASS - TrainConsistMgmt
 *
 * Use Case 11: Validate Train ID & Cargo Code
 *
 * Description:
 * This use case validates Train ID and Cargo Code
 * using Regular Expressions (Regex) to ensure
 * correct format before processing.
 *
 * Validation Rules:
 * - Train ID: TRN-1234 (exactly 4 digits)
 * - Cargo Code: PET-AB (exactly 2 uppercase letters)
 *
 * Key Concepts:
 * - Regex Pattern Matching
 * - Input Validation
 * - Data Integrity Enforcement
 * - JUnit-ready design
 *
 * @author Ramesh Harisabapathi Chettiar
 * @version 11.2
 * ============================================
 */
public class TrainConsistMgmt {

    // ================= REGEX CONSTANTS =================

    private static final String TRAIN_ID_REGEX = "TRN-\\d{4}";
    private static final String CARGO_CODE_REGEX = "PET-[A-Z]{2}";

    // ================= VALIDATION METHODS =================

    /**
     * Validates Train ID format
     */
    public static boolean validateTrainId(String trainId) {
        if (trainId == null || trainId.isEmpty()) return false;
        return Pattern.matches(TRAIN_ID_REGEX, trainId);
    }

    /**
     * Validates Cargo Code format
     */
    public static boolean validateCargoCode(String cargoCode) {
        if (cargoCode == null || cargoCode.isEmpty()) return false;
        return Pattern.matches(CARGO_CODE_REGEX, cargoCode);
    }

    // ================= MAIN EXECUTION =================

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println("UC11 - Validate Train ID & Cargo Code");
        System.out.println("========================================\n");

        // Input
        System.out.print("Enter Train ID (Format: TRN-1234): ");
        String trainId = scanner.nextLine();

        System.out.print("Enter Cargo Code (Format: PET-AB): ");
        String cargoCode = scanner.nextLine();

        // Validation
        boolean isTrainValid = validateTrainId(trainId);
        boolean isCargoValid = validateCargoCode(cargoCode);

        // Output
        System.out.println("\nValidation Results:");
        System.out.println("Train ID Valid: " + isTrainValid);
        System.out.println("Cargo Code Valid: " + isCargoValid);

        // Feedback (important for real systems)
        if (!isTrainValid) {
            System.out.println("⚠ Invalid Train ID format. Expected: TRN-1234");
        }

        if (!isCargoValid) {
            System.out.println("⚠ Invalid Cargo Code format. Expected: PET-AB");
        }

        System.out.println("\nUC11 validation completed...");
    }
}