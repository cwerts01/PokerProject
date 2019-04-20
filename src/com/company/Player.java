package com.company;

public abstract class Player {

    private boolean isChecked;
    private double wallet;
    private double amountBet;

    public abstract void call();

    public abstract void raise();

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
}