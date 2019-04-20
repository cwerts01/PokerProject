package com.company;

public class TexasHoldEm implements Rules {
    public final int handSize = 2;
    public boolean hasCommunityCards;
    public final double ante = 5.0;
    private int round = 1;


    @Override
    public boolean canCall() {
        return false;
    }

    @Override
    public boolean check() {
        return false;
    }

    @Override
    public boolean canRaise() {
        return false;
    }

    public void flipNextCard() {
        if(this.round < 4) {

        }
        else {

        }
    }



}
