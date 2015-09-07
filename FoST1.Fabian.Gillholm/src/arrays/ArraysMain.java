package arrays;

import java.lang.reflect.Array;

/**
 * Created by Foss on 2015-09-07.
 */
public class ArraysMain {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("Adding: " + Arrays.toString(arr));
        System.out.println("Sum: " + Arrays.sum(arr));
        System.out.println();

        System.out.println("Adding 2 to each number in this array: " + Arrays.toString(arr));
        System.out.println("Result: " + Arrays.toString(Arrays.addN(arr, 2)));
        System.out.println();

        System.out.println("Reversing: " + Arrays.toString(arr));
        System.out.println("Reversed: " + Arrays.toString(Arrays.reverse(arr)));
        System.out.println();

        System.out.println("Replacing all 4's with 8's in: " + Arrays.toString(arr));
        Arrays.replaceAll(arr, 4, 8);
        System.out.println("Result: " + Arrays.toString(arr));
        System.out.println();

        System.out.println("Sorting this: " + Arrays.toString(arr));
        System.out.println("Sorted: " + Arrays.toString(Arrays.sort(arr)));
        System.out.println();

        int[] arr1 = {1, 2, 3, 4, 5};
        int[] sub = {2, 3, 4};
        System.out.println("Checking for sequence " + Arrays.toString(sub) + " in " + Arrays.toString(arr1));
        if(Arrays.hasSubsequence(arr1, sub)) {
            System.out.println("Found it!");
        }
        else {
            System.out.println("Didn't find it :(");
        }
        System.out.println();

        int[] arr2 = {1, 1, 1, 1, 1};
        System.out.println("Calculating the difference between elements in " + Arrays.toString(arr1) + " and " + Arrays.toString(arr2));
        try {
            System.out.println("Result: " + Arrays.toString(Arrays.absDif(arr1, arr2)));
        }
        catch(IllegalArgumentException e) {
            System.out.println("You suck! Use arrays of equal sizes!");
        }
    }
}
