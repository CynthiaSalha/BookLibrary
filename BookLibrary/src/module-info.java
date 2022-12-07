module BookLibrary {
	requires javafx.controls;
	requires javafx.fxml;
	
	opens main to javafx.graphics, javafx.fxml;
	opens ui.addBook to javafx.graphics, javafx.fxml;
	opens ui.addNote to javafx.graphics, javafx.fxml;
	opens ui.listBook to javafx.graphics, javafx.fxml;
	opens ui.listNote to javafx.graphics, javafx.fxml;
	opens ui.settings to javafx.graphics, javafx.fxml;
	opens ui.login to javafx.graphics, javafx.fxml;
	opens ui.searchBook to javafx.graphics, javafx.fxml;
}
