package com.asteelflash.utils.dtoUtils;

import com.asteelflash.dto.SnVerificationMarkDto;
import com.asteelflash.entity.model.SnVerificationMarkModel;
import com.asteelflash.utils.DateUtil;

/**
 * Created by hunter.fei on 2018/8/6.
 */
public class SnVerificationMarkDtoUtil {

  public static SnVerificationMarkDto createSnVerificationMarkDto(SnVerificationMarkModel snVerificationMarkModel) {
    SnVerificationMarkDto snVerificationMarkDto = new SnVerificationMarkDto();
    snVerificationMarkDto.setMO_NUMBER(snVerificationMarkModel.getOrder_number());
    snVerificationMarkDto.setITEM_CODE(snVerificationMarkModel.getField2());
    snVerificationMarkDto.setSERIAL_NUMBER(snVerificationMarkModel.getSerial_number());
    snVerificationMarkDto.setMARK_NUMBER(snVerificationMarkModel.getUda_9());
    snVerificationMarkDto.setASS_DATE(DateUtil.formatDate(snVerificationMarkModel.getComplete_time()));
    snVerificationMarkDto.setFACTORY_CODE("B");
    snVerificationMarkDto.setFILE_NAME("CODE");
    return snVerificationMarkDto;
  }
}
