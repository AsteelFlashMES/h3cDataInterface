package com.asteelflash.utils.dtoUtils;

import com.asteelflash.dto.DefectRepairDto;
import com.asteelflash.entity.model.DefectRepairModel;
import com.asteelflash.utils.DB2Util;
import com.asteelflash.utils.DateUtil;
import com.asteelflash.utils.SqlUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by hunter.fei on 2018/6/26.
 */
public class DefectRepairUtil {

  public static DefectRepairDto createDefectRepairDto(DefectRepairModel defectRepairModel) {
    DefectRepairDto defectRepairDto = new DefectRepairDto();
    String serialNumber = defectRepairModel.getSerial_number();
    String opName = defectRepairModel.getOp_name();
    String defSN = null;
    if (null == defectRepairModel.getDefSN() || !defectRepairModel.getDefSN().startsWith("02")) {
      defSN = "";
    } else {
      defSN = defectRepairModel.getDefSN().trim().toUpperCase();
      defectRepairDto.setSERIAL_NUMBER(defectRepairModel.getDefSN());
    }
    if (null != serialNumber && serialNumber.startsWith("03")) {
      String sqlQuery = "select case when charindex('_TASK_',serial_number)>0 then "
          + "substring(serial_number,0,charindex('_TASK_',serial_number)) else serial_number end "
          + "as serial_number from unit with(NOLOCK) where unit_key in "
          + "(select top 1 tobj_key from consumed_part where part_serial='" + serialNumber + " '"
          + " and status='Unconsumed' order by last_modified_time DESC)";
      List<Map<String, Object>> result = SqlUtil.query(sqlQuery);
      if (null == result || result.size() == 0) {
        String sqlQuery2 = "select case when charindex('_TASK_',part_serial)>0 then "
            + "substring(part_serial,0,charindex('_TASK_',part_serial)) else part_serial end as "
            + "part_serial from consumed_part with(NOLOCK) where tobj_key in(select unit_key from "
            + "unit with(NOLOCK) where serial_number='" + serialNumber
            + " ') and status='Consumed'";
        List<Map<String, Object>> result2 = SqlUtil.query(sqlQuery2);
        defectRepairDto.setPARENT_SN(serialNumber);
        if (null == result2 || result2.size() == 0) {
          if (defSN.equals("")) {
            defectRepairDto.setSERIAL_NUMBER("/");
          }
        } else {
          if (defSN.equals("")) {
            defectRepairDto.setSERIAL_NUMBER(result2.get(0).get("part_serial").toString());
          }
        }
      } else {
        defectRepairDto.setPARENT_SN(result.get(0).get("serial_number").toString());
        defectRepairDto.setREPAIR_MEMO(
            null == defectRepairModel.getRemark() ? "" : defectRepairModel.getRemark());
        String sqlQuery3 = "select case when charindex('_TASK_',part_serial)>0 then "
            + "substring(part_serial,0,charindex('_TASK_',part_serial)) else part_serial end as "
            + "part_serial from consumed_part with(NOLOCK) where tobj_key in(select unit_key "
            + "from unit with(NOLOCK) where serial_number='" + serialNumber
            + " ') and status='Consumed'";
        List<Map<String, Object>> result3 = SqlUtil.query(sqlQuery3);
        if (null == result3 || result3.size() == 0) {
          defectRepairDto.setSERIAL_NUMBER("/");
        } else {
          if (defSN.equals("")) {
            defectRepairDto.setSERIAL_NUMBER(result3.get(0).get("part_serial").toString());
          }
        }
      }
    } else if (serialNumber.startsWith("02") && opName.equals("General Debug")) {
      String sqlQuery4 = "select case when charindex('_TASK_',serial_number)>0 then "
          + "substring(serial_number,0,charindex('_TASK_',serial_number)) else serial_number "
          + "end as serial_number from unit with(NOLOCK) where unit_key in (select tobj_key "
          + "from consumed_part with(NOLOCK) where part_serial='" + serialNumber
          + " ' and status='Unconsumed')";
      List<Map<String, Object>> result4 = SqlUtil.query(sqlQuery4);
      if (null == result4 || result4.size() == 0) {
        defectRepairDto.setPARENT_SN("/");
      } else {
        defectRepairDto.setPARENT_SN(result4.get(0).get("serial_number").toString());
      }
      if (defSN.equals("")) {
        defectRepairDto.setSERIAL_NUMBER(serialNumber);
      }
    } else if (serialNumber.startsWith("02")) {
      defectRepairDto.setPARENT_SN("/");
      if (defSN.equals("")) {
        defectRepairDto.setSERIAL_NUMBER(serialNumber);
      }
    } else {
      defectRepairDto.setPARENT_SN(serialNumber);
      if (defSN.equals("")) {
        defectRepairDto.setSERIAL_NUMBER("/");
      }
    }

    serialNumber = defectRepairDto.getPARENT_SN();
    String ict = defectRepairModel.getOp_name();
    if (null != ict && ict.equals("FT(FGI)") && !serialNumber.equals("/")) {
      String sqlQuery5 = "select * from tracked_object_history with(NOLOCK) where tobj_key in " +
          "(select unit_key from unit with(NOLOCK) where serial_number='" + serialNumber + " ') " +
          "and (op_name='Functional Test' or op_name='Functional Test2') ";
      List<Map<String, Object>> result5 = SqlUtil.query(sqlQuery5);
      if (null == result5 || result5.size() == 0) {
        ict = "FT2(FGI)";
      }
    }

    defectRepairDto.setFACTORY_CODE("B");
    defectRepairDto.setFILE_NAME("REWORK");
    defectRepairDto.setVERSION_CODE(defectRepairModel.getPart_revision());
    defectRepairDto.setMO_NUMBER(defectRepairModel.getOrder_number());
    defectRepairDto.setTEST_SECTION_CODE(getRework0pName(ict));

    String defectCode = defectRepairModel.getDefect();
    if (null != defectCode && defectCode.length() >= 4) {
      setDefectCodeAndLocation(defectCode, defectRepairDto, defectRepairModel);
    }

    if (null != defectRepairModel.getDefPartNumber() && defectRepairModel.getDefPartNumber()
        .startsWith("050")) {
      if (null != defectRepairModel.getDefPartNumber() && defectRepairModel.getDefPartNumber()
          .contains("+")) {
        defectRepairDto.setDEFECT_PART_CODE(defectRepairModel.getDefPartNumber()
            .substring(defectRepairModel.getDefPartNumber().indexOf("+") + 1,
                defectRepairModel.getDefPartNumber().indexOf("+") + 9));
      } else if (null != defectRepairModel.getDefPartNumber() && defectRepairModel
          .getDefPartNumber().contains("-")) {
        defectRepairDto.setDEFECT_PART_CODE(defectRepairModel.getDefPartNumber()
            .substring(defectRepairModel.getDefPartNumber().indexOf("-") + 1,
                defectRepairModel.getDefPartNumber().indexOf("+") + 9));
      }
    } else {
      if (null != defectRepairModel.getDefPartNumber() && !""
          .equals(defectRepairModel.getDefPartNumber())) {
        defectRepairDto.setDEFECT_PART_CODE(defectRepairModel.getDefPartNumber()
            .substring(3, 11));
      }
    }
    defectRepairDto.setREASON_CODE("PEO");
    if (null != defectRepairModel.getJointQty()) {
      defectRepairDto.setDEFECT_COUNT(defectRepairModel.getJointQty().doubleValue());
    } else {
      defectRepairDto.setDEFECT_COUNT(0);
    }
    defectRepairDto.setREPAIR_TIME(DateUtil.formatDate(defectRepairModel.getLast_modified_time()));

    defectRepairDto.setFAULT_NUMBER1(
        (null != defectRepairModel.getBigCategory() && defectRepairModel.getBigCategory()
            .equals("ICT测试不良")) ? ""
            : defectRepairModel.getBigCategory());
    defectRepairDto.setFAULT_NUMBER2(
        (null != defectRepairModel.getBigCategory() && defectRepairModel.getBigCategory()
            .equals("ICT测试不良")) ? ""
            : defectRepairModel.getSmallCategory());
    defectRepairDto.setPORT_NUMBER(
        (null == defectRepairModel.getDefPort() || defectRepairModel.getDefPort().equals("")) ? ""
            : defectRepairModel.getDefPort());
    //TODO 暂时不传测试不良项、不良物料D/C、不良物料原厂序号、不良物料制造商 四个字段

    if (null != defectRepairModel.getSerial_number() && defectRepairModel.getSerial_number()
        .startsWith("0")) {
      String sqlQuery6 = "Select product_id, raw_mat_pn,raw_mat_supplier_name," +
          "raw_mat_supplier_pn,raw_mat_id From cgspcm.material_history Where "
          + "product_id='" + defectRepairModel.getSerial_number()
          + "' and tool_type_name='REWORK' ";
      List<Map<String, Object>> result6 = DB2Util
          .db2Query("jdbc:db2://10.11.5.3:50000/cgsdw", "cgsapp", "T0mcat4Fun",
              sqlQuery6);
      if (null == result6 || result6.size() == 0) {
        defectRepairDto.setREP_FALG("N");
      } else {
        defectRepairDto.setREP_FALG("Y");
        //因为31上的DSVendor视图的vname全是空字符，无实际查询意义，所以全按查不到处理
        defectRepairDto.setREP_SUPPLY_CODE("");
        defectRepairDto.setREP_SUPPLY_NAME(result6.get(0).get("raw_mat_supplier_name").toString());
        defectRepairDto
            .setREP_MANUFACTURE_NAME(result6.get(0).get("raw_mat_supplier_pn").toString());
        defectRepairDto.setREP_DATECODE(result6.get(0).get("raw_mat_id").toString());
      }
    } else {
      defectRepairDto.setREP_FALG("N");
    }
    return defectRepairDto;
  }

