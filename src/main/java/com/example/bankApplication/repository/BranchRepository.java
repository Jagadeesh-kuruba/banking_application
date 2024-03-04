package com.example.bankApplication.repository;

import com.example.bankApplication.entity.BranchDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends JpaRepository<BranchDetails,Long> {
}
