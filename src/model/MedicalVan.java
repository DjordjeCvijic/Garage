package model;

import java.io.File;

public class MedicalVan extends HighPriorityVehicle {
    private int capacity;

    public MedicalVan(String type, String chassisNum, String motorNum, String regNum, File image, int x, int y, int platformNum,boolean rotation, int capacity){
        super(type,chassisNum,motorNum,regNum,image,x,y,platformNum,rotation);
        this.capacity=capacity;
        if(rotation)
            setMark("HR");
        else
        setMark("H");

    }

    int getCapacity(){return capacity;}

}
