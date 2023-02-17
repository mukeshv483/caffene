package com.security.securitydemo.repository;

import com.security.securitydemo.models.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@CacheConfig(cacheNames = "user-cache")
public interface UserRepository extends JpaRepository<User, Long> {
    @Cacheable(unless = "#result==null")
    User findByEmail(String email);
}
