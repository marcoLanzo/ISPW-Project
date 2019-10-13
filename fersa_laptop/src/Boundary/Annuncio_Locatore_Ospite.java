package Boundary;

import Bean.AnnuncioBean;
import Bean.UtenteBean;
import Controller.ControllerAnnuncio;
import Controller.MainController;
import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;


@SuppressWarnings("Duplicates")
public class Annuncio_Locatore_Ospite {


    @FXML
    private Text textAddress;
    @FXML
    private Text textcity;
    @FXML
    private Text textDescription;
    @FXML
    private Text textUser;
    @FXML
    private Text textAnnounceName;
    @FXML
    protected static Stage stage;
    @FXML
    private Text textriscaldamento;
    @FXML
    private Text textgas;
    @FXML
    private Text textprezzo;
    @FXML
    private Text numeropostiletto;
    @FXML
    private Text numerostanze;
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
    private Hyperlink maps;
    @FXML
    private ImageView imageApt;
    @FXML
    private Button rimuoviButton;


    private static AnnuncioBean annuncioBean;
    private static UtenteBean ub;


    @FXML
    public void initialize() {

        ub = MainController.getUtentebean();
        annuncioBean = MainController.getAnnuncioBean();
        textAddress.setText((annuncioBean.getAppartamentoBean().getSurfaceAddress()));
        textDescription.setText(annuncioBean.getAppartamentoBean().getDescription());
        textAnnounceName.setText(annuncioBean.getNomeAnnuncio());
        textUser.setText(annuncioBean.getUser().getUserid());
        textriscaldamento.setText(annuncioBean.getStanzabean().getRiscaldamento());
        textgas.setText(annuncioBean.getStanzabean().getGas());
        textprezzo.setText("€" + annuncioBean.getPrezzoMax());
        numeropostiletto.setText(String.valueOf(annuncioBean.getStanzabean().getPostiLetto()));
        numerostanze.setText(String.valueOf(annuncioBean.getAppartamentoBean().getStanze()));
        textcity.setText(annuncioBean.getAppartamentoBean().getCitta());
        imageApt.setImage(new Image("res/immobili/stanza2.jpg"));
        if (!annuncioBean.getStanzabean().isVasca()) {
            imageVasca.setImage(new Image("res/quadrato.png"));
        }
        if (!annuncioBean.getStanzabean().isDoccia()) {
            imageDoccia.setImage(new Image("res/quadrato.png"));
        }
        if (!annuncioBean.getStanzabean().isFrigorifero()) {
            imageFrigorifero.setImage(new Image("res/quadrato.png"));
        }
        if (!annuncioBean.getStanzabean().isLavastoviglie()) {
            imageLavastoviglie.setImage(new Image("res/quadrato.png"));
        }
        if (!annuncioBean.getStanzabean().isMacchinaDelGas()) {
            imageMacchinadelgas.setImage(new Image("res/quadrato.png"));
        }
        if (!annuncioBean.getStanzabean().isMisuratoreConsumoSingolaUnità()) {
            imageMisuratoreconsumosingolaunita.setImage(new Image("res/quadrato.png"));
        }
        if (!annuncioBean.getStanzabean().isTermostato()) {
            imageTermostato.setImage(new Image("res/quadrato.png"));
        }
        if (!annuncioBean.getStanzabean().isWifi()) {
            imageWifi.setImage(new Image("res/quadrato.png"));
        }

        maps.setText("Vuoi conoscere la posizione?! Clicca Qui");
        maps.setOnAction(event -> {
            try {
                Stage stage = new Stage();
                FXMLLoader loader = new FXMLLoader();
                Parent root = (AnchorPane) FXMLLoader.load(getClass().getResource("/Boundary/Maps.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("Posizione");
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


        DatePicker dataprenotazione = new DatePicker();
        dataprenotazione.setValue(LocalDate.of(2016, 7, 25));
        dataprenotazione.setShowWeekNumbers(true);

        FlowPane root = new FlowPane();
        root.getChildren().add(dataprenotazione);
        root.setPadding(new Insets(10));

    }

    public void displayRenterShowcase(ActionEvent event) {

        try {
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/Boundary/HomepageOspite_annunciLocatori.fxml"));

            Scene scene = new Scene(root);

            stage = Main.getStage();
            stage.setScene(scene);
            stage.setTitle("Homepage");
            stage.close();

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

            stage = Main.getStage(); // mi prendo il primary stage definito nell'initRootLayout
            stage.setScene(scene); //ci setto la nuova scene da visualizzare senza aprire una nuova finestra
            stage.setTitle("Homepage");
            this.stage.close();//chiudo la finestra precedente

            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void signal(ActionEvent event) {

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
    public void insertFavorites(ActionEvent event) {

    }


    @FXML
    public void contattaLocatore(ActionEvent event) { //TODO: mettere che posso contattarlo dopo aver selezionato le date!

        MainController.increase_counter_renting(annuncioBean);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Grazie!");
        alert.setHeaderText("Locatore contattato");
        alert.setContentText("Controllo della sua prenotazione passata in gestione a Renting");
        alert.showAndWait();
        alert.close();
        System.out.println("Controllo della prenotazione passato a Renting");
    }

    @FXML
    public void cercaSuMappa(ActionEvent event) {


    }

    @FXML
    public void cercaPerNome(ActionEvent event) {

    }


}
