package com.example.bankApplication.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BranchDto {
    private long branchRegNo;
    private String BankName;
    private String branchName;
    private String code;
    private int contactNumber;
    private String address;
}
