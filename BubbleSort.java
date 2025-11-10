import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
* Bubble Sort.
*
* @author  Atri Sarker
* @version 1.0
* @since   2025-11-09
*/
public final class BubbleSort {
  /**
   * Constant for the file path of the input file.
   */
  private static final String INPUT_FILE_PATH = "./input.txt";

  /**
   * Constant for the file path of the output file.
   */
  private static final String OUTPUT_FILE_PATH = "./output.txt";

  /**
   * Private constructor to satisfy style checker.
   * @exception IllegalStateException for the utility class.
   * @see IllegalStateException
   */
  private BubbleSort() {
    // Prevents illegal states.
    throw new IllegalStateException("Utility class.");
  }

  /**
   * Sorts an array of integers using the bubble sort algorithm.
   * @param arr the integer array to be sorted.
   */
  public static void bubbleSort(final int[] arr) {
    // Iterate over maxBound
    for (int maxBound = arr.length - 1; maxBound > 0; maxBound--) {
      // Flag for early completions
      boolean solved = true;
      // Iterate over unsorted portion
      for (int index = 0; index < maxBound; index++) {
        // Check if the current element is greater than the next element
        if (arr[index] > arr[index + 1]) {
          // If so, perform a swap
          int temp = arr[index];
          arr[index] = arr[index + 1];
          arr[index + 1] = temp;
          // Set flag to false
          solved = false;
        }
      }
      // If no swaps were made, the array is sorted
      if (solved) {
        break;
      }
    }
  }

  /**
   * Entrypoint of the program.
   * @param args UNUSED.
   */
  public static void main(final String[] args) {
    // Copied from 2-01
    try {
      // Access the input file and create a File object.
      File inputFile = new File(INPUT_FILE_PATH);
      // Access the output file and create a FileWriter object.
      FileWriter outputFile = new FileWriter(OUTPUT_FILE_PATH);
      // Scanner that will read the File Object.
      Scanner fileReader = new Scanner(inputFile);
      // Create list to store all the lines
      ArrayList<String> listOfLines = new ArrayList<>();
      // Loop through all available lines
      while (fileReader.hasNextLine()) {
        // Add the line to the list
        listOfLines.add(fileReader.nextLine());
      }
      // Close the file reader
      fileReader.close();
      // Loop through all the lines in the list
      for (String line : listOfLines) {
        // Check if the line is empty
        if (line.equals("")) {
          // If so, write an error message and continue
          outputFile.write("Error: No integers were found on this line.\n");
          continue;
        }
        // Split the line
        String[] stringArr = line.split(" ");
        // Convert String array into an int array
        int[] intArr = new int[stringArr.length];
        for (int index = 0; index < stringArr.length; index++) {
          intArr[index] = Integer.parseInt(stringArr[index]);
        }
        // Print Array Before Sorting
        System.out.print("Before: ");
        for (int num : intArr) {
          System.out.print(num + " ");
        }
        System.out.println();
        // Sort the array
        bubbleSort(intArr);
        // Print Array After Sorting
        System.out.print("After: ");
        for (int num : intArr) {
          System.out.print(num + " ");
        }
        System.out.println();
        // Write the sorted array to the output file
        for (int num : intArr) {
          outputFile.write(num + " ");
        }
        // Write a newline
        outputFile.write("\n");
      }
      // Close the FileWriter object
      outputFile.close();
    } catch (IOException error) {
      System.out.println(error);
    }
  }
}
