package com.rsystems.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rsystems.domains.Url;


@Repository
public interface UrlRepository extends JpaRepository<Url, String>{

}
