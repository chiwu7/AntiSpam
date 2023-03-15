package model;

public class Mail {
	
	//Content of the email message
	private String content;
	//Spam status of the email message
	private boolean spam;
	
	/*
	 * Construcs a Mail object with the given content and spam status
	 * @param content the content of the email message
	 * @param spam the spam status of the email message
	 */
	public Mail(String content, boolean spam) {
		this.content = content;
		this.spam = spam;
	}
	
	/*
	 * Return the spam status of the email message
	 * @return the spam status of the email message
	 */
	public boolean isSpam() {
		return spam;
	}
	
	/*
	 * Return the content of the email message
	 * @return the content of the email message
	 */
	public String getContent() {
		return content;
	}
}
