package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HelpWindowController {
	
	@FXML
	void handleNotes()
	{
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("Notes.fxml"));
			AnchorPane pane=loader.load();
			Scene scene=new Scene(pane);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.setTitle("Notes");
			stage.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	
	}
	@FXML
	void handleStats()
	{
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("Summary.fxml"));
			AnchorPane pane=loader.load();
			Scene scene=new Scene(pane);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.setTitle("Summary");
			stage.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
}
}

