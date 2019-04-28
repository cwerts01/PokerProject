package com.company;

public class ComputerPlayer extends Player {
    private String move;
    private Evaluator evaluator = new Evaluator();
    private int highestNum=0;

    public void evaluateDecision(double pot, Deck hand, int round, Rules rules) {
        if (round==0){
            if (this.canCall(pot)){
                this.call(pot);
                System.out.println("The opponent has called");
            }
            else {
                this.fold();
            }
        }
        else if (round==1){
            if (evaluator.pair(hand)>0)
            {
                move="2";
                highestNum = evaluator.pair(hand);
            }
            else {
                move = "1";
                for (Card card: hand.getDeck()){
                    if (card.getNumber()>highestNum){
                        highestNum=card.getNumber();
                    }
                }
            }
            if (move.equals("2")){
                if (this.canRaise(getAmountBet()+ 10, pot)){
                    this.raise(getAmountBet() + 10);
                    System.out.println("The opponent has raised");
                }
                else if (this.canCall(pot)){
                    this.canCall(pot);
                    System.out.println("The opponent has called");
                }
            }
            else {
                if (highestNum>=11){
                    if (this.canRaise(getAmountBet()+10, pot)){
                        this.raise(getAmountBet()+10);
                        System.out.println("The opponent raised");
                    }
                    else if (this.canCheck(pot)){
                        this.check();
                        System.out.println("The opponent checked");
                    }
                    else if (this.canCall(pot)){
                        this.call(pot);
                        System.out.println("The opponent called");
                    }
                    else{
                        this.fold();
                    }
                }
                else {
                    if (this.canCall(pot)){
                        this.call(pot);
                        System.out.println("The opponent has called");
                    }
                    else {
                        this.fold();
                    }
                }
            }
        }
        else if (round==2){
            if (rules instanceof FiveCard){
                if(evaluator.straightFlush(hand)<=0 && evaluator.fourOfAKind(hand)<=0 && evaluator.fullHouse(hand)<=0 && evaluator.flush(hand)<=0&& evaluator.straight(hand)<=0&&evaluator.twopair(hand)>0){
                    ((FiveCard) rules).swapCards(hand, evaluator);
                }
            }
            else {
                if (evaluator.straightFlush(hand)>0){
                    move = "9";
                    highestNum = evaluator.straightFlush(hand);
                }
                else if (evaluator.fourOfAKind(hand)>0){
                    move = "8";
                    highestNum = evaluator.fourOfAKind(hand);
                }
                else if (evaluator.fullHouse(hand)>0){
                    move = "7";
                    highestNum = evaluator.fullHouse(hand);
                }
                else if (evaluator.flush(hand)>0){
                    move = "6";
                    highestNum = evaluator.flush(hand);
                }
                else if (evaluator.straight(hand)>0){
                    move = "5";
                    highestNum = evaluator.straight(hand);
                }
                else if (evaluator.threeOfAKind(hand)>0){
                    move = "4";
                    highestNum = evaluator.threeOfAKind(hand);
                }
                else if (evaluator.twopair(hand)>0){
                    move = "3";
                    highestNum = evaluator.twopair(hand);
                }
                else if (evaluator.pair(hand)>0){
                    move = "2";
                    highestNum = evaluator.pair(hand);
                }
                else {
                    move = "1";
                    for (Card card: hand.getDeck()){
                        if (card.getNumber()>highestNum){
                            highestNum=card.getNumber();
                        }
                    }
                }
                if (move.equals("9"))
                {
                    if (this.canRaise(getAmountBet()+20, pot)){
                        this.raise(getAmountBet()+20);
                        System.out.println("The opponent has raised");
                }
                    else if (this.canCall(pot)){
                        this.call(pot);
                        System.out.println("The opponent has called");
                    }
                    else if (this.canCheck(pot)){
                        this.check();
                        System.out.println("The opponent checked");
                    }
                    else {
                        this.fold();
                    }
                }
                else if (move.equals("8")){
                    if (this.canRaise(getAmountBet()+20, pot)){
                        this.raise(getAmountBet()+20);
                        System.out.println("The opponent has raised");
                    }
                    else if (this.canCall(pot)){
                        this.call(pot);
                        System.out.println("The opponent has called");
                    }
                    else if (this.canCheck(pot)){
                        this.check();
                        System.out.println("The opponent checked");
                    }
                    else{
                        this.fold();
                    }
                }
                else if (move.equals("7")){
                    if (this.canRaise(getAmountBet()+15, pot)){
                        this.raise(getAmountBet()+15);
                    }
                    else if (this.canCall(pot)){
                        this.call(pot);
                        System.out.println("The opponent has called");
                    }
                    else if (this.canCheck(pot)){
                        this.check();
                        System.out.println("The opponent checked");
                    }
                    else{
                        this.fold();
                    }
                }
                else if (move.equals("6")){
                    if (this.canRaise(getAmountBet()+10, pot)){
                        this.raise(getAmountBet()+10);
                        System.out.println("The opponent has raised");
                    }
                    else if (this.canCall(pot)){
                        this.call(pot);
                        System.out.println("The opponent has called");
                    }
                    else if (this.canCheck(pot)){
                        this.check();
                        System.out.println("The opponent checked");
                    }
                    else{
                        this.fold();
                    }
                }
                else if (move.equals("5")){
                    if (this.canRaise(getAmountBet()+10, pot)){
                        this.raise(getAmountBet()+10);
                        System.out.println("The opponent has raised");
                    }
                    else if (this.canCall(pot)){
                        this.call(pot);
                        System.out.println("The opponent has called");
                    }
                    else if (this.canCheck(pot)){
                        this.check();
                        System.out.println("The opponent checked");
                    }
                    else{
                        this.fold();
                    }
                }
                else if (move.equals("4")){
                    if (this.canRaise(getAmountBet()+5, pot)){
                        this.raise(getAmountBet()+5);
                        System.out.println("The opponent has raised");
                    }
                    else if (this.canCall(pot)){
                        this.call(pot);
                        System.out.println("The opponent has called");
                    }
                    else{
                        this.fold();
                    }
                }
                else if (move.equals("3")){
                    if (this.canRaise(getAmountBet()+5, pot)){
                        this.raise(getAmountBet()+5);
                        System.out.println("The opponent has raised");
                    }
                    else if (this.canCheck(pot)){
                        this.check();
                        System.out.println("The opponent checked");
                    }
                    else if (this.canCall(pot)){
                        this.call(pot);
                        System.out.println("The opponent has called");
                    }
                    else{
                        this.fold();
                    }
                }
                else if (move.equals("2") || move.equals("1")){
                    if (this.canCheck(pot)){
                        this.check();
                        System.out.println("The opponent checked");
                    }
                    else if (this.canCall(pot)){
                        this.call(pot);
                        System.out.println("The opponent has called");
                    }
                    else{
                        this.fold();
                    }
                }
            }
        }
        else {
            if (evaluator.straightFlush(hand)>0){
                move = "9";
                highestNum = evaluator.straightFlush(hand);
            }
            else if (evaluator.fourOfAKind(hand)>0){
                move = "8";
                highestNum = evaluator.fourOfAKind(hand);
            }
            else if (evaluator.fullHouse(hand)>0){
                move = "7";
                highestNum = evaluator.fullHouse(hand);
            }
            else if (evaluator.flush(hand)>0){
                move = "6";
                highestNum = evaluator.flush(hand);
            }
            else if (evaluator.straight(hand)>0){
                move = "5";
                highestNum = evaluator.straight(hand);
            }
            else if (evaluator.threeOfAKind(hand)>0){
                move = "4";
                highestNum = evaluator.threeOfAKind(hand);
            }
            else if (evaluator.twopair(hand)>0){
                move = "3";
                highestNum = evaluator.twopair(hand);
            }
            else if (evaluator.pair(hand)>0){
                move = "2";
                highestNum = evaluator.pair(hand);
            }
            else {
                move = "1";
                for (Card card: hand.getDeck()){
                    if (card.getNumber()>highestNum){
                        highestNum=card.getNumber();
                    }
                }
            }
            if (move.equals("9"))
            {
                if (this.canRaise(getAmountBet()+20, pot)){
                    this.raise(getAmountBet()+20);
                    System.out.println("The opponent has raised");
                }
                else if (this.canCall(pot)){
                    this.call(pot);
                    System.out.println("The opponent has called");
                }
                else if (this.canCheck(pot)){
                    this.check();
                    System.out.println("The opponent checked");
                }
                else {
                    this.fold();
                }
            }
            else if (move.equals("8")){
                if (this.canRaise(getAmountBet()+15, pot)){
                    this.raise(getAmountBet()+15);
                    System.out.println("The opponent has raised");
                }
                else if (this.canCall(pot)){
                    this.call(pot);
                    System.out.println("The opponent has called");
                }
                else if (this.canCheck(pot)){
                    this.check();
                    System.out.println("The opponent checked");
                }
                else{
                    this.fold();
                }
            }
            else if (move.equals("7")){
                if (this.canRaise(getAmountBet()+15, pot)){
                    this.raise(getAmountBet()+15);
                    System.out.println("The opponent has raised");
                }
                else if (this.canCall(pot)){
                    this.call(pot);
                    System.out.println("The opponent has called");
                }
                else if (this.canCheck(pot)){
                    this.check();
                    System.out.println("The opponent checked");
                }
                else{
                    this.fold();
                }
            }
            else if (move.equals("6")){
                if (this.canRaise(getAmountBet()+10, pot)){
                    this.raise(getAmountBet()+10);
                    System.out.println("The opponent has raised");
                }
                else if (this.canCall(pot)){
                    this.call(pot);
                    System.out.println("The opponent has called");
                }
                else if (this.canCheck(pot)){
                    this.check();
                    System.out.println("The opponent checked");
                }
                else{
                    this.fold();
                }
            }
            else if (move.equals("5")){
                if (this.canRaise(getAmountBet()+10, pot)){
                    this.raise(getAmountBet()+10);
                    System.out.println("The opponent has raised");
                }
                else if (this.canCheck(pot)){
                    this.check();
                    System.out.println("The opponent checked");
                }
                else if (this.canCall(pot)){
                    this.call(pot);
                    System.out.println("The opponent has called");
                }
                else{
                    this.fold();
                }
            }
            else if (move.equals("4")){
                if (this.canRaise(getAmountBet()+5, pot)){
                    this.raise(getAmountBet()+5);
                    System.out.println("The opponent has raised");
                }
                else if (this.canCheck(pot)){
                    this.check();
                    System.out.println("The opponent checked");
                }
                else if (this.canCall(pot)){
                    this.call(pot);
                    System.out.println("The opponent has called");
                }
                else{
                    this.fold();
                }
            }
            else if (move.equals("3")){
                if (this.canRaise(getAmountBet()+5, pot)){
                    this.raise(getAmountBet()+5);
                    System.out.println("The opponent has raised");
                }
                else if (this.canCheck(pot)){
                    this.check();
                    System.out.println("The opponent checked");
                }
                else if (this.canCall(pot)){
                    this.call(pot);
                    System.out.println("The opponent has called");
                }
                else{
                    this.fold();
                }
            }
            else if (move.equals("2") || move.equals("1")){
                if (this.canCheck(pot)){
                    this.check();
                    System.out.println("The opponent checked");
                }
                else if (this.canCall(pot)){
                    this.call(pot);
                    System.out.println("The opponent has called");
                }
                else{
                    this.fold();
                }
            }
        }
    }
    public void makeDecision(double pot){

    }
}