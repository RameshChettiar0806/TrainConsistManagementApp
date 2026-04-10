import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistMgmtTest {

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(TrainConsistMgmt.validateTrainId("TRN-1234"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(TrainConsistMgmt.validateTrainId("TRAIN12"));
        assertFalse(TrainConsistMgmt.validateTrainId("1234-TRN"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(TrainConsistMgmt.validateCargoCode("PET-AB"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(TrainConsistMgmt.validateCargoCode("PET-ab"));
        assertFalse(TrainConsistMgmt.validateCargoCode("PET123"));
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(TrainConsistMgmt.validateTrainId("TRN-123"));
        assertFalse(TrainConsistMgmt.validateTrainId("TRN-12345"));
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(TrainConsistMgmt.validateCargoCode("PET-ab"));
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(TrainConsistMgmt.validateTrainId(""));
        assertFalse(TrainConsistMgmt.validateCargoCode(""));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        assertFalse(TrainConsistMgmt.validateTrainId("TRN-1234X"));
        assertFalse(TrainConsistMgmt.validateCargoCode("PET-ABCD"));
    }
}