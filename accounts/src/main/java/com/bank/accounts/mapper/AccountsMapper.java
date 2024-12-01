package com.bank.accounts.mapper;

import com.bank.accounts.dto.*;
import com.bank.accounts.entity.*;

public class AccountsMapper {


    public static Accountsdto mapToAccountDto(Accounts accounts, Accountsdto accountsdto)
    {
        accountsdto.setAccountNumber(accounts.getAccountNumber());
        accountsdto.setAccountType(accounts.getAccountType());
        accountsdto.setBranchAddress(accounts.getBranchAddress());
        return accountsdto;
    }

    public static Accounts mapToAccounts(Accounts accounts, Accountsdto accountsdto)
    {
        accounts.setAccountNumber(accountsdto.getAccountNumber());
        accounts.setAccountType(accountsdto.getAccountType());
        accounts.setBranchAddress(accountsdto.getBranchAddress());
        return accounts;
    }
}
