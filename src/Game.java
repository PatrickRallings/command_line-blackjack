import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private ArrayList<Player> playerProfiles = new ArrayList<>();
    public ArrayList<Round> roundHistory = new ArrayList<Round>();
    private final Deck deck;
    public Round currentRound;
    public Player currentPlayer;
    public Scanner scan = new Scanner(System.in);
    public Menu menu;

    public Game (){
        deck = new Deck();
    }

    public String setCurrentPlayer(String name){
        boolean check = false;
        String output = "";
        for (int i = 0; i <= playerProfiles.size()-1; i++){
            check = playerProfiles.get(i).getName().equalsIgnoreCase(name);
            if (check) {
                currentPlayer = playerProfiles.get(i);
                output = "Welcome back, "+currentPlayer.getName()+".";
            }
        }
        if (!check) {
            playerProfiles.add(new Player (name));
            currentPlayer = playerProfiles.get(playerProfiles.size()-1);
            output = "Welcome, "+currentPlayer.getName()+", a new profile has been created for you.";
        }
        return output;
    }

    public void newRound(int bet) {
        roundHistory.add(new Round(currentPlayer, bet, deck));
        currentRound = roundHistory.get(roundHistory.size() - 1);
        currentRound.roundStatus = "";
        currentRound.ongoingRound();
        if (currentRound.roundStatus.equalsIgnoreCase("lost")){
            currentPlayer.lostChips(currentRound.getBet());
        } else if (currentRound.roundStatus.equalsIgnoreCase("won")){
            currentPlayer.wonChips(currentRound.getBet());
        }
    }

}
