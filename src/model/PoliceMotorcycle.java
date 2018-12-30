package model;

import java.io.File;

public class PoliceMotorcycle extends PoliceVehicle {

    public PoliceMotorcycle(String type, String chassisNum, String motorNum, String regNum, File image, int x, int y, int platformNum, boolean rotation){
        super(type, chassisNum, motorNum, regNum, image, x, y, platformNum, rotation);
    }
}
