package com.asteelflash.dto;

import com.asteelflash.entity.DtoEntity.LotReturnEntity;

/**
 * Created by hunter.fei on 2018/6/26.
 * Return Material use.
 */
public class LotReturnDto {

  private String FACTORY_CODE;
  private String MO_NUMBER;
  private String LOT_NO;
  private int LOT_QTY;
  private int USED_QTY;
  private int FAIL_QTY;
  private String PART_CODE;
  private String MANUFACTRUE_NAME;
  private String SUPPLY_NAME;
  private String DEFECT_CODE;
  private String RESON_CODE;
  private String ITEM_CODE;
  private String REPORTER;
  private String REPORT_DATE;
  private String REPORT_DEP;
  private String SOURCE_FLAG;
  private String CREATION_DATE;
  private String LAST_UPDATE_DATE;
  private String PART_NO;
  private String LAST_UPDATE_BY;
  private String CREATION_BY;
  private String WORK_DAY;
  private String WORK_MONTH;
  private String WORK_YEAR;
  private String SUPPLY_CODE;
  private String FILE_NAME;
  private String REMARK;

  public LotReturnDto() {
  }

  public LotReturnDto(LotReturnEntity lotReturnEntity) {
    this.FACTORY_CODE = lotReturnEntity.getFACTORY_CODE();
    this.MO_NUMBER = lotReturnEntity.getMO_NUMBER();
    this.LOT_NO = lotReturnEntity.getLOT_NO();
    this.LOT_QTY = lotReturnEntity.getLOT_QTY();
    this.USED_QTY = lotReturnEntity.getUSED_QTY();
    this.FAIL_QTY = lotReturnEntity.getFAIL_QTY();
    this.PART_CODE = lotReturnEntity.getPART_CODE();
    this.MANUFACTRUE_NAME = lotReturnEntity.getMANUFACTRUE_NAME();
    this.SUPPLY_NAME = lotReturnEntity.getSUPPLY_NAME();
    this.DEFECT_CODE = lotReturnEntity.getDEFECT_CODE();
    this.RESON_CODE = lotReturnEntity.getRESON_CODE();
    this.ITEM_CODE = lotReturnEntity.getITEM_CODE();
    this.REPORTER = lotReturnEntity.getREPORTER();
    this.REPORT_DATE = lotReturnEntity.getREPORT_DATE();
    this.REPORT_DEP = lotReturnEntity.getREPORT_DEP();
    this.SOURCE_FLAG = lotReturnEntity.getSOURCE_FLAG();
    this.CREATION_DATE = lotReturnEntity.getCREATION_DATE();
    this.LAST_UPDATE_DATE = lotReturnEntity.getLAST_UPDATE_DATE();
    this.PART_NO = lotReturnEntity.getPART_NO();
    this.LAST_UPDATE_BY = lotReturnEntity.getLAST_UPDATE_BY();
    this.CREATION_BY = lotReturnEntity.getCREATION_BY();
    this.WORK_DAY = lotReturnEntity.getWORK_DAY();
    this.WORK_MONTH = lotReturnEntity.getWORK_MONTH();
    this.WORK_YEAR = lotReturnEntity.getWORK_YEAR();
    this.SUPPLY_CODE = lotReturnEntity.getSUPPLY_CODE();
    this.FILE_NAME = lotReturnEntity.getFILE_NAME();
    this.REMARK = lotReturnEntity.getREMARK();
  }

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
