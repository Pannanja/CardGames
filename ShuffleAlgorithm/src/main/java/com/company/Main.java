package com.company;

import java.util.Scanner;

public class Main {

    private static Game hearts = new Hearts();
    private static Game freeCell = new FreeCell();
    private static final Game[] games = new Game[]{hearts, freeCell};
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu(){
        System.out.println("Welcome to House of Cards!");
        boolean isInputValid = false;
        while (!isInputValid) {
            System.out.println("Please select a game:");
            int i = 1;
            for (Game game : games) {
                System.out.println("(" + i + ") " + game.getName());
                i++;
            }
            System.out.println("(9) Options");
            System.out.println("(0) Exit");
//            String userInput = input.nextLine();
            String userInput = "1";
            try {
                int validUserInput = Integer.parseInt(userInput);
                switch (validUserInput) {
                    case 1:
                        games[0].startGame();
                        break;
                    case 2:
                        games[1].startGame();
                        break;
                    case 9:
                        return;
                    case 0:
                        return;
                    default:
                        System.out.println("Sorry, I don't know how to play that game. Please enter a number to choose a game.");
                }
            }
            catch (Exception e){
                System.out.println("Sorry, I don't know how to play that game. Please enter a number to choose a game.");
            }
        }
    }
}
