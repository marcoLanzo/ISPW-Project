package Boundary;

import Controller.MainController;
import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

import static Boundary.Annuncio_locatario.annuncioBean;

public class Annuncio_ospite {

    @FXML
    private Main main;
    @FXML
    protected static Stage stage;

    @FXML
    protected Text textCity;
    @FXML
    protected Text textPrice;
    @FXML
    protected Text textDescription;
    @FXML
    protected Text textUser;
    @FXML
    protected Text textAnnounceName;


    @FXML
    public void accedi(ActionEvent event){

        try {

            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/Boundary/Login.fxml"));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Login");
            stage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void registra(ActionEvent event) {

        try {
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/Boundary/Registrazione.fxml"));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Registrazione");
            stage.show();


        } catch(Exception e) {
            e.printStackTrace();
        }

    }


    public void displayRenterShowcase(ActionEvent event) {

        try {
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/Boundary/HomepageOspite_annunciLocatori.fxml"));

            Scene scene = new Scene(root);

            stage = main.getStage();
            stage.setScene(scene);
            stage.setTitle("Homepage");
            this.stage.close();

            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void displayTenantShowcase(ActionEvent event) {

        try {
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/Boundary/HomepageOspite_annunciLocatari.fxml"));

            Scene scene = new Scene(root);

            stage = main.getStage(); // mi prendo il primary stage definito nell'initRootLayout
            stage.setScene(scene); //ci setto la nuova scene da visualizzare senza aprire una nuova finestra
            stage.setTitle("Homepage");
            this.stage.close();//chiudo la finestra precedente

            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void signal(ActionEvent event){

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Attenzione!");
        alert.setHeaderText("Registrazione necessaria");
        alert.setContentText("Devi effettuare il login per segnalare questo annuncio");
        alert.showAndWait();
        alert.close();

    }



    @FXML
    public void insertFavorites(ActionEvent event){

    }



    @FXML
    public void cercaSuMappa(ActionEvent event){


    }

    @FXML
    public void cercaPerNome(ActionEvent event){

    }

    @FXML
    public void contattaLocatario(ActionEvent event) {

        MainController.increase_counter_renting(annuncioBean);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Grazie!");
        alert.setHeaderText("Locatario contattato");
        alert.setContentText("Controllo della sua prenotazione passata in gestione a Renting");
        alert.showAndWait();
        alert.close();
        System.out.println("Controllo della prenotazione passato a Renting");
    }


}
