package com.bank.accounts.service;

import com.bank.accounts.dto.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

public interface IAccountService {

    void create(CustomerDto customerDto);

    CustomerDto getCustomerAndAccounts(String mobileNumber);

    boolean updateCustomerAndAccount(CustomerDto customerDto);

    boolean deleteAccount(String mobileNumber);
}
