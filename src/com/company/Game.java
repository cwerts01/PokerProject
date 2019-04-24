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
    public void playRound() {

        //This will be the ante
        //TODO implement a new method for the ante
        if(this.round == 0 ) {
           this.betting();
        }

        //The dealing round
        else if(this.round == 1) {
            //This long chain of methods deals the players their cards
            players[0].getHand().addCards(gameDeck.dealCards(rules.getHandSize()));
            players[1].getHand().addCards(gameDeck.dealCards(rules.getHandSize()));
            this.betting();
        }
        else if(this.round == rules.getFinalRound()) {
            this.endGame();
        }
        else {
            rules.nextRound(round, gameDeck);
            this.betting();
        }


        round++;
    }

    //TODO implement method that will end the game and evaluate the hand as well as take care of the pot.
    private void endGame() {

    }

    private void betting() {
        while(players[0].getCheckStatus() == false && players[1].getCheckStatus() == false) {
            players[0].makeDecision();
            players[1].makeDecision();
        }
    }
}
