package com.asteelflash.utils.dtoUtils;

import com.asteelflash.dto.ZcbPcbRelationDto;
import com.asteelflash.entity.model.ZcbPcbRelationModel;
import com.asteelflash.utils.DateUtil;

/**
 * Created by hunter.fei on 2018/8/3.
 */
public class ZcbPcbRelationDtoUtil {

  public static ZcbPcbRelationDto createZcbPcbRelationDto(ZcbPcbRelationModel zcbPcbRelationModel) {
    ZcbPcbRelationDto zcbPcbRelationDto = new ZcbPcbRelationDto();
    zcbPcbRelationDto.setZCB_ITEM("03" + zcbPcbRelationModel.getPart_serial().substring(0, 6));
    zcbPcbRelationDto.setZCB_NUMBER(zcbPcbRelationModel.getPart_serial());
    zcbPcbRelationDto.setPCB_ITEM("03" + zcbPcbRelationModel.getSerial_number().substring(0, 6));
    zcbPcbRelationDto.setPCB_NUMBER(zcbPcbRelationModel.getSerial_number());
    zcbPcbRelationDto.setASS_DATE(DateUtil.formatDate(zcbPcbRelationModel.getLast_modified_time()));
    zcbPcbRelationDto.setDEBUG_DATE(DateUtil.formatDate(zcbPcbRelationModel.getLast_modified_time()));
    if (null != zcbPcbRelationModel.getStatus() && zcbPcbRelationModel.getStatus()
        .equals("Unconsumed")) {
      zcbPcbRelationDto.setREMARKS(zcbPcbRelationModel.getStatus());
    }
    zcbPcbRelationDto.setFACTORY_CODE("B");
    zcbPcbRelationDto.setFILE_NAME("BASE DATA2");
    return zcbPcbRelationDto;
  }
}
