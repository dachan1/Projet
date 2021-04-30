package application;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="stuff")
public class SummaryListWrapper 
{
private List<Summary> stuff;
@XmlElement(name = "stuff")
public List<Summary> getEtudiants1()
{
	return stuff;
	
}

public void setEtudiants1(List<Summary> sum)
		{
	this.stuff=sum;
}



}

