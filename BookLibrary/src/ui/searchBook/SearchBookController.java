package ui.searchBook;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ui.addBook.Book;

public class SearchBookController implements Initializable {
	
	private static File srcFile = new File("books.txt");
	private static ObservableList<String> list = FXCollections.observableArrayList();
	
    @FXML
    private Text bookAuthorText;

    @FXML
    private Text bookIDText;

    @FXML
    private TextField bookInputID;

    @FXML
    private TextField bookInputTitle;

    @FXML
    private Text bookPublisherText;

    @FXML
    private Text bookTitleText;

    @FXML
    private AnchorPane mainPane;

    @FXML
    void back(ActionEvent event) {
    	Stage stage = (Stage)(mainPane.getScene().getWindow());
    	stage.close();
    }

    @FXML
    private void bookSearchUsingID(ActionEvent event) throws Exception{
    	String idInput = bookInputID.getText();
    	Scanner scan = new Scanner(srcFile);
    	list.clear();
		while(scan.hasNextLine()) {
			Book book = new Book(scan.nextLine(), scan.nextLine(), scan.nextLine(), scan.nextLine(), scan.nextBoolean());
			list.add(book.getId());
			scan.nextLine();
			if(list.contains(idInput)) {
				bookTitleText.setText("Book Title: " + book.getTitle());
				bookIDText.setText("Book ID: " + book.getId());
				bookAuthorText.setText("Book Author: " + book.getAuthor());
				bookPublisherText.setText("Book Publisher: " + book.getPublisher());
				return;
			}
		}
		scan.close();
		bookTitleText.setText("");
		bookIDText.setText("");
		bookAuthorText.setText("Book is unavailable");
		bookPublisherText.setText("");
		System.out.println(list);
    }

    @FXML
    private void bookSearchUsingTitle(ActionEvent event) throws Exception {
    	String titleInput = bookInputTitle.getText();
    	Scanner scan = new Scanner(srcFile);
    	list.clear();
		while(scan.hasNextLine()) {
			Book book = new Book(scan.nextLine(), scan.nextLine(), scan.nextLine(), scan.nextLine(), scan.nextBoolean());
			list.add(book.getTitle());
			scan.nextLine();
			if(list.contains(titleInput)) {
				bookTitleText.setText("Book Title: " + book.getTitle());
				bookIDText.setText("Book ID: " + book.getId());
				bookAuthorText.setText("Book Author: " + book.getAuthor());
				bookPublisherText.setText("Book Publisher: " + book.getPublisher());
				return;
			}
		}
		scan.close();
		bookTitleText.setText("");
		bookIDText.setText("");
		bookAuthorText.setText("Book is unavailable");
		bookPublisherText.setText("");
		System.out.println(list);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
