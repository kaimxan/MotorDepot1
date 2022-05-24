package com.company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Main {
    public static GsonBuilder GSON_BUILDER=new GsonBuilder();
    public static Gson GSON=GSON_BUILDER.setPrettyPrinting().create();
    public static Path URL_TRUCK = Paths.get("./truck.json");
    public static Path URL_Driver=Paths.get("./drivers.json");

    public static void main(String[] args) {
     Truck[] trucks={
             Truck.creatTruck(1,"Renault Magnum",new Driver(),Status.BASE),
             Truck.creatTruck(2,"Volvo",new Driver(),Status.BASE),
             Truck.creatTruck(3,"DAF XT",new Driver(),Status.BASE)
     };
     Truck[] trucks1=trucks;
     Driver [] drivers={
               Driver.creatDriver(1,"Petr"," "),
               Driver.creatDriver(2,"Askar"," "),
               Driver.creatDriver(1,"Uson"," ")

     };
        System.out.println("      Info about Trucks");
        System.out.println("------------------------------");
        System.out.println(" #|  Truck   | Driver | Status");
        System.out.println("------------------------------");
        Truck[] truckt=GSON.fromJson(readTruck(),Truck[].class);
        for (Truck truck :trucks) {
            System.out.println(truck.toString());

        }
        System.out.println();
        System.out.println("           Info about Driver");
        System.out.println("---------------------------------");
        System.out.println("# | name  | truck");
        System.out.println("------------------");
        Driver[] drivers1=GSON.fromJson(readDrivers(),Driver[].class);
        for (Driver driver :drivers) {
            System.out.println(Driver.toString());
//     String json=GSON.toJson(trucks);
//     writeTruck(json);

	// write your code here
    }
        while (true){
            try{
                TruckService truckService=new TruckService();
                Scanner scanner=new Scanner(System.in);
                System.out.println("выберите грузовика или нажмите на 0 чтобы остоновить программу");
                int truck =scanner.nextInt();
                truckService.changeTruck(trucks,truck,drivers);
                if (truck==0){
                    break;
                }
                for (Truck truck1:trucks) {
                    if (truck1.getId()==truck){
                        System.out.println("N:" + truck1.getId());
                        System.out.println("Truck:"+truck1.getName());
                        System.out.println("Driver:"+truck1.getDriver().getName());
                        System.out.println("Truck status:"+truck1.getStatus());
                    }
                }

                }catch (RuntimeException r){
                System.out.println(r.getMessage());
            }
            }
        }
    public static void writeTruck(String truck){
        Path write=Paths.get(String.valueOf(URL_TRUCK));
        try{
            Files.writeString(write,truck, StandardOpenOption.CREATE,StandardOpenOption.WRITE);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static String readTruck(){
        String j="";
        try{
            FileReader reader=new FileReader(String.valueOf(URL_TRUCK));
            int charcount;
            while ((charcount=reader.read())>0){
                j+=(char)charcount;
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return j;
    }
    public static String readDrivers(){
        String j="";
        try{
            FileReader reader=new FileReader(String.valueOf(URL_Driver));
            int charcount;
            while ((charcount=reader.read())>0){
                j+=(char)charcount;
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return j;
}}
