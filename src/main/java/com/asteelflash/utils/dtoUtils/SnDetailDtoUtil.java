package com.asteelflash.utils.dtoUtils;

import com.asteelflash.dto.SnDetailDto;
import com.asteelflash.entity.model.SNDetailModel;
import com.asteelflash.entity.model.SNDetailTestModel;
import com.asteelflash.utils.DateUtil;
import com.asteelflash.utils.SqlUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by hunter.fei on 2018/6/15.
 */
public class SnDetailDtoUtil {

  public static SnDetailDto createSnDetailDto(SNDetailModel snDetailModel, String type) {
    if (null == type || type.trim().equals("")) {
      return null;
    }
    SnDetailDto snDetailDto = createProcessSnDetailDto(snDetailModel);
    return snDetailDto;
  }

  public static SnDetailDto createSnDetailDto(SNDetailTestModel snDetailModel, String type) {
    if (null == type || type.trim().equals("")) {
      return null;
    }
    SnDetailDto snDetailDto = createTestSnDetailDto(snDetailModel);
    return snDetailDto;
  }


  private static SnDetailDto createProcessSnDetailDto(SNDetailModel snDetailModel) {
    SnDetailDto snDetailDto = new SnDetailDto();
    String partNumber = snDetailModel.getPart_number().toUpperCase();
    if ((partNumber.contains("HWF0231") || partNumber.contains("HWF0235")
        || snDetailModel.getOrder_number().toUpperCase().startsWith("CN")) && snDetailModel
        .getOp_name().toUpperCase().equals("BOXBUILD")) {
      setProcessSnDetailDtoValue("", snDetailDto, snDetailModel);
    } else if (partNumber.contains("HWF0303")) {
      if (snDetailModel.getRoute_name().toUpperCase().contains("CONSUME2") && snDetailModel
          .getOp_name().toUpperCase().equals("CONSUME2")) {
        setProcessSnDetailDtoValue("", snDetailDto, snDetailModel);
      } else if (null != snDetailModel.getOp_name() && snDetailModel.getOp_name().toUpperCase()
          .equals("CONSUME")) {
        setProcessSnDetailDtoValue("", snDetailDto, snDetailModel);
      }
    } else if (null != snDetailModel.getOp_name() && snDetailModel.getOp_name().toUpperCase()
        .contains("(FGI)")) {
      setProcessSnDetailDtoValue("WH", snDetailDto, snDetailModel);
    } else {

      snDetailDto.setFACTORY_CODE("B");
      snDetailDto.setSERIAL_NUMBER(snDetailModel.getSerial_number());
      snDetailDto.setMO_NUMBER(snDetailModel.getOrder_number());
      snDetailDto.setOUT_FROM("B");
      String tmp_op = "";
      if (null != snDetailModel.getLine() && (snDetailModel.getLine().contains("AOI")
          || snDetailModel.getLine().contains("FQC")
          || snDetailModel.getLine().contains("Wave Solder QC") && !snDetailModel.getLine()
          .contains("Rework"))) {
        if (snDetailModel.getLine().endsWith("NPI")) {
          tmp_op = "NPI";
        } else if (snDetailModel.getLine().substring(snDetailModel.getLine().length() - 3)
            .contains(" ")) {
          tmp_op = snDetailModel.getLine().substring(snDetailModel.getLine().indexOf(" ") + 1);
        } else {
          tmp_op = snDetailModel.getLine();
        }
      }
      snDetailDto.setLINE_CODE(tmp_op);
      snDetailDto.setCLASS_CODE("");
      snDetailDto.setSECTION_CODE(getProcessName(snDetailModel.getOp_name()));

      snDetailDto.setERR_FLAG(
          explainTestCode(snDetailModel.getDefect(), snDetailModel.getComplete_reason()));
      snDetailDto.setPASS_COUNT(Integer.valueOf(snDetailModel.getComplete_count()));
      snDetailDto.setTEST_ID("");
      if ("PASS".equals(snDetailDto.getERR_FLAG())) {
        snDetailDto.setDEFECT_CODE("");
      } else {
        if (null != snDetailModel.getDefect() && snDetailModel.getDefect().length() > 4) {
          snDetailDto.setDEFECT_CODE(snDetailModel.getDefect().substring(0, 4));
        }
      }
      if (null != snDetailModel.getComplete_time()) {
        snDetailDto.setIN_STATION_TIME(DateUtil.formatDate(snDetailModel.getComplete_time()));
      }
      snDetailDto.setTEST_DESC(getNote(snDetailModel.getOp_name()));
      snDetailDto.setFILE_NAME("PROCESS");
    }
    return snDetailDto;
  }

