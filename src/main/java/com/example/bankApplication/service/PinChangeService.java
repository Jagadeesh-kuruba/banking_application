package com.example.bankApplication.service;

import com.example.bankApplication.entity.PinChange;

public interface PinChangeService {
    public String CreatePin(PinChange pinChange);
    public String changePin(PinChange pinChange);
}
