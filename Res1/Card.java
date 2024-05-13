/**
 * 
 * @author Kyle Stewart
 * @version 1
 */

// Moved the Suit enum outside of the Card class
enum Suit {
    HEARTS, CLUBS, SPADES, DIAMONDS
}

/**
 * 
 * @author Kyle Stewart
 * @version 1
 */
enum Value {
    JOKER, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
}

/**
 * 
 * @author Kyle Stewart
 * @version 02/17/2024
 */
public class Card {
    private Suit suit;
    private Value value;

    /**
     * @param s Suit
     * @param v Value
     */
    public Card(Suit s, Value v) {
        suit = s;
        value = v;
    }

    /**
     * @return get suit
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * @return value
     */
    public Value getValue() {
        return value;
    }

    /**
     * @return the Value and the suit.
     */
    public String toString() {
        return value + " of " + suit;
    }

    /**
     * @param args Commandline Argument
     */
    public static void main(String[] args) {

        Card c = new Card(Suit.HEARTS, Value.THREE);

        assert c.getSuit() == Suit.HEARTS;
        assert c.getValue() == Value.THREE;

        System.out.println(c.toString());

        assert c.toString().equals("THREE of HEARTS");
    }
}