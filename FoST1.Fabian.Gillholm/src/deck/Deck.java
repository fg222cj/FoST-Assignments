package deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Fabian Gillholm on 2015-09-12.
 */
public class Deck {
    List<Card> deck;

    public Deck() {
        this.deck = new ArrayList<Card>();
        for(Card.Suite suite : Card.Suite.values()) {
            for(Card.Rank rank : Card.Rank.values()) {
                this.deck.add(new Card(suite, rank));
            }
        }
    }

    public void shuffle() {
        if(deckSize() == 52) {
            Collections.shuffle(this.deck);
        }
    }

    public Card handOutNextCard() {
        Card card = deck.get(deckSize() - 1);
        deck.remove(deckSize() - 1);
        return card;
    }

    public int deckSize() {
        return this.deck.size();
    }

}

