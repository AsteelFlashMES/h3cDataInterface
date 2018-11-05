package com.asteelflash.entity.model;

import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * Created by hunter.fei on 2018/8/8.
 */
public class SnLabelDataModel {
  private String serial_number;
  private String serial_number1;
  private String part_number;
  private String field4;
  private String part_revision;
  private String software_version;
  private String power_code;
  private String power_origin;
  private String QualityGrade;
  private Integer R4_Exclude;
  private String status;
  private Timestamp complete_time;
  private String PB;
  private String order_number;
  private BigInteger unit_key;
  private Integer PB_ASSIGN;
  private String PB_02Part;

  public String getSerial_number() {
    return serial_number;
  }

  public void setSerial_number(String serial_number) {
    this.serial_number = serial_number;
  }

  public String getSerial_number1() {
    return serial_number1;
  }

  public void setSerial_number1(String serial_number1) {
    this.serial_number1 = serial_number1;
  }

  public String getPart_number() {
    return part_number;
  }

  public void setPart_number(String part_number) {
    this.part_number = part_number;
  }

  public String getField4() {
    return field4;
  }

  public void setField4(String field4) {
    this.field4 = field4;
  }

  public String getPart_revision() {
    return part_revision;
  }

  public void setPart_revision(String part_revision) {
    this.part_revision = part_revision;
  }

  public String getSoftware_version() {
    return software_version;
  }

  public void setSoftware_version(String software_version) {
    this.software_version = software_version;
  }

  public String getPower_code() {
    return power_code;
  }

  public void setPower_code(String power_code) {
    this.power_code = power_code;
  }

  public String getPower_origin() {
    return power_origin;
  }

  public void setPower_origin(String power_origin) {
    this.power_origin = power_origin;
  }

  public String getQualityGrade() {
    return QualityGrade;
  }

  public void setQualityGrade(String qualityGrade) {
    QualityGrade = qualityGrade;
  }

  public Integer getR4_Exclude() {
    return R4_Exclude;
  }

  public void setR4_Exclude(Integer r4_Exclude) {
    R4_Exclude = r4_Exclude;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Timestamp getComplete_time() {
    return complete_time;
  }

  public void setComplete_time(Timestamp complete_time) {
    this.complete_time = complete_time;
  }

  public String getPB() {
    return PB;
  }

  public void setPB(String PB) {
    this.PB = PB;
  }

  public String getOrder_number() {
    return order_number;
  }

  public void setOrder_number(String order_number) {
    this.order_number = order_number;
  }

  public BigInteger getUnit_key() {
    return unit_key;
  }

  public void setUnit_key(BigInteger unit_key) {
    this.unit_key = unit_key;
  }

  public Integer getPB_ASSIGN() {
    return PB_ASSIGN;
  }

  public void setPB_ASSIGN(Integer PB_ASSIGN) {
    this.PB_ASSIGN = PB_ASSIGN;
  }

  public String getPB_02Part() {
    return PB_02Part;
  }

  public void setPB_02Part(String PB_02Part) {
    this.PB_02Part = PB_02Part;
  }

  public SnLabelDataModel() {
  }

  public SnLabelDataModel(String serial_number, String serial_number1, String part_number,
      String field4, String part_revision, String software_version, String power_code,
      String power_origin, String qualityGrade, Integer r4_Exclude, String status,
      Timestamp complete_time, String PB, String order_number, BigInteger unit_key, Integer PB_ASSIGN,
      String PB_02Part) {
    this.serial_number = serial_number;
    this.serial_number1 = serial_number1;
    this.part_number = part_number;
    this.field4 = field4;
    this.part_revision = part_revision;
    this.software_version = software_version;
    this.power_code = power_code;
    this.power_origin = power_origin;
    this.QualityGrade = qualityGrade;
    this.R4_Exclude = r4_Exclude;
    this.status = status;
    this.complete_time = complete_time;
    this.PB = PB;
    this.order_number = order_number;
    this.unit_key = unit_key;
    this.PB_ASSIGN = PB_ASSIGN;
    this.PB_02Part = PB_02Part;
  }
}
