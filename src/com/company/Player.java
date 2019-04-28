package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Player {

    //TODO add a fold method for the player

    private boolean isFolded;
    private boolean isChecked;
    private double wallet;
    private double amountBet;
    private Deck hand = new Deck();
    Scanner key = new Scanner(System.in);

    //Player action methods
    public void call(double pot) {
        if(this.wallet - (pot * (2 - this.amountBet)) >= 0 ) {
            this.putMoneyInPot(pot * (2 - this.amountBet));
        }
        else {
            this.putMoneyInPot(this.wallet);
        }
        this.unCheck();
    }

    public void check() {
        this.isChecked = true;
    }

    public void raise(double amount) {
        this.putMoneyInPot(amount);
        this.unCheck();
    }

    private void unCheck() {
        this.isChecked = false;
    }

    public void fold() {
        this.isFolded = true;
    }

    public void clearHand() {
        this.hand = new Deck();
    }


    //Getters and Setters
    public boolean getCheckStatus() {
        return isChecked;
    }
    public boolean getFoldStatus() {
        return isFolded;
    }

    public double getAmountBet() {
        return this.amountBet;
    }

    public double getWallet() {
        return this.wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public void setAmountBet(double amountBet) {
        this.amountBet = amountBet;
    }

    public void setCheckStatus(boolean status) {
        isChecked = status;
    }

    public void setFoldStatus(boolean status) {
        this.isFolded = status;
    }

    public Deck getHand() {
        return this.hand;
    }



    //Private methods
    private void putMoneyInPot(double amount) {
        this.wallet-=amount;
        this.amountBet+=amount;

    }

    private void addMoney(double amount) {
        this.wallet+=amount;
    }


    //Check methods to see if the player can do an action
    public boolean canCall(double pot) {
        if(pot - 2 * this.getAmountBet() > 0 ) {
            return true;
        }
        return false;
    }

    public boolean canCheck(double pot) {
        if(pot - this.getAmountBet()*2 <= 0 || this.getWallet() <= 0) {
            return true;
        }
        return false;
    }

    public boolean canRaise(double amount, double pot) {
        if(pot - 2* this.getAmountBet() >= 0 && this.getWallet() - amount >=0 ) {
            return true;
        }
        return false;
    }

    public abstract void makeDecision(double pot);

    public abstract void evaluateDecision(double pot, Deck deck, int round, Rules rules);


}