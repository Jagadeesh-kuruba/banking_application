package com.example.bankApplication.repository;

import com.example.bankApplication.entity.PinChange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PinRepository extends JpaRepository<PinChange,Long> {
}
