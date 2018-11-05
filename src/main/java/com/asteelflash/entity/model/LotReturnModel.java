package com.asteelflash.entity.model;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by hunter.fei on 2018/6/26.
 * retrun material use.
 */
public class LotReturnModel {

  private String idno;
  private String wo;
  private String released_qty;
  private Integer num;
  private String link;
  private Timestamp rdate;
  private String proportion;
  private String mfg_part_number;
  private String vendor_code;
  private Integer used_num;
  private Integer buliang_num;
  private String remark;
  private String rdemo;

  public String getIdno() {
    return idno;
  }

  public void setIdno(String idno) {
    this.idno = idno;
  }

  public String getWo() {
    return wo;
  }

  public void setWo(String wo) {
    this.wo = wo;
  }

  public String getReleased_qty() {
    return released_qty;
  }

  public void setReleased_qty(String released_qty) {
    this.released_qty = released_qty;
  }

  public Integer getNum() {
    return num;
  }

  public void setNum(Integer num) {
    this.num = num;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public Timestamp getRdate() {
    return rdate;
  }

  public void setRdate(Timestamp rdate) {
    this.rdate = rdate;
  }

  public String getProportion() {
    return proportion;
  }

  public void setProportion(String proportion) {
    this.proportion = proportion;
  }

  public String getMfg_part_number() {
    return mfg_part_number;
  }

  public void setMfg_part_number(String mfg_part_number) {
    this.mfg_part_number = mfg_part_number;
  }

  public String getVendor_code() {
    return vendor_code;
  }

  public void setVendor_code(String vendor_code) {
    this.vendor_code = vendor_code;
  }

  public Integer getUsed_num() {
    return used_num;
  }

  public void setUsed_num(Integer used_num) {
    this.used_num = used_num;
  }

  public Integer getBuliang_num() {
    return buliang_num;
  }

  public void setBuliang_num(Integer buliang_num) {
    this.buliang_num = buliang_num;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String getRdemo() {
    return rdemo;
  }

  public void setRdemo(String rdemo) {
    this.rdemo = rdemo;
  }

  public LotReturnModel() {
  }

  public LotReturnModel(String idno, String wo, String released_qty, Integer num, String link,
      Timestamp rdate, String proportion, String mfg_part_number, String vendor_code, Integer used_num,
      Integer buliang_num, String remark, String rdemo) {
    this.idno = idno;
    this.wo = wo;
    this.released_qty = released_qty;
    this.num = num;
    this.link = link;
    this.rdate = rdate;
    this.proportion = proportion;
    this.mfg_part_number = mfg_part_number;
    this.vendor_code = vendor_code;
    this.used_num = used_num;
    this.buliang_num = buliang_num;
    this.remark = remark;
    this.rdemo = rdemo;
  }
}

