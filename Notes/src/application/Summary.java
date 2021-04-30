package application;

public class Summary {
	private String name;
	 private String lastname;
	 private String summary;
	 private String subject;
	 
	 
	 public Summary()
	 {
		 this(null,null,null,null);
	 }

	 public Summary(String name, String lastname, String vocab, String summary) {
			this.name=name;
			this.lastname=lastname;
			this.subject="";
			this.summary=summary;
			
		}

	public String getName1() {
		return name;
	}

	public String getLastname1() {
		return lastname;
	}

	public String getSummary1() {
		return summary;
	}

	public String getSubject1() {
		return subject;
	}

	public void setName1(String name) {
		this.name = name;
	}

	public void setLastname1(String lastname) {
		this.lastname = lastname;
	}

	public void setSummary1(String summary) {
		this.summary = summary;
	}

	public void setSubject1(String subject) {
		this.subject = subject;
	}



	

}