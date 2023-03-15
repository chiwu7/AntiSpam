package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import model.FileChooserSample;


public class TextAnalyzeController {
	
	// BorderPane correspondant à la fenetre
	@FXML
	private BorderPane root;
	
	
	public void openFileChooser() {
		FileChooserSample fileChooser = new FileChooserSample();
		fileChooser.start(null);
	}
	
	
	@FXML
	private void reload() throws Exception{
		Scene scene = root.getScene();
		scene.setRoot(FXMLLoader.load(this.getClass().getResource("FXMLDocument.fxml")));
	}
	
	@FXML
    private void initialize() {    
    }
}
