package com.ncs.teller.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ncs.teller.entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>{
	@Query("SELECT new com.ncs.teller.entities.Transaction(txid,amount,balance,txdate,txtype,txstatus,accid) FROM Transaction WHERE txstatus = :txstatus")
    public List<Transaction> getProcessTransactions(String txstatus);
}
