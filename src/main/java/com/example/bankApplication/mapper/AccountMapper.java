package com.example.bankApplication.mapper;

import com.example.bankApplication.dao.AccountDto;
import com.example.bankApplication.entity.Account;

public class AccountMapper {
    public static Account mapToAccount(AccountDto accountDto){
        return new Account(accountDto.getAccountNo(),
                accountDto.getAccountHolderName(),
                accountDto.getAddress(),
                accountDto.getUniqueRefId(),
                accountDto.getBalance(),
                accountDto.getMobileNo(),
                accountDto.getDob(),
                accountDto.getAccountStatus());
    }

    public static AccountDto mapToAccountDto(Account account){
        return new AccountDto(account.getAccountNo(),
                account.getAccountHolderName(),
                account.getAddress(),
                account.getUniqueRefId(),
                account.getBalance(),
                account.getMobileNo(),
                account.getDob(),
                account.getAccountStatus());
    }
}
