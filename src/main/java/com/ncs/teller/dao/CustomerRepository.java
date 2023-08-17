package com.ncs.teller.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ncs.teller.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
