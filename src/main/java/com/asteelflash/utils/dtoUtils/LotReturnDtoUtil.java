package com.asteelflash.utils.dtoUtils;

import com.asteelflash.dto.LotReturnDto;
import com.asteelflash.entity.model.LotReturnModel;
import java.text.SimpleDateFormat;

/**
 * Created by hunter.fei on 2018/6/26.
 */
public class LotReturnDtoUtil {

  private static SimpleDateFormat sfd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  public static LotReturnDto createLotReturnDto(LotReturnModel lotReturnModel) {
    LotReturnDto lotReturnDto = new LotReturnDto();
    if(null != lotReturnModel) {
      lotReturnDto.setPART_CODE(lotReturnModel.getIdno());
      lotReturnDto.setMO_NUMBER(lotReturnModel.getWo());
      lotReturnDto.setLOT_QTY(lotReturnModel.getNum());
      lotReturnDto.setUSED_QTY(lotReturnModel.getUsed_num());
      lotReturnDto.setFAIL_QTY(lotReturnModel.getBuliang_num());
      lotReturnDto.setSUPPLY_CODE(lotReturnModel.getVendor_code());

      lotReturnDto.setREPORT_DEP(lotReturnModel.getLink());
      lotReturnDto.setWORK_DAY(sfd.format(lotReturnModel.getRdate()));
      lotReturnDto.setREMARK(lotReturnModel.getRdemo());
      lotReturnDto.setMANUFACTRUE_NAME(lotReturnModel.getRemark());
      lotReturnDto.setFACTORY_CODE("B");
      lotReturnDto.setFILE_NAME("RETURN MATERIAL");
    }
    return lotReturnDto;
  }
}
