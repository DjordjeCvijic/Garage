package model;

public class Field {

    private boolean isAvailable = true;
    private boolean isParking = false;
    private Vehicle vehicle = null;
    private Platform onPlatform;

    public Field(Platform platformTmp) {
        onPlatform = platformTmp;
    }

    public void setAvailable(boolean tmp) { isAvailable = tmp; }
    public boolean isAvailable() {return isAvailable;}

    public void setParking(boolean tmp){isParking=tmp;}
    public boolean isParking(){return isParking;}

    public void setVehicleOnField(Vehicle tmp){vehicle=tmp;}
    public Vehicle getVehicleFromField(){return vehicle;}

    public void setPlatform(Platform tmp){onPlatform=tmp;}
    public Platform getPlatform(){return onPlatform;}

}