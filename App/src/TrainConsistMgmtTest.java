import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistMgmtTest {

    @Test
    void testCargo_SafeAssignment() {
        TrainConsistMgmt.GoodsBogie bogie =
                new TrainConsistMgmt.GoodsBogie("Cylindrical");

        bogie.assignCargo("Petroleum");

        assertEquals("Petroleum", bogie.cargo);
    }

    @Test
    void testCargo_UnsafeAssignmentHandled() {
        TrainConsistMgmt.GoodsBogie bogie =
                new TrainConsistMgmt.GoodsBogie("Rectangular");

        bogie.assignCargo("Petroleum");

        assertNull(bogie.cargo); // should not be assigned
    }

    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        TrainConsistMgmt.GoodsBogie bogie =
                new TrainConsistMgmt.GoodsBogie("Rectangular");

        bogie.assignCargo("Petroleum");

        assertNull(bogie.cargo);
    }

    @Test
    void testCargo_ProgramContinuesAfterException() {
        TrainConsistMgmt.GoodsBogie b1 =
                new TrainConsistMgmt.GoodsBogie("Rectangular");

        TrainConsistMgmt.GoodsBogie b2 =
                new TrainConsistMgmt.GoodsBogie("Cylindrical");

        b1.assignCargo("Petroleum"); // fails
        b2.assignCargo("Coal");      // should still work

        assertEquals("Coal", b2.cargo);
    }

    @Test
    void testCargo_FinallyBlockExecution() {
        TrainConsistMgmt.GoodsBogie bogie =
                new TrainConsistMgmt.GoodsBogie("Rectangular");

        // We can't directly assert finally output,
        // but we ensure method completes without crash
        assertDoesNotThrow(() -> bogie.assignCargo("Petroleum"));
    }
}