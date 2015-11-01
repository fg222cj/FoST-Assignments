package exercise5;

/**
 * Created by Fabian Gillholm on 2015-11-01.
 */
public interface WordSet extends Iterable {
    public void add(Word word); // Add word if not already added
    public boolean contains(Word word); // Return true if word contained
    public int size(); // Return current set size
    public String toString(); // Print contained words
}
