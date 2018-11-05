package com.asteelflash.entity.model;

import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * Created by hunter.fei on 2018/6/26.
 * rework interface use.
 */
public class DefectRepairModel {
  private String field1;
  private String uda_9;
  private String serial_number;
  private String part_revision;
  private String order_number;
  private String op_name;
  private String defect;
  private String location;
  private BigInteger jointQty;
  private Timestamp last_modified_time;
  private String opname;
  private String defPartNumber;
  private String defSN;
  private String bigCategory;
  private String smallCategory;
  private String symptomCode;
  private String defPort;
  private String defMaterialSN;
  private String defMaterialDC;
  private String defSupplierName;
  private String remark;

  public String getField1() {
    return field1;
  }

  public void setField1(String field1) {
    this.field1 = field1;
  }

  public String getUda_9() {
    return uda_9;
  }

  public void setUda_9(String uda_9) {
    this.uda_9 = uda_9;
  }

  public String getSerial_number() {
    return serial_number;
  }

  public void setSerial_number(String serial_number) {
    this.serial_number = serial_number;
  }

  public String getPart_revision() {
    return part_revision;
  }

  public void setPart_revision(String part_revision) {
    this.part_revision = part_revision;
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

  public String getDefect() {
    return defect;
  }

  public void setDefect(String defect) {
    this.defect = defect;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public BigInteger getJointQty() {
    return jointQty;
  }

  public void setJointQty(BigInteger jointQty) {
    this.jointQty = jointQty;
  }

  public Timestamp getLast_modified_time() {
    return last_modified_time;
  }

  public void setLast_modified_time(Timestamp last_modified_time) {
    this.last_modified_time = last_modified_time;
  }

  public String getOpname() {
    return opname;
  }

  public void setOpname(String opname) {
    this.opname = opname;
  }

  public String getDefPartNumber() {
    return defPartNumber;
  }

  public void setDefPartNumber(String defPartNumber) {
    this.defPartNumber = defPartNumber;
  }

  public String getDefSN() {
    return defSN;
  }

  public void setDefSN(String defSN) {
    this.defSN = defSN;
  }

  public String getBigCategory() {
    return bigCategory;
  }

  public void setBigCategory(String bigCategory) {
    this.bigCategory = bigCategory;
  }

  public String getSmallCategory() {
    return smallCategory;
  }

  public void setSmallCategory(String smallCategory) {
    this.smallCategory = smallCategory;
  }

  public String getSymptomCode() {
    return symptomCode;
  }

  public void setSymptomCode(String symptomCode) {
    this.symptomCode = symptomCode;
  }

  public String getDefPort() {
    return defPort;
  }

  public void setDefPort(String defPort) {
    this.defPort = defPort;
  }

  public String getDefMaterialSN() {
    return defMaterialSN;
  }

  public void setDefMaterialSN(String defMaterialSN) {
    this.defMaterialSN = defMaterialSN;
  }

  public String getDefMaterialDC() {
    return defMaterialDC;
  }

  public void setDefMaterialDC(String defMaterialDC) {
    this.defMaterialDC = defMaterialDC;
  }

  public String getDefSupplierName() {
    return defSupplierName;
  }

  public void setDefSupplierName(String defSupplierName) {
    this.defSupplierName = defSupplierName;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public DefectRepairModel() {
  }

  public DefectRepairModel(String field1, String uda_9, String serial_number,
      String part_revision, String order_number, String op_name, String defect,
      String location, BigInteger jointQty, Timestamp last_modified_time, String opname,
      String defPartNumber, String defSN, String bigCategory, String smallCategory,
      String symptomCode, String defPort, String defMaterialSN, String defMaterialDC,
      String defSupplierName, String remark) {
    this.field1 = field1;
    this.uda_9 = uda_9;
    this.serial_number = serial_number;
    this.part_revision = part_revision;
    this.order_number = order_number;
    this.op_name = op_name;
    this.defect = defect;
    this.location = location;
    this.jointQty = jointQty;
    this.last_modified_time = last_modified_time;
    this.opname = opname;
    this.defPartNumber = defPartNumber;
    this.defSN = defSN;
    this.bigCategory = bigCategory;
    this.smallCategory = smallCategory;
    this.symptomCode = symptomCode;
    this.defPort = defPort;
    this.defMaterialSN = defMaterialSN;
    this.defMaterialDC = defMaterialDC;
    this.defSupplierName = defSupplierName;
    this.remark = remark;
  }
}
