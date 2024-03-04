package com.example.bankApplication.mapper;

import com.example.bankApplication.dao.BranchDto;
import com.example.bankApplication.entity.BranchDetails;

public class BranchMapper {
    public static BranchDetails toBranchDetails(BranchDto branchDto){
        return new BranchDetails(
                branchDto.getBranchRegNo(),
                branchDto.getBankName(),
                branchDto.getBranchName(),
                branchDto.getCode(),
                branchDto.getContactNumber(),
                branchDto.getAddress()
                );
    }
    public static BranchDto toBranchDto(BranchDetails branchDetails){
        return new BranchDto(
                branchDetails.getBranchRegNo(),
                branchDetails.getBankName(),
                branchDetails.getBranchName(),
                branchDetails.getCode(),
                branchDetails.getContactNumber(),
                branchDetails.getAddress()
        );
    }
}
