package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        boolean gameEnd = false;

        while (gameEnd=false){
            System.out.println("Would you like to play Texas Hold 'Em or Five Card?: ");
            String rules = scanner.nextLine();

            if (rules.equals("Texas Hold 'Em")){
                //generate a Texas Hold 'Em game
            }
            else if (rules.equals("Five Card")){
                //generate a Five Card game
            }
            else {
                System.out.println("Not a valid option, please try again");
            }
            //when the game finishes
            System.out.println("Would you like to play again? y/n:");
            String again = scanner.nextLine();
            if (again.equals("n")){
                gameEnd=true;
            }
            else if (again.equals("y")){
                gameEnd=false;
            }
            else {
                System.out.println("Not a valid option, please try again");
            }
        }*/
            Player hp = new HumanPlayer();
            Player cp = new ComputerPlayer();
            Rules tx = new TexasHoldEm();
            Game game = new Game(hp, cp, tx);
            game.newGame();
            game.playRound();
            game.playRound();
            game.playRound();
            game.playRound();
            game.playRound();
            game.playRound();

    }
}
