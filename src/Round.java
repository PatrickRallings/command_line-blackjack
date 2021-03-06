import java.util.ArrayList;

public class Round {
    public Player currentPlayer;
    public int bet;
    private Deck deck;
    private ArrayList<String> dealerHand;
    public ArrayList<String[]> dealerHandArray;
    public ArrayList<String[]> playerHandArray;
    private ArrayList<String> playerHand;
    private int dealerHandValue = 0;
    private int playerHandValue = 0;
    private int dealerAceCount = 0;
    private int playerAceCount = 0;
    public String roundStatus;
    public HandVisual playerHandVisual;
    public HiddenHandVisual hiddenDealerVisual;
    public HandVisual dealerHandVisual;

    TextVisual v;

    public Round(Player currentPlayer,int bet, Deck deck) {
        this.currentPlayer = currentPlayer;
        this.dealerHand = new ArrayList<>();
        this.playerHand = new ArrayList<>();
        this.dealerHandArray = new ArrayList<>();
        this.playerHandArray = new ArrayList<>();
        v = new TextVisual();
        this.deck = deck;
        this.bet = bet;
        dealPlayerCard();
        dealDealerCard();
        dealPlayerCard();
        dealDealerCard();
    }

    public ArrayList<String[]> getDealerHandArray() {
        return dealerHandArray;
    }
    public ArrayList<String[]> getPlayerHandArray() {
        return playerHandArray;
    }

    private void dealDealerCard() {
        dealerHand.add(deck.getCurrentCard());
        dealerHandArray.add(deck.getCurrentCardArray());
        updateDealerHandValue();
        deck.nextCardArray();
    }

    public void dealPlayerCard() {
        playerHand.add(deck.getCurrentCard());
        playerHandArray.add(deck.getCurrentCardArray());
        updatePlayerHandValue();
        deck.nextCardArray();
    }

    public String showCards(String overload) {
        playerHandVisual = new HandVisual(getPlayerHandArray());
        dealerHandVisual = new HandVisual(getDealerHandArray());
        hiddenDealerVisual = new HiddenHandVisual(getDealerHandArray());
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
//        +hand.toString()+"\n"
        return v.dealer()+"\n"+dealerHandVisual.getOutput()+"\n"+v.you()+"\n"+playerHandVisual.getOutput();
    }
    public String showCards() {
        playerHandVisual = new HandVisual(getPlayerHandArray());
        dealerHandVisual = new HandVisual(getDealerHandArray());
        hiddenDealerVisual = new HiddenHandVisual(getDealerHandArray());
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
        return v.dealer()+"\n"+hiddenDealerVisual.getOutput()+"\n"+v.you()+"\n"+playerHandVisual.getOutput();
    }

    public void updateDealerHandValue() {
        if (deck.getCurrentCardValue().equalsIgnoreCase("")) {
            dealerAceCount++;
            dealerHandValue += 11;
            while (dealerHandValue > 21 && dealerAceCount > 0) {
                dealerAceCount--;
                dealerHandValue -= 10;
                if (dealerHandValue <= 21) {
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
            while (playerHandValue > 21 && playerAceCount > 0) {
                playerAceCount--;
                playerHandValue -= 10;
                if (playerHandValue <= 21) {
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
//            System.out.println(getDealerHand());
//            System.out.println("Dealer wins with 21");
            roundStatus = "lost";
        } else {
            while (true) {
                System.out.println(showCards());
                if (dealCount == 0){
                    System.out.println(v.hit_stay_doubleDown());
                } else {
                    System.out.println(v.hit_stay());
                }

                String s = Main.scanner.nextLine();
                if (s.equalsIgnoreCase("double down") && dealCount == 0){
                    dealPlayerCard();
                    if (playerHandValue > 21){
                        System.out.println(showCards());
//                        System.out.println("Sorry, you busted.");
                        roundStatus = "lostdouble";
                        break;
                    } else {
                        dealerPlayOut();
                        System.out.println(showCards());
//                        System.out.println(getDealerHand());
                        if ((playerHandValue == 21) && dealerHandValue != 21) {
//                            System.out.println("You won with 21 on a double down!");
                            roundStatus = "won21double";
                            break;
                        } else if ((dealerHandValue > 21) || (dealerHandValue < playerHandValue && playerHandValue <= 21)) {
//                            System.out.println("You won with a double down!");
                            roundStatus = "wondouble";
                            break;
                        } else if ((dealerHandValue == 21 && playerHandValue == 21)) {
                            System.out.println("Push.");
                            roundStatus = "push";
                            break;
                        }  else {
//                            System.out.println("Sorry, you lost on a double down.");
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
                    System.out.println(showCards("overload"));
//                    System.out.println(getDealerHand());
                    if ((playerHandValue == 21) && dealerHandValue != 21) {
                        System.out.println("You won with 21!");
                        roundStatus = "won21";
                        break;
                    } else if ((dealerHandValue > 21) || (dealerHandValue < playerHandValue && playerHandValue <= 21)) {
//                        System.out.println("You won!");
                        roundStatus = "won";
                        break;
                    } else if ((dealerHandValue == playerHandValue)) {
//                        System.out.println("Push.");
                        roundStatus = "push";
                        break;
                    }  else {
//                        System.out.println("Sorry, you lost.");
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
