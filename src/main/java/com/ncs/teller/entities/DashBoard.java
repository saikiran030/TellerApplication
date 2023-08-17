package com.ncs.teller.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DashBoard {
	private int custid;
	private int accid;
	@Id
	private int txid;
	private String name;
	private String acctype;
	private String txtype;
	private int amount;
	private int balance;
	private Date txdate;
	private String txstatus;
	
	public DashBoard(int custid, int accid, int txid, String name, String acctype, String txtype, int amount,
			int balance, Date txdate, String txstatus) {
		this.custid = custid;
		this.accid = accid;
		this.txid = txid;
		this.name = name;
		this.acctype = acctype;
		this.txtype = txtype;
		this.amount = amount;
		this.balance = balance;
		this.txdate = txdate;
		this.txstatus = txstatus;
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

	public int getTxid() {
		return txid;
	}

	public void setTxid(int txid) {
		this.txid = txid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAcctype() {
		return acctype;
	}

	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}

	public String getTxtype() {
		return txtype;
	}

	public void setTxtype(String txtype) {
		this.txtype = txtype;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public Date getTxdate() {
		return txdate;
	}

	public void setTxdate(Date txdate) {
		this.txdate = txdate;
	}

	public String getTxstatus() {
		return txstatus;
	}

	public void setTxstatus(String txstatus) {
		this.txstatus = txstatus;
	}
	
	@Override
	public String toString() {
		return "DashBoard [custid=" + custid + ", accid=" + accid + ", txid=" + txid + ", name=" + name + ", acctype="
				+ acctype + ", txtype=" + txtype + ", amount=" + amount + ", balance=" + balance + ", txdate=" + txdate
				+ ", txstatus=" + txstatus + "]";
	}

}
