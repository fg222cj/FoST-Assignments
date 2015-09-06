package countchars;

import assignmentframework.Interaction;

import java.io.File;
import java.util.Scanner;

/**
 * Created by Foss on 2015-09-06.
 */
public class CountChars {
    public static void main(String[] args) {
        int uppercase = 0; // Number of uppercase characters
        int lowercase = 0; // Number of lowercase characters
        int whitespace = 0; // Number of whitespaces
        int numbers = 0; // Number of number type characters
        int other = 0; // Number of other characters that don't fit any of the above


        File file = new File("H:\\Fabian\\SergioGarciaBeatsTheAmericans.txt");
        try {
            Scanner fileScan = new Scanner(file);

            while(fileScan.hasNext()) {
                String row = fileScan.nextLine();
                // Loop through the row, checking each character
                for(int i = 0; i < row.length(); i++) {
                    char character = row.charAt(i);

                    if(Character.isUpperCase(character)) {
                        uppercase++;
                        continue;
                    }

                    if(Character.isLowerCase(character)) {
                        lowercase++;
                        continue;
                    }

                    if(Character.isDigit(character)) {
                        numbers++;
                        continue;
                    }

                    if(Character.isWhitespace(character)) {
                        whitespace++;
                        continue;
                    }

                    // If none of the previous cases match, then by definition it's something other
                    other++;
                }
            }

        }
        catch(Exception e) {
            e.printStackTrace();
        }


        System.out.println("Uppsercase: " + uppercase);
        System.out.println("Lowercase: " + lowercase);
        System.out.println("Whitespaces: " + whitespace);
        System.out.println("Numbers: " + numbers);
        System.out.println("Others: " + other);
    }
}
