package com.asteelflash.entity.DtoEntity;

import com.asteelflash.entity.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by hunter.fei on 2018/7/31.
 */
@Entity
@Table(name = "ProdFitDefectEntity")
public class ProdFitDefectEntity extends BaseEntity {
  @Column(name = "factory_code")
  private String FACTORY_CODE;
  @Column(name = "serial_number")
  private String SERIAL_NUMBER;
  @Column(name = "mo_number")
  private String MO_NUMBER;
  @Column(name = "item_code")
  private String ITEM_CODE;
  @Column(name = "test_time")
  private String TEST_TIME;
  @Column(name = "defect_code")
  private String DEFECT_CODE;
  @Column(name = "defect_desc")
  private String DEFECT_DESC;
  @Column(name = "test_station_code")
  private String TEST_STATION_CODE;
  @Column(name = "test_group_code")
  private String TEST_GROUP_CODE;
  @Column(name = "test_section_code")
  private String TEST_SECTION_CODE;
  @Column(name = "test_line_code")
  private String TEST_LINE_CODE;
  @Column(name = "work_day")
  private String WORK_DAY;
  @Column(name = "creation_date")
  private String CREATION_DATE;
  @Column(name = "creation_by")
  private String CREATION_BY;
  @Column(name = "last_update_date")
  private String LAST_UPDATE_DATE;
  @Column(name = "last_update_by")
  private String LAST_UPDATE_BY;
  @Column(name = "test_id")
  private String TEST_ID;
  @Column(name = "factory")
  private String FACTORY;
  @Column(name = "remark")
  private String REMARK;
  @Column(name = "file_name")
  private String FILE_NAME;

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

  public String getITEM_CODE() {
    return ITEM_CODE;
  }

  public void setITEM_CODE(String ITEM_CODE) {
    this.ITEM_CODE = ITEM_CODE;
  }

  public String getTEST_TIME() {
    return TEST_TIME;
  }

  public void setTEST_TIME(String TEST_TIME) {
    this.TEST_TIME = TEST_TIME;
  }

  public String getDEFECT_CODE() {
    return DEFECT_CODE;
  }

  public void setDEFECT_CODE(String DEFECT_CODE) {
    this.DEFECT_CODE = DEFECT_CODE;
  }

  public String getDEFECT_DESC() {
    return DEFECT_DESC;
  }

  public void setDEFECT_DESC(String DEFECT_DESC) {
    this.DEFECT_DESC = DEFECT_DESC;
  }

  public String getTEST_STATION_CODE() {
    return TEST_STATION_CODE;
  }

  public void setTEST_STATION_CODE(String TEST_STATION_CODE) {
    this.TEST_STATION_CODE = TEST_STATION_CODE;
  }

  public String getTEST_GROUP_CODE() {
    return TEST_GROUP_CODE;
  }

  public void setTEST_GROUP_CODE(String TEST_GROUP_CODE) {
    this.TEST_GROUP_CODE = TEST_GROUP_CODE;
  }

  public String getTEST_SECTION_CODE() {
    return TEST_SECTION_CODE;
  }

  public void setTEST_SECTION_CODE(String TEST_SECTION_CODE) {
    this.TEST_SECTION_CODE = TEST_SECTION_CODE;
  }

  public String getTEST_LINE_CODE() {
    return TEST_LINE_CODE;
  }

  public void setTEST_LINE_CODE(String TEST_LINE_CODE) {
    this.TEST_LINE_CODE = TEST_LINE_CODE;
  }

  public String getWORK_DAY() {
    return WORK_DAY;
  }

  public void setWORK_DAY(String WORK_DAY) {
    this.WORK_DAY = WORK_DAY;
  }

  public String getCREATION_DATE() {
    return CREATION_DATE;
  }

  public void setCREATION_DATE(String CREATION_DATE) {
    this.CREATION_DATE = CREATION_DATE;
  }

  public String getCREATION_BY() {
    return CREATION_BY;
  }

  public void setCREATION_BY(String CREATION_BY) {
    this.CREATION_BY = CREATION_BY;
  }

  public String getLAST_UPDATE_DATE() {
    return LAST_UPDATE_DATE;
  }

  public void setLAST_UPDATE_DATE(String LAST_UPDATE_DATE) {
    this.LAST_UPDATE_DATE = LAST_UPDATE_DATE;
  }

  public String getLAST_UPDATE_BY() {
    return LAST_UPDATE_BY;
  }

  public void setLAST_UPDATE_BY(String LAST_UPDATE_BY) {
    this.LAST_UPDATE_BY = LAST_UPDATE_BY;
  }

  public String getTEST_ID() {
    return TEST_ID;
  }

  public void setTEST_ID(String TEST_ID) {
    this.TEST_ID = TEST_ID;
  }

  public String getFACTORY() {
    return FACTORY;
  }

  public void setFACTORY(String FACTORY) {
    this.FACTORY = FACTORY;
  }

  public String getREMARK() {
    return REMARK;
  }

  public void setREMARK(String REMARK) {
    this.REMARK = REMARK;
  }

  public String getFILE_NAME() {
    return FILE_NAME;
  }

  public void setFILE_NAME(String FILE_NAME) {
    this.FILE_NAME = FILE_NAME;
  }
}
