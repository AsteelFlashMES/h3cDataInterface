package com.asteelflash.entity.DtoEntity;

import com.asteelflash.entity.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by hunter.fei on 2018/8/7.
 */
@Entity
@Table(name = "SnLabelDataEntity")
public class SnLabelDataEntity extends BaseEntity {

  @Column(name = "serial_number")
  private String SERIAL_NUMBER;
  @Column(name = "mo_number")
  private String MO_NUMBER;
  @Column(name = "item_code")
  private String ITEM_CODE;
  @Column(name = "factory")
  private String FACTORY;
  @Column(name = "factory_code")
  private String FACTORY_CODE;
  @Column(name = "hardware_ver")
  private String HARDWARE_VER;
  @Column(name = "software_ver")
  private String SOFTWARE_VER;
  @Column(name = "vendor_code")
  private String VENDOR_CODE;
  @Column(name = "origin_country")
  private String ORIGIN_COUNTRY;
  @Column(name = "grade")
  private String GRADE;
  @Column(name = "sp")
  private String SP;
  @Column(name = "po")
  private String PO;
  @Column(name = "environment_state")
  private String ENVIRONMENT_STATE;
  @Column(name = "state_5000")
  private String STATE_5000;
  @Column(name = "remark")
  private String REMARK;
  @Column(name = "ass_date")
  private String ASS_DATE;
  @Column(name = "reformed")
  private String REFORMED;
  @Column(name = "old_sn")
  private String OLD_SN;
  @Column(name = "created_by")
  private String CREATED_BY;
  @Column(name = "creation_date")
  private String CREATION_DATE;
  @Column(name = "last_update_by")
  private String LAST_UPDATE_BY;
  @Column(name = "last_update_date")
  private String LAST_UPDATE_DATE;
  @Column(name = "file_name")
  private String FILE_NAME;

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

  public String getFACTORY() {
    return FACTORY;
  }

  public void setFACTORY(String FACTORY) {
    this.FACTORY = FACTORY;
  }

  public String getFACTORY_CODE() {
    return FACTORY_CODE;
  }

  public void setFACTORY_CODE(String FACTORY_CODE) {
    this.FACTORY_CODE = FACTORY_CODE;
  }

  public String getHARDWARE_VER() {
    return HARDWARE_VER;
  }

  public void setHARDWARE_VER(String HARDWARE_VER) {
    this.HARDWARE_VER = HARDWARE_VER;
  }

  public String getSOFTWARE_VER() {
    return SOFTWARE_VER;
  }

  public void setSOFTWARE_VER(String SOFTWARE_VER) {
    this.SOFTWARE_VER = SOFTWARE_VER;
  }

  public String getVENDOR_CODE() {
    return VENDOR_CODE;
  }

  public void setVENDOR_CODE(String VENDOR_CODE) {
    this.VENDOR_CODE = VENDOR_CODE;
  }

  public String getORIGIN_COUNTRY() {
    return ORIGIN_COUNTRY;
  }

  public void setORIGIN_COUNTRY(String ORIGIN_COUNTRY) {
    this.ORIGIN_COUNTRY = ORIGIN_COUNTRY;
  }

  public String getGRADE() {
    return GRADE;
  }

  public void setGRADE(String GRADE) {
    this.GRADE = GRADE;
  }

  public String getSP() {
    return SP;
  }

  public void setSP(String SP) {
    this.SP = SP;
  }

  public String getPO() {
    return PO;
  }

  public void setPO(String PO) {
    this.PO = PO;
  }

  public String getENVIRONMENT_STATE() {
    return ENVIRONMENT_STATE;
  }

  public void setENVIRONMENT_STATE(String ENVIRONMENT_STATE) {
    this.ENVIRONMENT_STATE = ENVIRONMENT_STATE;
  }

  public String getSTATE_5000() {
    return STATE_5000;
  }

  public void setSTATE_5000(String STATE_5000) {
    this.STATE_5000 = STATE_5000;
  }

  public String getREMARK() {
    return REMARK;
  }

  public void setREMARK(String REMARK) {
    this.REMARK = REMARK;
  }

  public String getASS_DATE() {
    return ASS_DATE;
  }

  public void setASS_DATE(String ASS_DATE) {
    this.ASS_DATE = ASS_DATE;
  }

  public String getREFORMED() {
    return REFORMED;
  }

  public void setREFORMED(String REFORMED) {
    this.REFORMED = REFORMED;
  }

  public String getOLD_SN() {
    return OLD_SN;
  }

  public void setOLD_SN(String OLD_SN) {
    this.OLD_SN = OLD_SN;
  }

  public String getCREATED_BY() {
    return CREATED_BY;
  }

  public void setCREATED_BY(String CREATED_BY) {
    this.CREATED_BY = CREATED_BY;
  }

  public String getCREATION_DATE() {
    return CREATION_DATE;
  }

  public void setCREATION_DATE(String CREATION_DATE) {
    this.CREATION_DATE = CREATION_DATE;
  }

  public String getLAST_UPDATE_BY() {
    return LAST_UPDATE_BY;
  }

  public void setLAST_UPDATE_BY(String LAST_UPDATE_BY) {
    this.LAST_UPDATE_BY = LAST_UPDATE_BY;
  }

  public String getLAST_UPDATE_DATE() {
    return LAST_UPDATE_DATE;
  }

  public void setLAST_UPDATE_DATE(String LAST_UPDATE_DATE) {
    this.LAST_UPDATE_DATE = LAST_UPDATE_DATE;
  }

  public String getFILE_NAME() {
    return FILE_NAME;
  }

  public void setFILE_NAME(String FILE_NAME) {
    this.FILE_NAME = FILE_NAME;
  }
}
