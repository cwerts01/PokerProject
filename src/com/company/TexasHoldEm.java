package com.company;

public class TexasHoldEm implements Rules {
    public final int handSize = 2;
    Deck communityCards = new Deck();

    @Override
    public boolean canCall(Player player, double amount) {
        return false;
    }

    @Override
    public boolean canCheck(Player player) {
        return false;
    }

    @Override
    public boolean canRaise(Player player, double amount) {
        return false;
    }

    public void nextRound(int round) {
        if(round < 4) {

        }
        else {

        }
    }



}
