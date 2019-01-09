package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import main.Main;
import model.*;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class EditVehicleSceneController implements Initializable{

    @FXML private TextField name;
    @FXML private TextField chassisNumber;
    @FXML private TextField motorNumber;
    @FXML private TextField registrationNumber;
    @FXML private TextField xValue;
    @FXML private TextField yValue;
    @FXML private TextField selectedImage;
    @FXML private TextField numberOfDoors;
    @FXML private TextField capacity;
    @FXML private CheckBox rotation;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        name.setText(AdminSceneController.vehicleToEdit.getNameOfVehicle());
        chassisNumber.setText(AdminSceneController.vehicleToEdit.getChassisNumber());
        motorNumber.setText(AdminSceneController.vehicleToEdit.getMotorNumber());
        registrationNumber.setText(AdminSceneController.vehicleToEdit.getRegistrationNumber());
        xValue.setText(String.valueOf(AdminSceneController.vehicleToEdit.getX()));
        yValue.setText(String.valueOf(AdminSceneController.vehicleToEdit.getY()));
        selectedImage.setText(AdminSceneController.vehicleToEdit.getImage().getAbsolutePath());

        if (AdminSceneController.vehicleToEdit instanceof Car ){
            numberOfDoors.setDisable(false);
            numberOfDoors.setText(String.valueOf(((Car) AdminSceneController.vehicleToEdit).getNumberOfDoors()));

        }
        else if (AdminSceneController.vehicleToEdit instanceof MedicalCar ){
            numberOfDoors.setDisable(false);
            numberOfDoors.setText(String.valueOf(((MedicalCar) AdminSceneController.vehicleToEdit).getNumberOfDoors()));
            rotation.setSelected(((HighPriorityVehicle)AdminSceneController.vehicleToEdit).isRotationOn());
        }
        else if (AdminSceneController.vehicleToEdit instanceof PoliceCar ){
            numberOfDoors.setDisable(false);
            numberOfDoors.setText(String.valueOf(((PoliceCar) AdminSceneController.vehicleToEdit).getNumberOfDoors()));
            rotation.setSelected(((HighPriorityVehicle)AdminSceneController.vehicleToEdit).isRotationOn());
        }
        else if (AdminSceneController.vehicleToEdit instanceof Van ){
            capacity.setDisable(false);
            capacity.setText(String.valueOf(((Van) AdminSceneController.vehicleToEdit).getCapacity()));
        }
        else if (AdminSceneController.vehicleToEdit instanceof FireVan ){
            capacity.setDisable(false);
            capacity.setText(String.valueOf(((FireVan) AdminSceneController.vehicleToEdit).getCapacity()));
            rotation.setSelected(((HighPriorityVehicle)AdminSceneController.vehicleToEdit).isRotationOn());
        }
        else if (AdminSceneController.vehicleToEdit instanceof MedicalVan ){
            capacity.setDisable(false);
            capacity.setText(String.valueOf(((MedicalVan) AdminSceneController.vehicleToEdit).getCapacity()));
            rotation.setSelected(((HighPriorityVehicle)AdminSceneController.vehicleToEdit).isRotationOn());
        }
        else if (AdminSceneController.vehicleToEdit instanceof PoliceVan ){
            capacity.setDisable(false);
            capacity.setText(String.valueOf(((PoliceVan) AdminSceneController.vehicleToEdit).getCapacity()));
            rotation.setSelected(((HighPriorityVehicle)AdminSceneController.vehicleToEdit).isRotationOn());
        }



    }

    public void addImage(ActionEvent actionEvent) {
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
        //Main.primaryStage.show();

    }

    public void saveBtn(ActionEvent actionEvent) {
        AdminSceneController.vehiclesForTable.remove(AdminSceneController.vehicleToEdit);

        try{
            if (name.getText().equals("") || chassisNumber.getText().equals("") || motorNumber.getText().equals("")
                    || registrationNumber.getText().equals("") || xValue.getText().equals("") || yValue.getText().equals("")|| selectedImage.getText().equals(""))
                Main.warning("Some basic fields are left empty!");
            int currentX = Integer.parseInt(xValue.getText());
            int currentY = Integer.valueOf(yValue.getText());
            if (currentX < 0 || currentX > 9 || currentY < 0 || currentY > 7)
                Main.warning("Values of coordinates are out of range");
            else if ((AdminSceneController.vehicleToEdit instanceof Van || AdminSceneController.vehicleToEdit instanceof FireVan ||AdminSceneController.vehicleToEdit instanceof MedicalVan
                    || AdminSceneController.vehicleToEdit instanceof PoliceVan) && capacity.getText().equals(""))
                Main.warning("Capacity of Van is left empty!");
            else if((AdminSceneController.vehicleToEdit instanceof Car ||AdminSceneController.vehicleToEdit instanceof PoliceCar ||AdminSceneController.vehicleToEdit instanceof MedicalCar )
                    && numberOfDoors.getText().equals(""))
                Main.warning("Number of doors in car is left empty");
            else if(!Garage.platforms[AdminSceneController.vehicleToEdit.getPlatformNumber()].getFields()[currentX][currentY].isParking())
                Main.warning("Choosen field is not parking");
            else if(!Garage.platforms[AdminSceneController.vehicleToEdit.getPlatformNumber()].getFields()[currentX][currentY].isAvailable() && (AdminSceneController.vehicleToEdit.getX()!=currentX
                    || AdminSceneController.vehicleToEdit.getY()!=currentY))
                Main.warning("Choosen fild is not available!");
            else{
                AdminSceneController.vehicleToEdit.setNameOfVehicle(name.getText());
                AdminSceneController.vehicleToEdit.setChassisNumber(chassisNumber.getText());
                AdminSceneController.vehicleToEdit.setMotorNumber(motorNumber.getText());
                AdminSceneController.vehicleToEdit.setRegistrationNumber(registrationNumber.getText());
                int tmpX=AdminSceneController.vehicleToEdit.getX();
                int tmpY=AdminSceneController.vehicleToEdit.getY();
                AdminSceneController.vehicleToEdit.setX(Integer.valueOf(xValue.getText()));
                AdminSceneController.vehicleToEdit.setY(Integer.valueOf(yValue.getText()));
                AdminSceneController.vehicleToEdit.setImage(new File(selectedImage.getText()));

                if (AdminSceneController.vehicleToEdit instanceof Car)
                    ((Car) AdminSceneController.vehicleToEdit).setNumberOfDoors(Integer.valueOf(numberOfDoors.getText()));
                else if (AdminSceneController.vehicleToEdit instanceof Van)
                    ((Van) AdminSceneController.vehicleToEdit).setCapacity(Integer.valueOf(capacity.getText()));
                else if (AdminSceneController.vehicleToEdit instanceof MedicalCar) {
                    ((MedicalCar) AdminSceneController.vehicleToEdit).setNumberOfDoors(Integer.valueOf(numberOfDoors.getText()));
                    ((MedicalCar) AdminSceneController.vehicleToEdit).setRotationOn(rotation.isSelected());
                } else if (AdminSceneController.vehicleToEdit instanceof MedicalVan) {
                    ((MedicalVan) AdminSceneController.vehicleToEdit).setCapacity(Integer.valueOf(capacity.getText()));
                    ((MedicalVan) AdminSceneController.vehicleToEdit).setRotationOn(rotation.isSelected());
                } else if (AdminSceneController.vehicleToEdit instanceof PoliceCar) {
                    ((PoliceCar) AdminSceneController.vehicleToEdit).setNumberOfDoors(Integer.valueOf(numberOfDoors.getText()));
                    ((PoliceCar) AdminSceneController.vehicleToEdit).setRotationOn(rotation.isSelected());
                } else if (AdminSceneController.vehicleToEdit instanceof PoliceVan) {
                    ((PoliceVan) AdminSceneController.vehicleToEdit).setCapacity(Integer.valueOf(capacity.getText()));
                    ((PoliceVan) AdminSceneController.vehicleToEdit).setRotationOn(rotation.isSelected());
                } else if (AdminSceneController.vehicleToEdit instanceof PoliceMotorcycle) {
                    ((PoliceMotorcycle) AdminSceneController.vehicleToEdit).setRotationOn(rotation.isSelected());
                }

                Garage.platforms[AdminSceneController.vehicleToEdit.getPlatformNumber()].editVehicle(AdminSceneController.vehicleToEdit,tmpX,tmpY);
                AdminSceneController.vehiclesForTable.add(AdminSceneController.vehicleToEdit);
                AdminSceneController.showInTable();
                Main.warning("Vehicle successfully edited!");
            }







        }catch(Exception e){

        }

    }
}
