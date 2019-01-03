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

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class AddNewVehicleSceneController implements Initializable{
    @FXML private TextField numberOfDoors=new TextField();
    @FXML private TextField capacity=new TextField();
    @FXML private CheckBox rotation=new CheckBox();
    @FXML private TextField selectedImage=new TextField();




    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if (AdminSceneController.selectedVehicle.contains("Car")){
            numberOfDoors.setDisable(false);}
        if (AdminSceneController.selectedVehicle.contains("Van"))
            capacity.setDisable(false);
        if (AdminSceneController.selectedVehicle.contains("Police") || AdminSceneController.selectedVehicle.contains("Medical") || AdminSceneController.selectedVehicle.contains("Fire"))
            rotation.setDisable(false);
    }





    public void addImage(ActionEvent actionEvent){
        FileChooser chooseFile = new FileChooser();
        chooseFile.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files","*.bmp","*.png", "*.jpg"));
        File selectedFile = chooseFile.showOpenDialog(new Stage());
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

}
