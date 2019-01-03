package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

//import java.awt.*;
import javafx.scene.control.*;
import javafx.scene.control.CheckBox;
import main.Main;

import java.net.URL;
import java.util.ResourceBundle;

public class AddNewVehicleSceneController implements Initializable{
    @FXML private TextField numberOfDoors=new TextField();
    @FXML private TextField capacity=new TextField();
    @FXML private CheckBox rotation=new CheckBox();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if (AdminSceneController.selectedVehicle.contains("Car")){
            numberOfDoors.setDisable(false);}
        if (AdminSceneController.selectedVehicle.contains("Van"))
            capacity.setDisable(false);
        if (AdminSceneController.selectedVehicle.contains("Police") || AdminSceneController.selectedVehicle.contains("Medical") || AdminSceneController.selectedVehicle.contains("Fire"))
            rotation.setDisable(false);
    }


    public void backToAdministation(ActionEvent actionEvent) {
        Main.primaryStage.setScene(Main.primaryScene);
        Main.primaryStage.setTitle("Administration");
        Main.primaryStage.show();
    }
}
