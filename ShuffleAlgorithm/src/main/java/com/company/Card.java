package com.company;

import java.util.Map;
import java.util.Random;

import static java.util.Map.entry;

public class Card {
    public enum Rank{
        ACE,
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        JACK,
        QUEEN,
        KING
    }
    public enum Suit{
        CLUBS,
        DIAMONDS,
        HEARTS,
        SPADES
    }
    private final Map<Rank, Integer> rankIntMap = Map.ofEntries(
            entry(Rank.ACE, 1),
            entry(Rank.TWO, 2),
            entry(Rank.THREE, 3),
            entry(Rank.FOUR, 4),
            entry(Rank.FIVE, 5),
            entry(Rank.SIX, 6),
            entry(Rank.SEVEN, 7),
            entry(Rank.EIGHT, 8),
            entry(Rank.NINE, 9),
            entry(Rank.TEN, 10),
            entry(Rank.JACK, 11),
            entry(Rank.QUEEN, 12),
            entry(Rank.KING, 13)
    );

    private final Map<Suit, Integer> suitIntMap = Map.ofEntries(
            entry(Suit.CLUBS, 0),
            entry(Suit.DIAMONDS, 1),
            entry(Suit.HEARTS, 2),
            entry(Suit.SPADES, 3)
    );

    private final Map<Rank, String> rankSymbolMap = Map.ofEntries(
            entry(Rank.ACE, "A"),
            entry(Rank.TWO, "2"),
            entry(Rank.THREE, "3"),
            entry(Rank.FOUR, "4"),
            entry(Rank.FIVE, "5"),
            entry(Rank.SIX, "6"),
            entry(Rank.SEVEN, "7"),
            entry(Rank.EIGHT, "8"),
            entry(Rank.NINE, "9"),
            entry(Rank.TEN, "10"),
            entry(Rank.JACK, "J"),
            entry(Rank.QUEEN, "Q"),
            entry(Rank.KING, "K")
    );

    private final Map<Suit, String> suitSymbolMap = Map.ofEntries(
            entry(Suit.CLUBS, "\u2663"),
            entry(Suit.DIAMONDS, "\u2666"),
            entry(Suit.HEARTS, "\u2665"),
            entry(Suit.SPADES, "\u2660")
    );

    public enum Color{
        RED, BLACK
    }

    private final Rank rank;
    private final Suit suit;
    private boolean isFaceDown = true;

    public Card(Rank rank, Suit suit){
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank(){
        return rank;
    }

    public int getRankValue(boolean acesHigh){
        if (acesHigh && rank.equals(Rank.ACE)) return 14;
        return rankIntMap.get(rank);
    }

    public Suit getSuit() {
        return suit;
    }

    public int getSuitValue(){
        return suitIntMap.get(suit);
    }

    public boolean cardEquals(Card card){
        return this.getSuit() == card.getSuit() && this.getRank() == card.getRank();
    }

    public String printCard(){
        return rankSymbolMap.get(rank) + suitSymbolMap.get(suit);
    }

    public Color getColor() {
        return getSuit().equals(Suit.CLUBS) || getSuit().equals(Suit.SPADES) ? Color.BLACK : Color.RED;
    }

    public boolean isFaceDown() {
        return isFaceDown;
    }
    public void flipCard(){isFaceDown = !isFaceDown;}


}
