package com.asteelflash.entity.DtoEntity;

import com.asteelflash.entity.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by hunter.fei on 2018/8/7.
 */
@Entity
@Table(name = "CmEcEntity")
public class CmEcEntity extends BaseEntity {

  @Column(name = "factory_code")
  private String FACTORY_CODE;
  @Column(name = "file_name")
  private String FILE_NAME;
  @Column(name = "serial_number")
  private String SERIAL_NUMBER;
  @Column(name = "l_number")
  private String L_NUMBER;
  @Column(name = "ec_date")
  private String EC_DATE;
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

  public String getSERIAL_NUMBER() {
    return SERIAL_NUMBER;
  }

  public void setSERIAL_NUMBER(String SERIAL_NUMBER) {
    this.SERIAL_NUMBER = SERIAL_NUMBER;
  }

  public String getL_NUMBER() {
    return L_NUMBER;
  }

  public void setL_NUMBER(String l_NUMBER) {
    L_NUMBER = l_NUMBER;
  }

  public String getEC_DATE() {
    return EC_DATE;
  }

  public void setEC_DATE(String EC_DATE) {
    this.EC_DATE = EC_DATE;
  }

  public String getREMARK() {
    return REMARK;
  }

  public void setREMARK(String REMARK) {
    this.REMARK = REMARK;
  }
}
