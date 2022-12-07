package ui.addBook;

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

public class AddBookController {
	
	ObservableList<Book> bookList = FXCollections.observableArrayList();
	
	private static final File trgtFile = new File("books.txt");

	@FXML
	private AnchorPane mainPane;
	@FXML
	private TextField title;
	@FXML
	private TextField id;
	@FXML
	private TextField author;
	@FXML
	private TextField publisher;
	@FXML
	private Button saveButton;
	@FXML
	private Button cancelButton;

	// Event Listener on Button[#saveButton].onAction
	@FXML
	public void addBook(ActionEvent event) throws IOException {
		String bookTitle = title.getText();
		String bookId = id.getText();
		String bookAuthor = author.getText();
		String bookPublisher = publisher.getText();
		
		boolean isEmpty = bookId.isEmpty() || bookAuthor.isEmpty() || bookTitle.isEmpty() || bookPublisher.isEmpty();
		
		if(isEmpty) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setContentText("Please enter all fields");
			alert.showAndWait();
			return;
		}
		Book book = new Book(bookTitle, bookId, bookAuthor, bookPublisher, true);
		bookList.add(book);
		Iterator<Book> iterator = bookList.iterator();
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
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setHeaderText(null);
		alert.setContentText("Success");
		alert.showAndWait();
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
