package com.asteelflash.utils.dtoUtils;

import com.asteelflash.dto.ProdFitDefectDto;
import com.asteelflash.entity.model.ProdFitDefectModel;

/**
 * Created by hunter.fei on 2018/7/31.
 */
public class ProdFitDefectDtoUtil {

  public static ProdFitDefectDto createProdFitDefectDto(ProdFitDefectModel prodFitDefectModel) {
    ProdFitDefectDto prodFitDefectDto = new ProdFitDefectDto();

    prodFitDefectDto.setTEST_ID(String.valueOf(prodFitDefectModel.getOrder_key()));
    prodFitDefectDto.setSERIAL_NUMBER(prodFitDefectModel.getSerial_number());
    prodFitDefectDto.setDEFECT_CODE(prodFitDefectModel.getDefect().substring(0,5).trim());
    prodFitDefectDto.setDEFECT_DESC(prodFitDefectModel.getSymptomcode());
    if(prodFitDefectModel.getPart_number().substring(2,3).equals("0")){
      prodFitDefectDto.setITEM_CODE(prodFitDefectModel.getPart_number().substring(2,10));
    }else {
      prodFitDefectDto.setITEM_CODE(prodFitDefectModel.getPart_number().substring(3,11));
    }
    prodFitDefectDto.setFACTORY("B");
    prodFitDefectDto.setFACTORY_CODE("B");
    prodFitDefectDto.setFILE_NAME("ASSEMBLY DEFECT");
    return prodFitDefectDto;
  }
}
