package com.company;

import java.util.ArrayList;

public class HandCards {
    private ArrayList<Card> hand = new ArrayList<>();

    public HandCards() {}

    public ArrayList<Card> getHand() {
        return hand;
    }



    //Using an insertion sort to sort the hand by rank, use the same for deck of cards


    public String toString() {
        return hand.toString();
    }
}