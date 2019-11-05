package com.universe.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.universe.entity.User;

/**
 * @author 刘亚楼
 * @date 2019/11/5
 */
@Repository
public class CustomUserRepositoryImpl {

  @PersistenceContext
  private EntityManager entityManager;

  public User getUserByUsernameUsingNativeQuery(String username) {
    String sql = "select user_id,username,password from tbl_user where username = ?1";
    // 实体必须包含id且实体属性和结果集必须一一对应，实体属性不能多也不能少
    Query query = entityManager.createNativeQuery(sql, User.class);
    query.setParameter(1, username);
    return (User) query.getSingleResult();
  }

}
