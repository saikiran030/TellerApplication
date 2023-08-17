package com.ncs.teller.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.sql.Timestamp;

@Entity
public class Account {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accid;
	private String acctype;
	private int balance;
	private Timestamp accdate = new java.sql.Timestamp(System.currentTimeMillis());
	private int beginbalance;
    private int custid;

	public Account() {
		
	}
	
	public Account(String acctype, int balance, int beginbalance,int custid) {
		this.acctype = acctype;
		this.balance = balance;
		this.beginbalance = beginbalance;
		this.custid=custid;
	}
	
	
	public int getAccid() {
		return accid;
	}
	public void setAccid(int accid) {
		this.accid = accid;
	}
	public String getAcctype() {
		return acctype;
	}
	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getBeginbalance() {
		return beginbalance;
	}
	public void setBeginbalance(int beginbalance) {
		this.beginbalance = beginbalance;
	}

	public Timestamp getAccdate() {
		return accdate;
	}

	public void setAccdate(Timestamp accdate) {
		this.accdate = accdate;
	}
	
	public int getCustid() {
		return custid;
	}

	public void setCustid(int custid) {
		this.custid = custid;
	}
	@Override
	public String toString() {
		return "Account [accid=" + accid + ", acctype=" + acctype + ", balance=" + balance + ", accdate=" + accdate
				+ ", beginbalance=" + beginbalance + "]";
	}
}
