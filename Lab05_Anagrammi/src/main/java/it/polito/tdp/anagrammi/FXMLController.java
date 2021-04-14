package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Anagrammi;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Anagrammi model;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btCalcola;

    @FXML
    private TextArea txtCorretti;

    @FXML
    private TextArea txtErrati;

    @FXML
    private Button btReset;

    @FXML
    void doCalcola(ActionEvent event) {
    	this.txtCorretti.clear();
    	this.txtErrati.clear();
    	String parola = this.txtParola.getText();
    	if(parola.isEmpty() || !parola.matches("[a-zA-Z]+")) {
    		this.txtCorretti.setText("Devi inserire una parola senza numeri");
    		return;
    	}
    	
    	List<String> corretti = new ArrayList<>();
    	List<String> errati = new ArrayList<>();
    	
    	this.model.calcola(corretti, errati, parola);
    	for(String s: corretti)
    		this.txtCorretti.appendText(s+"\n");
    	
    	for(String s: errati) {
    		this.txtErrati.appendText(s+"\n");
    	}
    }

    @FXML
    void doReset(ActionEvent event) {
    	this.txtCorretti.clear();
    	this.txtErrati.clear();
    	this.txtParola.clear();
    	return;
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btCalcola != null : "fx:id=\"btCalcola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btReset != null : "fx:id=\"btReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	public void setModel(Anagrammi model) {
		this.model = model;
		
	}
}