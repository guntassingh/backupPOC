package com.rsystems.accountService.service;

import com.rsystems.accountService.dto.UserDto;
import com.rsystems.accountService.dto.UserRegistrationDto;

public interface AccountService {

    /**
     * Invokes Auth Service user creation
     *
     * @param user
     * @return created account
     */
    UserDto create(UserRegistrationDto user);
}
