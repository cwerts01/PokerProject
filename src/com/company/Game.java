package com.company;

public class Game {
    private Rules rules;
    private int round;
    public Player[] players = new Player[2];
    Deck gameDeck = new Deck();


    public void newGame() {
        this.round = 0;
        this.unCheckPlayers();
        gameDeck.initDeck();
        gameDeck.shuffle();
    }

    //This method may be unescessary only time will tell
    public void unCheckPlayers() {
        this.players[0].setCheckStatus(false);
        this.players[1].setCheckStatus(false);
    }


    //Considering having this delegated more to the rules classes since this varies depending on variant
    public void startRound() {
        //This will be the ante
        if(this.round == 0 ) {
           System.out.println("Would you like to pay the ante to play?");

        }
        //The dealing round
        if(this.round == 1) {
            System.out.println("Here is your hand");

        }

        while(players[0].getCheckStatus() == false && players[1].getCheckStatus() == false) {
            players[0].makeDecision();
            players[1].makeDecision();
            rules.nextRound(round, gameDeck);
        }
        round++;
    }
}