  private static void setProcessSnDetailDtoValue(String value, SnDetailDto snDetailDto,
      SNDetailModel snDetailModel) {
    snDetailDto.setFACTORY_CODE("B");
    snDetailDto.setFILE_NAME("PROCESS");
    snDetailDto.setSERIAL_NUMBER(snDetailModel.getSerial_number());
    snDetailDto.setMO_NUMBER(snDetailModel.getOrder_number());
    snDetailDto.setOUT_FROM("B");
    snDetailDto.setLINE_CODE("");
    snDetailDto.setCLASS_CODE("");
    if (null == value || value.trim().equals("")) {
      snDetailDto.setSECTION_CODE("ONLINE");
    } else {
      snDetailDto.setSECTION_CODE(value);
    }
    snDetailDto.setERR_FLAG("PASS");
    snDetailDto.setPASS_COUNT(1);
    snDetailDto.setTEST_ID("");
    snDetailDto.setDEFECT_CODE("");
    snDetailDto.setIN_STATION_TIME(DateUtil.formatDate(snDetailModel.getComplete_time()));
    snDetailDto.setTEST_DESC("");
  }


  private static SnDetailDto createTestSnDetailDto(SNDetailTestModel snDetailModel) {
    SnDetailDto snDetailDto = new SnDetailDto();
    String serialnumber = snDetailModel.getSerial_number();
    snDetailDto.setFACTORY_CODE("B");
    snDetailDto.setSERIAL_NUMBER(snDetailModel.getSerial_number());
    snDetailDto.setMO_NUMBER(snDetailModel.getOrder_number());
    snDetailDto.setOUT_FROM("B");

    snDetailDto.setSECTION_CODE(getTestName(snDetailModel.getOp_name()));
    if (null != snDetailModel.getOp_name() && null != snDetailDto.getSECTION_CODE() && snDetailModel
        .getOp_name().equals("FT(FGI)") && snDetailDto.getSECTION_CODE()
        .equals("ST62")) {
      String sql = "select * from tracked_object_history with(NOLOCK) where tobj_key in " +
          "(select unit_key from unit with(NOLOCK) where serial_number='" + serialnumber + " ') " +
          "and (op_name='Functional Test' or op_name='Functional Test2') ";
      List<Map<String, Object>> result = SqlUtil.query(sql);
      if (null == result || result.size() == 0) {
        snDetailDto.setSECTION_CODE("ST66");
      }
    }
    snDetailDto.setERR_FLAG(explainTestCode(snDetailModel.getSymptomcode(),snDetailModel.getComplete_reason()));
    if ("PASS".equals(snDetailDto.getERR_FLAG())) {
      snDetailDto.setERR_DESC("");
    } else {
      snDetailDto.setERR_DESC(snDetailModel.getSymptomcode());
    }
    snDetailDto.setPASS_COUNT(Integer.valueOf(snDetailModel.getComplete_count()));
    snDetailDto.setTEST_ID(snDetailModel.getComplete_user_name());
    snDetailDto.setIN_STATION_TIME(DateUtil.formatDate(snDetailModel.getComplete_time()));
    snDetailDto.setTEST_DESC(snDetailModel.getEquip_1());
    if (null != snDetailDto.getSECTION_CODE() && snDetailDto.getSECTION_CODE()
        .equals("Pre Hi Pot")) {
      snDetailDto.setTEST_DESC("耐压");
    }
    if (null != snDetailDto.getSECTION_CODE() && snDetailDto.getSECTION_CODE().equals("ICT")) {
      String sql = "Select case when charindex('_TASK_',c.part_serial)>0 then "
          + "substring(c.part_serial,0,charindex('_TASK_',c.part_serial)) else c.part_serial "
          + "end as part_serial From consumed_part c with(NOLOCK) where c.tobj_key = "
          + snDetailModel.getTobj_key() + " and c.status='Consumed' ";
      List<Map<String, Object>> result = SqlUtil.query(sql);
      if (null != result && result.size() > 0) {
        snDetailDto.setSERIAL_NUMBER(result.get(0).get("part_serial").toString());
      }
    }
    snDetailDto.setFILE_NAME("TEST");
    return snDetailDto;
  }


