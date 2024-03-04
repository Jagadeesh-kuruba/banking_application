package com.example.bankApplication.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {

    private long accountNo;
    private String accountHolderName;
    private String address;
    private String uniqueRefId;
    private double balance;
    private int mobileNo;
    private String dob;
    private String accountStatus;
}
