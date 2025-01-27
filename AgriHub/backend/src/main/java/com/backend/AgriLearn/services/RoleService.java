package com.backend.AgriLearn.services;

import com.backend.AgriLearn.dtos.RoleDTO;
import com.backend.AgriLearn.entities.Role;
import com.backend.AgriLearn.enums.RoleType;
import com.backend.AgriLearn.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    // Create a new role
    public Role createRole(RoleDTO roleDTO) {
        if (roleRepository.existsByRoleType(roleDTO.getRoleType())) {
            throw new RuntimeException("Role with type '" + roleDTO.getRoleType() + "' already exists.");
        }

        Role role = new Role();
        role.setRoleType(roleDTO.getRoleType());
        role.setDescription(roleDTO.getDescription());

        return roleRepository.save(role);
    }

    // Get all roles
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    // Get a role by ID
    public Optional<Role> getRoleByID(int roleID) {
        return roleRepository.findById(roleID);
    }

    // Get a role by type
    public Optional<Role> getRoleByType(RoleType roleType) {
        return roleRepository.findByRoleType(roleType);
    }

    // Update a role
    public Role updateRole(int roleID, RoleDTO roleDTO) {
        Optional<Role> existingRole = roleRepository.findById(roleID);
        if (existingRole.isPresent()) {
            Role role = existingRole.get();
            role.setRoleType(roleDTO.getRoleType());
            role.setDescription(roleDTO.getDescription());

            return roleRepository.save(role);
        } else {
            throw new RuntimeException("Role with ID '" + roleID + "' not found.");
        }
    }

    // Delete a role
    public void deleteRole(int roleID) {
        if (roleRepository.existsById(roleID)) {
            roleRepository.deleteById(roleID);
        } else {
            throw new RuntimeException("Role with ID '" + roleID + "' not found.");
        }
    }













}
