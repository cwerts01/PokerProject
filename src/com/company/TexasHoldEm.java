package com.company;

public class TexasHoldEm implements Rules {
    public Deck hand = new Deck();
    public Deck communityCards = new Deck();
    public boolean ante = true;
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
