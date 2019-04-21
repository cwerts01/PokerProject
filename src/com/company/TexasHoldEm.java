package com.company;

public class TexasHoldEm implements Rules {
    private final int handSize = 2;
    private final int finalRound = 4;
    Deck communityCards = new Deck();

    public int getHandSize() {
        return this.handSize;
    }
    public int getFinalRound() {
        return this.finalRound;
    }
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

    public void nextRound(int round, Deck deck) {

        if(round == 2) {
            communityCards.addCards(deck.dealCards(3));
            System.out.println(communityCards);
        }
        else {
            communityCards.addCards(deck.dealCards(1));
            System.out.println(communityCards);
        }
    }



}
