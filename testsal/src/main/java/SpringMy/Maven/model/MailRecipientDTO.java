package SpringMy.Maven.model;

public class MailRecipientDTO {
	
	
	private String sender;
	private String recipient;
	private String subject;
	private String message;
	
	
	public MailRecipientDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public MailRecipientDTO(String sender, String recipient, String subject, String message) {
		super();
		this.sender = sender;
		this.recipient = recipient;
		this.subject = subject;
		this.message = message;
	}
	
	
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

	
}
