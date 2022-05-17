import java.util.HashMap;

public class CardVisual {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String RED_BOLD_BRIGHT = "\033[1;91m";
    public static final String BLACK_BOLD_BRIGHT = "\033[1;30m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public static final String ANSI_BG_RED    = "\u001B[41m";
    public static final String ANSI_BRIGHT_WHITE  = "\u001B[97m";
    public static final String ANSI_BG_BLUE   = "\u001B[44m";


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
            if (val.equalsIgnoreCase("10")){
                return ANSI_WHITE_BACKGROUND + BLACK_BOLD_BRIGHT + " " + val + "       " + ANSI_RESET;
            } else {
                return ANSI_WHITE_BACKGROUND + BLACK_BOLD_BRIGHT + " " + val + "        " + ANSI_RESET;
            }


    }
    public static String getFlippedBottom(String val, String symbol){
            if (val.equalsIgnoreCase("10")){
                return ANSI_WHITE_BACKGROUND + BLACK_BOLD_BRIGHT + "       " + val + " " + ANSI_RESET;
            } else {
                return ANSI_WHITE_BACKGROUND + BLACK_BOLD_BRIGHT + "        " + val + " " + ANSI_RESET;
            }

    }

    public static String getUnflippedOne(){
            return ANSI_BG_RED + ANSI_BRIGHT_WHITE + " ♥ ♣ ♦ ♠  " + ANSI_RESET;
    }
    public static String getUnflippedTwo(){
            return ANSI_BG_RED + ANSI_BRIGHT_WHITE + "  ♦ ♠ ♥ ♣ " + ANSI_RESET;


    }

}
