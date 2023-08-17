package com.ncs.teller.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.teller.entities.Customer;
import com.ncs.teller.entities.Transaction;
import com.ncs.teller.service.TransactionService;

@RestController
@RequestMapping("/api/v1/process")
public class ProcessController {
	@Autowired
    private TransactionService service;
	
	@GetMapping("/initiated")
	public ResponseEntity<List<Transaction>> getInitiatedTransaction() {
	    try {
	    	List<Transaction> transaction = service.getProcessTransactions("INITIATED");
	        return new ResponseEntity<List<Transaction>>(transaction, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<List<Transaction>>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@PutMapping("/initiated/{txid}/{state}")
	public ResponseEntity<String> updateIntiatedTransaction(@PathVariable int txid,@PathVariable boolean state) {
	    try {
	    	Transaction existTransation = service.get(txid);
	        String msg = service.process(txid, "INITIATED", state);
	        return new ResponseEntity<String>(msg, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	
	//MARKED
	@GetMapping("/marked")
	public ResponseEntity<List<Transaction>> getMarkedTransaction() {
	    try {
	    	List<Transaction> transaction = service.getProcessTransactions("MARKED");
	        return new ResponseEntity<List<Transaction>>(transaction, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<List<Transaction>>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@PutMapping("/marked/{txid}/{state}")
	public ResponseEntity<String> updateMarkedTransaction(@PathVariable int txid,@PathVariable boolean state) {
	    try {
	    	Transaction existTransation = service.get(txid);
	    	String msg = service.process(txid, "MARKED", state);
	        return new ResponseEntity<String>(msg,HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	//CHECKED
	@GetMapping("/checked")
	public ResponseEntity<List<Transaction>> getCheckedTransaction() {
	    try {
	    	List<Transaction> transaction = service.getProcessTransactions("CHECKED");
	        return new ResponseEntity<List<Transaction>>(transaction, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<List<Transaction>>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@PutMapping("/checked/{txid}/{state}")
	public ResponseEntity<String> updateCheckedTransaction(@PathVariable int txid,@PathVariable boolean state) {
	    try {
	    	Transaction existTransation = service.get(txid);
	    	String msg = service.process(txid, "CHECKED", state);
	        return new ResponseEntity<String>(msg,HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	//AUTHORISED
	@GetMapping("/authorised")
	public ResponseEntity<List<Transaction>> getAuthorisedTransaction() {
	    try {
	    	List<Transaction> transaction = service.getProcessTransactions("AUTHORISED");
	        return new ResponseEntity<List<Transaction>>(transaction, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<List<Transaction>>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@PutMapping("/authorised/{txid}/{state}")
	public ResponseEntity<String> updateAuthorisedTransaction(@PathVariable int txid,@PathVariable boolean state) {
	    try {
	    	Transaction existTransation = service.get(txid);
	    	String msg = service.process(txid, "AUTHORISED", state);
	        return new ResponseEntity<String>(msg,HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	
	//COMPLETED
	@GetMapping("/completed")
	public ResponseEntity<List<Transaction>> getCompletedTransaction() {
	    try {
	    	List<Transaction> transaction = service.getProcessTransactions("COMPLETED");
	        return new ResponseEntity<List<Transaction>>(transaction, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<List<Transaction>>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@PutMapping("/completed/{txid}/{state}")
	public ResponseEntity<String> updateCompletedTransaction(@PathVariable int txid,@PathVariable boolean state) {
	    try {
	    	Transaction existTransation = service.get(txid);
	    	String msg = service.process(txid, "COMPLETED", state);
	        return new ResponseEntity<String>(msg, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	//REJECTED
	@GetMapping("/rejected")
	public ResponseEntity<List<Transaction>> getRejectedTransaction() {
	    try {
	    	List<Transaction> transaction = service.getProcessTransactions("REJECTED");
	        return new ResponseEntity<List<Transaction>>(transaction, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<List<Transaction>>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@PutMapping("/rejected/{txid}/{state}")
	public ResponseEntity<String> updateRejectedTransaction(@PathVariable int txid,@PathVariable boolean state) {
	    try {
	    	Transaction existTransation = service.get(txid);
	    	String msg = service.process(txid, "REJECTED", state);
	        return new ResponseEntity<String>(msg,HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	//FAILED
	@GetMapping("/failed")
	public ResponseEntity<List<Transaction>> getFailedTransaction() {
	    try {
	    	List<Transaction> transaction = service.getProcessTransactions("FAILED");
	        return new ResponseEntity<List<Transaction>>(transaction, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<List<Transaction>>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@PutMapping("/failed/{txid}/{state}")
	public ResponseEntity<String> updateFailedTransaction(@PathVariable int txid,@PathVariable boolean state) {
	    try {
	    	Transaction existTransation = service.get(txid);
	        String msg = service.process(txid, "FAILED", state);
	        return new ResponseEntity<String>(msg,HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
}
