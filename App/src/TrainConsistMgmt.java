import java.util.*;
import java.util.stream.Collectors;

/**
 * ============================================
 * MAIN CLASS - TrainConsistMgmt
 *
 * Use Case 13: Performance Comparison (Loops vs Streams)
 *
 * Description:
 * This use case compares execution time of loop-based
 * filtering versus stream-based filtering using
 * System.nanoTime().
 *
 * Key Concepts:
 * - Performance Benchmarking
 * - System.nanoTime()
 * - Loop vs Stream processing
 * - Evidence-driven optimization
 *
 * @author Ramesh Harisabapathi Chettiar
 * @version 13.1
 * ============================================
 */
public class TrainConsistMgmt {

    /**
     * Inner Class - Bogie
     */
    static class Bogie {
        String type;
        int capacity;

        Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return type + " -> " + capacity;
        }
    }

    /**
     * Loop-based filtering
     */
    public static List<Bogie> filterWithLoop(List<Bogie> bogies) {
        List<Bogie> result = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > 60) {
                result.add(b);
            }
        }
        return result;
    }

    /**
     * Stream-based filtering
     */
    public static List<Bogie> filterWithStream(List<Bogie> bogies) {
        return bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("UC13 - Performance Comparison");
        System.out.println("========================================\n");

        // Create large dataset
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            bogies.add(new Bogie("Type" + (i % 3), 50 + (i % 50)));
        }

        // -------- LOOP BENCHMARK --------
        long startLoop = System.nanoTime();
        List<Bogie> loopResult = filterWithLoop(bogies);
        long endLoop = System.nanoTime();

        long loopTime = endLoop - startLoop;

        // -------- STREAM BENCHMARK --------
        long startStream = System.nanoTime();
        List<Bogie> streamResult = filterWithStream(bogies);
        long endStream = System.nanoTime();

        long streamTime = endStream - startStream;

        // Output
        System.out.println("Loop Execution Time (ns): " + loopTime);
        System.out.println("Stream Execution Time (ns): " + streamTime);

        System.out.println("\nFiltered Count (Loop): " + loopResult.size());
        System.out.println("Filtered Count (Stream): " + streamResult.size());

        System.out.println("\nUC13 performance benchmarking completed...");
    }
}