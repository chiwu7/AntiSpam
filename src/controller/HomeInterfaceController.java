package controller;


import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import models.FileChooserSample;


public class HomeInterfaceController {
	

	// BorderPane correspondant à la fenetre
	@FXML
	private BorderPane root;
	
	
	@FXML
	private void reload() throws Exception{
		Scene scene = root.getScene();
		scene.setRoot(FXMLLoader.load(this.getClass().getResource("FXMLDocument.fxml")));
	}
	
	@FXML
    private void initialize() {    
    }
	
	public void changeViewToTextFileInterface() {
		try {
			Scene scene = root.getScene();
			scene.setRoot(FXMLLoader.load(this.getClass().getResource("/vue/TextAnalyzeVue.fxml")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
