package com.bank.accounts.service.implementation;

import com.bank.accounts.constants.*;
import com.bank.accounts.dto.*;
import com.bank.accounts.entity.*;
import com.bank.accounts.exception.*;
import com.bank.accounts.mapper.*;
import com.bank.accounts.repository.*;
import com.bank.accounts.service.*;
import lombok.*;
import org.springframework.boot.web.servlet.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import java.time.*;
import java.util.*;

@Service
@AllArgsConstructor
public class AccountsServiceImpl implements IAccountService {

    private AccountsRepository accountsRepository;

    private CustomerRepository customerRepository;

    @Override
    public void create(@RequestBody CustomerDto customerDto) {

        Customer customer = CustomerMapper.mapToCustomer(customerDto,new Customer());
        Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        if(optionalCustomer.isPresent())
        {
            throw new CustomerAlreadyExistsException("Customer already exists with mobile number "
                    +customerDto.getMobileNumber());
        }

        customer.setCreatedDate(LocalDateTime.now());
        customer.setCreatedBy("anonymous");
        Customer createdCustomer = customerRepository.save(customer);
        accountsRepository.save(createNewAccount(createdCustomer));


    }



    private Accounts createNewAccount(Customer customer)
    {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber =1000000000L + new Random().nextInt(90000000);
        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        newAccount.setCreatedBy("anonymous");
        newAccount.setCreatedDate(LocalDateTime.now());
        return newAccount;
    }

    @Override
    public CustomerDto getCustomerAndAccounts(String mobileNumber) {

        Customer customer = customerRepository.findByMobileNumber(mobileNumber).
                orElseThrow(()->new ResourceNotFoundException("customer","mobileNumber",mobileNumber));

        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId())
                .orElseThrow(() ->new ResourceNotFoundException("accounts","mobileNumber",mobileNumber.toString()));

        CustomerDto customerDto = CustomerMapper.mapToCustomerDto(customer,new CustomerDto());
        customerDto.setAccountsdto(AccountsMapper.mapToAccountDto(accounts,new Accountsdto()));


        return customerDto;
    }

    @Override
    public boolean updateCustomerAndAccount(CustomerDto customerDto) {

        boolean flag = false;
        Accountsdto accountsDto = customerDto.getAccountsdto();
        if(accountsDto!=null)
        {
            Accounts accounts = accountsRepository.findById(accountsDto.getAccountNumber())
              .orElseThrow(() -> new ResourceNotFoundException("Account","AccountNumber",
                      accountsDto.getAccountNumber().toString()));

              AccountsMapper.mapToAccounts(accounts,accountsDto);
              accounts = accountsRepository.save(accounts);


              Long customerId = accounts.getCustomerId();
              Customer customer = customerRepository.findById(customerId)
                      .orElseThrow(()-> new ResourceNotFoundException("Customer","CustomerId",customerId.toString()));

              CustomerMapper.mapToCustomer(customerDto,customer);
              customer = customerRepository.save(customer);
              flag = true;
        }
        return flag;
    }

    @Override
    public boolean deleteAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(()->new ResourceNotFoundException("Customer","MobileNumber",mobileNumber));

        accountsRepository.deleteByCustomerId(customer.getCustomerId());
        customerRepository.deleteById(customer.getCustomerId());
        return true;

    }
}