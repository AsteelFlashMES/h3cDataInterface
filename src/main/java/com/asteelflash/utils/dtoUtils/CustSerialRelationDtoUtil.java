package com.asteelflash.utils.dtoUtils;

import com.asteelflash.dto.CustSerialRelationDto;
import com.asteelflash.entity.model.CustSerialRelationModel;
import com.asteelflash.utils.DateUtil;

/**
 * Created by hunter.fei on 2018/8/6.
 */
public class CustSerialRelationDtoUtil {

  public static CustSerialRelationDto createCustSerialRelationDto(
      CustSerialRelationModel custSerialRelationModel) {
    CustSerialRelationDto custSerialRelationDto = new CustSerialRelationDto();
    custSerialRelationDto.setSERIAL_NO(custSerialRelationModel.getSerial_number());
    custSerialRelationDto.setCUST_SERIAL_NO(custSerialRelationModel.getComponent_SN());
    custSerialRelationDto
        .setPACK_DATE(DateUtil.formatDate(custSerialRelationModel.getCreation_time()));
    custSerialRelationDto.setFACTORY_CODE("B");
    custSerialRelationDto.setFILE_NAME("HP");
    return custSerialRelationDto;
  }
}