  public static void moveProcessInvalidData(List<SNDetailModel> snDetailModelList) {
    Iterator<SNDetailModel> iterator = snDetailModelList.iterator();
    while (iterator.hasNext()) {
      SNDetailModel temp = iterator.next();
      if (null == temp || temp.getDefect().startsWith("E15C")) {
        //list.remove(temp);// 出现java.util.ConcurrentModificationException
        iterator.remove();// 推荐使用
      }

    }
  }

  public static void moveProcessNullData(List<SnDetailDto> snDetailDtoList) {
    Iterator<SnDetailDto> iterator = snDetailDtoList.iterator();
    while (iterator.hasNext()) {
      SnDetailDto temp = iterator.next();
      if (null == temp || null== temp.getFACTORY_CODE()) {
        //list.remove(temp);// 出现java.util.ConcurrentModificationException
        iterator.remove();// 推荐使用
      }
    }
  }

  public static void moveTestInvalidData(List<SNDetailTestModel> snDetailTestModelList) {
    Iterator<SNDetailTestModel> iterator = snDetailTestModelList.iterator();
    while (iterator.hasNext()) {
      SNDetailTestModel snDetailTestModel = iterator.next();
      if (null == snDetailTestModel) {
        iterator.remove();
      } else if (null != snDetailTestModel.getSerial_number() && !snDetailTestModel
          .getSerial_number().trim().equals("")
          && snDetailTestModel.getSerial_number().trim().startsWith("0")) {
        String opName = snDetailTestModel.getOp_name().trim();
        if (null != opName) {
          if (opName.equals("FCT") || opName.equals("FCT(AUTO)") || opName.equals("FCT1(AUTO)")
              || opName.equals("FCT2(AUTO)")
              || opName.equals("FCT1") || opName.equals("FCT2") || opName.equals("FCT3")) {
            if (snDetailTestModel.getComplete_reason().toUpperCase().equals("FAIL")) {
              iterator.remove();
            }
          }
        }
      }
    }
  }

