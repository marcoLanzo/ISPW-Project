
package Boundary;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ErroreAccesso {

	
	@FXML
	private Button closeButton;
	
    
	@FXML
	public void chiudi(ActionEvent event) {
		// implementazione del pulsante per chiudere la finestra attuale
	    Stage stage = (Stage) closeButton.getScene().getWindow();
		System.out.println("Eseguito Logout Con Successo");
	    stage.close();
	}
	
}

