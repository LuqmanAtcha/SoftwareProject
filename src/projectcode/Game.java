package projectcode;

import java.util.*;
public class Game {
    private List<Player> players;
    private GroupOfCards deck;

    public Game(List<String> playerNames) {
        players = new ArrayList<Player>();
        for (String name : playerNames) {
            Player player = new Player(name);
            players.add(player);
        }

        deck = new GroupOfCards();
        deck.shuffle();
    }

    public void play() {
        // Deal initial hand to players
        for (Player player : players) {
            for (int i = 0; i < 7; i++) {
                Card card = deck.dealCard();
                player.addCardToHand(card);
            }
        }

        // Play the game
        boolean gameNotOver = true;
        while (gameNotOver) {
            for (Player player : players) {
                Player otherPlayer = askOtherPlayerForCard(player);
                if (otherPlayer != null) {
                    Card card = getCardFromOtherPlayer(player, otherPlayer);
                    player.addCardToHand(card);
                    checkIfPlayerHasFourOfAKind(player);
                } else {
                    if (deck.cardsRemaining() > 0) {
                        Card card = deck.dealCard();
                        player.addCardToHand(card);
                        checkIfPlayerHasFourOfAKind(player);
                    }
                }

                if (player.getHandSize() == 0) {
                    gameNotOver = false;
                    break;
                }
            }
        }

        Player winner = checkWin();
        System.out.println("Game over! " + winner.getName() + " wins!");
    }

    public Player askOtherPlayerForCard(Player player) {
        System.out.println(player.getName() + ", choose a player to ask for a card:");
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i) != player) {
                System.out.println(i + ": " + players.get(i).getName());
            }
        }
        Scanner scanner = new Scanner(System.in);
        int playerIndex = scanner.nextInt();
        Player otherPlayer = players.get(playerIndex);
        System.out.println(player.getName() + " asks " + otherPlayer.getName() + " for a card...");
        String rank = chooseRankFromHand(player);
        Card card = otherPlayer.removeCardFromHand(rank);
        if (card != null) {
            System.out.println(otherPlayer.getName() + " gives " + player.getName() + " the " + card.getRank() + " of " + card.getSuit() + ".");
            return otherPlayer;
        } else {
            System.out.println(otherPlayer.getName() + " does not have any " + rank + "'s.");
            return null;
        }
    }
    
    public String chooseRankFromHand(Player player) {
        System.out.println(player.getName() + ", choose a rank from your hand to ask for:");
        List<String> ranks = new ArrayList<String>();
        for (Card card : player.getHand()) {
            if (!ranks.contains(card.getRank())) {
                ranks.add(card.getRank());
            }
        }
        for (int i = 0; i < ranks.size(); i++) {
            System.out.println(i + ": " + ranks.get(i));
        }
        Scanner scanner = new Scanner(System.in);
        int rankIndex = scanner.nextInt();
        return ranks.get(rankIndex);
    }
    
    public Card getCardFromOtherPlayer(Player player, Player otherPlayer) {
        String rank = chooseRankToGive(otherPlayer);
        Card card = otherPlayer.removeCardFromHand(rank);
        System.out.println(otherPlayer.getName() + " gives " + player.getName() + " the " + card.getRank() + " of " + card.getSuit() + ".");
        return card;
    }
    
    public String chooseRankToGive(Player player) {
        System.out.println(player.getName() + ", choose a rank from your hand to give:");
        List<String> ranks = new ArrayList<String>();
        for (Card card : player.getHand()) {
            if (!ranks.contains(card.getRank())) {
                ranks.add(card.getRank());
            }
        }
        for (int i = 0; i < ranks.size(); i++) {
            System.out.println(i + ": " + ranks.get(i));
        }
        Scanner scanner = new Scanner(System.in);
        int rankIndex = scanner.nextInt();
        return ranks.get(rankIndex);
    }
    
    public void checkIfPlayerHasFourOfAKind(Player player) {
        List<Card> hand = player.getHand();
        for (int i = 0; i < hand.size(); i++) {
            int count = 1;
            for (int j = i + 1; j < hand.size(); j++) {
                if (hand.get(i).getRank().equals(hand.get(j).getRank())) {
                    count++;
                }
            }
            if (count == 4) {
                System.out.println(player.getName() + " has four " + hand.get(i).getRank() + "'s!");
                player.removeCardFromHand(hand.get(i).getRank());
                player.setScore(player.getScore() + 1);
            }
        }
    }
    public Player checkWin() {
        Player winner = null;
        int highestScore = 0;
        for (Player player : players) {
            if (player.getScore() > highestScore) {
                winner = player;
                highestScore = player.getScore();
            }
        }
        return winner;
    }
}