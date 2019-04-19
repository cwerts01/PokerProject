package com.company;

import java.util.ArrayList;

public class DeckOfCards {
    ArrayList<Card> deck = new ArrayList<>();

    private void createDeck(){
        deck.clear();
        for (int i=0;i<4;i++){
            for(int j = 0; j<13; j++) {
                Card newCard = new Card(Card.getSuits().get(i), j+2);
                deck.add(newCard);
            }

        }
    }

    public void setHand() {
        deck.add(new Card("Clubs", 4));
        deck.add(new Card("Clubs", 3));
        deck.add(new Card("Clubs", 7));
        deck.add(new Card("Clubs", 2));
        deck.add(new Card("Clubs", 14));
    }

    public void shuffle() {

    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public DeckOfCards() {
        this.createDeck();
    }

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

    public String toString() {
        return deck.toString();
    }
}