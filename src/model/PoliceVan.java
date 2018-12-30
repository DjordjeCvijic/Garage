package model;

import java.io.File;

public class PoliceVan extends PoliceVehicle {
    private int capacity;

    public PoliceVan(String type, String chassisNum, String motorNum, String regNum, File image, int x, int y, int platformNum, boolean rotation,int capacity){
        super(type, chassisNum, motorNum, regNum, image, x, y, platformNum, rotation);
        this.capacity=capacity;
    }

    public int getCapacity(){return capacity;}
}
