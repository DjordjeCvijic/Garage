package controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import model.Garage;
import view.Main;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminSceneController implements Initializable{
    @FXML private ComboBox<String> vehicleToChoose;
    @FXML private ComboBox<Integer> platformToChoose;







    public static String selectedVehicle;//vozilo koje je izabrano iz padajuceg menija
    public static int selectedNumberOfPlatform;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        vehicleToChoose.getItems().addAll("Car","Van","Motorcycle","Police Car","Police Van","Police MotorCycle","Fire Van","Medical Car","Medical Van");
        for(int i=0;i<Garage.numberOfPlatforms;i++)
            platformToChoose.getItems().add(i);

        platformToChoose.getSelectionModel().selectFirst();


    }

    public void onClc(ActionEvent actionEvent) {

        //TO-DO pokretanje simulacije
        System.out.println("rado");

    }

    public void addVehicle(ActionEvent actionEvent) throws Exception {
        if(vehicleToChoose.getSelectionModel().getSelectedItem()==null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("You must choose type of vehicle!");

            alert.showAndWait();
        }
        else{
            selectedVehicle=vehicleToChoose.getSelectionModel().getSelectedItem();
            selectedNumberOfPlatform=platformToChoose.getSelectionModel().getSelectedItem();

            Parent root = FXMLLoader.load(getClass().getResource("view"+File.separator+"AddNewVehicleScene.fxml"));
            Main.primaryStage.setScene(new Scene(root));
            Main.primaryStage.setTitle("Add new vehicle");
            Main.primaryStage.show();


        }


    }
}
