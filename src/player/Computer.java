package player;

public class Computer {
    private String name;
    private Hand hand;
    private boolean computersTurn;

    public Computer(){
        this.name = "Computer";
        hand = new Hand();
        computersTurn = false;
    }


    public String getName() {
        return name;
    }

    public Hand getHand() {
        return hand;
    }

    public void setComputersTurn(boolean turn){
        computersTurn = turn;
    }

    public boolean getComputersTurn(){
        return computersTurn;
    }

    public void setHand(Hand hand){
        computersTurn = false;
        this.hand = hand;
    }

}
