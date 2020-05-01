package com.company;

import java.util.Random;

public class U1 extends Rocket {

    private static int  rocketCost=10;
    private int rocketmaxcargo=8000;
    private static  int  rocketcounterU1;
    private double chanceOfLaunchExplosionU1;
    private double chanceOfLandingCrashU1;


    public U1(int lastWeight) {
        setMaxCargo(maxCargo);
        setCost(cost);
        setWeight(weight);
        setCurrentWeight(lastWeight);

        rocketcounterU1++;
        System.out.println("------------------------------------");
    }

    public U1() {
        this(0);
    }



    @Override
    public boolean land() {

        System.out.println("\nLANDING...");

        Random random=new Random();

        double landchances=random.nextDouble();

        System.out.println("RANDOM CHANCES:" + landchances);

        chanceOfLandingCrashU1= 0.01 * (getTotalWeight() / rocketmaxcargo);

        if(landchances>chanceOfLandingCrashU1){

            System.out.println("U1 CRASHED!!!");
            System.out.println("...Sending another rocket because it crashed...");

        return false;

        }

        System.out.println("U1 landed successfully!");

        return super.land();

    }

    @Override
    public boolean launch() {

        System.out.println("\nLAUNCHING...");

        Random random=new Random();

        double Launchchances=random.nextDouble();

        chanceOfLaunchExplosionU1= 0.05 * (getTotalWeight() / rocketmaxcargo);

        if(Launchchances>chanceOfLaunchExplosionU1){

            System.out.println("U1 EXPLODED!!!");
            System.out.println("...Sending another rocket because it exploded...");

            return false;

        }
        System.out.println("U1 launched successfully!");
        return super.launch();
    }

    public static int getRocketcounterU1() {
        return rocketcounterU1;
    }

    public static void setRocketcounterU1(int rocketcounterU1) {
        U1.rocketcounterU1 = rocketcounterU1;
    }

    public int getRocketCost() {
        return rocketCost;
    }

    public int getRocketmaxcargo() {
        return rocketmaxcargo;
    }

    public void setRocketCost(int rocketCost) {
        this.rocketCost = rocketCost;
    }

    public void setRocketmaxcargo(int rocketmaxcargo) {
        this.rocketmaxcargo = rocketmaxcargo;
    }

    public static long getTotalCost() {
        return (long) getRocketcounterU1() * rocketCost;
    }
}
