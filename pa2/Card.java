import java.util.*;

/*
 * A card class represent general poker card
 */
public class Card {
    private String suit;
    private String rank;

    // static array of suit
    static String SUITS[] = {"Spade", "Heart", "Diamond", "Club"};
    static String RANKS[] = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    // static map for rank
    static final Map<String, Integer> RANKMAP;
    static {
        RANKMAP = new HashMap<>();
        RANKMAP.put("A", 1);
        RANKMAP.put("2", 2);
        RANKMAP.put("3", 3);
        RANKMAP.put("4", 4);
        RANKMAP.put("5", 5);
        RANKMAP.put("6", 6);
        RANKMAP.put("7", 7);
        RANKMAP.put("8", 8);
        RANKMAP.put("9", 9);
        RANKMAP.put("10", 10);
        RANKMAP.put("J", 10);
        RANKMAP.put("Q", 10);
        RANKMAP.put("K", 10);
    }

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    public int getValue() {
        return Card.RANKMAP.get(rank);
    }

    public String toString() {
        return "(" + suit + ", " + rank + ")";
    }
}