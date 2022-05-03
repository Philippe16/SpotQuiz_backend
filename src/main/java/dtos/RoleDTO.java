package dtos;

import entities.Role;
import entities.User;
import dtos.UserDTO;

import java.util.List;

public class RoleDTO {


    private String roleName;
    private List<UserDTO> users;

    public RoleDTO() {
    }

    public RoleDTO(Role role) {
        this.roleName = role.getRoleName();
        this.users = role.getUsers();
    }


    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }
}
