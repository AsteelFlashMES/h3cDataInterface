package com.asteelflash.entity.model;

import java.sql.Timestamp;

/**
 * Created by hunter.fei on 2018/8/7.
 */
public class SnImeiModel {

  private String serial_number;
  private String component_SN;
  private Timestamp creation_time;

  public String getSerial_number() {
    return serial_number;
  }

  public void setSerial_number(String serial_number) {
    this.serial_number = serial_number;
  }

  public String getComponent_SN() {
    return component_SN;
  }

  public void setComponent_SN(String component_SN) {
    this.component_SN = component_SN;
  }

  public Timestamp getCreation_time() {
    return creation_time;
  }

  public void setCreation_time(Timestamp creation_time) {
    this.creation_time = creation_time;
  }

  public SnImeiModel() {
  }

  public SnImeiModel(String serial_number, String component_SN, Timestamp creation_time) {
    this.serial_number = serial_number;
    this.component_SN = component_SN;
    this.creation_time = creation_time;
  }
}
