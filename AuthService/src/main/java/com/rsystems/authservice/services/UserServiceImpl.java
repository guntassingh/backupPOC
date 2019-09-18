package com.rsystems.authservice.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rsystems.authservice.domains.User;
import com.rsystems.authservice.enums.Authorities;
import com.rsystems.authservice.repositories.UserRepository;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
	private  PasswordEncoder passwordEncoder;
    
    @Autowired
    private  UserRepository userRepository;

	/*
	 * public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository
	 * userRepository) { this.passwordEncoder = passwordEncoder; this.userRepository
	 * = userRepository; }
	 */
    @Override
    public User create(User user) {
        throwIfUsernameExists(user.getUsername());

        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        user.setActivated(Boolean.TRUE); // TODO send sms or email with code for activation
        user.setAuthorities(new HashSet<>(Collections.singletonList(Authorities.ROLE_USER)));

        // TODO other routines on account creation

        return userRepository.save(user);
    }

    private void throwIfUsernameExists(String username) {
        Optional<User> existingUser = userRepository.findByUsername(username);
        existingUser.ifPresent((user) -> {
            throw new IllegalArgumentException("User not available");
        });
    }

}
