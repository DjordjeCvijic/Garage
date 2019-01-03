package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Garage;

public class Main extends Application {
    public static Stage primaryStage;
    public static Scene primaryScene;

    @Override
    public void start(Stage stage) throws Exception{
        Garage garage=new Garage();
        primaryStage= stage;

        Parent root = FXMLLoader.load(getClass().getResource("AdminScene.fxml"));
        primaryScene=new Scene(root);
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("Administration");
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}

