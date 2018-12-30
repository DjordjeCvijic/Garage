package model;

import java.io.File;

public class Motorcycle extends Vehicle {

    public Motorcycle(String type, String chassisNum, String motorNum, String regNum, File image, int x, int y, int platformNum){
        super(type,chassisNum,motorNum,regNum,image,x,y,platformNum);
    }

}
