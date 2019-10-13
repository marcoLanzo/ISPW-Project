package Boundary;

import Bean.AnnuncioBean;
import Bean.UtenteBean;
import Controller.Controller;
import Controller.ControllerAnnuncio;
import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import Controller.*;
import Thread.*;

import java.io.IOException;
import java.util.ArrayList;

@SuppressWarnings("duplicates")
public class Storico_annunci {

    @FXML
    private AnchorPane homepageLocatarioPane;
    @FXML
    private Main main;
    @FXML
    protected static Stage stage;

    @FXML
    private Text textAnnounceName;
    @FXML
    private Text textAnnounceName2;
    @FXML
    private Text textAnnounceName3;
    @FXML
    private Text textAnnounceName4;
    @FXML
    private Text textAnnounceName5;
    @FXML
    private Text textAnnounceName6;
    @FXML
    private Text textAnnounceName7;
    @FXML
    private Text textAnnounceName8;
    @FXML
    private Text textAnnounceName9;
    @FXML
    private Text textcity;
    @FXML
    private Text textcity2;
    @FXML
    private Text textcity3;
    @FXML
    private Text textcity4;
    @FXML
    private Text textcity5;
    @FXML
    private Text textcity6;
    @FXML
    private Text textcity7;
    @FXML
    private Text textcity8;
    @FXML
    private Text textcity9;
    @FXML
    private Text textPrice;
    @FXML
    private Text textPrice2;
    @FXML
    private Text textPrice3;
    @FXML
    private Text textPrice4;
    @FXML
    private Text textPrice5;
    @FXML
    private Text textPrice6;
    @FXML
    private Text textPrice7;
    @FXML
    private Text textPrice8;
    @FXML
    private Text textPrice9;
    @FXML
    private ImageView imageApt1;
    @FXML
    private ImageView imageApt2;
    @FXML
    private ImageView imageApt3;
    @FXML
    private ImageView imageApt4;
    @FXML
    private ImageView imageApt5;
    @FXML
    private ImageView imageApt6;
    @FXML
    private ImageView imageApt7;
    @FXML
    private ImageView imageApt8;
    @FXML
    private ImageView imageApt9;
    @FXML
    private Button announceButton1;
    @FXML
    private Button announceButton2;
    @FXML
    private Button announceButton3;
    @FXML
    private Button announceButton4;
    @FXML
    private Button announceButton5;
    @FXML
    private Button announceButton6;
    @FXML
    private Button announceButton7;
    @FXML
    private Button announceButton8;
    @FXML
    private Button announceButton9;
    @FXML
    private Button backBtn;
    @FXML
    private Button nextBtn;


    private static UtenteBean credenziali;
    private String nickname;

    protected static Stage publishStage;

    private static int size;
    private static int k;
    private static int pagina;
    private static int visualizzati;
    private static int i;
    private ControllerStorico cS;
    private static AnnuncioBean annuncioBean;


    public void setMain(Main main) {
        this.main = main;
    }

