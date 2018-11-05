package com.asteelflash.utils.dtoUtils;

import com.asteelflash.dto.SnImeiDto;
import com.asteelflash.entity.model.SnImeiModel;
import com.asteelflash.utils.DateUtil;

/**
 * Created by hunter.fei on 2018/8/7.
 */
public class SnImeiDtoUtil {

  public static SnImeiDto createSnImeiDto(SnImeiModel snImeiModel) {
    SnImeiDto snImeiDto = new SnImeiDto();
    snImeiDto.setSN(snImeiModel.getSerial_number());
    snImeiDto.setIMEI(snImeiModel.getComponent_SN());
    snImeiDto.setCOLLECTION_DATE(DateUtil.formatDate(snImeiModel.getCreation_time()));
    snImeiDto.setFACTORY_CODE("B");
    snImeiDto.setFILE_NAME("IMEI");
    return snImeiDto;
  }
}
