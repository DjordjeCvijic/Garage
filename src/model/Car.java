package model;

import java.io.File;

public class Car extends Vehicle{

    private int numberOfDoors;

    public Car(String type, String chassisNum, String motorNum, String regNum, File image, int x, int y, int platformNum,int numOfDoors){
        super(type,chassisNum,motorNum,regNum,image,x,y,platformNum);
        numberOfDoors=numOfDoors;
    }

    public int getNumberOfDoors(){return numberOfDoors;};
}
