/**
 * Sample Skeleton for 'Anagrammi.fxml' Controller Class
 */

package it.polito.tdp.anagrammi.controller;

import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;

import it.polito.tdp.anagramma.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {
	
	Model model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader

    @FXML // fx:id="btnCalcola"
    private Button btnCalcola; // Value injected by FXMLLoader

    @FXML // fx:id="txtCorrect"
    private TextArea txtCorrect; // Value injected by FXMLLoader

    @FXML // fx:id="txtIncorrect"
    private TextArea txtIncorrect; // Value injected by FXMLLoader

    @FXML // fx:id="btnReset"
    private Button btnReset; // Value injected by FXMLLoader

    @FXML
    void doCalcola(ActionEvent event) {

    	Set<String> anagrammi= this.model.anagrammi(txtParola.getText());
    	
    	for(String s: anagrammi){
    		if (this.model.isCorrect(s))
    			txtCorrect.appendText(s+"\n");
    		else
    			txtIncorrect.appendText(s+"\n");
    	}
    	
    }

    @FXML
    void doReset(ActionEvent event) {
    	
    	txtParola.clear();
    	txtCorrect.clear();
    	txtIncorrect.clear();

    }
    
    public void setModel(Model model){
    	this.model=model;
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtCorrect != null : "fx:id=\"txtCorrect\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtIncorrect != null : "fx:id=\"txtIncorrect\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }
}


