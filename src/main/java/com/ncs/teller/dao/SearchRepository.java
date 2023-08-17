package com.ncs.teller.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ncs.teller.entities.Search;

public interface SearchRepository extends JpaRepository<Search, Integer>{
    @Query("SELECT new com.ncs.teller.entities.Search(c.custid,a.accid,c.name,a.balance) FROM Customer c inner join Account a on c.custid=a.custid WHERE c.custid = :custid and a.accid = :accid")
    public List<Search> getCustomerAccount(int custid,int accid);
    
    @Query("SELECT new com.ncs.teller.entities.Search(c.custid,a.accid,c.name,a.balance) FROM Customer c inner join Account a on c.custid=a.custid WHERE c.custid = :custid")
    public List<Search> getCustomer(int custid);
    
    @Query("SELECT new com.ncs.teller.entities.Search(c.custid,a.accid,c.name,a.balance) FROM Customer c inner join Account a on c.custid=a.custid WHERE a.accid = :accid")
    public List<Search> getAccount(int accid);
    
}
