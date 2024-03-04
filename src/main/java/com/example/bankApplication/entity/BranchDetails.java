package com.example.bankApplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="branchData")
public class BranchDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long branchRegNo;
    @Column(nullable = false)
    private String BankName;
    @Column(nullable = false)
    private String branchName;
    @Column(nullable = false,unique = true)
    private String code;
    private int contactNumber;
    private String address;
}
