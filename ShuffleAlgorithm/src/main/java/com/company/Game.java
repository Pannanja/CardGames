package com.company;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Game {
    private final String name;
    private final int numberOfPlayers;
    private int playerCount = 0;
    private int numberOfStartingCards;
    private final Deck deck;
    private final boolean acesHigh;
    protected Scanner input = new Scanner(System.in);

    public List<Player> players = new ArrayList<>();

    public Game(String name, int numberOfPlayers, int numberOfStartingCards, boolean acesHigh){
        this.name = name;
        this.numberOfPlayers = numberOfPlayers;
        this.numberOfStartingCards = numberOfStartingCards;
        this.acesHigh = acesHigh;
        this.deck = new Deck();
    }

    public Game(){
        this.name = "GenericGame";
        this.numberOfPlayers = 4;
        this.numberOfStartingCards = 13;
        this.acesHigh = true;
        this.deck = new Deck();
    }

    public String getName(){return name;}
    public int getNumberOfPlayers() {return numberOfPlayers;}
    public int getNumberOfStartingCards(){return numberOfStartingCards;}
    public Deck getDeck(){return deck;}
    public boolean isAcesHigh(){return acesHigh;}

    public abstract void startGame();

    protected abstract void enterPlayerName();

    private void addPlayer(){
        players.add(new Player(playerCount));
        playerCount++;
    }
    protected void addPlayer(String name){
        players.add(new Player(playerCount, name));
        playerCount++;
    }

    private void fillInPlayers(){
        while (playerCount < numberOfPlayers){
            addPlayer();
        }
    }

    protected void deal(){
        fillInPlayers();
        deck.shuffle();
        for(int cardsDealt = 0; cardsDealt <= numberOfStartingCards; cardsDealt++){
            for(Player player : players){
                if(deck.getDeckSize() > 0) {
                    player.dealTo(deck.topDeck());
                }
            }
        }
        for(Player player : players) player.sortHand(acesHigh);
    }
}
