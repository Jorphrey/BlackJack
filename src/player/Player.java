package player;

import cards.Card;

import java.util.LinkedList;
import java.util.List;

public class Player {
    private String name;
    private Hand hand;
    private Hand splitHand;
    private int money;

    public Player(String name){
        this.name = name;
        hand = new Hand();
        splitHand = new Hand();
        money = 100;
    }


    public String getFormattedName() {
        String formattedName = "";
        int namelength = Math.round((19 - name.length())/2);

        for(int i = 0; i < 19; i++){
            if(i < namelength || i > (name.length() + namelength)){
                formattedName += " ";

            }else {
                formattedName += name.substring(0, Math.min(name.length(), 18));
                i = name.length() + i;
            }
        }
        return formattedName;
    }

    public String getName(){
        return name;
    }

    public Hand getHand() {
        return hand;
    }
    public void setHand(Hand hand){
        this.hand = hand;
    }

    public void setMoney(int pot){
        money += pot;
    }

    public int getMoney(){
        return money;
    }

    public void setSplitHand(Hand hand){
        this.splitHand = hand;
    }

    public Hand getSplitHand(){
        return splitHand;
    }

}
