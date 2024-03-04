package com.example.bankApplication.controller;

import com.example.bankApplication.entity.PinChange;
import com.example.bankApplication.service.PinChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account/pin")
public class PinController {
    @Autowired
    private PinChangeService pinChangeService;

    @PostMapping("/create")
    public String createPin(@RequestBody PinChange pinChange){
        if(pinChange.getAccountNo()>0 && (pinChange.getOldPin()!=null && !pinChange.getOldPin().isEmpty())
          && (pinChange.getNewPin()!=null && !pinChange.getNewPin().isEmpty()) && (pinChange.getConfirmPin()!=null && !pinChange.getConfirmPin().isEmpty()) ){
            if(pinChange.getNewPin().equals(pinChange.getConfirmPin())){
                return pinChangeService.CreatePin(pinChange);
            }else{
                return "new pin is not matching with confirm pin";
            }
        }else{
            return "fields are null or empty in PinChange Json";
        }
    }

    @PutMapping("/change")
    public String pinChange(@RequestBody PinChange pinChange){

        if(pinChange.getAccountNo()>0 && (pinChange.getOldPin()!=null && !pinChange.getOldPin().isEmpty())
                && (pinChange.getNewPin()!=null && !pinChange.getNewPin().isEmpty()) && (pinChange.getConfirmPin()!=null && !pinChange.getConfirmPin().isEmpty()) ){
            if(pinChange.getNewPin().equals(pinChange.getConfirmPin())){
                return pinChangeService.changePin(pinChange);
            }else{
                return "new pin is not matching with confirm pin";
            }
        }else{
            return "fields are null or empty in PinChange Json";
        }

    }
}
