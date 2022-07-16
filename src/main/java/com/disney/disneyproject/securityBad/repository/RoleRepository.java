package com.disney.disneyproject.securityBad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.disney.disneyproject.securityBad.entities.Role;
import com.disney.disneyproject.securityBad.enums.RoleList;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByRoleName(RoleList roleName);
}
