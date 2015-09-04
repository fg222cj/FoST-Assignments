package assignmentframework;

/**
 * Created by Foss on 2015-09-04.
 */
public class Validation {
    public static boolean validatePositiveInteger(int i) {
        if(i >= 0) {
            return true;
        }
        return false;
    }
}
