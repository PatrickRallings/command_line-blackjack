import java.util.ArrayList;

public class Player {
    public String name;
    private Integer chipCount;
    private String currentHand;

    public Player(String name) {
        this.name = name;
        this.chipCount = 0;
    }

    private void addChips(int chips) {
        this.chipCount += chips;
    }

    private void removeChips(int chips) {
        this.chipCount -= chips;
    }

    public void setCurrentHand(String currentHand) {
        this.currentHand = currentHand;
    }

    public String getCurrentHand() {
        return currentHand;
    }

    public String getName() {
        return name;
    }

    public Integer getChipCount() {
        return chipCount;
    }
}
