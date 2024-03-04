package com.example.bankApplication.controller;

import com.example.bankApplication.dao.AccountDto;
import com.example.bankApplication.dao.DepositDto;
import com.example.bankApplication.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bank/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/create")
    public ResponseEntity<AccountDto> createNewAccount(@RequestBody AccountDto accountDto){
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<AccountDto> updateActDetails(@RequestBody AccountDto accountDto){
        return new ResponseEntity<>(accountService.updateAccountDetails(accountDto),HttpStatus.OK);
    }

    @GetMapping("/details/{accountNo}")
    public ResponseEntity<AccountDto> getAccountDetails(@PathVariable long accountNo){
        return new ResponseEntity<>(accountService.viewAccountDetails(accountNo),HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteAccount(@RequestParam("accountNo") long accountNo){
        return new ResponseEntity<>(accountService.deleteAccount(accountNo),HttpStatus.OK);
    }

    @PostMapping("/deposit")
    public ResponseEntity<DepositDto> depositMoney(@RequestBody AccountDto accountDto){
        return new ResponseEntity<>(accountService.depositMoney(accountDto),HttpStatus.OK);
    }
}
