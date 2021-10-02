package com.company;

public class Hearts extends Game{

    private Player currentPlayer;

    public Hearts(){
        super("Hearts", 4, 13, true);
    }
    public void startGame(){
        enterPlayerName();
        super.deal();
        currentPlayer = findTwoOfClubs();
        printHand(currentPlayer);

    }

    protected void enterPlayerName(){
        System.out.println("Enter player name:");
        addPlayer(input.nextLine());
    }

    private Player findTwoOfClubs(){
        Card twoOfClubs = new Card(Card.Rank.TWO, Card.Suit.CLUBS);
        for(Player player: players){
            if (player.getHand().get(0).cardEquals(twoOfClubs)){
                return player;
            }
        }
        return null;
    }

    private void printHand(Player player){
        String totalClubs = "";
        String totalDiamonds = "";
        String totalHearts = "";
        String totalSpades = "";
        for(Card card : player.getHand()){
            switch (card.getSuit()){
                case CLUBS: totalClubs += card.printCard() + " "; break;
                case DIAMONDS: totalDiamonds += card.printCard() + " "; break;
                case HEARTS: totalHearts += card.printCard() + " "; break;
                case SPADES: totalSpades += card.printCard() + " "; break;
            }
        }
        System.out.println("Choose a card to play:");
        System.out.println(totalClubs);
        System.out.println(totalDiamonds);
        System.out.println(totalSpades);
        System.out.println(totalHearts);
    }

}
