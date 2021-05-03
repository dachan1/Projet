package application;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import com.sun.javafx.scene.control.skin.TableViewSkin;
import javafx.scene.control.Skin;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.awt.Label;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SummaryController implements Initializable {
	
	
    @FXML
    private TableColumn<Summary, String> subColumn1;

    @FXML
    private TableColumn<Summary, String> lastnameColumn1;

    @FXML
    private Button btnEffacer1;

    @FXML
    private TextField txtnamea;

    @FXML
    private TextField txtlastnamea;
    
    @FXML
    private TableView<Summary> summaryTable;

    @FXML
    private TableColumn<Summary, String> nameColumn1;

    @FXML
    private Button btnAjouter1;

    @FXML
    private TextField txtsuma;

    @FXML
    private TableColumn<Summary, String> sumColumn1;

    @FXML
    private Button btnModifier1;

    @FXML
    private Button btnClear1;

    @FXML
    private ComboBox<String> cbosubjecta;


    private ObservableList<String> list=(ObservableList<String>) FXCollections.observableArrayList("English", "French", "Chemistry","Music","Art","Drama","Physics","Biology","Careers","Spanish","Technolgy","Mandarin","History","Geography");
 public ObservableList<Summary> summaryData= FXCollections.observableArrayList();
 private Main main;
 public void setMain (Main main)
 {
	 this.main=main;
 }
    public ObservableList<Summary> summaryData()
    {
    	return summaryData;
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
		
		
	cbosubjecta.setItems(list);
	//atribute the variables
	nameColumn1.setCellValueFactory(new PropertyValueFactory<>("name1"));
	lastnameColumn1.setCellValueFactory(new PropertyValueFactory<>("lastname1"));
	subColumn1.setCellValueFactory(new PropertyValueFactory<>("subject1"));
	sumColumn1.setCellValueFactory(new PropertyValueFactory<>("summary1"));
	nameColumn1.setCellFactory(param -> {
        TableCell<Summary, String> cell = new TableCell<>();
        Text text = new Text();
        cell.setGraphic(text);
        cell.setPrefHeight(Control.USE_COMPUTED_SIZE);
        text.wrappingWidthProperty().bind(nameColumn1.widthProperty().subtract(5));
        text.textProperty().bind(cell.itemProperty());
        return cell;
    });
	lastnameColumn1.setCellFactory(param -> {
        TableCell<Summary, String> cell = new TableCell<>();
        Text text = new Text();
        cell.setGraphic(text);
        cell.setPrefHeight(Control.USE_COMPUTED_SIZE);
        text.wrappingWidthProperty().bind(lastnameColumn1.widthProperty().subtract(5));
        text.textProperty().bind(cell.itemProperty());
        return cell;
    });
	subColumn1.setCellFactory(param -> {
        TableCell<Summary, String> cell = new TableCell<>();
        Text text = new Text();
        cell.setGraphic(text);
        cell.setPrefHeight(Control.USE_COMPUTED_SIZE);
        text.wrappingWidthProperty().bind(subColumn1.widthProperty().subtract(10));
        text.textProperty().bind(cell.itemProperty());
        return cell;
    });
	sumColumn1.setCellFactory(param -> {
        TableCell<Summary, String> cell = new TableCell<>();
        Text text = new Text();
        cell.setGraphic(text);
        cell.setPrefHeight(Control.USE_COMPUTED_SIZE);
        text.wrappingWidthProperty().bind(sumColumn1.widthProperty().subtract(5));
        text.textProperty().bind(cell.itemProperty());
        return cell;
    });
	
	
	summaryTable.setItems(summaryData);
	
	btnModifier1.setDisable(true);
	btnEffacer1.setDisable(true);
	btnClear1.setDisable(true);
	
	showSummary2(null);
	
	//Mettre à jour l'affichage
	summaryTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue)-> showSummary2(newValue));	
	}
	//Ajouter un étudiant
		@FXML
		void ajouter2()
		{
		if(noEmptyInput2())
			{
				Summary tmp=new Summary();
				tmp=new Summary();
				tmp.setName1(txtnamea.getText());
				tmp.setLastname1(txtlastnamea.getText());
				tmp.setSubject1(cbosubjecta.getValue());
				tmp.setSummary1(txtsuma.getText());//may be a problem
				summaryData.add(tmp);
				clearFields2();
				
			}
			
		}
		//Effacer le contenue des champs
		@FXML
		void clearFields2()
		{
			cbosubjecta.setValue(null);
			txtnamea.setText("");
			txtlastnamea.setText("");
			txtsuma.setText("");
			
		}
		public void showSummary2(Summary summary)
		{
			if(summary!=null)
			{
				cbosubjecta.setValue(summary.getSubject1());
				txtnamea.setText(summary.getName1());
				txtlastnamea.setText(summary.getLastname1());
				txtsuma.setText(summary.getSummary1());
				
				
				
				btnModifier1.setDisable(false);
				btnEffacer1.setDisable(false);
				btnClear1.setDisable(false);
				
			
			}
			else
			{
				clearFields2();
			}
		}
		@FXML
		public void updateEtudian2()
		{
			if(noEmptyInput2())
			{
				Summary summary=summaryTable.getSelectionModel().getSelectedItem();
				summary.setName1(txtnamea.getText());
				summary.setLastname1(txtlastnamea.getText());
				summary.setSummary1(txtsuma.getText());
				summary.setSubject1(cbosubjecta.getValue());
				summaryTable.refresh();	
			}
		}
			
			@FXML
			public void deleteNotes2()
			{
				int selectedIndex = summaryTable.getSelectionModel().getSelectedIndex();
						if(selectedIndex >=0)
						{
							Alert alert=new Alert(AlertType.CONFIRMATION);
							alert.setTitle("delete");
							alert.setContentText("confirme to delete!");
							Optional<ButtonType> result=alert.showAndWait();
							if(result.get()==ButtonType.OK)
							summaryTable.getItems().remove(selectedIndex);
						}
			}
			
			//vérifier champs vides
			private boolean noEmptyInput2()
			{
				String errorMessage="";
				if(txtnamea.getText().trim().equals(""))
				{
					errorMessage+="The name field must not be empty! \n";
				}
				if(txtlastnamea.getText()==null||txtlastnamea.getText().length()==0)
				{
					errorMessage+="The last name field must not be empty! \n";
				}
				
				if(cbosubjecta.getValue()==null||cbosubjecta.getValue().length()==0)
				{
					errorMessage+="The subject field must not be empty! \n";
				}
				if(txtsuma.getText()==null||txtsuma.getText().length()==0)
				{
					errorMessage+="The definition field must not be empty! \n";
				}
				if(errorMessage.length()==0)
				{
					return true;
				}
				else
				{
					Alert alert=new Alert(AlertType.ERROR);
					alert.setTitle("Fields missing");
					alert.setHeaderText("Fill in the fields");
					alert.setContentText(errorMessage);
					alert.showAndWait();
					return false;
				}
			}
			//Sauvegarde de Données
			//recuperer le chemin(path des fichers si ca existe
			public File getNotesFilePath2()
			{
				Preferences prefs= Preferences.userNodeForPackage(Main.class);
				String filePath = prefs.get("filePath", null);
				if (filePath !=null)
				{
					return new File(filePath);  
				}
				else
				{
					return null;
				}
			}
			
			//attribuer un chemin de fichiers
			
			public void setNotesFilePath2(File file)
			{
				Preferences prefs = Preferences.userNodeForPackage(Main.class);
				if (file != null)
				{
					prefs.put("filePath", file.getPath());
				}
				else
				{
					prefs.remove("filePath");
				}
			}
			
		 //Prendere les donné de type xml et les convertir 
			public void loadNotesDataFromFile2(File file)
			{
				try {
					JAXBContext context = JAXBContext.newInstance(SummaryListWrapper.class);
					Unmarshaller um = context.createUnmarshaller();
					SummaryListWrapper wrapper= new SummaryListWrapper();
					wrapper = (SummaryListWrapper) um.unmarshal(file);
					summaryData.clear();
					summaryData.addAll(wrapper.getEtudiants1());
					setNotesFilePath2(file);
					
					Stage pStage=(Stage)summaryTable.getScene().getWindow();
					pStage.setTitle(file.getName());
				} catch (Exception e) {
					
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error");
					alert.setHeaderText("data not found");
					alert.setContentText("data could not be found :/n" + file.getPath());
					alert.showAndWait();
					
					
				}
				
				
			}
			
			
			//prendres les donnée de type Java fx et les covnertir en type fxml
			
			public void saveNotesDatatoFile2(File file)
			{
				try {
					JAXBContext context = JAXBContext.newInstance(SummaryListWrapper.class);
					Marshaller m = context.createMarshaller();
					m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
					SummaryListWrapper wrapper= new SummaryListWrapper();
					wrapper.setEtudiants1(summaryData);
					
					m.marshal(wrapper, file);
					
					//sauvegarde dans le registre
					setNotesFilePath2(file);
					//donner le titre du ficher
					Stage pStage=(Stage)summaryTable.getScene().getWindow();
					pStage.setTitle(file.getName());
				} catch (Exception e) {
					
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error");
					alert.setHeaderText("Data not saved");
					alert.setContentText("data could not be found :/n" + file.getPath());
					alert.showAndWait();
					
				}
		}
			
			
		
			@FXML
			private void handleNew2()
			{
				summaryData().clear();
				setNotesFilePath2(null);

			
			
			}
			
			
			//file chooser

			@FXML
			private void handleOpen2() 
			{
				FileChooser fileChooser = new FileChooser();
				//permettre un filtre sur l'extension du fichier à chercher
				FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML files(* .xml)", "*.xml");
				fileChooser.getExtensionFilters().add(extFilter);
				
				//montrer le dialogue
				File file = fileChooser.showOpenDialog(null);
				if(file !=null)
				{
					loadNotesDataFromFile2(file);
				}
			}

			//saauvegarder le fichier correspondant
			
			@FXML
			private void handleSave2() {
				File notesFile = getNotesFilePath2();
				if(notesFile !=null) {
					saveNotesDatatoFile2(notesFile);
				}
				else {
					
					handleSaveAS2();
				}
			}
			
			@FXML
			private void handleSaveAS2() {
				FileChooser fileChooser = new FileChooser();
				FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML files(* .xml)", "*.xml");
				fileChooser.getExtensionFilters().add(extFilter);
				
				//SAUVEGARDE
				File file = fileChooser.showSaveDialog(null);
				if(file !=null)
				{
					if(!file.getPath().endsWith(".xml"));
				}
				saveNotesDatatoFile2(file);
			}
		
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
				void handleHelp()
				{
					try {
						FXMLLoader loader = new FXMLLoader(Main.class.getResource("Help.fxml"));
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
			}
			
			
			
		
		 
