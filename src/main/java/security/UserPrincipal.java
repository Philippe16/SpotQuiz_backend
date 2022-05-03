package security;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import entities.User2;

public class UserPrincipal implements Principal {

  private String username;
  private String role;

  /* Create a UserPrincipal, given the Entity class User*/
  public UserPrincipal(User2 user) {
    this.username = user.getUsername();
    this.role = user.getRoleAsString();
  }

  public UserPrincipal(String username, String role) {
    super();
    this.username = username;
    this.role = role; // vil have string.. Hvis jeg laver den her til string brokker den sig i JWTauthenticationFilter og hvis jeg laver den til String[], så brokker den sig her
  }

  @Override
  public String getName() {
    return username;
  }

  public boolean isUserInRole(String role) {
    return this.role.contains(role);
  }
}