public class Test {
    public static void main(String[] args) {
        Player p = new Player("Patrick");
        Deck d = new Deck();
        Round r = new Round(p, 500, d);
        HandVisual hv = new HandVisual(r.getDealerHandArray());
        System.out.println(hv.getOutput());

    }
}
