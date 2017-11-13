package player;

import cards.Card;
import cards.CardValue;

import java.util.LinkedList;
import java.util.List;

public class Hand {
    private List<Card> hand;
    private int points;
    private boolean hit;
    private int bet;

    public Hand() {
        points = 0;
        hand = new LinkedList<>();
        hit = true;
        bet = 0;
    }

    public List<Card> getCards() {
        return hand;
    }

    public void setHand(Card card) {
        hand.add(card);
        if(hand.size() == 1 && hand.get(0).getCardValue().getValue() == 10 && card.getCardValue().equals(CardValue.ACE)) {
            points = 21;
        }if(points < 21 && card.getCardValue().equals(CardValue.ACE)){
            points += 11;
        } else {
            points += card.getCardValue().getValue();
        }
    }

    public String printPoints() {
       return String.format("%1$2s", Integer.toString(points));
    }

    public int getPoints(){
        return points;
    }

    public void setPoints(int points) {
       this.points = points;
        }

    public void clearHand(){
        hand.clear();
    }

    public void printHand(){
        for(Card card : hand){
            System.out.println(card);
        }
    }

    public void setHit(boolean hit){
        this.hit = false;
    }

    public boolean getHit(){
        return hit;
    }

    public void setBet(int bet){
        this.bet = bet;
    }

    public int getBet(){
        return bet;
    }

}
