package Boundary;

import Bean.AnnuncioBean;
import Bean.UtenteBean;
import Controller.Controller;
import Controller.ControllerBachecaLocatario;
import Controller.ControllerBachecaLocatore;
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

import static Boundary.Annuncio_locatario.annuncioBean;

public class HomepageLocatario {

    @FXML
    private Text textUtente;
    @FXML
    private AnchorPane homepageLocatarioPane;
    @FXML
    protected static Stage stage;
    protected static Stage publishStage;
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
    @FXML
    private Button backBtn;
    @FXML
    private Button nextBtn;
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

    private static int size;
    private static int k ;
    private static int pagina;
    private static int visualizzati;
    private static int i ;
    private ControllerBachecaLocatario controllerBachecaLocatario;
    private UtenteBean utenteBean;
    private static int z;

    public Stage getStage() {return this.stage;}

    @FXML
    public void initialize() {

        utenteBean = ControllerBachecaLocatario.getUtentebean();
        k = ControllerBachecaLocatore.getK();
        i = ControllerBachecaLocatore.getI();
        visualizzati = Controller.getVisualizzati();
        pagina = ControllerBachecaLocatore.getPagina();
        /* Finché avrò annunci da visualizzare, setterò le relative Text ed immagini */

        textUtente.setText("Benvenuto " + utenteBean.getUserid());
        controllerBachecaLocatario= ControllerBachecaLocatario.getInstance();
        ArrayList<AnnuncioBean> ab = controllerBachecaLocatario.displayTenantShowcase();

        if (pagina > 0)
            backBtn.setVisible(true);
        else backBtn.setVisible(false);

        if (visualizzati == 0)
            nextBtn.setVisible(false);
        else nextBtn.setVisible(true);


        if (pagina == 0)
            backBtn.setVisible(false);
        else backBtn.setVisible(true);
        if (size < 4){
            nextBtn.setVisible(false);
        }

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


        if (k-4 < size) {
            buttonHeart1.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (inserisciPreferiti(ab.get(i), utenteBean)) { // Inserimento tra i preferiti
                        imageHeart1.setImage(new Image("res/full_heart.png"));
                    }
                    else{  //Rimozione dai preferiti
                        imageHeart1.setImage(new Image("res/heart.png"));

                    }
                }
            });
            announceButton1.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    annuncioBean = controllerBachecaLocatario.annuncioSelezionatoLocatario(ab.get(i));
                    ControllerBachecaLocatore.setAnnuncioBean(annuncioBean);
                    showSingleAnnounce(event);

                }
            });

        }
        if (k-3 < size) {

            buttonHeart2.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (inserisciPreferiti(ab.get(i + 1), utenteBean)) {
                        imageHeart2.setImage(new Image("res/full_heart.png"));

                    } else {  //Rimozione dai preferiti
                        imageHeart2.setImage(new Image("res/heart.png"));

                    }
                }
            });
            announceButton2.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    annuncioBean = controllerBachecaLocatario.annuncioSelezionatoLocatario(ab.get(i+1));
                    ControllerBachecaLocatore.setAnnuncioBean(annuncioBean);
                    showSingleAnnounce(event);

                }
            });
        }
        if (k-2<size ) {
            buttonHeart3.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (inserisciPreferiti(ab.get(i + 2), utenteBean)) {
                        imageHeart3.setImage(new Image("res/full_heart.png"));

                    }else{//Rimozione dai preferiti
                        imageHeart3.setImage(new Image("res/heart.png"));
                    }
                }
            });
            announceButton3.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    annuncioBean = controllerBachecaLocatario.annuncioSelezionatoLocatario(ab.get(i+3));
                    ControllerBachecaLocatore.setAnnuncioBean(annuncioBean);
                    showSingleAnnounce(event);

                }
            });
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
                    annuncioBean = controllerBachecaLocatario.annuncioSelezionatoLocatario(ab.get(i+3));
                    ControllerBachecaLocatore.setAnnuncioBean(annuncioBean);
                    showSingleAnnounce(event);

                }
            });
        }

        for (z = 0;z<ab.size();z++) {
            switch (z) {
                case 0:
                    if (controllerBachecaLocatario.checkpreferiti(ab.get(z).getAnnounceId(), utenteBean.getUserid())) {
                        imageHeart1.setImage(new Image("res/full_heart.png"));
                        break;
                    }
                case 1:
                    if (controllerBachecaLocatario.checkpreferiti(ab.get(z).getAnnounceId(), utenteBean.getUserid())) {
                        imageHeart2.setImage(new Image("res/full_heart.png"));
                        break;
                    }
                case 2:
                    if (controllerBachecaLocatario.checkpreferiti(ab.get(z).getAnnounceId(), utenteBean.getUserid())) {
                        imageHeart3.setImage(new Image("res/full_heart.png"));
                        break;
                    }
                case 3:
                    if (controllerBachecaLocatario.checkpreferiti(ab.get(z).getAnnounceId(), utenteBean.getUserid())) {
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
            ControllerBachecaLocatario.setPagina(0);
            ControllerBachecaLocatario.setK(0);
            ControllerBachecaLocatario.setVisualizzati(0);
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/Boundary/HomepageUtente_annunciLocatori.fxml"));
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

            ControllerBachecaLocatario.setPagina(0);
            ControllerBachecaLocatario.setK(0);
            ControllerBachecaLocatario.setVisualizzati(0);
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/Boundary/HomepageUtente_annunciLocatari.fxml"));

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
    public void nextPage(ActionEvent event) {

        AnchorPane root = null;
        try {

            pagina = pagina++;
            visualizzati = 0;
            k=k+4;
            ControllerBachecaLocatario.setPagina(pagina);
            ControllerBachecaLocatario.setK(k+4);
            ControllerBachecaLocatario.setVisualizzati(0);

            root = (AnchorPane) FXMLLoader.load(getClass().getResource("/Boundary/HomepageUtente_annunciLocatari.fxml"));

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
            ControllerBachecaLocatario.setPagina(pagina);
            ControllerBachecaLocatario.setK(k);
            ControllerBachecaLocatario.setVisualizzati(0);


            root = (AnchorPane) FXMLLoader.load(getClass().getResource("/Boundary/HomepageUtente_annunciLocatari.fxml"));

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
    public void cercaSuMappa(ActionEvent event){


    }

    @FXML
    public void cercaPerNome(ActionEvent event){


    }

    @FXML
    public void showPreferiti(ActionEvent event) {
        try {
            ControllerBachecaLocatore.setK(0);
            ControllerBachecaLocatore.setI(0);
            ControllerBachecaLocatore.setVisualizzati(0);
            ControllerBachecaLocatore.setPagina(0);

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
    public void inserisciAnnuncioLocatore(ActionEvent event){

        try {
            ControllerBachecaLocatario.setPagina(0);
            ControllerBachecaLocatario.setK(0);
            ControllerBachecaLocatario.setVisualizzati(0);
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
    public void inserisciAnnuncioLocatario(ActionEvent event){

        try {
            ControllerBachecaLocatario.setPagina(0);
            ControllerBachecaLocatario.setK(0);
            ControllerBachecaLocatario.setVisualizzati(0);
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
    public void showSingleAnnounce(ActionEvent event){


        try {
            ControllerBachecaLocatario.setPagina(0);
            ControllerBachecaLocatario.setK(0);
            ControllerBachecaLocatario.setVisualizzati(0);
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/Boundary/Annuncio_locatario_utente.fxml"));

            Scene scene = new Scene(root);

            stage = Main.getStage();
            stage.setScene(scene);
            stage.setTitle("Annuncio locatario");
            stage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void showProfile(ActionEvent event){


        try {
            ControllerBachecaLocatario.setPagina(0);
            ControllerBachecaLocatario.setK(0);
            ControllerBachecaLocatario.setVisualizzati(0);
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/Boundary/Profilo.fxml"));

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
    public void pubblicaAnnuncio(ActionEvent event){

        try {
            ControllerBachecaLocatario.setPagina(0);
            ControllerBachecaLocatario.setK(0);
            ControllerBachecaLocatario.setVisualizzati(0);
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
    public boolean inserisciPreferiti(AnnuncioBean ab,UtenteBean ub){

        controllerBachecaLocatario = controllerBachecaLocatario.getInstance();
        System.out.println(ab.getAnnounceId());
        return controllerBachecaLocatario.inserisciAnnuncioPreferiti(ab,ub);

    }
}
