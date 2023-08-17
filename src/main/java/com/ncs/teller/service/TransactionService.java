package com.ncs.teller.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.ncs.teller.dao.AccountRepository;
import com.ncs.teller.dao.TransactionRepository;
import com.ncs.teller.entities.Account;
import com.ncs.teller.entities.Search;
import com.ncs.teller.entities.Transaction;

enum Status
{
    INITIATED, MARKED, CHECKED, AUTHORISED, COMPLETED, REJECTED, FAILED;
}

@Service
@Transactional
public class TransactionService {
	@Autowired
    private TransactionRepository repo;
	@Autowired
    private AccountRepository accrepo;
	
	public List<Transaction> listAll() {
        return repo.findAll();
    }
     
    public void save(Transaction transaction) {
        repo.save(transaction);
    }
     
    public Transaction get(Integer txid) {
        return repo.findById(txid).get();
    }
     
    public void delete(Integer txid) {
        repo.deleteById(txid);
    }
    
    public Account getAccountById(int accid) {
		Account account = accrepo.findById(accid).get();
		
		if (account == null)
			throw new RuntimeException("Not found account");

		return account;
	}
    
    public Transaction getTransactionById(int txid) {
    	Transaction transaction = repo.findById(txid).get();
		
		if (transaction == null)
			throw new RuntimeException("Not found transaction");

		return transaction;
	}
    
    public void deposit(int accid,String txtype, int amount, String txstatus) {
    	Transaction tx;
    	int amt=0;
    	Account acc;
    	try {
    		if(amount<0) {
    			throw new Exception("Enter valid amount");
    		}
    		acc = getAccountById(accid);
    		amt = acc.getBalance() + amount;
    		tx = new Transaction(amount,amt, txtype, txstatus, accid);
    		repo.save(tx);
    	} catch(Exception e) {
    		acc = getAccountById(accid);
    		tx = new Transaction(amount,acc.getBalance(), txtype, "FAILED", accid);
    		repo.save(tx);
    		e.printStackTrace();
    	}
		
	}
    
    public void withdraw(int accid,String txtype, int amount, String txstatus) {
    	Transaction tx;
    	int amt=0;
    	Account acc;
    	try {
    		acc = getAccountById(accid);
    		if(amount>acc.getBalance()) {
    			throw new Exception("Insufficient  amount");
    		}
    		amt = acc.getBalance() - amount;
    		tx = new Transaction(amount,amt, txtype, txstatus, accid);
    		repo.save(tx);
    		
    	} catch(Exception e) {
    		acc = getAccountById(accid);
    		tx = new Transaction(amount,acc.getBalance(), txtype, "FAILED", accid);
    		repo.save(tx);
    		e.printStackTrace();
    	}
	}
    
    public String process(int txid, String txstatus, boolean state) {
    	Transaction tx;
    	try {
    		if(state) {
        		tx = getTransactionById(txid);
        		int cur = Status.valueOf(txstatus).ordinal();
        		int prev = Status.valueOf(tx.getTxstatus()).ordinal();
        		if(prev<=cur) {
        			tx.setTxstatus(txstatus);
            		repo.save(tx);
            		
            		if(txstatus.equals("AUTHORISED") || (tx.getAmount()<1000 && txstatus.equals("CHECKED"))) {
            			Account acc = getAccountById(tx.getAccid());
            			acc.setBalance(tx.getBalance());
                		accrepo.save(acc);
                		tx.setTxstatus("COMPLETED");
                		repo.save(tx);
                		return txstatus +" Done";
            		}
        		} else {
        			return txstatus +" Status is already updated";
        		}
    		} else {
    			tx = getTransactionById(txid);
        		tx.setTxstatus("REJECTED");
        		repo.save(tx);
        		return txstatus +" Rejected";
    		}
    		return txstatus +" Done";
    	} catch(Exception e) {
    		tx = getTransactionById(txid);
    		tx.setTxstatus("FAILED");
    		e.printStackTrace();
    		return txstatus +" Failed";
    	}
	}
    
    
    public List<Transaction> getProcessTransactions(String txstatus)
	{
		return repo.getProcessTransactions(txstatus);
	}

}
