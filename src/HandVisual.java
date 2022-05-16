import java.util.ArrayList;

public class HandVisual {
    ArrayList<String[]> hand;
    String top;
    String blank;
    String middle;
    String bottom;
    String output;

    public HandVisual(ArrayList<String[]> hand){
        this.hand = hand;
        setTop();
        setBlank();
        setMiddle();
        setBottom();
        setOutput();
        System.out.println(hand.size());
    }
    public void setTop(){
        top = "";
        for (int i = 0; i < hand.size()-1; i++) {
            top += CardVisual.getFlippedTop(hand.get(i)[3]);
        }
        top += "\n";
    }
    public void setBlank(){
        blank = "";
        for (int i = 0; i < hand.size()-1; i++) {
            blank += CardVisual.getFlippedBlank();
        }
        blank += "\n";
    }
    public void setMiddle(){
        middle = "";
        for (int i = 0; i < hand.size()-1; i++) {
            middle += CardVisual.getFlippedMiddle(hand.get(i)[1]);
        }
        middle += "\n";
    }
    public void setBottom(){
        bottom = "";
        for (int i = 0; i < hand.size()-1; i++) {
            bottom += CardVisual.getFlippedBottom(hand.get(i)[3]);
        }
        bottom += "\n";
    }
    public void setOutput(){
        output = top+blank+middle+blank+bottom;
    }
    public String getOutput(){
        return output;
    }

//    public void createRow(){
//        CardVisual.getFlippedTop()+"\n" +
//                CardVisual.getFlippedBlank()+"\n" +
//                CardVisual.getFlippedMiddle()+"\n" +
//                CardVisual.getFlippedBlank()+"\n" +
//                CardVisual.getFlippedBottom()+"\n";
//    }
}
