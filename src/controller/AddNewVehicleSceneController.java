package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

//import java.awt.*;
import javafx.scene.control.*;
import javafx.scene.control.CheckBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import main.Main;
import model.*;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class AddNewVehicleSceneController implements Initializable{
    @FXML private TextField numberOfDoors=new TextField();
    @FXML private TextField capacity=new TextField();
    @FXML private CheckBox rotation=new CheckBox();
    @FXML private TextField selectedImage=new TextField();
    @FXML private TextField name=new TextField();
    @FXML private TextField chassisNumber=new TextField();
    @FXML private TextField motorNumber=new TextField();
    @FXML private TextField registrationNumber=new TextField();
    @FXML private TextField xValue=new TextField();
    @FXML private TextField yValue=new TextField();





    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if (AdminSceneController.selectedVehicle.contains("Car")){
            numberOfDoors.setDisable(false);}
        if (AdminSceneController.selectedVehicle.contains("Van"))
            capacity.setDisable(false);
        if (AdminSceneController.selectedVehicle.contains("Police") || AdminSceneController.selectedVehicle.contains("Medical") || AdminSceneController.selectedVehicle.contains("Fire"))
            rotation.setDisable(false);
        name.setText(AdminSceneController.selectedVehicle);
    }





    public void addImage(ActionEvent actionEvent){
        FileChooser file = new FileChooser();
        file.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files","*.bmp","*.png", "*.jpg"));
        File selectedFile = file.showOpenDialog(new Stage());
        if(selectedFile != null)
        {
            selectedImage.setText(selectedFile.getAbsolutePath());
        }
        else
            selectedImage.setText("");

    }
    public void backToAdministation(ActionEvent actionEvent) {
        Main.primaryStage.setScene(Main.primaryScene);
        Main.primaryStage.setTitle("Administration");
        Main.primaryStage.show();
    }

    public void addVehicle(ActionEvent actionEvent){
       try {
            if (name.getText().equals("") || chassisNumber.getText().equals("") || motorNumber.getText().equals("")
                || registrationNumber.getText().equals("") || xValue.getText().equals("") || yValue.getText().equals("")|| selectedImage.getText().equals(""))
            Main.warning("Some basic fields are left empty!");
            int currentX = Integer.parseInt(xValue.getText());
            int currentY = Integer.valueOf(yValue.getText());
            if (currentX < 0 || currentX > 9 || currentY < 0 || currentY > 7)
                Main.warning("Values of coordinates are out of range");
            else if (AdminSceneController.selectedVehicle.contains("Van")
                    && capacity.getText().equals(""))
                Main.warning("Capacity of Van is left empty!");
            else if(AdminSceneController.selectedVehicle.contains("Car")&& numberOfDoors.getText().equals(""))
                Main.warning("Number of doors in car is left empty");
            else if(!Garage.platforms[AdminSceneController.selectedNumberOfPlatform].getFields()[currentX][currentY].isParking())
                Main.warning("Choosen field is not parking");
            else if(!Garage.platforms[AdminSceneController.selectedNumberOfPlatform].getFields()[currentX][currentY].isAvailable())
                Main.warning("Choosen fild is not available!");
            else {
                Vehicle vehicleTmp=null;
                if (AdminSceneController.selectedVehicle.equals("Car"))
                    vehicleTmp=new Car(name.getText(),chassisNumber.getText(),motorNumber.getText(),registrationNumber.getText(),new File(selectedImage.getText()),
                            currentX,currentY,AdminSceneController.selectedNumberOfPlatform,Integer.parseInt(numberOfDoors.getText()));
                else if(AdminSceneController.selectedVehicle.equals("Van"))
                    vehicleTmp=new Van(name.getText(),chassisNumber.getText(),motorNumber.getText(),registrationNumber.getText(),new File(selectedImage.getText()),
                            currentX,currentY,AdminSceneController.selectedNumberOfPlatform,Integer.parseInt(capacity.getText()));
                else if(AdminSceneController.selectedVehicle.equals("Motorcycle"))
                    vehicleTmp=new Motorcycle(name.getText(),chassisNumber.getText(),motorNumber.getText(),registrationNumber.getText(),new File(selectedImage.getText()),
                            currentX,currentY,AdminSceneController.selectedNumberOfPlatform);
                else if(AdminSceneController.selectedVehicle.equals("Police Car"))
                    vehicleTmp=new PoliceCar(name.getText(),chassisNumber.getText(),motorNumber.getText(),registrationNumber.getText(),new File(selectedImage.getText()),
                            currentX,currentY,AdminSceneController.selectedNumberOfPlatform,rotation.isSelected(),Integer.parseInt(numberOfDoors.getText()));
                else if(AdminSceneController.selectedVehicle.equals("Police Van"))
                    vehicleTmp=new PoliceVan(name.getText(),chassisNumber.getText(),motorNumber.getText(),registrationNumber.getText(),new File(selectedImage.getText()),
                            currentX,currentY,AdminSceneController.selectedNumberOfPlatform,rotation.isSelected(),Integer.parseInt(capacity.getText()));
                else if(AdminSceneController.selectedVehicle.equals("Police Motorcycle"))
                    vehicleTmp=new PoliceMotorcycle(name.getText().toString(),chassisNumber.getText(),motorNumber.getText(),registrationNumber.getText(),new File(selectedImage.getText()),
                            currentX,currentY,AdminSceneController.selectedNumberOfPlatform,rotation.isSelected());
                else if(AdminSceneController.selectedVehicle.equals("Fire Van"))
                    vehicleTmp=new FireVan(name.getText(),chassisNumber.getText(),motorNumber.getText(),registrationNumber.getText(),new File(selectedImage.getText()),
                            currentX,currentY,AdminSceneController.selectedNumberOfPlatform,rotation.isSelected(),Integer.parseInt(capacity.getText()));
                else if(AdminSceneController.selectedVehicle.equals("Medical Car"))
                    vehicleTmp=new MedicalCar(name.getText(),chassisNumber.getText(),motorNumber.getText(),registrationNumber.getText(),new File(selectedImage.getText()),
                            currentX,currentY,AdminSceneController.selectedNumberOfPlatform,rotation.isSelected(),Integer.parseInt(numberOfDoors.getText()));
                else if(AdminSceneController.selectedVehicle.equals("Medical Van"))
                    vehicleTmp=new MedicalVan(name.getText(),chassisNumber.getText(),motorNumber.getText(),registrationNumber.getText(),new File(selectedImage.getText()),
                            currentX,currentY,AdminSceneController.selectedNumberOfPlatform,rotation.isSelected(),Integer.parseInt(capacity.getText()));

                Garage.platforms[AdminSceneController.selectedNumberOfPlatform].addVehicleToPlatform(vehicleTmp);
                AdminSceneController.vehiclesForTable.add(vehicleTmp);
                AdminSceneController.showInTable();
                Main.warning("Vehicle successfully added!");


            }



        }catch(Exception e){
           // warning("Invalid input");
        }


    }



}
