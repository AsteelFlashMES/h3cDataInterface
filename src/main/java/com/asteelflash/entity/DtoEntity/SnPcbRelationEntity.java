package com.asteelflash.entity.DtoEntity;

import com.asteelflash.entity.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by hunter.fei on 2018/8/2.
 */
@Entity
@Table(name = "SnPcbRelationEntity")
public class SnPcbRelationEntity extends BaseEntity {

  @Column(name="serial_number")
  private String SERIAL_NUMBER;
  @Column(name="pcb_number")
  private String PCB_NUMBER;
  @Column(name="creation_date")
  private String CREATION_DATE;
  @Column(name="last_update_date")
  private String LAST_UPDATE_DATE;
  @Column(name="last_update_by")
  private String LAST_UPDATE_BY;
  @Column(name="creation_by")
  private String CREATION_BY;
  @Column(name="item_code")
  private String ITEM_CODE;
  @Column(name="f_m_flag")
  private String F_M_FLAG;
  @Column(name="ass_date")
  private String ASS_DATE;
  @Column(name="debug_date")
  private String DEBUG_DATE;
  @Column(name="remarks")
  private String REMARKS;
  @Column(name="sys_item")
  private String SYS_ITEM;
  @Column(name="new_flag")
  private String NEW_FLAG;
  @Column(name="factory_code")
  private String FACTORY_CODE;
  @Column(name="file_name")
  private String FILE_NAME;
  @Column(name="mo_number")
  private String MO_NUMBER;

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

  public String getITEM_CODE() {
    return ITEM_CODE;
  }

  public void setITEM_CODE(String ITEM_CODE) {
    this.ITEM_CODE = ITEM_CODE;
  }

  public String getF_M_FLAG() {
    return F_M_FLAG;
  }

  public void setF_M_FLAG(String f_M_FLAG) {
    F_M_FLAG = f_M_FLAG;
  }

  public String getASS_DATE() {
    return ASS_DATE;
  }

  public void setASS_DATE(String ASS_DATE) {
    this.ASS_DATE = ASS_DATE;
  }

  public String getDEBUG_DATE() {
    return DEBUG_DATE;
  }

  public void setDEBUG_DATE(String DEBUG_DATE) {
    this.DEBUG_DATE = DEBUG_DATE;
  }

  public String getREMARKS() {
    return REMARKS;
  }

  public void setREMARKS(String REMARKS) {
    this.REMARKS = REMARKS;
  }

  public String getSYS_ITEM() {
    return SYS_ITEM;
  }

  public void setSYS_ITEM(String SYS_ITEM) {
    this.SYS_ITEM = SYS_ITEM;
  }

  public String getNEW_FLAG() {
    return NEW_FLAG;
  }

  public void setNEW_FLAG(String NEW_FLAG) {
    this.NEW_FLAG = NEW_FLAG;
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

  public String getMO_NUMBER() {
    return MO_NUMBER;
  }

  public void setMO_NUMBER(String MO_NUMBER) {
    this.MO_NUMBER = MO_NUMBER;
  }
}
