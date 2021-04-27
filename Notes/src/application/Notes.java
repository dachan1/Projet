package application;

public class Notes {
	private String name;
	 private String lastname;
	private String notes;
	 private String vocab;
	 private String subject;
	 
	 
	 public Notes()
	 {
		 this(null,null,null,null);
	 }

	 public Notes(String name, String lastname, String vocab, String notes) {
			this.name=name;
			this.lastname=lastname;
			this.subject="";
			this.notes=notes;
			this.vocab=vocab;
		}

	public String getName() {
		return name;
	}

	public String getLastname() {
		return lastname;
	}

	public String getNotes() {
		return notes;
	}

	public String getVocab() {
		return vocab;
	}

	public String getSubject() {
		return subject;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public void setVocab(String vocab) {
		this.vocab = vocab;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	

}