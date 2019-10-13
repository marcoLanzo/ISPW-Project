package Boundary;

import Bean.AnnuncioBean;
import Bean.UtenteBean;
import Controller.ControllerAnnuncio;
import Controller.ControllerBachecaLocatore;
import Enumerations.Gas;
import Enumerations.Riscaldamento;
import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;


public class HomepageOspite_Locatori {


    protected String gasString, riscaldamentoString;

    @FXML
    private Main main;
    @FXML
    protected static Stage stage;

    protected static Stage loginStage;
    @FXML
    protected Text textUtente;
    @FXML
    private Text textAnnounceName;
    @FXML
    private Text textPrice;
    @FXML
    private Text textNickname;
    @FXML
    private Text textAnnounceName2;
    @FXML
    private Text textPrice2;
    @FXML
    private Text textNickname2;
    @FXML
    private Text textAnnounceName3;
    @FXML
    private Text textPrice3;
    @FXML
    private Text textNickname3;
    @FXML
    private Text textAnnounceName4;
    @FXML
    private Text textPrice4;
    @FXML
    private Text textNickname4;
    @FXML
    private ImageView imageApt1;
    @FXML
    private ImageView imageApt2;
    @FXML
    private ImageView imageApt3;
    @FXML
    private ImageView imageApt4;
    @FXML
    private Button backBtn;
    @FXML
    private Button nextBtn;

    @FXML
    private Text textcity;
    @FXML
    private Text textcity2;
    @FXML
    private Text textcity3;
    @FXML
    private Text textcity4;

    @FXML
    private ComboBox<Gas> gasComboBox;
    @FXML
    private ComboBox<Riscaldamento> riscaldamentoComboBox;
    @FXML
    private Button announceButton1;
    @FXML
    private Button announceButton2;
    @FXML
    private Button announceButton3;
    @FXML
    private Button announceButton4;

    public void setMain(Main main) {
        this.main = main;
    }

    public void setStage(Stage ospiteStage) {
        this.stage = ospiteStage;
    }

    public Stage getStage() {return this.stage;}





    private static int size ;
    private static int k  ;
    private static int pagina ;
    private static int visualizzati ;
    private static int i ;
    private ControllerBachecaLocatore controllerBachecaLocatore;
    private UtenteBean utenteBean;
    private AnnuncioBean annuncioBean;



