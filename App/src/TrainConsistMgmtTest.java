import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistMgmtTest {

    @Test
    void testSafety_AllBogiesValid() {
        List<TrainConsistMgmt.GoodsBogie> bogies = Arrays.asList(
                new TrainConsistMgmt.GoodsBogie("Cylindrical", "Petroleum"),
                new TrainConsistMgmt.GoodsBogie("Open", "Coal")
        );
        assertTrue(TrainConsistMgmt.isTrainSafe(bogies));
    }

    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        List<TrainConsistMgmt.GoodsBogie> bogies = Arrays.asList(
                new TrainConsistMgmt.GoodsBogie("Cylindrical", "Coal")
        );
        assertFalse(TrainConsistMgmt.isTrainSafe(bogies));
    }

    @Test
    void testSafety_NonCylindricalBogiesAllowed() {
        List<TrainConsistMgmt.GoodsBogie> bogies = Arrays.asList(
                new TrainConsistMgmt.GoodsBogie("Open", "Coal"),
                new TrainConsistMgmt.GoodsBogie("Box", "Grain")
        );
        assertTrue(TrainConsistMgmt.isTrainSafe(bogies));
    }

    @Test
    void testSafety_MixedBogiesWithViolation() {
        List<TrainConsistMgmt.GoodsBogie> bogies = Arrays.asList(
                new TrainConsistMgmt.GoodsBogie("Cylindrical", "Petroleum"),
                new TrainConsistMgmt.GoodsBogie("Cylindrical", "Coal") // violation
        );
        assertFalse(TrainConsistMgmt.isTrainSafe(bogies));
    }

    @Test
    void testSafety_EmptyBogieList() {
        List<TrainConsistMgmt.GoodsBogie> bogies = new ArrayList<>();
        assertTrue(TrainConsistMgmt.isTrainSafe(bogies));
    }
}