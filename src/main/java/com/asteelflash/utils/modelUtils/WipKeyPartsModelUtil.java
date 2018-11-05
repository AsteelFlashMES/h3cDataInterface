package com.asteelflash.utils.modelUtils;

import com.asteelflash.entity.model.WipKeyPartsModel;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by hunter.fei on 2018/8/1.
 */
public class WipKeyPartsModelUtil {

  public static List<WipKeyPartsModel> castEntity(List<Map<String, Object>> result) {
    List<WipKeyPartsModel> wipKeyPartsModels = new ArrayList<>();
    if (null != result && result.size() > 0) {
      for (Map<String, Object> map : result) {
        WipKeyPartsModel wipKeyPartsModel = new WipKeyPartsModel();
        wipKeyPartsModel.setProduct_id((String) map.get("PRODUCT_ID"));
        wipKeyPartsModel.setRaw_mat_pn((String)map.get("RAW_MAT_PN"));
        wipKeyPartsModel.setRaw_mat_supplier_pn((String)map.get("RAW_MAT_SUPPLIER_PN"));
        wipKeyPartsModel.setRaw_mat_supplier_name((String)map.get("RAW_MAT_SUPPLIER_NAME"));
        wipKeyPartsModel.setRaw_mat_id((String)map.get("RAW_MAT_ID"));
        wipKeyPartsModel.setSnapshot_tmst((Timestamp)map.get("SNAPSHOT_TMST"));
        wipKeyPartsModel.setProduct_pn((String)map.get("PRODUCT_PN"));
        wipKeyPartsModel.setUdf_01((String)map.get("UDF_01"));
        wipKeyPartsModel.setUdf_02((String)map.get("UDF_02"));
        wipKeyPartsModel.setUdf_03((String)map.get("UDF_03"));

        wipKeyPartsModels.add(wipKeyPartsModel);
      }
    }
    return wipKeyPartsModels;
  }
}
