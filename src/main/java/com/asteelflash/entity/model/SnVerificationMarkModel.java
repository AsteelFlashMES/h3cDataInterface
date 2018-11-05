package com.asteelflash.entity.model;

import java.sql.Timestamp;

/**
 * Created by hunter.fei on 2018/8/3.
 */
public class SnVerificationMarkModel {

 private String order_number;
 private String field2;
 private String serial_number;
 private String uda_9;
 private Timestamp complete_time;

  public String getOrder_number() {
    return order_number;
  }

  public void setOrder_number(String order_number) {
    this.order_number = order_number;
  }

  public String getField2() {
    return field2;
  }

  public void setField2(String field2) {
    this.field2 = field2;
  }

  public String getSerial_number() {
    return serial_number;
  }

  public void setSerial_number(String serial_number) {
    this.serial_number = serial_number;
  }

  public String getUda_9() {
    return uda_9;
  }

  public void setUda_9(String uda_9) {
    this.uda_9 = uda_9;
  }

  public Timestamp getComplete_time() {
    return complete_time;
  }

  public void setComplete_time(Timestamp complete_time) {
    this.complete_time = complete_time;
  }

  public SnVerificationMarkModel() {
  }

  public SnVerificationMarkModel(String order_number, String field2, String serial_number,
      String uda_9, Timestamp complete_time) {
    this.order_number = order_number;
    this.field2 = field2;
    this.serial_number = serial_number;
    this.uda_9 = uda_9;
    this.complete_time = complete_time;
  }
}
