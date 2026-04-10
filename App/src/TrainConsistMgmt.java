import java.util.*;

/**
 * ============================================
 * MAIN CLASS - TrainConsistMgmt
 *
 * Use Case 16: Sort Passenger Bogies by Capacity
 *
 * Description:
 * This use case demonstrates manual sorting of
 * passenger bogie capacities using Bubble Sort.
 *
 * Key Concepts:
 * - Bubble Sort Algorithm
 * - Nested loops
 * - Swapping logic
 * - Algorithmic thinking
 *
 * @author Ramesh Harisabapathi Chettiar
 * @version 16.1
 * ============================================
 */
public class TrainConsistMgmt {

    /**
     * Bubble Sort Logic
     */
    public static void bubbleSort(int[] arr) {

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {
                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("UC16 - Manual Sorting using Bubble Sort");
        System.out.println("========================================\n");

        // Input array
        int[] capacities = {72, 56, 24, 70, 60};

        // Display original
        System.out.println("Original Capacities:");
        for (int c : capacities) {
            System.out.print(c + " ");
        }

        // Apply sorting
        bubbleSort(capacities);

        // Display sorted
        System.out.println("\n\nSorted Capacities (Ascending):");
        for (int c : capacities) {
            System.out.print(c + " ");
        }

        System.out.println("\n\nUC16 sorting completed...");
    }
}