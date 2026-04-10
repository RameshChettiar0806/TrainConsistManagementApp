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
 * proper format before processing.
 *
 * Key Concepts:
 * - Regular Expressions (Regex)
 * - Pattern class
 * - matches() validation
 * - Input validation & data integrity
 *
 * @author Ramesh Harisabapathi Chettiar
 * @version 11.1
 * ============================================
 */
public class TrainConsistMgmt {

    /**
     * Regex Patterns
     */
    private static final String TRAIN_ID_REGEX = "TRN-\\d{4}";
    private static final String CARGO_CODE_REGEX = "PET-[A-Z]{2}";

    /**
     * Validation Methods
     */
    private static boolean validateTrainId(String trainId) {
        return Pattern.matches(TRAIN_ID_REGEX, trainId);
    }

    private static boolean validateCargoCode(String cargoCode) {
        return Pattern.matches(CARGO_CODE_REGEX, cargoCode);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println("UC11 - Validate Train ID & Cargo Code");
        System.out.println("========================================\n");

        // Accept input
        System.out.print("Enter Train ID (Format: TRN-1234): ");
        String trainId = scanner.nextLine();

        System.out.print("Enter Cargo Code (Format: PET-AB): ");
        String cargoCode = scanner.nextLine();

        // Validate
        boolean isTrainValid = validateTrainId(trainId);
        boolean isCargoValid = validateCargoCode(cargoCode);

        // Output Results
        System.out.println("\nValidation Results:");
        System.out.println("Train ID Valid: " + isTrainValid);
        System.out.println("Cargo Code Valid: " + isCargoValid);

        System.out.println("\nUC11 validation completed ...\n");

        // ================= TEST CASES =================

        testRegex_ValidTrainID();
        testRegex_InvalidTrainIDFormat();
        testRegex_ValidCargoCode();
        testRegex_InvalidCargoCodeFormat();
        testRegex_TrainIDDigitLengthValidation();
        testRegex_CargoCodeUppercaseValidation();
        testRegex_EmptyInputHandling();
        testRegex_ExactPatternMatch();
    }

    // ================= TEST METHODS =================

    static void testRegex_ValidTrainID() {
        System.out.println("ValidTrainID: " + validateTrainId("TRN-1234"));
    }

    static void testRegex_InvalidTrainIDFormat() {
        System.out.println("InvalidTrainID: " + validateTrainId("TRAIN12"));
    }

    static void testRegex_ValidCargoCode() {
        System.out.println("ValidCargoCode: " + validateCargoCode("PET-AB"));
    }

    static void testRegex_InvalidCargoCodeFormat() {
        System.out.println("InvalidCargoCode: " + validateCargoCode("PET-ab"));
    }

    static void testRegex_TrainIDDigitLengthValidation() {
        System.out.println("DigitLengthCheck (TRN-123): " + validateTrainId("TRN-123"));
        System.out.println("DigitLengthCheck (TRN-12345): " + validateTrainId("TRN-12345"));
    }

    static void testRegex_CargoCodeUppercaseValidation() {
        System.out.println("UppercaseCheck (PET-ab): " + validateCargoCode("PET-ab"));
    }

    static void testRegex_EmptyInputHandling() {
        System.out.println("EmptyTrainID: " + validateTrainId(""));
        System.out.println("EmptyCargoCode: " + validateCargoCode(""));
    }

    static void testRegex_ExactPatternMatch() {
        System.out.println("ExactMatch (TRN-1234X): " + validateTrainId("TRN-1234X"));
        System.out.println("ExactMatch (PET-ABCD): " + validateCargoCode("PET-ABCD"));
    }
}