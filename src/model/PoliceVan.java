package model;

import java.io.File;

public class PoliceVan extends PoliceVehicle {
    private int capacity;

    public PoliceVan(String name, String chassisNum, String motorNum, String regNum, File image, int x, int y, int platformNum, boolean rotation,int capacity){
        super(name, chassisNum, motorNum, regNum, image, x, y, platformNum, rotation);
        this.capacity=capacity;
    }

    public int getCapacity(){return capacity;}
    public void  setCapacity(int tmp){capacity=tmp;}
}
