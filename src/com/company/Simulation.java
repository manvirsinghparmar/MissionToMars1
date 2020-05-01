package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Simulation {


    private ArrayList<Rocket> rocketU1;

    private ArrayList<Rocket> rocketU2;

     private  ArrayList<Item> listofItems;

    private boolean hasLanded = true;

     ArrayList<Item> loadItems(String fileName) throws FileNotFoundException {

         File file= new File(fileName);

         Scanner scanner = new Scanner(file);

        listofItems= new ArrayList<>();

        while (scanner.hasNextLine()) {

            String line = scanner.nextLine();

            String[] oneItem = line.split("=");

            listofItems.add(new Item(oneItem[0],Integer.parseInt(oneItem[1])));
        }
         //for (Item i : listofItems) {
           //System.out.println(i.name + ": " + i.weight);
        //}
        //System.out.println(listofItems);

        return listofItems;
    }

    public ArrayList<Rocket> loadU1(List<Item> itemsU1 ) {
        System.out.println("loading U1...");
        rocketU1 = new ArrayList<>();
        Rocket rocket = new U1();
        Iterator iterator = itemsU1.iterator();

        while (iterator.hasNext()) {
            Item item = (Item) iterator.next();
            if (rocket.canCarry(item)) {
                rocket.carry(item);
            } else {
                rocketU1.add(rocket);
                rocket = new U1();
                System.out.println("New U1 rocket created");
                rocket.carry(item);
            }
            if (!iterator.hasNext()) {
                rocketU1.add(rocket);
            }
        }

        System.out.println(rocketU1);

        return rocketU1;


    }


    public ArrayList<Rocket> loadU2(ArrayList<Item> itemsU2) {
        System.out.println("loading U2");
        rocketU2 = new ArrayList<>();
        Rocket rocket = new U2();
        Iterator iterator = itemsU2.iterator();

        while (iterator.hasNext()) {
            Item item = (Item) iterator.next();
            if (rocket.canCarry(item)) {
                rocket.carry(item);
            } else {
                rocketU2.add(rocket);
                rocket = new U2();
                System.out.println("New U2 rocket created");
                rocket.carry(item);
            }
            if (!iterator.hasNext()) {
                rocketU2.add(rocket);
            }
        }

        return rocketU2;
    }

    public void runSimulation(ArrayList<Rocket> rockets, int i) {

        for (Rocket rocket : rockets) {

            while (!rocket.launch()) {
                launchSimulation(i);
            }

            while (!rocket.land()) {
                while (!rocket.launch()) {
                    launchSimulation(i);
                }
                landSimulation(i);
            }

        }
    }

    public void launchSimulation(int i) {

        if (i == 1) {

            System.out.println("Launch Simulation started for U1");
            int counter1 = U1.getRocketcounterU1();
            counter1++;
            U1.setRocketcounterU1(counter1);

        } else {

            System.out.println("Launch Simulation started for U2");
            int counter1 = U2.getRocketU2Counter();
            counter1++;
            U2.setRocketcounterU2(counter1);

        }
    }

    public void landSimulation(int i) {
        if (i == 1) {
            System.out.println("Land Simulation started for U1");
            int counter = U1.getRocketcounterU1();
            counter++;
            U1.setRocketcounterU1(counter);

        } else {

            System.out.println("Launch Simulation started for U2");
            int counter = U2.getRocketU2Counter();
            counter++;
            U2.setRocketcounterU2(counter);
        }
        hasLanded = false;
    }


    }
