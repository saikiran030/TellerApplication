package com.ncs.teller.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ncs.teller.entities.DashBoard;

public interface DashBoardRepository extends JpaRepository<DashBoard, Integer>{
    
    @Query("SELECT new com.ncs.teller.entities.DashBoard(c.custid,a.accid,t.txid,c.name,a.acctype,t.txtype,t.amount,t.balance,t.txdate,t.txstatus) FROM Customer c inner join Account a on c.custid=a.custid  inner join Transaction t on a.accid=t.accid")
    public List<DashBoard> getDashBoard();
}
