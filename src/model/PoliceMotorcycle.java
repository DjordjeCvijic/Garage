package model;

import java.io.File;

public class PoliceMotorcycle extends PoliceVehicle {

    public PoliceMotorcycle(String name, String chassisNum, String motorNum, String regNum, File image, int x, int y, int platformNum, boolean rotation){
        super(name, chassisNum, motorNum, regNum, image, x, y, platformNum, rotation);
    }
}
