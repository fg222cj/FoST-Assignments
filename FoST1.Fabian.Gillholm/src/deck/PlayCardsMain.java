package deck;

/**
 * Created by Fabian Gillholm on 2015-09-12.
 */
public class PlayCardsMain {
    public static void main(String[] args) {
        Deck deck = new Deck();
        System.out.println("Deck size: " + deck.deckSize());
        deck.shuffle();
        System.out.println("Dealing " + deck.handOutNextCard().toString());
        System.out.println("Deck size: " + deck.deckSize());
        System.out.println("Dealing " + deck.handOutNextCard().toString());
        System.out.println("Dealing " + deck.handOutNextCard().toString());
        System.out.println("Dealing " + deck.handOutNextCard().toString());
        System.out.println("Dealing " + deck.handOutNextCard().toString());
        System.out.println("Deck size: " + deck.deckSize());
    }
}
