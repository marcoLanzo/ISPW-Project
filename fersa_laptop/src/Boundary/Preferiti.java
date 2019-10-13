package Boundary;

import Bean.AnnuncioBean;
import Bean.UtenteBean;
import Controller.ControllerAnnunciAttivi;
import Controller.ControllerAnnuncio;
import Controller.ControllerBachecaLocatore;
import Controller.ControllerPreferiti;
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

import java.io.IOException;
import java.util.ArrayList;

public class Preferiti {


    @FXML
    protected Text textUtente;
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
    private Text textNickname;
    @FXML
    private Text textNickname2;
    @FXML
    private Text textNickname3;
    @FXML
    private Text textNickname4;
    @FXML
    private Text textNickname5;
    @FXML
    private Text textNickname6;
    @FXML
    private Text textNickname7;
    @FXML
    private Text textNickname8;
    @FXML
    private Text textNickname9;



    @FXML
    private Button backBtn;
    @FXML
    private Button nextBtn;

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
    protected static Stage stage;


    protected Main main = new Main();



    protected static Stage publishStage;

    protected static int size;
    protected static int k = 0;
    protected static int i = 0;
    protected static int pagina;
    protected static int visualizzati;

    private AnnuncioBean annuncioBean;


    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    protected ArrayList<AnnuncioBean> annunciPreferiti;

