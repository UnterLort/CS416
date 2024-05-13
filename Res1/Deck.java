import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author Kyle Stewart
 * @version 1
 */
public class Card {
    private String suit;
    private String rank;

    /**
     * @param suit the color of the card
     * @param rank the rank of the card
     */

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}

/**
 * 
 * @author Kyle Stewart
 * @version 1
 */
public class Deck {
    private List<Card> cards;
    private int cardsUsed;

    /**
     * The Deck.
     */
    public Deck() {
        String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
        String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };

        cards = new ArrayList<>();
        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Card(suit, rank));
            }
        }
        cardsUsed = 0;
    }

    /**
     * Shuffle the Deck.
     */
    public void shuffle() {
        Collections.shuffle(cards);
        cardsUsed = 0;
    }

    /**
     * @return the card size
     */
    public int cardsLeft() {
        return cards.size() - cardsUsed;
    }

    /**
     * @return the cards used
     */
    public Card dealCard() {
        if (cardsUsed == cards.size()) {
            throw new IllegalStateException("No more cards are left");
        }
        cardsUsed++;
        return cards.get(cardsUsed - 1);
    }

    /**
     * @param args Commandline arguement
     */
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();

        System.out.println("Number of cards left in the deck: " + deck.cardsLeft());

        System.out.println("Dealing a few cards from the deck:");
        for (int i = 0; i < 5; i++) {
            System.out.println(deck.dealCard());
        }

        System.out.println("Number of cards left in the deck: " + deck.cardsLeft());
    }
}