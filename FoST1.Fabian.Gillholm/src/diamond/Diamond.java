package diamond;

import assignmentframework.Interaction;

/**
 * Created by Foss on 2015-09-04.
 */
public class Diamond {
    public static void main(String[] args) {
        int width = Interaction.getOddPositiveInteger("Please provide an odd, positive integer: ");

        // Nested loops, this first one is for each row
        for(int i = 1; i <= width; i += 2) {
            System.out.println();
            // The second loop is for each character on a row
            for(int j = 0; j < width; j++) {
                // Determines whether a character should be a star or a white space
                if(j < ((width - i) / 2) || j > (width - ((width - i) / 2)) - 1) {
                    System.out.print(" ");
                }
                else {
                    System.out.print("*");
                }
            }
        }

        // Same as the loops above, but in the opposite order, starting with the maximum number of stars and working our
        // way down
        for(int i = width - 2; i > 0; i -= 2) {
            System.out.println();
            for(int j = 0; j < width; j++) {
                if(j < ((width - i) / 2) || j > (width - ((width - i) / 2)) - 1) {
                    System.out.print(" ");
                }
                else {
                    System.out.print("*");
                }
            }
        }
    }
}
