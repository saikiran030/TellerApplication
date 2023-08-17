package com.ncs.teller.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.util.Set;

import javax.persistence.*;

@Entity
public class Customer {

	private int custid;
	private String name;
	private String address;
	private String phone;
	private String email;
	
	public Customer() {
		
	}
	
	public Customer(int custid, String name, String address, String phone, String email) {
		this.custid = custid;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getCustid() {
		return custid;
	}

	public void setCustid(int custid) {
		this.custid = custid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Customer [custid=" + custid + ", name=" + name + ", address=" + address + ", phone=" + phone
				+ ", email=" + email + "]";
	}
}
