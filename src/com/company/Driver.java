package com.company;

public class Driver {
    private int id;
    private String name;
    private String truck;
    public Driver(){

    }

    public Driver(int id, String name, String truck) {
        this.id = id;
        this.name = name;
        this.truck = truck;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTruck() {
        return truck;
    }

    public void setTruck(String truck) {
        this.truck = truck;
    }
    public String infoDriver(){
        return id+" | "+name+" | "+truck;
    }


}
