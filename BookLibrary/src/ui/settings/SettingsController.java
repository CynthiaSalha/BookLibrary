package ui.settings;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SettingsController implements Initializable{
	
	private static File trgtFile = new File("user.txt");
	
	User user;

    @FXML
    private AnchorPane mainPane;
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;

	// Event Listener on Button.onAction
	@FXML
	public void saveAction(ActionEvent event) throws IOException {
		String uName = username.getText();
		String pass = password.getText();
		if(uName.equals(user.getUsername()) && pass.equals(user.getPassword())) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setContentText("You already have the same username and password");
			alert.showAndWait();
			return;
		} else {
			user.setUsername(uName);
			user.setPassword(pass);
			exitStage();
		}
		
		FileWriter fw = new FileWriter(trgtFile);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter outToFile = new PrintWriter(bw);
		outToFile.println(user.toString());
		outToFile.close();
	}
	// Event Listener on Button.onAction
	@FXML
	public void cancelAction(ActionEvent event) {
		exitStage();
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		user = User.getInformation();
	}
	
	private void exitStage() {
    	Stage stage = (Stage)(mainPane.getScene().getWindow());
    	stage.close();
    }
}
