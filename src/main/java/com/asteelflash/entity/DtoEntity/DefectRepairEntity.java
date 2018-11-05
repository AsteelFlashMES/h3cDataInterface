package com.asteelflash.entity.DtoEntity;

import com.asteelflash.entity.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by hunter.fei on 2018/6/26.
 * rework interface use.
 */
@Entity
@Table(name = "DefectRepairEntity")
public class DefectRepairEntity extends BaseEntity {

  @Column(name = "factory_code")
  private String FACTORY_CODE;
  @Column(name = "serial_number")
  private String SERIAL_NUMBER;
  @Column(name = "mo_number")
  private String MO_NUMBER;
  @Column(name = "defect_code")
  private String DEFECT_CODE;
  @Column(name = "defect_name")
  private String DEFECT_NAME;
  @Column(name = "defect_type")
  private String DEFECT_TYPE;
  @Column(name = "test_section_code")
  private String TEST_SECTION_CODE;
  @Column(name = "repairer_number")
  private String REPAIRER_NUMBER;
  @Column(name = "repair_time")
  private String REPAIR_TIME;
  @Column(name = "repair_memo")
  private String REPAIR_MEMO;
  @Column(name = "duty_section_group_code")
  private String DUTY_SECTION_GROUP_CODE;
  @Column(name = "defect_part_code")
  private String DEFECT_PART_CODE;
  @Column(name = "part_designator")
  private String PART_DESIGNATOR;
  @Column(name = "defect_count")
  private double DEFECT_COUNT;
  @Column(name = "version_code")
  private String VERSION_CODE;
  @Column(name = "parent_sn")
  private String PARENT_SN;
  @Column(name = "supply_code")
  private String SUPPLY_CODE;
  @Column(name = "supply_name")
  private String SUPPLY_NAME;
  @Column(name = "rep_falg")
  private String REP_FALG;
  @Column(name = "rep_supply_name")
  private String REP_SUPPLY_NAME;
  @Column(name = "rep_supply_code")
  private String REP_SUPPLY_CODE;
  @Column(name = "rep_manufacture_name")
  private String REP_MANUFACTURE_NAME;
  @Column(name = "rep_datecode")
  private String REP_DATECODE;
  @Column(name = "rep_lotno")
  private String REP_LOTNO;
  @Column(name = "file_name")
  private String FILE_NAME;
  @Column(name = "creation_date")
  private String CREATION_DATE;
  @Column(name = "last_update_date")
  private String LAST_UPDATE_DATE;
  @Column(name = "reason_code")
  private String REASON_CODE;
  @Column(name = "fault_number1")
  private String FAULT_NUMBER1;
  @Column(name = "fault_number2")
  private String FAULT_NUMBER2;
  @Column(name = "port_number")
  private String PORT_NUMBER;
  @Column(name = "fault_name1")
  private String FAULT_NAME1;
  @Column(name = "fault_name2")
  private String FAULT_NAME2;

  public String getFACTORY_CODE() {
    return FACTORY_CODE;
  }

  public void setFACTORY_CODE(String FACTORY_CODE) {
    this.FACTORY_CODE = FACTORY_CODE;
  }

  public String getSERIAL_NUMBER() {
    return SERIAL_NUMBER;
  }

  public void setSERIAL_NUMBER(String SERIAL_NUMBER) {
    this.SERIAL_NUMBER = SERIAL_NUMBER;
  }

  public String getMO_NUMBER() {
    return MO_NUMBER;
  }

  public void setMO_NUMBER(String MO_NUMBER) {
    this.MO_NUMBER = MO_NUMBER;
  }

  public String getDEFECT_CODE() {
    return DEFECT_CODE;
  }

  public void setDEFECT_CODE(String DEFECT_CODE) {
    this.DEFECT_CODE = DEFECT_CODE;
  }

  public String getDEFECT_NAME() {
    return DEFECT_NAME;
  }

  public void setDEFECT_NAME(String DEFECT_NAME) {
    this.DEFECT_NAME = DEFECT_NAME;
  }

  public String getDEFECT_TYPE() {
    return DEFECT_TYPE;
  }

  public void setDEFECT_TYPE(String DEFECT_TYPE) {
    this.DEFECT_TYPE = DEFECT_TYPE;
  }

  public String getTEST_SECTION_CODE() {
    return TEST_SECTION_CODE;
  }

  public void setTEST_SECTION_CODE(String TEST_SECTION_CODE) {
    this.TEST_SECTION_CODE = TEST_SECTION_CODE;
  }

  public String getREPAIRER_NUMBER() {
    return REPAIRER_NUMBER;
  }

  public void setREPAIRER_NUMBER(String REPAIRER_NUMBER) {
    this.REPAIRER_NUMBER = REPAIRER_NUMBER;
  }

  public String getREPAIR_TIME() {
    return REPAIR_TIME;
  }

  public void setREPAIR_TIME(String REPAIR_TIME) {
    this.REPAIR_TIME = REPAIR_TIME;
  }

  public String getREPAIR_MEMO() {
    return REPAIR_MEMO;
  }

  public void setREPAIR_MEMO(String REPAIR_MEMO) {
    this.REPAIR_MEMO = REPAIR_MEMO;
  }

  public String getDUTY_SECTION_GROUP_CODE() {
    return DUTY_SECTION_GROUP_CODE;
  }

