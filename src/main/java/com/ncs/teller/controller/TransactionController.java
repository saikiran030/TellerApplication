package com.ncs.teller.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.teller.entities.Transaction;
import com.ncs.teller.service.TransactionService;

@RestController
@RequestMapping("/api/v1/transaction")
public class TransactionController {
	@Autowired
    private TransactionService service;
	
	@GetMapping
	public List<Transaction> list() {
	    return service.listAll();
	}
	
	@GetMapping("/{txid}")
	public ResponseEntity<Transaction> get(@PathVariable Integer txid) {
	    try {
	    	Transaction transaction = service.get(txid);
	        return new ResponseEntity<Transaction>(transaction, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Transaction>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	/*@PostMapping
	public void add(@RequestBody Transaction transaction) {
	    service.save(transaction);
	}*/
	
	@PutMapping("/{txid}")
	public ResponseEntity<?> update(@RequestBody Transaction transaction, @PathVariable int txid) {
	    try {
	    	Transaction existTransaction = service.get(txid);
	        service.save(transaction);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@DeleteMapping("/{txid}")
	public void delete(@PathVariable Integer txid) {
	    service.delete(txid);
	}
	
	@PostMapping("/saveAccountTransaction/{accid}/{amount}/{txtype}")
	public String saveAccountTransaction(@PathVariable int accid, @PathVariable int amount, @PathVariable String txtype) {
		if(txtype.equals("Deposit")) {
			service.deposit(accid, txtype ,amount, "INITIATED");
			return "Deposit Initiated";
		} else if(txtype.equals("Withdraw")) {
			service.withdraw(accid, txtype ,amount, "INITIATED");
			return "Withdraw Initiated";
		}
		return "Invalid Transaction";
	}
	
}
