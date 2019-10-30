package com.universe.repository.spec;

import org.springframework.data.jpa.domain.Specification;

import com.universe.entity.User;

public abstract class UserSpecificationFactory {

  public static Specification<User> isUserStatusNormal() {
    return (root, query, builder) -> {
      // 查出状态为0的
      return builder.equal(root.get("status"), "0");
    };
  }
}
