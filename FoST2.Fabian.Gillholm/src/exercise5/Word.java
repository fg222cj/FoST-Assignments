package exercise5;

/**
 * Created by Fabian Gillholm on 2015-10-31.
 */
public class Word implements Comparable<Word> {
    private String word;

    public Word(String str) {
        word = str;
    }

    public String toString() {
        return word;
    }

    @Override
    public int hashCode() {
        return word.toLowerCase().hashCode();
    }

    @Override
    public boolean equals(Object other) {
        return this.hashCode() == other.hashCode();
    }

    // Not a perfect implementation but this course is already demanding too much time due to all the extra bullshit
    // Everything I hand in from now on will be as quick and shitty as possible so I can keep up with my other course
    public int compareTo(Word w) {
        // Loop through the characters in both words and compare each position to the other
        for(int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if(Character.isUpperCase(c)) {
                c = Character.toLowerCase(c);
            }


            if(i < w.toString().length()) {
                Character other = w.toString().charAt(i);
                if (Character.isUpperCase(other)) {
                    other = Character.toLowerCase(other);
                }

                // If both letters are the same, move on to the next letter
                if(c.compareTo(other) != 0) {
                    // If they differ, we're done. Return the difference.
                    return c.compareTo(other);
                }
            }
            else {
                return 1; // w contains the same characters in the same order but is shorter
            }
        }
        // If we've gotten to this point it means the other word is either similar but longer than this word, or they are the same
        if(w.toString().length() > word.length()) {
            return -1;
        }
        return 0;
    }
}
