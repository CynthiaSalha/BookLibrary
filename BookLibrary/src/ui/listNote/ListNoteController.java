package ui.listNote;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ListNoteController implements Initializable{
	
	private static File srcFile = new File("Notes.txt");
	
	private static ObservableList<String> noteList = FXCollections.observableArrayList();
	@FXML
	private AnchorPane mainPane;
	@FXML
	private ListView<String> noteLists;
	
	private void loadData() {
//		Iterator<Book> iterator = bookList.iterator();
//		String books = "";
//		while(iterator.hasNext()) {
//			books.concat(iterator.next().toString());
//		}
//		System.out.println(books);
		noteLists.getItems().clear();
		noteLists.setItems(noteList);
	}

	private void loadList() throws FileNotFoundException {
		Scanner scan = new Scanner(srcFile);
		noteList.clear();
		while(scan.hasNextLine()) {
			String s = scan.nextLine();
			noteList.add(s);
		}
		System.out.println(noteList);
		scan.close();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			loadList();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loadData();		
	}
	
    @FXML
    void back(ActionEvent event) {
    	Stage stage = (Stage)(mainPane.getScene().getWindow());
    	stage.close();
    }
    
    @FXML
    private void clearList(ActionEvent event) {
    	Alert alert = new Alert(AlertType.CONFIRMATION,"Are you sure you want to clear the list?", ButtonType.YES, ButtonType.CANCEL);
    	alert.setHeaderText(null);
		alert.showAndWait();
		if (alert.getResult() == ButtonType.YES) {
		    noteList.clear();
		    noteLists.getItems().clear();
		}
    	
    }


}
