package ui.listBook;

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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import ui.addBook.Book;

public class ListBookController implements Initializable{
	
	private static File srcFile = new File("books.txt");
	
	private static ObservableList<String> bookList = FXCollections.observableArrayList();
	
	@FXML
	private AnchorPane mainPane;
    @FXML
    private ListView<String> booksList;

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
		    bookList.clear();
		    booksList.getItems().clear();
		}
    	
    }


	private void loadData() {
		booksList.getItems().addAll(bookList);
	}

	private void loadList() throws FileNotFoundException {
		Scanner scan = new Scanner(srcFile);
		bookList.clear();
		while(scan.hasNextLine()) {
			Book book = new Book(scan.nextLine(), scan.nextLine(), scan.nextLine(), scan.nextLine(), scan.nextBoolean());
			bookList.add(book.getTitle());
			scan.nextLine();
		}
		System.out.println(bookList);
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

}
