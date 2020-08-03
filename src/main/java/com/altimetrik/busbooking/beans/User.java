package com.altimetrik.busbooking.beans;

/**
 * @author Prasath
 *
 */
public class User {

	private String userName;
	private String firstName;
	private String lastName;
	private int age;
	private String emailAddress;
	private String mobileNumber;
	private String whatsAppEnabled;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getWhatsAppEnabled() {
		return whatsAppEnabled;
	}
	public void setWhatsAppEnabled(String whatsAppEnabled) {
		this.whatsAppEnabled = whatsAppEnabled;
	}
	
}
