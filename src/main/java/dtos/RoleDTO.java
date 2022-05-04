package dtos;

import entities.Role;
import entities.User;

import java.util.ArrayList;
import java.util.List;

public class RoleDTO {
    private String roleName;
    private List<UserDTO> users = new ArrayList<>();

    public RoleDTO() {
    }

    public RoleDTO(Role role) {
        this.roleName = role.getRoleName();

        for(User user : role.getUsers()){
            users.add(new UserDTO(user));
        }
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
