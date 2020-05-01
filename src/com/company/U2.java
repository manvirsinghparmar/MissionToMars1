package com.company;

import java.util.Random;

public class U2 extends Rocket {

    private static int rocketCost=12;
    private int rocketmaxcargo=18000;
    private static int rocketcounterU2;
    private double chanceOfLaunchExplosionU2;
    private double chanceOfLandingCrashU2;


    public U2() {
        this(0);
    }

    public U2(int lastWeight) {
        setMaxCargo(maxCargo);
        setCost(cost);
        setWeight(weight);
        setCurrentWeight(lastWeight);

        rocketcounterU2++;
        System.out.println("------------------------------------");
    }

    @Override
    public boolean land() {

        Random random=new Random();

        double landchances=random.nextDouble();

        chanceOfLandingCrashU2= 0.08 * (getTotalWeight() / rocketmaxcargo);

        if(landchances>chanceOfLandingCrashU2){

            System.out.println("U2 Crashed!!");
            System.out.println("...Sending another rocket because it crashed...");

            return false;

        }

        System.out.println("U2 landed successfully!");
        return super.land();
    }

    @Override
    public boolean launch() {


        Random random=new Random();

        double landchances=random.nextDouble();

        chanceOfLaunchExplosionU2= 0.04 * (getTotalWeight() / rocketmaxcargo);

        if(landchances>chanceOfLaunchExplosionU2){

            System.out.println("U2 Exploded!");
            System.out.println("...Sending another rocket because it exploded...");

            return false;

        }
        System.out.println("U2 launched successfully!");
        return super.launch();
    }

    public  static int getRocketU2Counter() {
        return rocketcounterU2;
    }

    public static void setRocketcounterU2(int rocketcounterU2) {
        U2.rocketcounterU2 = rocketcounterU2;
    }

    public static long getTotalCost() {
        return (long) getRocketU2Counter() * rocketCost;
    }
}
