package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import model.FileChooserSample;


public class TextAnalyzeController {
	
	/*
	 * BorderPane correspondant à la fenetre
	 */
	@FXML
	private BorderPane root;
	
	
	/*
	 * Bouton pour chercher les fichiers à analyser dans l'ordinateur de l'utilisateur
	 */
	@FXML
	private Button chooseFileButton;
	
	/*
	 * Label sera affiché lorsque l'utilisateur clique sur le bouton valider mais qu'il
	 * n'a pas sélectionné de fichier(s) à analyser.
	 */
	@FXML
	private Label errorFileNotSelected;
	
	/*
	 * Texte en fin de page pour annoncer le nombre de spam et de non spam trouvés
	 */
	@FXML
	private Label successMessage;
	
	
	public void openFileChooser() {
		FileChooserSample fileChooser = new FileChooserSample();
		// Ici
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
	
	@FXML
	private void fileNotSelected() {
		// Vérifier si des fichiers ont été importés
		this.errorFileNotSelected.setVisible(true);
	}
}
