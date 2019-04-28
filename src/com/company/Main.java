package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean gameEnd = false;

        while (gameEnd=false){
            System.out.println("Would you like to play Texas Hold 'Em or Five Card?: ");
            String rules = scanner.nextLine();

            if (rules.equals("Texas Hold 'Em")){
                Player hp = new HumanPlayer();
                Player cp = new ComputerPlayer();
                Rules tx = new TexasHoldEm();
                Game game = new Game(hp, cp, tx);
                game.newGame();
                while(!(game.getRound() < 0)) {
                    game.playRound();
                    if(game.getRound() < 0) {
                        break;
                    }
                }
            }
            else if (rules.equals("Five Card")){
                Player hp = new HumanPlayer();
                Player cp = new ComputerPlayer();
                Rules tx = new TexasHoldEm();
                Game game = new Game(hp, cp, tx);
                game.newGame();
                while(!(game.getRound() < 0)) {
                    game.playRound();
                    if(game.getRound() < 0) {
                        break;
                    }
                }
            }
        }
        System.out.println("Thanks for playing!");
    }
}
