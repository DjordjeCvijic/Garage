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

    public void setVehicle(Vehicle tmp){vehicle=tmp;}
    public Vehicle getVehicle(){return vehicle;}

    public void set
}