package com.asteelflash.utils.dtoUtils;

import com.asteelflash.dto.SnPcbRelationDto;
import com.asteelflash.entity.model.SnPcbRelationModel;
import com.asteelflash.utils.DateUtil;
import com.asteelflash.utils.SqlUtil;
import java.util.List;
import java.util.Map;

/**
 * Created by hunter.fei on 2018/8/2.
 */
public class SnPcbRelationDtoUtil {

  public static SnPcbRelationDto createSnPcbRelationDto(SnPcbRelationModel snPcbRelationModel) {

    SnPcbRelationDto snPcbRelationDto = new SnPcbRelationDto();
    if (null != snPcbRelationModel.getPart_serial() && snPcbRelationModel.getPart_serial()
        .startsWith("21")) {
      snPcbRelationDto.setITEM_CODE(snPcbRelationModel.getPart_serial().substring(2, 10));
    } else if (null != snPcbRelationModel.getPart_serial() && snPcbRelationModel.getPart_serial()
        .toUpperCase().startsWith("CN")) {
      String sql =
          "select part_number from unit with(NOLOCK) where serial_number='" + snPcbRelationModel
              .getPart_serial() + "'";
      List<Map<String, Object>> result = SqlUtil.query(sql);
      if (null != result && result.size() > 0) {
        String partNumber = (String) result.get(0).get("part_number");
        if (null != partNumber && partNumber.length() > 8) {
          snPcbRelationDto.setITEM_CODE(
              partNumber.substring(partNumber.indexOf("0"), partNumber.indexOf("0") + 8));
        }
      }
    } else {
      snPcbRelationDto.setITEM_CODE("03" + snPcbRelationModel.getPart_serial().substring(0, 6));
    }
    snPcbRelationDto.setFACTORY_CODE("B");
    snPcbRelationDto.setFILE_NAME("BASE DATA3");
    snPcbRelationDto.setPCB_NUMBER(snPcbRelationModel.getPart_serial().trim());
    snPcbRelationDto.setSYS_ITEM(snPcbRelationModel.getPart_number().substring(3, 11));
    snPcbRelationDto.setSERIAL_NUMBER(snPcbRelationModel.getSerial_number().trim());
    snPcbRelationDto.setASS_DATE(DateUtil.formatDate(snPcbRelationModel.getLast_modified_time()));
    snPcbRelationDto
        .setDEBUG_DATE(DateUtil.formatDate(snPcbRelationModel.getLast_modified_time()));
    if (null != snPcbRelationModel.getStatus() && snPcbRelationModel.getStatus()
        .equals("Unconsumed")) {
      snPcbRelationDto.setREMARKS(snPcbRelationModel.getStatus());
    }
    return snPcbRelationDto;
  }
}
