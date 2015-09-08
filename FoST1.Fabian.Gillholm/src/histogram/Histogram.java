package histogram;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Foss on 2015-09-08.
 */
public class Histogram {
    public static void main(String[] args) {

        // Check if we receive a filepath as an argument, otherwise halt the execution
        String filepath = "";
        if(args.length != 0) {
            filepath = args[0];
        }
        else {
            System.out.println("CountChars expects a filepath as a parameter!");
            System.exit(1);
        }

        try {
            // Grab the file and output a helpful message
            File file = new File(filepath);
            Scanner fileScan = new Scanner(file);
            System.out.println("Reading integers from the file: " + filepath);

            // Traverse the file and add all integers in the span 1 - 200 to the list
            List<Integer> integers = new ArrayList<Integer>();
            while (fileScan.hasNextInt()) {
                int integer = fileScan.nextInt();
                if(integer >= 1 && integer <= 200) {
                    integers.add(integer);
                }
            }

            // Output the result
            System.out.println("Number of integers in the interval [1,100]: " + getInterval(integers, 1, 100));
            System.out.println("in the interval [101,200]: " + getInterval(integers, 101, 200));
            System.out.println();
            System.out.println("Histogram");
            System.out.println("1  - 10  | " + numbersToStars(getInterval(integers, 1, 10)));
            System.out.println("11 - 20  | " + numbersToStars(getInterval(integers, 11, 20)));
            System.out.println("21 - 30  | " + numbersToStars(getInterval(integers, 21, 30)));
            System.out.println("31 - 40  | " + numbersToStars(getInterval(integers, 31, 40)));
            System.out.println("41 - 50  | " + numbersToStars(getInterval(integers, 41, 50)));
            System.out.println("51 - 60  | " + numbersToStars(getInterval(integers, 51, 60)));
            System.out.println("61 - 70  | " + numbersToStars(getInterval(integers, 61, 70)));
            System.out.println("71 - 80  | " + numbersToStars(getInterval(integers, 71, 80)));
            System.out.println("81 - 90  | " + numbersToStars(getInterval(integers, 81, 90)));
            System.out.println("91 - 100 | " + numbersToStars(getInterval(integers, 91, 100)));
            System.out.println("101 - 200| " + numbersToStars(getInterval(integers, 101, 200)));
        }
        catch(FileNotFoundException e) {
            System.out.println("You suck! File was not found.");
            System.exit(1);
        }
        catch(Exception e) {
            System.out.println("An unexpected error occurred. Probably your fault.");
            System.exit(1);
        }
    }

    // Receives a list of integers, a minimum and a maximum. Determines the number of integers in the list that fall
    // between the min and the max
    private static int getInterval(List<Integer> integers, int min, int max) {
        int result = 0;
        for(int integer : integers) {
            if(integer >= min && integer <= max) {
                result++;
            }
        }
        return result;
    }

    // Receives an integer and returns that number of stars (*) as a string
    private static String numbersToStars(int number) {
        StringBuilder stars = new StringBuilder();
        for(int i = 0; i < number; i++) {
            stars.append("*");
        }
        return stars.toString();
    }
}
