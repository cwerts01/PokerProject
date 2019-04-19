package com.company;

public class Evaluator {

    public String calculateHand(DeckOfCards myHand) {
        int[] value = new int[4];
        value[0] = this.pair(myHand);
        value[1] = this.twopair(myHand);
        if(value[0] != 0) {
            return "You have a pair!";
        }
        return "nothing";
    }

    //TODO Go through and make sure that all the methods work, also have to make a
    //TODO method that allows me to choose my hand so I know that the evals work.

    //This has to make sure to not mistake three of a kind for a two pair so each pair I find I go up another card.
    public int twopair(DeckOfCards myHand) {
        myHand.sortByRank();
        int highestPair = 0;
        int pairs = 0;

        for(int i = 0; i < myHand.getDeck().size()-1; i++) {
            Card temp = myHand.getDeck().get(i+1);
            if(myHand.getDeck().get(i).getNumber() == temp.getNumber()) {
                pairs++;
                i++;
                highestPair = temp.getNumber();
            }
        }
        if(pairs >= 2)
            return highestPair;
        else return 0;

    }

    public int pair(DeckOfCards myHand) {
        myHand.sortByRank();
        int highestPair = 0;

        for(int i = 0; i <myHand.getDeck().size()-1; i++) {
            Card temp = myHand.getDeck().get(i+1);
            if(myHand.getDeck().get(i).getNumber() == temp.getNumber()) {
                highestPair = temp.getNumber();
            }
        }
        return highestPair;

    }
}
