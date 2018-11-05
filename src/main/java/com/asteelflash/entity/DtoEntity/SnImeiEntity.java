package com.asteelflash.entity.DtoEntity;

import com.asteelflash.entity.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by hunter.fei on 2018/8/7.
 */
@Entity
@Table(name = "SnImeiEntity")
public class SnImeiEntity extends BaseEntity {

  @Column(name = "factory_code")
  private String FACTORY_CODE;
  @Column(name = "file_name")
  private String FILE_NAME;
  @Column(name = "sn")
  private String SN;
  @Column(name = "imei")
  private String IMEI;
  @Column(name = "tps_name")
  private String TPS_NAME;
  @Column(name = "collection_date")
  private String COLLECTION_DATE;
  @Column(name = "remark")
  private String REMARK;

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

  public String getSN() {
    return SN;
  }

  public void setSN(String SN) {
    this.SN = SN;
  }

  public String getIMEI() {
    return IMEI;
  }

  public void setIMEI(String IMEI) {
    this.IMEI = IMEI;
  }

  public String getTPS_NAME() {
    return TPS_NAME;
  }

  public void setTPS_NAME(String TPS_NAME) {
    this.TPS_NAME = TPS_NAME;
  }

  public String getCOLLECTION_DATE() {
    return COLLECTION_DATE;
  }

  public void setCOLLECTION_DATE(String COLLECTION_DATE) {
    this.COLLECTION_DATE = COLLECTION_DATE;
  }

  public String getREMARK() {
    return REMARK;
  }

  public void setREMARK(String REMARK) {
    this.REMARK = REMARK;
  }
}
