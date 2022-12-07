package ui.login;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import ui.settings.User;

public class LoginController implements Initializable {
	
	private static File srcFile = new File("user.txt");
	
	User user;
	
    @FXML
    private AnchorPane mainPane;
	
    @FXML
    private PasswordField password;

    @FXML
    private TextField username;
    
    @FXML
    void cancelAction(ActionEvent event) {
    	System.exit(0);
    }

    @FXML
    void loginAction(ActionEvent event) throws FileNotFoundException {
    	String uName = username.getText();
    	String pass = password.getText();
    	
    	Scanner scan = new Scanner(srcFile);
    	String correctUsername = null, correctPass = null;
    	while(scan.hasNextLine()) {
    		correctUsername = scan.nextLine();
    		correctPass = scan.nextLine();
    	}
    	
    	if(uName.equals(correctUsername) && pass.equals(correctPass)) {
    		exitStage();
    		loadMain();
    	} else {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setContentText("Wrong Credentials");
			alert.showAndWait();
			return;
    	}
    	
    }

    private void loadMain() {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/main/mainFile.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Book Library");
            Image icon = new Image(getClass().getResourceAsStream("library.png"));
            stage.getIcons().add(icon);
            stage.setScene(new Scene(parent));
            stage.show();
        }
        catch (IOException ex) {
        	ex.printStackTrace();
        }
    }
    
    private void exitStage() {
    	Stage stage = (Stage)(mainPane.getScene().getWindow());
    	stage.close();
    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		user = User.getInformation();
	}

}
