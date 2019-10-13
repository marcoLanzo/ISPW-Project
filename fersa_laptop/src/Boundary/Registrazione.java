package Boundary;

import Bean.UtenteBean;
import Controller.Controller;
import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import Exception.UtenteEsistenteException;


import java.io.IOException;


public class Registrazione {

    int type;
    @FXML
    private TextField user;
    @FXML
    private TextField password;
    @FXML
    private Main main;
    @FXML
    private Stage stage;
    @FXML
    private AnchorPane registerPane;

    @FXML
    public void Esci() {
        System.out.println("Uscito dal sistema con successo");
        System.exit(0);
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public void setStage(Stage loginStage) {
        this.stage = loginStage;
    }


    @FXML
    public void registra(ActionEvent event) throws UtenteEsistenteException {

        String user = this.user.getText();
        String pass = this.password.getText();
        if (user.isEmpty() || pass.isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("");
            alert.setHeaderText("Attenzione!");
            alert.setContentText("Per effettuare la registrazione inserire username e password.");
            alert.showAndWait();

        } else {
            UtenteBean ub = new UtenteBean();
            ub.setUserid(user);
            ub.setPassword(pass);
            System.out.println("Tentativo di registrazione con i seguenti dati:");
            System.out.println("ID:" + user + "     " + "password:" + pass);

            try {
                Controller controllerFisico = Controller.getInstance();

                if (!controllerFisico.registrazione(ub.getUserid(), ub.getPassword())){

                    throw new UtenteEsistenteException();
                }
                else {

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("");
                    alert.setHeaderText("Grazie!");
                    alert.setContentText("La registrazione nel sistema è andata a buon fine");
                    alert.showAndWait();

                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/Boundary/Login.fxml"));
                    setStageTitle("Login");

                    AnchorPane anchorPane = loader.load();
                    registerPane.getChildren().setAll(anchorPane);
                }
            } catch (NullPointerException e) {
                this.main.apriSchermataErrore();
                System.out.println("Errore nell'accesso ");
                stage.close();

            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    @FXML
    public void indietro(ActionEvent event){

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Boundary/Login.fxml"));
        setStageTitle("Login");

        try {
            AnchorPane anchorPane = loader.load();
            registerPane.getChildren().setAll(anchorPane);

        }catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public void setStageTitle(String newTitle) {
        Main.getStage().setTitle(newTitle);
    }

}