  private static void setDefectCodeAndLocation(String defectCode, DefectRepairDto defectRepairDto,
      DefectRepairModel defectRepairModel) {
    switch (defectCode) {
      case "C19C":
      case "C33B":
      case "C35B":
      case "C36B":
      case "C37B":
      case "C39B":
      case "C40B":
      case "C41B":
      case "C42B":
      case "C45B":
      case "C46B":
      case "C48B":
      case "C49C":
      case "C53B":
      case "C55C":
      case "C56C":
      case "C57B":
      case "P10B":
      case "P36B":
      case "P37B":
      case "P39B":
      case "P41B":
      case "P44B":
      case "P45B":
      case "P46B":
      case "P47B":
      case "P48C":
      case "P49C":
      case "P51B":
      case "P52B":
      case "P53B":
      case "P54C":
      case "P58B":
      case "P59C":
      case "P60C":
      case "P61B":
      case "P62B":
      case "P98B":
      case "S01B":
      case "S02B":
      case "S03B":
      case "S04B":
      case "S05B":
      case "S06B":
      case "S07B":
      case "S08B":
      case "S09B":
      case "S10B":
      case "S11B":
      case "S12B":
      case "S13B":
      case "S14B":
      case "S15B":
      case "S16B":
      case "S99C":
      case "ST00":
      case "ST01":
      case "ST02":
      case "ST03":
      case "ST04":
      case "ST05":
      case "ST06":
      case "ST07":
      case "ST08":
      case "T23B":
      case "T24B":
      case "T25B":
      case "T26B":
      case "T27B":
      case "T28B":
      case "T29B":
      case "T30B":
      case "T31B":
      case "T32B":
      case "T33B":
      case "T35B":
      case "T99C":
      case "W01B":
      case "W02B":
      case "W03B":
      case "W04B":
      case "W05B":
      case "W06B":
      case "W07B":
      case "W08B":
      case "W09B":
      case "Z999":
        defectRepairDto.setDEFECT_CODE(defectRepairModel.getDefect().substring(0, 4));
        defectRepairDto.setPART_DESIGNATOR("OTH");
        break;
      case "E48B":
      case "E49B":
      case "I11C":
      case "I12C":
      case "I13C":
      case "I14C":
      case "E11C":
      case "E12C":
      case "E13C":
      case "E14C":
      case "E15C":
        defectRepairDto.setDEFECT_CODE(defectRepairModel.getDefect().substring(0, 4));
        defectRepairDto.setPART_DESIGNATOR("NDF");
        break;
      case "0002":
        defectRepairDto.setDEFECT_CODE("NDF");
        defectRepairDto.setPART_DESIGNATOR("NDF");
        break;

      default:
        defectRepairDto.setDEFECT_CODE(defectRepairModel.getDefect().substring(0, 4));
        if (null == defectRepairModel.getLocation() || defectRepairModel.getLocation()
            .equals("")) {
          defectRepairDto.setPART_DESIGNATOR("OTH");
        } else {
          defectRepairDto.setPART_DESIGNATOR(replaceLocation(defectRepairModel.getLocation()));
        }
        break;
    }
  }

