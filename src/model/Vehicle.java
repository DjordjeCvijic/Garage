package model;
import java.io.File;
import java.io.Serializable;


public abstract class Vehicle implements Serializable{
    private String nameOfVehicle;//car,police car,medical..
    private String chassisNumber;  //1234
    private String motorNumber;  ///12345
    private String registrationNumber;  ///123-456
    private File image;
    private int platformNumber;
    private int x;
    private int y;
    private String mark="V";

    public Vehicle(){};

    public Vehicle(String name,String chassisNum,String motorNum,String regNum,File image,int x,int y,int platformNum){
        nameOfVehicle=name;
        chassisNumber=chassisNum;
        motorNumber=motorNum;
        registrationNumber=regNum;
        this.image=image;
        this.x=x;
        this.y=y;
        platformNumber=platformNum;
    }

    public String getChassisNumber(){return chassisNumber;}
    public String getMotorNumber(){return motorNumber;}

    public void setChassisNumber(String chassisNumber) {
        this.chassisNumber = chassisNumber;
    }

    public void setMotorNumber(String motorNumber) {
        this.motorNumber = motorNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void setImage(File image) {
        this.image = image;
    }

    public void setPlatformNumber(int platformNumber) {
        this.platformNumber = platformNumber;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getRegistrationNumber(){return registrationNumber;}
    public void setNameOfVehicle(String s){nameOfVehicle=s;}
    public String getNameOfVehicle(){return nameOfVehicle;}
    public File getImage(){return image;}
    public int getX(){return x;}
    public int getY(){return y;}

    public String getMark(){return mark;}
    public void setMark(String tmp){mark=tmp;}
    public int getPlatformNumber(){return platformNumber;}

    @Override
    public String toString() {
        return nameOfVehicle+platformNumber+"koordinate:"+x+y+mark;
    }
}
