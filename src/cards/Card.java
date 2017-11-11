package cards;

import java.util.Objects;

public class Card {
    private Suit suit;
    private CardValue cardValue;

    public Card(Suit suit, CardValue cardValue){
        this.suit = suit;
        this.cardValue = cardValue;
    }

    public Suit getSuit() {
        return suit;
    }

    public CardValue getCardValue() {
        return cardValue;
    }

    public String toString(){
        return cardValue + " of " + suit;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return getSuit() == card.getSuit() &&
                getCardValue() == card.getCardValue();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getSuit(), getCardValue());
    }
}