    @SuppressWarnings("Duplicates")
    @FXML
    public void initialize() {

        UtenteBean credenziali = ControllerAnnuncio.getUtentebean();
        ControllerPreferiti cp = ControllerPreferiti.getInstance();
        if (credenziali.getType() == 1 || credenziali.getType() == 0)
            annunciPreferiti = cp.displayRenterFavoriteAnnounces(credenziali.getUserid());
        else if (credenziali.getType() == 2)
            annunciPreferiti = cp.displayTenantFavoriteAnnounces(credenziali.getUserid());
        else if (credenziali.getType() == 3){
            annunciPreferiti = cp.displayRenterFavoriteAnnounces(credenziali.getUserid());
            annunciPreferiti.addAll(cp.displayTenantFavoriteAnnounces(credenziali.getUserid()));
        }

        pagina = ControllerAnnunciAttivi.getPagina();
        k = ControllerAnnunciAttivi.getK();
        i = ControllerAnnunciAttivi.getI();
        visualizzati = ControllerAnnunciAttivi.getVisualizzati();

        if (pagina == 0)
            backBtn.setVisible(false);
        else backBtn.setVisible(true);

        if (pagina > 0 && (k >= size || visualizzati < 4))
            nextBtn.setVisible(false);
        else nextBtn.setVisible(true);


        size = annunciPreferiti.size();

        if (k < 0)
            k = 0;

        if (k < size) {
            textAnnounceName.setText(annunciPreferiti.get(k).getNomeAnnuncio());
            textcity.setText(annunciPreferiti.get(k).getCity());
            textPrice.setText("€" + (annunciPreferiti.get(k).getPrezzoMax()));
            textNickname.setText(annunciPreferiti.get(k).getUser().getUserid());
            imageApt1.setImage(new Image("res/immobili/appartamento1.jpg"));
            visualizzati++;
            k++;
        }

        if (k < size) {
            textAnnounceName2.setText(annunciPreferiti.get(k).getNomeAnnuncio());
            textcity2.setText(annunciPreferiti.get(k).getCity());
            textPrice2.setText("€" + (annunciPreferiti.get(k).getPrezzoMax()));
            textNickname2.setText(annunciPreferiti.get(k).getUser().getUserid());
            imageApt2.setImage(new Image("res/immobili/stanza1.jpg"));
            visualizzati++;
            k++;
        }
        if (k < size) {
            textAnnounceName3.setText(annunciPreferiti.get(k).getNomeAnnuncio());
            textcity3.setText(annunciPreferiti.get(k).getCity());
            textPrice3.setText("€" + (annunciPreferiti.get(k).getPrezzoMax()));
            textNickname3.setText(annunciPreferiti.get(k).getUser().getUserid());
            imageApt3.setImage(new Image("res/immobili/stanza2.jpg"));
            visualizzati++;
            k++;
        }
        if (k < size) {
            textAnnounceName4.setText(annunciPreferiti.get(k).getNomeAnnuncio());
            textcity4.setText(annunciPreferiti.get(k).getCity());
            textPrice4.setText("€" + (annunciPreferiti.get(k).getPrezzoMax()));
            textNickname4.setText(annunciPreferiti.get(k).getUser().getUserid());
            imageApt4.setImage(new Image("res/immobili/stanza3.jpg"));
            visualizzati++;
            k++;
        }
        if (k < size) {
            textAnnounceName5.setText(annunciPreferiti.get(k).getNomeAnnuncio());
            textcity5.setText(annunciPreferiti.get(k).getCity());
            textPrice5.setText("€" + (annunciPreferiti.get(k).getPrezzoMax()));
            textNickname5.setText(annunciPreferiti.get(k).getUser().getUserid());
            imageApt5.setImage(new Image("res/immobili/stanza3.jpg"));
            visualizzati++;
            k++;
        }

        if (k < size) {
            textAnnounceName6.setText(annunciPreferiti.get(k).getNomeAnnuncio());
            textcity6.setText(annunciPreferiti.get(k).getCity());
            textPrice6.setText("€" + (annunciPreferiti.get(k).getPrezzoMax()));
            textNickname6.setText(annunciPreferiti.get(k).getUser().getUserid());
            imageApt6.setImage(new Image("res/immobili/stanza3.jpg"));
            visualizzati++;
            k++;
        }
        if (k < size) {
            textAnnounceName7.setText(annunciPreferiti.get(k).getNomeAnnuncio());
            textcity7.setText(annunciPreferiti.get(k).getCity());
            textPrice7.setText("€" + (annunciPreferiti.get(k).getPrezzoMax()));
            textNickname7.setText(annunciPreferiti.get(k).getUser().getUserid());
            imageApt7.setImage(new Image("res/immobili/stanza3.jpg"));
            visualizzati++;
            k++;
        }
        if (k < size) {
            textAnnounceName8.setText(annunciPreferiti.get(k).getNomeAnnuncio());
            textcity8.setText(annunciPreferiti.get(k).getCity());
            textPrice8.setText("€" + (annunciPreferiti.get(k).getPrezzoMax()));
            textNickname8.setText(annunciPreferiti.get(k).getUser().getUserid());
            imageApt8.setImage(new Image("res/immobili/stanza3.jpg"));
            visualizzati++;
            k++;
        }
        if (k < size) {
            textAnnounceName9.setText(annunciPreferiti.get(k).getNomeAnnuncio());
            textcity9.setText(annunciPreferiti.get(k).getCity());
            textPrice9.setText("€" + (annunciPreferiti.get(k).getPrezzoMax()));
            textNickname9.setText(annunciPreferiti.get(k).getUser().getUserid());
            imageApt9.setImage(new Image("res/immobili/stanza3.jpg"));
            visualizzati++;
            k++;
        }

        System.out.println(annunciPreferiti);
        if (k-9<size) {
            announceButton1.setOnAction(event -> {
                if (cp.checkannouncelocatore(annunciPreferiti.get(i))) { // Inserimento tra i preferiti
                    annuncioBean = cp.annuncioselezionatolocatore(annunciPreferiti.get(i));
                    ControllerPreferiti.setAnnuncioBean(annuncioBean);
                    showSingleAnnounceLocatore(event);

                } else { //Rimozione dai preferiti
                    annuncioBean = cp.annuncioSelezionatoLocatario(annunciPreferiti.get(i));
                    ControllerPreferiti.setAnnuncioBean(annuncioBean);
                    showSingleAnnounceLocatario(event);

                }
            });
        }
        if (k-8<size) {
            announceButton2.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (cp.checkannouncelocatore(annunciPreferiti.get(i+1))) { // Inserimento tra i preferiti
                        annuncioBean = cp.annuncioselezionatolocatore(annunciPreferiti.get(i+1));
                        ControllerAnnunciAttivi.setAnnuncioBean(annuncioBean);
                        showSingleAnnounceLocatore(event);

                    } else { //Rimozione dai preferiti
                        annuncioBean = cp.annuncioSelezionatoLocatario(annunciPreferiti.get(i+1));
                        ControllerAnnunciAttivi.setAnnuncioBean(annuncioBean);
                        showSingleAnnounceLocatario(event);

                    }
                }
            });
        }
        if (k-7 <size) {
            announceButton3.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (cp.checkannouncelocatore(annunciPreferiti.get(i+2))) { // Inserimento tra i preferiti
                        annuncioBean = cp.annuncioselezionatolocatore(annunciPreferiti.get(i+2));
                        ControllerAnnunciAttivi.setAnnuncioBean(annuncioBean);
                        showSingleAnnounceLocatore(event);
                    } else { //Rimozione dai preferiti
                        annuncioBean = cp.annuncioSelezionatoLocatario(annunciPreferiti.get(i+2));
                        ControllerAnnunciAttivi.setAnnuncioBean(annuncioBean);
                        showSingleAnnounceLocatario(event);


                    }
                }
            });
        }
        if (k-6 < size) {
            announceButton4.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (cp.checkannouncelocatore(annunciPreferiti.get(i+3))) { // Inserimento tra i preferiti
                        annuncioBean = cp.annuncioselezionatolocatore(annunciPreferiti.get(i+3));
                        ControllerAnnunciAttivi.setAnnuncioBean(annuncioBean);
                        showSingleAnnounceLocatore(event);

                    } else { //Rimozione dai preferiti
                        annuncioBean = cp.annuncioSelezionatoLocatario(annunciPreferiti.get(i+3));
                        ControllerAnnunciAttivi.setAnnuncioBean(annuncioBean);
                        showSingleAnnounceLocatario(event);

                    }
                }
            });
        }
        if (k-5 <size) {
            announceButton5.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (cp.checkannouncelocatore(annunciPreferiti.get(i+4))) { // Inserimento tra i preferiti
                        annuncioBean = cp.annuncioselezionatolocatore(annunciPreferiti.get(i+4));
                        ControllerAnnunciAttivi.setAnnuncioBean(annuncioBean);
                        showSingleAnnounceLocatore(event);

                    } else { //Rimozione dai preferiti
                        annuncioBean = cp.annuncioSelezionatoLocatario(annunciPreferiti.get(i+4));
                        ControllerAnnunciAttivi.setAnnuncioBean(annuncioBean);
                        showSingleAnnounceLocatario(event);

                    }
                }
            });
        }
        if (k-4 <size) {

            announceButton6.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (cp.checkannouncelocatore(annunciPreferiti.get(i+5))) { // Inserimento tra i preferiti
                        annuncioBean = cp.annuncioselezionatolocatore(annunciPreferiti.get(i+5));
                        ControllerAnnunciAttivi.setAnnuncioBean(annuncioBean);
                        showSingleAnnounceLocatore(event);

                    } else { //Rimozione dai preferiti
                        annuncioBean = cp.annuncioSelezionatoLocatario(annunciPreferiti.get(i+5));
                        ControllerAnnunciAttivi.setAnnuncioBean(annuncioBean);
                        showSingleAnnounceLocatario(event);

                    }
                }
            });
        }
        if (k-3 < size) {

            announceButton7.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (cp.checkannouncelocatore(annunciPreferiti.get(i + 6))) { // Inserimento tra i preferiti
                        annuncioBean = cp.annuncioselezionatolocatore(annunciPreferiti.get(i+6));
                        ControllerAnnunciAttivi.setAnnuncioBean(annuncioBean);
                        showSingleAnnounceLocatore(event);
                    } else { //Rimozione dai preferiti
                        annuncioBean = cp.annuncioSelezionatoLocatario(annunciPreferiti.get(i+6));
                        ControllerAnnunciAttivi.setAnnuncioBean(annuncioBean);
                        showSingleAnnounceLocatario(event);

                    }
                }
            });
        }
        if (k-2 < size) {
            announceButton8.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (cp.checkannouncelocatore(annunciPreferiti.get(i + 7))) { // Inserimento tra i preferiti
                        annuncioBean = cp.annuncioselezionatolocatore(annunciPreferiti.get(i+7));
                        ControllerAnnunciAttivi.setAnnuncioBean(annuncioBean);
                        showSingleAnnounceLocatore(event);

                    } else { //Rimozione dai preferiti
                        annuncioBean = cp.annuncioSelezionatoLocatario(annunciPreferiti.get(i+7));
                        ControllerAnnunciAttivi.setAnnuncioBean(annuncioBean);
                        showSingleAnnounceLocatario(event);

                    }
                }
            });
        }
        if (k-1 < size) {

            announceButton9.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (cp.checkannouncelocatore(annunciPreferiti.get(i + 8))) { // Inserimento tra i preferiti
                        annuncioBean = cp.annuncioselezionatolocatore(annunciPreferiti.get(i+8));
                        ControllerAnnunciAttivi.setAnnuncioBean(annuncioBean);
                        showSingleAnnounceLocatore(event);

                    } else { //Rimozione dai preferiti
                        annuncioBean = cp.annuncioSelezionatoLocatario(annunciPreferiti.get(i+8));
                        ControllerAnnunciAttivi.setAnnuncioBean(annuncioBean);
                        showSingleAnnounceLocatario(event);

                    }
                }
            });
        }
    }

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
            i= i+9;

            ControllerBachecaLocatore.setK(k+9);
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
            i = i-9;

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
    public void showSingleAnnounceLocatore(javafx.event.ActionEvent event){


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
            stage.close();

            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void showSingleAnnounceLocatario(javafx.event.ActionEvent event){


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


    public boolean inserisciPreferiti(AnnuncioBean ab, UtenteBean ub) {

        ControllerAnnuncio cA = ControllerAnnuncio.getInstance();
        System.out.println(ab.getAnnounceId());
        return cA.inserisciAnnuncioPreferiti(ab, ub);

    }


}
