package com.disney.disneyproject.securityBad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.disney.disneyproject.securityBad.entities.Role;
import com.disney.disneyproject.securityBad.enums.RoleList;
import com.disney.disneyproject.securityBad.repository.RoleRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository){
        this.roleRepository=roleRepository;
    }
    public Optional<Role> GetByRoleName(RoleList roleName){
        return roleRepository.findByRoleName(roleName);
    }


}
