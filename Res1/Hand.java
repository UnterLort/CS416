import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author Kyle Stewart
 * @version 1
 */
public class Hand {
    private List<Card> cards;

    /**
     * The cards.
     */
    public Hand() {
        cards = new ArrayList<>();
    }

    /**
     * Cards clear.
     */
    public void clear() {
        cards.clear();
    }

    /**
     * @param c for cards
     */
    public void addCard(Card c) {
        if (c == null) {
            throw new NullPointerException("Card cannot be null");
        }
        cards.add(c);
    }

    /**
     * @param c for cards
     */
    public void removeCard(Card c) {
        cards.remove(c);
    }

    /**
     * @return the card size
     */
    public int getCardCount() {
        return cards.size();
    }

    /**
     * @param position The Position
     * @return The Values
     */
    public Card getCard(int position) {
        if (position < 0 || position >= cards.size()) {
            throw new IllegalArgumentException("Invalid position");
        }
        return cards.get(position);
    }

    /**
     * Get the Suit color for each card.
     */
    public void sortBySuit() {
        Collections.sort(cards, (card1, card2) -> {
            int suitComparison = card1.getSuit().compareTo(card2.getSuit());
            if (suitComparison == 0) {
                return card1.getRank().compareTo(card2.getRank());
            }
            return suitComparison;
        });
    }

    /**
     * Get the value of the cards.
     */
    public void sortByValue() {
        Collections.sort(cards, (card1, card2) -> {
            int valueComparison = getValueRank(card1.getRank()) - getValueRank(card2.getRank());
            if (valueComparison == 0) {
                return card1.getSuit().compareTo(card2.getSuit());
            }
            return valueComparison;
        });
    }

    /**
     * @param rank card ranking
     * @return the card
     */
    private int getValueRank(String rank) {
        switch (rank) {
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            case "6":
                return 6;
            case "7":
                return 7;
            case "8":
                return 8;
            case "9":
                return 9;
            case "10":
                return 10;
            case "Jack":
                return 11;
            case "Queen":
                return 12;
            case "King":
                return 13;
            case "Ace":
                return 14;
            default:
                throw new IllegalArgumentException("Invalid card rank");
        }
    }
}