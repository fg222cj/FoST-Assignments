package largestk;
import assignmentframework.Interaction;
import assignmentframework.Validation;

/**
 * Created by Foss on 2015-09-04.
 */
public class LargestK {
    public static void main(String[] args) {
        int N = Interaction.getPositiveInteger("Please enter a positive integer:");
        int K = 0;
        int sum = 0;

        // Add 2 to K and add it to sum until sum is greater than N
        for(int i = 0; sum <= N; i += 2) {
            sum += i;
            K = i;
        }

        // K will be too big, subtract it by 2 to get it just right
        K -= 2;

        System.out.println("N: " + N);
        System.out.println("Largest K: " + K);
    }
}
