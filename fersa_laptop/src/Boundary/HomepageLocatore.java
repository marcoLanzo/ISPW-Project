package Boundary;

import Bean.AnnuncioBean;
import Bean.UtenteBean;
import Controller.ControllerBachecaLocatore;
import Controller.MainController;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HomepageLocatore {

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
    private AnchorPane homepageLocatorePane;
    @FXML
    private ComboBox<Gas> gasComboBox;
    @FXML
    private ComboBox<Riscaldamento> riscaldamentoComboBox;
    @FXML
    private Button buttonHeart1;
    @FXML
    private Button buttonHeart2;
    @FXML
    private Button buttonHeart3;
    @FXML
    private Button buttonHeart4;
    @FXML
    private ImageView imageHeart1;
    @FXML
    private ImageView imageHeart2;
    @FXML
    private ImageView imageHeart3;
    @FXML
    private ImageView imageHeart4;
    @FXML
    private Button announceButton1;
    @FXML
    private Button announceButton2;
    @FXML
    private Button announceButton3;
    @FXML
    private Button announceButton4;

    protected Main main = new Main();

    protected String gasString, riscaldamentoString;

    protected static Stage stage;

    protected static Stage publishStage;

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

        textUtente.setText("Benvenuto " + utenteBean.getUserid());
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

        if (size <= 4){
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
                buttonHeart1.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if (inserisciPreferiti(ab.get(i), utenteBean)) { // Inserimento tra i preferiti
                            imageHeart1.setImage(new Image("res/full_heart.png"));
                        } else {  //Rimozione dai preferiti
                            imageHeart1.setImage(new Image("res/heart.png"));

                        }
                    }
                });
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

                buttonHeart2.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if (inserisciPreferiti(ab.get(i+1), utenteBean)) {
                            imageHeart2.setImage(new Image("res/full_heart.png"));

                        } else {  //Rimozione dai preferiti
                            imageHeart2.setImage(new Image("res/heart.png"));

                        }
                    }
                });
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
                buttonHeart3.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if (inserisciPreferiti(ab.get(i+2), utenteBean)) {
                            imageHeart3.setImage(new Image("res/full_heart.png"));

                        }else{//Rimozione dai preferiti
                            imageHeart3.setImage(new Image("res/heart.png"));
                        }
                    }
                });
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

                buttonHeart4.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if (inserisciPreferiti(ab.get(i+3), utenteBean)) {
                            imageHeart4.setImage(new Image("res/full_heart.png"));
                        }else{
                            imageHeart4.setImage(new Image("res/heart.png"));
                        }
                    }
                });
                announceButton4.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        annuncioBean = controllerBachecaLocatore.annuncioselezionatolocatore(ab.get(i+3));
                        ControllerBachecaLocatore.setAnnuncioBean(annuncioBean);
                        showSingleAnnounce(event);

                    }
                });
            }

        for (int z = 0;z<ab.size();z++) {
            switch (z) {
                case 0:
                    if (controllerBachecaLocatore.checkpreferiti(ab.get(z).getAnnounceId(), utenteBean.getUserid())) {
                        imageHeart1.setImage(new Image("res/full_heart.png"));
                        break;
                    }
                case 1:
                    if (controllerBachecaLocatore.checkpreferiti(ab.get(z).getAnnounceId(), utenteBean.getUserid())) {
                        imageHeart2.setImage(new Image("res/full_heart.png"));
                        break;
                    }
                case 2:
                    if (controllerBachecaLocatore.checkpreferiti(ab.get(z).getAnnounceId(), utenteBean.getUserid())) {
                        imageHeart3.setImage(new Image("res/full_heart.png"));
                        break;
                    }
                case 3:
                    if (controllerBachecaLocatore.checkpreferiti(ab.get(z).getAnnounceId(), utenteBean.getUserid())) {
                        imageHeart4.setImage(new Image("res/full_heart.png"));
                        break;
                    }
                case 4:
                    break;
            }

            if (z==4)
                break;
        }

    }

    @FXML
    public void showAnnunciLocatori(ActionEvent event) {

        try {
            k = 0;
            i = 0;
            visualizzati = 0;
            pagina = 0;
            ControllerBachecaLocatore.setK(k);
            ControllerBachecaLocatore.setI(i);
            ControllerBachecaLocatore.setVisualizzati(visualizzati);
            ControllerBachecaLocatore.setPagina(pagina);
            AnchorPane root = FXMLLoader.load(getClass().getResource("/Boundary/HomepageUtente_annunciLocatori.fxml"));

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
    public void showAnnunciLocatari(ActionEvent event) {

        try {
            k = 0;
            i = 0;
            visualizzati = 0;
            pagina = 0;

            ControllerBachecaLocatore.setK(k);
            ControllerBachecaLocatore.setI(i);
            ControllerBachecaLocatore.setVisualizzati(visualizzati);
            ControllerBachecaLocatore.setPagina(pagina);

            AnchorPane root = FXMLLoader.load(getClass().getResource("/Boundary/HomepageUtente_annunciLocatari.fxml"));

            Scene scene = new Scene(root);

            stage = Main.getStage(); // mi prendo il primary stage definito nell'initRootLayout
            stage.setScene(scene); //ci setto la nuova scene da visualizzare senza aprire una nuova finestra
            stage.setTitle("Homepage");
            stage.close();//chiudo la finestra precedente

            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void nextPage(ActionEvent event) {

        AnchorPane root = null;
        try {
            pagina = pagina+1;
            i = i+4;
            visualizzati = 0;
            ControllerBachecaLocatore.setK(k);
            ControllerBachecaLocatore.setI(i);
            ControllerBachecaLocatore.setVisualizzati(visualizzati);
            ControllerBachecaLocatore.setPagina(pagina);


            root = FXMLLoader.load(getClass().getResource("/Boundary/HomepageUtente_annunciLocatori.fxml"));

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
    public void backPage(ActionEvent event) {

        AnchorPane root = null;
        try {

            k = k-visualizzati-4;
            pagina = pagina -1;
            i = i-4;
            visualizzati = 0;
            ControllerBachecaLocatore.setK(k);
            ControllerBachecaLocatore.setI(i);
            ControllerBachecaLocatore.setVisualizzati(visualizzati);
            ControllerBachecaLocatore.setPagina(pagina);



            root = FXMLLoader.load(getClass().getResource("/Boundary/HomepageUtente_annunciLocatori.fxml"));

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
    public void cercaSuMappa(ActionEvent event) {


    }

    @FXML
    public void cercaPerNome(ActionEvent event) {


    }

    @FXML
    public void inserisciAnnuncioLocatore(ActionEvent event) {

        try {
            k = 0;
            i = 0;
            visualizzati = 0;
            pagina = 0;

            ControllerBachecaLocatore.setK(k);
            ControllerBachecaLocatore.setI(i);
            ControllerBachecaLocatore.setVisualizzati(visualizzati);
            ControllerBachecaLocatore.setPagina(pagina);

            AnchorPane root = FXMLLoader.load(getClass().getResource("/Boundary/InserisciStanza.fxml"));

            Scene scene = new Scene(root);
            stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Inserisci una stanza");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @FXML
    public void inserisciAnnuncioLocatario(ActionEvent event) {

        try {

            k = 0;
            i = 0;
            visualizzati = 0;
            pagina = 0;

            ControllerBachecaLocatore.setK(k);
            ControllerBachecaLocatore.setI(i);
            ControllerBachecaLocatore.setVisualizzati(visualizzati);
            ControllerBachecaLocatore.setPagina(pagina);

            AnchorPane root = FXMLLoader.load(getClass().getResource("/Boundary/InserisciRichiesta.fxml"));

            Scene scene = new Scene(root);
            stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Pubblica una richiesta");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void showSingleAnnounce(ActionEvent event) {


        try {
            k = 0;
            i = 0;
            visualizzati = 0;
            pagina = 0;

            ControllerBachecaLocatore.setK(k);
            ControllerBachecaLocatore.setI(i);
            ControllerBachecaLocatore.setVisualizzati(visualizzati);
            ControllerBachecaLocatore.setPagina(pagina);
            AnchorPane root = FXMLLoader.load(getClass().getResource("/Boundary/Annuncio_locatore_utente.fxml"));

            Scene scene = new Scene(root);

            stage = Main.getStage();
            stage.setScene(scene);
            stage.setTitle("Annuncio locatore");
            stage.close();

            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @FXML
    public void showProfile(ActionEvent event) {


        try {
            k = 0;
            i = 0;
            visualizzati = 0;
            pagina = 0;

            ControllerBachecaLocatore.setK(k);
            ControllerBachecaLocatore.setI(i);
            ControllerBachecaLocatore.setVisualizzati(visualizzati);
            ControllerBachecaLocatore.setPagina(pagina);
            AnchorPane root = FXMLLoader.load(getClass().getResource("/Boundary/Profilo.fxml"));

            Scene scene = new Scene(root);

            stage = Main.getStage();
            stage.setScene(scene);
            stage.setTitle("Profilo utente");
            stage.close();

            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @FXML
    public void pubblicaAnnuncio(ActionEvent event) {

        try {
            k = 0;
            i = 0;
            visualizzati = 0;
            pagina = 0;

            ControllerBachecaLocatore.setK(k);
            ControllerBachecaLocatore.setI(i);
            ControllerBachecaLocatore.setVisualizzati(visualizzati);
            ControllerBachecaLocatore.setPagina(pagina);

            AnchorPane root = FXMLLoader.load(getClass().getResource("/Boundary/PubblicaAnnuncioAppartamento.fxml"));

            Scene scene = new Scene(root);

            publishStage = new Stage();
            publishStage.setScene(scene);
            publishStage.setTitle("Pubblica un annuncio");

            publishStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void showPreferiti(ActionEvent event) {
        try {
            k = 0;
            i = 0;
            visualizzati = 0;
            pagina = 0;

            ControllerBachecaLocatore.setK(k);
            ControllerBachecaLocatore.setI(i);
            ControllerBachecaLocatore.setVisualizzati(visualizzati);
            ControllerBachecaLocatore.setPagina(pagina);
            AnchorPane root = FXMLLoader.load(getClass().getResource("/Boundary/Preferiti.fxml"));

            Scene scene = new Scene(root);

            stage = Main.getStage();
            stage.setScene(scene);
            stage.setTitle("Preferiti");
            stage.close();

            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @FXML
    public boolean inserisciPreferiti(AnnuncioBean ab,UtenteBean ub){

        controllerBachecaLocatore = controllerBachecaLocatore.getInstance();
        System.out.println(ab.getAnnounceId());
        return controllerBachecaLocatore.inserisciAnnuncioPreferiti(ab,ub);

    }

}


