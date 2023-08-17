package com.ncs.teller.service;

import java.util.List;

import javax.transaction.Transactional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ncs.teller.entities.Customer;
import com.ncs.teller.dao.CustomerRepository;

@Service
@Transactional
public class CustomerService {
	@Autowired
    private CustomerRepository repo;
     
    public List<Customer> listAll() {
        return repo.findAll();
    }
     
    public void save(Customer customer) {
        repo.save(customer);
    }
     
    public Customer get(Integer custid) {
        return repo.findById(custid).get();
    }
     
    public void delete(Integer custid) {
        repo.deleteById(custid);
    }
}
