package com.rsystems.accountService.service;


import org.springframework.stereotype.Service;

import com.rsystems.accountService.client.AuthServiceFeignClient;
import com.rsystems.accountService.dto.UserDto;
import com.rsystems.accountService.dto.UserRegistrationDto;

@Service
public class AccountServiceImpl implements AccountService {

    private final AuthServiceFeignClient authServiceFeignClient;

    public AccountServiceImpl(AuthServiceFeignClient authServiceFeignClient) {
        this.authServiceFeignClient = authServiceFeignClient;
    }

    @Override
    public UserDto create(UserRegistrationDto user) {
        return authServiceFeignClient.createUser(user);
    }
}
