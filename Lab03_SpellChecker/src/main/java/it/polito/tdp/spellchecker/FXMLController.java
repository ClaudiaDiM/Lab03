package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import it.polito.tdp.spellchecker.model.Dictionary;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class FXMLController {
	
	private Dictionary dizionario;
	private List<String> inputTextList;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> boxLingua;

    @FXML
    private TextArea txtDaCorreggere;

    @FXML
    private Button spellCheckButton;

    @FXML
    private TextArea txtCorretto;

    @FXML
    private Label lblErrori;

    @FXML
    private Button clearTextButton;

    @FXML
    private Label lblStato;

    @FXML
    void doActivation(ActionEvent event) {
    	
    	if(boxLingua.getValue()!= null) {
    		
    		txtDaCorreggere.setDisable(false);
    		spellCheckButton.setDisable(false);
    		clearTextButton.setDisable(false);
    		txtDaCorreggere.clear();
    		txtCorretto.clear();
     }
    	else {
    		txtDaCorreggere.setDisable(true);
    		txtCorretto.setDisable(true);
    		spellCheckButton.setDisable(true);
    		clearTextButton.setDisable(true);
    		txtDaCorreggere.setText("Seleziona una lingua!");
    		
    	}
    	

    }

    @FXML
    void doClearText(ActionEvent event) {
    	txtDaCorreggere.clear();
    	txtCorretto.clear();
    	lblErrori.setText("Number of Errors:");
		lblStato.setText("Spell Check Status:");

    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	
    	txtCorretto.clear();
    	inputTextList = new ArrayList<String>();
    	
    	if(boxLingua.getValue()==null) {
    		txtDaCorreggere.setText("Seleziona una lingua!");
    		return;
    	}
    	
    	if(!dizionario.loadDictionary(boxLingua.getValue())) {
    		txtDaCorreggere.setText("Errore nel caricamento del dizionario!");
    		return;
    	}
    	
    	String inputText = txtDaCorreggere.getText();
    	
    	if(inputText.isEmpty()) {
    		txtDaCorreggere.setText("Inserire un testo da correggere!");
			return;
    	}
    	
    	inputText = inputText.replaceAll("\n", " ");
    	inputText = inputText.replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]]", "");
    	//StringTokenizer mi mette in st le parole che sono divese da spazio
    	StringTokenizer st = new StringTokenizer(inputText, " ");
    	while(st.hasMoreTokens()) {
    		inputTextList.add(st.nextToken());
    	}

    }

    @FXML
    void initialize() {
        assert boxLingua != null : "fx:id=\"boxLingua\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtDaCorreggere != null : "fx:id=\"txtDaCorreggere\" was not injected: check your FXML file 'Scene.fxml'.";
        assert spellCheckButton != null : "fx:id=\"spellCheckButton\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorretto != null : "fx:id=\"txtCorretto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert lblErrori != null : "fx:id=\"lblErrori\" was not injected: check your FXML file 'Scene.fxml'.";
        assert clearTextButton != null : "fx:id=\"clearTextButton\" was not injected: check your FXML file 'Scene.fxml'.";
        assert lblStato != null : "fx:id=\"lblStato\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
