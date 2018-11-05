package com.asteelflash.dto;

/**
 * Created by hunter.fei on 2018/8/7.
 */
public class SnImeiDto {

  private String FACTORY_CODE;
  private String FILE_NAME;
  private String SN;
  private String IMEI;
  private String TPS_NAME;
  private String COLLECTION_DATE;
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
