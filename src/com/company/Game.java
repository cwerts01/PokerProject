package com.company;

import java.util.Scanner;

public class Game {
    private Rules rules;
    private int round;
    public Player[] players = new Player[2];
    Deck gameDeck = new Deck();
    double pot;
    Scanner key = new Scanner(System.in);


    public Game(Player p1, Player p2, Rules rules) {
        p1.setWallet(100.0);
        p2.setWallet(100.0);

        players[0] = p1;
        players[1] = p2;
        this.rules = rules;
        this.pot = 0;
    }

    //Need to figure out how much money each player should start with
    public void newGame() {
        this.unCheckPlayers();
        this.unFoldPlayers();
        players[0].clearHand();
        players[1].clearHand();
        gameDeck.initDeck();
        gameDeck.shuffle();
        this.pot = 0;
        this.round = 0;
    }

    public void unCheckPlayers() {
        this.players[0].setCheckStatus(false);
        this.players[1].setCheckStatus(false);
    }
    public void unFoldPlayers() {
        this.players[0].setFoldStatus(false);
        this.players[1].setFoldStatus(false);
    }


   //Depending on the round it will ask the rules class to do what it needs for that round
    public void playRound() {

        //This will be the ante
        if(this.round == 0 ) {
            System.out.println("It's the first round, no cards have been dealt yet but there is a round of betting");
            this.betting();
        }


        //The dealing round
        else if(this.round == 1) {
            //This long chain of methods deals the players their cards
            players[0].getHand().addCards(gameDeck.dealCards(rules.getHandSize()));
            players[1].getHand().addCards(gameDeck.dealCards(rules.getHandSize()));

            System.out.println("These are your cards, " + players[0].getHand() + "\n There are no community cards at this time");
            this.betting();
        }
        else if(this.round == rules.getFinalRound()+1) {
            this.endGame();
        }
        else {
            System.out.println("These are your cards " + players[0].getHand());
            rules.nextRound(round, gameDeck);
            this.betting();
        }

        round++;
        this.unCheckPlayers();
    }

    //Method to finish the game, it gives the player their money based on the hand and then sets the pot to 0
    private void endGame() {
        System.out.println("This is the end");
        Evaluator evaluator = new Evaluator();


        //These lines make sure that the community cards are counted in addition to their regular hand
        players[0].getHand().addCards(rules.getCommunityCards().getDeck());
        players[1].getHand().addCards(rules.getCommunityCards().getDeck());


        String winner = evaluator.compareHands(players);
        if(winner.equalsIgnoreCase("split")) {
            players[0].setWallet(players[0].getWallet() + Math.round(pot/2));
            players[1].setWallet(players[1].getWallet() + Math.round(pot/2));
            System.out.println("It was a draw, you split the pot with the opponent");
        }
        else if(winner.contains("1")) {
            players[0].setWallet(players[0].getWallet() + pot);
            System.out.println("Congrats! You won the pot of $" + pot);
        }
        else {
            players[1].setWallet(players[1].getWallet() + pot);
            System.out.println("Tough luck, you lost the round");
        }

        this.wantsNewGame();

    }

    private void betting() {
        while(players[0].getCheckStatus() == false && players[1].getCheckStatus() == false) {
            System.out.println("The current pot is $" + this.pot);
            players[0].makeDecision(this.pot);
            this.pot = players[0].getAmountBet() + players[1].getAmountBet();
            if(players[0].getFoldStatus()) {
                this.foldGame(0);
                return;
            }

            //Making sure in case player 1 checked first and player 2 didn't in the first round
                if(players[0].getCheckStatus() == true && players[1].getCheckStatus() == true)
                    break;

            players[1].makeDecision(this.pot);
            this.pot = players[0].getAmountBet() + players[1].getAmountBet();
            if(players[1].getFoldStatus()) {
                this.foldGame(1);
                return;
            }
        }

    }


    //Need to have the game be replayable
    private void foldGame(int index) {
        if(index == 1) {
            players[0].setWallet(players[0].getWallet() + pot);
            System.out.println("Your opponent has folded and you've won the pot of $" + pot);
        }
        else {
            players[1].setWallet(players[1].getWallet() + pot);
            System.out.println("Tough luck, you folded so the computer won");
        }

        this.wantsNewGame();

    }

    private void wantsNewGame() {
        System.out.println(String.format("You currently have $%s and the computer has $%s", players[0].getWallet(), players[1].getWallet()));
        System.out.println("If you would like to play another game? If so enter yes, if not enter no");
        String response = key.nextLine();
        if(response.equalsIgnoreCase("yes")) {
            this.newGame();
        }
        else if (response.equalsIgnoreCase("no")) {
            this.round = -2;
        }
        else this.wantsNewGame();

    }

    public int getRound() {
        return this.round;
    }

}
