package com.company;

public class FreeCell extends Game{
    public FreeCell(){
        super("FreeCell", 1, 52, false);
    }
    public void startGame(){
        super.deal();
    }

    protected void enterPlayerName(){
        System.out.println("Enter player name:");
        addPlayer(input.nextLine());
    }

}
