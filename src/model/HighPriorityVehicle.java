package model;

import java.io.File;

public abstract class HighPriorityVehicle extends Vehicle{

    private boolean rotationOn=false;

    public HighPriorityVehicle(){};

    public HighPriorityVehicle(String type, String chassisNum, String motorNum, String regNum, File image, int x, int y, int platformNum,boolean rotation){
        super(type,chassisNum,motorNum,regNum,image,x,y,platformNum);
        rotationOn=rotation;
    }

    public boolean isRotationOn(){return rotationOn;}
}
