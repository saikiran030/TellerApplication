package com.ncs.teller.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.ncs.teller.dao.SearchRepository;
import com.ncs.teller.entities.Search;

@Service
@Transactional
public class SearchService {
	@Autowired
    private SearchRepository repo;
	
	public List<Search> getCustomerAccount(@Param("custid") int custid,@Param("accid") int accid)
	{
		return repo.getCustomerAccount(custid,accid);
	}
	
	public List<Search> getCustomer(@Param("custid") int custid)
	{
		return repo.getCustomer(custid);
	}
	
	public List<Search> getAccount(@Param("accid") int accid)
	{
		return repo.getAccount(accid);
	}
}
