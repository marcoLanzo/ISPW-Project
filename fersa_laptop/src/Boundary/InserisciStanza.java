package Boundary;

import Bean.StanzaBean;
import Bean.UtenteBean;
import Controller.Controller;
import Controller.ControllerAppartamento;
import Enumerations.Gas;
import Enumerations.Riscaldamento;
import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;


@SuppressWarnings("Duplicates")
public class InserisciStanza {

    @FXML
    private Button nextButton;
    @FXML
    private Button closeButton;
    @FXML
    private TextField postiLettoInput;
    @FXML
    private CheckBox vasca;
    @FXML
    private CheckBox lavastoviglie;
    @FXML
    private CheckBox wifi;
    @FXML
    private CheckBox frigorifero;
    @FXML
    private CheckBox doccia;
    @FXML
    private CheckBox macchinaGas;
    @FXML
    private CheckBox termostato;
    @FXML
    private CheckBox misuratore;
    @FXML
    private ComboBox<Gas> gasComboBox;
    @FXML
    private ComboBox<Riscaldamento> riscaldamentoComboBox;
    @FXML
    private AnchorPane stanzaPane;


    protected String gasString, riscaldamentoString;
    private  StanzaBean stanzabean = new StanzaBean();

    @FXML
    public void initialize() {

        ObservableList<Gas> gas = FXCollections.observableArrayList(Gas.values());
        this.gasComboBox.setItems(gas);
        this.gasComboBox.valueProperty().addListener((observable, oldValue, newValue) ->
                gasString = (newValue.toString()));

        ObservableList<Riscaldamento> riscaldamento = FXCollections.observableArrayList(Riscaldamento.values());
        this.riscaldamentoComboBox.setItems(riscaldamento);

        /*
        addListener prende un evento da ascoltare e una funzione da chiamare quando avviene l'evento

        toString prende l'enum
        */

        this.riscaldamentoComboBox.valueProperty().addListener((observable, oldValue, newValue) ->
                riscaldamentoString = (newValue.toString()));


    }

    /* Gestione tasto "Next": completo l'inserimento con le info dell'appartamento */
    @FXML
    public void inserisciStanzaAppartamento(ActionEvent event) {

        try {
            if (postiLettoInput.getText().isEmpty() || Integer.valueOf(postiLettoInput.getText()) <= 0 || Integer.valueOf(postiLettoInput.getText()) > 50) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Attenzione!");
                alert.setHeaderText("Inserimento non andato a buon fine");
                alert.setContentText("Riempire tutti i campi obbligatori!");
                alert.showAndWait();
                alert.close();
                return;
            }

            if (vasca.isSelected())
                stanzabean.setVasca(true);
            else stanzabean.setVasca((false));

            if (doccia.isSelected())
                stanzabean.setDoccia(true);
            else stanzabean.setDoccia(false);

            if (frigorifero.isSelected())
                stanzabean.setFrigorifero(true);
            else stanzabean.setFrigorifero(false);

            if (lavastoviglie.isSelected())
                stanzabean.setLavastoviglie(true);
            else stanzabean.setLavastoviglie(false);

            if (termostato.isSelected())
                stanzabean.setTermostato(true);
            else stanzabean.setTermostato(false);

            if (macchinaGas.isSelected())
                stanzabean.setMacchinaDelGas(true);
            else stanzabean.setMacchinaDelGas(false);

            if (misuratore.isSelected())
                stanzabean.setMisuratoreConsumoSingolaUnità(true);
            else stanzabean.setMisuratoreConsumoSingolaUnità(false);

            if (wifi.isSelected())
                stanzabean.setWifi(true);
            else stanzabean.setWifi(false);

            stanzabean.setRiscaldamento(riscaldamentoString);
            stanzabean.setGas(gasString);
            stanzabean.setPostiLetto(Integer.valueOf(this.postiLettoInput.getText()));
            ControllerAppartamento.setStanzabean(stanzabean);

            if (riscaldamentoString == null || gasString == null){

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Errore");
                alert.setHeaderText("Inserimento non andato a buon fine");
                alert.setContentText("Riempire tutti i obbligatori!");
                alert.showAndWait();
                alert.close();
                return;
            }

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/Boundary/InserisciAppartamento.fxml"));
            setStageTitle("Inserisci Appartamento");
            AnchorPane anchorPane = loader.load();
            stanzaPane.getChildren().setAll(anchorPane);


        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Attenzione!");
            alert.setHeaderText("Errore nel form");
            alert.setContentText("Inserire un numero valido!");
            alert.showAndWait();
            alert.close();
            return;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void indietro(ActionEvent event) {
        // implementazione del pulsante per chiudere la finestra attuale
        ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
        System.out.println("Pagina chiusa con successo");
    }

    public void setStageTitle(String newTitle) {
        Main.getStage().setTitle(newTitle);
    }



}
