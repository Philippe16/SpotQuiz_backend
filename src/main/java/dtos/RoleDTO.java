package dtos;

import entities.Role;

public class RoleDTO {
    private String roleName;

    public RoleDTO() {
    }

    public RoleDTO(Role role) {
        this.roleName = role.getRoleName();
    }


    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
