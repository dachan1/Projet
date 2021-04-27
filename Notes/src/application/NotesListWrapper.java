package application;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import javafx.collections.ObservableList;

@XmlRootElement(name="notes")
public class NotesListWrapper 
{

private List<Notes> notes;
@XmlElement(name = "notes")

public List<Notes> getNotesa()
{
	
	return notes;
	
	
}

public void setnotes(List<Notes> notes)
		{
	this.notes=notes;
}

public Notes getClass(ObservableList<Notes> notesData) {
	return (Notes) notes;
	
}



}
