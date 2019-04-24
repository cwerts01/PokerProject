package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Player {

    private boolean isChecked;
    private double wallet;
    private double amountBet;
    private Deck hand = new Deck();
    Scanner key = new Scanner(System.in);

    public void call(double amount, double pot) {
        if(this.wallet - amount >= 0 ) {
            this.putMoneyInPot(amount);
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

    public boolean getCheckStatus() {
        return isChecked;
    }

    private void unCheck() {
        this.isChecked = false;
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

    private void putMoneyInPot(double amount) {
        this.wallet-=amount;
        this.amountBet+=amount;

    }
    private void addMoney(double amount) {
        this.wallet+=amount;
    }
    public void setCheckStatus(boolean status) {
        isChecked = status;
    }

    public Deck getHand() {
        return this.hand;
    }


    public abstract void makeDecision();
}