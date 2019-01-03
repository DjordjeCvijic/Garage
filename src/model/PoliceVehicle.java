package model;

import java.io.File;

public abstract class PoliceVehicle extends HighPriorityVehicle {
    private static File chase;

    public PoliceVehicle(){};

    public PoliceVehicle(String type, String chassisNum, String motorNum, String regNum, File image, int x, int y, int platformNum,boolean rotation) {
        super(type, chassisNum, motorNum, regNum, image, x, y, platformNum, rotation);

        if(rotation)
            setMark("PR");
        else
            setMark("P");
    }

    public static void setChase(File chaseTmp){
        chase=chaseTmp;
    }


}
