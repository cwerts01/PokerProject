package com.company;

public interface Rules {

    public int getFinalRound();
    public int getHandSize();

    public void nextRound(int round, Deck deck, Player[] players);

    public Deck getCommunityCards();
}
