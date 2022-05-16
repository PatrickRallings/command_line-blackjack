import java.util.ArrayList;

public class Round {
    public Player currentPlayer;
    public int bet;
    private Deck deck;
    private ArrayList<String> dealerHand;
    private ArrayList<String> playerHand;
    private int dealerHandValue = 0;
    private int playerHandValue = 0;
    private int dealerAceCount = 0;
    private int playerAceCount = 0;
    public String roundStatus;

    public Round(Player currentPlayer,int bet, Deck deck) {
        this.currentPlayer = currentPlayer;
        this.dealerHand = new ArrayList<>();
        this.playerHand = new ArrayList<>();
        this.deck = deck;
        this.bet = bet;
        dealPlayerCard();
        dealDealerCard();
        dealPlayerCard();
        dealDealerCard();
    }


    private void dealDealerCard() {
        dealerHand.add(deck.getCurrentCard());
        updateDealerHandValue();
        deck.nextCardArray();
    }

    public void dealPlayerCard() {
        playerHand.add(deck.getCurrentCard());
        updatePlayerHandValue();
        deck.nextCardArray();
    }

    public String showCards() {
        String hand = "The dealer's face-up card is: " + dealerHand.get(1) + "\nYour cards: | ";
        for (int i = 0; i < this.playerHand.size(); i++) {
            hand += (playerHand.get(i)) + " | ";
        }
        hand += "You hand's value is currently: " + String.valueOf(this.playerHandValue);
        if (this.playerHandValue > 21){
            hand += "\nYOU LOST THE ROUND.";
        } else {
            hand += "\nPlease enter either hit or stay:";
        }
        return hand.toString();
    }

    public String getDealerHand() {
        String hand = "The dealer cards: | ";
        for (int i = 0; i < this.dealerHand.size(); i++) {
            hand += (dealerHand.get(i)) + " | ";
        }
        hand += "Their hand's final value is: " + String.valueOf(this.dealerHandValue);
        return hand.toString();
    }

    public void updateDealerHandValue() {
        if (deck.getCurrentCardValue().equalsIgnoreCase("")) {
            dealerAceCount++;
            dealerHandValue += 11;
            int tempNum = 0;
            while (dealerHandValue > 21) {
                tempNum++;
                dealerHandValue -= 10;
                if (dealerHandValue <= 21 || tempNum == dealerAceCount) {
                    break;
                }
            }
        } else {
            dealerHandValue += Integer.parseInt(deck.getCurrentCardValue());
        }
    }

    public void updatePlayerHandValue() {
        if (deck.getCurrentCardValue().equalsIgnoreCase("")) {
            playerAceCount++;
            playerHandValue += 11;
            int tempNum = 0;
            while (playerHandValue > 21) {
                tempNum++;
                playerHandValue -= 10;
                if (playerHandValue <= 21 || tempNum == playerAceCount) {
                    break;
                }
            }
        } else {
            playerHandValue += Integer.parseInt(deck.getCurrentCardValue());
        }
    }

    public void dealerPlayOut(){
        while (true){
            if (dealerHandValue < 17){
                dealDealerCard();
            } else { break; }
        }
    }

    public String ongoingRound(){
        int dealCount = 0;
        if (dealerHandValue == 21) {
            System.out.println(showCards());
            System.out.println(getDealerHand());
            System.out.println("Dealer wins with 21");
            roundStatus = "lost";
        } else {
            while (true) {
                System.out.println(showCards());
                System.out.println("Hit | Stay | Double Down");
                String s = Main.scanner.nextLine();
                if (s.equalsIgnoreCase("double down")){
                    dealPlayerCard();
                    if (playerHandValue > 21){
                        System.out.println(showCards());
                        System.out.println("Sorry, you busted.");
                        roundStatus = "lostdouble";
                        break;
                    } else {
                        dealerPlayOut();
                        System.out.println(showCards());
                        System.out.println(getDealerHand());
                        if ((playerHandValue == 21) && dealerHandValue != 21) {
                            System.out.println("You won with 21 on a double down!");
                            roundStatus = "won21double";
                            break;
                        } else if ((dealerHandValue > 21) || (dealerHandValue < playerHandValue && playerHandValue <= 21)) {
                            System.out.println("You won with a double down!");
                            roundStatus = "wondouble";
                            break;
                        } else if ((dealerHandValue == 21 && playerHandValue == 21)) {
                            System.out.println("Push.");
                            roundStatus = "push";
                            break;
                        }  else {
                            System.out.println("Sorry, you lost on a double down.");
                            roundStatus = "lostdouble";
                            break;
                        }
                    }
                }
                if (s.equalsIgnoreCase("hit")) {
                    dealCount++;
                    dealPlayerCard();
                    if (playerHandValue > 21){
                        System.out.println(showCards());
                        System.out.println("Sorry, you busted.");
                        roundStatus = "lost";
                        break;
                    }
                } else {
                    dealerPlayOut();
                    System.out.println(showCards());
                    System.out.println(getDealerHand());
                    if ((playerHandValue == 21) && dealerHandValue != 21) {
                        System.out.println("You won with 21!");
                        roundStatus = "won21";
                        break;
                    } else if ((dealerHandValue > 21) || (dealerHandValue < playerHandValue && playerHandValue <= 21)) {
                        System.out.println("You won!");
                        roundStatus = "won";
                        break;
                    } else if ((dealerHandValue == 21 && playerHandValue == 21)) {
                        System.out.println("Push.");
                        roundStatus = "push";
                        break;
                    }  else {
                        System.out.println("Sorry, you lost.");
                        roundStatus = "lost";
                        break;
                    }
                }
            }

        }
        return roundStatus;
    }
    public int getBet() {
        return bet;
    }
}
