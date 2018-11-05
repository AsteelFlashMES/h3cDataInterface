package com.asteelflash.entity.model;

import java.math.BigInteger;

/**
 * Created by hunter.fei on 2018/7/31.
 */
public class ProdFitDefectModel {
  private BigInteger order_key;
  private String serial_number;
  private String defect;
  private String symptomcode;
  private String part_number;

  public BigInteger getOrder_key() {
    return order_key;
  }

  public void setOrder_key(BigInteger order_key) {
    this.order_key = order_key;
  }

  public String getSerial_number() {
    return serial_number;
  }

  public void setSerial_number(String serial_number) {
    this.serial_number = serial_number;
  }

  public String getDefect() {
    return defect;
  }

  public void setDefect(String defect) {
    this.defect = defect;
  }

  public String getSymptomcode() {
    return symptomcode;
  }

  public void setSymptomcode(String symptomcode) {
    this.symptomcode = symptomcode;
  }

  public String getPart_number() {
    return part_number;
  }

  public void setPart_number(String part_number) {
    this.part_number = part_number;
  }

  public ProdFitDefectModel() {
  }

  public ProdFitDefectModel(BigInteger order_key, String serial_number, String defect,
      String symptomcode, String part_number) {
    this.order_key = order_key;
    this.serial_number = serial_number;
    this.defect = defect;
    this.symptomcode = symptomcode;
    this.part_number = part_number;
  }
}
