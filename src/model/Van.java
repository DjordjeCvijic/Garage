package model;

import java.io.File;

public class Van extends Vehicle{
    private int capacity;

    public Van(String type, String chassisNum, String motorNum, String regNum, File image, int x, int y, int platformNum, int capacity){
        super(type,chassisNum,motorNum,regNum,image,x,y,platformNum);
        this.capacity=capacity;
    }

    int getCapacity(){return capacity;}
}
