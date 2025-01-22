package com.backend.AgriLearn.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleID;

    @Column(nullable = false, unique = true)
    private String roleName;

    @Column(length = 5000)
    private String roleDescription;

    public Role() {
    }

    public Role(Long roleID, String roleName, String roleDescription) {
        this.roleID = roleID;
        this.roleName = roleName;
        this.roleDescription = roleDescription;
    }

    public Long getRoleID() {
        return roleID;
    }

    public void setRoleID(Long roleID) {
        this.roleID = roleID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
}
