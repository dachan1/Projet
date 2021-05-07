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

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class NotesController implements Initializable {

    @FXML
    private Button btnEffacer;
    
    @FXML
    private TextField txtname;
    
    @FXML
    private TextField txtlastname;

    @FXML
    private TextField txtvocab;

    @FXML
    private Button btnModifier;

    @FXML
    private TableColumn<Notes, String> notColumn;
    
    @FXML
    private TableColumn<Notes, String> nameColumn;
    
    @FXML
    private TableColumn<Notes, String> lastnameColumn;

    @FXML
    private TextField txtnotes;
    
    @FXML
    private TableView<Notes> notesTable;

    @FXML
    private TableColumn<Notes, String> vocColumn;

    @FXML
    private ComboBox<String> cbosubject;

    @FXML
    private TableColumn<Notes, String> subColumn;

    @FXML
    private Button btnAjouter;

    @FXML
    private Button btnClear;
    
    
    private ObservableList<String> list=(ObservableList<String>) FXCollections.observableArrayList("English", "French", "Chemistry","Music","Art","Drama","Physics","Biology","Careers","Spanish","Technolgy","Mandarin","History","Geography");
 public ObservableList<Notes> notesData= FXCollections.observableArrayList();
 private Main main;
 public void setMain (Main main)
 {
	 this.main=main;
 }

    
    public ObservableList<Notes> notesData()
    {
    	return notesData;
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
		
		
	cbosubject.setItems(list);
	//atribute the variables
	nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
	lastnameColumn.setCellValueFactory(new PropertyValueFactory<>("lastname"));
	subColumn.setCellValueFactory(new PropertyValueFactory<>("subject"));
	vocColumn.setCellValueFactory(new PropertyValueFactory<>("vocab"));
	notColumn.setCellValueFactory(new PropertyValueFactory<>("notes"));
	
	nameColumn.setCellFactory(param -> {
        TableCell<Notes, String> cell = new TableCell<>();
        Text text = new Text();
        cell.setGraphic(text);
        cell.setPrefHeight(Control.USE_COMPUTED_SIZE);
        text.wrappingWidthProperty().bind(nameColumn.widthProperty().subtract(5));
        text.textProperty().bind(cell.itemProperty());
        return cell;
    });
	lastnameColumn.setCellFactory(param -> {
        TableCell<Notes, String> cell = new TableCell<>();
        Text text = new Text();
        cell.setGraphic(text);
        cell.setPrefHeight(Control.USE_COMPUTED_SIZE);
        text.wrappingWidthProperty().bind(lastnameColumn.widthProperty().subtract(5));
        text.textProperty().bind(cell.itemProperty());
        return cell;
    });
	subColumn.setCellFactory(param -> {
        TableCell<Notes, String> cell = new TableCell<>();
        Text text = new Text();
        cell.setGraphic(text);
        cell.setPrefHeight(Control.USE_COMPUTED_SIZE);
        text.wrappingWidthProperty().bind(subColumn.widthProperty().subtract(10));
        text.textProperty().bind(cell.itemProperty());
        return cell;
    });
	vocColumn.setCellFactory(param -> {
        TableCell<Notes, String> cell = new TableCell<>();
        Text text = new Text();
        cell.setGraphic(text);
        cell.setPrefHeight(Control.USE_COMPUTED_SIZE);
        text.wrappingWidthProperty().bind(vocColumn.widthProperty().subtract(5));
        text.textProperty().bind(cell.itemProperty());
        return cell;
    });
	notColumn.setCellFactory(param -> {
        TableCell<Notes, String> cell = new TableCell<>();
        Text text = new Text();
        cell.setGraphic(text);
        cell.setPrefHeight(Control.USE_COMPUTED_SIZE);
        text.wrappingWidthProperty().bind(notColumn.widthProperty().subtract(5));
        text.textProperty().bind(cell.itemProperty());
        return cell;
    });

	
	notesTable.setItems(notesData);
	
	btnModifier.setDisable(true);
	btnEffacer.setDisable(true);
	btnClear.setDisable(true);
	
	showNotes(null);
	
	//Mettre à jour l'affichage
	notesTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue)-> showNotes(newValue));	
	}
	//Ajouter un notes
		@FXML
		void ajouter()
		{
		if(noEmptyInput())
			{
				Notes tmp=new Notes();
				tmp=new Notes();
				tmp.setName(txtname.getText());
				tmp.setLastname(txtlastname.getText());
				tmp.setSubject(cbosubject.getValue());
				tmp.setNotes(txtnotes.getText());
				tmp.setVocab(txtvocab.getText());
				notesData.add(tmp);
				clearFields();
				
			}
			
		}
		//Effacer le contenue des champs
		@FXML
		void clearFields()
		{
			cbosubject.setValue(null);
			txtname.setText("");
			txtlastname.setText("");
			txtnotes.setText("");
			txtvocab.setText("");
		}
		public void showNotes(Notes notes)
		{
			if(notes!=null)
			{
				cbosubject.setValue(notes.getSubject());
				txtname.setText(notes.getName());
				txtlastname.setText(notes.getLastname());
				txtnotes.setText(notes.getNotes());
				txtvocab.setText(notes.getVocab());
				
				
				
				btnModifier.setDisable(false);
				btnEffacer.setDisable(false);
				btnClear.setDisable(false);
				
			
			}
			else
			{
				clearFields();
			}
		}
		@FXML
		public void updateEtudian()//method update notes
		{
			if(noEmptyInput())
			{
				Notes notes=notesTable.getSelectionModel().getSelectedItem();
				notes.setName(txtname.getText());
				notes.setLastname(txtlastname.getText());
				notes.setNotes(txtnotes.getText());
				notes.setSubject(cbosubject.getValue());
				notes.setVocab(txtvocab.getText());
				notesTable.refresh();	
			}
		}
			
			@FXML
			public void deleteNotes()//method pour delete notes
			{
				int selectedIndex = notesTable.getSelectionModel().getSelectedIndex();
						if(selectedIndex >=0)
						{
							Alert alert=new Alert(AlertType.CONFIRMATION);
							alert.setTitle("delete");
							alert.setContentText("confirme to delete!");
							Optional<ButtonType> result=alert.showAndWait();
							if(result.get()==ButtonType.OK)
							notesTable.getItems().remove(selectedIndex);
						}
			}
			
			//vérifier champs vides
			private boolean noEmptyInput()
			{
				String errorMessage="";
				if(txtname.getText().trim().equals(""))
				{
					errorMessage+="The name field must not be empty! \n";
				}
				if(txtlastname.getText()==null||txtlastname.getText().length()==0)
				{
					errorMessage+="The last name field must not be empty! \n";
				}
				
				if(cbosubject.getValue()==null||cbosubject.getValue().length()==0)
				{
					errorMessage+="The subject field must not be empty! \n";
				}
				if(txtnotes.getText()==null||txtnotes.getText().length()==0)
				{
					errorMessage+="The definition field must not be empty! \n";
				}
				if(txtvocab.getText()==null||txtvocab.getText().length()==0)
				{
					errorMessage+="The vocabulary field must not be empty! \n";
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
			public File getNotesFilePath()
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
			
			public void setNotesFilePath(File file)
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
			public void loadNotesDataFromFile(File file)
			{
				try {
					JAXBContext context = JAXBContext.newInstance(NotesListWrapper.class);
					Unmarshaller um = context.createUnmarshaller();
					NotesListWrapper wrapper= new NotesListWrapper();
					wrapper = (NotesListWrapper) um.unmarshal(file);
					notesData.clear();
					notesData.addAll(wrapper.getEtudiants());
					setNotesFilePath(file);
					
					Stage pStage=(Stage)notesTable.getScene().getWindow();
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
			
			public void saveNotesDatatoFile(File file)
			{
				try {
					JAXBContext context = JAXBContext.newInstance(NotesListWrapper.class);
					Marshaller m = context.createMarshaller();
					m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
					NotesListWrapper wrapper= new NotesListWrapper();
					wrapper.setEtudiants(notesData);
					
					m.marshal(wrapper, file);
					
					//sauvegarde dans le registre
					setNotesFilePath(file);
					//donner le titre du ficher
					Stage pStage=(Stage)notesTable.getScene().getWindow();
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
			private void handleNew()
			{
				notesData().clear();
				setNotesFilePath(null);

			
			
			}
			
			
			//file chooser

			@FXML
			private void handleOpen() 
			{
				FileChooser fileChooser = new FileChooser();
				//permettre un filtre sur l'extension du fichier à chercher
				FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML files(* .xml)", "*.xml");
				fileChooser.getExtensionFilters().add(extFilter);
				
				//montrer le dialogue
				File file = fileChooser.showOpenDialog(null);
				if(file !=null)
				{
					loadNotesDataFromFile(file);
				}
			}

			//saauvegarder le fichier correspondant
			
			@FXML
			private void handleSave() {
				File notesFile = getNotesFilePath();
				if(notesFile !=null) {
					saveNotesDatatoFile(notesFile);
				}
				else {
					
					handleSaveAS();
				}
			}
			
			@FXML
			private void handleSaveAS() {
				FileChooser fileChooser = new FileChooser();
				FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML files(* .xml)", "*.xml");
				fileChooser.getExtensionFilters().add(extFilter);
				
				//SAUVEGARDE
				File file = fileChooser.showSaveDialog(null);
				if(file !=null)
				{
					if(!file.getPath().endsWith(".xml"));
				}
				saveNotesDatatoFile(file);
			}
			//affihcer le ficher summary de scene notes
			@FXML
			void handleStats()
			{
				main.secondWindow();
				}
				
				
			@FXML
			void handleHelp()//method d'avoir le ficher help du stage Notes
			{
				main.mainWindow();
		
		}
}
		 
