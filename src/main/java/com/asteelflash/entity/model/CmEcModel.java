package com.asteelflash.entity.model;

import java.sql.Timestamp;

/**
 * Created by hunter.fei on 2018/8/7.
 */
public class CmEcModel {

  private String serial_number;
  private String EC;
  private Timestamp creation_time;
  private String remark;

  public String getSerial_number() {
    return serial_number;
  }

  public void setSerial_number(String serial_number) {
    this.serial_number = serial_number;
  }

  public String getEC() {
    return EC;
  }

  public void setEC(String EC) {
    this.EC = EC;
  }

  public Timestamp getCreation_time() {
    return creation_time;
  }

  public void setCreation_time(Timestamp creation_time) {
    this.creation_time = creation_time;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public CmEcModel() {
  }

  public CmEcModel(String serial_number, String EC, Timestamp creation_time, String remark) {
    this.serial_number = serial_number;
    this.EC = EC;
    this.creation_time = creation_time;
    this.remark = remark;
  }
}
