package Boundary;

import Bean.UtenteBean;
import Controller.ControllerProfilo;
import Controller.MainController;
import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class Profilo {

    protected  static Stage stage;
    @FXML
    private AnchorPane profilePane;
    @FXML
    private ImageView imgStar1;
    @FXML
    private ImageView imgStar2;
    @FXML
    private ImageView imgStar3;
    @FXML
    private ImageView imgStar4;
    @FXML
    private ImageView imgStar5;
    @FXML
    private ImageView imgUser;

    private UtenteBean ub;
    private  double evaluation;

    public void initialize() {

        ub = MainController.getUtentebean();
        evaluation = getAvgScore(ub);
        int rating = 0;


        if (isBetween(evaluation, 0, 1.9)) {
            rating = 1;
            imgStar1.setImage(new Image("res/full_star.png"));
        }
        else if (isBetween(evaluation, 2, 3.9)) {
            rating = 2;
            imgStar1.setImage(new Image("res/full_star.png"));
            imgStar2.setImage(new Image("res/full_star.png"));
        }
        else if (isBetween(evaluation, 4, 5.9)) {
            rating = 3;
            imgStar1.setImage(new Image("res/full_star.png"));
            imgStar2.setImage(new Image("res/full_star.png"));
            imgStar3.setImage(new Image("res/full_star.png"));
        }
        else if (isBetween(evaluation, 6, 7.9)) {
            rating = 4;
            imgStar1.setImage(new Image("res/full_star.png"));
            imgStar2.setImage(new Image("res/full_star.png"));
            imgStar3.setImage(new Image("res/full_star.png"));
            imgStar4.setImage(new Image("res/full_star.png"));
        }
        else if (isBetween(evaluation, 8, 10)) {
            rating = 5;
            imgStar1.setImage(new Image("res/full_star.png"));
            imgStar2.setImage(new Image("res/full_star.png"));
            imgStar3.setImage(new Image("res/full_star.png"));
            imgStar4.setImage(new Image("res/full_star.png"));
            imgStar5.setImage(new Image("res/full_star.png"));
        }

        if (rating < 3)
            imgUser.setImage(new Image("res/utente_negativo.png"));
        else imgUser.setImage(new Image("res/utente_positivo.png"));

    }

    public static boolean isBetween(double x, int lower, double upper) {
        return lower <= x && x <= upper;
    }

    @FXML
    public void displayRenterShowcase(ActionEvent event) {

        try {
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/Boundary/HomepageUtente_annunciLocatori.fxml"));

            Scene scene = new Scene(root);

            stage = Main.getStage();
            stage.setScene(scene);
            stage.setTitle("Homepage");

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
    public void inserisciAnnuncioLocatore(ActionEvent event){

        try {
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/Boundary/InserisciStanza.fxml"));

            Scene scene = new Scene(root);
            stage = Main.getStage();
            stage.setScene(scene);
            stage.setTitle("Inserisci una stanza");
            this.stage.close();

            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @FXML
    public void inserisciAnnuncioLocatario(ActionEvent event) {

        try {
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/Boundary/InserisciRichiesta.fxml"));

            Scene scene = new Scene(root);
            stage = Main.getStage();
            stage.setScene(scene);
            stage.setTitle("Inserisci una richiesta");
            this.stage.close();

            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    @FXML
    public void showAppartamenti(ActionEvent event){

        try {

            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/Boundary/Storico_Appartamenti.fxml"));

            Scene scene = new Scene(root);
            stage = Main.getStage();
            stage.setScene(scene);
            stage.setTitle("Storico Locatore");
            this.stage.close();

            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void showAnnunciAttivi(ActionEvent event){
        try {

            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/Boundary/Annunci_attivi.fxml"));

            Scene scene = new Scene(root);
            stage = Main.getStage();
            stage.setScene(scene);
            stage.setTitle("Annunci attivi");
            this.stage.close();

            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void inserisciAnnuncio(ActionEvent event){

    }

    @FXML
    public void displayHistorical(ActionEvent event){
        try {
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/Boundary/Storico_annunci.fxml"));

            Scene scene = new Scene(root);
            stage = Main.getStage();
            stage.setScene(scene);
            stage.setTitle("Storico Annunci");
            stage.close();

            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void logout(ActionEvent event) {
        // implementazione del pulsante per disconettere l'utente

        ControllerProfilo.setPagina(0);
        ControllerProfilo.setK(0);
        ControllerProfilo.setVisualizzati(0);
        //System.exit(0);
        Main.getStage().close();
        System.out.println("Logout effettuato con successo");

        try {

            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/Boundary/HomepageOspite_annunciLocatori.fxml"));

            Scene scene = new Scene(root);
            Stage loginStage = new Stage();
            loginStage.setScene(scene);
            loginStage.setTitle("Homepage");
            loginStage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public double getAvgScore(UtenteBean user){

        Random r = new Random(); //N.B. viene implementata randomicamente in quanto compito del sottosistema Evaluation

        double eval = r.nextInt(10);
        user.setEvaluation(eval);

        return eval;
    }



}
