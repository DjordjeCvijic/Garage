package model;
import java.io.File;
import java.security.ProtectionDomain;


public abstract class Vehicle {
    protected String typeOfVehicle;//car,police car,medical..
    protected String chassisNumber;  //1234
    protected String motorNumber;  ///12345
    protected String registrationNumber;  ///123-456
    protected File image;
    protected int platformNumber;
    protected int x;
    protected int y;
    private String mark="V";

    public Vehicle(){};

    public Vehicle(String type,String chassisNum,String motorNum,String regNum,File image,int x,int y,int platformNum){
        typeOfVehicle=type;
        chassisNumber=chassisNum;
        motorNumber=motorNum;
        registrationNumber=regNum;
        this.image=image;
        this.x=x;
        this.y=y;
        platformNumber=platformNum;
    }

    public String getTypeOfVehicle(){return typeOfVehicle;}
    public String getChassisNumber(){return chassisNumber;}
    public String getMotorNumber(){return motorNumber;}
    public String getRegistrationNumber(){return registrationNumber;}
    public File getImage(){return image;}
    public int getX(){return x;}
    public int getY(){return y;}

    public String getMark(){return mark;}
    public void setMark(String tmp){
        mark=tmp;
        }



}