  private static String replaceLocation(String location) {
    location.replace("_1", "");
    location.replace("_2", "");
    location.replace("_3", "");
    location.replace("_4", "");
    location.replace("_5", "");
    location.replace("_6", "");
    return location;
  }

  private static String getRework0pName(String ict) {
    switch (ict) {
      case "SMT-QC Primary":
      case "SMT-QC Secondary":
      case "SMT-QC Primary(FGI)":
      case "SMT-QC Secondary(FGI)":
        ict = "BI";
        break;
      case "FQC":
      case "FQC(FGI)":
        ict = "RS";
        break;
      case "OQA":
        ict = "FQC";
        break;
      case "FT(AUTO)":
      case "FT(FGI)":
      case "FT(AUTO)(FGI)":
      case "FT2(FGI)":
        ict = "ST66";
        break;
      case "FCT(FGI)":
        ict = "FT";
        break;
      case "FCT2":
        ict = "FT1";
        break;
      case "FCT3":
        ict = "FT2";
        break;
      case "HASA":
        ict = "HASA";
        break;
      case "Wave Solder QC":
      case "WSQC(FGI)":
        ict = "THT-B";
        break;
      case "FCT1":
      case "Functional Test":
        ict = "SW";
        break;
      case "AOI":
      case "AOI(FGI)":
      case "AOIP":
      case "AOIS":
      case "AOIP(FGI)":
      case "AOIS(FGI)":
        ict = "AOI";
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
        ict = "ZP";
        break;
      case "MTP(AUTO)":
      case "MTP_AFT_HASA(AUTO)":
        ict = "MTP";
        break;
      case "Press Fit":
      case "Press Fit(FGI)":
      case "Press Fit2":
      case "Press FitP":
      case "Press FitS":
      case "Press FitS(FGI)":
      case "PressFit-QC(FGI)":
        ict = "PR-I";
        break;
      case "BBFQC(Random)":
      case "IPQC":
      case "QC1":
      case "QC2":
      case "QC2(FGI)":
        ict = "IPQC";
        break;
      case "Analysis":
        ict = "Analysis";
        break;
      case "PFAOI":
        ict = "AOI-P";
        break;
      case "FQC(Random)":
        ict = "PD";
        break;
      case "FCT(AUTO)":
      case "FCT1(AUTO)":
      case "FCT2(AUTO)":
      case "FCT(TERM)":
      case "FCT(AUTO)(FGI)":
        ict = "ATE";
        break;
      case "ICT":
      case "ICT(FGI)":
        ict = "ICT";
        break;
      case "Pack":
      case "Pack(FGI)":
        ict = "BZ";
        break;
      case "FQA":
      case "FQA(FGI)":
        ict = "BZ";
        break;
      case "3DX":
      case "3DX(FGI)":
        ict = "5DX";
        break;
      case "5DX":
        ict = "5DX";
        break;
      case "HFT2_AFT_ESS(AUTO)":
        ict = "FT2_AFTER_ESS";
        break;
      case "HST2_AFT_ESS(AUTO)":
        ict = "ST2_AFTER_ESS";
        break;
      case "HFT3_AFT_ESS(AUTO)":
        ict = "FT3_AFTER_ESS";
        break;
      case "HST3_AFT_ESS(AUTO)":
        ict = "ST3_AFTER_ESS";
        break;
      case "HFT4_AFT_ESS(AUTO)":
        ict = "FT4_AFTER_ESS";
        break;
      case "HST4_AFT_ESS(AUTO)":
        ict = "ST4_AFTER_ESS";
        break;
      case "HJTAG(AUTO)":
        ict = "JTAG";
        break;
      case "HFT(AUTO)":
        ict = "FT";
        break;
      case "HFT2(AUTO)":
        ict = "FT2";
        break;
      case "HFT3(AUTO)":
        ict = "FT3";
        break;
      case "HFT4(AUTO)":
        ict = "FT4";
        break;
      case "HFT_AFT_HASA(AUTO)":
        ict = "FT_AFTER_HASA";
        break;
      case "HFT2_AFT_HASA(AUTO)":
        ict = "FT2_AFTER_HASA";
        break;
      case "HFT3_AFT_HASA(AUTO)":
        ict = "FT3_AFTER_HASA";
        break;
      case "HFT4_AFT_HASA(AUTO)":
        ict = "FT4_AFTER_HASA";
        break;
      case "HST(AUTO)":
        ict = "ST";
        break;
      case "HESS(AUTO)":
        ict = "ESS";
        break;
      case "D_Aging(AUTO)":
        ict = "D_Burn";
        break;
      case "HFT_AFT_ESS(AUTO)":
        ict = "FT_AFTER_ESS";
        break;
      case "HST_AFT_ESS(AUTO)":
        ict = "ST_AFTER_ESS";
        break;
      case "SMB Test":
        ict = "ST";
        break;
      case "OVEN":
      case "HOVEN(AUTO)":
        ict = "OVEN";
        break;
      case "FCT(CY)":
        ict = "FC";
        break;
      case "Burn in":
      case "Burn In(AUTO)":
      case "Burn In(AUTO)(FGI)":
        ict = "BURN_IN";
        break;
      case "Hi Pot":
      case "Pre Hi Pot":
        ict = "AG";
        break;
      case "3DXRework":
      case "5DXRework":
      case "AOI Rework":
      case "AOI(FGI) Rework":
      case "AOIP Rework":
      case "AOIS Rework":
      case "Assemble Rework":
      case "FCT Debug":
      case "FCT(TERM) Debug":
      case "FCT1 Debug":
      case "FCT2 Debug":
      case "FCT3 Debug":
      case "FQARework":
      case "FQCRework":
      case "FTRework":
      case "General Debug":
      case "HASA Debug":
      case "Hi Pot Rework":
      case "ICT Debug/Rework":
      case "JTAG Debug/Rework":
      case "PFAOI Rework":
      case "Press Fit Rework":
      case "Press Fit2 Rework":
      case "Press FitP Rework":
      case "Press FitS Rework":
      case "PressFit-QC Rework":
      case "QC1 Rework":
      case "QC2 Rework":
      case "Rework":
      case "SMT-QC Primary Rework":
      case "WSRework":
      case "SMT-QC Secondary Rework":
        ict = "RW";
        break;
      default:
        break;
    }
    return ict;
  }

