package com.disney.disneyproject.securityBad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.disney.disneyproject.securityBad.entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserName(String userName);
    boolean existsByUserName(String userName);
}
