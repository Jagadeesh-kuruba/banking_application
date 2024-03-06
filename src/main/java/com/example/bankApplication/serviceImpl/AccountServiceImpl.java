package com.example.bankApplication.serviceImpl;

import com.example.bankApplication.dao.AccountDto;
import com.example.bankApplication.dao.DepositDto;
import com.example.bankApplication.entity.Account;
import com.example.bankApplication.mapper.AccountMapper;
import com.example.bankApplication.repository.AccountRepository;
import com.example.bankApplication.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Override
    public AccountDto createAccount(AccountDto accountDto) {

        Account account = AccountMapper.mapToAccount(accountDto);
        Account saveAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(saveAccount);
    }

    @Override
    public AccountDto viewAccountDetails(long accountNo) {
        Optional<Account> account = accountRepository.findById(accountNo);
        return account.map(AccountMapper::mapToAccountDto).orElse(null);
    }

    @Override
    public String deleteAccount(long accountNo) {

        if(accountRepository.existsById(accountNo)){
            accountRepository.deleteById(accountNo);
            return accountNo+" is deleted successfully";
        }else{
            return accountNo+" is does not exits";
        }

    }

    @Override
    public AccountDto updateAccountDetails(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account saveAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(saveAccount);
    }

    @Override
    public DepositDto depositMoney(AccountDto accountDto) {
        if(accountDto.getAccountNo()>0 && accountDto.getBalance()>0){
            Optional<Account> account;
            if(accountRepository.existsById(accountDto.getAccountNo())){
                account = accountRepository.findById(accountDto.getAccountNo());
                if(account.isPresent()) {
                    double amount = account.get().getBalance() + accountDto.getBalance();
                    account.get().setBalance(amount);
                    accountRepository.save(account.get());
                    return new DepositDto(account.get().getAccountNo(),
                            "Balance updated successfully",
                            account.get().getBalance());
                }else{
                    return new DepositDto(accountDto.getAccountNo(),
                            "Data is not present for this account",
                            accountDto.getBalance());
                }
            }else{
                return new DepositDto(accountDto.getAccountNo(),
                        "Account Number is not existed ",
                        accountDto.getBalance());
            }

        }else{
            return new DepositDto(accountDto.getAccountNo(),
                    "Enter account No or Amount ",
                    accountDto.getBalance());
        }
    }
    @Override
    public String lockOrUnlockAccount(AccountDto accountDto) {
        if(accountRepository.existsById(accountDto.getAccountNo())){
            Optional<Account> account= accountRepository.findById(accountDto.getAccountNo());
            if(account.isPresent()){
                account.get().setAccountStatus(accountDto.getAccountStatus());
                accountRepository.save(account.get());
                return "Account status is changes to"+accountDto.getAccountStatus()+"successfully";
            }else{
                return "NO Data Found";
            }
        }else{
            return "Invalid account No";
        }
    }

    @Override
    public boolean accountStatus(long accountNo) {
        if (accountRepository.existsById(accountNo)) {
            Optional<Account> account = accountRepository.findById(accountNo);
            if (account.isPresent()) {
                if (account.get().getAccountStatus().equalsIgnoreCase("opened")) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
