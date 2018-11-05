package com.asteelflash.utils.modelUtils;

import com.asteelflash.entity.model.LotReturnModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by hunter.fei on 2018/7/24.
 */
public class LotReturnModelUtil {

  public static List<LotReturnModel> castEntity(List<Map<String, Object>> list) {
    List<LotReturnModel> lotReturnModels = new ArrayList<>();
    if (list != null && list.size() > 0) {
      for (Map<String, Object> map : list) {
        LotReturnModel lotReturnModel = new LotReturnModel();
        lotReturnModel.setIdno((String) map.get("idno"));
        lotReturnModel.setWo((String) map.get("wo"));
        lotReturnModel.setReleased_qty((String) map.get("released_qty"));
        lotReturnModel.setNum((Integer) map.get("num"));
        lotReturnModel.setLink((String) map.get("link"));
        lotReturnModel.setRdate((java.sql.Timestamp) map.get("rdate"));
        lotReturnModel.setProportion((String) map.get("proportion"));
        lotReturnModel.setMfg_part_number((String) map.get("mfg_part_number"));
        lotReturnModel.setVendor_code((String) map.get("vendor_code"));
        lotReturnModel.setUsed_num((Integer) map.get("used_num"));
        lotReturnModel.setBuliang_num((Integer) map.get("buliang_num"));
        lotReturnModel.setRemark((String) map.get("remark"));
        lotReturnModel.setRdemo((String) map.get("rdemo"));
        lotReturnModels.add(lotReturnModel);
      }
    }
    return lotReturnModels;
  }
}
