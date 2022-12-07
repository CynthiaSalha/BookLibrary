package main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainController implements Initializable {


    @FXML
    void loadAddBook(ActionEvent event) {
    	loadWindow("/ui/addBook/addBook.fxml", "Adding a book");
    }

    @FXML
    void loadAddNote(ActionEvent event) {
    	loadWindow("/ui/addNote/addNote.fxml", "Adding a note");
    }

    @FXML
    void loadBookTable(ActionEvent event) {
    	loadWindow("/ui/listBook/listBook.fxml", "List of Books");
    }
    
    @FXML
    void loadNoteTable(ActionEvent event) {
    	loadWindow("/ui/listNote/listNote.fxml", "List of notes");
    }

    @FXML
    void loadSearch(ActionEvent event) {
    	loadWindow("/ui/searchBook/searchBook.fxml", "Search for a book");
    }

    @FXML
    void loadSettings(ActionEvent event) {
    	loadWindow("/ui/settings/settings.fxml", "Settings");
    }
    
    private void loadWindow(String location, String title) {
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource(location));
			Stage stage = new Stage(StageStyle.DECORATED);
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle(title);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
