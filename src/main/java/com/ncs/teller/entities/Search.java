package com.ncs.teller.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Search {
	private int custid;
	@Id
	private int accid;
	private String name;
	private int balance;
	
	public Search(int custid, int accid, String name, int balance) {
		this.custid = custid;
		this.accid = accid;
		this.name = name;
		this.balance = balance;
	}
	
	public int getCustid() {
		return custid;
	}

	public void setCustid(int custid) {
		this.custid = custid;
	}

	public int getAccid() {
		return accid;
	}

	public void setAccid(int accid) {
		this.accid = accid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "CustomerSearch [custid=" + custid + ", accid=" + accid + ", name=" + name + ", balance=" + balance
				+ "]";
	}
}
