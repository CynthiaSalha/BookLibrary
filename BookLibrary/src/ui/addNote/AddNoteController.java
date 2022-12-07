package ui.addNote;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AddNoteController {
	
	private static ObservableList<String> noteList = FXCollections.observableArrayList();
	
	private static File trgtFile = new File("Notes.txt");
	@FXML
	private AnchorPane mainPane;
	@FXML
	private TextField note;
	@FXML
	private Button saveButton;
	@FXML
	private Button cancelButton;

	// Event Listener on Button[#saveButton].onAction
	@FXML
	public void addNote(ActionEvent event) throws IOException {
		String noteText = note.getText();
		if(!noteText.equals("")) {
			noteList.add(noteText);
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setHeaderText(null);
			alert.setContentText("Success");
			alert.showAndWait();
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setContentText("You didn't enter any note");
			alert.showAndWait();
		}
		Iterator<String> iterator = noteList.iterator();
		FileWriter fw = new FileWriter(trgtFile);
		BufferedWriter bw  = new BufferedWriter(fw);
		PrintWriter outToFile = new PrintWriter(bw);
		String singleBook;
		while(iterator.hasNext()) {
			singleBook = iterator.next().toString();
			outToFile.println(singleBook);
		}
		System.out.println("Copied");
		outToFile.close();
	}
	// Event Listener on Button[#cancelButton].onAction
	@FXML
	public void cancel(ActionEvent event) {
		exitStage();
	}
	
	private void exitStage() {
    	Stage stage = (Stage)(mainPane.getScene().getWindow());
    	stage.close();
    }
}
