package com.universe.test;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import com.universe.Application;
import com.universe.entity.User;
import com.universe.repository.UserRepository;
import com.universe.repository.spec.UserSpecificationFactory;
import com.universe.util.JsonUtils;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserRepositoryTest {

  @Autowired
  private UserRepository userRepository;

  @Test
  public void listUsers() {
    System.err.println(userRepository.findAll());
  }

  @Test
  public void listUsersWithMap() {
    System.err.println(userRepository.listUsers("0"));
  }

  @Test
  public void listUsersWithOrderAndPage() {
    Sort sort = Sort.by("userId").descending();
    Pageable pageable = PageRequest.of(0, 1, sort);
    Page<User> page = userRepository.findAll(pageable);
    System.err.println(page.getContent());
  }

  @Test
  public void getUserByUsername() {
    System.err.println(userRepository.getUserByUsername("root"));
  }

  @Test
  public void getUserByUserId() {
    System.err.println(userRepository.getUserByUserId(1));
  }

  @Test
  public void getNormalUser() {
    System.err.println(userRepository.findAll(UserSpecificationFactory.isUserStatusNormal()));
  }

  @Test
  public void listUsersWithNativeSql() {
    List<Map<String, Object>> list = userRepository.listUsersWithNativeSql();
    list.forEach(map -> System.err.println(JsonUtils.toJsonString(map)));
  }

  @Test
  public void deleteUserByUserId() {
    userRepository.deleteByUserId(100);
  }

}
