package controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import main.Main;
import model.*;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AdminSceneController implements Initializable{
    @FXML private ComboBox<String> vehicleToChoose=new ComboBox<>();
    @FXML private ComboBox<Integer> platformToChoose=new ComboBox<>();
    @FXML private TableView<Vehicle> table =new TableView<>();
    @FXML private static TableView<Vehicle> staticTable;
    @FXML private TableColumn<Vehicle,String> vehicleName=new TableColumn<>();
    @FXML private TableColumn<Vehicle,String> chassisNum=new TableColumn<>();
    @FXML private TableColumn<Vehicle,String> registrationNum=new TableColumn<>();
    @FXML private TableColumn<Vehicle, Integer> x = new TableColumn<>();
    @FXML private TableColumn<Vehicle, Integer> y = new TableColumn<>();
    @FXML private TableColumn<Vehicle, String> motorNum = new TableColumn<>();
    @FXML private TableColumn<Vehicle, String> image = new TableColumn<>();
    @FXML private Button addVehicleBtn;
    @FXML private Button deleteVehicle;






    public static String selectedVehicle;//vozilo koje je izabrano iz padajuceg menija
    public static int selectedNumberOfPlatform;
    public static ObservableList<Vehicle> vehiclesForTable = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        vehicleToChoose.getItems().addAll("Car","Van","Motorcycle","Police Car","Police Van","Police Motorcycle","Fire Van","Medical Car","Medical Van");
        for(int i=0;i<Garage.numberOfPlatforms;i++)
            platformToChoose.getItems().add(i);

        platformToChoose.getSelectionModel().selectFirst();
        initializeTableFromSerialization();
        Vehicle vehicle1=new Car("BMW","12","34","45",new File(""),2,0,0,3);
        Vehicle vehicle2=new Motorcycle("HONDA","3123","3456","4555",new File(""),3,0,0);
        Vehicle vehicle3=new Van("MERCEDES","1002","0034","4005",new File(""),4,0,0,3);
        Garage.platforms[0].addVehicleToPlatform(vehicle1);
        Garage.platforms[0].addVehicleToPlatform(vehicle2);
        Garage.platforms[0].addVehicleToPlatform(vehicle3);
        vehiclesForTable.addAll(vehicle1,vehicle2,vehicle3);
        staticTable=table;
        table.setItems(vehiclesForTable);
        setTable();
        addVehicleBtn.setStyle("-fx-background-color: cyan");
        deleteVehicle.setStyle("-fx-background-color: crimson ");

    }

    public void initializeTableFromSerialization(){
        File tmp=new File(".."+ File.separator+"resources"+File.separator+"garaza.ser");
        if(tmp.exists()){
            ArrayList<Platform> platforms=Platform.deserializationOfThePlatform();
            int i=0;
            for(Platform p:platforms){
                Garage.platforms[i]=p;
                i++;
            }

            for(i=0;i<Platform.NUM_OF_ROWS;i++){
                for(int j=0;j<Platform.NUM_OF_COLUMNS;j++){
                    Vehicle v=Garage.platforms[0].getFields()[i][j].getVehicleFromField();
                    if(v!=null)
                        vehiclesForTable.add(v);
                }
            }

        }




    }

    public void setTable(){
        vehicleName.setCellValueFactory(new PropertyValueFactory<>("nameOfVehicle"));
        chassisNum.setCellValueFactory(new PropertyValueFactory<>("chassisNumber"));
        motorNum.setCellValueFactory(new PropertyValueFactory<>("motorNumber"));
        registrationNum.setCellValueFactory(new PropertyValueFactory<>("registrationNumber"));
        x.setCellValueFactory(new PropertyValueFactory<>("x"));
        y.setCellValueFactory(new PropertyValueFactory<>("y"));
        table.setItems(vehiclesForTable);

    }

    public static void showInTable(){
        staticTable.setItems(vehiclesForTable);
    }

    public void onClc(ActionEvent actionEvent) {

        //TO-DO pokretanje simulacije
        System.out.println("rado");

    }

    public void addVehicleBtn(ActionEvent actionEvent) throws Exception {
        selectedVehicle=vehicleToChoose.getSelectionModel().getSelectedItem();
        if(selectedVehicle==null){
            Main.warning("You mast choose vehicle");

        }
        else{

            selectedNumberOfPlatform=platformToChoose.getSelectionModel().getSelectedItem();
            Parent root = FXMLLoader.load(getClass().getResource(".."+File.separator+"view"+ File.separator+"AddNewVehicleScene.fxml"));
            Main.primaryStage.setScene(new Scene(root));
            Main.primaryStage.setTitle("Add new vehicle");
            Main.primaryStage.show();


        }


    }
    public void deleteVehicleBtn(ActionEvent actionEvent){
        Vehicle vehicleToDelete=table.getSelectionModel().getSelectedItem();
        if(vehicleToDelete==null)
            Main.warning("You mast choose vehicle to delete");

        else{
            Garage.platforms[platformToChoose.getSelectionModel().getSelectedItem()].deleteVehicleFromPlatform(vehicleToDelete);
            vehiclesForTable.remove(vehicleToDelete);
            showInTable();
        }
    }
    public void showPlatformBtn(ActionEvent actionEvent){
        vehiclesForTable.removeAll(vehiclesForTable);
        Platform platform=Garage.platforms[platformToChoose.getSelectionModel().getSelectedItem()];
        for(int i=0;i<Platform.NUM_OF_ROWS;i++)
            for(int j=0;j<Platform.NUM_OF_COLUMNS;j++){
            if(platform.getFields()[i][j].getVehicleFromField()!=null)
                vehiclesForTable.add(platform.getFields()[i][j].getVehicleFromField());
            }
            showInTable();
    }

    public void editVehicleBtn(ActionEvent actionEvent){
        try {
            Parent root = FXMLLoader.load(getClass().getResource(".." + File.separator + "view" + File.separator + "EditVehicleScene.fxml"));
            Main.primaryStage.setScene(new Scene(root));
            Main.primaryStage.setTitle("Edit vehicle");
            Main.primaryStage.show();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
