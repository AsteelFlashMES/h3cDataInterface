package com.asteelflash.entity.DtoEntity;

import com.asteelflash.dto.SnDetailDto;
import com.asteelflash.entity.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by hunter.fei on 2018/6/15.
 *  process & test interface use.
 */
@Entity
@Table(name = "SnDetailEntity")
public class SnDetailEntity extends BaseEntity {

  //工厂编码
  @Column(name = "factory_code")
  private String FACTORY_CODE;
  //单板条码、制成板条码
  @Column(name = "serial_number")
  private String SERIAL_NUMBER;
  //成品板条码
  @Column(name = "pcb_number")
  private String PCB_NUMBER;
  //任务令
  @Column(name = "mo_number")
  private String MO_NUMBER;
  //生产线
  @Column(name = "line_code")
  private String LINE_CODE;
  //工序编码
  @Column(name = "section_code")
  private String SECTION_CODE;
  //检验结果
  @Column(name = "err_flag")
  private String ERR_FLAG;
  //通过次数
  @Column(name = "s_count")
  private int PASS_COUNT;
  //测试时间
  @Column(name = "in_station_time")
  private String IN_STATION_TIME;

  @Column(name = "file_name")
  private String FILE_NAME;
  @Column(name = "creation_date")
  private String CREATION_DATE;
  @Column(name = "last_update_date")
  private String LAST_UPDATE_DATE;
  @Column(name = "emp_no")
  private String EMP_NO;
  //班次编码
  @Column(name = "class_code")
  private String CLASS_CODE;
  //检验ID
  @Column(name = "test_id")
  private String TEST_ID;
  //产地
  @Column(name = "out_from")
  private String OUT_FROM;
  //故障描述
  @Column(name = "err_desc")
  private String ERR_DESC;
  //备注
  @Column(name = "test_desc")
  private String TEST_DESC;
  //erp导入标识
  @Column(name = "erp_import_flag")
  private String ERP_IMPORT_FLAG;
  //缺陷代码
  @Column(name = "defect_code")
  private String DEFECT_CODE;

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

  public SnDetailEntity(SnDetailDto snDetailDto) {
    this.FACTORY_CODE = snDetailDto.getFACTORY_CODE();
    this.SERIAL_NUMBER = snDetailDto.getSERIAL_NUMBER();
    this.PCB_NUMBER = snDetailDto.getPCB_NUMBER();
    this.MO_NUMBER = snDetailDto.getMO_NUMBER();
    this.LINE_CODE = snDetailDto.getLINE_CODE();
    this.SECTION_CODE = snDetailDto.getSECTION_CODE();
    this.ERR_FLAG = snDetailDto.getERR_FLAG();
    this.PASS_COUNT = snDetailDto.getPASS_COUNT();
    this.IN_STATION_TIME = snDetailDto.getIN_STATION_TIME();
    this.FILE_NAME = snDetailDto.getFILE_NAME();
    this.CREATION_DATE = snDetailDto.getCREATION_DATE();
    this.LAST_UPDATE_DATE = snDetailDto.getLAST_UPDATE_DATE();
    this.EMP_NO = snDetailDto.getEMP_NO();
    this.CLASS_CODE = snDetailDto.getCLASS_CODE();
    this.TEST_ID = snDetailDto.getTEST_ID();
    this.OUT_FROM = snDetailDto.getOUT_FROM();
    this.ERR_DESC = snDetailDto.getERR_DESC();
    this.TEST_DESC = snDetailDto.getTEST_DESC();
    this.ERP_IMPORT_FLAG = snDetailDto.getERP_IMPORT_FLAG();
    this.DEFECT_CODE = snDetailDto.getDEFECT_CODE();
  }

  public SnDetailEntity() {
  }
}
