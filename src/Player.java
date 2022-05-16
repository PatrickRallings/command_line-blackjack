import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    Scanner scan = new Scanner(System.in);
    public String name;
    private Integer chipCount;



    public Player(String name) {
        this.name = name;
        this.chipCount = 0;
    }

    public void addChips() {
        System.out.println("Please enter how many chips you would like to add:");
        this.chipCount += Integer.parseInt(scan.nextLine());
        System.out.println("Chips added. Returning to Main Menu.");
    }

    public void wonChips(int chips) {
        this.chipCount += chips;
    }
    public void lostChips(int chips) {
        this.chipCount -= chips;

    }

    public String getName() {
        return name;
    }

    public Integer getChipCount() {
        return chipCount;
    }
}
