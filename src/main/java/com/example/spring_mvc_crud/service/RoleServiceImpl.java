package com.example.spring_mvc_crud.service;

import com.example.spring_mvc_crud.model.Role;
import com.example.spring_mvc_crud.repositories.RoleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Transactional
@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public void saveRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    @Transactional(readOnly = true)
    public Role findRoleByName(String roleName) {
        return roleRepository.findByName(Role.ALLNAMES.valueOf(roleName));
    }

    @Override
    public Set<Role> getRolesSetByUserName(Set<Role> userRoles, List<String> roleNames) {
        Set<Role> roles;
        roles = new HashSet<>();
        for (String roleName : roleNames) {
            Optional<Role> role = Optional.ofNullable(this.findRoleByName(roleName));
            roles.add(role.get());
        }
        return roles;
    }
}
