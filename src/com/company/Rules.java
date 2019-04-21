package com.company;

public interface Rules {

    public boolean canCall(Player player, double amount, double pot);
    public boolean canCheck(Player player, double pot);
    public boolean canRaise(Player player, double amount, double pot);
    public int getFinalRound();
    public int getHandSize();

    public void nextRound(int round, Deck deck);
}
