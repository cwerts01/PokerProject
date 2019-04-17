package com.company;

public class TexasHoldEm implements Rules {
    public final int handSize = 2;
    public final int communityCardsSize = 5;
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
            Evaluator.calculateHand();
        }
    }



}
