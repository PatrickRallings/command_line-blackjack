import java.util.ArrayList;

public class HiddenHandVisual {
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

    public HiddenHandVisual(ArrayList<String[]> hand){
        this.hand = hand;
        setBorder();
        setTop();
        setBlank();
        setMiddle();
        setBottom();
        setOutput();
    }

    private void setBorder(){
        borderOuter = ANSI_BLACK_BACKGROUND+ANSI_GREEN+"$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$"+ANSI_RESET+ANSI_BLACK_BACKGROUND+ANSI_GREEN+"";
        borderInner = ANSI_BLACK_BACKGROUND+ANSI_GREEN+"$"+ANSI_RESET+ANSI_GREEN_BACKGROUND+"                                   "+ANSI_BLACK_BACKGROUND+ANSI_GREEN+""+ANSI_RESET+ANSI_GREEN_BACKGROUND;
        borderOuter += ANSI_RESET;
        borderInner += ANSI_RESET;
    }

    public void setTop(){
        top = ANSI_GREEN_BACKGROUND+borderOuter+ANSI_RESET+"\n"+borderInner+ANSI_BLACK_BACKGROUND+ANSI_GREEN+"$"+ANSI_RESET+"\n"+ANSI_BLACK_BACKGROUND+ANSI_GREEN+"$"+ANSI_GREEN_BACKGROUND+"     "+ANSI_RESET;
            top += CardVisual.getFlippedTop(hand.get(0)[3], hand.get(0)[1])+ANSI_GREEN_BACKGROUND+"     "+ANSI_RESET+CardVisual.getUnflippedOne()+ANSI_GREEN_BACKGROUND+"     "+ANSI_RESET;
        top += ANSI_BLACK_BACKGROUND+ANSI_GREEN+"$"+ANSI_RESET+"\n";
    }
    public void setBlank(){
        blank = ANSI_BLACK_BACKGROUND+ANSI_GREEN+"$"+ANSI_GREEN_BACKGROUND+"     "+ANSI_RESET;
            blank += CardVisual.getFlippedBlank(hand.get(0)[1])+ANSI_GREEN_BACKGROUND+"     "+ANSI_RESET+CardVisual.getUnflippedTwo()+ANSI_GREEN_BACKGROUND+"     "+ANSI_RESET;
        blank += ANSI_BLACK_BACKGROUND+ANSI_GREEN+"$"+ANSI_RESET+"\n";
    }
    public void setMiddle(){
        middle = ANSI_BLACK_BACKGROUND+ANSI_GREEN+"$"+ANSI_GREEN_BACKGROUND+"     "+ANSI_RESET;
            middle += CardVisual.getFlippedMiddle(hand.get(0)[1])+ANSI_GREEN_BACKGROUND+"     "+ANSI_RESET+CardVisual.getUnflippedOne()+ANSI_GREEN_BACKGROUND+"     "+ANSI_RESET;;
        middle += ANSI_BLACK_BACKGROUND+ANSI_GREEN+"$"+ANSI_RESET+"\n";
    }
    public void setBottom(){
        bottom = ANSI_BLACK_BACKGROUND+ANSI_GREEN+"$"+ANSI_GREEN_BACKGROUND+"     "+ANSI_RESET;
            bottom += CardVisual.getFlippedBottom(hand.get(0)[3], hand.get(0)[1])+ANSI_GREEN_BACKGROUND+"     "+ANSI_RESET+CardVisual.getUnflippedOne()+ANSI_GREEN_BACKGROUND+"     "+ANSI_RESET;
        bottom += ANSI_BLACK_BACKGROUND+ANSI_GREEN+"$"+ANSI_RESET+"\n"+ANSI_GREEN_BACKGROUND+borderInner+ANSI_BLACK_BACKGROUND+ANSI_GREEN+"$"+ANSI_RESET+"\n"+borderOuter;
    }
    public void setOutput(){
        output = top+blank+middle+blank+bottom;
    }
    public String getOutput(){
        return output;
    }
}