    @SuppressWarnings("Duplicates")
    @FXML
    public void initialize() { /* Il metodo initialize setta le variabili desiderate prima di creare la finestra */
        credenziali = ControllerStorico.getUtentebean();
        nickname = credenziali.getUserid();
        ArrayList<AnnuncioBean> storicoAnnunci = new ArrayList<AnnuncioBean>();
        cS = ControllerStorico.getInstance();

        pagina = ControllerStorico.getPagina();
        k = ControllerStorico.getK();
        i = ControllerStorico.getI();
        visualizzati = ControllerStorico.getVisualizzati();

        if (credenziali.getType() == 1) {
            storicoAnnunci = cS.displayHistoricalRenter(nickname);
        } else if (credenziali.getType() == 2) {
            storicoAnnunci = cS.displayHistoricalTenant(nickname);
        } else if (credenziali.getType() == 3) {
            storicoAnnunci = cS.displayAllHistorical(nickname);

        }

        if (pagina == 0)
            backBtn.setVisible(false);
        else backBtn.setVisible(true);

        if (pagina > 0 && (k >= size || visualizzati < 9))
            nextBtn.setVisible(false);
        else nextBtn.setVisible(true);
        if (size < 9) {
            nextBtn.setVisible(false);
        }

        size = storicoAnnunci.size();

        if (k < 0)
            k = 0;

        if (k < size) {
            textAnnounceName.setText(storicoAnnunci.get(k).getNomeAnnuncio());
            textcity.setText(storicoAnnunci.get(k).getCity());
            textPrice.setText("€" + (storicoAnnunci.get(k).getPrezzoMax()));
            imageApt1.setImage(new Image("res/immobili/appartamento1.jpg"));
            visualizzati++;
            k++;
        }

        if (k < size) {
            textAnnounceName2.setText(storicoAnnunci.get(k).getNomeAnnuncio());
            textcity2.setText(storicoAnnunci.get(k).getCity());
            textPrice2.setText("€" + (storicoAnnunci.get(k).getPrezzoMax()));
            imageApt2.setImage(new Image("res/immobili/stanza1.jpg"));
            visualizzati++;
            k++;
        }
        if (k < size) {
            textAnnounceName3.setText(storicoAnnunci.get(k).getNomeAnnuncio());
            textcity3.setText(storicoAnnunci.get(k).getCity());
            textPrice3.setText("€" + (storicoAnnunci.get(k).getPrezzoMax()));
            imageApt3.setImage(new Image("res/immobili/stanza2.jpg"));
            visualizzati++;
            k++;
        }
        if (k < size) {
            textAnnounceName4.setText(storicoAnnunci.get(k).getNomeAnnuncio());
            textcity4.setText(storicoAnnunci.get(k).getCity());
            textPrice4.setText("€" + (storicoAnnunci.get(k).getPrezzoMax()));
            imageApt4.setImage(new Image("res/immobili/stanza3.jpg"));
            visualizzati++;
            k++;
        }
        if (k < size) {
            textAnnounceName5.setText(storicoAnnunci.get(k).getNomeAnnuncio());
            textcity5.setText(storicoAnnunci.get(k).getCity());
            textPrice5.setText("€" + (storicoAnnunci.get(k).getPrezzoMax()));
            imageApt5.setImage(new Image("res/immobili/stanza3.jpg"));
            visualizzati++;
            k++;
        }
        if (k < size) {
            textAnnounceName5.setText(storicoAnnunci.get(k).getNomeAnnuncio());
            textcity5.setText(storicoAnnunci.get(k).getCity());
            textPrice5.setText("€" + (storicoAnnunci.get(k).getPrezzoMax()));
            imageApt5.setImage(new Image("res/immobili/stanza3.jpg"));
            visualizzati++;
            k++;
        }
        if (k < size) {
            textAnnounceName6.setText(storicoAnnunci.get(k).getNomeAnnuncio());
            textcity6.setText(storicoAnnunci.get(k).getCity());
            textPrice6.setText("€" + (storicoAnnunci.get(k).getPrezzoMax()));
            imageApt6.setImage(new Image("res/immobili/stanza3.jpg"));
            visualizzati++;
            k++;
        }
        if (k < size) {
            textAnnounceName7.setText(storicoAnnunci.get(k).getNomeAnnuncio());
            textcity7.setText(storicoAnnunci.get(k).getCity());
            textPrice7.setText("€" + (storicoAnnunci.get(k).getPrezzoMax()));
            imageApt7.setImage(new Image("res/immobili/stanza3.jpg"));
            visualizzati++;
            k++;
        }
        if (k < size) {
            textAnnounceName8.setText(storicoAnnunci.get(k).getNomeAnnuncio());
            textcity8.setText(storicoAnnunci.get(k).getCity());
            textPrice8.setText("€" + (storicoAnnunci.get(k).getPrezzoMax()));
            imageApt8.setImage(new Image("res/immobili/stanza3.jpg"));
            visualizzati++;
            k++;
        }
        if (k < size) {
            textAnnounceName9.setText(storicoAnnunci.get(k).getNomeAnnuncio());
            textcity9.setText(storicoAnnunci.get(k).getCity());
            textPrice9.setText("€" + (storicoAnnunci.get(k).getPrezzoMax()));
            imageApt9.setImage(new Image("res/immobili/stanza3.jpg"));
            visualizzati++;
            k++;
        }
        ArrayList<AnnuncioBean> finalStoricoAnnunci = storicoAnnunci;
        System.out.println(finalStoricoAnnunci);
        System.out.println(finalStoricoAnnunci.size());
        System.out.println(i);
        if (i < size) {
            announceButton1.setOnAction(event -> {
                if (cS.checkannouncelocatore(finalStoricoAnnunci.get(i))) { // Inserimento tra i preferiti
                    annuncioBean = cS.annuncioselezionatolocatore(finalStoricoAnnunci.get(i));
                    ControllerPreferiti.setAnnuncioBean(annuncioBean);
                    showSingleAnnounceLocatore(event);

                } else { //Rimozione dai preferiti
                    annuncioBean = cS.annuncioSelezionatoLocatario(finalStoricoAnnunci.get(i));
                    ControllerPreferiti.setAnnuncioBean(annuncioBean);
                    showSingleAnnounceLocatario(event);

                }
            });
        }
        if (i+1 < size) {
            announceButton2.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (cS.checkannouncelocatore(finalStoricoAnnunci.get(i + 1))) { // Inserimento tra i preferiti
                        annuncioBean = cS.annuncioselezionatolocatore(finalStoricoAnnunci.get(i + 1));
                        ControllerStorico.setAnnuncioBean(annuncioBean);
                        showSingleAnnounceLocatore(event);

                    } else { //Rimozione dai preferiti
                        annuncioBean = cS.annuncioSelezionatoLocatario(finalStoricoAnnunci.get(i + 1));
                        ControllerStorico.setAnnuncioBean(annuncioBean);
                        showSingleAnnounceLocatario(event);

                    }
                }
            });
        }
        if (i+2 < size) {
            announceButton3.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (cS.checkannouncelocatore(finalStoricoAnnunci.get(i + 2))) { // Inserimento tra i preferiti
                        annuncioBean = cS.annuncioselezionatolocatore(finalStoricoAnnunci.get(i + 2));
                        ControllerStorico.setAnnuncioBean(annuncioBean);
                        showSingleAnnounceLocatore(event);
                    } else { //Rimozione dai preferiti
                        annuncioBean = cS.annuncioSelezionatoLocatario(finalStoricoAnnunci.get(i + 2));
                        ControllerStorico.setAnnuncioBean(annuncioBean);
                        showSingleAnnounceLocatario(event);


                    }
                }
            });
        }
        if (i+3 < size) {
            announceButton4.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (cS.checkannouncelocatore(finalStoricoAnnunci.get(i + 3))) { // Inserimento tra i preferiti
                        annuncioBean = cS.annuncioselezionatolocatore(finalStoricoAnnunci.get(i + 3));
                        ControllerStorico.setAnnuncioBean(annuncioBean);
                        showSingleAnnounceLocatore(event);

                    } else { //Rimozione dai preferiti
                        annuncioBean = cS.annuncioSelezionatoLocatario(finalStoricoAnnunci.get(i + 3));
                        ControllerStorico.setAnnuncioBean(annuncioBean);
                        showSingleAnnounceLocatario(event);

                    }
                }
            });
        }
        if (i+4 < size) {
            announceButton5.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (cS.checkannouncelocatore(finalStoricoAnnunci.get(i + 4))) { // Inserimento tra i preferiti
                        annuncioBean = cS.annuncioselezionatolocatore(finalStoricoAnnunci.get(i + 4));
                        ControllerStorico.setAnnuncioBean(annuncioBean);
                        showSingleAnnounceLocatore(event);

                    } else { //Rimozione dai preferiti
                        annuncioBean = cS.annuncioSelezionatoLocatario(finalStoricoAnnunci.get(i + 4));
                        ControllerStorico.setAnnuncioBean(annuncioBean);
                        showSingleAnnounceLocatario(event);

                    }
                }
            });
        }
        if (i+5 < size) {

            announceButton6.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (cS.checkannouncelocatore(finalStoricoAnnunci.get(i + 5))) { // Inserimento tra i preferiti
                        annuncioBean = cS.annuncioselezionatolocatore(finalStoricoAnnunci.get(i + 5));
                        ControllerStorico.setAnnuncioBean(annuncioBean);
                        showSingleAnnounceLocatore(event);

                    } else { //Rimozione dai preferiti
                        annuncioBean = cS.annuncioSelezionatoLocatario(finalStoricoAnnunci.get(i + 5));
                        ControllerStorico.setAnnuncioBean(annuncioBean);
                        showSingleAnnounceLocatario(event);

                    }
                }
            });
        }
        if (i+6 < size) {

            announceButton7.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (cS.checkannouncelocatore(finalStoricoAnnunci.get(i + 6))) { // Inserimento tra i preferiti
                        annuncioBean = cS.annuncioselezionatolocatore(finalStoricoAnnunci.get(i + 6));
                        ControllerStorico.setAnnuncioBean(annuncioBean);
                        showSingleAnnounceLocatore(event);
                    } else { //Rimozione dai preferiti
                        annuncioBean = cS.annuncioSelezionatoLocatario(finalStoricoAnnunci.get(i + 6));
                        ControllerStorico.setAnnuncioBean(annuncioBean);
                        showSingleAnnounceLocatario(event);

                    }
                }
            });
        }
        if (i+7  < size) {
            announceButton8.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (cS.checkannouncelocatore(finalStoricoAnnunci.get(i + 7))) { // Inserimento tra i preferiti
                        annuncioBean = cS.annuncioselezionatolocatore(finalStoricoAnnunci.get(i + 7));
                        ControllerStorico.setAnnuncioBean(annuncioBean);
                        showSingleAnnounceLocatore(event);

                    } else { //Rimozione dai preferiti
                        annuncioBean = cS.annuncioSelezionatoLocatario(finalStoricoAnnunci.get(i + 7));
                        ControllerStorico.setAnnuncioBean(annuncioBean);
                        showSingleAnnounceLocatario(event);

                    }
                }
            });
        }
        if (i+8 < size) {

            announceButton9.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (cS.checkannouncelocatore(finalStoricoAnnunci.get(i + 8))) { // Inserimento tra i preferiti
                        annuncioBean = cS.annuncioselezionatolocatore(finalStoricoAnnunci.get(i + 8));
                        ControllerStorico.setAnnuncioBean(annuncioBean);
                        showSingleAnnounceLocatore(event);

                    } else { //Rimozione dai preferiti
                        annuncioBean = cS.annuncioSelezionatoLocatario(finalStoricoAnnunci.get(i + 8));
                        ControllerStorico.setAnnuncioBean(annuncioBean);
                        showSingleAnnounceLocatario(event);

                    }
                }
            });
        }
    }

    @SuppressWarnings("Duplicates")
    @FXML
    public void showAnnunciLocatori(ActionEvent event) {

        try {
            ControllerBachecaLocatore.setK(0);
            ControllerBachecaLocatore.setI(0);
            ControllerBachecaLocatore.setVisualizzati(0);
            ControllerBachecaLocatore.setPagina(0);
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/Boundary/HomepageUtente_annunciLocatori.fxml"));

            Scene scene = new Scene(root);

            stage = Main.getStage();
            stage.setScene(scene);
            stage.setTitle("Profilo utente");
            this.stage.close();

            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void showAnnunciLocatari(ActionEvent event) {

        try {
            ControllerBachecaLocatore.setK(0);
            ControllerBachecaLocatore.setI(0);
            ControllerBachecaLocatore.setVisualizzati(0);
            ControllerBachecaLocatore.setPagina(0);

            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/Boundary/HomepageUtente_annunciLocatari.fxml"));

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
    public void nextPage(ActionEvent event) {

        AnchorPane root = null;
        try {

            pagina++;
            visualizzati = 0;
            i = i + 9;

            ControllerBachecaLocatore.setK(k + 9);
            ControllerBachecaLocatore.setVisualizzati(0);
            ControllerBachecaLocatore.setPagina(pagina);
            ControllerBachecaLocatore.setI(i);

            root = (AnchorPane) FXMLLoader.load(getClass().getResource("/Boundary/HomepageUtente_annunciLocatori.fxml"));

            Scene scene = new Scene(root);

            stage = new Stage();
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

            k = k - visualizzati - 9;
            pagina--;
            visualizzati = 0;
            i = i - 9;

            ControllerBachecaLocatore.setK(k);
            ControllerBachecaLocatore.setVisualizzati(0);
            ControllerBachecaLocatore.setPagina(pagina);
            ControllerBachecaLocatore.setI(i);

            root = (AnchorPane) FXMLLoader.load(getClass().getResource("/Boundary/HomepageUtente_annunciLocatori.fxml"));

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
    public void cercaSuMappa(ActionEvent event) {


    }

    @FXML
    public void cercaPerNome(ActionEvent event) {


    }

    @FXML
    public void inserisciAnnuncioLocatore(ActionEvent event) {

        try {
            ControllerBachecaLocatore.setK(0);
            ControllerBachecaLocatore.setI(0);
            ControllerBachecaLocatore.setVisualizzati(0);
            ControllerBachecaLocatore.setPagina(0);

            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/Boundary/InserisciStanza.fxml"));

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
            ControllerBachecaLocatore.setK(0);
            ControllerBachecaLocatore.setI(0);
            ControllerBachecaLocatore.setVisualizzati(0);
            ControllerBachecaLocatore.setPagina(0);

            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/Boundary/InserisciRichiesta.fxml"));

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
            ControllerBachecaLocatore.setK(0);
            ControllerBachecaLocatore.setI(0);
            ControllerBachecaLocatore.setVisualizzati(0);
            ControllerBachecaLocatore.setPagina(0);


            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/Boundary/Annuncio_locatore_utente.fxml"));

            Scene scene = new Scene(root);

            stage = Main.getStage();
            stage.setScene(scene);
            stage.setTitle("Annuncio locatore");
            this.stage.close();

            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @FXML
    public void showSingleAnnounceLocatore(javafx.event.ActionEvent event) {


        try {
            ControllerBachecaLocatore.setK(0);
            ControllerBachecaLocatore.setI(0);
            ControllerBachecaLocatore.setVisualizzati(0);
            ControllerBachecaLocatore.setPagina(0);

            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/Boundary/Annuncio_locatore_utente.fxml"));

            Scene scene = new Scene(root);

            stage = Main.getStage();
            stage.setScene(scene);
            stage.setTitle("Annuncio locatario");
            stage.close();

            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void pubblicaAnnuncio(ActionEvent event) {

        try {
            ControllerBachecaLocatore.setK(0);
            ControllerBachecaLocatore.setI(0);
            ControllerBachecaLocatore.setVisualizzati(0);
            ControllerBachecaLocatore.setPagina(0);

            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/Boundary/PubblicaAnnuncioAppartamento.fxml"));

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
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/Boundary/Preferiti.fxml"));

            Scene scene = new Scene(root);

            stage = Main.getStage();
            stage.setScene(scene);
            stage.setTitle("Profilo utente");
            this.stage.close();

            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void showSingleAnnounceLocatario(javafx.event.ActionEvent event) {


        try {
            ControllerBachecaLocatore.setK(0);
            ControllerBachecaLocatore.setI(0);
            ControllerBachecaLocatore.setVisualizzati(0);
            ControllerBachecaLocatore.setPagina(0);

            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/Boundary/Annuncio_locatario_utente.fxml"));

            Scene scene = new Scene(root);

            stage = Main.getStage();
            stage.setScene(scene);
            stage.setTitle("Annuncio locatario");
            stage.close();

            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}