import java.util.HashMap;

public class CardVisual {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String RED_BOLD = "\033[1;31m";
    public static final String RED_BOLD_BRIGHT = "\033[1;91m";
    public static final String BLACK_BOLD_BRIGHT = "\033[1;30m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    public static String getFlippedMiddle(String symbol){
        if (symbol.equalsIgnoreCase("♠")||symbol.equalsIgnoreCase("♣")) {
            return ANSI_WHITE_BACKGROUND + BLACK_BOLD_BRIGHT + "     " + symbol + "    " + ANSI_RESET;
        } else {
            return ANSI_WHITE_BACKGROUND + RED_BOLD_BRIGHT + "     " + symbol + "    " + ANSI_RESET;
        }
    }
    public static String getFlippedBlank(String symbol){
        if (symbol.equalsIgnoreCase("♠")||symbol.equalsIgnoreCase("♣")) {
            return ANSI_WHITE_BACKGROUND + BLACK_BOLD_BRIGHT + "          " + ANSI_RESET;
        } else {
            return ANSI_WHITE_BACKGROUND + RED_BOLD_BRIGHT + "          " + ANSI_RESET;
        }
    }
    public static String getFlippedTop(String val, String symbol){
        if (symbol.equalsIgnoreCase("♠")||symbol.equalsIgnoreCase("♣")) {
            if (val.equalsIgnoreCase("10")){
                return ANSI_WHITE_BACKGROUND + BLACK_BOLD_BRIGHT + " " + val + "       " + ANSI_RESET;
            } else {
                return ANSI_WHITE_BACKGROUND + BLACK_BOLD_BRIGHT + " " + val + "        " + ANSI_RESET;
            }
        }
        else {
            return ANSI_WHITE_BACKGROUND + RED_BOLD_BRIGHT + " " + val + "        " + ANSI_RESET;
        }
    }
    public static String getFlippedBottom(String val, String symbol){
        if (symbol.equalsIgnoreCase("♠")||symbol.equalsIgnoreCase("♣")) {
            if (val.equalsIgnoreCase("10")){
                return ANSI_WHITE_BACKGROUND + BLACK_BOLD_BRIGHT + "       " + val + " " + ANSI_RESET;
            } else {
                return ANSI_WHITE_BACKGROUND + BLACK_BOLD_BRIGHT + "        " + val + " " + ANSI_RESET;
            }
        } else {
            return ANSI_WHITE_BACKGROUND + RED_BOLD_BRIGHT + "        " + val + " " + ANSI_RESET;
        }
    }

}
