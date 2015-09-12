package arrays;

import java.util.Random;

/**
 * Created by Fabian Gillholm on 2015-09-07.
 */
public class Arrays {

    public static int sum(int[] arr) {
        int sum = 0;
        // Loop through the array, adding each number to sum
        for(int add : arr) {
            sum += add;
        }
        return sum;
    }

    public static String toString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        // Add a nice bracket to the start of the string
        sb.append('[');

        // Loop through the array, adding each number to the stringbuilder object
        for(int i = 0; i < arr.length; i++) {
            // If this is not the first number in the array, separate it from the previous one with a comma and a space
            if(i != 0) {
                sb.append(", ");
            }
            sb.append(arr[i]);
        }

        // Add a nice bracket to the end of the string
        sb.append(']');
        return sb.toString();
    }

    public static int[] addN(int[] arr, int n) {
        // Loop through the array, adding n to each element
        for(int i = 0; i < arr.length; i++) {
            arr[i] += n;
        }
        return arr;
    }

    public static int[] reverse(int[] arr) {
        int[] rra = new int[arr.length];
        int j = 0;

        // Loop backwards through the array while looping forward through the new array, adding each element in turn
        for(int i = arr.length - 1; i >= 0; i--) {
            rra[j] = arr[i];
            j++;
        }
        return rra;
    }

    public static void replaceAll(int[] arr, int old, int nw) {
        // Loop through the array, replacing any element that matches old with nw
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == old) {
                arr[i] = nw;
            }
        }
    }

    public static int[] sort(int[] arr) {
        // Clone the array and sort it
        int[] arrSorted = arr.clone();
        // This is much, much worse than just using java.util.Arrays.sort(), but since you want to encourage us to
        // implement a custom sorting algorithm, here you go
        bogoSort(arrSorted);
        return arrSorted;
    }

    public static boolean hasSubsequence(int[] arr, int[] sub) {
        boolean exists = false;

        // Loop through the array. If the first element of the subsequence is matched, loop through the subsequence to
        // determine if the rest matches as well. In that case, break and return true
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == sub[0]) {
                exists = true;
                for(int j = 0; j < sub.length; j++) {
                    if(arr[i+j] != sub[j]) {
                        exists = false;
                    }
                }
                if(exists == true) {
                    break;
                }
            }
        }

        return exists;
    }

    public static int[] absDif(int[] arr1, int[] arr2) {
        // Make sure the array sizes match
        if(arr1.length != arr2.length) {
            throw new IllegalArgumentException("User is stupid");
        }
        int[] arrDiff = new int[arr1.length];
        // Loop through the array, subtracting an element in arr2 from the corresponding element in arr1 and turning the
        // result into a positive integer (even if it already is)
        for(int i = 0; i < arr1.length; i++) {
            arrDiff[i] = Math.abs(arr1[i] - arr2[i]);
        }
        return arrDiff;
    }


    // Bogosort. Shuffles the array randomly until it is sorted
    public static int[] bogoSort(int[] arr) {
        while(!isSorted(arr)) {
            shuffleArray(arr);
        }
        return arr;
    }

    public static boolean isSorted(int[] arr) {
        for(int i = 0; i < arr.length-1; i ++) {
            if (arr[i+1] < arr[i]) {
                return false;
            }
        }
        return true;
    }

    static void shuffleArray(int[] arr)
    {
        Random random = new Random();
        for (int i = arr.length - 1; i > 0; i--)
        {
            int index = random.nextInt(i + 1);
            int a = arr[index];
            arr[index] = arr[i];
            arr[i] = a;
        }
    }
}