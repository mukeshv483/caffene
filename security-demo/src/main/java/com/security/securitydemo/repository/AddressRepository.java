package com.security.securitydemo.repository;

import com.security.securitydemo.models.Address;
import com.security.securitydemo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
