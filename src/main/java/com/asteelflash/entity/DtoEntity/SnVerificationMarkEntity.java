package com.asteelflash.entity.DtoEntity;

import com.asteelflash.entity.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by hunter.fei on 2018/8/3.
 */
@Entity
@Table(name = "SnVerificationMarkEntity")
public class SnVerificationMarkEntity extends BaseEntity {

  @Column(name = "serial_number")
  private String SERIAL_NUMBER;
  @Column(name = "mark_number")
  private String MARK_NUMBER;
  @Column(name = "ass_date")
  private String ASS_DATE;
  @Column(name = "creation_date")
  private String CREATION_DATE;
  @Column(name = "last_update_date")
  private String LAST_UPDATE_DATE;
  @Column(name = "creation_by")
  private String CREATION_BY;
  @Column(name = "last_update_by")
  private String LAST_UPDATE_BY;
  @Column(name = "item_code")
  private String ITEM_CODE;
  @Column(name = "mo_number")
  private String MO_NUMBER;
  @Column(name = "remark")
  private String REMARK;
  @Column(name = "factory_code")
  private String FACTORY_CODE;
  @Column(name = "file_name")
  private String FILE_NAME;

  public String getSERIAL_NUMBER() {
    return SERIAL_NUMBER;
  }

  public void setSERIAL_NUMBER(String SERIAL_NUMBER) {
    this.SERIAL_NUMBER = SERIAL_NUMBER;
  }

  public String getMARK_NUMBER() {
    return MARK_NUMBER;
  }

  public void setMARK_NUMBER(String MARK_NUMBER) {
    this.MARK_NUMBER = MARK_NUMBER;
  }

  public String getASS_DATE() {
    return ASS_DATE;
  }

  public void setASS_DATE(String ASS_DATE) {
    this.ASS_DATE = ASS_DATE;
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

  public String getCREATION_BY() {
    return CREATION_BY;
  }

  public void setCREATION_BY(String CREATION_BY) {
    this.CREATION_BY = CREATION_BY;
  }

  public String getLAST_UPDATE_BY() {
    return LAST_UPDATE_BY;
  }

  public void setLAST_UPDATE_BY(String LAST_UPDATE_BY) {
    this.LAST_UPDATE_BY = LAST_UPDATE_BY;
  }

  public String getITEM_CODE() {
    return ITEM_CODE;
  }

  public void setITEM_CODE(String ITEM_CODE) {
    this.ITEM_CODE = ITEM_CODE;
  }

  public String getMO_NUMBER() {
    return MO_NUMBER;
  }

  public void setMO_NUMBER(String MO_NUMBER) {
    this.MO_NUMBER = MO_NUMBER;
  }

  public String getREMARK() {
    return REMARK;
  }

  public void setREMARK(String REMARK) {
    this.REMARK = REMARK;
  }

  public String getFACTORY_CODE() {
    return FACTORY_CODE;
  }

  public void setFACTORY_CODE(String FACTORY_CODE) {
    this.FACTORY_CODE = FACTORY_CODE;
  }

  public String getFILE_NAME() {
    return FILE_NAME;
  }

  public void setFILE_NAME(String FILE_NAME) {
    this.FILE_NAME = FILE_NAME;
  }
}
