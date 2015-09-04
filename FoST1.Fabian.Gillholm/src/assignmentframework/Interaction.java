package assignmentframework;
import java.util.Scanner;

/**
 * Created by Foss on 2015-09-04.
 */
public class Interaction {
    public static String queryString(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);

        String response = scanner.nextLine();
        return response;
    }

    public static int queryInt(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);

        int response = scanner.nextInt();
        return response;
    }

    public static double queryDouble(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);

        double response = scanner.nextDouble();
        return response;
    }

    public static int getPositiveInteger(String prompt) {
        int input = -1;
        boolean inputIsValid = false;

        while(!inputIsValid) {
            try {
                input = queryInt(prompt);
                inputIsValid = Validation.validatePositiveInteger(input);
            }
            catch(Exception e) {
                // No need to do anything here
            }

            // Display a polite error message if the user supplies invalid input
            if(!inputIsValid) {
                System.out.println("Stop fucking around. Try again.");
            }
        }

        return input;
    }
}
