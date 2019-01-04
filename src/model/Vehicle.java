package model;
import java.io.File;


public abstract class Vehicle {
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

    public String getTypeOfVehicle(){return nameOfVehicle;}
    public String getChassisNumber(){return chassisNumber;}
    public String getMotorNumber(){return motorNumber;}
    public String getRegistrationNumber(){return registrationNumber;}
    public void setNameOfVehicle(String s){nameOfVehicle=s;}
    public String getNameOfVehicle(){return nameOfVehicle;}
    public File getImage(){return image;}
    public int getX(){return x;}
    public int getY(){return y;}

    public String getMark(){return mark;}
    public void setMark(String tmp){mark=tmp;}

    @Override
    public String toString() {
        return nameOfVehicle;
    }
}
