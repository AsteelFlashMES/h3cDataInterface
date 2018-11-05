package com.asteelflash.entity.DtoEntity;

import com.asteelflash.entity.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by hunter.fei on 2018/6/26.
 * Return Material use.
 */
@Entity
@Table(name = "LotReturnEntity")
public class LotReturnEntity extends BaseEntity {

  @Column(name = "factory_code")
  private String FACTORY_CODE;
  @Column(name = "mo_number")
  private String MO_NUMBER;
  @Column(name = "lot_no")
  private String LOT_NO;
  @Column(name = "_qty")
  private int LOT_QTY;
  @Column(name = "d_qty")
  private int USED_QTY;
  @Column(name = "l_qty")
  private int FAIL_QTY;
  @Column(name = "part_code")
  private String PART_CODE;
  @Column(name = "manufactrue_name")
  private String MANUFACTRUE_NAME;
  @Column(name = "supply_name")
  private String SUPPLY_NAME;
  @Column(name = "defect_code")
  private String DEFECT_CODE;
  @Column(name = "reson_code")
  private String RESON_CODE;
  @Column(name = "item_code")
  private String ITEM_CODE;
  @Column(name = "reporter")
  private String REPORTER;
  @Column(name = "report_date")
  private String REPORT_DATE;
  @Column(name = "report_dep")
  private String REPORT_DEP;
  @Column(name = "source_flag")
  private String SOURCE_FLAG;
  @Column(name = "creation_date")
  private String CREATION_DATE;
  @Column(name = "last_update_date")
  private String LAST_UPDATE_DATE;
  @Column(name = "part_no")
  private String PART_NO;
  @Column(name = "last_update_by")
  private String LAST_UPDATE_BY;
  @Column(name = "creation_by")
  private String CREATION_BY;
  @Column(name = "work_day")
  private String WORK_DAY;
  @Column(name = "work_month")
  private String WORK_MONTH;
  @Column(name = "work_year")
  private String WORK_YEAR;
  @Column(name = "supply_code")
  private String SUPPLY_CODE;
  @Column(name = "file_name")
  private String FILE_NAME;
  @Column(name = "remark")
  private String REMARK;

  public String getFACTORY_CODE() {
    return FACTORY_CODE;
  }

  public void setFACTORY_CODE(String FACTORY_CODE) {
    this.FACTORY_CODE = FACTORY_CODE;
  }

  public String getMO_NUMBER() {
    return MO_NUMBER;
  }

  public void setMO_NUMBER(String MO_NUMBER) {
    this.MO_NUMBER = MO_NUMBER;
  }

  public String getLOT_NO() {
    return LOT_NO;
  }

  public void setLOT_NO(String LOT_NO) {
    this.LOT_NO = LOT_NO;
  }

  public int getLOT_QTY() {
    return LOT_QTY;
  }

  public void setLOT_QTY(int LOT_QTY) {
    this.LOT_QTY = LOT_QTY;
  }

  public int getUSED_QTY() {
    return USED_QTY;
  }

  public void setUSED_QTY(int USED_QTY) {
    this.USED_QTY = USED_QTY;
  }

  public int getFAIL_QTY() {
    return FAIL_QTY;
  }

  public void setFAIL_QTY(int FAIL_QTY) {
    this.FAIL_QTY = FAIL_QTY;
  }

  public String getPART_CODE() {
    return PART_CODE;
  }

  public void setPART_CODE(String PART_CODE) {
    this.PART_CODE = PART_CODE;
  }

  public String getMANUFACTRUE_NAME() {
    return MANUFACTRUE_NAME;
  }

  public void setMANUFACTRUE_NAME(String MANUFACTRUE_NAME) {
    this.MANUFACTRUE_NAME = MANUFACTRUE_NAME;
  }

  public String getSUPPLY_NAME() {
    return SUPPLY_NAME;
  }

  public void setSUPPLY_NAME(String SUPPLY_NAME) {
    this.SUPPLY_NAME = SUPPLY_NAME;
  }

  public String getDEFECT_CODE() {
    return DEFECT_CODE;
  }

  public void setDEFECT_CODE(String DEFECT_CODE) {
    this.DEFECT_CODE = DEFECT_CODE;
  }

  public String getRESON_CODE() {
    return RESON_CODE;
  }

  public void setRESON_CODE(String RESON_CODE) {
    this.RESON_CODE = RESON_CODE;
  }

  public String getITEM_CODE() {
    return ITEM_CODE;
  }

  public void setITEM_CODE(String ITEM_CODE) {
    this.ITEM_CODE = ITEM_CODE;
  }

  public String getREPORTER() {
    return REPORTER;
  }

  public void setREPORTER(String REPORTER) {
    this.REPORTER = REPORTER;
  }

  public String getREPORT_DATE() {
    return REPORT_DATE;
  }

  public void setREPORT_DATE(String REPORT_DATE) {
    this.REPORT_DATE = REPORT_DATE;
  }

  public String getREPORT_DEP() {
    return REPORT_DEP;
  }

  public void setREPORT_DEP(String REPORT_DEP) {
    this.REPORT_DEP = REPORT_DEP;
  }

  public String getSOURCE_FLAG() {
    return SOURCE_FLAG;
  }

  public void setSOURCE_FLAG(String SOURCE_FLAG) {
    this.SOURCE_FLAG = SOURCE_FLAG;
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

  public String getPART_NO() {
    return PART_NO;
  }

  public void setPART_NO(String PART_NO) {
    this.PART_NO = PART_NO;
  }

  public String getLAST_UPDATE_BY() {
    return LAST_UPDATE_BY;
  }

  public void setLAST_UPDATE_BY(String LAST_UPDATE_BY) {
    this.LAST_UPDATE_BY = LAST_UPDATE_BY;
  }

  public String getCREATION_BY() {
    return CREATION_BY;
  }

  public void setCREATION_BY(String CREATION_BY) {
    this.CREATION_BY = CREATION_BY;
  }

  public String getWORK_DAY() {
    return WORK_DAY;
  }

  public void setWORK_DAY(String WORK_DAY) {
    this.WORK_DAY = WORK_DAY;
  }

  public String getWORK_MONTH() {
    return WORK_MONTH;
  }

  public void setWORK_MONTH(String WORK_MONTH) {
    this.WORK_MONTH = WORK_MONTH;
  }

  public String getWORK_YEAR() {
    return WORK_YEAR;
  }

  public void setWORK_YEAR(String WORK_YEAR) {
    this.WORK_YEAR = WORK_YEAR;
  }

  public String getSUPPLY_CODE() {
    return SUPPLY_CODE;
  }

  public void setSUPPLY_CODE(String SUPPLY_CODE) {
    this.SUPPLY_CODE = SUPPLY_CODE;
  }

  public String getFILE_NAME() {
    return FILE_NAME;
  }

  public void setFILE_NAME(String FILE_NAME) {
    this.FILE_NAME = FILE_NAME;
  }

  public String getREMARK() {
    return REMARK;
  }

  public void setREMARK(String REMARK) {
    this.REMARK = REMARK;
  }
}
