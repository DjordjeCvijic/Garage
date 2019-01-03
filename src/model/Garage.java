package model;
import javafx.beans.property.SimpleObjectProperty;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Garage {
    private ArrayList<Platform> platforms=new ArrayList<>();
    public static int numberOfPlatforms;

    public Garage(){

        try(BufferedReader in=new BufferedReader(new FileReader("src"+File.separator+"resources"+ File.separator+"properties.txt"))) {
            numberOfPlatforms=Integer.valueOf(in.readLine());

            for(int i=0;i<numberOfPlatforms;i++)

                platforms.add(new Platform());


        } catch(Exception e){
            e.printStackTrace();
        }

    }

}
