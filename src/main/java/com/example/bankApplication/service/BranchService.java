package com.example.bankApplication.service;

import com.example.bankApplication.dao.BranchDto;

public interface BranchService {
    public BranchDto createBranch(BranchDto branchDto);
    public BranchDto updateBranch(BranchDto branchDto);
    public String deleteBranch(long branchRegNo);
    public BranchDto viewBranchDetails(long branchRegNo);
}
