package com.company;

public interface Rules {

    public boolean canCall(Player player, double amount);
    public boolean canCheck(Player player);
    public boolean canRaise(Player player, double amount);

    public void nextRound(int round);
}
