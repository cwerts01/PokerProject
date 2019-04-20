package com.company;


import java.util.ArrayList;
import java.util.Arrays;

public class Card {

    private String suit;
    private int number;
    private final static ArrayList<String> suits = new ArrayList<>(Arrays.asList("Clubs", "Diamonds", "Hearts", "Spades"));

    public String getSuit() {
        return suit;
    }

    public int getNumber() {
        return number;
    }

    public static ArrayList<String> getSuits() {
        return suits;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    public Card(){

    }

    public Card(String suit, int number) {
        this.suit = suit;
        this.number = number;

    }

    public String toString() {
        String ret = "";
        if(this.number == 11)
            ret = "Jack of ";
        else if(this.number == 12)
            ret = "Queen of ";
        else if(this.number == 13)
            ret = "King of ";
        else if(this.number == 14)
            ret = "Ace of ";
        else
            ret = this.number + " of ";

        return ret + this.suit;
    }
}
