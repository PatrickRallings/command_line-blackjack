import java.util.Scanner;

public class Menu {
    private final Game game;


    public Menu(Game game){
        this.game = game;
    }

    public String getMainMenu(){
        return (
                "Profile: "+game.currentPlayer.getName()+"\n" +
                "Chip Count: "+game.currentPlayer.getChipCount()+ "\n\n" +
                "Main Menu (Select an Option)\n" +
                "1: Add more chips\n" +
                "2: Play BlackJack\n" +
                "3: Exit"
                );
    }
    public String getPostRoundMenu(){
        return (
                game.currentPlayer.getName() + ", you now have "+game.currentPlayer.getChipCount()+ " chips.\n" +
                "Would you like to: (Select an Option)\n" +
                "1: Return to Main Menu\n" +
                "2: Play another round\n"
        );
    }
}
