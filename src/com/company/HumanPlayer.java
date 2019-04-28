package com.company;

import java.util.Scanner;

public class HumanPlayer extends Player {

    Scanner key = new Scanner(System.in);

    //Recursive method that makes the player make a decision
    public void makeDecision(double pot) {
        System.out.println("Your current wallet is $" + this.getWallet());

        //This is the print method
        System.out.println("Enter the number of the action you'd like to make" +
                "\n 1. Check" +
                "\n 2. Call" +
                "\n 3. Raise");
        String response = key.nextLine();

        //Making sure they enter a valid response
        if(!(response.equals("1") || (response.equals("2") || response.equals("3")))) {
            System.out.println("The last response was invalid try again");
            this.makeDecision(pot);
            return;
        }

        //What to do if they try to check
        if(response.equals("1")) {
            if(this.canCheck(pot)) {
                this.check();
                return;
            }
            System.out.println("You cannot currently check, try again");
            this.makeDecision(pot);
        }

        if(response.equals("2")) {
            if(this.canCall(pot)) {
                this.call(pot);
                return;
            }
            System.out.println("You cannot currently call, try again");
            this.makeDecision(pot);
        }

        if(response.equals("3")) {
            System.out.println("How much money would you like to raise?");
            double amount = Double.parseDouble(key.nextLine());
            if(this.canRaise(amount, pot)) {
                this.raise(amount);
                return;
            }
            System.out.println("You cannot raise that much money, try again");
            this.makeDecision(pot);
        }

    }

}