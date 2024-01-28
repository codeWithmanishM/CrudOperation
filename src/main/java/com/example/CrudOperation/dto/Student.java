package com.example.CrudOperation.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student 
{
	@Id
	private int RollNo;
	private String Name;
	private String Address;
	
	public Student() {
		
	}

	public Student(int rollNo, String name, String address) {
		super();
		this.RollNo = rollNo;
		this.Name = name;
		this.Address = address;
	}
	
	public int getRollNo() {
		return RollNo;
	}
	public void setRollNo(int rollNo) {
		RollNo = rollNo;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}

	@Override
	public String toString() {
		return "Student [RollNo=" + RollNo + ", Name=" + Name + ", Address=" + Address + "]";
	}
	
}
