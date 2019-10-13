package Boundary;


// Okay metodo publishTenantAnnounce(String nickname) cosi come nell'interfaccia di Announcing

import Bean.AnnuncioBean;
import Bean.StanzaBean;
import Bean.UtenteBean;
import Controller.Controller;
import Controller.ControllerAnnuncio;
import Enumerations.*;
import Exception.AnnuncioesistenteException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class InserisciRichiesta {

    @FXML
    private TextField citta;

    @FXML
    private Slider sliderprezzomin;

    @FXML
    private Slider sliderprezzomax;


    @FXML
    private RadioButton stanza;

    @FXML
    private RadioButton appartamento;

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
    private TextArea descrizione;
    @FXML
    private TextField p1;
    @FXML
    private TextField p2;
    @FXML
    private TextField nome_annuncio;


    protected String gasString, riscaldamentoString;
    protected static StanzaBean stanzabean = new StanzaBean();
    private int counter_annuncio_id = (int) (Math.random() * 1000 + 1);
    private String nomeCitta;
    final ToggleGroup group = new ToggleGroup();
    private String nickname;
    private UtenteBean  credenziali;

    @FXML
    public void initialize() {

        credenziali = ControllerAnnuncio.getUtentebean();
        nickname = credenziali.getUserid();

        ObservableList<Gas> gas = FXCollections.observableArrayList(Gas.values());
        this.gasComboBox.setItems(gas);
        this.gasComboBox.valueProperty().addListener((observable, oldValue, newValue) ->
                gasString = (newValue.toString()));

        ObservableList<Riscaldamento> riscaldamento = FXCollections.observableArrayList(Riscaldamento.values());
        this.riscaldamentoComboBox.setItems(riscaldamento);

        this.riscaldamentoComboBox.valueProperty().addListener((observable, oldValue, newValue) ->
                riscaldamentoString = (newValue.toString()));

        stanza.setToggleGroup(group);
        stanza.setSelected(true);

        appartamento.setToggleGroup(group);

        // create slider

        // set the value of property min,
        // max and value
        sliderprezzomin.setMin(0);
        sliderprezzomin.setMax(500);
        sliderprezzomin.setValue(80);


        sliderprezzomin.setBlockIncrement(20);

        // Adding Listener to value property.
        sliderprezzomin.valueProperty().addListener(
                new ChangeListener<Number>() {

                    public void changed(ObservableValue<? extends Number >
                                                observable, Number oldValue, Number newValue)
                    {
                        p1.setText(String.valueOf(newValue.intValue()));
                    }
                });

        sliderprezzomax.setMin(500);
        sliderprezzomax.setMax(1000);
        sliderprezzomax.setValue(80);

        sliderprezzomax.setBlockIncrement(20);

        // Adding Listener to value property.
        sliderprezzomax.valueProperty().addListener(
                new ChangeListener<Number>() {

                    public void changed(ObservableValue<? extends Number >
                                                observable, Number oldValue, Number newValue)
                    {
                        p2.setText(String.valueOf(newValue.intValue()));
                    }
                });

    }

    @FXML
    public void conferma (ActionEvent event) throws AnnuncioesistenteException {

        try {
            if (postiLettoInput.getText().isEmpty() || Integer.valueOf(postiLettoInput.getText()) <= 0 || Integer.valueOf(postiLettoInput.getText()) > 50) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Attenzione!");
                alert.setHeaderText("Inserimento non andato a buon fine");
                alert.setContentText("Riempire tutti i campi obbligatori!");
                alert.showAndWait();
                alert.close();
            }
            if (publishTenantAnnounce(nickname)) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Grazie!");
                alert.setHeaderText("Inserimento andato a buon fine");
                alert.showAndWait();
                alert.close();
            } else {
                throw new AnnuncioesistenteException();
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public boolean  publishTenantAnnounce(String nickname) {
        nomeCitta = citta.getText();
        AnnuncioBean ab = new AnnuncioBean();
        ab.setAnnounceId(counter_annuncio_id);
        ab.setVasca(vasca.isSelected());
        ab.setDoccia(doccia.isSelected());
        ab.setFrigorifero(frigorifero.isSelected());
        ab.setLavastoviglie(lavastoviglie.isSelected());
        ab.setTermostato(termostato.isSelected());
        ab.setMacchinaDelGas(macchinaGas.isSelected());
        ab.setMisuratoreConsumoSingolaUnità(misuratore.isSelected());
        ab.setRiscaldamento(riscaldamentoString);
        ab.setGas(gasString);
        ab.setPostiLetto(Integer.valueOf(this.postiLettoInput.getText()));
        ab.setDescription(descrizione.getText());
        ab.setWifi(wifi.isSelected());
        ab.setPrezzoMax((int) sliderprezzomax.getValue());
        ab.setPrezzoMin((int)sliderprezzomin.getValue());
        Date date= new Date();
        long time = date.getTime();
        Timestamp ts = new Timestamp(time);
        ab.setDate(ts);
        ab.setSignal(false);
        ab.setAttivo(true);
        ab.setUser(credenziali);
        ab.setCity(nomeCitta);
        ab.setNomeAnnuncio(nome_annuncio.getText());

        if (stanza.isSelected())
            ab.setStanzaboolean(true);
        else if (appartamento.isSelected())
            ab.setAppartamentoboolean(true);

        ControllerAnnuncio cA = ControllerAnnuncio.getInstance();
        return cA.inserisciAnnuncioLocatario(ab);
    }

    @FXML
    public void chiudi(ActionEvent event) {
        // implementazione del pulsante per chiudere la finestra attuale
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
        System.out.println("Pagina chiusa con successo");
    }



}
