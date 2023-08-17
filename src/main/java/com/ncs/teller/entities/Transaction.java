package com.ncs.teller.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.util.Date;

@Entity
public class Transaction {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int txid;
	private int amount;
	private int balance;
	private Date txdate = new java.sql.Timestamp(System.currentTimeMillis());
	private String txtype;
	private String txstatus;
	private int accid;
	
	
	public Transaction() {
		
	}
	
	public Transaction(int amount, int balance, String txtype, String txstatus, int accid) {
		this.amount = amount;
		this.balance = balance;
		this.txtype = txtype;
		this.accid = accid;
		this.txstatus=txstatus;
	}

	public Transaction(int txid, int amount, int balance, Date txdate, String txtype, String txstatus, int accid) {
		this.txid = txid;
		this.amount = amount;
		this.balance = balance;
		this.txdate = txdate;
		this.txtype = txtype;
		this.accid = accid;
		this.txstatus=txstatus;
	}
	

	
	public int getTxid() {
		return txid;
	}

	public void setTxid(int txid) {
		this.txid = txid;
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

	public String getTxtype() {
		return txtype;
	}

	public void setTxtype(String txtype) {
		this.txtype = txtype;
	}

	public String getTxstatus() {
		return txstatus;
	}

	public void setTxstatus(String txstatus) {
		this.txstatus = txstatus;
	}
	
	public int getAccid() {
		return accid;
	}

	public void setAccid(int accid) {
		this.accid = accid;
	}
	
	@Override
	public String toString() {
		return "Transaction [txid=" + txid + ", amount=" + amount + ", balance=" + balance + ", accdate=" + txdate
				+ ", txtype=" + txtype + ", txstatus=\" + txstatus + \", accid=" + accid + "]";
	}

}