  public static void moveUnusedData(List<DefectRepairModel> defectRepairModelList) {
    if (null != defectRepairModelList && defectRepairModelList.size() > 0) {
      Iterator<DefectRepairModel> iterator = defectRepairModelList.iterator();
      while (iterator.hasNext()) {
        DefectRepairModel defectRepairModel = iterator.next();
        if (defectRepairModel.getDefect().startsWith("0001") || defectRepairModel.getDefect()
            .startsWith("Z999")
            || defectRepairModel.getDefect().startsWith("I99C") || defectRepairModel.getDefect()
            .startsWith("542B04")
            || defectRepairModel.getDefect().startsWith("ST00") || defectRepairModel.getDefect()
            .startsWith("ST01")
            || defectRepairModel.getDefect().startsWith("ST02") || defectRepairModel.getDefect()
            .startsWith("ST03")
            || defectRepairModel.getDefect().startsWith("ST04") || defectRepairModel.getDefect()
            .startsWith("ST05")
            || defectRepairModel.getDefect().startsWith("ST06") || defectRepairModel.getDefect()
            .startsWith("ST07")
            || defectRepairModel.getDefect().startsWith("ST08") || defectRepairModel.getDefect()
            .startsWith("TE00")) {
          iterator.remove();
        }
      }
    }
  }
}
