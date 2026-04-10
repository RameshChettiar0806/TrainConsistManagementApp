import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistMgmtTest {

    private final String[] sample = {"BG101","BG205","BG309","BG412","BG550"};

    @Test
    void testSearch_BogieFound() {
        assertTrue(TrainConsistMgmt.linearSearch(sample, "BG309"));
    }

    @Test
    void testSearch_BogieNotFound() {
        assertFalse(TrainConsistMgmt.linearSearch(sample, "BG999"));
    }

    @Test
    void testSearch_FirstElementMatch() {
        assertTrue(TrainConsistMgmt.linearSearch(sample, "BG101"));
    }

    @Test
    void testSearch_LastElementMatch() {
        assertTrue(TrainConsistMgmt.linearSearch(sample, "BG550"));
    }

    @Test
    void testSearch_SingleElementArray() {
        String[] arr = {"BG101"};
        assertTrue(TrainConsistMgmt.linearSearch(arr, "BG101"));
    }
}