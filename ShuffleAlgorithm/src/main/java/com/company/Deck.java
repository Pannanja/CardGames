package com.company;

import java.util.Stack;

public class Deck implements DeckInterface{
    private Stack<Card> deck = new Stack<>();

    public Deck(){createDeck();}

    public Stack<Card> getDeck() {
        return deck;
    }

    public void createDeck(){
        for(Card.Suit suit : Card.Suit.values()){
            for(Card.Rank rank : Card.Rank.values()){
                deck.push(new Card(rank, suit));
            }
        }
    }

    public void shuffle(){
        Stack<Card> shuffledDeck = new Stack<>();
        while(deck.size() > 0) {
            for(int i = 0; i < deck.size(); i++){
                if (Math.random() < 0.5){
                    shuffledDeck.push(deck.remove(i));
                }
            }
        }
        deck = shuffledDeck;
    }

    public Card topDeck(){return deck.pop();}

    public int getDeckSize(){return deck.size();}
}
