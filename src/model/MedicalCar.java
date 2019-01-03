package model;

import java.io.File;

public class MedicalCar extends HighPriorityVehicle{
    private int numberOfDoors;

    public MedicalCar(String type, String chassisNum, String motorNum, String regNum, File image, int x, int y, int platformNum, boolean rotation, int numOfDoors) {
        super(type,chassisNum,motorNum,regNum,image,x,y,platformNum,rotation );
        numberOfDoors=numOfDoors;
        if(rotation)
            setMark("HR");
        else
            setMark("H");
    }

    public int getNubmerOfDoors(){return numberOfDoors;}
}
