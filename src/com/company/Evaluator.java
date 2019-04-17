package com.company;

public class Evaluator {

    public static void calculateHand() {

    }

    //TODO Go through and make sure that all the methods work, also have to make a
    //TODO method that allows me to choose my hand so I know that the evals work.

    //This has to make sure to not mistake three of a kind for a two pair so each pair I find I go up another card.
    public int twopair(HandCards hand) {
        hand.sortByNumber();
        int highestPair = 0;
        int pairs = 0;

        for(int i = 0; i <hand.getHand().size()-1; i++) {
            Card temp = hand.getHand().get(i+1);
            if(hand.getHand().get(i).getNumber() == temp.getNumber()) {
                pairs++;
                i++;
                highestPair = temp.getNumber();
            }
        }
        if(pairs >= 2)
            return highestPair;
        else return 0;

    }

    public int pair(HandCards hand) {
        hand.sortByNumber();
        int highestPair = 0;

        for(int i = 0; i <hand.getHand().size()-1; i++) {
            Card temp = hand.getHand().get(i+1);
            if(hand.getHand().get(i).getNumber() == temp.getNumber()) {
                highestPair = temp.getNumber();
            }
        }
        return highestPair;

    }
}
