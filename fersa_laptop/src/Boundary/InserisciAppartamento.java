
package Boundary;

import Bean.AppartamentoBean;
import Bean.StanzaBean;
import Bean.UtenteBean;
import Controller.Controller;
import Controller.ControllerAppartamento;
import Exception.AppartamentoInesistenteException;
import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.Date;
import java.util.ArrayList;


public class InserisciAppartamento {

	@FXML
	private Button confermaButton;
	@FXML
	private Button closeButton;
	@FXML
	private TextField indirizzo;
	@FXML
	private TextField stanze;
	@FXML
	private CheckBox appCompleto;
	@FXML
	private CheckBox appGruppo;
	@FXML
	private DatePicker data;
	@FXML
	private TextArea descrizione;
	@FXML
	private TextField textCity;
	@FXML
	private AnchorPane appartamentoPane;


	@FXML
	private Main main;

	private UtenteBean user = new UtenteBean();
	private StanzaBean stanzaBean = new StanzaBean();
	Controller controllerFisico = Controller.getInstance();

	protected String StatusString;
	private ControllerAppartamento cA;
	private int counter_id;
	public void setStageTitle(String newTitle) {
		Main.getStage().setTitle(newTitle);
	}

	@FXML
	public void initialize() {

		user = controllerFisico.getUtentebean();
		stanzaBean = ControllerAppartamento.getStanzabean();
		counter_id = ControllerAppartamento.getCounter();

	}


	@FXML
	public void conferma (ActionEvent event) throws AppartamentoInesistenteException {

		String indirizzo = this.indirizzo.getText();
		int stanze = Integer.parseInt(this.stanze.getText());
		boolean appCompleto = this.appCompleto.isSelected();
		boolean appGruppo = this.appGruppo.isSelected();
		String descrizione = this.descrizione.getText();
		String citta = this.textCity.getText();
		java.util.Date Dataprenotazione = (java.util.Date) Date.valueOf(this.data.getValue());

		StanzaBean sb[] = new StanzaBean[stanze];

		if (indirizzo.isEmpty() || stanze <= 0 || (Dataprenotazione == null)) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Attenzione!");
			alert.setHeaderText("Inserimento non andato a buon fine");
			alert.setContentText("Riempire tutti i campi obbligatori!");
			alert.showAndWait();
			alert.close();
			return;
		}



		AppartamentoBean ab = new AppartamentoBean();
		ab.setApartmentId(counter_id);
		ab.setRenter(user);
		ab.setSurfaceAddress(indirizzo);
		ab.setDescription(descrizione);
		ab.setStanze(stanze);
		ArrayList<StanzaBean> Sb = new ArrayList<StanzaBean>();


		for (int i = 0; i<stanze; i++){
			sb[i] = new StanzaBean();
			sb[i].setDoccia(stanzaBean.isDoccia());
			sb[i].setFrigorifero(stanzaBean.isFrigorifero());
			sb[i].setLavastoviglie(stanzaBean.isLavastoviglie());
			sb[i].setMacchinaDelGas(stanzaBean.isMacchinaDelGas());
			sb[i].setMisuratoreConsumoSingolaUnità(stanzaBean.isMisuratoreConsumoSingolaUnità());
			sb[i].setTermostato(stanzaBean.isTermostato());
			sb[i].setVasca(stanzaBean.isVasca());
			sb[i].setWifi(stanzaBean.isWifi());
			sb[i].setGas(stanzaBean.getGas());
			sb[i].setPostiLetto(stanzaBean.getPostiLetto());
			sb[i].setRiscaldamento(stanzaBean.getRiscaldamento());
			sb[i].setStanzaid(counter_id++);
			sb[i].setAppartamentoId(ab.getApartmentId());
			Sb.add(sb[i]);
		}

		ab.setAppcompleto(appCompleto);
		ab.setAppGruppo(appGruppo);
		ab.setData(Dataprenotazione);
		ab.setRooms(Sb);
		ab.setCitta(citta);
		counter_id++;
		try {
			ControllerAppartamento controllerApp = ControllerAppartamento.getInstance();

			if (!controllerApp.inserisciAppartamento(ab)) {

				throw new AppartamentoInesistenteException();
			} else {
				Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
				alert.setTitle("Grazie!");
				alert.setHeaderText("Inserimento andato a buon fine");
				alert.showAndWait();
				alert.close();

			}

		} catch (NullPointerException e) {
			System.out.println("Errore nell'accesso ");
			e.printStackTrace();

		}

	}

	@FXML
	public void chiudi(ActionEvent event) {
		// implementazione del pulsante per chiudere la finestra attuale
		((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
		System.out.println("Pagina chiusa con successo");
	}



}
	
