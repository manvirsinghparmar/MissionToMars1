package com.company;

public class Rocket implements  SpaceShip {

    private int currentWeight;
     int weight;
     int maxCargo;
     private double totalWeight = currentWeight + weight;
     int cost;

    @Override
    public boolean launch()

    {
        return true;
    }

    @Override
    public boolean land()

    {
        return true;
    }

    @Override
    public boolean canCarry(Item item) {

        if(totalWeight<=(currentWeight+item.getWeight())) {

            return true;
        }
        return false;
    }

    @Override
    public boolean carry(Item item) {

            currentWeight=currentWeight+item.getWeight();

        return true;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getTotalWeight() {

        totalWeight=getWeight()+getCurrentWeight();
        return totalWeight;
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public int getCost() {
        return cost;
    }

    public int getMaxCargo() {
        return maxCargo;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }

    public void setMaxCargo(int maxCargo) {
        this.maxCargo = maxCargo;


    }

    public void setTotalWeight(double totalWeight) {
        this.totalWeight = totalWeight;
    }
}
