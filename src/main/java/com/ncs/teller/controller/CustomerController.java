package com.ncs.teller.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
 
import org.springframework.web.bind.annotation.*;
import com.ncs.teller.service.CustomerService;

import com.ncs.teller.entities.Customer;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
	@Autowired
    private CustomerService service;
	
	@GetMapping
	public List<Customer> list() {
	    return service.listAll();
	}
	
	@GetMapping("/{custid}")
	public ResponseEntity<Customer> get(@PathVariable Integer custid) {
	    try {
	        Customer customer = service.get(custid);
	        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@PostMapping
	public void add(@RequestBody Customer customer) {
	    service.save(customer);
	}
	
	@PutMapping("/{custid}")
	public ResponseEntity<?> update(@RequestBody Customer customer, @PathVariable int custid) {
	    try {
	    	Customer existCustomer = service.get(custid);
	        service.save(customer);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@DeleteMapping("/{custid}")
	public void delete(@PathVariable Integer custid) {
	    service.delete(custid);
	}
}
