package com.company;

public class FiveCard implements Rules {
    private final int handSize = 5;
    private final int finalRound = 4;
    Deck communityCards = new Deck();

    public int getHandSize() {
        return this.handSize;
    }

    public int getFinalRound() {
        return this.finalRound;
    }

    public void nextRound(int round, Deck deck) {
        if(round == 2) {
            System.out.println("These are the community cards:");
            communityCards.addCards(deck.dealCards(3));
            System.out.println(communityCards);
        }
        else {
            communityCards.addCards(deck.dealCards(1));
            System.out.println(communityCards);
        }
    }

    //Returns the cards of the player and of the community cards combined
    public Deck getCommunityCards() {
        return this.communityCards;
    }
}
