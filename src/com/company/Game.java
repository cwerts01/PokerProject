package com.company;

public class Game {
    private Rules rules;
    private int round;
    private int turn;
    public Player[] players = new Player[2];


    public void newGame() {
        this.round = 0;
        this.turn = 0;
        this.unCheckPlayers();
    }

    public void unCheckPlayers() {
        this.players[0].setCheckStatus(false);
        this.players[1].setCheckStatus(false);
    }
}
