import java.util.*;
import java.util.stream.Collectors;

/**
 * ============================================
 * MAIN CLASS - TrainConsistMgmt
 *
 * Use Case 10: Aggregate Total Seating Capacity
 *
 * Description:
 * This use case calculates the total seating capacity
 * of a train by aggregating capacities of all bogies
 * using Java Stream API and reduce().
 *
 * Key Concepts:
 * - Stream API
 * - map() transformation
 * - reduce() aggregation
 * - Functional programming
 * - Test-driven validation
 *
 * @author Ramesh Harisabapathi Chettiar
 * @version 10.0
 * ============================================
 */
public class TrainConsistMgmt {

    /**
     * Inner Class - Bogie
     * Represents a train bogie with name and capacity
     */
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return name + " -> " + capacity;
        }
    }

    /**
     * Core Business Logic
     * Aggregates total seating capacity using reduce()
     */
    private static int countTotalSeats(List<Bogie> bogies) {
        return bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
    }

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("UC10 - Aggregate Total Seating Capacity");
        System.out.println("========================================\n");

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));

        System.out.println("Bogies in Train:");
        bogies.forEach(System.out::println);

        int totalSeats = countTotalSeats(bogies);
        System.out.println("\nTotal Seating Capacity of Train: " + totalSeats);

        System.out.println("\nUC10 aggregation completed ...\n");

        // ================= TEST CASES =================

        testReduce_TotalSeatCalculation();
        testReduce_MultipleBogiesAggregation();
        testReduce_SingleBogieCapacity();
        testReduce_EmptyBogieList();
        testReduce_CorrectCapacityExtraction();
        testReduce_AllBogiesIncluded();
        testReduce_OriginalListUnchanged();
    }

    // ================= TEST METHODS =================

    static void testReduce_TotalSeatCalculation() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56)
        );
        System.out.println("TotalSeatCalculation: " + countTotalSeats(bogies));
    }

    static void testReduce_MultipleBogiesAggregation() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 24)
        );
        System.out.println("MultipleAggregation: " + countTotalSeats(bogies));
    }

    static void testReduce_SingleBogieCapacity() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72)
        );
        System.out.println("SingleBogie: " + countTotalSeats(bogies));
    }

    static void testReduce_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();
        System.out.println("EmptyList: " + countTotalSeats(bogies));
    }

    static void testReduce_CorrectCapacityExtraction() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56)
        );
        System.out.println("CapacityExtraction: " +
                bogies.stream().map(b -> b.capacity).collect(Collectors.toList()));
    }

    static void testReduce_AllBogiesIncluded() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 24)
        );
        System.out.println("AllIncluded: " + countTotalSeats(bogies));
    }

    static void testReduce_OriginalListUnchanged() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));

        countTotalSeats(bogies);

        System.out.println("OriginalListUnchanged: " + bogies.size() + " bogies remain");
    }
}