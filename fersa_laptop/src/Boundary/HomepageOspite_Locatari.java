package Boundary;

import Bean.AnnuncioBean;
import Controller.Controller;
import Controller.ControllerAnnuncio;
import Controller.ControllerBachecaLocatario;
import Controller.ControllerBachecaLocatore;
import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;


public class HomepageOspite_Locatari{


    protected static Stage loginStage;
    @FXML
    private AnchorPane homepageOspitePane;
    @FXML
    private Main main;
    @FXML
    protected static Stage stage;
    @FXML
    private Button annunciLocatoriBtn;
    @FXML
    private Button annunciLocatariBtn;
    @FXML
    private Button cercaMappaBtn;
    @FXML
    private Button cercaNomeBtn;
    @FXML
    private Button nextBtn;
    @FXML
    private Button backBtn;
    @FXML
    private Button loginButton;
    @FXML
    private Text textAnnounceName;
    @FXML
    private Text textPrice;
    @FXML
    private Text textNickname;
    @FXML
    private Text textCity;
    @FXML
    private Text textAnnounceName2;
    @FXML
    private Text textPrice2;
    @FXML
    private Text textNickname2;
    @FXML
    private Text textCity2;
    @FXML
    private Text textAnnounceName3;
    @FXML
    private Text textPrice3;
    @FXML
    private Text textNickname3;
    @FXML
    private Text textCity3;
    @FXML
    private Text textAnnounceName4;
    @FXML
    private Text textPrice4;
    @FXML
    private Text textNickname4;
    @FXML
    private Text textCity4;
    @FXML
    private ImageView imageUser;
    @FXML
    private ImageView imageUser2;
    @FXML
    private ImageView imageUser3;
    @FXML
    private ImageView imageUser4;

    private static int size;
    private static int k ;
    private static int pagina;
    private static int visualizzati;
    private ControllerBachecaLocatario cL;


    public void setMain(Main main) {
        this.main = main;
    }

    public void setStage(Stage ospiteStage) {
        this.stage = ospiteStage;
    }

    public Stage getStage() {return this.stage;}

    @FXML
    public void initialize() {


        /* Finché avrò annunci da visualizzare, setterò le relative Text ed immagini */

        k = ControllerBachecaLocatario.getK();
        visualizzati = ControllerBachecaLocatario.getVisualizzati();
        pagina = ControllerBachecaLocatario.getPagina();


        cL = ControllerBachecaLocatario.getInstance();
        ArrayList<AnnuncioBean> ab = cL.displayTenantShowcase();

        if (pagina == 0)
            backBtn.setVisible(false);
        else backBtn.setVisible(true);

        if (pagina > 0 && (k >= size || visualizzati < 4))
            nextBtn.setVisible(false);
        else nextBtn.setVisible(true);

        size = ab.size();

        if(k<0)
            k = 0;


        if (k < size) { // se k == size significa che ho visualizzato tutti gli annunci disponibili
            textAnnounceName.setText(ab.get(k).getNomeAnnuncio());
            textNickname.setText("Richiesta di: "+ab.get(k).getUser().getUserid());
            textPrice.setText("€" + (ab.get(k).getPrezzoMin())+"-"+(ab.get(k).getPrezzoMax()));
            textCity.setText(ab.get(k).getCity());
            imageUser.setImage(new Image("res/immobili/appartamento1.jpg"));
            visualizzati++;
            k++;
        }

        if (k < size) {
            textAnnounceName2.setText(ab.get(k).getNomeAnnuncio());
            textNickname2.setText("Richiesta di: "+ab.get(k).getUser().getUserid());
            textPrice2.setText("€" + (ab.get(k).getPrezzoMin())+"-"+(ab.get(k).getPrezzoMax()));
            textCity2.setText(ab.get(k).getCity());
            imageUser2.setImage(new Image("res/immobili/stanza1.jpg"));
            visualizzati++;
            k++;

        }
        if (k < size) {
            textAnnounceName3.setText(ab.get(k).getNomeAnnuncio());
            textNickname3.setText("Richiesta di: "+ab.get(k).getUser().getUserid());
            textPrice3.setText("€" + (ab.get(k).getPrezzoMin())+"-"+(ab.get(k).getPrezzoMax()));
            textCity3.setText(ab.get(k).getCity());
            imageUser3.setImage(new Image("res/immobili/stanza2.jpg"));
            visualizzati++;
            k++;

        }
        if (k < size){
            textAnnounceName4.setText (ab.get(k).getNomeAnnuncio());
            textNickname4.setText("Richiesta di: "+ab.get(k).getUser().getUserid());
            textPrice4.setText("€" + (ab.get(k).getPrezzoMin())+"-"+(ab.get(k).getPrezzoMax()));
            textCity4.setText(ab.get(k).getCity());
            imageUser4.setImage(new Image("res/immobili/stanza3.jpg"));
            visualizzati++;
            k++;

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
            ControllerBachecaLocatario.setPagina(0);
            ControllerBachecaLocatario.setK(0);
            ControllerBachecaLocatario.setVisualizzati(0);
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
    public void showAnnunciLocatari(ActionEvent event) {

        try {

            pagina = 0;
            k = 0;
            visualizzati=0;
            ControllerBachecaLocatario.setPagina(0);
            ControllerBachecaLocatario.setK(0);
            ControllerBachecaLocatario.setVisualizzati(0);
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/Boundary/HomepageOspite_annunciLocatari.fxml"));

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

            pagina = pagina ++;
            visualizzati = 0;
            k = k+4;
            ControllerBachecaLocatario.setPagina(pagina);
            ControllerBachecaLocatario.setK(k+4);
            ControllerBachecaLocatario.setVisualizzati(0);

            root = (AnchorPane) FXMLLoader.load(getClass().getResource("/Boundary/HomepageOspite_annunciLocatari.fxml"));

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
    public void backPage(ActionEvent event) {

        AnchorPane root = null;
        try {

            k = k-visualizzati-4;
            pagina--;
            visualizzati = 0;
            ControllerBachecaLocatario.setPagina(pagina);
            ControllerBachecaLocatario.setK(k);
            ControllerBachecaLocatario.setVisualizzati(0);


            root = (AnchorPane) FXMLLoader.load(getClass().getResource("/Boundary/HomepageOspite_annunciLocatari.fxml"));

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
    public void accedi(ActionEvent event){

        try {
            ControllerBachecaLocatario.setPagina(0);
            ControllerBachecaLocatario.setK(0);
            ControllerBachecaLocatario.setVisualizzati(0);
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
            ControllerBachecaLocatario.setPagina(0);
            ControllerBachecaLocatario.setK(0);
            ControllerBachecaLocatario.setVisualizzati(0);
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/Boundary/Registrazione.fxml"));

            Scene scene = new Scene(root);
            Stage stage = loginStage;
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
            ControllerBachecaLocatario.setPagina(0);
            ControllerBachecaLocatario.setK(0);
            ControllerBachecaLocatario.setVisualizzati(0);
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/Boundary/Annuncio_locatario_ospite.fxml"));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Pubblica una richiesta");
            stage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }

    }


}

