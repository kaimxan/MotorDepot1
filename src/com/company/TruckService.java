package com.company;

import java.util.Scanner;

public class TruckService {

    static  String truckName;
    static String driverName=null;
    Scanner scanner=new Scanner(System.in);
    static Driver driver=new Driver();
    static String dr;
    public  void changeTruck(Truck[]trucks,int truckId,Driver[]drivers){
        for (int i = 0; i < trucks.length; i++) {
            if (trucks[i].detId() == truckId) {
                if (trucks[i].getDriver().getName() == null) {
                    dr = " ";
                } else {
                    dr = trucks[i].getDriver().getName();
                }
                truckName = trucks[i].getName();
                System.out.println("N:      " + trucks[i].getId());
                System.out.println("Truck : " + trucks[i].getName());
                System.out.println("Driver: " + dr);
                System.out.println("State : " + trucks[i].getStatus());
                if (trucks[i].getStatus().equals(Status.BASE)) {
                    System.out.println("вы выбрали грузовик-" + truckName + "и он в базе");
                    System.out.println("если хотите отправить в путь нажмите на 1");
                    System.out.println("если хотите отправить на ремонт нажмите на 2");
                    System.out.println("если хотите выбрать водителя нажмите на 3");
                    int change = scanner.nextInt();
                    if (change == 3) {
                        System.out.println("выберите водителя");
                        changeDriving(drivers, scanner.nextInt());
                        trucks[i].setDriver(driver);
                        System.out.println("хотите отправит в путь? тогда нажмите на 1 если нет тогда 0");
                        change = scanner.nextInt();
                        if (change == 1) {
                            startDriving(truckName, driverName);
                            trucks[i].setStatus(Status.ROUTE);
                        } else if (change == 0) {
                            System.out.println("грузовик осталься на базе");
                        } else if (change == 1) {
                            System.out.println("сначала выберите водителя ");
                            changeDriving(drivers, scanner.nextInt());
                            startDriving(truckName, driverName);
                            trucks[i].setDriver(driver);
                            trucks[i].setStatus(Status.ROUTE);
                        } else if (change == 2) {
                            startRepair(truckName);
                            trucks[i].setStatus(Status.REPAIR);

                        }
                    } else if (trucks[i].getStatus().equals(Status.ROUTE)) {
                        System.out.println("вы выбрали грузовик " + truckName + "и он уже в пути ");

                    } else if (trucks[i].getStatus().equals(Status.REPAIR)) {
                        System.out.println("вы выбрали грузовик " + truckName + "и он на ремонте");
                    }
                }
            }
            if (truckId > 3){
        }
        throw new RuntimeException("выберите только один из 3");
        }
    }

    private void changeDriving(Driver[] drivers, int driverId) {
        for (int i = 0; i < drivers.length; i++) {
            if (drivers[i].getId()==driverId){
                driverName=drivers[i].getName();
                driver=drivers[i];
            }
        }
        System.out.println("тепер у грузовика-"+truckName+"водитель-"+driverName);
    }
    public static void startDriving(String truck,String driver){
        System.out.println("тепер грузовик "+truck+"в путь и ведет его "+driver);
    }
    public static void startRepair(String truck){
        System.out.println("тепер грузовик "+truck+"на ремонте");
    }
}
