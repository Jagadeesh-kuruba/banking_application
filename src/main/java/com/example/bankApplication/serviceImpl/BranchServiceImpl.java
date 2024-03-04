package com.example.bankApplication.serviceImpl;

import com.example.bankApplication.dao.BranchDto;
import com.example.bankApplication.entity.BranchDetails;
import com.example.bankApplication.mapper.BranchMapper;
import com.example.bankApplication.repository.BranchRepository;
import com.example.bankApplication.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BranchServiceImpl implements BranchService {

    @Autowired
    private BranchRepository branchRepository;
    @Override
    public BranchDto createBranch(BranchDto branchDto) {
      BranchDetails branchDetails= branchRepository.save(BranchMapper.toBranchDetails(branchDto));
      return BranchMapper.toBranchDto(branchDetails);
    }

    @Override
    public BranchDto updateBranch(BranchDto branchDto) {
        if(branchRepository.existsById(branchDto.getBranchRegNo()))
        {
            BranchDetails branchDetails= branchRepository.save(BranchMapper.toBranchDetails(branchDto));
            return BranchMapper.toBranchDto(branchDetails);
        }
        return null;
    }

    @Override
    public String deleteBranch(long branchRegNo) {
        if (branchRepository.existsById(branchRegNo)) {
            branchRepository.deleteById(branchRegNo);
            return "Branch is deleted successfully";
        }else{
            return "Branch details are not present";
        }
    }

    @Override
    public BranchDto viewBranchDetails(long branchRegNo) {
        Optional<BranchDetails> branchDetails = branchRepository.findById(branchRegNo);
        return branchDetails.map(BranchMapper::toBranchDto).orElseGet(BranchDto::new);
    }
}
