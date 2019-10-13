package Boundary;

import Bean.AnnuncioBean;
import Bean.AppartamentoBean;
import Bean.StanzaBean;
import Bean.UtenteBean;
import Controller.ControllerAnnuncio;
import Controller.ControllerAppartamento;
import Dao.AnnuncioDao;
import Exception.AnnuncioRifiutatoExecption;
import Exception.AnnuncioesistenteException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Vector;

@SuppressWarnings("Duplicates")
public class PubblicaAnnuncioAppartamento {

    @FXML
    private ComboBox<Object> SelezionaImmobile;

    @FXML
    private TextField announcePrice;

    @FXML
    private TextField announceName;


    private AppartamentoBean AppSelezionato;
    private StanzaBean stanzaSelezionata;
    private Object immobileSelezionato;
    protected Vector<AppartamentoBean> v = new Vector<>(2);
    protected String aptString;
    protected String stanzaString;
    private int counter_annuncio_id = (int) (Math.random() * 1000 + 1);
    private String nickname;

    public void initialize() {
        UtenteBean credenziali = ControllerAnnuncio.getUtentebean();
        nickname = credenziali.getUserid();
        ControllerAppartamento cA = ControllerAppartamento.getInstance();
        ArrayList<AppartamentoBean> Ab ;
        ArrayList<StanzaBean> sB ;
        Ab = cA.ottieniAppartamento(credenziali.getUserid());
        sB = cA.ottieniStanza(credenziali.getUserid());

        ObservableList<AppartamentoBean> appartamenti = FXCollections.observableArrayList(Ab);
        ObservableList<StanzaBean> stanze = FXCollections.observableArrayList(sB);
        ObservableList<Object> immobili = FXCollections.observableArrayList();
        immobili.addAll(stanze);
        immobili.addAll(appartamenti);

        this.SelezionaImmobile.setItems(immobili);

        this.SelezionaImmobile.valueProperty().addListener((observable, oldValue, newValue) ->
        {
            aptString = newValue.toString();
            stanzaString = newValue.toString();
            immobileSelezionato = newValue;

            if (immobileSelezionato instanceof AppartamentoBean)
                AppSelezionato = (AppartamentoBean) immobileSelezionato;
            if (immobileSelezionato instanceof StanzaBean)
                stanzaSelezionata = (StanzaBean) immobileSelezionato;
        });
    }

    @FXML
    public void conferma() throws AnnuncioesistenteException {


        try{
            if (announceName.getText().isEmpty() || announcePrice.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Attenzione!");
            alert.setHeaderText("Inserimento non andato a buon fine");
            alert.setContentText("Riempire tutti i campi obbligatori!");
            alert.showAndWait();
            alert.close();
        }
        if( Integer.valueOf(announcePrice.getText()) <= 0) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Attenzione!");
            alert.setHeaderText("Inserimento non andato a buon fine");
            alert.setContentText("Inserire un prezzo per l'immobile positivo!");
            alert.showAndWait();
            alert.close();
        }

        if (immobileSelezionato == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Attenzione!");
            alert.setHeaderText("Inserimento non andato a buon fine");
            alert.setContentText("Selezionare almeno una stanza o un appartamento");
            alert.showAndWait();
            alert.close();

        }

            if (stanzaSelezionata == null) { //annuncio appartamento (stanza null)
                if (publishRenterAnnounce(AppSelezionato.getApartmentId(),nickname)) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Grazie!");
                    alert.setHeaderText("Inserimento andato a buon fine");
                    alert.showAndWait();
                    alert.close();
                    if (HomepageLocatore.publishStage != null)
                        HomepageLocatore.publishStage.close();

                    if (HomepageLocatario.publishStage != null){
                        HomepageLocatario.publishStage.close();
                    }
                } else
                    throw new AnnuncioesistenteException();
            }else {//annuncio stanza
                if (publishRenterAnnounce(stanzaSelezionata.getAppartamentoId(), nickname)) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Grazie!");
                    alert.setHeaderText("Inserimento andato a buon fine");
                    alert.showAndWait();
                    alert.close();

                    if (HomepageLocatore.publishStage != null)
                        HomepageLocatore.publishStage.close();

                    if (HomepageLocatario.publishStage != null){
                        HomepageLocatario.publishStage.close();
                    }
                } else
                    throw new AnnuncioesistenteException();
            }
        }catch (NullPointerException e) {
            e.printStackTrace();
        }catch(AnnuncioRifiutatoExecption a){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Attenzione!");
            alert.setHeaderText("Inserimento non andato a buon fine");
            alert.setContentText("L'annuncio inserito non rispetta le regole del sistema.");
            alert.showAndWait();
            alert.close();
        }catch(NumberFormatException ne){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Attenzione!");
            alert.setHeaderText("Inserimento non andato a buon fine");
            alert.setContentText("Inserire un prezzo numerico!");
            alert.showAndWait();
            alert.close();
        }
    }

    private  boolean publishRenterAnnounce(int id,String nickname) throws AnnuncioRifiutatoExecption {
        ControllerAnnuncio cA = ControllerAnnuncio.getInstance();
        String nomeAnnuncio = announceName.getText();
        int prezzoAnnuncio = Integer.valueOf(announcePrice.getText());

        AnnuncioBean ab = new AnnuncioBean();
        while(AnnuncioDao.annuncioEsistente(counter_annuncio_id)){
            counter_annuncio_id++;
        }
        ab.setAnnounceId(counter_annuncio_id);
        ab.setNomeAnnuncio(nomeAnnuncio);
        ab.setPrezzoMax(prezzoAnnuncio);
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        ab.setDate(ts);
        UtenteBean ub = new UtenteBean();
        ub.setUserid(nickname);
        ab.setUser(ub);
        ab.getUser().setUserid(nickname);
        ab.setCounterRenting(0);

        if (stanzaSelezionata == null) {
            ab.setAppartamentoId(id);
            ab.setCity(AppSelezionato.getCitta());
        }else { //annuncio stanza
            String city = cA.getCity(stanzaSelezionata);
            ab.setStanza_id(stanzaSelezionata.getStanzaid());
            ab.setAppartamentoId(id);
            ab.setCity(city);

        }
        ab.setAttivo(true);
        ab.setSignal(false);
        if (checkAnnounce(ab.getAnnounceId())) {
            try {
                return cA.inserisciAnnuncio(ab);

            }catch (AnnuncioesistenteException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("");
                alert.setHeaderText("Attenzione!");
                alert.setContentText("L'annuncio sull'appartamento inserito è già esistente.");
                alert.showAndWait();

                return false;
            }
        }
        else
            throw new AnnuncioRifiutatoExecption();
    }

    @FXML
    public void chiudi(ActionEvent event){

        ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
        System.out.println("Pagina chiusa con successo");

    }

    /* Metodo checkAnnounce importato da Rules -> testato in modo fittizio con un boolean randomico che
    nell'80 % dei casi torna true;
     */
    private boolean checkAnnounce(int id)
    {
        Random random = new Random();
        int  n = (random.nextInt(10));

        boolean true80 = (n < 8) ? true : false;
        return true80;
    }
}
