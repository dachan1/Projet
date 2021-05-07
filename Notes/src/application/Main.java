package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	private Stage primaryStage;
	@Override
	public void start(Stage primaryStage) {
			this.primaryStage=primaryStage;
			mainWindow();
		}
	
	
	
	//pour charger la fenêtre principal
	public void mainWindow()
	{
		
		try {
			FXMLLoader loader=new FXMLLoader(Main.class.getResource("Help.fxml"));
			AnchorPane pane = loader.load();
			Scene scene=new Scene(pane);
			HelpWindowController mainwindowcontroller=loader.getController();
			mainwindowcontroller.setMain(this);
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.setTitle("Help");
			primaryStage.show();
			} catch (IOException e) {
			// TODO Auto-generated catch blockp
			e.printStackTrace();
			}
	}
		
	
	//pour charger la fenêtre secondaire
	public void secondWindow()
	{
		
		try {
			FXMLLoader loader=new FXMLLoader(Main.class.getResource("Summary.fxml"));
			AnchorPane pane = loader.load();
			Scene scene=new Scene(pane);
			SummaryController mainwindowcontroller=loader.getController();
			mainwindowcontroller.setMain(this);
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.setTitle("Summary");
			primaryStage.show();
			} catch (IOException e) {
			// TODO Auto-generated catch blockp
			e.printStackTrace();
		}
		}
	public void handlenotes()//method d'avoir le ficher help du stage Notes
	{
		
			try {
				FXMLLoader loader=new FXMLLoader(Main.class.getResource("Notes.fxml"));
				AnchorPane pane = loader.load();
				Scene scene=new Scene(pane);
				NotesController mainwindowcontroller=loader.getController();
				mainwindowcontroller.setMain(this);
				primaryStage.setScene(scene);
				primaryStage.setResizable(false);
				primaryStage.setTitle("Notes");
				primaryStage.show();
				} catch (IOException e) {
				// TODO Auto-generated catch blockp
				e.printStackTrace();
			}
		}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