  public void setDUTY_SECTION_GROUP_CODE(String DUTY_SECTION_GROUP_CODE) {
    this.DUTY_SECTION_GROUP_CODE = DUTY_SECTION_GROUP_CODE;
  }

  public String getDEFECT_PART_CODE() {
    return DEFECT_PART_CODE;
  }

  public void setDEFECT_PART_CODE(String DEFECT_PART_CODE) {
    this.DEFECT_PART_CODE = DEFECT_PART_CODE;
  }

  public String getPART_DESIGNATOR() {
    return PART_DESIGNATOR;
  }

  public void setPART_DESIGNATOR(String PART_DESIGNATOR) {
    this.PART_DESIGNATOR = PART_DESIGNATOR;
  }

  public double getDEFECT_COUNT() {
    return DEFECT_COUNT;
  }

  public void setDEFECT_COUNT(double DEFECT_COUNT) {
    this.DEFECT_COUNT = DEFECT_COUNT;
  }

  public String getVERSION_CODE() {
    return VERSION_CODE;
  }

  public void setVERSION_CODE(String VERSION_CODE) {
    this.VERSION_CODE = VERSION_CODE;
  }

  public String getPARENT_SN() {
    return PARENT_SN;
  }

  public void setPARENT_SN(String PARENT_SN) {
    this.PARENT_SN = PARENT_SN;
  }

  public String getSUPPLY_CODE() {
    return SUPPLY_CODE;
  }

  public void setSUPPLY_CODE(String SUPPLY_CODE) {
    this.SUPPLY_CODE = SUPPLY_CODE;
  }

  public String getSUPPLY_NAME() {
    return SUPPLY_NAME;
  }

  public void setSUPPLY_NAME(String SUPPLY_NAME) {
    this.SUPPLY_NAME = SUPPLY_NAME;
  }

  public String getREP_FALG() {
    return REP_FALG;
  }

  public void setREP_FALG(String REP_FALG) {
    this.REP_FALG = REP_FALG;
  }

  public String getREP_SUPPLY_NAME() {
    return REP_SUPPLY_NAME;
  }

  public void setREP_SUPPLY_NAME(String REP_SUPPLY_NAME) {
    this.REP_SUPPLY_NAME = REP_SUPPLY_NAME;
  }

  public String getREP_SUPPLY_CODE() {
    return REP_SUPPLY_CODE;
  }

  public void setREP_SUPPLY_CODE(String REP_SUPPLY_CODE) {
    this.REP_SUPPLY_CODE = REP_SUPPLY_CODE;
  }

  public String getREP_MANUFACTURE_NAME() {
    return REP_MANUFACTURE_NAME;
  }

  public void setREP_MANUFACTURE_NAME(String REP_MANUFACTURE_NAME) {
    this.REP_MANUFACTURE_NAME = REP_MANUFACTURE_NAME;
  }

  public String getREP_DATECODE() {
    return REP_DATECODE;
  }

  public void setREP_DATECODE(String REP_DATECODE) {
    this.REP_DATECODE = REP_DATECODE;
  }

  public String getREP_LOTNO() {
    return REP_LOTNO;
  }

  public void setREP_LOTNO(String REP_LOTNO) {
    this.REP_LOTNO = REP_LOTNO;
  }

  public String getFILE_NAME() {
    return FILE_NAME;
  }

  public void setFILE_NAME(String FILE_NAME) {
    this.FILE_NAME = FILE_NAME;
  }

  public String getCREATION_DATE() {
    return CREATION_DATE;
  }

  public void setCREATION_DATE(String CREATION_DATE) {
    this.CREATION_DATE = CREATION_DATE;
  }

  public String getLAST_UPDATE_DATE() {
    return LAST_UPDATE_DATE;
  }

  public void setLAST_UPDATE_DATE(String LAST_UPDATE_DATE) {
    this.LAST_UPDATE_DATE = LAST_UPDATE_DATE;
  }

  public String getREASON_CODE() {
    return REASON_CODE;
  }

  public void setREASON_CODE(String REASON_CODE) {
    this.REASON_CODE = REASON_CODE;
  }

  public String getFAULT_NUMBER1() {
    return FAULT_NUMBER1;
  }

  public void setFAULT_NUMBER1(String FAULT_NUMBER1) {
    this.FAULT_NUMBER1 = FAULT_NUMBER1;
  }

  public String getFAULT_NUMBER2() {
    return FAULT_NUMBER2;
  }

  public void setFAULT_NUMBER2(String FAULT_NUMBER2) {
    this.FAULT_NUMBER2 = FAULT_NUMBER2;
  }

  public String getPORT_NUMBER() {
    return PORT_NUMBER;
  }

  public void setPORT_NUMBER(String PORT_NUMBER) {
    this.PORT_NUMBER = PORT_NUMBER;
  }

  public String getFAULT_NAME1() {
    return FAULT_NAME1;
  }

  public void setFAULT_NAME1(String FAULT_NAME1) {
    this.FAULT_NAME1 = FAULT_NAME1;
  }

  public String getFAULT_NAME2() {
    return FAULT_NAME2;
  }

  public void setFAULT_NAME2(String FAULT_NAME2) {
    this.FAULT_NAME2 = FAULT_NAME2;
  }
}
