import java.util.ArrayList;

public class HandVisual {
    ArrayList<String[]> hand;
    String top;
    String blank;
    String middle;
    String bottom;
    String output;
    String borderOuter;
    String borderInner;
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_RESET = "\u001B[0m";

    public HandVisual(ArrayList<String[]> hand){
        this.hand = hand;
        setBorder();
        setTop();
        setBlank();
        setMiddle();
        setBottom();
        setOutput();
    }

    private void setBorder(){
        borderOuter = ANSI_BLACK_BACKGROUND+ANSI_GREEN+"$$"+ANSI_RESET+ANSI_BLACK_BACKGROUND+ANSI_GREEN+"";
        borderInner = ANSI_BLACK_BACKGROUND+ANSI_GREEN+"$"+ANSI_RESET+ANSI_GREEN_BACKGROUND+"";
        int charCount = ((hand.size())*15)+4;
        for (int i = 0; i <= charCount; i++){
            borderOuter += "$";
            borderInner += " ";
        }
        borderOuter += ANSI_RESET;
        borderInner += ANSI_RESET;
    }

    public void setTop(){
        top = ANSI_GREEN_BACKGROUND+borderOuter+ANSI_RESET+"\n"+borderInner+ANSI_BLACK_BACKGROUND+ANSI_GREEN+"$"+ANSI_RESET+"\n"+ANSI_BLACK_BACKGROUND+ANSI_GREEN+"$"+ANSI_GREEN_BACKGROUND+"     "+ANSI_RESET;;
        for (int i = 0; i < hand.size(); i++) {
            top += CardVisual.getFlippedTop(hand.get(i)[3], hand.get(i)[1])+ANSI_GREEN_BACKGROUND+"     "+ANSI_RESET;
        }
        top += ANSI_BLACK_BACKGROUND+ANSI_GREEN+"$"+ANSI_RESET+"\n";
    }
    public void setBlank(){
        blank = ANSI_BLACK_BACKGROUND+ANSI_GREEN+"$"+ANSI_GREEN_BACKGROUND+"     "+ANSI_RESET;
        for (int i = 0; i < hand.size(); i++) {
            blank += CardVisual.getFlippedBlank(hand.get(i)[1])+ANSI_GREEN_BACKGROUND+"     "+ANSI_RESET;
        }
        blank += ANSI_BLACK_BACKGROUND+ANSI_GREEN+"$"+ANSI_RESET+"\n";
    }
    public void setMiddle(){
        middle = ANSI_BLACK_BACKGROUND+ANSI_GREEN+"$"+ANSI_GREEN_BACKGROUND+"     "+ANSI_RESET;
        for (int i = 0; i < hand.size(); i++) {
            middle += CardVisual.getFlippedMiddle(hand.get(i)[1])+ANSI_GREEN_BACKGROUND+"     "+ANSI_RESET;
        }
        middle += ANSI_BLACK_BACKGROUND+ANSI_GREEN+"$"+ANSI_RESET+"\n";
    }
    public void setBottom(){
        bottom = ANSI_BLACK_BACKGROUND+ANSI_GREEN+"$"+ANSI_GREEN_BACKGROUND+"     "+ANSI_RESET;
        for (int i = 0; i < hand.size(); i++) {
            bottom += CardVisual.getFlippedBottom(hand.get(i)[3], hand.get(i)[1])+ANSI_GREEN_BACKGROUND+"     "+ANSI_RESET;
        }
        bottom += ANSI_BLACK_BACKGROUND+ANSI_GREEN+"$"+ANSI_RESET+"\n"+ANSI_GREEN_BACKGROUND+borderInner+ANSI_BLACK_BACKGROUND+ANSI_GREEN+"$"+ANSI_RESET+"\n"+borderOuter;
    }
    public void setOutput(){
        output = top+blank+middle+blank+bottom;
    }
    public String getOutput(){
        return output;
    }
}