  private static String getTestName(String oldName) {
    String newName;
    switch (oldName) {
      case "ICT(FGI)":
      case "ICT":
        newName = "ICT";
        break;
      case "Functional Test2":
      case "Functional Test":
      case "FCT1":
        newName = "SW";
        break;
      case "FT(AUTO)(FGI)":
      case "FT(AUTO)":
      case "FT(FGI)":
      case "FT2(FGI)":
      case "FCT":
        newName = "ST66";
        break;
      case "MTP(AUTO)":
      case "MTP_AFT_HASA(AUTO)":
        newName = "MTP";
        break;
      case "FCT(FGI)":
      case "FCT(TERM)":
      case "FCT(TERM)(FGI)":
        newName = "FT";
        break;
      case "FCT1(AUTO)":
      case "FCT2(AUTO)":
      case "FCT(AUTO)(FGI)":
      case "FCT(AUTO)":
        newName = "ATE";
        break;
      case "FCT2":
        newName = "FT1";
        break;
      case "FCT3":
        newName = "FT2";
        break;
      case "HJTAG(AUTO)"
          :
      case "JTAG"
          :
      case "JTAG(AUTO)TAA":
        newName = "JTAG";
        break;
      case "HASA":
        newName = "HASA";
        break;
      case "SMB Test":
        newName = "ST";
        break;
      case "OVEN":
        newName = "OVEN";
        break;
      case "Hi Pot":
        newName = "AG";
        break;
      case "Pre Hi Pot":
        newName = "AG";
        break;
      case "Burn in":
        newName = "BURN_IN";
        break;

      case "Burn In(AUTO)":
        newName = "BURN_IN";
        break;
      case "Burn In(AUTO)(FGI)":
        newName = "BURN_IN";
        break;
      case "FCT(CY)":
        newName = "FC";
        break;
      case "HFT2_AFT_ESS(AUTO)":
        newName = "FT2_AFTER_ESS";
        break;
      case "HST2_AFT_ESS(AUTO)":
        newName = "ST2_AFTER_ESS";
        break;
      case "HFT3_AFT_ESS(AUTO)":
        newName = "FT3_AFTER_ESS";
        break;
      case "HST3_AFT_ESS(AUTO)":
        newName = "ST3_AFTER_ESS";
        break;
      case "HFT4_AFT_ESS(AUTO)":
        newName = "FT4_AFTER_ESS";
        break;
      case "HST4_AFT_ESS(AUTO)":
        newName = "ST4_AFTER_ESS";
        break;
      case "HFT(AUTO)":
        newName = "FT";
        break;
      case "HFT2(AUTO)":
        newName = "FT2";
        break;
      case "HFT3(AUTO)":
        newName = "FT3";
        break;
      case "HFT4(AUTO)":
        newName = "FT4";
        break;
      case "HFT_AFT_HASA(AUTO)":
        newName = "FT_AFTER_HASA";
        break;
      case "HST_AFT_HASA(AUTO)":
        newName = "ST_AFTER_HASA";
        break;
      case "HFT2_AFT_HASA(AUTO)":
        newName = "FT2_AFTER_HASA";
        break;
      case "HFT3_AFT_HASA(AUTO)":
        newName = "FT3_AFTER_HASA";
        break;
      case "HFT4_AFT_HASA(AUTO)":
        newName = "FT4_AFTER_HASA";
        break;
      case "HESS(AUTO)":
        newName = "ESS";
        break;
      case "D_Aging(AUTO)":
        newName = "D_Burn";
        break;
      case "HST(AUTO)":
        newName = "ST";
        break;
      case "HST2(AUTO)":
        newName = "ST2";
        break;
      case "HOVEN(AUTO)":
        newName = "OVEN";
        break;
      case "HFT_AFT_ESS(AUTO)":
        newName = "FT_AFTER_ESS";
        break;
      case "HST_AFT_ESS(AUTO)":
        newName = "ST_AFTER_ESS";
        break;
      default:
        newName = "";
        break;
    }
    return newName;
  }

