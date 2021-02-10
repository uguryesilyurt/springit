package com.ugur.springit.service;

import com.ugur.springit.domain.Role;
import com.ugur.springit.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role findByName(String name){
        return roleRepository.findByName(name);
    }
}
