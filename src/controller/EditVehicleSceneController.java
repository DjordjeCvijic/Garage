package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import model.*;
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
        if (AdminSceneController.vehicleToEdit instanceof MedicalCar ){
            numberOfDoors.setDisable(false);
            numberOfDoors.setText(String.valueOf(((MedicalCar) AdminSceneController.vehicleToEdit).getNumberOfDoors()));
        }
        if (AdminSceneController.vehicleToEdit instanceof PoliceCar ){
            numberOfDoors.setDisable(false);
            numberOfDoors.setText(String.valueOf(((PoliceCar) AdminSceneController.vehicleToEdit).getNumberOfDoors()));
        }
        if (AdminSceneController.vehicleToEdit instanceof Van ){
            capacity.setDisable(false);
            capacity.setText(String.valueOf(((Van) AdminSceneController.vehicleToEdit).getCapacity()));
        }
        if (AdminSceneController.vehicleToEdit instanceof FireVan ){
            capacity.setDisable(false);
            capacity.setText(String.valueOf(((FireVan) AdminSceneController.vehicleToEdit).getCapacity()));
        }
        if (AdminSceneController.vehicleToEdit instanceof MedicalVan ){
            capacity.setDisable(false);
            capacity.setText(String.valueOf(((MedicalVan) AdminSceneController.vehicleToEdit).getCapacity()));
        }
        if (AdminSceneController.vehicleToEdit instanceof PoliceVan ){
            capacity.setDisable(false);
            capacity.setText(String.valueOf(((PoliceVan) AdminSceneController.vehicleToEdit).getCapacity()));
        }
        if(AdminSceneController.vehicleToEdit instanceof HighPriorityVehicle){
            rotation.setDisable(false);
            rotation.setSelected(((HighPriorityVehicle)AdminSceneController.vehicleToEdit).isRotationOn());

        }


    }

    public void addImage(ActionEvent actionEvent) {
    }

    public void backToAdministation(ActionEvent actionEvent) {
    }

    public void saveBtn(ActionEvent actionEvent) {
    }
}
