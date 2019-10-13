package Boundary;

import Bean.AnnuncioBean;
import Bean.UtenteBean;
import Controller.ControllerAnnuncio;
import Controller.MainController;
import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class Annuncio_locatario {

    @FXML
    protected Text textUtente;
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
    private Main main;
    @FXML
    protected static Stage stage;
    @FXML
    private Text textriscaldamento;
    @FXML
    private Text textgas;
    @FXML
    private Text numeropostiletto;
    @FXML
    private ImageView imageVasca;
    @FXML
    private ImageView imageDoccia;
    @FXML
    private ImageView imageWifi;
    @FXML
    private ImageView imageTermostato;
    @FXML
    private ImageView imageFrigorifero;
    @FXML
    private ImageView imageMacchinadelgas;
    @FXML
    private ImageView imageLavastoviglie;
    @FXML
    private ImageView imageMisuratoreconsumosingolaunita;
    @FXML
    private Button rimuoviButton;
    @FXML
    private Text textminPrice;
    @FXML
    private Text textmaxPrice;



    protected static AnnuncioBean annuncioBean = new AnnuncioBean();

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    public void initialize() {


        UtenteBean credenziali = MainController.getUtentebean();
        annuncioBean = MainController.getAnnuncioBean();
        textUtente.setText("Benvenuto " + credenziali.getUserid());
        textCity.setText((annuncioBean.getCity()));
        textminPrice.setText("€" + String.valueOf(annuncioBean.getPrezzoMin()));
        textmaxPrice.setText(String.valueOf(annuncioBean.getPrezzoMax()));
        textDescription.setText(annuncioBean.getDescription());
        textAnnounceName.setText(annuncioBean.getNomeAnnuncio());
        annuncioBean = MainController.getAnnuncioBean();
        textUtente.setText("Benvenuto " + credenziali.getUserid());
        textDescription.setText(annuncioBean.getDescription());
        textAnnounceName.setText(annuncioBean.getNomeAnnuncio());
        textUser.setText(annuncioBean.getUser().getUserid());
        textriscaldamento.setText(annuncioBean.getRiscaldamento());
        textgas.setText(annuncioBean.getGas());
        numeropostiletto.setText(String.valueOf(annuncioBean.getPostiLetto()));
        textCity.setText(annuncioBean.getCity());
        if (!annuncioBean.isVasca()) {
            imageVasca.setImage(new Image("res/quadrato.png"));
        }
        if (!annuncioBean.isDoccia()) {
            imageDoccia.setImage(new Image("res/quadrato.png"));
        }
        if (!annuncioBean.isFrigorifero()) {
            imageFrigorifero.setImage(new Image("res/quadrato.png"));
        }
        if (!annuncioBean.isLavastoviglie()) {
            imageLavastoviglie.setImage(new Image("res/quadrato.png"));
        }
        if (!annuncioBean.isMacchinaDelGas()) {
            imageMacchinadelgas.setImage(new Image("res/quadrato.png"));
        }
        if (!annuncioBean.isMisuratoreConsumoSingolaUnità()) {
            imageMisuratoreconsumosingolaunita.setImage(new Image("res/quadrato.png"));
        }
        if (!annuncioBean.isTermostato()) {
            imageTermostato.setImage(new Image("res/quadrato.png"));
        }
        if (!annuncioBean.isWifi()) {
            imageWifi.setImage(new Image("res/quadrato.png"));
        }

    }


    @FXML
    public void displayRenterShowcase(ActionEvent event) {

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
    public void displayTenantShowcase(ActionEvent event) {

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
    public void signal(ActionEvent event){

        annuncioBean.setSignal(true);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Grazie!");
        alert.setHeaderText("Segnalazione effettuata");
        alert.setContentText("La segnalazione verrà valutata dal sottosistema Rules");
        alert.showAndWait();
        alert.close();
        System.out.println("Controllo della segnalazione passato a Rules");

    }


    @FXML
    public void showProfile(ActionEvent event){


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
    public void inserisciAppartamento(ActionEvent event){

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
    public void inserisciRichiesta(ActionEvent event){

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
    public void displayFavorites(ActionEvent event){

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
