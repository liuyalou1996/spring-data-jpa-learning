package com.universe.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.universe.entity.User;
import com.universe.entity.UserDuplicate;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

  @Query("select u from User u where u.username = ?1")
  User getUserByUsername(String username);

  /**
   * 使用map接收时必须指定别名，否则返回的key从0开始
   * @param status
   * @return
   */
  @Query("select new map(userId as userId, username as username, password as password, salt as salt, status as status) from User where status = ?1")
  List<Map<String, Object>> listUsers(String status);

  /**
   * 使用其它对象接收时必须执行创建相应的构造器
   * @return
   */
  @Query("select new com.universe.entity.UserDuplicate(username, password) from User where userId = ?1")
  UserDuplicate getUserByUserId(Integer userId);
}
