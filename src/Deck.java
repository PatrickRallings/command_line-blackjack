import java.util.Arrays;

public class Deck {
    private final String[][] deck = {{"2 of Spades", "black", "2"},{"3 of Spades", "black", "3"},{"4 of Spades", "black", "4"},{"5 of Spades", "black", "5"},{"6 of Spades", "black", "6"},{"7 of Spades", "black", "7"},{"8 of Spades", "black", "8"},{"9 of Spades", "black", "9"},{"10 of Spades", "black", "10"},{"Jack of Spades", "black", "10"},{"Queen of Spades", "black", "10"},{"King of Spades", "black", "10"},{"Ace of Spades", "black", ""},{"2 of Clubs", "black", "2"},{"3 of Clubs", "black", "3"},{"4 of Clubs", "black", "4"},{"5 of Clubs", "black", "5"},{"6 of Clubs", "black", "6"},{"7 of Clubs", "black", "7"},{"8 of Clubs", "black", "8"},{"9 of Clubs", "black", "9"},{"10 of Clubs", "black", "10"},{"Jack of Clubs", "black", "10"},{"Queen of Clubs", "black", "10"},{"King of Clubs", "black", "10"},{"Ace of Clubs", "black", ""},{"2 of Hearts", "red", "2"},{"3 of Hearts", "red", "3"},{"4 of Hearts", "red", "4"},{"5 of Hearts", "red", "5"},{"6 of Hearts", "red", "6"},{"7 of Hearts", "red", "7"},{"8 of Hearts", "red", "8"},{"9 of Hearts", "red", "9"},{"10 of Hearts", "red", "10"},{"Jack of Hearts", "red", "10"},{"Queen of Hearts", "red", "10"},{"King of Hearts", "red", "10"},{"Ace of Hearts", "red", ""},{"2 of Diamonds", "red", "2"},{"3 of Diamonds", "red", "3"},{"4 of Diamonds", "red", "4"},{"5 of Diamonds", "red", "5"},{"6 of Diamonds", "red", "6"},{"7 of Diamonds", "red", "7"},{"8 of Diamonds", "red", "8"},{"9 of Diamonds", "red", "9"},{"10 of Diamonds", "red", "10"},{"Jack of Diamonds", "red", "10"},{"Queen of Diamonds", "red", "10"},{"King of Diamonds", "red", "10"},{"Ace of Diamonds", "red", ""}};
    private int currentCardIndex;


    public Deck(){
        shuffleDeck();
        currentCardIndex = 0;
    }
    private void shuffleDeck(){
        for (int i = 0; i < deck.length; i++){
            int index = (int) (Math.random()*deck.length-1);
            String[] temp = deck[i];
            deck[i] = deck[index];
            deck[index] = temp;
        }
    }
    public void nextCardArray(){
        currentCardIndex++;
    }
    public String getCurrentCardValue(){
        return deck[currentCardIndex][2];
    }
    public String getCurrentCardColor(){
        return deck[currentCardIndex][1];
    }
    public String getCurrentCard (){
        return deck[currentCardIndex][0];
    }
    public String getAllCards (){
        String s = "";
        int count = 0;
        for(int i = 0; i < deck.length; i++){
            count++;
            s += "Card #"+String.valueOf(count)+" | Card: "+deck[i][0]+"\n";
        }
        return s;
    }
}
