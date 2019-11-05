package com.universe.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.universe.Application;
import com.universe.repository.CustomUserRepositoryImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class CustomUserRepositoryImplTest {

  @Autowired
  private CustomUserRepositoryImpl userRepository;

  @Test
  public void getUserByUsername() {
    System.err.println(userRepository.getUserByUsernameUsingNativeQuery("root"));
  }

}
