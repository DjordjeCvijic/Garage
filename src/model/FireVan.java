package model;

import java.io.File;

public class FireVan extends HighPriorityVehicle {
    private int capacity;

    public FireVan(String type, String chassisNum, String motorNum, String regNum, File image, int x, int y, int platformNum,boolean rotation, int capacity){
        super(type,chassisNum,motorNum,regNum,image,x,y,platformNum,rotation);
        this.capacity=capacity;
        if(rotation)
            setMark("FR");
        setMark("F");
    }

    public int getCapacity(){return capacity;}
}
