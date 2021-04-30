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
			try {
				AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Notes.fxml"));
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.setTitle("Notes");
				primaryStage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	
	
	
	//pour charger la fenêtre principal
	public void mainWindow()
	{
		
			try {
				FXMLLoader loader=new FXMLLoader(Main.class.getResource("Notes.fxml"));
				AnchorPane pane = loader.load();
				Scene scene=new Scene(pane);
				NotesController mainwindowcontroller=loader.getController();
				mainwindowcontroller.setMain(this);
				primaryStage.setScene(scene);
				primaryStage.setTitle("Notes");
				primaryStage.show();
				} catch (IOException e) {
				// TODO Auto-generated catch blockp
				e.printStackTrace();
			}
			}
		
	
	//pour charger la fenêtre secondaire
	public void secondWindow(String name)
	{
		
		try {
			FXMLLoader loader=new FXMLLoader(Main.class.getResource("Summary.fxml"));
			AnchorPane pane = loader.load();
			Scene scene=new Scene(pane);
			SummaryController secondwindowcontroller=loader.getController();
			//secondwindowcontroller.setText(name);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Summary");
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
