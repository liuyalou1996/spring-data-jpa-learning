package com.universe.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_operation_log")
public class OperationLog {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private Integer opType;
  private String opContent;
  private Integer userId;
  private Date createTime;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getOpType() {
    return opType;
  }

  public void setOpType(Integer opType) {
    this.opType = opType;
  }

  public String getOpContent() {
    return opContent;
  }

  public void setOpContent(String opContent) {
    this.opContent = opContent;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  @Override
  public String toString() {
    return "OperationLog [id=" + id + ", opType=" + opType + ", opContent=" + opContent + ", userId=" + userId + ", createTime="
        + createTime + "]";
  }

}
