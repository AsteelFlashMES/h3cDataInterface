package com.asteelflash.utils.dtoUtils;

import com.asteelflash.dto.CmEcDto;
import com.asteelflash.entity.model.CmEcModel;
import com.asteelflash.utils.DateUtil;

/**
 * Created by hunter.fei on 2018/8/7.
 */
public class CmEcDtoUtil {

  public static CmEcDto createCmEcDto(CmEcModel cmEcModel) {
    CmEcDto cmEcDto = new CmEcDto();
    cmEcDto.setSERIAL_NUMBER(cmEcModel.getSerial_number());
    cmEcDto.setL_NUMBER(cmEcModel.getEC());
    cmEcDto.setEC_DATE(DateUtil.formatDate(cmEcModel.getCreation_time()));
    cmEcDto.setREMARK(cmEcModel.getRemark());
    cmEcDto.setFACTORY_CODE("B");
    cmEcDto.setFILE_NAME("EC");

    return cmEcDto;
  }
}
