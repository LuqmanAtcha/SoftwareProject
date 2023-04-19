package projectcode;
import java.util.*;
public class Player {
    private String name;
    private int score;
    private List<Card> hand;

    public Player(String name) {
        this.name = name;
        score = 0;
        hand = new ArrayList<Card>();
    }
    public Card removeCardFromHand(String rank) {
        hand.removeIf(card -> card.getRank().equals(rank));
        return null;
    }
    public void addCardToHand(Card card) {
        hand.add(card);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<Card> getHand() {
        return hand;
    }
    public int getHandSize() {
        return hand.size();
    }
    public void setHand(List<Card> hand) {
        this.hand = hand;
    }
}