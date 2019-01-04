package model;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Garage {

    public static Platform[]platforms;
    public static int numberOfPlatforms;

    public Garage(){

        try(BufferedReader in=new BufferedReader(new FileReader("src"+File.separator+"resources"+ File.separator+"properties.txt"))) {
            numberOfPlatforms=Integer.valueOf(in.readLine());
            platforms=new Platform[numberOfPlatforms];
            System.out.println("Number of platforms:"+numberOfPlatforms);

            for(int i=0;i<numberOfPlatforms;i++)

                platforms[i]=new Platform();


        } catch(Exception e){
            e.printStackTrace();
        }

    }

}
