import java.util.*;

/**
 * 
 * @author Kyle Stewart
 * @version 1
 */
public class Card implements Comparable<Card> {
    private String value;
    private String suit;

    private static final Map<String, String> VALUE_TRANSLATIONS = Map.of(
            "2", "Two", "3", "Three", "4", "Four", "5", "Five", "6", "Six",
            "7", "Seven", "8", "Eight", "9", "Nine", "10", "Ten",
            "Jack", "Jack", "Queen", "Queen", "King", "King", "Ace", "Ace"
    );

    private static final Map<String, String> SUIT_TRANSLATIONS = Map.of(
            "Spades", "Spades", "Diamonds", "Diamonds", "Clubs", "Clubs", "Hearts", "Hearts"
    );

    /**
     * 
     * @param suit The suit of the card.
     * @param value The value of the card.
     */
    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
    }

    /**
     * 
     * @return The value of the card.
     */
    public String getValue() {
        return this.value;
    }

    /**
     * 
     * @return The suit of the card.
     */
    public String getSuit() {
        return this.suit;
    }

    /**
     * 
     * @param other The other card to compare with.
     * @return A negative integer, zero, or a positive integer.
     */
    @Override
    public int compareTo(Card other) {
        int valueComparison = getValueOrder(this.value) - getValueOrder(other.value);
        if (valueComparison != 0) {
            return valueComparison;
        } else {
            return 0
        }
    }

    /**
     * 
     * @param value The value of the card.
     * @return The order of the card value.
     */
    private int getValueOrder(String value) {
        List<String> order = Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace");
        return order.indexOf(value);
    }

    /**
     * 
     * @param obj The reference object with which to compare.
     * @return true if this object is the same as the obj argument; false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Card)) {
            return false;
        }
        Card other = (Card) obj;
        return this.suit.equals(other.suit) && this.value.equals(other.value);
    }

    /**
     * 
     * @return A string representation of the card.
     */
    @Override
    public String toString() {
        return String.format("%s of %s", VALUE_TRANSLATIONS.get(this.value), SUIT_TRANSLATIONS.get(this.suit));
    }
}