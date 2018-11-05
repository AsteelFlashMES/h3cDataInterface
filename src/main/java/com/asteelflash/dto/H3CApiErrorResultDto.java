package com.asteelflash.dto;

import com.asteelflash.entity.H3CApiErrorResult;
import java.util.Date;

/**
 * Created by hunter.fei on 2018/10/17.
 */
public class H3CApiErrorResultDto {

  private String msg;
  private String exception;
  private String apiName;
  private String runTime;
  private Date creationTime;

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

  public Date getCreationTime() {
    return creationTime;
  }

  public void setCreationTime(Date creationTime) {
    this.creationTime = creationTime;
  }

  public H3CApiErrorResultDto() {
  }

  public H3CApiErrorResultDto(H3CApiErrorResult h3CApiErrorResult) {
    this.apiName = h3CApiErrorResult.getApiName();
    this.creationTime = h3CApiErrorResult.getCreationTime();
    this.exception = h3CApiErrorResult.getException();
    this.msg = h3CApiErrorResult.getMsg();
    this.runTime = h3CApiErrorResult.getRunTime();
  }
}
