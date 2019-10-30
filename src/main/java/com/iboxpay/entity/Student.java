package com.iboxpay.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * The class Student.
 *
 * Description:
 * 加上Entity注解会被搜寻的实体类
 * @author: liuyalou
 * @since: 2018年3月19日
 * @version: $Revision$ $Date$ $LastChangedBy$
 *
 */
@Entity
public class Student implements Serializable {

    private static final long serialVersionUID = 81950990095421264L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer sid;
    private String name;
    private String email;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student [sid=" + sid + ", name=" + name + ", email=" + email
                + "]";
    }
}
