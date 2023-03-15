package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import model.FileChooserSample;


public class TextAnalyzeController {
	
	// BorderPane correspondant à la fenetre
	@FXML
	private BorderPane root;
	
	// Bouton pour chercher les fichiers à analyser dans l'ordinateur de l'utilisateur
	@FXML
	private Button chooseFileButton;
	
	// Bouton pour vérifier que l'utilisateur a bien importés des fichiers avant de lancer un analyse de spam
	@FXML
	private Button checkFilesImported;
	
	// Texte en fin de page pour annoncer le nombre de spam et de non spam trouvés
	@FXML
	private Label successMessage;
	
	
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
