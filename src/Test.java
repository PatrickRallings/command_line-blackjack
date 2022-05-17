public class Test {
    public static void main(String[] args) {
        Deck d = new Deck();
        Player p = new Player("p");
        Round r = new Round(p, 500, d);
        System.out.println(r.hiddenDealerVisual);

    }
}
