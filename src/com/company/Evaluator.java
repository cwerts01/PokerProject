package com.company;

public class Evaluator {

    public String calculateHand(Deck myHand) {
        return "yay";
    }

    //TODO Go through and make sure that all the methods work, also have to make a

    //This has to make sure to not mistake three of a kind for a two pair so each pair I find I go up another card.
    public int twopair(Deck myHand) {
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

    //When checking a pair make sure that a three of a kind isn't seen as just a pair otherwise
    public int pair(Deck myHand) {
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

    //Three of a kind, uses a counter to make sure there are three of the same
    public int threeOfAKind(Deck myHand) {
        myHand.sortByRank();
        int counter = 0;
        int highestCard = 0;
        for(int i = 0; i <myHand.getDeck().size()-1; i++) {
            Card b = myHand.getDeck().get(i+1);
            if(myHand.getDeck().get(i).getNumber() == b.getNumber())
                counter++;
            else
                counter = 0;

            //If there is three of a kind return it
            if(counter >= 2)
                highestCard = b.getNumber();
        }
        return highestCard;

    }

    //Same way to check as three of a kind, just a higher break point for the return method.
    public int fourOfAKind(Deck myHand) {
        myHand.sortByRank();
        int counter = 0;
        int highestCard = 0;
        for(int i = 0; i <myHand.getDeck().size()-1; i++) {
            Card b = myHand.getDeck().get(i+1);
            if(myHand.getDeck().get(i).getNumber() == b.getNumber())
                counter++;
            else
                counter = 0;

            //If there is three of a kind return it
            if(counter >= 3)
                highestCard = b.getNumber();
        }
        return highestCard;
    }

    public int straight(Deck myHand) {
        myHand.sortByRank();
        int counter = 0;
        int highestCard = 0;
        for(int i = 0; i <myHand.getDeck().size()-1; i++) {
            Card b = myHand.getDeck().get(i+1);


            if(myHand.getDeck().get(i).getNumber() - b.getNumber() == -1) {
                counter++;
            }
            else if(myHand.getDeck().get(i).getNumber() == b.getNumber()) {
                counter = counter;
            }
            else {
                counter = 0;
            }

            //Setting the highest straight card
            if(counter >= 4)
                highestCard = b.getNumber();
        }
        return highestCard;
    }

    //Same method as a straight but with suits instead of number
    public int flush(Deck myHand) {
        myHand.sortBySuit();
        int counter = 0;
        int highestCard = 0;
        for(int i = 0; i <myHand.getDeck().size()-1; i++) {
            Card b = myHand.getDeck().get(i+1);

            //Checking if the suits of the cards are equal
            if(myHand.getDeck().get(i).getSuit().equalsIgnoreCase(b.getSuit())) {
                counter++;
            }
            else {
                counter = 0;
            }

            //Setting the highest of the flush
            if(counter >= 4)
                highestCard = b.getNumber();
        }
        return highestCard;
    }

    //Same as the check for a straight, but it also makes sure it is of the same suit before increasing the counter.
    public int straightFlush(Deck myHand) {
        myHand.sortByRank();
        int counter = 0;
        int highestCard = 0;
        for(int i = 0; i <myHand.getDeck().size()-1; i++) {
            Card b = myHand.getDeck().get(i+1);

            //In the check it does makes sure its a straight and of the same suit
            if(myHand.getDeck().get(i).getNumber() - b.getNumber() == -1 &&
                    myHand.getDeck().get(i).getSuit().equalsIgnoreCase(b.getSuit())) {
                counter++;
            }
            else if(myHand.getDeck().get(i).getNumber() == b.getNumber()) {
                counter = counter;
            }
            else {
                counter = 0;
            }

            //Setting the highest straight card
            if(counter >= 4)
                highestCard = b.getNumber();
        }
        return highestCard;
    }

    public int fullHouse(Deck myHand) {

        if(this.threeOfAKind(myHand) != this.pair(myHand))
            return this.threeOfAKind(myHand);
        else return 0;
    }

}
