package player;

import cards.Card;

import java.util.LinkedList;
import java.util.List;

public class Hand {
    private List<Card> hand;
    private int points;
    private boolean hit;

    public Hand() {
        points = 0;
        hand = new LinkedList<>();
        hit = true;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void setHand(Card card) {
       hand.add(card);
       points += card.getCardValue().getValue();
    }

    public int getPoints() {
        return points;
    }

//    public void setPoints() {
//        for(Card card : hand){
//           points += card.getCardValue().getValue();
//        }
//    }

    public void clearHand(){
        hand.clear();
    }

    public void printHand(){
        for(Card card : hand){
            System.out.println(card);
        }
    }

    public void setHit(){
        hit = false;
    }

    public boolean getHit(){
        return hit;
    }
}
