import java.util.ArrayList;

public class HandVisual {
    ArrayList<String[]> hand;
    String top;
    String blank;
    String middle;
    String bottom;
    String output;
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_RESET = "\u001B[0m";

    public HandVisual(ArrayList<String[]> hand){
        this.hand = hand;
        setTop();
        setBlank();
        setMiddle();
        setBottom();
        setOutput();
    }
    public void setTop(){
        top = ANSI_GREEN_BACKGROUND+"        D E A L E R' S  H A N D      "+ANSI_RESET+"\n"+ANSI_GREEN_BACKGROUND+"       ";
        for (int i = 0; i < hand.size(); i++) {
            top += CardVisual.getFlippedTop(hand.get(i)[3], hand.get(i)[1])+ANSI_GREEN_BACKGROUND+"     "+ANSI_RESET;
        }
        top += "\n";
    }
    public void setBlank(){
        blank = ANSI_GREEN_BACKGROUND+"       "+ANSI_RESET;
        for (int i = 0; i < hand.size(); i++) {
            blank += CardVisual.getFlippedBlank(hand.get(i)[1])+ANSI_GREEN_BACKGROUND+"     "+ANSI_RESET;
        }
        blank += "\n";
    }
    public void setMiddle(){
        middle = ANSI_GREEN_BACKGROUND+"       "+ANSI_RESET;
        for (int i = 0; i < hand.size(); i++) {
            middle += CardVisual.getFlippedMiddle(hand.get(i)[1])+ANSI_GREEN_BACKGROUND+"     "+ANSI_RESET;
        }
        middle += "\n";
    }
    public void setBottom(){
        bottom = ANSI_GREEN_BACKGROUND+"       "+ANSI_RESET;
        for (int i = 0; i < hand.size(); i++) {
            bottom += CardVisual.getFlippedBottom(hand.get(i)[3], hand.get(i)[1])+ANSI_GREEN_BACKGROUND+"     "+ANSI_RESET;
        }
        bottom += "\n"+ANSI_GREEN_BACKGROUND+"                                     "+ANSI_RESET;
    }
    public void setOutput(){
        output = top+blank+middle+blank+bottom;
    }
    public String getOutput(){
        return output;
    }
}
