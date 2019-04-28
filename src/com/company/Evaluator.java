package com.company;

import java.util.ArrayList;

public class Evaluator {

    public String calculateHand(Deck myHand) {
        myHand.sortByRank();
        if(this.straightFlush(myHand) > 0) {
            return "9 " + this.straightFlush(myHand);
        }
        if(this.fourOfAKind(myHand) > 0) {
            return "8 " + this.fourOfAKind(myHand);
        }
        if(this.fullHouse(myHand) > 0) {
            return "7 " + this.fullHouse(myHand);
        }
        if(this.flush(myHand) > 0) {
            return "6 " + this.flush(myHand);
        }
        if(this.straight(myHand) > 0) {
            return "5 " + this.straight(myHand);
        }
        if(this.threeOfAKind(myHand) > 0) {
            return "4 " + this.threeOfAKind(myHand);
        }
        if(this.twopair(myHand) > 0) {
            return "3 " + this.twopair(myHand);
        }
        if(this.pair(myHand) > 0) {
            return "2 " + this.pair(myHand);
        }

        //Returns the highest card instead
        return "1 " + myHand.getDeck().get(myHand.getDeck().size()-1).getNumber();
    }


    public String compareHands(Player[] players) {

        String player1 = this.calculateHand(players[0].getHand());
        String player2 = this.calculateHand(players[1].getHand());

        System.out.println(players[0].getHand());
        System.out.println(players[1].getHand());

        System.out.println(player1);
        System.out.println(player2);


        if(Integer.parseInt(player1.substring(0,1)) > Integer.parseInt(player2.substring(0,1))) {
            return "player 1";
        }
        else if(Integer.parseInt(player1.substring(0,1)) < Integer.parseInt(player2.substring(0,1))) {
            return "player 2";
        }
        else {
            if(Integer.parseInt(player1.substring(2)) == Integer.parseInt(player2.substring(2))) {
                return this.highestCard(players);
            }
            else if(Integer.parseInt(player1.substring(2)) > Integer.parseInt(player2.substring(2))) {
                return "player 1";
            }
            else {
                return "player 2";
            }
        }

    }

    public String highestCard(Player[] players) {
        players[0].getHand().sortByRank();
        players[1].getHand().sortByRank();

        ArrayList<Card> player1 = players[0].getHand().getDeck();
        ArrayList<Card> player2 = players[1].getHand().getDeck();

        for(int i = player1.size()-1; i >= 0; i--) {
            if(player1.get(i).getNumber() == player2.get(i).getNumber()) {
                player1.remove(i);
                player2.remove(i);
            }
            else if(player1.get(i).getNumber() > player2.get(i).getNumber()) {
                return "player 1";
            }
            else {
                return "player 2";
            }
        }

        return "split";
    }

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
        int counterStart = 0;
        for(int i = 0; i <myHand.getDeck().size()-1; i++) {
            Card b = myHand.getDeck().get(i+1);

            //In the check it does makes sure its a straight and of the same suit
            if(myHand.getDeck().get(i).getNumber() - b.getNumber() == -1 && myHand.getDeck().get(i).getSuit().equalsIgnoreCase(b.getSuit())) {
                counter++;
                if(counter == 1)
                    counterStart = i;
            }

            //There was a weird case with texas holdem and the straight flush variant, this takes care of it
            else if(myHand.getDeck().get(i).getNumber() == b.getNumber()) {
                if(i < myHand.getDeck().size()-2) {
                    Card c = myHand.getDeck().get(i+2);
                    if(c.getSuit().equalsIgnoreCase(myHand.getDeck().get(counterStart).getSuit()))
                        if(counter >=4)
                            highestCard = b.getNumber();
                        counter = 0;
                }
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
