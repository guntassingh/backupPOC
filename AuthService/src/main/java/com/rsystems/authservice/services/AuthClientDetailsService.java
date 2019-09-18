package com.rsystems.authservice.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.stereotype.Service;

import com.rsystems.authservice.repositories.AuthClientRepository;

@Service
public class AuthClientDetailsService implements ClientDetailsService {
	
	@Autowired
    private  AuthClientRepository authClientRepository;

   

    @Override
    public ClientDetails loadClientByClientId(String clientId) {
        return authClientRepository.findByClientId(clientId).orElseThrow(IllegalArgumentException::new);
    }
}
