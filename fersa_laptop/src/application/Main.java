
package application;

import Boundary.HomepageOspite_Locatori;
import Controller.ControllerBachecaLocatore;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    protected static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {

        this.primaryStage=primaryStage;
        initRootLayout();

    }

    public static Stage getStage() { return primaryStage; }

    public void initRootLayout() {
        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/Boundary/HomepageOspite_annunciLocatori.fxml"));
            AnchorPane root= loader.load();
            Scene scene = new Scene(root);

            primaryStage.setTitle("Homepage");
            primaryStage.setScene(scene);
            HomepageOspite_Locatori controllerLogico = loader.getController();
            controllerLogico.setMain(this);
            controllerLogico.setStage(primaryStage);

            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }


    public void apriSchermataErrore() {
        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/Boundary/ErroreAccesso.fxml"));

            AnchorPane anchorPane = loader.load();
            primaryStage.setTitle("Errore");
            primaryStage.setScene(new Scene(anchorPane));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            primaryStage.close();
        }
    }
}
