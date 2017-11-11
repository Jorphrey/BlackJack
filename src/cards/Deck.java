package cards;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Deck {
    private Random random;
    private Card[] deck;
    private List<Card> tempDeck;

    public Deck() {
        deck = new Card[52];
        random = new Random();
        tempDeck = new LinkedList<>();

        int i = 0;
        for (Suit suit : Suit.values()) {
            for (CardValue cardValue : CardValue.values()) {
                deck[i] = new Card(suit, cardValue);
                tempDeck.add(new Card(suit, cardValue));
                i++;
            }
        }
    }

    public Card[] getDeck() {
        return deck;
    }

    public void shuffle() {
        Card card;
        int tempSize = tempDeck.size();
        for (int i = 0; i < tempSize; i++) {
            card = tempDeck.get(random.nextInt(tempDeck.size()));
            deck[i] = card;
            tempDeck.remove(card);
        }
    }

    public void printDeck() {
        for (Card card : deck) {
            System.out.println(card);
        }
    }
}