import java.util.ArrayList;
import java.util.List;

/**
 * MAIN CLASS - TrainConsistMgmt
 *
 * Use Case 1: Initialize Train and Display Consist Summary
 *
 * Description:
 * This class represents the entry point of the Train Consist
 * Management Application.
 *
 * At this stage, the application:
 * - Creates an empty train consist
 * - Uses a dynamic List to store bogies
 * - Displays initial bogie count
 * - Prints the current state of the train
 *
 * @author Ramesh
 * @version 1.0
 */

public class TrainConsistMgmt {

    public static void main(String[] args) {

        // Display welcome banner
        System.out.println("========================================");
        System.out.println("=== Train Consist Management App ===");
        System.out.println("========================================\n");

        // Create a dynamic list to store train bogies
        List<String> trainConsist = new ArrayList<>();

        // Display initialization message
        System.out.println("Train initialized successfully ...");

        // Display initial consist information
        System.out.println("Initial Bogie Count : " + trainConsist.size());
        System.out.println("Current Train Consist : " + trainConsist);

        // Final system message
        System.out.println("\nSystem ready for operations ...");
    }
}