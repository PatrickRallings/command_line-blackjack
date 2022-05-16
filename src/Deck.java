import java.util.Arrays;

public class Deck {
    private final String[][] deck = {{"2 of Spades", "♠", "2","2"},{"3 of Spades", "♠", "3","3"},{"4 of Spades", "♠", "4","4"},{"5 of Spades", "♠", "5","5"},{"6 of Spades", "♠", "6","6"},{"7 of Spades", "♠", "7","7"},{"8 of Spades", "♠", "8","8"},{"9 of Spades", "♠", "9","9"},{"10 of Spades", "♠", "10","10"},{"Jack of Spades", "♠", "10","J"},{"Queen of Spades", "♠", "10","Q"},{"King of Spades", "♠", "10","K"},{"Ace of Spades", "♠", "","A"},{"2 of Clubs", "♣", "2", "2"},{"3 of Clubs", "♣", "3", "3"},{"4 of Clubs", "♣", "4", "4"},{"5 of Clubs", "♣", "5", "5"},{"6 of Clubs", "♣", "6", "6"},{"7 of Clubs", "♣", "7", "7"},{"8 of Clubs", "♣", "8", "8"},{"9 of Clubs", "♣", "9", "9"},{"10 of Clubs", "♣", "10", "10"},{"Jack of Clubs", "♣", "10", "J"},{"Queen of Clubs", "♣", "10", "Q"},{"King of Clubs", "♣", "10","K"},{"Ace of Clubs", "♣", "", "A"},{"2 of Hearts", "♥", "2", "2"},{"3 of Hearts", "♥", "3", "3"},{"4 of Hearts", "♥", "4", "4"},{"5 of Hearts", "♥", "5", "5"},{"6 of Hearts", "♥", "6", "6"},{"7 of Hearts", "♥", "7", "7"},{"8 of Hearts", "♥", "8", "8"},{"9 of Hearts", "♥", "9", "9"},{"10 of Hearts", "♥", "10", "10"},{"Jack of Hearts", "♥", "10", "J"},{"Queen of Hearts", "♥", "10", "Q"},{"King of Hearts", "♥", "10", "K"},{"Ace of Hearts", "♥", "", "A"},{"2 of Diamonds", "♦", "2","2"},{"3 of Diamonds", "♦", "3", "3"},{"4 of Diamonds", "♦", "4", "4"},{"5 of Diamonds", "♦", "5","5"},{"6 of Diamonds", "♦", "6","6"},{"7 of Diamonds", "♦", "7","7"},{"8 of Diamonds", "♦", "8","8"},{"9 of Diamonds", "♦", "9","9"},{"10 of Diamonds", "♦", "10","10"},{"Jack of Diamonds", "♦", "10","J"},{"Queen of Diamonds", "♦", "10","Q"},{"King of Diamonds", "♦", "10","K"},{"Ace of Diamonds", "♦", "","A"}};
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
    public String[] getCurrentCardArray(){
        return deck[currentCardIndex];
    }
    public String getCurrentCard (){
        return deck[currentCardIndex][0];
    }


    //Development tool
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
