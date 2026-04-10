import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistMgmtTest {

    @Test
    void testException_ValidCapacityCreation() throws TrainConsistMgmt.InvalidCapacityException {
        TrainConsistMgmt.PassengerBogie bogie =
                new TrainConsistMgmt.PassengerBogie("Sleeper", 72);

        assertNotNull(bogie);
    }

    @Test
    void testException_NegativeCapacityThrowsException() {
        Exception exception = assertThrows(
                TrainConsistMgmt.InvalidCapacityException.class,
                () -> new TrainConsistMgmt.PassengerBogie("Sleeper", -10)
        );

        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ZeroCapacityThrowsException() {
        assertThrows(
                TrainConsistMgmt.InvalidCapacityException.class,
                () -> new TrainConsistMgmt.PassengerBogie("AC Chair", 0)
        );
    }

    @Test
    void testException_ExceptionMessageValidation() {
        Exception exception = assertThrows(
                TrainConsistMgmt.InvalidCapacityException.class,
                () -> new TrainConsistMgmt.PassengerBogie("AC Chair", 0)
        );

        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ObjectIntegrityAfterCreation() throws TrainConsistMgmt.InvalidCapacityException {
        TrainConsistMgmt.PassengerBogie bogie =
                new TrainConsistMgmt.PassengerBogie("Sleeper", 72);

        assertEquals("Sleeper", bogie.type);
        assertEquals(72, bogie.capacity);
    }

    @Test
    void testException_MultipleValidBogiesCreation() throws TrainConsistMgmt.InvalidCapacityException {
        TrainConsistMgmt.PassengerBogie b1 =
                new TrainConsistMgmt.PassengerBogie("Sleeper", 72);

        TrainConsistMgmt.PassengerBogie b2 =
                new TrainConsistMgmt.PassengerBogie("AC Chair", 56);

        assertNotNull(b1);
        assertNotNull(b2);
    }
}