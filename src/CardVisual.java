import java.util.HashMap;

public class CardVisual {
    private String cardName;
    private String cardColor;
    private String flippedMiddle;
    private String flippedBlank;
    private String flippedTop;
    private String flippedBottom;
    private String flippedCard;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    public static String getFlippedMiddle(String symbol){
        return ANSI_WHITE_BACKGROUND+ANSI_BLACK+"     "+symbol+"    "+ANSI_RESET;
    }
    static String getFlippedBlank(){
        return ANSI_WHITE_BACKGROUND+ANSI_BLACK+"          "+ANSI_RESET;
    }
    public static String getFlippedTop(String val){
        return ANSI_WHITE_BACKGROUND+ANSI_BLACK+" "+val+"        "+ANSI_RESET;
    }
    public static String getFlippedBottom(String val){
        return ANSI_WHITE_BACKGROUND+ANSI_BLACK+"        "+val+" "+ANSI_RESET;
    }

}
