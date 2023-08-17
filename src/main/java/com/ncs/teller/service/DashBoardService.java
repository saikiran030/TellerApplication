package com.ncs.teller.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.ncs.teller.dao.DashBoardRepository;
import com.ncs.teller.entities.DashBoard;

@Service
@Transactional
public class DashBoardService {
	@Autowired
    private DashBoardRepository repo;
	
	public List<DashBoard> getDashBoard()
	{
		return repo.getDashBoard();
	}
}
