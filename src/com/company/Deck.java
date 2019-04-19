package com.company;

import java.util.ArrayList;

public class Deck {
    ArrayList<Card> deck = new ArrayList<>();

    //TODO implement shuffle method

    private void initDeck(){
        deck.clear();
        for (int i=0;i<4;i++){
            for(int j = 0; j<13; j++) {
                Card newCard = new Card(Card.getSuits().get(i), j+2);
                deck.add(newCard);
            }

        }
    }

    //Easy method to set a hand of cards to test if the methods work for evaluator.
    public void setHand() {
        deck.clear();
        deck.add(new Card("Diamonds", 14));
        deck.add(new Card("Hearts", 3));
        deck.add(new Card("Spades", 7));
        deck.add(new Card("Clubs", 4));
        deck.add(new Card("Diamonds", 14));
    }

    public void shuffle() {

    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public Deck() {
    }

    //Uses an insertion sort for the numbers
    public void sortByRank(){
        for(int i = 1; i < deck.size(); i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(deck.get(i).getNumber() - deck.get(j).getNumber() < 0)
                {
                    //Moves all the other elements up one;
                    Card temp = deck.get(i);
                    for (int q = i; q >= j+1; q--)
                    {
                        deck.set(q, deck.get(q-1));
                    }
                    deck.set(j, temp);
                    break;
                }
            }
        }
    }

    public void sortBySuit(){
        for(int i = 1; i < deck.size(); i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(deck.get(i).getSuit().compareTo(deck.get(j).getSuit()) < 0)
                {
                    //Moves all the other elements up one;
                    Card temp = deck.get(i);
                    for (int q = i; q >= j+1; q--)
                    {
                        deck.set(q, deck.get(q-1));
                    }
                    deck.set(j, temp);
                    break;
                }
            }
        }
    }

    public String toString() {
        return deck.toString();
    }
}