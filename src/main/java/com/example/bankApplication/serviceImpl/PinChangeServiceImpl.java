package com.example.bankApplication.serviceImpl;

import com.example.bankApplication.entity.Account;
import com.example.bankApplication.entity.PinChange;
import com.example.bankApplication.repository.AccountRepository;
import com.example.bankApplication.repository.PinRepository;
import com.example.bankApplication.service.PinChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PinChangeServiceImpl implements PinChangeService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private PinRepository pinRepository;
    @Override
    public String CreatePin(PinChange pinChange) {
        if(accountRepository.existsById(pinChange.getAccountNo())){
            Optional<Account> existedAccDtls = accountRepository.findById(pinChange.getAccountNo());
            String output ="";
            if(existedAccDtls.isPresent()){
                if(pinChange.getOldPin().equals(existedAccDtls.get().getDob())){
                    pinRepository.save(pinChange);
                    output = "pin is created successfully";
                }else{
                    output = "Date of Birth is not matching";
                }
            }else{
                output = "No data found";
            }
            return output;

        }else{
            return "Invalid account No";
        }
    }

    @Override
    public String changePin(PinChange pinChange) {

        if(pinRepository.existsById(pinChange.getAccountNo())){
            Optional<PinChange> existedPinDtls = pinRepository.findById(pinChange.getAccountNo());
            String output ="";
            if(existedPinDtls.isPresent()){
                if(pinChange.getOldPin().equals(existedPinDtls.get().getNewPin())){
                    pinRepository.save(pinChange);
                    output = "pin changed successfully";
                }else{
                    output = "Incorrect Old Pin";
                }
            }else{
                output = "No data found";
            }
            return output;

        }else{
            return "Invalid account No";
        }
    }

}
