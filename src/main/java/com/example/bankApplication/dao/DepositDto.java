package com.example.bankApplication.dao;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class DepositDto {
    private long accountNo;
    private String response;
    private double balance;
}
