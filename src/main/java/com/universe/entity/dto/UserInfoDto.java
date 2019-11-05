package com.universe.entity.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserInfoDto {

  @Id
  @Column(name = "user_id")
  private Integer userId;

  @Column
  private String username;

  @Column
  private String password;

  public UserInfoDto(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "UserInfo [userId=" + userId + ", username=" + username + ", password=" + password + "]";
  }

}
