package com.asteelflash.entity.DtoEntity;

import com.asteelflash.entity.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by hunter.fei on 2018/8/1.
 */
@Entity
@Table(name = "WipKeyPartsEntity")
public class WipKeyPartsEntity extends BaseEntity {

  @Column(name = "serial_number")
  private String SERIAL_NUMBER;
  @Column(name = "item_code")
  private String ITEM_CODE;
  @Column(name = "keypart_item_code")
  private String KEYPART_ITEM_CODE;
  @Column(name = "supply_code")
  private String SUPPLY_CODE;
  @Column(name = "supply_name")
  private String SUPPLY_NAME;
  @Column(name = "manufacture_name")
  private String MANUFACTURE_NAME;
  @Column(name = "manufacture_npm")
  private String MANUFACTURE_NPM;
  @Column(name = "date_code")
  private String DATE_CODE;
  @Column(name = "ass_date")
  private String ASS_DATE;
  @Column(name = "ass_desc")
  private String ASS_DESC;
  @Column(name = "factory_code")
  private String FACTORY_CODE;
  @Column(name = "file_name")
  private String FILE_NAME;
  @Column(name = "creation_date")
  private String CREATION_DATE;
  @Column(name = "last_update_date")
  private String LAST_UPDATE_DATE;
  @Column(name = "country_origin")
  private String COUNTRY_ORIGIN;
  @Column(name = "supply_lot_no")
  private String SUPPLY_LOT_NO;

  public String getSERIAL_NUMBER() {
    return SERIAL_NUMBER;
  }

  public void setSERIAL_NUMBER(String SERIAL_NUMBER) {
    this.SERIAL_NUMBER = SERIAL_NUMBER;
  }

  public String getITEM_CODE() {
    return ITEM_CODE;
  }

  public void setITEM_CODE(String ITEM_CODE) {
    this.ITEM_CODE = ITEM_CODE;
  }

  public String getKEYPART_ITEM_CODE() {
    return KEYPART_ITEM_CODE;
  }

  public void setKEYPART_ITEM_CODE(String KEYPART_ITEM_CODE) {
    this.KEYPART_ITEM_CODE = KEYPART_ITEM_CODE;
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

  public String getMANUFACTURE_NAME() {
    return MANUFACTURE_NAME;
  }

  public void setMANUFACTURE_NAME(String MANUFACTURE_NAME) {
    this.MANUFACTURE_NAME = MANUFACTURE_NAME;
  }

  public String getMANUFACTURE_NPM() {
    return MANUFACTURE_NPM;
  }

  public void setMANUFACTURE_NPM(String MANUFACTURE_NPM) {
    this.MANUFACTURE_NPM = MANUFACTURE_NPM;
  }

  public String getDATE_CODE() {
    return DATE_CODE;
  }

  public void setDATE_CODE(String DATE_CODE) {
    this.DATE_CODE = DATE_CODE;
  }

  public String getASS_DATE() {
    return ASS_DATE;
  }

  public void setASS_DATE(String ASS_DATE) {
    this.ASS_DATE = ASS_DATE;
  }

  public String getASS_DESC() {
    return ASS_DESC;
  }

  public void setASS_DESC(String ASS_DESC) {
    this.ASS_DESC = ASS_DESC;
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

  public String getCOUNTRY_ORIGIN() {
    return COUNTRY_ORIGIN;
  }

  public void setCOUNTRY_ORIGIN(String COUNTRY_ORIGIN) {
    this.COUNTRY_ORIGIN = COUNTRY_ORIGIN;
  }

  public String getSUPPLY_LOT_NO() {
    return SUPPLY_LOT_NO;
  }

  public void setSUPPLY_LOT_NO(String SUPPLY_LOT_NO) {
    this.SUPPLY_LOT_NO = SUPPLY_LOT_NO;
  }
}
