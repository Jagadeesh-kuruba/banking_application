package com.example.bankApplication.controller;

import com.example.bankApplication.dao.BranchDto;
import com.example.bankApplication.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bank/branch")
public class BranchController {

    @Autowired
    private BranchService branchService;

    @PostMapping("/create")
    public BranchDto createBranch(@RequestBody BranchDto branchDto){
        return branchService.createBranch(branchDto);
    }
    @PutMapping("/update")
    public BranchDto updateBranch(@RequestBody BranchDto branchDto){
        return branchService.updateBranch(branchDto);
    }

   // http://localhost:8021/bank/branch/details?branchRegNo=2
    @GetMapping("/details")
    public BranchDto getBranchDetails(@RequestParam long branchRegNo){
        return branchService.viewBranchDetails(branchRegNo);
    }

    @DeleteMapping("/delete/")
    public String deleteBranch(@PathVariable long branchRegNo){
        return branchService.deleteBranch(branchRegNo);
    }

}
