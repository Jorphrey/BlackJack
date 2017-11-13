import cards.Card;
import cards.Deck;
import player.Computer;
import player.Hand;
import player.Player;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

//TODO add money to player.
//TODO make sure player hand  and computer hand clears after each round and the deck is reset
//TODO ask if player wants to continue or cash out
//TODO testing to make sure ace works
//TODO check blackjack rules to make sure everything is correct

public class Game {
    private Scanner scanner;
    private Player player;
    private Computer computer;
    int cardNumber;
    Card[] cards;
    StringFormatter stringFormatter;

    public Game() {

    }

    public void begin() {
        stringFormatter = new StringFormatter();
        scanner = new Scanner(System.in);
        System.out.print("Please enter your name: ");
        player = new Player(scanner.nextLine());
        computer = new Computer();
        deal();
    }

    public void deal() {
        player.setHand(new Hand());
        computer.setHand(new Hand());
        Deck deck = new Deck();
        cards = deck.getDeck();
        cardNumber = 0;
        deck.shuffle();
        bet();
        player.getHand().setHand(cards[cardNumber]);
        cardNumber++;
        computer.getHand().setHand(cards[cardNumber]);
        cardNumber++;
        update();
        playerTurn();
        computerTurn();
    }

    public void update() {
        System.out.println("Money: " + player.getMoney() + "           Bet: " + player.getHand().getBet());
        System.out.println("---------------------------------------");
        System.out.println("|" + stringFormatter.formatString(player.getName()) + "|      Dealer      |");
        System.out.println("---------------------------------------");

        if (computer.getComputersTurn()) {
            System.out.println("|       " + player.getHand().printPoints() + "         |        " +
                    computer.getHand().printPoints() + "        |");
        } else {
            System.out.println("|        " + player.getHand().printPoints() + "        |        " +
                    "--        |");


        }
        printCardsInHand();
        System.out.println("---------------------------------------");
    }

    public void printCardsInHand() {

        Iterator<Card> p = player.getHand().getCards().iterator();
        Iterator<Card> c = computer.getHand().getCards().iterator();
        System.out.println("---------------------------------------");
        if (computer.getComputersTurn()) {
            while (p.hasNext() && c.hasNext()) {
                System.out.println("|" + stringFormatter.formatString(p.next().toString()) + "|" +
                        stringFormatter.formatString(c.next().toString()) + "|");
            }
            while (p.hasNext()) {
                System.out.println("|" + stringFormatter.formatString(p.next().toString()) + "|" +
                        stringFormatter.formatString("") + "|");
            }
            while (c.hasNext()) {
                System.out.println("|" + stringFormatter.formatString("") + "|" +
                        stringFormatter.formatString(c.next().toString()) + "|");
            }
        } else {
            Iterator<Card> pl = player.getHand().getCards().iterator();
            while (pl.hasNext()) {
                System.out.println("|" + stringFormatter.formatString(pl.next().toString()) + "|" +
                        stringFormatter.formatString("") + "|");
            }
        }
    }

    public void bet() {
        int bet = 0;
        System.out.print("You have " + player.getMoney());
        if (player.getMoney() == 1) {
            System.out.print(" dollar.");
        } else {
            System.out.println(" dollars.");
        }
        while (true) {
            try {
                System.out.print("How much would you like to bet?: ");
                bet = Integer.parseInt(scanner.nextLine());
                System.out.println();
                player.getHand().setBet(bet);
                player.setMoney(-bet);
                return;
            } catch (Exception e) {
                System.out.println("Invalid amount.");
            }
        }
    }

    public void split(){
        //TODO
        //player.setSplitHand(player.getHand().setHand(player.getHand().getCards().get(1));
    }


    public void playerTurn() {
        while (true) {

            System.out.print("Please type hit or stand: ");
            String play = scanner.nextLine();
            if (!play.toLowerCase().equals("hit") && !play.toLowerCase().equals("h") &&
                    !play.toLowerCase().equals("s") && !play.toLowerCase().equals("stand")) {
                System.out.println("I don't understand.  Please enter again.");
            } else if (play.toLowerCase().equals("h") || play.toLowerCase().equals("hit")) {
                player.getHand().setHand(cards[cardNumber]);
                update();

                cardNumber++;
                if (player.getHand().getPoints() > 21) {
                    computerTurn();
                }

            } else {
                computerTurn();
            }

        }
    }

    public void computerTurn() {
        computer.setComputersTurn(true);
        while (computer.getHand().getPoints() < 17) {
            computer.getHand().setHand(cards[cardNumber]);
            update();
            cardNumber++;
        }
        winner();

    }

    public void winner() {
        if (computer.getHand().getPoints() > 21 && player.getHand().getPoints() <= 21) {
            System.out.println("You win!");
            player.setMoney(player.getHand().getBet() * 2);
            System.out.println("Money: " + player.getMoney());
        } else if (player.getHand().getPoints() > computer.getHand().getPoints() && player.getHand().getPoints() <= 21) {
            System.out.println("You win!");
            player.setMoney(player.getHand().getBet() * 2);
            System.out.println("Money: " + player.getMoney());

        } else if (player.getHand().getPoints() == computer.getHand().getPoints()) {
            System.out.println("You tied.  No winner.");
            System.out.println("Money: " + player.getMoney());

        } else {
            System.out.println("You lose.");
            System.out.println("Money: " + player.getMoney());

        }

        System.out.print("\nWould you like to play another hand? Y or N:");
        String continueOrCashout;
        while (true) {
            continueOrCashout = scanner.nextLine().toLowerCase();
            if (continueOrCashout.equals("y") || continueOrCashout.equals("yes")) {
                deal();
            } else if (continueOrCashout.equals("n") || continueOrCashout.equals("no")) {
                System.exit(0);
            } else {
                System.out.print("I do not understand, please answer. Y or N: ");
            }
        }


    }

}


