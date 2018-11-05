package com.asteelflash.entity.model;

import java.sql.Timestamp;

/**
 * Created by hunter.fei on 2018/8/1.
 */
public class WipKeyPartsModel {

  private String product_id;
  private String raw_mat_pn;
  private String raw_mat_supplier_pn;
  private String raw_mat_supplier_name;
  private String raw_mat_id;
  private java.sql.Timestamp snapshot_tmst;
  private String product_pn;
  private String udf_01;
  private String udf_02;
  private String udf_03;

  public String getProduct_id() {
    return product_id;
  }

  public void setProduct_id(String product_id) {
    this.product_id = product_id;
  }

  public String getRaw_mat_pn() {
    return raw_mat_pn;
  }

  public void setRaw_mat_pn(String raw_mat_pn) {
    this.raw_mat_pn = raw_mat_pn;
  }

  public String getRaw_mat_supplier_pn() {
    return raw_mat_supplier_pn;
  }

  public void setRaw_mat_supplier_pn(String raw_mat_supplier_pn) {
    this.raw_mat_supplier_pn = raw_mat_supplier_pn;
  }

  public String getRaw_mat_supplier_name() {
    return raw_mat_supplier_name;
  }

  public void setRaw_mat_supplier_name(String raw_mat_supplier_name) {
    this.raw_mat_supplier_name = raw_mat_supplier_name;
  }

  public String getRaw_mat_id() {
    return raw_mat_id;
  }

  public void setRaw_mat_id(String raw_mat_id) {
    this.raw_mat_id = raw_mat_id;
  }

  public Timestamp getSnapshot_tmst() {
    return snapshot_tmst;
  }

  public void setSnapshot_tmst(Timestamp snapshot_tmst) {
    this.snapshot_tmst = snapshot_tmst;
  }

  public String getProduct_pn() {
    return product_pn;
  }

  public void setProduct_pn(String product_pn) {
    this.product_pn = product_pn;
  }

  public String getUdf_01() {
    return udf_01;
  }

  public void setUdf_01(String udf_01) {
    this.udf_01 = udf_01;
  }

  public String getUdf_02() {
    return udf_02;
  }

  public void setUdf_02(String udf_02) {
    this.udf_02 = udf_02;
  }

  public String getUdf_03() {
    return udf_03;
  }

  public void setUdf_03(String udf_03) {
    this.udf_03 = udf_03;
  }

  public WipKeyPartsModel() {
  }

  public WipKeyPartsModel(String product_id, String raw_mat_pn, String raw_mat_supplier_pn,
      String raw_mat_supplier_name, String raw_mat_id, Timestamp snapshot_tmst,
      String product_pn, String udf_01, String udf_02, String udf_03) {
    this.product_id = product_id;
    this.raw_mat_pn = raw_mat_pn;
    this.raw_mat_supplier_pn = raw_mat_supplier_pn;
    this.raw_mat_supplier_name = raw_mat_supplier_name;
    this.raw_mat_id = raw_mat_id;
    this.snapshot_tmst = snapshot_tmst;
    this.product_pn = product_pn;
    this.udf_01 = udf_01;
    this.udf_02 = udf_02;
    this.udf_03 = udf_03;
  }
}