package model;

import java.io.*;
import java.util.ArrayList;

public class Platform implements Serializable{
    private static int counter=0;
    private Field[][] fields;
    private int platformNumber;
    public static int NUM_OF_COLUMNS=8;
    public static int NUM_OF_ROWS=10;
    private int numberOfAvailableParkingFields;
    private String[][] currentMarks;


    public Platform() {
        counter++;
        platformNumber=counter;
        fields=new Field[NUM_OF_ROWS][NUM_OF_COLUMNS];
        for(int i=0;i<NUM_OF_ROWS;i++)
            for(int j=0;j<NUM_OF_COLUMNS;j++)
                fields[i][j]=new Field(this);

        numberOfAvailableParkingFields=28;

        currentMarks=new String [NUM_OF_ROWS][NUM_OF_COLUMNS];

        for(int i=0; i<NUM_OF_ROWS; i++){
            for(int j=0; j<NUM_OF_COLUMNS; j++){
                if((j == 0 || j == 3 || j == 4 || j == 7) && (i != 0 && i != 1 && i != 8 && i != 9))
                    fields[i][j].setParking(true);
                if( (i == 8 && (j == 0 || j == 7)) || (i == 9 && (j == 0 || j == 7)))
                    fields[i][j].setParking(true);
            }
        }
        currentMarks = new String[NUM_OF_ROWS][NUM_OF_COLUMNS];
        for(int i=0; i<Platform.NUM_OF_ROWS; i++){
            for(int j=0; j<Platform.NUM_OF_COLUMNS; j++){
                if(fields[i][j].isParking()) {
                    currentMarks[i][j] = "*";
                }else
                    currentMarks[i][j] ="";
            }
        }


    }

    public static void serializationOfThePlatform(ArrayList<Platform>platforms){
        try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(".."+ File.separator+"resources"+File.separator+"garaza.ser"))){
            out.writeObject(platforms);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Platform> deserializationOfThePlatform(){
        try(ObjectInputStream in=new ObjectInputStream(new FileInputStream(".."+ File.separator+"resources"+File.separator+"garaza.ser"))){
            ArrayList<Platform> platforms=(ArrayList<Platform>) in.readObject();
            return platforms;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public synchronized void addVehicleToPlatform(Vehicle vehicle){
        fields[vehicle.getX()][vehicle.getY()].setVehicleOnField(vehicle);
        currentMarks[vehicle.getX()][vehicle.getY()]=vehicle.getMark();
        numberOfAvailableParkingFields--;
        fields[vehicle.getX()][vehicle.getY()].setAvailable(false);
    }

    public Field[][] getFields(){return fields;}






}
