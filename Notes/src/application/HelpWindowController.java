package application;

import java.io.IOException;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HelpWindowController {
	 private Main main;
	 public void setMain (Main main)
	 {
		 this.main=main;
	 }
	@FXML//method to bring vocab window from help scene
	void handleNotes()
	{
		main.secondWindow();
		}
		
		
		
	
	
	@FXML//method to bring Summary window from help window
	void handleStats()
	{
		main.handlenotes();
}
}

