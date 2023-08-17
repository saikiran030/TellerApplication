package com.ncs.teller.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.teller.dao.AccountRepository;
import com.ncs.teller.entities.Account;

@Service
@Transactional
public class AccountService {
	@Autowired
    private AccountRepository repo;
     
    public List<Account> listAll() {
        return repo.findAll();
    }
     
    public void save(Account account) {
        repo.save(account);
    }
     
    public Account get(Integer accid) {
        return repo.findById(accid).get();
    }
     
    public void delete(Integer accid) {
        repo.deleteById(accid);
    }
}
