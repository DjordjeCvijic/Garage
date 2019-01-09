package model;

import java.io.File;

public class Van extends Vehicle{
    private int capacity;

    public Van(String name, String chassisNum, String motorNum, String regNum, File image, int x, int y, int platformNum, int capacity){
        super(name,chassisNum,motorNum,regNum,image,x,y,platformNum);
        this.capacity=capacity;
    }

    public int getCapacity(){return capacity;}
    public void  setCapacity(int tmp){capacity=tmp;}
}
