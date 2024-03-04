package com.example.bankApplication.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long accountNo;
    @Column(nullable = false)
    private String accountHolderName;
    private String address;
    @Column(name="uniqueRefId",unique = true,nullable = false)
    private String uniqueRefId;
    @Column(nullable = false)
    private double balance;
    @Column(nullable = false,unique = true)
    private int mobileNo;
    @Column(nullable = false)
    private String dob;
    @Column(nullable = false)
    private String accountStatus;
}
