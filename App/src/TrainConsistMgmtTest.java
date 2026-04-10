import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistMgmtTest {

    private List<TrainConsistMgmt.Bogie> getSampleData() {
        return Arrays.asList(
                new TrainConsistMgmt.Bogie("Sleeper", 72),
                new TrainConsistMgmt.Bogie("AC Chair", 56),
                new TrainConsistMgmt.Bogie("First Class", 24),
                new TrainConsistMgmt.Bogie("General", 90)
        );
    }

    @Test
    void testLoopFilteringLogic() {
        List<TrainConsistMgmt.Bogie> result =
                TrainConsistMgmt.filterWithLoop(getSampleData());

        assertTrue(result.stream().allMatch(b -> b.capacity > 60));
    }

    @Test
    void testStreamFilteringLogic() {
        List<TrainConsistMgmt.Bogie> result =
                TrainConsistMgmt.filterWithStream(getSampleData());

        assertTrue(result.stream().allMatch(b -> b.capacity > 60));
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<TrainConsistMgmt.Bogie> loopResult =
                TrainConsistMgmt.filterWithLoop(getSampleData());

        List<TrainConsistMgmt.Bogie> streamResult =
                TrainConsistMgmt.filterWithStream(getSampleData());

        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        List<TrainConsistMgmt.Bogie> data = getSampleData();

        long start = System.nanoTime();
        TrainConsistMgmt.filterWithLoop(data);
        long end = System.nanoTime();

        long elapsed = end - start;

        assertTrue(elapsed > 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<TrainConsistMgmt.Bogie> bogies = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            bogies.add(new TrainConsistMgmt.Bogie("Type", i));
        }

        List<TrainConsistMgmt.Bogie> result =
                TrainConsistMgmt.filterWithStream(bogies);

        assertNotNull(result);
    }
}