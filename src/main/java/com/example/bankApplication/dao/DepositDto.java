package com.example.bankApplication.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DepositDto {
    private long accountNo;
    private String response;
    private double balance;
}
