package fr.artisandeveloppeur.bean;

import java.util.Calendar;
import java.util.Date;

public class Employee {
	private String firstname;
	private String lastname;
	private Date birthday;
	private String mail;
	
	public Employee(String firstname, String lastname, Date birthday, String mail) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthday = birthday;
		this.mail = mail;
	}
	
	public boolean isMybirtday() {
		Calendar cal = Calendar.getInstance();
		Calendar birthdayCal = Calendar.getInstance();
		birthdayCal.setTime(birthday);
		if (cal.get(Calendar.DATE) == birthdayCal.get(Calendar.DATE) && cal.get(Calendar.MONTH) == birthdayCal.get(Calendar.MONTH)) {
			return true;
		}
		return false;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public Date getBirthday() {
		return birthday;
	}
	
	public String getMail() {
		return mail;
	}
}
