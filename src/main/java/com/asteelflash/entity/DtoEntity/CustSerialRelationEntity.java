package com.asteelflash.entity.DtoEntity;

import com.asteelflash.entity.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by hunter.fei on 2018/8/6.
 */
@Entity
@Table(name = "CustSerialRelationEntity")
public class CustSerialRelationEntity extends BaseEntity {

  @Column(name = "mo_no")
  private String MO_NO;
  @Column(name = "item_code")
  private String ITEM_CODE;
  @Column(name="serial_no")
  private String SERIAL_NO;
  @Column(name="cust_serial_no")
  private String CUST_SERIAL_NO;
  @Column(name="customer_name")
  private String CUSTOMER_NAME;
  @Column(name="creation_date")
  private String CREATION_DATE;
  @Column(name = "create_by")
  private String CREATE_BY;
  @Column(name = "last_update_date")
  private String LAST_UPDATE_DATE;
  @Column(name = "last_update_by")
  private String LAST_UPDATE_BY;
  @Column(name = "pack_date")
  private String PACK_DATE;
  @Column(name = "file_name")
  private String FILE_NAME;
  @Column(name = "factory_code")
  private String FACTORY_CODE;

  public String getMO_NO() {
    return MO_NO;
  }

  public void setMO_NO(String MO_NO) {
    this.MO_NO = MO_NO;
  }

  public String getITEM_CODE() {
    return ITEM_CODE;
  }

  public void setITEM_CODE(String ITEM_CODE) {
    this.ITEM_CODE = ITEM_CODE;
  }

  public String getSERIAL_NO() {
    return SERIAL_NO;
  }

  public void setSERIAL_NO(String SERIAL_NO) {
    this.SERIAL_NO = SERIAL_NO;
  }

  public String getCUST_SERIAL_NO() {
    return CUST_SERIAL_NO;
  }

  public void setCUST_SERIAL_NO(String CUST_SERIAL_NO) {
    this.CUST_SERIAL_NO = CUST_SERIAL_NO;
  }

  public String getCUSTOMER_NAME() {
    return CUSTOMER_NAME;
  }

  public void setCUSTOMER_NAME(String CUSTOMER_NAME) {
    this.CUSTOMER_NAME = CUSTOMER_NAME;
  }

  public String getCREATION_DATE() {
    return CREATION_DATE;
  }

  public void setCREATION_DATE(String CREATION_DATE) {
    this.CREATION_DATE = CREATION_DATE;
  }

  public String getCREATE_BY() {
    return CREATE_BY;
  }

  public void setCREATE_BY(String CREATE_BY) {
    this.CREATE_BY = CREATE_BY;
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

  public String getPACK_DATE() {
    return PACK_DATE;
  }

  public void setPACK_DATE(String PACK_DATE) {
    this.PACK_DATE = PACK_DATE;
  }

  public String getFILE_NAME() {
    return FILE_NAME;
  }

  public void setFILE_NAME(String FILE_NAME) {
    this.FILE_NAME = FILE_NAME;
  }

  public String getFACTORY_CODE() {
    return FACTORY_CODE;
  }

  public void setFACTORY_CODE(String FACTORY_CODE) {
    this.FACTORY_CODE = FACTORY_CODE;
  }
}
