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

    public void nextRound(int round, Deck gameDeck, Player[] players) {
        if(round == 1) {
            //This long chain of methods deals the players their cards
            players[0].getHand().addCards(gameDeck.dealCards(this.getHandSize()));
            players[1].getHand().addCards(gameDeck.dealCards(this.getHandSize()));

            System.out.println("These are your cards, " + players[0].getHand());
        }
        else if(round == 2) {
            System.out.println("These are the community cards:");
            communityCards.addCards(gameDeck.dealCards(3));
            System.out.println(communityCards);
            System.out.println("These are your cards " + players[0].getHand());
        }
        else {
            communityCards.addCards(gameDeck.dealCards(1));
            System.out.println("These are the community cards:");
            System.out.println(communityCards);
            System.out.println("These are your cards " + players[0].getHand());
        }
    }

    //Returns the cards of the player and of the community cards combined
    public Deck getCommunityCards() {
        return this.communityCards;
    }



}
