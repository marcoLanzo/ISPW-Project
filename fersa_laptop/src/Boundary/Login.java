package Boundary;


import Bean.UtenteBean;
import Controller.Controller;
import Exception.DatiErratiException;
import Exception.UtenteNonTrovatoException;
import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Login implements Initializable{

    int type;


    @FXML
    private TextField user;
    @FXML
    private TextField password;
    @FXML
    private Main main;
    @FXML
    protected Stage stage;
    @FXML
    TextFlow myTextFlow;
    @FXML
    private AnchorPane loginPane;

    private static  UtenteBean ub = new UtenteBean();

    public static UtenteBean getUb() {
        return ub;
    }

    @FXML
    public void Esci() {
        System.out.println("Uscito dal sistema con successo");
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Text text =  new Text("Non sei registrato?");

        myTextFlow.getChildren().add(text);
        Hyperlink createAccount = new Hyperlink("Clicca qui");
        myTextFlow.getChildren().add(createAccount);
        createAccount.setOnAction(event -> {
            try {

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/Boundary/Registrazione.fxml"));
                setStageTitle("Registrazione");
                AnchorPane anchorPane = loader.load();
                loginPane.getChildren().setAll(anchorPane);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }


    @FXML
    public void accedi(ActionEvent event) throws UtenteNonTrovatoException, IOException, DatiErratiException {
        //collegare i bottoni e altre strutture fxml
        String user = this.user.getText();
        String pass = this.password.getText();
        if (user.isEmpty() || pass.isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("");
            alert.setHeaderText("Attenzione!");
            alert.setContentText("Per effettuare il login inserire username e password.");
            alert.showAndWait();

        } else {
            ub.setUserid(user);
            ub.setPassword(pass);
            System.out.println("Tentativo di accedere con i seguenti dati:");
            System.out.println("ID:" + user + "     " + "password:" + pass);

            try {
                 Controller controllerFisico = Controller.getInstance();

                if(controllerFisico.utenteEsistente(user)) {

                    UtenteBean bean = controllerFisico.login(ub.getUserid(), ub.getPassword());
                    type = bean.getType();
                    bean.setType(type);
                    controllerFisico.setUtentebean(bean);


                    Controller.setK(0);
                    Controller.setI(0);
                    Controller.setPagina(0);
                    Controller.setVisualizzati(0);

                    if (type == 1 || type == 3) { /* LOCATORE oppure ENTRAMBI*/

                        Parent root = (AnchorPane) FXMLLoader.load(getClass().getResource("/Boundary/HomepageUtente_annunciLocatori.fxml"));

                        Scene scene = new Scene(root);
                        stage = main.getStage();
                        stage.setScene(scene);
                        stage.setTitle("Homepage");
                        HomepageOspite_Locatori.stage.close();
                        HomepageOspite_Locatori.loginStage.close();
                        stage.show();

                    } else if (type == 2) {/* LOCATARIO */
                        Parent root = (AnchorPane) FXMLLoader.load(getClass().getResource("/Boundary/HomepageUtente_annunciLocatari.fxml"));

                        Scene scene = new Scene(root);
                        stage = main.getStage();
                        stage.setScene(scene);
                        stage.setTitle("Homepage");
                        HomepageOspite_Locatori.stage.close();
                        HomepageOspite_Locatori.loginStage.close();
                        stage.show();

                    } else if (type == 0) {/* OSPITE: Homepage generica dell'utente registrato! (Per default entra nei locatori)*/
                        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/Boundary/HomepageUtente_annunciLocatori.fxml"));

                        Scene scene = new Scene(root);
                        stage = main.getStage();
                        stage.setScene(scene);
                        stage.setTitle("Homepage");
                        HomepageOspite_Locatori.stage.close();
//                        HomepageOspite_Locatori.loginStage.close();
                        stage.show();

                    }
                }
                else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("");
                    alert.setHeaderText("Attenzione!");
                    alert.setContentText("Utente non trovato");
                    alert.showAndWait();

                    throw new UtenteNonTrovatoException();
                }


            } catch (NullPointerException e) {
                e.printStackTrace();
            } catch (DatiErratiException e) {

                AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/Boundary/ErroreAccesso.fxml"));

                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Errore");
                stage.show();


            } catch (IOException e) {
                e.printStackTrace();
            }


        }

    }

    public void setStageTitle(String newTitle) {
        Main.getStage().setTitle(newTitle);
    }


}