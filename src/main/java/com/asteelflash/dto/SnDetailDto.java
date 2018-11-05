package com.asteelflash.dto;

import com.asteelflash.entity.DtoEntity.SnDetailEntity;

/**
 * Created by hunter.fei on 2018/6/15.
 * process & test interface use.
 */
public class SnDetailDto {

  //工厂编码
  private String FACTORY_CODE;
  //单板条码、制成板条码
  private String SERIAL_NUMBER;
  //成品板条码
  private String PCB_NUMBER;
  //任务令
  private String MO_NUMBER;
  //生产线
  private String LINE_CODE;
  //工序编码
  private String SECTION_CODE;
  //检验结果
  private String ERR_FLAG;
  //通过次数
  private int PASS_COUNT;
  //测试时间
  private String IN_STATION_TIME;

  private String FILE_NAME;
  private String CREATION_DATE;
  private String LAST_UPDATE_DATE;
  private String EMP_NO;
  //班次编码
  private String CLASS_CODE;
  //检验ID
  private String TEST_ID;
  //产地
  private String OUT_FROM;
  //故障描述
  private String ERR_DESC;
  //备注
  private String TEST_DESC;
  //erp导入标识
  private String ERP_IMPORT_FLAG;
  //缺陷代码
  private String DEFECT_CODE;

  public SnDetailDto() {
  }

  public SnDetailDto(SnDetailEntity snDetailEntity) {
    this.FACTORY_CODE = snDetailEntity.getFACTORY_CODE();
    this.SERIAL_NUMBER = snDetailEntity.getSERIAL_NUMBER();
    this.PCB_NUMBER = snDetailEntity.getPCB_NUMBER();
    this.MO_NUMBER = snDetailEntity.getMO_NUMBER();
    this.LINE_CODE = snDetailEntity.getLINE_CODE();
    this.SECTION_CODE = snDetailEntity.getSECTION_CODE();
    this.ERR_FLAG = snDetailEntity.getERR_FLAG();
    this.PASS_COUNT = snDetailEntity.getPASS_COUNT();
    this.IN_STATION_TIME = snDetailEntity.getIN_STATION_TIME();
    this.FILE_NAME = snDetailEntity.getFILE_NAME();
    this.CREATION_DATE = snDetailEntity.getCREATION_DATE();
    this.LAST_UPDATE_DATE = snDetailEntity.getLAST_UPDATE_DATE();
    this.EMP_NO = snDetailEntity.getEMP_NO();
    this.CLASS_CODE = snDetailEntity.getCLASS_CODE();
    this.TEST_ID = snDetailEntity.getTEST_ID();
    this.OUT_FROM = snDetailEntity.getOUT_FROM();
    this.ERR_DESC = snDetailEntity.getERR_DESC();
    this.TEST_DESC = snDetailEntity.getTEST_DESC();
    this.ERP_IMPORT_FLAG = snDetailEntity.getERP_IMPORT_FLAG();
    this.DEFECT_CODE = snDetailEntity.getDEFECT_CODE();
  }

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

  public String getPCB_NUMBER() {
    return PCB_NUMBER;
  }

  public void setPCB_NUMBER(String PCB_NUMBER) {
    this.PCB_NUMBER = PCB_NUMBER;
  }

  public String getMO_NUMBER() {
    return MO_NUMBER;
  }

  public void setMO_NUMBER(String MO_NUMBER) {
    this.MO_NUMBER = MO_NUMBER;
  }

  public String getLINE_CODE() {
    return LINE_CODE;
  }

  public void setLINE_CODE(String LINE_CODE) {
    this.LINE_CODE = LINE_CODE;
  }

  public String getSECTION_CODE() {
    return SECTION_CODE;
  }

  public void setSECTION_CODE(String SECTION_CODE) {
    this.SECTION_CODE = SECTION_CODE;
  }

  public String getERR_FLAG() {
    return ERR_FLAG;
  }

  public void setERR_FLAG(String ERR_FLAG) {
    this.ERR_FLAG = ERR_FLAG;
  }

  public int getPASS_COUNT() {
    return PASS_COUNT;
  }

  public void setPASS_COUNT(int PASS_COUNT) {
    this.PASS_COUNT = PASS_COUNT;
  }

  public String getIN_STATION_TIME() {
    return IN_STATION_TIME;
  }

  public void setIN_STATION_TIME(String IN_STATION_TIME) {
    this.IN_STATION_TIME = IN_STATION_TIME;
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

  public String getEMP_NO() {
    return EMP_NO;
  }

  public void setEMP_NO(String EMP_NO) {
    this.EMP_NO = EMP_NO;
  }

  public String getCLASS_CODE() {
    return CLASS_CODE;
  }

  public void setCLASS_CODE(String CLASS_CODE) {
    this.CLASS_CODE = CLASS_CODE;
  }

  public String getTEST_ID() {
    return TEST_ID;
  }

  public void setTEST_ID(String TEST_ID) {
    this.TEST_ID = TEST_ID;
  }

  public String getOUT_FROM() {
    return OUT_FROM;
  }

  public void setOUT_FROM(String OUT_FROM) {
    this.OUT_FROM = OUT_FROM;
  }

  public String getERR_DESC() {
    return ERR_DESC;
  }

  public void setERR_DESC(String ERR_DESC) {
    this.ERR_DESC = ERR_DESC;
  }

  public String getTEST_DESC() {
    return TEST_DESC;
  }

  public void setTEST_DESC(String TEST_DESC) {
    this.TEST_DESC = TEST_DESC;
  }

  public String getERP_IMPORT_FLAG() {
    return ERP_IMPORT_FLAG;
  }

  public void setERP_IMPORT_FLAG(String ERP_IMPORT_FLAG) {
    this.ERP_IMPORT_FLAG = ERP_IMPORT_FLAG;
  }

  public String getDEFECT_CODE() {
    return DEFECT_CODE;
  }

  public void setDEFECT_CODE(String DEFECT_CODE) {
    this.DEFECT_CODE = DEFECT_CODE;
  }

}
