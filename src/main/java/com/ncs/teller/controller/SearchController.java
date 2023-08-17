package com.ncs.teller.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.teller.entities.Search;
import com.ncs.teller.service.SearchService;

@RestController
@RequestMapping("/api/v1/search")
public class SearchController {
	@Autowired
    private SearchService service;
	
	@GetMapping("/{custid}/{accid}")
	public ResponseEntity<List<Search>> getCustomerAccount(@PathVariable Integer custid, @PathVariable Integer accid) {
	    try {
	    	List<Search> search = service.getCustomerAccount(custid,accid);
	        return new ResponseEntity<List<Search>>(search, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<List<Search>>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	
	@GetMapping("/customer/{custid}")
	public ResponseEntity<List<Search>> getCustomer(@PathVariable Integer custid) {
	    try {
	    	List<Search> search = service.getCustomer(custid);
	        return new ResponseEntity<List<Search>>(search, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<List<Search>>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	
	@GetMapping("/account/{accid}")
	public ResponseEntity<List<Search>> getAccount(@PathVariable Integer accid) {
	    try {
	    	List<Search> search = service.getAccount(accid);
	        return new ResponseEntity<List<Search>>(search, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<List<Search>>(HttpStatus.NOT_FOUND);
	    }      
	}
}
