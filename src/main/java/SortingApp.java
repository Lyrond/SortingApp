import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class SortingApp {
    private static final Logger logger = LogManager.getLogger(SortingApp.class);
    public static void main(int[] array) {
        logger.info("Application started.");
        // Check for no argument
        if (getErrorMessage(array)) return;

        // sort the integer values
        sortNumbers(array);

        // Print the sorted values
        System.out.println("Sorted values in ascending order:");
        for (int number : array) {
            System.out.print(number + " ");
        }
        logger.info("Application finished.");
    }

    static int[] sortNumbers(int[] array) {
        for (int i = 0; i< array.length ; i++) {
            try {
                for (int j = 0; j < array.length - 1; j++) {
                    if (array[j + 1] < array[j]) {
                        int temp = array[j + 1];
                        array[j + 1] = array[j];
                        array[j] = temp;
                    }
                }
            } catch (NumberFormatException exception) {
                System.out.println("Invalid argument: " + array[i] + ". Please provide integer values only.");
            }
        }
        return array;
    }

    static boolean getErrorMessage(int[] array) {
        if (array.length == 0) {
            System.out.println("No arguments provided. Please provide integer values.");
            return true;
        }
        return false;
    }

}
