package com.company;

public class Game {
    private Rules rules;
    private int round;
    public Player[] players = new Player[2];


    public void newGame() {
        this.round = 0;
        this.unCheckPlayers();
    }

    //This method may be unescessary only time will tell
    public void unCheckPlayers() {
        this.players[0].setCheckStatus(false);
        this.players[1].setCheckStatus(false);
    }

    public void startRound() {
        rules.nextRound(round);
        while(players[0].getCheckStatus() == false && players[1].getCheckStatus() == false) {
            players[0].makeDecision();
            players[1].makeDecision();
        }
    }
}
