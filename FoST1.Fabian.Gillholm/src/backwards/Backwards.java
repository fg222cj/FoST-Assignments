package backwards;
import assignmentframework.Interaction;

/**
 * Created by Foss on 2015-09-04.
 */
public class Backwards {
    public static void main(String[] args) {
        // Prompt the user and get a string input
        String text = Interaction.queryString("Please type in a text to reverse:");

        // Flip it using StringBuilder class
        String reversed = new StringBuilder(text).reverse().toString();

        // Output the reversed string
        System.out.println("Backwards: " + reversed);
    }
}