package com.backend.User.repositories;

import com.backend.User.entities.Role;
import com.backend.User.enums.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    // Find a role by its type
    Optional<Role> findByRoleType(RoleType roleType);

    // Check if a role exists by its type
    boolean existsByRoleType(RoleType roleType);

    // Find all roles by a list of role types
    List<Role> findByRoleTypeIn(List<RoleType> roleTypes);

    // Find a role by its ID
    Optional<Role> findById(int roleID);

    // Find all roles
    List<Role> findAll();

    // Delete a role by its type
    void deleteByRoleType(RoleType roleType);

    // Count the number of roles by type
    long countByRoleType(RoleType roleType);
}