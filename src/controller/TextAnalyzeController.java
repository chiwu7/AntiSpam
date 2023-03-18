package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
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
		/*
		 * TODO: Enlever le null et ajouter quelque chose à la place -> voir comment cela marche dans le main
		 */
		Stage stage = new Stage();
		fileChooser.start(stage);
	}
	
	public boolean hasFilesImported() {
		// ajouter condition pour chercher le fichier
		return true;
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
		// Faire un if
		this.errorFileNotSelected.setVisible(true);
	}
	
	@FXML
	private void resultAnalyseMessage() {
		// Modifier le texte avec le nb spam trouvés et ceux non spam
		// Vérifier que "fileNotSelected" 
		this.successMessage.setText("LALA");
		this.successMessage.setVisible(true);
	}
}
