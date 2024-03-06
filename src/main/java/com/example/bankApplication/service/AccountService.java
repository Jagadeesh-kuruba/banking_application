package com.example.bankApplication.service;

import com.example.bankApplication.dao.AccountDto;
import com.example.bankApplication.dao.DepositDto;

public interface AccountService {

    public AccountDto createAccount(AccountDto accountDto);
    public AccountDto viewAccountDetails(long accountNo);
    public String deleteAccount(long accountNo);
    public AccountDto updateAccountDetails(AccountDto accountDto);
    public DepositDto depositMoney(AccountDto accountDto);
    public String lockOrUnlockAccount(AccountDto accountDto);
    public boolean accountStatus(long accountNo);

}
