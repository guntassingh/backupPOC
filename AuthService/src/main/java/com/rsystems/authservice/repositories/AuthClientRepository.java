package com.rsystems.authservice.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rsystems.authservice.domains.AuthClientDetails;

import java.util.Optional;

@Repository
public interface AuthClientRepository extends MongoRepository<AuthClientDetails, String> {
    Optional<AuthClientDetails> findByClientId(String clientId);
}
