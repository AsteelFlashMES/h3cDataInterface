package com.asteelflash.entity.model;

import java.sql.Timestamp;

/**
 * Created by hunter.fei on 2018/8/3.
 */
public class ZcbPcbRelationModel {
  private String part_serial;
  private String serial_number;
  private Timestamp last_modified_time;
  private String status;

  public String getPart_serial() {
    return part_serial;
  }

  public void setPart_serial(String part_serial) {
    this.part_serial = part_serial;
  }

  public String getSerial_number() {
    return serial_number;
  }

  public void setSerial_number(String serial_number) {
    this.serial_number = serial_number;
  }

  public Timestamp getLast_modified_time() {
    return last_modified_time;
  }

  public void setLast_modified_time(Timestamp last_modified_time) {
    this.last_modified_time = last_modified_time;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public ZcbPcbRelationModel() {
  }

  public ZcbPcbRelationModel(String part_serial, String serial_number,
      Timestamp last_modified_time, String status) {
    this.part_serial = part_serial;
    this.serial_number = serial_number;
    this.last_modified_time = last_modified_time;
    this.status = status;
  }
}
