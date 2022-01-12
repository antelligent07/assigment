package org.assignment.user;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class User {

	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String city;
	private long mobileNumber;

	public User() {

	}

	public User(String firstName, String lastName, String dateOfBirth, String city, String mobileNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		java.util.Date date = null;
//		try {
//			date = dateFormat.parse(dateOfBirth);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
////		this.dateOfBirth = new Date(dateFormat.format(date));
//		String newdate = dateFormat.format(date);
////		System.out.println("new date:" + newdate);
////		try {
////			this.dateOfBirth = dateFormat.parse(newdate);
////		} catch (ParseException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
//		
//		try {
//			this.dateOfBirth = new SimpleDateFormat("yyyy-MM-dd").parse(dateOfBirth);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		try {
			this.dateOfBirth = Date.valueOf(dateOfBirth);
		} catch (java.lang.IllegalArgumentException e) {
			System.out.println("Date exception");
		}
		
		this.city = city;
		this.mobileNumber = Long.parseLong(mobileNumber);
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth + ", city="
				+ city + ", mobileNumber=" + mobileNumber + "]";
	}
}
