public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        for (int i = 0; i < 52; i++) {
            deck.setCurrentCardArray(i);
            System.out.println(deck.getCurrentCardValue());
        }

    }
}