package com.company;

public abstract class Player {

    private boolean isChecked;
    private double wallet;
    private double amountBet;

    public void call(double amount, double pot) {
        if(this.wallet - amount >= 0 ) {
            this.putMoneyInPot(amount);
        }
        else {
            this.putMoneyInPot(this.wallet);
        }
    }

    public void check() {
        this.isChecked = true;
    }


    public void raise(double amount) {
        this.putMoneyInPot(amount);
    }

    public boolean getCheckStatus() {
        return isChecked;
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

    public abstract void makeDecision();
}