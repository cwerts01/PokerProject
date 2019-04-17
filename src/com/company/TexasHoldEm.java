package com.company;

public class TexasHoldEm implements Rules {
    int handSize = 2;
    int communityCardsSize = 5;
    boolean ante = true;

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
}
