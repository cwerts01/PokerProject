package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);

        Rules rules =  new TexasHoldEm();
        System.out.println("Enter the number of the game you would like to play" +
                "\n 1. Texas Hold 'Em" +
                "\n 2. Five Card");
        String ruleset = key.nextLine();
        if(ruleset.equals("1")) {
            rules = new TexasHoldEm();
        }
        else if(ruleset.equals("2")) {
            rules = new FiveCard();
        }

        Player hp = new HumanPlayer();
        Player cp = new ComputerPlayer();

        Game game = new Game(hp, cp, rules);
        game.newGame();
        while(!(game.getRound() < 0)) {
            game.playRound();
            if(game.getRound() < 0) {
                break;
            }
        }
        System.out.println("Thanks for playing!");
    }
}
