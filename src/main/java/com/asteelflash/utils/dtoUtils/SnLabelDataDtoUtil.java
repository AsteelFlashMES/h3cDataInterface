package com.asteelflash.utils.dtoUtils;

import com.asteelflash.dto.SnLabelDataDto;
import com.asteelflash.entity.model.SnLabelDataModel;
import com.asteelflash.utils.DateUtil;

/**
 * Created by hunter.fei on 2018/8/8.
 */
public class SnLabelDataDtoUtil {

  public static SnLabelDataDto createSnLabelDataDto(SnLabelDataModel snLabelDataModel) {
    SnLabelDataDto snLabelDataDto = new SnLabelDataDto();
    snLabelDataDto.setFACTORY_CODE("B");
    snLabelDataDto.setFILE_NAME("SHIP");
    snLabelDataDto.setMO_NUMBER(snLabelDataModel.getOrder_number());
    snLabelDataDto.setSERIAL_NUMBER(snLabelDataModel.getSerial_number1().toUpperCase());
    int indexOf0 = snLabelDataModel.getPart_number().indexOf("0");
    snLabelDataDto
        .setITEM_CODE(snLabelDataModel.getPart_number().substring(indexOf0, indexOf0 + 8));
    snLabelDataDto.setFACTORY("B");
    snLabelDataDto.setHARDWARE_VER(snLabelDataModel.getPart_revision());
    snLabelDataDto.setSOFTWARE_VER(
        (null == snLabelDataModel.getSoftware_version() || snLabelDataModel.getSoftware_version()
            .equals("") || snLabelDataModel.getSerial_number().startsWith("0")) ? "N/A"
            : snLabelDataModel.getSoftware_version());
    snLabelDataDto.setVENDOR_CODE(
        (null == snLabelDataModel.getPower_code() || snLabelDataModel.getPower_code().equals(""))
            ? "N/A" : snLabelDataModel.getPower_code());
    snLabelDataDto.setORIGIN_COUNTRY(
        (null == snLabelDataModel.getPower_origin() || snLabelDataModel.getPower_origin()
            .equals("")) ? "CHINA" : snLabelDataModel.getPower_origin());

    if (null != snLabelDataModel.getQualityGrade() && snLabelDataModel.getQualityGrade()
        .startsWith("300")) {
      snLabelDataDto.setGRADE("AA");
    } else {
      if (null == snLabelDataModel.getQualityGrade() || snLabelDataModel.getQualityGrade()
          .equals("")) {
        snLabelDataDto.setGRADE("FF");
      } else {
        snLabelDataDto.setGRADE(snLabelDataModel.getQualityGrade());
      }
    }
    snLabelDataDto.setSTATE_5000(
        (null == snLabelDataModel.getStatus() || snLabelDataModel.getStatus().equals("")) ? "NA"
            : snLabelDataModel.getStatus());

    snLabelDataDto.setASS_DATE(DateUtil.formatDate(snLabelDataModel.getComplete_time()));
    if (snLabelDataModel.getPart_number().substring(snLabelDataModel.getPart_number().length() - 6)
        .toUpperCase().equals("-NROHS")) {
      snLabelDataDto.setENVIRONMENT_STATE("N*");
    } else {
      if (null != snLabelDataModel.getPB_02Part() && snLabelDataModel.getPB_02Part().contains("Y2")
          && !snLabelDataModel.getPB_02Part()
          .contains("Y1")
          && !snLabelDataModel.getPB_02Part().contains("Y3") && !snLabelDataModel.getPB_02Part()
          .contains("Y4")
          && !snLabelDataModel.getPB_02Part().contains("N1") && !snLabelDataModel.getPB_02Part()
          .contains("N3")
          && !snLabelDataModel.getPB_02Part().contains("N4")) {
        snLabelDataDto.setENVIRONMENT_STATE("R6-NPb");
      } else if (null != snLabelDataModel.getPB_02Part() && snLabelDataModel.getPB_02Part()
          .contains("Y4")) {
        snLabelDataDto.setENVIRONMENT_STATE("R4-NPb");
      } else if (null != snLabelDataModel.getPB_02Part() && snLabelDataModel.getPB_02Part()
          .contains("Y3")) {
        snLabelDataDto.setENVIRONMENT_STATE("R4-Pb");
      } else if (null != snLabelDataModel.getPB() && (
          snLabelDataModel.getPB().trim().toUpperCase().equals("Y4") || snLabelDataModel
              .getPB().trim().toUpperCase().equals("N4"))) {
        snLabelDataDto.setENVIRONMENT_STATE("R4-NPb");
      } else if (null != snLabelDataModel.getPB() && (
          snLabelDataModel.getPB().trim().toUpperCase().equals("Y1") || snLabelDataModel
              .getPB().trim().toUpperCase().equals("Y3")
              || snLabelDataModel.getPB().trim().toUpperCase().equals("Y*") || snLabelDataModel
              .getPB()
              .trim().toUpperCase().equals("N1")
              || snLabelDataModel.getPB().trim().toUpperCase().equals("N3") || snLabelDataModel
              .getPB()
              .trim().toUpperCase().equals("N*"))) {
        snLabelDataDto.setENVIRONMENT_STATE("R4-Pb");
      } else if (null != snLabelDataModel.getPB() && (
          snLabelDataModel.getPB().trim().toUpperCase().equals("Y2") || snLabelDataModel
              .getPB().trim().toUpperCase().equals("N2"))) {
        snLabelDataDto.setENVIRONMENT_STATE("R6-NPb");
      } else if (snLabelDataModel.getPB_ASSIGN() > 0) {
        snLabelDataDto.setENVIRONMENT_STATE("R4-NPb");
      } else if (null != snLabelDataModel.getPB() && (
          snLabelDataModel.getPB().trim().toUpperCase().equals("PB")
              || snLabelDataModel.getPB().trim().length() == 0)) {
//        if (snLabelDataModel.getSerial_number1().trim().toUpperCase().startsWith("CN")) {
//          if (snLabelDataModel.getR4_Exclude() > 0 || (
//              snLabelDataModel.getSerial_number1().substring(2, 3).compareTo("2") <= 0
//                  && snLabelDataModel.getSerial_number1().substring(3, 4).compareTo("4") <= 0
//                  && !snLabelDataModel.getSerial_number1().substring(3, 4).equals("0"))) {
//            snLabelDataDto.setENVIRONMENT_STATE("R4-Pb");
//          } else {
//            snLabelDataDto.setENVIRONMENT_STATE("R4-Pb");
//          }
//        } else {
//          if (snLabelDataModel.getR4_Exclude() > 0 || (
//              snLabelDataModel.getSerial_number1().substring(11, 13).compareTo("12") <= 0 &&
//                  snLabelDataModel.getSerial_number1().substring(13, 14).compareTo("4") <= 0)) {
//            snLabelDataDto.setENVIRONMENT_STATE("R4-Pb");
//          } else {
//            snLabelDataDto.setENVIRONMENT_STATE("R4-Pb");
//          }
//        }
        //从原先VB代码来看，不需要做判断，值都一样
        snLabelDataDto.setENVIRONMENT_STATE("R4-Pb");
      } else if (null != snLabelDataModel.getPB() && snLabelDataModel.getPB().trim().toUpperCase()
          .equals("/")) {
        snLabelDataDto.setENVIRONMENT_STATE("/");
      } else if (null != snLabelDataModel.getSerial_number1() && snLabelDataModel
          .getSerial_number1().startsWith("0")) {
        if (snLabelDataModel.getSerial_number1()
            .substring(snLabelDataModel.getSerial_number1().length() - 6,
                snLabelDataModel.getSerial_number1().length() - 5).equals("9")) {
          snLabelDataDto.setENVIRONMENT_STATE("R6-NPb");
        } else {
          snLabelDataDto.setENVIRONMENT_STATE("R6-NPb");
        }
      } else {
        if (null != snLabelDataModel.getSerial_number() &&
            snLabelDataModel.getSerial_number().trim().toUpperCase().startsWith("CN")) {
          if (snLabelDataModel.getR4_Exclude() > 0 || (
              snLabelDataModel.getSerial_number1().substring(2, 3).compareTo("5") <= 0
                  && snLabelDataModel.getSerial_number1().substring(3, 4).compareTo("6") <= 0
                  && !snLabelDataModel.getSerial_number1().substring(3, 4).equals("0"))) {
            snLabelDataDto.setENVIRONMENT_STATE("R4-Pb");
          } else {
            snLabelDataDto.setENVIRONMENT_STATE("R6-NPb");
          }
        } else {
          if (snLabelDataModel.getR4_Exclude() > 0 || (
              snLabelDataModel.getSerial_number1().substring(11, 13).compareTo("15") <= 0
                  && snLabelDataModel.getSerial_number1().substring(13, 14).compareTo("6") <= 0)) {
            snLabelDataDto.setENVIRONMENT_STATE("R4-Pb");
          } else {
            snLabelDataDto.setENVIRONMENT_STATE("R6-NPb");
          }
        }
      }

    }
    snLabelDataDto.setREFORMED("N");
    snLabelDataDto.setOLD_SN("N/A");

    return snLabelDataDto;
  }
}
