package security;

import java.security.Principal;

import entities.User;

public class UserPrincipal implements Principal {

  private String username;
  private String role;

  /* Create a UserPrincipal, given the Entity class User*/
  public UserPrincipal(User user) {
    this.username = user.getUsername();
    this.role = user.getRoleAsString();
  }

  public UserPrincipal(String username, String role) {
    super();
    this.username = username;
    this.role = role;
  }

  @Override
  public String getName() {
    return username;
  }

  public boolean isUserInRole(String role) {
    return this.role.contains(role);
  }
}