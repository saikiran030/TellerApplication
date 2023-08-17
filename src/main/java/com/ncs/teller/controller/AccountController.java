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

import com.ncs.teller.service.AccountService;
import com.ncs.teller.entities.Account;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {
	@Autowired
    private AccountService service;
	
	@GetMapping
	public List<Account> list() {
	    return service.listAll();
	}
	
	@GetMapping("/{accid}")
	public ResponseEntity<Account> get(@PathVariable Integer accid) {
	    try {
	    	Account account = service.get(accid);
	        return new ResponseEntity<Account>(account, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@PostMapping
	public void add(@RequestBody Account account) {
	    service.save(account);
	}
	
	@PutMapping("/{accid}")
	public ResponseEntity<?> update(@RequestBody Account account, @PathVariable int accid) {
	    try {
	    	Account existAccount = service.get(accid);
	        service.save(account);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@DeleteMapping("/{accid}")
	public void delete(@PathVariable Integer accid) {
	    service.delete(accid);
	}
}