    protected ArrayList<AnnuncioBean> ab;
    @FXML
    public void initialize() { /* Il metodo initialize setta le variabili desiderate prima di creare la finestra */

        utenteBean = ControllerBachecaLocatore.getUtentebean();
        k = ControllerBachecaLocatore.getK();
        i = ControllerBachecaLocatore.getI();
        visualizzati = ControllerBachecaLocatore.getVisualizzati();
        pagina = ControllerBachecaLocatore.getPagina();

        controllerBachecaLocatore = ControllerBachecaLocatore.getInstance();
        ab = controllerBachecaLocatore.displayRenterShowcase();

        ObservableList<Gas> gas = FXCollections.observableArrayList(Gas.values());
        this.gasComboBox.setItems(gas);
        this.gasComboBox.valueProperty().addListener((observable, oldValue, newValue) ->
                gasString = (newValue.toString()));

        ObservableList<Riscaldamento> riscaldamento = FXCollections.observableArrayList(Riscaldamento.values());
        this.riscaldamentoComboBox.setItems(riscaldamento);
        this.riscaldamentoComboBox.valueProperty().addListener((observable, oldValue, newValue) ->
                riscaldamentoString = (newValue.toString()));

        size = ab.size();

        if (pagina == 0)
            backBtn.setVisible(false);
        else backBtn.setVisible(true);

        if (pagina > 0 && (k >= size || visualizzati < 4))
            nextBtn.setVisible(false);
        else nextBtn.setVisible(true);

        if (size <= 4) {
            nextBtn.setVisible(false);
        }


        if (k < 0)
            k = 0;

        if (k < size) { // se k == size significa che ho visualizzato tutti gli annunci disponibili
            textAnnounceName.setText(ab.get(k).getNomeAnnuncio());
            textNickname.setText(ab.get(k).getUser().getUserid());
            textPrice.setText("€" + (ab.get(k).getPrezzoMax()));
            textcity.setText(ab.get(k).getCity());
            imageApt1.setImage(new Image("res/immobili/appartamento1.jpg"));
            visualizzati++;
            k++;
        }

        if (k < size) {
            textAnnounceName2.setText(ab.get(k).getNomeAnnuncio());
            textNickname2.setText(ab.get(k).getUser().getUserid());
            textPrice2.setText("€" + (ab.get(k).getPrezzoMax()));
            imageApt2.setImage(new Image("res/immobili/stanza1.jpg"));
            textcity2.setText(ab.get(k).getCity());
            visualizzati++;
            k++;
        }
        if (k < size) {
            textAnnounceName3.setText(ab.get(k).getNomeAnnuncio());
            textNickname3.setText(ab.get(k).getUser().getUserid());
            textPrice3.setText("€" + (ab.get(k).getPrezzoMax()));
            imageApt3.setImage(new Image("res/immobili/stanza2.jpg"));
            textcity3.setText(ab.get(k).getCity());
            visualizzati++;
            k++;
        }
        if (k < size) {
            textAnnounceName4.setText(ab.get(k).getNomeAnnuncio());
            textNickname4.setText(ab.get(k).getUser().getUserid());
            textPrice4.setText("€" + (ab.get(k).getPrezzoMax()));
            imageApt4.setImage(new Image("res/immobili/stanza3.jpg"));
            textcity4.setText(ab.get(k).getCity());
            visualizzati++;
            k++;
        }

        if (k-4 <size ) {
            try {
                announceButton1.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        annuncioBean = controllerBachecaLocatore.annuncioselezionatolocatore(ab.get(i));
                        ControllerBachecaLocatore.setAnnuncioBean(annuncioBean);
                        showSingleAnnounce(event);

                    }
                });
            } catch (ArrayIndexOutOfBoundsException exception) {
                System.out.println("Non è presente nessun annuncio da selezionare");
            }
        }
        if (k-3<size) {
            try {
                announceButton2.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        annuncioBean = controllerBachecaLocatore.annuncioselezionatolocatore(ab.get(i+1));
                        ControllerBachecaLocatore.setAnnuncioBean(annuncioBean);
                        showSingleAnnounce(event);

                    }
                });
            } catch (ArrayIndexOutOfBoundsException  index) {
                System.out.println("Non è presente nessun annuncio da selezionare");
            }
        }
        if (k-2<size) {
            try {
                announceButton3.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        annuncioBean = controllerBachecaLocatore.annuncioselezionatolocatore(ab.get(i+2));
                        ControllerBachecaLocatore.setAnnuncioBean(annuncioBean);
                        showSingleAnnounce(event);

                    }
                });
            } catch (ArrayIndexOutOfBoundsException index) {
                System.out.println("Non è presente nessun annuncio da selezionare");
            }
        }
        if (k-1<size) {

            announceButton4.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    annuncioBean = controllerBachecaLocatore.annuncioselezionatolocatore(ab.get(i+3));
                    ControllerBachecaLocatore.setAnnuncioBean(annuncioBean);
                    showSingleAnnounce(event);

                }
            });
        }
    }

    @FXML
    public void cercaSuMappa(ActionEvent event) {


    }

    @FXML
    public void cercaPerNome(ActionEvent event) {


    }

    @FXML
    public void showAnnunciLocatori(ActionEvent event) {

        try {
            pagina = 0;
            k = 0;
            visualizzati=0;
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/Boundary/HomepageOspite_annunciLocatori.fxml"));
            Scene scene = new Scene(root);

            stage = Main.getStage();
            stage.setScene(scene);
            stage.setTitle("Homepage");
            this.stage.close();

            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void showAnnunciLocatari(ActionEvent event) {

        try {
            pagina = 0;
            k = 0;
            visualizzati=0;
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/Boundary/HomepageOspite_annunciLocatari.fxml"));

            Scene scene = new Scene(root);

            stage = Main.getStage();
            stage.setScene(scene);
            stage.setTitle("Homepage");
            this.stage.close();

            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void inserisciPreferiti(ActionEvent event) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Non registrato");
        alert.setHeaderText("Attenzione!");
        alert.setContentText("Per inserire un annuncio tra i preferiti devi effettuare il login");
        alert.showAndWait();

    }

    @FXML
    public void nextPage(ActionEvent event) {

        AnchorPane root = null;
        try {

            pagina++;
            visualizzati = 0;

            root = (AnchorPane) FXMLLoader.load(getClass().getResource("/Boundary/HomepageOspite_annunciLocatori.fxml"));

            Scene scene = new Scene(root);

            stage = Main.getStage();
            stage.setScene(scene);
            stage.setTitle("Homepage");
            this.stage.close();

            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void backPage(ActionEvent event) {

        AnchorPane root = null;
        try {

            k = k-visualizzati-4;
            pagina--;
            visualizzati = 0;


            root = (AnchorPane) FXMLLoader.load(getClass().getResource("/Boundary/HomepageOspite_annunciLocatori.fxml"));

            Scene scene = new Scene(root);

            stage = Main.getStage();
            stage.setScene(scene);
            stage.setTitle("Homepage");
            this.stage.close();

            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void accedi(ActionEvent event){

        try {

            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/Boundary/Login.fxml"));

            Scene scene = new Scene(root);
            loginStage = new Stage();
            loginStage.setScene(scene);
            loginStage.setTitle("Login");
            loginStage.show();

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

    @FXML
    public void showSingleAnnounce(ActionEvent event){


        try {
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/Boundary/Annuncio_locatore_ospite.fxml"));

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Pubblica una richiesta");
            stage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void showProfile(ActionEvent event){


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Non registrato");
        alert.setHeaderText("Attenzione!");
        alert.setContentText("Per andare sul tuo profilo ");
        alert.showAndWait();


    }

}