  private static String getProcessName(String oldName) {
    String newName;
    switch (oldName) {
      case "SMT-QC Primary":
      case "SMT-QC Secondary":
      case "SMT-QC Primary(FGI)":
      case "SMT-QC Secondary(FGI)":
        newName = "BI";
        break;
      case "FQC":
      case "FQC(FGI)":
        newName = "RS";
        break;
      case "OQA":
        newName = "FQC";
        break;
      case "FT(AUTO)":
      case "FT(FGI)":
      case "FT(AUTO)(FGI)":
        newName = "ST66";
        break;
      case "FCT(FGI)":
        newName = "FT";
        break;
      case "FCT2":
        newName = "FT1";
        break;
      case "FCT3":
        newName = "FT2";
        break;
      case "HASA":
        newName = "HASA";
        break;
      case "Wave Solder QC":
      case "WSQC(FGI)":
        newName = "THT-B";
        break;
      case "FCT1":
      case "Functional Test":
        newName = "SW";
        break;
      case "AOIP":
      case "AOIS":
      case "AOIP(FGI)":
      case "AOIS(FGI)":
        newName = "AOI";
        break;

      case "Assemble":
      case "Assemble(FGI)":
      case "BoxBuild":
      case "BOXBUILD2":
      case "BoxBuild(FGI)":
      case "Consume":
      case "Consume1":
      case "Consume2":
      case "Consume2(FGI)":
      case "Consume(FGI)":
        newName = "ZP";
        break;

      case "BBFQC(Random)":
      case "IPQC":
      case "QC1":
        newName = "IPQC";
        break;
      case "AOI":
      case "AOI(FGI)":
      case "PFAOI":
        newName = "AOI-P";
        break;
      case "FQC(Random)":
        newName = "PD";
        break;
      case "FCT(AUTO)":
      case "FCT1(AUTO)":
      case "FCT2(AUTO)":
      case "FCT(AUTO)(FGI)":
        newName = "ATE";
        break;

      case "ICT":
      case "ICT(FGI)":
        newName = "ICT";
        break;
      case "Pack":
      case "Pack(FGI)":
        newName = "BZ";
        break;
      case "QC2":
      case "QC2(FGI)":
        newName = "BZ";
        break;
      case "3DX":
      case "3DX(FGI)":
        newName = "5DX";
        break;
      case "5DX":
        newName = "5DX";
        break;
      case "WIP-IN":
        newName = "WIP-IN";
        break;
      case "WIP-OUT":
        newName = "WIP-OUT";
        break;
      case "Press Fit":
      case "Press Fit(FGI)":
      case "Press Fit2":
      case "Press FitP":
      case "Press FitS":
      case "Press FitS(FGI)":
      case "PressFit-QC(FGI)":
        newName = "PR-I";
        break;

      case "SMB Test":
        newName = "ST";
        break;
      case "OVEN":
        newName = "OVEN";
        break;
      case "FCT(CY)":
        newName = "FC";
        break;
      case "Burn in":
      case "Burn In(AUTO)":
      case "Burn In(AUTO)(FGI)":
        newName = "BURN_IN";
        break;
      case "Hi Pot":
        newName = "AG";
        break;
      case "Pre Hi Pot":
        newName = "AG";
        break;
      case "3DXRew:k":
      case "5DXRew:k":
      case "AOI Rew:k":
      case "AOI(FGI) Rew:k":
      case "AOIP Rew:k":
      case "AOIS Rew:k":
      case "Assemble Rew:k":
      case "FCT Debug":
      case "FCT1 Debug":
      case "FCT2 Debug":
      case "FCT3 Debug":
      case "FQARew:k":
      case "FQCRew:k":
      case "FTRew:k":
      case "General Debug":
      case "HASA Debug":
      case "Hi Pot Rew:k":
      case "ICT Debug/Rew:k":
      case "PFAOI Rew:k":
      case "Press Fit Rew:k":
      case "Press Fit2 Rew:k":
      case "Press FitP Rew:k":
      case "Press FitS Rew:k":
      case "PressFit-QC Rew:k":
      case "QC1 Rew:k":
      case "QC2 Rew:k":
      case "Rew:k":
      case "SMT-QC Primary Rew:k":
      case "WSRew:k":
      case "SMT-QC Secondary Rew:k":
        newName = "RW";
        break;
      default:
        newName = oldName;
        break;
    }
    return newName;
  }

  private static String explainTestCode(String testCode, String reason) {
    String testResult;
    if (null == testCode || testCode.equals("")) {
      return "PASS";
    }
    if (testCode.startsWith("542B04")) {
      return "PASS";
    }
    if(testCode.length() >= 4) {
      switch (testCode.substring(0, 4)) {
        case "I99C":
        case "ST00":
        case "ST01":
        case "ST02":
        case "ST03":
        case "ST04":
        case "ST05":
        case "ST06":
        case "ST07":
        case "ST08":
        case "TE00":
        case "Z999":
        case "E11C":
        case "E12C":
        case "E13C":
        case "E14C":
        case "E15C":
        case "E48B":
          testResult = "PASS";
          break;
        default:
          testResult = "";
          if (reason.length() >= 4) {
            testResult = reason.substring(0, 4);
          }
          break;
      }
    }else {
      testResult = "";
      if (reason.length() >= 4) {
        testResult = reason.substring(0, 4);
      }
    }
    return testResult;
  }

  private static String getNote(String stationName) {
    String note;
    switch (stationName) {
      case "SMT-QC Primary":
      case "SMT-QC Primary(FGI)":
        note = "Top";
        break;
      case "SMT-QC Secondary":
      case "SMT-QC Secondary(FGI)":
        note = "Bot";
        break;
      case "AOI":
      case "AOIP":
      case "AOIP(FGI)":
        note = "Bot";
        break;
      case "AOIS":
      case "AOIS(FGI)":
        note = "Top";
        break;
      default:
        note = "";
        break;
    }
    return note;
  }
}
