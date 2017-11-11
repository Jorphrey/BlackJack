import cards.Card;
import cards.Deck;
import player.Computer;
import player.Player;

import java.util.Scanner;

//TODO add money to player.
//TODO make sure player hand  and computer hand clears after each round and the deck is reset
//TODO ask if player wants to continue or cash out
//TODO testing to make sure ace works
//TODO check blackjack rules to make sure everything is correct

public class Game {

    private Player player;
    private Computer computer;
    int cardNumber;
    Card[] cards;

    public Game() {

    }

    public void begin() {
        player = new Player("Jeffrey");
        computer = new Computer();
        Deck deck = new Deck();
        deck.shuffle();
        cards = deck.getDeck();
        cardNumber = 0;

        Deal();
        playerTurn();
        computerTurn();
    }

    public void Deal() {
        player.getHand().setHand(cards[cardNumber]);
        cardNumber++;
        computer.getHand().setHand(cards[cardNumber]);
        cardNumber++;
    }

    public void playerTurn() {
        Scanner scanner = new Scanner(System.in);
        while (player.getHand().getHit()) {
            player.getHand().printHand();
            System.out.println("You have " + player.getHand().getPoints() + " points.");

            while (true) {
                System.out.println("Please type hit or stand: ");
                String play = scanner.nextLine();
                if (!play.toLowerCase().equals("hit") && !play.toLowerCase().equals("h") &&
                        !play.toLowerCase().equals("s") && !play.toLowerCase().equals("stand")) {
                    System.out.println("I don't understand.  Please enter again.");
                } else if (play.toLowerCase().equals("h") || play.toLowerCase().equals("hit")) {
                    System.out.println("You hit");
                    player.getHand().setHand(cards[cardNumber]);
                    System.out.println(cards[cardNumber]);
                    System.out.println(player.getHand().getPoints());
                    cardNumber++;
                    if (player.getHand().getPoints() > 21) {
                        System.out.println("You're over, you lose;");
                        computerTurn();
                    }

                } else {
                    System.out.println("You stand");
                    computerTurn();
                }
            }
        }
    }

    public void computerTurn() {
        while (computer.getHand().getPoints() < 17) {
            System.out.println(computer.getHand().getPoints());
            System.out.println(cards[cardNumber]);
            computer.getHand().setHand(cards[cardNumber]);
            cardNumber++;
        }
        winner();

    }

    public void winner() {
        System.out.println("Final Scores: ");
        System.out.println("You: " + player.getHand().getPoints());
        System.out.println("Computer: " + computer.getHand().getPoints());
        if(computer.getHand().getPoints() > 21){
            System.out.println("You win!");
        }else if (player.getHand().getPoints() > computer.getHand().getPoints()) {
            System.out.println("You win!");
        } else if (player.getHand().getPoints() == computer.getHand().getPoints()) {
            System.out.println("You tied.  No winner.");
        }else {
            System.out.println("You lose.");
        }
        begin();
    }

}


