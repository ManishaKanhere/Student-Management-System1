package com.example.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
@Entity
@NamedQueries({ 
	@NamedQuery(
			name="findByStudent",
			query="select e from Student e WHERE percent BETWEEN :min and :max"
			),
	@NamedQuery(name="viewAllStudents",
	query="select s from  Student s"
	)
	
})





@Table(name="StudentDetails")
public class Student {
	@Id
	int rollNo;
	String name;
	String dob;
	float percent;
	String city;
	String emailId;
	String phoneNo;
	public Student() {
		super();
	}
	public Student(int rollNo, String name, String dob, float percent, String city, String emailId, String phoneNo) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.dob = dob;
		this.percent = percent;
		this.city = city;
		this.emailId = emailId;
		this.phoneNo = phoneNo;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public float getPercent() {
		return percent;
	}
	public void setPercent(float percent) {
		this.percent = percent;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", dob=" + dob + ", percent=" + percent + ", city="
				+ city + ", emailId=" + emailId + ", phoneNo=" + phoneNo + "]";
	}

	

}
