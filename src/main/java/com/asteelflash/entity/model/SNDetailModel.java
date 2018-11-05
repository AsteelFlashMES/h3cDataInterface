package com.asteelflash.entity.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * Created by hunter.fei on 2018/6/15.
 * process used
 */
public class SNDetailModel implements Serializable {

  private BigInteger tobj_history_key;
  private String serial_number;
  private String order_number;
  private String op_name;
  private String complete_reason;
  private Integer complete_count;
  private String defect;
  private Timestamp complete_time;
  private String part_revision;
  private String line;
  private String part_number;
  private String route_name;
//  private String complete_user_name;
//  private String symptomcode;
//  private String uda_9;
//  private String tobj_key;
//  private String equip1;


  public BigInteger getTobj_history_key() {
    return tobj_history_key;
  }

  public void setTobj_history_key(BigInteger tobj_history_key) {
    this.tobj_history_key = tobj_history_key;
  }

  public String getOrder_number() {
    return order_number;
  }

  public void setOrder_number(String order_number) {
    this.order_number = order_number;
  }

  public String getSerial_number() {
    return serial_number;
  }

  public void setSerial_number(String serial_number) {
    this.serial_number = serial_number;
  }

  public String getOp_name() {
    return op_name;
  }

  public void setOp_name(String op_name) {
    this.op_name = op_name;
  }

  public String getComplete_reason() {
    return complete_reason;
  }

  public void setComplete_reason(String complete_reason) {
    this.complete_reason = complete_reason;
  }

  public Integer getComplete_count() {
    return complete_count;
  }

  public void setComplete_count(Integer complete_count) {
    this.complete_count = complete_count;
  }

  public String getDefect() {
    return defect;
  }

  public void setDefect(String defect) {
    this.defect = defect;
  }

  public Timestamp getComplete_time() {
    return complete_time;
  }

  public void setComplete_time(Timestamp complete_time) {
    this.complete_time = complete_time;
  }

  public String getPart_revision() {
    return part_revision;
  }

  public void setPart_revision(String part_revision) {
    this.part_revision = part_revision;
  }

  public String getLine() {
    return line;
  }

  public void setLine(String line) {
    this.line = line;
  }

  public String getPart_number() {
    return part_number;
  }

  public void setPart_number(String part_number) {
    this.part_number = part_number;
  }

  public String getRoute_name() {
    return route_name;
  }

  public void setRoute_name(String route_name) {
    this.route_name = route_name;
  }

  public SNDetailModel() {
  }

  public SNDetailModel(BigInteger tobj_history_key, String serial_number, String order_number,
      String op_name, String complete_reason, Integer complete_count, String defect,
      Timestamp complete_time, String part_revision, String line, String part_number,
      String route_name) {
    this.tobj_history_key = tobj_history_key;
    this.serial_number = serial_number;
    this.order_number = order_number;
    this.op_name = op_name;
    this.complete_reason = complete_reason;
    this.complete_count = complete_count;
    this.defect = defect;
    this.complete_time = complete_time;
    this.part_revision = part_revision;
    this.line = line;
    this.part_number = part_number;
    this.route_name = route_name;
  }
}
