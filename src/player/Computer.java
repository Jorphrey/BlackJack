package player;

public class Computer {
    private String name;
    private Hand hand;

    public Computer(){
        this.name = "Computer";
        hand = new Hand();
    }


    public String getName() {
        return name;
    }

    public Hand getHand() {
        return hand;
    }

}
