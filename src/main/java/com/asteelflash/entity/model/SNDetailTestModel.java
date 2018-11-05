package com.asteelflash.entity.model;

import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * Created by hunter.fei on 2018/8/13.
 */
public class SNDetailTestModel {

  private BigInteger tobj_history_key;
  private String serial_number;
  private String order_number;
  private String op_name;
  private String complete_reason;
  private Integer complete_count;
  private String complete_user_name;
  private String symptomcode;
  private Timestamp complete_time;
  private String uda_9;
  private BigInteger tobj_key;
  private String Line;
  private String equip_1;

  public BigInteger getTobj_history_key() {
    return tobj_history_key;
  }

  public void setTobj_history_key(BigInteger tobj_history_key) {
    this.tobj_history_key = tobj_history_key;
  }

  public String getSerial_number() {
    return serial_number;
  }

  public void setSerial_number(String serial_number) {
    this.serial_number = serial_number;
  }

  public String getOrder_number() {
    return order_number;
  }

  public void setOrder_number(String order_number) {
    this.order_number = order_number;
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

  public String getComplete_user_name() {
    return complete_user_name;
  }

  public void setComplete_user_name(String complete_user_name) {
    this.complete_user_name = complete_user_name;
  }

  public String getSymptomcode() {
    return symptomcode;
  }

  public void setSymptomcode(String symptomcode) {
    this.symptomcode = symptomcode;
  }

  public Timestamp getComplete_time() {
    return complete_time;
  }

  public void setComplete_time(Timestamp complete_time) {
    this.complete_time = complete_time;
  }

  public String getUda_9() {
    return uda_9;
  }

  public void setUda_9(String uda_9) {
    this.uda_9 = uda_9;
  }

  public BigInteger getTobj_key() {
    return tobj_key;
  }

  public void setTobj_key(BigInteger tobj_key) {
    this.tobj_key = tobj_key;
  }

  public String getLine() {
    return Line;
  }

  public void setLine(String line) {
    Line = line;
  }

  public String getEquip_1() {
    return equip_1;
  }

  public void setEquip_1(String equip_1) {
    this.equip_1 = equip_1;
  }

  public SNDetailTestModel() {
  }

  public SNDetailTestModel(BigInteger tobj_history_key, String serial_number,
      String order_number, String op_name, String complete_reason, Integer complete_count,
      String complete_user_name, String symptomcode, Timestamp complete_time, String uda_9,
      BigInteger tobj_key, String line, String equip_1) {
    this.tobj_history_key = tobj_history_key;
    this.serial_number = serial_number;
    this.order_number = order_number;
    this.op_name = op_name;
    this.complete_reason = complete_reason;
    this.complete_count = complete_count;
    this.complete_user_name = complete_user_name;
    this.symptomcode = symptomcode;
    this.complete_time = complete_time;
    this.uda_9 = uda_9;
    this.tobj_key = tobj_key;
    this.Line = line;
    this.equip_1 = equip_1;
  }
}
