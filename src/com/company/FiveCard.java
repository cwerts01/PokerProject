package com.company;

import java.util.Scanner;

public class FiveCard implements Rules {
    private final int handSize = 5;
    private final int finalRound = 2;
    Deck communityCards = new Deck();
    Scanner key = new Scanner(System.in);

    public int getHandSize() {
        return this.handSize;
    }

    public int getFinalRound() {
        return this.finalRound;
    }

    public void nextRound(int round, Deck gameDeck, Player[] players) {
        if(round == 1) {
            players[0].getHand().addCards(gameDeck.dealCards(this.getHandSize()));
            players[1].getHand().addCards(gameDeck.dealCards(this.getHandSize()));

            players[0].getHand().sortByRank();
            System.out.println("These are your cards, " + players[0].getHand());
        }
        else {
            players[0].getHand().sortByRank();
            System.out.println("These are your cards, " + players[0].getHand());
            System.out.println("Would you like to swap any of your cards? If so enter yes, if not enter no");
            String response = key.nextLine();
            if(response.equalsIgnoreCase("Yes")) {
                this.swapCards(gameDeck, players);
            }
            else if(response.equalsIgnoreCase("No")) {
                return;
            }
            else {
                System.out.println("Please enter a valid response \n");
                this.nextRound(round, gameDeck, players);
            }

        }

    }

    //Returns the cards of the player and of the community cards combined
    public Deck getCommunityCards() {
        return this.communityCards;
    }

    private void swapCards(Deck gameDeck, Player[] players) {
        System.out.println("Enter the index (between 1 and 5) of your cards you would like to swap out separated by commas,. E.g 1,4,5");
        players[0].getHand().sortByRank();
        System.out.println(players[0].getHand());
        String cards = key.nextLine();

        //Actually swapping the cards, annoying to deal with an arrayList, it will add the new card to the back, set the card its supposed to swap and then remove the card at the end to keep order
        String[] swaps = cards.split(",");
        for(int i = 0; i < swaps.length; i++) {
            int swap = Integer.parseInt(swaps[i])-1;
            players[0].getHand().addCards(gameDeck.dealCards(1));
            players[0].getHand().getDeck().set(swap, players[0].getHand().getDeck().get(5));
            players[0].getHand().getDeck().remove(5);

        }
        System.out.println("These are your new cards, " + players[0].getHand());
    }
}
