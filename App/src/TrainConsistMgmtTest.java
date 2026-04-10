import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistMgmtTest {

    private final String[] sample = {"BG101","BG205","BG309","BG412","BG550"};

    @Test
    void testBinarySearch_BogieFound() {
        assertTrue(TrainConsistMgmt.binarySearch(sample.clone(), "BG309"));
    }

    @Test
    void testBinarySearch_BogieNotFound() {
        assertFalse(TrainConsistMgmt.binarySearch(sample.clone(), "BG999"));
    }

    @Test
    void testBinarySearch_FirstElementMatch() {
        assertTrue(TrainConsistMgmt.binarySearch(sample.clone(), "BG101"));
    }

    @Test
    void testBinarySearch_LastElementMatch() {
        assertTrue(TrainConsistMgmt.binarySearch(sample.clone(), "BG550"));
    }

    @Test
    void testBinarySearch_SingleElementArray() {
        String[] arr = {"BG101"};
        assertTrue(TrainConsistMgmt.binarySearch(arr, "BG101"));
    }

    @Test
    void testBinarySearch_EmptyArray() {
        String[] arr = {};
        assertFalse(TrainConsistMgmt.binarySearch(arr, "BG101"));
    }

    @Test
    void testBinarySearch_UnsortedInputHandled() {
        String[] arr = {"BG309","BG101","BG550","BG205","BG412"};
        assertTrue(TrainConsistMgmt.binarySearch(arr, "BG205"));
    }
}