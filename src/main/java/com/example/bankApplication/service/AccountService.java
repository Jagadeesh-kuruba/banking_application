package com.example.bankApplication.service;

import com.example.bankApplication.dao.AccountDto;
import com.example.bankApplication.dao.DepositDto;
import com.example.bankApplication.entity.Account;

public interface AccountService {

    public AccountDto createAccount(AccountDto accountDto);
    public AccountDto viewAccountDetails(long accountNo);
    public String deleteAccount(long accountNo);
    public AccountDto updateAccountDetails(AccountDto accountDto);
    public DepositDto depositMoney(AccountDto accountDto);
}
