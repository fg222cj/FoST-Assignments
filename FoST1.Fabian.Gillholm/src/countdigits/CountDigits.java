package countdigits;
import assignmentframework.Interaction;

/**
 * Created by Fabian Gillholm on 2015-09-04.
 */
public class CountDigits {
    public static void main(String[] args) {
        int zeros = 0; // Number of zeroes in the given integer
        int odds = 0; // Number of odd digits
        int evens = 0; // Number of even digits
        int sum = 0; // Total sum of all digits

        // Get an integer from the user and convert it to a string
        // Note that leading zeros will be ignored
        int input = Interaction.getPositiveInteger("Please enter a positive integer: ");
        String digits = Integer.toString(input);

        // Loop through the string, converting each character to a digit and checking it
        for(int i = 0; i < digits.length(); i++) {
            int digit = Character.getNumericValue(digits.charAt(i));
            sum += digit;

            if(digit == 0) {
                zeros++;
                continue; // Zeros shouldn't count towards even, so just skip the rest of this iteration
            }

            if(digit%2 == 0) {
                evens++;
            }
            else {
                odds++;
            }
        }

        System.out.println("Zeros: " + zeros);
        System.out.println("Odd: " + odds);
        System.out.println("Even: " + evens);
        System.out.println("Sum: " + sum);
    }
}
