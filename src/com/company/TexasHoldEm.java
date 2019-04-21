package com.company;

public class TexasHoldEm implements Rules {
    public final int handSize = 2;
    Deck communityCards = new Deck();

    @Override
    public boolean canCall(Player player, double amount, double pot) {
        if(pot - 2* player.getAmountBet() > 0 ) {
            return true;
        }
        return false;
    }

    @Override
    public boolean canCheck(Player player, double pot) {
        if(pot - player.getAmountBet()*2 <= 0 || player.getWallet() <= 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean canRaise(Player player, double amount, double pot) {
        if(pot - 2* player.getAmountBet() >= 0 && player.getWallet() - amount >=0 ) {
            return true;
        }
        return false;
    }

    public void nextRound(int round) {
        if(round < 4) {

        }
        else {

        }
    }



}
