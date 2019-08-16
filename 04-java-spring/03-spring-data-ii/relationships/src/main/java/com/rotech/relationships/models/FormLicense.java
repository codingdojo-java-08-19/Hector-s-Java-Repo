package com.rotech.relationships.models;


public class FormLicense {
    private String expirationDate;
    private String state;
    private String person;
    public FormLicense() {
    	
    }
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
     
}
