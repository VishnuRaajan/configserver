package com.bank.accounts.repository;

import com.bank.accounts.entity.*;
import jakarta.transaction.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface AccountsRepository extends JpaRepository<Accounts, Long> {

    Optional<Accounts> findByCustomerId(Long customerId);

    @Transactional
    @Modifying
    void deleteByCustomerId(Long customerId);
}
