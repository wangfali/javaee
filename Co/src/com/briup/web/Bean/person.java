package com.briup.web.Bean;

public class person {
	private String idString;
	private String nameString;
	private String phoneString;
	private String qQString;
	private String emailString;
	public String getIdString() {
		return idString;
	}
	public void setIdString(String idString) {
		this.idString = idString;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public String getPhoneString() {
		return phoneString;
	}
	public void setPhoneString(String phoneString) {
		this.phoneString = phoneString;
	}
	public String getqQString() {
		return qQString;
	}
	public void setqQString(String qQString) {
		this.qQString = qQString;
	}
	public String getEmailString() {
		return emailString;
	}
	public void setEmailString(String emailString) {
		this.emailString = emailString;
	}
	/**
	 * @param idString
	 * @param nameString
	 * @param phoneString
	 * @param qQString
	 * @param emailString
	 */
	public person(String idString, String nameString, String phoneString,
			String qQString, String emailString) {
		super();
		this.idString = idString;
		this.nameString = nameString;
		this.phoneString = phoneString;
		this.qQString = qQString;
		this.emailString = emailString;
	}
	/**
	 * 
	 */
	public person() {
		super();
	}
	
	
}
