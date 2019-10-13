package Boundary;

import Bean.UtenteBean;
import Controller.Controller;
import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import Controller.MainController;

import java.io.IOException;

public class Storico_locatore {
    @FXML
    private AnchorPane homepageLocatarioPane;
    @FXML
    private Main main;
    @FXML
    protected static Stage stage;

    protected static UtenteBean credenziali = new UtenteBean();

    public void setMain(Main main) {
        this.main = main;
    }
    @FXML
    public void initialize() { /* Il metodo initialize setta le variabili desiderate prima di creare la finestra */

        Controller c = new Controller();
        UtenteBean credenziali = MainController.getUtentebean();
    }

    @FXML
    public void showAnnunciLocatori(javafx.event.ActionEvent event) {

        try {
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/Boundary/HomepageUtente_annunciLocatori.fxml"));

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
    public void showAnnunciLocatari(javafx.event.ActionEvent event) {

        try {
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/Boundary/HomepageUtente_annunciLocatari.fxml"));

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
    public void cercaSuMappa(javafx.event.ActionEvent event){


    }

    @FXML
    public void cercaPerNome(javafx.event.ActionEvent event){


    }

    @FXML
    public void inserisciAnnuncioLocatore(javafx.event.ActionEvent event){

        try {
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/Boundary/InserisciStanza.fxml"));

            Scene scene = new Scene(root);
            stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Inserisci una stanza");
            stage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }


    }

    @FXML
    public void inserisciAnnuncioLocatario(javafx.event.ActionEvent event){

        try {
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/Boundary/InserisciRichiesta.fxml"));

            Scene scene = new Scene(root);
            stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Pubblica una richiesta");
            stage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void showSingleAnnounce(javafx.event.ActionEvent event){


        try {
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/Boundary/Annuncio_locatario_utente.fxml"));

            Scene scene = new Scene(root);

            stage = main.getStage();
            stage.setScene(scene);
            stage.setTitle("Annuncio locatario");
            this.stage.close();

            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void showProfile(javafx.event.ActionEvent event){


        try {
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/Boundary/Profilo.fxml"));

            Scene scene = new Scene(root);

            stage = main.getStage();
            stage.setScene(scene);
            stage.setTitle("Profilo utente");
            this.stage.close();

            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    @FXML
    public void pubblicaAnnuncio(javafx.event.ActionEvent event){

        try {
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/Boundary/PubblicaAnnuncioAppartamento.fxml"));

            Scene scene = new Scene(root);

            stage = main.getStage();
            stage.setScene(scene);
            stage.setTitle("Pubblica un annuncio");
            this.stage.close();

            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void showPreferiti(ActionEvent event){

    }

    public void setStageTitle(String newTitle) {
        Main.getStage().setTitle(newTitle);
    }


}
