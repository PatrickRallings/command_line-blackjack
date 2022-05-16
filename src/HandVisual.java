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
    }
    public void setTop(){
        top = "";
        for (int i = 0; i < hand.size(); i++) {
            top += CardVisual.getFlippedTop(hand.get(i)[3])+"     ";
        }
        top += "\n";
    }
    public void setBlank(){
        blank = "";
        for (int i = 0; i < hand.size(); i++) {
            blank += CardVisual.getFlippedBlank()+"     ";
        }
        blank += "\n";
    }
    public void setMiddle(){
        middle = "";
        for (int i = 0; i < hand.size(); i++) {
            middle += CardVisual.getFlippedMiddle(hand.get(i)[1])+"     ";
        }
        middle += "\n";
    }
    public void setBottom(){
        bottom = "";
        for (int i = 0; i < hand.size(); i++) {
            bottom += CardVisual.getFlippedBottom(hand.get(i)[3])+"     ";
        }
        bottom += "\n";
    }
    public void setOutput(){
        output = top+blank+middle+blank+bottom;
    }
    public String getOutput(){
        return output;
    }
}
