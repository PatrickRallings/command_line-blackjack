import java.util.Scanner;

public class Main {

    public static Game game;
    public static Visuals v = new Visuals();
    public static Menu menu;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        v.welcome();
        game = new Game();
        System.out.println("What is your name?");
        System.out.println(game.setCurrentPlayer(scanner.nextLine()));
        menu = new Menu(game);
        mainMenu();
    }
    public static void mainMenu(){
        while (true) {
            System.out.println(menu.getMainMenu());
            switch (scanner.nextLine().toLowerCase()) {
                case "1":
                    game.currentPlayer.addChips();
                    break;
                case "2":
                    if (game.currentPlayer.getChipCount() >= 5) {
                        round();
                    } else {
                        System.out.println("You need at least 5 chips to play.");
                        System.out.println("Error: Please enter your response again.");
                        break;
                    }
                    break;
                case "3":
                    break;
                default:
                    System.out.println("Error: Please enter your response again.");
                    break;
            }
        }
    }
    public static void round(){
        while (true){
            if (game.currentPlayer.getChipCount() < 5) {
                System.out.println("Please add more chips to continue playing.");
                break;
            }
            System.out.println("How many chips would you like to bet this round?");
            int num = Integer.parseInt(scanner.nextLine());
            if (game.currentPlayer.getChipCount() < num){
                System.out.println("Please add more chips to cover this amount.");
                break;
            }
            game.newRound(num);
            System.out.println(menu.getPostRoundMenu());
            String s = scanner.nextLine();
            if (s.equalsIgnoreCase("1")){
                break;
            }
        }
    }
}