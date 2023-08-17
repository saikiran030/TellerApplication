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

import com.ncs.teller.entities.DashBoard;
import com.ncs.teller.service.DashBoardService;

@RestController
@RequestMapping("/api/v1/dashboard")
public class DashBoardController {
	@Autowired
    private DashBoardService service;
	
	@GetMapping
	public ResponseEntity<List<DashBoard>> getDashBoard() {
	    try {
	    	List<DashBoard> dashboard = service.getDashBoard();
	        return new ResponseEntity<List<DashBoard>>(dashboard, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<List<DashBoard>>(HttpStatus.NOT_FOUND);
	    }      
	}
}
