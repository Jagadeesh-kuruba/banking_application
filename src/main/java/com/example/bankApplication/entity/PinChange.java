package com.example.bankApplication.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name ="passwords")
public class PinChange {
    @Id
    @Column(nullable = false,unique = true)
    private long accountNo;
    @Column(nullable = false)
    private String oldPin;
    @Column(nullable = false)
    private String newPin;
    @Column(nullable = false)
    private String confirmPin;
}
