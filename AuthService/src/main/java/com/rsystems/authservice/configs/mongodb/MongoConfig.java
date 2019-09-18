package com.rsystems.authservice.configs.mongodb;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.rsystems.authservice.repositories")
public class MongoConfig {

}
