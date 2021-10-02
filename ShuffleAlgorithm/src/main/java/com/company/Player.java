package com.company;
import java.util.List;
import java.util.ArrayList;

public class Player {
    private int playerId;
    private String name;
    private List<Card> hand = new ArrayList<>();
    private boolean isHuman = false;

    public Player(int playerId, String name){
        this.playerId = playerId;
        this.name = name;
        isHuman = true;
    }

    public Player(int playerId){
        this.playerId = playerId;
        switch (playerId){
            case 0: name = "Annie"; break;
            case 1: name = "Beth"; break;
            case 2: name = "Connor"; break;
            case 3: name = "Doug"; break;
            case 4: name = "Ellie"; break;
            case 5: name = "Frank"; break;
            case 6: name = "Garth"; break;
            default: name = "Hannah"; break;
        }
    }

    public int getPlayerId() {
        return playerId;
    }
    public String getName() {
        return name;
    }
    public boolean isHuman(){return isHuman;}
    public List<Card> getHand(){return hand;}

    public void dealTo(Card card){
        hand.add(card);

    }
    public void sortHand(boolean acesHigh){
        int highCard = acesHigh ? 14 : 13;
        List<Card> sortedHand = new ArrayList<>();
        for (int suit = 0; suit < 4; suit ++){
            for (int i = acesHigh ? 1 : 0; i < highCard; i++) {
                for(Card card: hand){
                    if (card.getRankValue(acesHigh) == i && card.getSuitValue() == suit){
                        sortedHand.add(card);
                    }
                }
            }
        }
        hand = sortedHand;
    }
}
