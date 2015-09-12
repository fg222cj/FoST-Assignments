package deck;

/**
 * Created by Fabian Gillholm on 2015-09-12.
 */
public class Card {
    private Suite suite;
    private Rank rank;

    public Card(Suite suite, Rank rank) {
        this.suite = suite;
        this.rank = rank;
    }

    public Suite getSuite() {
        return this.suite;
    }

    public Rank getRank() {
        return this.rank;
    }

    public String toString() {
        return getRank() + " of " + getSuite();
    }

    public enum Suite {
        Hearts,
        Clubs,
        Spades,
        Diamonds
    }

    public enum Rank {
        Ace,
        Two,
        Three,
        Four,
        Five,
        Six,
        Seven,
        Eight,
        Nine,
        Ten,
        Jack,
        Queen,
        King
    }
}
