package game123;

import deck.Card;
import deck.Deck;

/**
 * Created by Fabian Gillholm on 2015-09-12.
 */
public class Game123 {
    public boolean play() {
        Deck deck = new Deck();
        deck.shuffle();

        int i = 1;
        while(deck.deckSize() > 0) {
            Card card = deck.handOutNextCard();
            switch(i % 3) {
                case 1:
                    if(card.getRank() == Card.Rank.Ace) {
                        return false;
                    }
                    break;

                case 2:
                    if(card.getRank() == Card.Rank.Two) {
                        return false;
                    }
                    break;

                case 0:
                    if(card.getRank() == Card.Rank.Three) {
                        return false;
                    }
                    break;
            }
            i++;
        }
        return true;
    }
}