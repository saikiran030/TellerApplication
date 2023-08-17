package com.ncs.teller.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ncs.teller.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{


}
