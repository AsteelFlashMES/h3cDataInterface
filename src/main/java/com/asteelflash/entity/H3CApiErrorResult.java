package com.asteelflash.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by hunter.fei on 2018/10/16.
 */
@Entity
@Table(name = "H3C_Api_Error_Result")
public class H3CApiErrorResult extends BaseEntity {

  @Column(name = "msg")
  private String msg;
  @Column(name = "exception")
  private String exception;
  @Column(name = "apiName")
  private String apiName;
  @Column(name = "runTime")
  private String runTime;
  @Column(name = "failQty")
  private int failQty;


  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public String getException() {
    return exception;
  }

  public void setException(String exception) {
    this.exception = exception;
  }

  public String getApiName() {
    return apiName;
  }

  public void setApiName(String apiName) {
    this.apiName = apiName;
  }

  public String getRunTime() {
    return runTime;
  }

  public void setRunTime(String runTime) {
    this.runTime = runTime;
  }

  public int getFailQty() {
    return failQty;
  }

  public void setFailQty(int failQty) {
    this.failQty = failQty;
  }
}
