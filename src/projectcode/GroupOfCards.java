package projectcode;
import java.util.*;
public class GroupOfCards {
    private List<Card> cards;

    public GroupOfCards() {
        // Populate the deck with cards
        cards = new ArrayList<Card>();
        for (String suit : new String[] {"Hearts", "Diamonds", "Clubs", "Spades"}) {
            for (String rank : new String[] {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"}) {
                int value = 0;
                try {
                value = Integer.parseInt(rank);
                }
                catch(Exception e){
                if (rank.equals("Jack") || rank.equals("Queen") || rank.equals("King")) {
                    value = 10;
                } else if (rank.equals("Ace")) {
                    value = 11;
                }
            }
                Card card = new Card(suit, rank, value);
                cards.add(card);
            }
        }
    }
    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card dealCard() {
        return cards.remove(0);
    }

    public int cardsRemaining() {
        return cards.size();
    }
}