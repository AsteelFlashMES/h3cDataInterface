package com.asteelflash.utils.dtoUtils;

import com.asteelflash.dto.WipKeyPartsDto;
import com.asteelflash.entity.model.WipKeyPartsModel;
import com.asteelflash.utils.DB2Util;
import com.asteelflash.utils.DateUtil;
import com.asteelflash.utils.SqlUtil;
import java.util.List;
import java.util.Map;

/**
 * Created by hunter.fei on 2018/8/1.
 */
public class WipKeyPartsDtoUtil {


  public static WipKeyPartsDto crateDto(WipKeyPartsModel wipKeyPartsModel,
      String material_part_number, String supplier_pn, String item_id2, WipKeyPartsDto oldDto) {
    WipKeyPartsDto wipKeyPartsDto = new WipKeyPartsDto();
    wipKeyPartsDto.setSERIAL_NUMBER(wipKeyPartsModel.getProduct_id());
    int indexOfPn = wipKeyPartsModel.getProduct_pn().indexOf("0");
    wipKeyPartsDto
        .setITEM_CODE(wipKeyPartsModel.getProduct_pn().substring(indexOfPn, indexOfPn + 8));
    wipKeyPartsDto.setKEYPART_ITEM_CODE(wipKeyPartsModel.getRaw_mat_pn().replaceAll("-Z0", ""));
    wipKeyPartsDto.setMANUFACTURE_NPM(wipKeyPartsModel.getRaw_mat_supplier_pn());
    if (null != wipKeyPartsModel.getUdf_02() && wipKeyPartsModel.getUdf_02().length() > 0) {
      wipKeyPartsDto.setDATE_CODE(wipKeyPartsModel.getUdf_02());
    } else {
      if (null != wipKeyPartsModel.getUdf_01() && wipKeyPartsModel.getUdf_01().length() > 0) {
        wipKeyPartsDto.setDATE_CODE(wipKeyPartsModel.getUdf_01());
      } else {
        wipKeyPartsDto.setDATE_CODE(wipKeyPartsModel.getRaw_mat_id());
      }
    }
    if (null != wipKeyPartsModel.getSnapshot_tmst()) {
      wipKeyPartsDto.setASS_DATE(DateUtil.formatDate(wipKeyPartsModel.getSnapshot_tmst()));
    }
    wipKeyPartsDto.setASS_DESC("");
    if (null != wipKeyPartsModel.getRaw_mat_pn() && (
        wipKeyPartsModel.getRaw_mat_pn().toUpperCase().startsWith("HWH05") || wipKeyPartsModel
            .getRaw_mat_pn().toUpperCase().startsWith("HUE05"))) {
      String sql = "SELECT PART_NUMBER FROM CGS.PART_NUMBER WHERE PART_NUMBER_KEY in"
          + " (SELECT SOURCE_PN_KEY FROM CGS.PN_LINK WHERE PN_LINK_CTX_KEY=2 AND TARGET_PN_KEY "
          + " in (SELECT PART_NUMBER_KEY FROM CGS.PART_NUMBER WHERE PART_NUMBER = '"
          + wipKeyPartsModel.getRaw_mat_pn() + "')) with ur ";
      List<Map<String, Object>> result = DB2Util
          .db2Query("jdbc:db2://10.11.1.16:50000/cgs", "cgsapp", "T0mcat4Fun", sql);
      if (null != result && result.size() > 0) {
        wipKeyPartsDto
            .setKEYPART_ITEM_CODE(
                ((String) result.get(0).get("PART_NUMBER")).replaceAll("-Z0", ""));
      }
    }
    if (null != wipKeyPartsDto.getKEYPART_ITEM_CODE() && (
        wipKeyPartsDto.getKEYPART_ITEM_CODE().startsWith("050") || wipKeyPartsDto
            .getKEYPART_ITEM_CODE()
            .startsWith("070"))) {
      if (wipKeyPartsDto.getKEYPART_ITEM_CODE().length() >= 18) {
        wipKeyPartsDto.setSUPPLY_CODE(wipKeyPartsDto.getKEYPART_ITEM_CODE().substring(9, 17));
      }
    } else {
      if (null != wipKeyPartsDto.getKEYPART_ITEM_CODE()
          && wipKeyPartsDto.getKEYPART_ITEM_CODE().length() >= 17) {
        if (wipKeyPartsDto.getKEYPART_ITEM_CODE().startsWith("HUWHC")) {
          wipKeyPartsDto
              .setKEYPART_ITEM_CODE(wipKeyPartsDto.getKEYPART_ITEM_CODE().substring(6, 14));
        } else {
          if (wipKeyPartsDto.getKEYPART_ITEM_CODE().startsWith("H")) {
            wipKeyPartsDto
                .setKEYPART_ITEM_CODE(wipKeyPartsDto.getKEYPART_ITEM_CODE().substring(3, 11));
          } else {
            if ((wipKeyPartsDto.getKEYPART_ITEM_CODE().startsWith("0502") ||
                wipKeyPartsDto.getKEYPART_ITEM_CODE().startsWith("0702")) &&
                wipKeyPartsDto.getKEYPART_ITEM_CODE().length() == 17) {
              wipKeyPartsDto.setKEYPART_ITEM_CODE(wipKeyPartsDto.getKEYPART_ITEM_CODE()
                  .substring(wipKeyPartsDto.getKEYPART_ITEM_CODE().length() - 8));
            } else {
              wipKeyPartsDto
                  .setKEYPART_ITEM_CODE(wipKeyPartsDto.getKEYPART_ITEM_CODE().substring(2, 10));
            }
          }
        }
      }
    }
    if (null != material_part_number && null != supplier_pn && null != item_id2
        && material_part_number.equals(wipKeyPartsModel.getProduct_pn().trim()) && supplier_pn
        .equals(wipKeyPartsModel.getRaw_mat_supplier_pn().trim()) && item_id2
        .equals(wipKeyPartsModel.getUdf_01().trim())) {
      if (null != oldDto) {
        wipKeyPartsDto.setKEYPART_ITEM_CODE(oldDto.getKEYPART_ITEM_CODE());
        wipKeyPartsDto.setSUPPLY_CODE(oldDto.getSUPPLY_CODE());
        wipKeyPartsDto.setSUPPLY_NAME(oldDto.getSUPPLY_NAME());
        wipKeyPartsDto.setMANUFACTURE_NAME(oldDto.getMANUFACTURE_NAME());
      }
    } else {
      material_part_number = wipKeyPartsModel.getProduct_pn();
      supplier_pn = wipKeyPartsModel.getRaw_mat_supplier_pn();
      item_id2 = (null == wipKeyPartsModel.getUdf_01() ? "" : wipKeyPartsModel.getUdf_01());
      String sqlForUid = "";
      if (null != wipKeyPartsModel.getRaw_mat_id() && wipKeyPartsModel.getRaw_mat_id()
          .startsWith("L0") && (
          wipKeyPartsModel.getRaw_mat_id().length() == 12
              || wipKeyPartsModel.getRaw_mat_id().length() == 20)) {
        sqlForUid =
            "SELECT SUPPLIER_NAME_S,SUPPLIER_CODE_S FROM AT_at_afg_wms_deliever with(NOLOCK)"
                + " where UID_S='" + wipKeyPartsModel.getRaw_mat_id().substring(0, 12) + "'";
      } else {
        sqlForUid = "SELECT top 1 SUPPLIER_NAME_S,SUPPLIER_CODE_S FROM AT_at_afg_wms_deliever "
            + "with(NOLOCK) where SUPPLIER_PN_S='" + wipKeyPartsModel.getRaw_mat_supplier_pn()
            + "' and left(part_number_s,2)='HW' order by creation_time desc";
      }
      List<Map<String, Object>> resultForUid = SqlUtil.query(sqlForUid);
      if (null != resultForUid && resultForUid.size() > 0) {
        if (null != resultForUid.get(0).get("SUPPLIER_CODE_S")
            && ((String) resultForUid.get(0).get("SUPPLIER_CODE_S")).length() > 0) {
          String supplierCode = (String) resultForUid.get(0).get("SUPPLIER_CODE_S");
          wipKeyPartsDto.setSUPPLY_CODE(supplierCode.substring(supplierCode.length() - 6));
          wipKeyPartsDto.setSUPPLY_NAME((String) resultForUid.get(0).get("SUPPLIER_NAME_S"));
          String sqlForVendor = "SELECT HWVCODE,HWVNAME FROM DSVendor with(NOLOCK) where "
              + "SAPVCODE='" + supplierCode.substring(supplierCode.length() - 6) + "' ";
          List<Map<String, Object>> vendorResult = SqlUtil.query(sqlForVendor);
          if (null != vendorResult && vendorResult.size() > 0) {
            wipKeyPartsDto.setSUPPLY_CODE((String) vendorResult.get(0).get("HWVCODE"));
          }
        } else {
          wipKeyPartsDto.setSUPPLY_CODE("141078");
          wipKeyPartsDto.setSUPPLY_NAME("B");
        }
      } else {
        wipKeyPartsDto.setSUPPLY_CODE("141078");
        wipKeyPartsDto.setSUPPLY_NAME("B");
      }

      String sqlForDSManufacturer = "select H3C from DSManufacturer with(NOLOCK) where AFG ='"
          + wipKeyPartsModel.getRaw_mat_supplier_name() + "'";
      List<Map<String, Object>> resultForDSManufacturer = SqlUtil.query(sqlForDSManufacturer);
      if (null != resultForDSManufacturer && resultForDSManufacturer.size() > 0) {
        wipKeyPartsDto.setMANUFACTURE_NAME((String) resultForDSManufacturer.get(0).get("H3C"));
      } else {
        wipKeyPartsDto.setMANUFACTURE_NAME(wipKeyPartsModel.getRaw_mat_supplier_name().trim());
      }
      if (null != wipKeyPartsDto.getKEYPART_ITEM_CODE() && wipKeyPartsDto.getKEYPART_ITEM_CODE()
          .startsWith("0512")) {
        String sqlForDSCFPARTConvert = "select H3C from DSCFPARTConvert with(NOLOCK) where AFG='"
            + wipKeyPartsDto.getKEYPART_ITEM_CODE() + "'";
        List<Map<String, Object>> resultForDSCFPARTConvert = SqlUtil.query(sqlForDSCFPARTConvert);
        if (null != resultForDSCFPARTConvert && resultForDSCFPARTConvert.size() > 0) {
          wipKeyPartsDto
              .setKEYPART_ITEM_CODE(((String) resultForDSCFPARTConvert.get(0).get("H3C")).trim());
        }
      }
    }

    return wipKeyPartsDto;
  }
}
