package com.serviceA;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VerifyServiceImpl implements VerifyService {
    @Override
    public PersonReport verify(String name) {
        boolean isValid = false;
        if (name != null && name.equals("testuser1")) {
            isValid = true;
        }
        return new PersonReport(name, isValid);
    }
}
