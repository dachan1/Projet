package application;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="etudiants")
public class NotesListWrapper 
{
private List<Notes> etudiants;
@XmlElement(name = "etudiant")
public List<Notes> getEtudiants()
{
	return etudiants;
	
}

public void setEtudiants(List<Notes> etudiants)
		{
	this.etudiants=etudiants;
}



}



