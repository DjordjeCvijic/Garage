package model;

import java.io.File;

public class PoliceCar extends PoliceVehicle {
    private int numberOfDoors;

    public PoliceCar(String type, String chassisNum, String motorNum, String regNum, File image, int x, int y, int platformNum, boolean rotation,int numOfDoors){
        super(type, chassisNum, motorNum, regNum, image, x, y, platformNum, rotation);
        numberOfDoors=numOfDoors;
    }

    public int getNumberOfDoors(){return numberOfDoors;}
}
