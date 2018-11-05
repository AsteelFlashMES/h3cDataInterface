package com.asteelflash.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.asteelflash.dto.CmEcDto;
import com.asteelflash.dto.CustSerialRelationDto;
import com.asteelflash.dto.DefectRepairDto;
import com.asteelflash.dto.H3CApiErrorResultDto;
import com.asteelflash.dto.LotReturnDto;
import com.asteelflash.dto.ProdFitDefectDto;
import com.asteelflash.dto.ResponseDto;
import com.asteelflash.dto.SnDetailDto;
import com.asteelflash.dto.SnImeiDto;
import com.asteelflash.dto.SnLabelDataDto;
import com.asteelflash.dto.SnPcbRelationDto;
import com.asteelflash.dto.SnVerificationMarkDto;
import com.asteelflash.dto.WipKeyPartsDto;
import com.asteelflash.dto.ZcbPcbRelationDto;
import com.asteelflash.entity.DtoEntity.CmEcEntity;
import com.asteelflash.entity.DtoEntity.CustSerialRelationEntity;
import com.asteelflash.entity.DtoEntity.DefectRepairEntity;
import com.asteelflash.entity.DtoEntity.LotReturnEntity;
import com.asteelflash.entity.DtoEntity.ProdFitDefectEntity;
import com.asteelflash.entity.DtoEntity.SnDetailEntity;
import com.asteelflash.entity.DtoEntity.SnImeiEntity;
import com.asteelflash.entity.DtoEntity.SnLabelDataEntity;
import com.asteelflash.entity.DtoEntity.SnPcbRelationEntity;
import com.asteelflash.entity.DtoEntity.SnVerificationMarkEntity;
import com.asteelflash.entity.DtoEntity.ZcbPcbRelationEntity;
import com.asteelflash.entity.H3CApiErrorResult;
import com.asteelflash.entity.model.CmEcModel;
import com.asteelflash.entity.model.CustSerialRelationModel;
import com.asteelflash.entity.model.DefectRepairModel;
import com.asteelflash.entity.model.LotReturnModel;
import com.asteelflash.entity.model.ProdFitDefectModel;
import com.asteelflash.entity.model.SNDetailModel;
import com.asteelflash.entity.model.SNDetailTestModel;
import com.asteelflash.entity.model.SnImeiModel;
import com.asteelflash.entity.model.SnLabelDataModel;
import com.asteelflash.entity.model.SnPcbRelationModel;
import com.asteelflash.entity.model.SnVerificationMarkModel;
import com.asteelflash.entity.model.WipKeyPartsModel;
import com.asteelflash.entity.model.ZcbPcbRelationModel;
import com.asteelflash.repository.CmEcRepository;
import com.asteelflash.repository.CustSerialRelationRepository;
import com.asteelflash.repository.DefectRepairRepository;
import com.asteelflash.repository.H3CApiErrorResultRepository;
import com.asteelflash.repository.LotReturnRepository;
import com.asteelflash.repository.ProdFitDefectRepository;
import com.asteelflash.repository.SnDetailRepository;
import com.asteelflash.repository.SnImeiRepository;
import com.asteelflash.repository.SnLabelDataRepository;
import com.asteelflash.repository.SnPcbRelationRepository;
import com.asteelflash.repository.SnVerificationMarkRepository;
import com.asteelflash.repository.ZcbPcbRelationRepository;
import com.asteelflash.utils.BeanUtils;
import com.asteelflash.utils.CommonUtils;
import com.asteelflash.utils.DB2Util;
import com.asteelflash.utils.DateUtil;
import com.asteelflash.utils.HttpUtil;
import com.asteelflash.utils.SendEmailUtil;
import com.asteelflash.utils.SqlUtil;
import com.asteelflash.utils.dtoUtils.CmEcDtoUtil;
import com.asteelflash.utils.dtoUtils.CustSerialRelationDtoUtil;
import com.asteelflash.utils.dtoUtils.DefectRepairUtil;
import com.asteelflash.utils.dtoUtils.LotReturnDtoUtil;
import com.asteelflash.utils.dtoUtils.ProdFitDefectDtoUtil;
import com.asteelflash.utils.dtoUtils.SnDetailDtoUtil;
import com.asteelflash.utils.dtoUtils.SnImeiDtoUtil;
import com.asteelflash.utils.dtoUtils.SnLabelDataDtoUtil;
import com.asteelflash.utils.dtoUtils.SnPcbRelationDtoUtil;
import com.asteelflash.utils.dtoUtils.SnVerificationMarkDtoUtil;
import com.asteelflash.utils.dtoUtils.WipKeyPartsDtoUtil;
import com.asteelflash.utils.dtoUtils.ZcbPcbRelationDtoUtil;
import com.asteelflash.utils.modelUtils.LotReturnModelUtil;
import com.asteelflash.utils.modelUtils.WipKeyPartsModelUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by hunter.fei on 2018/6/15.
 */
@Service
@Transactional
public class H3CDataTransmissionService {

  private static final String HOST_IP = "http://10.11.1.157:90/";

  @Autowired
  private EntityManager entityManager;

  @Autowired
  private H3CApiErrorResultRepository h3CApiErrorResultRepository;

  @Autowired
  private SnDetailRepository snDetailRepository;
  @Autowired
  private LotReturnRepository lotReturnRepository;
  @Autowired
  private DefectRepairRepository defectRepairRepository;
  @Autowired
  private ProdFitDefectRepository prodFitDefectRepository;
  @Autowired
  private SnPcbRelationRepository snPcbRelationRepository;
  @Autowired
  private ZcbPcbRelationRepository zcbPcbRelationRepository;
  @Autowired
  private SnVerificationMarkRepository snVerificationMarkRepository;
  @Autowired
  private CustSerialRelationRepository custSerialRelationRepository;
  @Autowired
  private SnLabelDataRepository snLabelDataRepository;
  @Autowired
  private SnImeiRepository snImeiRepository;
  @Autowired
  private CmEcRepository cmEcRepository;


  //send process data to h3c
  public String sendSnDetailProcessData(Date date) throws IOException {
    String endDate = DateUtil.formatDate(date);
    String beginDate = DateUtil.getBeforeTimeByMinute(date, 20);
    String sql =
        "select distinct tobj_history_key,serial_number,case when charindex('_',order_number)>0 then "
            + "substring(order_number,0,charindex('_',order_number)) else order_number end as order_number,"
            + "op_name,(case when left(defect,6)='542B04' then 'PASS' when left(defect,4)='I99C' then 'PASS' "
            + "when left(defect,4)='ST00' then 'PASS' when left(defect,4)='ST01' then 'PASS' when left(defect,4)='ST02'"
            + " then 'PASS' when left(defect,4)='ST03' then 'PASS' when left(defect,4)='ST04' then 'PASS' when "
            + "left(defect,4)='ST05' then 'PASS' when left(defect,4)='ST06' then 'PASS' when left(defect,4)='ST07' "
            + "then 'PASS' when left(defect,4)='ST08' then 'PASS' when left(defect,4)='TE00' then 'PASS' when left(defect,4)='Z999' then 'PASS'  "
            + "when left(defect,4)='E11C' then 'PASS' when left(defect,4)='E12C' then 'PASS' when left(defect,4)='E13C' then 'PASS'"
            + " when left(defect,4)='E14C' then 'PASS' when left(defect,4)='E15C' then 'PASS' when left(defect,4)='E48B' then 'PASS' "
            + "else complete_reason end) as complete_reason,complete_count,"
            + "'' as defect,complete_time,part_revision,case when replace(substring(complete_comment,charindex('~~~~',complete_comment)+5,50),'~','')"
            + " is null then 'NONE' else replace(substring(complete_comment,charindex('~~~~',complete_comment)+5,50),'~','') "
            + "end as Line,part_number,''route_name into ##lprocess_temp  from HW_Basic_Data_View1 with(NOLOCK) "
            + "where left(order_number,4)<>'test' and op_name in ('3DX','3DX(FGI)','5DX','AOI(FGI)','AOIP','AOIP(FGI)',"
            + "'AOIS','AOIS(FGI)','PFAOI','SMT-QC Primary','SMT-QC Primary(FGI)','SMT-QC Secondary','SMT-QC Secondary(FGI)',"
            + "'QC2','QC2(FGI)','FQC','FQC(FGI)','OQA','BBFQC(Random)','IPQC','FQC(Random)','Press Fit','Press Fit(FGI)',"
            + "'Press Fit2','Press FitP','Press FitS','Press FitS(FGI)','PressFit-QC(FGI)','SMB Test','Wave Solder QC',"
            + "'WSQC(FGI)','BoxBuild','BOXBUILD2','BoxBuild(FGI)','Consume','Consume1','Consume2','Consume2(FGI)','Consume(FGI)',"
            + "'3DXRework','5DXRework','AOI Rework','AOI(FGI) Rework','AOIP Rework','AOIS Rework','FCT Debug','FCT1 Debug',"
            + "'FCT2 Debug','FCT3 Debug','FQARework','FQCRework','FTRework','General Debug','HASA Debug','Hi Pot Rework',"
            + "'ICT Debug/Rework','PFAOI Rework','Press Fit Rework','Press Fit2 Rework','Press FitP Rework','Press FitS Rework',"
            + "'PressFit-QC Rework ','Rework','SMT-QC Primary Rework','SMT-QC Secondary Rework','WSRework','FQA(FGI)')"
            + "and complete_time >= '" + beginDate + "' and complete_time < '" + endDate + "'"
            + " union all "
            + "select distinct a.tobj_history_key,a.serial_number,case when charindex('_',a.order_number)>0 then "
            + "substring(a.order_number,0,charindex('_',a.order_number)) else a.order_number end as order_number,a.op_name,"
            + "(case when left(a.defect,6)='542B04' then 'PASS' when left(a.defect,4)='I99C' then 'PASS' when left(a.defect,4)='ST00' "
            + "then 'PASS' when left(a.defect,4)='ST01' then 'PASS' when left(a.defect,4)='ST02' then 'PASS' when left(a.defect,4)='ST03' "
            + "then 'PASS' when left(a.defect,4)='ST04' then 'PASS' when left(a.defect,4)='ST05' then 'PASS' when left(a.defect,4)='ST06'"
            + " then 'PASS' when left(a.defect,4)='ST07' then 'PASS' when left(a.defect,4)='ST08' then 'PASS' when left(a.defect,4)='TE00'"
            + " then 'PASS' when left(a.defect,4)='Z999' then 'PASS' "
            + " when left(a.defect,4)='E11C' then 'PASS' when left(a.defect,4)='E12C' then 'PASS' when "
            + "left(a.defect,4)='E13C' then 'PASS' when left(a.defect,4)='E14C' then 'PASS' "
            + "when left(a.defect,4)='E15C' then 'PASS' when left(a.defect,4)='E48B' then 'PASS' "
            + "else a.complete_reason end) as complete_reason,a.complete_count, "
            + " '' as defect,a.complete_time,a.part_revision,case when replace(substring(complete_comment,charindex('~~~~',complete_comment)+5,50),'~','')"
            + " is null then 'NONE' else replace(substring(complete_comment,charindex('~~~~',complete_comment)+5,50),'~','') end as Line ,"
            + "part_number,''route_name from HW_Basic_Data_View1 a with(NOLOCK) left outer join mike_chg_sn b with(NOLOCK)"
            + " on a.serial_number=b.old_serial_number where left(order_number,4)<>'test' and op_name in "
            + "('3DX','3DX(FGI)','5DX','AOI(FGI)','AOIP','AOIP(FGI)','AOIS','AOIS(FGI)','PFAOI','SMT-QC Primary',"
            + "'SMT-QC Primary(FGI)','SMT-QC Secondary','SMT-QC Secondary(FGI)','QC2','QC2(FGI)','FQC','FQC(FGI)',"
            + "'OQA','BBFQC(Random)','IPQC','FQC(Random)','Press Fit','Press Fit(FGI)','Press Fit2','Press FitP',"
            + "'Press FitS','Press FitS(FGI)','PressFit-QC(FGI)','SMB Test','Wave Solder QC','WSQC(FGI)','BoxBuild',"
            + "'BOXBUILD2','BoxBuild(FGI)','Consume','Consume1','Consume2','Consume2(FGI)','Consume(FGI)','3DXRework',"
            + "'5DXRework','AOI Rework','AOI(FGI) Rework','AOIP Rework','AOIS Rework','FCT Debug','FCT1 Debug',"
            + "'FCT2 Debug','FCT3 Debug','FQARework','FQCRework','FTRework','General Debug','HASA Debug','Hi Pot Rework',"
            + "'ICT Debug/Rework','PFAOI Rework','Press Fit Rework','Press Fit2 Rework','Press FitP Rework',"
            + "'Press FitS Rework','PressFit-QC Rework ','Rework','SMT-QC Primary Rework','SMT-QC Secondary Rework','WSRework','FQA(FGI)')"
            + "and a.serial_number in (select new_serial_number from mike_chg_sn where old_serial_number<>new_serial_number and "
            + "change_time >= '" + beginDate + "' and change_time < '" + endDate + "') Union All "
            + "select a.unit_key+convert(nvarchar(64),DATEDIFF(s, '12/30/2015', a.complete_time)) as tobj_history_key,a.serial_number,"
            + "case when charindex('_',c.order_number)>0 then substring(c.order_number,0,charindex('_',c.order_number)) else c.order_number "
            + "end as order_number,a.op_name,a.complete_reason,'1' as complete_count,'' as defect,a.complete_time,b.part_revision,'NONE' "
            + "as Line, b.part_number,''route_name from DMS_HISTORY a with(NOLOCK) left outer join UNIT b with(NOLOCK) on a.unit_key=b.unit_key "
            + "left outer join WORK_ORDER c with(NOLOCK) on b.order_key=c.order_key "
            + "where a.op_name in ('WIP-IN','WIP-OUT') and a.complete_time >= '" + beginDate
            + "' and a.complete_time < '" + endDate + "'"
            + "UNION ALL SELECT distinct A.PRODUCT_NO,A.PRODUCT_ID,A.BATCH_ID,A.TRACK_STATION,'PASS' "
            + "complete_reason,'1','',DATEADD(HOUR,6,A.CREATE_TIME) AS CREATE_TIME,B.PART_REV,B.LINE,B.PART_NUMBER,"
            + "''route_anme  FROM C_PRODUCT A JOIN C_MATERIAL_SNAPSHOT B ON A.SNAPSHOT_NO=B.SNAPSHOT_NO AND A.TRACK_STATION=B.TRACK_STATION "
            + "WHERE A.EFFE_FLAG='1' AND B.EFFE_FLAG='1' AND A.TRACK_STATION='SMT' AND A.CREATE_TIME>='"
            + beginDate + "' AND A.CREATE_TIME<'" + endDate + "'";

    Query insertData = entityManager.createNativeQuery(sql);
    insertData.executeUpdate();

    String sqlQuery = "select * from ##lprocess_temp";
    Query query = entityManager.createNativeQuery(sqlQuery);
    //此方法是将数据集合转换位map类型的List集合
    //query.unwrap(SQLQuery.class).setResultTransformer(Transformers.aliasToBean(HashMap.class));
    List<Object[]> resultList = query.getResultList();

    String sqlDrop = "drop table ##lprocess_temp";
    Query dropQuery = entityManager.createNativeQuery(sqlDrop);

    dropQuery.executeUpdate();
    List<SNDetailModel> snDetailModelList = new ArrayList<>();
    List<SnDetailDto> snDetailDtos = new ArrayList<>();
    try {
      snDetailModelList = CommonUtils.castEntity(resultList, SNDetailModel.class);
    } catch (Exception e) {
      e.printStackTrace();
    }
    if (snDetailModelList.size() > 0) {
      SnDetailDtoUtil.moveProcessInvalidData(snDetailModelList);
      snDetailModelList.forEach(
          snDetailModel -> snDetailDtos
              .add(SnDetailDtoUtil.createSnDetailDto(snDetailModel, "process")));
      SnDetailDtoUtil.moveProcessNullData(snDetailDtos);
      snDetailDtos.forEach(snDetailDto -> {
        SnDetailEntity snDetailEntity = new SnDetailEntity();
        BeanUtils.copyProperties(snDetailDto, snDetailEntity);
        snDetailEntity.setCreationTime(date);
        snDetailRepository.save(snDetailEntity);
      });
      String url = HOST_IP + "api/SN_DETAIL/AddListModelSN_DETAIL";
      String data = JSON.toJSONString(snDetailDtos);
      return HttpUtil.sendInfo(url, data);
    } else {
      return "No data send";
    }

  }

  // send test data to h3c
  public String sendSnDetailTestData(Date date) throws IOException {
    String endDate = DateUtil.formatDate(date);
    String beginDate = DateUtil.getBeforeTimeByMinute(date, 20);
    String sql =
        "select distinct tobj_history_key,serial_number,case when charindex('_',order_number)>0 then "
            + "substring(order_number,0,charindex('_',order_number)) else order_number end as order_number, "
            + "op_name,complete_reason,complete_count,complete_user_name,left(symptomcode,33) as symptomcode, "
            + "complete_time,uda_9,tobj_key,case when replace(substring(complete_comment,"
            + "charindex('~~~~',complete_comment)+5,50),'~','') is null then 'NONE' else "
            + "replace(substring(complete_comment,charindex('~~~~',complete_comment)+5,50),'~','') "
            + " end as Line,(select equip1 from part_equ with(NOLOCK) "
            + "where part_number=a.part_number and op_name=a.op_name) as equip1 "
            + "from HW_Basic_Data_View1 a with(NOLOCK) "
            + "where complete_time >= '" + beginDate + "' and complete_time < '" + endDate + "' "
            + "and op_name in ('ICT','Functional Test','Functional Test2','FT(FGI)','FT(AUTO)','FT(AUTO)(FGI)',"
            + "'FCT','FCT(AUTO)','FCT1(AUTO)','FCT2(AUTO)','FCT(AUTO)(FGI)','FCT(FGI)','FCT1',"
            + "'FCT2','FCT3','FCT(CY)','FCT(TERM)','FCT(TERM)(FGI)','HASA','SMB Test','Hi Pot',"
            + "'Pre Hi Pot','Burn in','Burn In(AUTO)','Burn In(AUTO)(FGI)','ICT(FGI)','FT(FGI)',"
            + "'FT2(FGI)','MTP_AFT_HASA(AUTO)','MTP(AUTO)','JTAG','JTAG(AUTO)TAA','HJTAG(AUTO)',"
            + "'HFT(AUTO)','HFT2(AUTO)','HFT3(AUTO)','HFT4(AUTO)','HFT_AFT_HASA(AUTO)','HFT2_AFT_HASA(AUTO)',"
            + "'HFT3_AFT_HASA(AUTO)','HFT4_AFT_HASA(AUTO)','HST(AUTO)','HST2(AUTO)','HESS(AUTO)',"
            + "'HOVEN(AUTO)','HFT_AFT_ESS(AUTO)','HST_AFT_HASA(AUTO)','HST_AFT_ESS(AUTO)','HFT2_AFT_ESS(AUTO)',"
            + "'HST2_AFT_ESS(AUTO)','HFT3_AFT_ESS(AUTO)','HST3_AFT_ESS(AUTO)','HFT4_AFT_ESS(AUTO)',"
            + "'HST4_AFT_ESS(AUTO)','OVEN') union all  "
            + "select distinct a.tobj_history_key,b.new_serial_number,case when charindex('_',a.order_number)>0 "
            + "then substring(a.order_number,0,charindex('_',a.order_number)) else a.order_number end as order_number, "
            + "a.op_name,a.complete_reason,a.complete_count,a.complete_user_name,a.symptomcode,"
            + "a.complete_time,a.uda_9,a.tobj_key,case when replace(substring(a.complete_comment,"
            + "charindex('~~~~',a.complete_comment)+5,50),'~','') is null then 'NONE' else "
            + "replace(substring(a.complete_comment,charindex('~~~~',a.complete_comment)+5,50),'~','') "
            + "end as Line,(select equip1 from part_equ with(NOLOCK) "
            + "where part_number=a.part_number and op_name=a.op_name) as equip1 " +
            "from HW_Basic_Data_View1 a with(NOLOCK) left outer join mike_chg_sn b with(NOLOCK) "
            + "on a.serial_number=b.new_serial_number " +
            "where a.serial_number in (select new_serial_number from mike_chg_sn where "
            + "old_serial_number<>new_serial_number and change_time >= '" + beginDate
            + "' and change_time < '" + endDate + "') "
            + " and a.op_name in ('ICT','Functional Test','Functional Test2','FT(FGI)','FT(AUTO)','FT(AUTO)(FGI)',"
            + "'FCT','FCT(AUTO)','FCT1(AUTO)','FCT2(AUTO)','FCT(AUTO)(FGI)','FCT(FGI)','FCT1','FCT2',"
            + "'FCT3','FCT(CY)','FCT(TERM)','FCT(TERM)(FGI)','HASA','SMB Test','Hi Pot','Pre Hi Pot',"
            + "'Burn in','Burn In(AUTO)','Burn In(AUTO)(FGI)','ICT(FGI)','FT(FGI)','FT2(FGI)',"
            + "'MTP_AFT_HASA(AUTO)','MTP(AUTO)','JTAG','JTAG(AUTO)TAA','HJTAG(AUTO)','HFT(AUTO)',"
            + "'HFT2(AUTO)','HFT3(AUTO)','HFT4(AUTO)','HFT_AFT_HASA(AUTO)','HFT2_AFT_HASA(AUTO)',"
            + "'HFT3_AFT_HASA(AUTO)','HFT4_AFT_HASA(AUTO)','HST(AUTO)','HST2(AUTO)','HESS(AUTO)',"
            + "'HOVEN(AUTO)','HFT_AFT_ESS(AUTO)','HST_AFT_HASA(AUTO)','HST_AFT_ESS(AUTO)',"
            + "'HFT2_AFT_ESS(AUTO)','HST2_AFT_ESS(AUTO)','HFT3_AFT_ESS(AUTO)','HST3_AFT_ESS(AUTO)',"
            + "'HFT4_AFT_ESS(AUTO)','HST4_AFT_ESS(AUTO)','OVEN') ";
    Query query = entityManager.createNativeQuery(sql);
    //此方法是将数据集合转换位map类型的List集合
    //query.unwrap(SQLQuery.class).setResultTransformer(Transformers.aliasToBean(HashMap.class));
    List<Object[]> resultList = query.getResultList();

    List<SNDetailTestModel> snDetailTestModelList = new ArrayList<>();
    List<SnDetailDto> snDetailDtos = new ArrayList<>();
    try {
      snDetailTestModelList = CommonUtils.castEntity(resultList, SNDetailTestModel.class);
    } catch (Exception e) {
      e.printStackTrace();
    }
    if (snDetailTestModelList.size() > 0) {
      SnDetailDtoUtil.moveTestInvalidData(snDetailTestModelList);
      snDetailTestModelList.forEach(
          snDetailTestModel -> snDetailDtos
              .add(SnDetailDtoUtil.createSnDetailDto(snDetailTestModel, "test")));
      snDetailDtos.forEach(snDetailDto -> {
        SnDetailEntity snDetailEntity = new SnDetailEntity();
        BeanUtils.copyProperties(snDetailDto, snDetailEntity);
        snDetailEntity.setCreationTime(date);
        snDetailRepository.save(snDetailEntity);
      });
      String url = HOST_IP + "api/SN_DETAIL/AddListModelSN_DETAIL";
      String data = JSON.toJSONString(snDetailDtos);
      return HttpUtil.sendInfo(url, data);
    } else {
      return "No data send";
    }

  }

  // send return material data to h3c
  public String sendLotReturnData(Date date) throws IOException {
    String endDate = DateUtil.formatDate(date);
    String beginDate = DateUtil.getBeforeTimeByMinute(date, 20);
    String sql = "select a.idno,a.wo,'' as released_qty,a.num,a.link,a.rdate,a.proportion,'' "
        + "as mfg_part_number,a.vendor_code,a.used_num,a.buliang_num,case when charindex('[',remark)>0 "
        + "then substring(remark,charindex('[',remark)+1,charindex(']',remark)-charindex('[',remark)-1) "
        + "else '' end as remark,a.rdemo from returnst a where a.rdate>='" + beginDate
        + "' and a.rdate<'" + endDate + "' and customer='HW-3COM' ";
    List<LotReturnModel> lotReturnModelList = new ArrayList<>();
    List<LotReturnDto> lotReturnDtos = new ArrayList<>();
    try {
      List<Map<String, Object>> list = SqlUtil
          .otherDatabaseQuery("jdbc:sqlserver://10.11.1.31:1433;database=returnst", "sa",
              "Itadmin1",
              sql);

      lotReturnModelList = LotReturnModelUtil.castEntity(list);
    } catch (Exception e) {
      e.printStackTrace();
    }
    if (lotReturnModelList.size() > 0) {
      lotReturnModelList
          .forEach(lotReturnModel -> lotReturnDtos
              .add(LotReturnDtoUtil.createLotReturnDto(lotReturnModel)));
      lotReturnDtos.forEach(lotReturnDto -> {
        LotReturnEntity lotReturnEntity = new LotReturnEntity();
        BeanUtils.copyProperties(lotReturnDto, lotReturnEntity);
        lotReturnEntity.setCreationTime(date);
        lotReturnRepository.save(lotReturnEntity);
      });
      String url = HOST_IP + "api/LOT_RETURN/AddListModelLOT_RETURN";
      String data = JSON.toJSONString(lotReturnDtos);
      return HttpUtil.sendInfo(url, data);
    } else {
      return "No data send";
    }

  }

  //send rework data to h3c
  public String sendDefectRepairData(Date date) throws IOException {
    String endDate = DateUtil.formatDate(date);
    String beginDate = DateUtil.getBeforeTimeByMinute(date, 20);
    String sql = "select distinct convert(char(21),a.tobj_key),b.uda_9,case when "
        + "charindex('_TASK_',b.serial_number)>0 then "
        + "substring(b.serial_number,0,charindex('_TASK_',b.serial_number)) else b.serial_number end "
        + "as serial_number,b.part_revision,case when charindex('_',c.order_number)>0 then "
        + "substring(c.order_number,0,charindex('_',c.order_number)) else c.order_number end as order_number, "
        + "(case when b.uda_6 is null then a.op_name else b.uda_6 end) op_name,d.Defect,d.Location,"
        + "d.JointQty,d.last_modified_time,d.op_name opname,case when charindex('+',d.DefPartNumber)>0 "
        + "then 'HWH'+substring(d.DefPartNumber,charindex('+',d.DefPartNumber)+1,8) else d.DefPartNumber "
        + "end as DefPartNumber,case when charindex('_TASK_',d.DefSN)>0 then "
        + "substring(d.DefSN,0,charindex('_TASK_',d.DefSN)) else d.DefSN end as DefSN, " +
        " d.BigCategory,d.SmallCategory,d.SymptomCode,d.DefPort,d.DefMaterialSN,d.DefMaterialDC,d.DefSupplierName,d.Remark "
        + "from tracked_object_history a with (nolock) join unit b with(NOLOCK) on a.tobj_key = b.unit_key "
        + "join work_order c with(NOLOCK) on b.order_key = c.order_key join DC_FlashSymptom d with(NOLOCK) "
        + "on a.tobj_key = d.object_key and a.op_name = d.DiscoveryOper where d.logDate >= '"
        + beginDate + "' and d.logDate < '" + endDate + "' and d.defect is not null and d.fix='1' "
        + "and d.DiscoveryOper in ('3DX','3DX(FGI)','5DX','Hi Pot','Pre Hi Pot','AOI(FGI)','AOIP','AOIP(FGI)',"
        + "'AOIS','AOIS(FGI)','PFAOI','FCT(AUTO)','FCT1(AUTO)','FCT2(AUTO)','FCT(AUTO)(FGI)',"
        + "'SMT-QC Primary','SMT-QC Primary(FGI)','SMT-QC Secondary','SMT-QC Secondary(FGI)','Burn in',"
        + "'Burn In(AUTO)','Burn In(AUTO)(FGI)','Pack','Pack(FGI)','FQA','FQA(FGI)','FCT(CY)','FQC',"
        + "'FQC(FGI)','OQA','FCT(FGI)','FCT2','FCT3','HASA','ICT','ICT(FGI)','BBFQC(Random)','IPQC',"
        + "'FQC(Random)','Press Fit','Press Fit(FGI)','Press Fit2','Press FitP','Press FitS','Press FitS(FGI)',"
        + "'PressFit-QC(FGI)','SMB Test','FT(AUTO)','FT(AUTO)(FGI)','FT(FGI)','FCT1','Functional Test',"
        + "'Wave Solder QC','WSQC(FGI)','BoxBuild','BOXBUILD2','BoxBuild(FGI)','Consume','Consume1',"
        + "'Consume2','Consume2(FGI)','Consume(FGI)','3DXRework','5DXRework','AOI Rework','AOI(FGI) Rework',"
        + "'AOIP Rework','AOIS Rework','FCT Debug','FCT(TERM) Debug','FCT1 Debug','FCT2 Debug','FCT3 Debug',"
        + "'FQARework','FQCRework','FTRework','General Debug','HASA Debug','Hi Pot Rework',"
        + "'ICT Debug/Rework','JTAG Debug/Rework','PFAOI Rework','Press Fit Rework','Press Fit2 Rework',"
        + "'Press FitP Rework','Press FitS Rework','PressFit-QC Rework ','Rework','SMT-QC Primary Rework',"
        + "'SMT-QC Secondary Rework','WSRework','HJTAG(AUTO)','HFT(AUTO)','HFT2(AUTO)','HFT3(AUTO)',"
        + "'HFT4(AUTO)','HFT_AFT_HASA(AUTO)','HFT2_AFT_HASA(AUTO)','HFT3_AFT_HASA(AUTO)','HFT4_AFT_HASA(AUTO)',"
        + "'HST(AUTO)','HESS(AUTO)','HOVEN(AUTO)','HFT_AFT_ESS(AUTO)','HST_AFT_ESS(AUTO)','HFT2_AFT_ESS(AUTO)',"
        + "'HST2_AFT_ESS(AUTO)','HFT3_AFT_ESS(AUTO)','HST3_AFT_ESS(AUTO)','HFT4_AFT_ESS(AUTO)','HST4_AFT_ESS(AUTO)','OVEN') "
        + "and left(d.defect,4)<>'E15C' and b.part_number LIKE 'HW%' AND DATEDIFF(second, d.creation_time, a.complete_time)<60 "
        + "AND DATEDIFF(second, d.creation_time, a.complete_time)>=0  Union All "
        + "select distinct convert(char(21),a.id),'' uda_9,case when charindex('_TASK_',b.serial_number)>0 "
        + "then substring(b.serial_number,0,charindex('_TASK_',b.serial_number)) else b.serial_number "
        + "end as serial_number,b.part_revision,case when charindex('_',c.order_number)>0 then "
        + "substring(c.order_number,0,charindex('_',c.order_number)) else c.order_number end as order_number, "
        + "'Analysis' op_name,'E10C',a.Location,a.JointQty,a.last_modified_time,'Analysis' opname,a.DefPartNumber,"
        + "case when charindex('_TASK_',a.DefSN)>0 then substring(a.DefSN,0,charindex('_TASK_',a.DefSN)) "
        + "else a.DefSN end as DefSN ,'','','','','','','','' from DMS_Symptom a with (nolock) "
        + "join UNIT b with(NOLOCK) on a.unit_key = b.unit_key "
        + "join work_order c with(NOLOCK) on b.order_key = c.order_key "
        + "where a.last_modified_time >= '" + beginDate + "' and a.last_modified_time < '" + endDate
        + "' and a.defect is not null and a.fix='1' and b.part_number LIKE 'HW%' ";

    Query query = entityManager.createNativeQuery(sql);
    List<Object[]> resultList = query.getResultList();

    List<DefectRepairModel> defectRepairModelList = new ArrayList<>();
    List<DefectRepairDto> defectRepairDtos = new ArrayList<>();
    try {
      defectRepairModelList = CommonUtils.castEntity(resultList, DefectRepairModel.class);
    } catch (Exception e) {
      e.printStackTrace();
    }
    if (defectRepairModelList.size() > 0) {
      DefectRepairUtil.moveUnusedData(defectRepairModelList);
      defectRepairModelList
          .forEach(defectRepairModel -> defectRepairDtos
              .add(DefectRepairUtil.createDefectRepairDto(defectRepairModel)));
      defectRepairDtos.forEach(defectRepairDto -> {
        DefectRepairEntity defectRepairEntity = new DefectRepairEntity();
        BeanUtils.copyProperties(defectRepairDto, defectRepairEntity);
        defectRepairEntity.setCreationTime(date);
        defectRepairRepository.save(defectRepairEntity);
      });
      String url = HOST_IP + "api/DEFECT_REPAIR/AddListModelDEFECT_REPAIR";
      String data = JSON.toJSONString(defectRepairDtos);
      return HttpUtil.sendInfo(url, data);
    } else {
      return "No data send";
    }

  }


  // send return assembly defect data to h3c
  public String sendProdFitDefect(Date date) throws IOException {
    String endDate = DateUtil.formatDate(date);
    String beginDate = DateUtil.getBeforeTimeByMinute(date, 20);
    String sql = "select c.order_key,case when charindex('_TASK_',b.serial_number)>0 then substring"
        + "(b.serial_number,0,charindex('_TASK_',b.serial_number)) else b.serial_number end as "
        + "serial_number,a.defect,left(a.symptomcode,33) as symptomcode,b.part_number " +
        "from dc_flashsymptom a with (nolock) join unit b with (nolock) on a.object_key=b.unit_Key "
        +
        "join work_order c with (nolock) on b.order_key=c.order_key " +
        "where a.last_modified_time>='" + beginDate + "' and a.last_modified_time<'" + endDate
        + "' " +
        "and b.part_number like 'HW%' " +
        "and a.discoveryoper in ('Boxbuild','BOXBUILD2','BoxBuild(FGI)','Pack','Consume','Consume1',"
        + "'Consume2','Consume2(FGI)') order by c.order_key";
    List<ProdFitDefectModel> prodFitDefectModels = new ArrayList<>();
    List<ProdFitDefectDto> prodFitDefectDtos = new ArrayList<>();
    try {
      Query query = entityManager.createNativeQuery(sql);
      List<Object[]> resultList = query.getResultList();

      prodFitDefectModels = CommonUtils.castEntity(resultList, ProdFitDefectModel.class);
    } catch (Exception e) {
      e.printStackTrace();
    }
    if (prodFitDefectModels.size() > 0) {
      prodFitDefectModels
          .forEach(prodFitDefectModel -> prodFitDefectDtos
              .add(ProdFitDefectDtoUtil.createProdFitDefectDto(prodFitDefectModel)));
      prodFitDefectDtos.forEach(prodFitDefectDto -> {
        ProdFitDefectEntity prodFitDefectEntity = new ProdFitDefectEntity();
        BeanUtils.copyProperties(prodFitDefectDto, prodFitDefectEntity);
        prodFitDefectEntity.setCreationTime(date);
        prodFitDefectRepository.save(prodFitDefectEntity);
      });
      String url = HOST_IP + "api/PROD_FIT_DEFECT/AddListModelPROD_FIT_DEFECT";
      String data = JSON.toJSONString(prodFitDefectDtos);
      return HttpUtil.sendInfo(url, data);
    } else {
      return "No data send";
    }

  }

  //send base data1 data to h3c
  public String sendWipKeyPartsData(Date date) throws IOException {
    String endDate = DateUtil.formatDate(date);
    String beginDate = DateUtil.getBeforeTimeByMinute(date, 20);
    String xdate = DateUtil.formatShortDate(date);
    String sql =
        "SELECT PT.PRODUCT_ID,MS.RAW_MAT_PN,MS.RAW_MAT_SUPPLIER_PN,MS.RAW_MAT_SUPPLIER_NAME,"
            + "MS.RAW_MAT_ID,MS.SNAPSHOT_TMST,PT.PRODUCT_PN,UF.UDF_01,UF.UDF_02,UF.UDF_03 FROM "
            + "CGSPCM.PRODUCT_TRACEABILITY_ALL PT JOIN CGSPCM.MATERIAL_SNAPSHOT_ALL MS ON "
            + "(PT.BATCH_ID = MS.BATCH_ID AND PT.SNAPSHOT_TOOL_KEY = MS.SNAPSHOT_TOOL_KEY "
            + "AND PT.SNAPSHOT_TMST = MS.SNAPSHOT_TMST) LEFT OUTER JOIN CGS.RAW_MAT_UDF UF ON "
            + "MS.RAW_MAT_KEY=UF.ITEM_KEY WHERE PT.EVENT_DATE='" + xdate + "' and PT.EVENT_TMST>='"
            + beginDate + "' and PT.EVENT_TMST<'" + endDate + "' AND left(PT.PRODUCT_PN,2)='HW' "
            + "AND (LENGTH(PT.PRODUCT_ID)=16 OR LENGTH(PT.PRODUCT_ID)=20 or LENGTH(PT.PRODUCT_ID)=13 "
            + "or left(PT.PRODUCT_ID,2)='CN' or left(PRODUCT_ID,2)='cn') "
            + "and left(PT.EVENT_TYPE,10)='START OPER' ORDER BY MS.RAW_MAT_PN with ur";
    List<Map<String, Object>> result = DB2Util
        .db2Query("jdbc:db2://10.11.5.3:50000/cgsdw", "cgsapp", "T0mcat4Fun", sql);
    List<WipKeyPartsDto> wipKeyPartsDtos = new ArrayList<>();
    if (null != result && result.size() > 0) {
      List<WipKeyPartsModel> wipKeyPartsModels = WipKeyPartsModelUtil.castEntity(result);
      String material_part_number = "";
      String supplier_pn = "";
      String item_id2 = "";
      for (int i = 0; i < wipKeyPartsModels.size(); i++) {
        if (i == 0) {
          wipKeyPartsDtos.add(WipKeyPartsDtoUtil
              .crateDto(wipKeyPartsModels.get(i), material_part_number, supplier_pn, item_id2,
                  null));
        } else {
          wipKeyPartsDtos.add(WipKeyPartsDtoUtil
              .crateDto(wipKeyPartsModels.get(i), material_part_number, supplier_pn, item_id2,
                  wipKeyPartsDtos.get(i - 1)));
        }
      }
      String url = HOST_IP + "api/WIP_KEYPARTS_T/AddListModelWIP_KEYPARTS_T";
      String data = JSON.toJSONString(wipKeyPartsDtos);
      return HttpUtil.sendInfo(url, data);
    } else {
      return "No data send";
    }

  }

  // send base data2 data to h3c
  public String sendZcbPcbRelationData(Date date) throws IOException {
    String endDate = DateUtil.formatDate(date);
    String beginDate = DateUtil.getBeforeTimeByMinute(date, 20);
    String sql =
        "Select case when charindex('_TASK_',c.part_serial)>0 then substring(c.part_serial,"
            + "0,charindex('_TASK_',c.part_serial)) else c.part_serial end as part_serial,case when "
            + "charindex('_TASK_',b.serial_number)>0 then substring(b.serial_number,0,charindex('_TASK_',"
            + "b.serial_number)) else b.serial_number end as serial_number,c.last_modified_time,"
            + "c.status From consumed_part c join unit b on c.tobj_key=b.unit_key Where "
            + "c.last_modified_time>='" + beginDate + "' and c.last_modified_time<'" + endDate
            + "' "
            + "and left(b.serial_number,2)='03' and b.part_number like 'HW%' and c.part_serial "
            + "is not null "
            + "union all  Select c.part_serial,case when charindex('_TASK_',b.serial_number)>0 then "
            + "substring(b.serial_number,0,charindex('_TASK_',b.serial_number)) else b.serial_number "
            + "end as serial_number,c.last_modified_time,c.status From consumed_part c join unit b "
            + "on c.tobj_key=b.unit_key join mike_chg_sn e on b.unit_key=e.unit_key " +
            "Where e.old_serial_number<>e.new_serial_number and e.change_time>='" + beginDate
            + "' and "
            + "e.change_time<'" + endDate + "' and left(b.serial_number,2)='03' and b.part_number "
            + "like 'HW%' and c.part_serial is not null ";

    List<ZcbPcbRelationDto> zcbPcbRelationDtos = new ArrayList<>();
    List<ZcbPcbRelationModel> zcbPcbRelationModels = new ArrayList<>();
    try {
      Query query = entityManager.createNativeQuery(sql);
      List<Object[]> resultList = query.getResultList();
      zcbPcbRelationModels = CommonUtils.castEntity(resultList, ZcbPcbRelationModel.class);
    } catch (Exception e) {
      e.printStackTrace();
    }
    if (zcbPcbRelationModels.size() > 0) {
      zcbPcbRelationModels
          .forEach(zcbPcbRelationModel -> zcbPcbRelationDtos
              .add(ZcbPcbRelationDtoUtil.createZcbPcbRelationDto(zcbPcbRelationModel)));
      zcbPcbRelationDtos.forEach(zcbPcbRelationDto -> {
        ZcbPcbRelationEntity zcbPcbRelationEntity = new ZcbPcbRelationEntity();
        BeanUtils.copyProperties(zcbPcbRelationDto, zcbPcbRelationEntity);
        zcbPcbRelationEntity.setCreationTime(date);
        zcbPcbRelationRepository.save(zcbPcbRelationEntity);
      });
      String url = HOST_IP + "api/ZCB_PCB_RELATION/AddListModelZCB_PCB_RELATION";
      String data = JSON.toJSONString(zcbPcbRelationDtos);
      return HttpUtil.sendInfo(url, data);
    } else {
      return "No data send";
    }
  }

  //send base data3 to h3c
  public String sendSnPcbRelationData(Date date) throws IOException {
    String endDate = DateUtil.formatDate(date);
    String beginDate = DateUtil.getBeforeTimeByMinute(date, 20);
    String sql =
        "select case when charindex('_TASK_',a.part_serial)>0 then substring(a.part_serial,0,"
            + "charindex('_TASK_',a.part_serial)) else a.part_serial end as part_serial,case "
            + "when charindex('_TASK_',b.serial_number)>0 then substring(b.serial_number, "
            + "0,charindex('_TASK_',b.serial_number)) else b.serial_number end as serial_number,"
            + "a.last_modified_time,b.part_number,a.status into ##lbasedata3_temp From consumed_part a "
            + "with(NOLOCK) join unit b with(NOLOCK) on a.tobj_key=b.unit_key Where "
            + "a.last_modified_time>=' " + beginDate + "' and a.last_modified_time<' " + endDate +
            "' and b.part_number like 'HW%' and left(b.serial_number,2)<>'03' and a.part_serial "
            + "is not null union all select case when charindex('_TASK_',a.part_serial)>0 then "
            + "substring(a.part_serial,0,charindex('_TASK_',a.part_serial)) else a.part_serial end "
            + "as part_serial,case when charindex('_TASK_',b.serial_number)>0 then "
            + "substring(b.serial_number,0,charindex('_TASK_',b.serial_number)) else b.serial_number"
            + " end as serial_number,a.last_modified_time,b.part_number,a.status From consumed_part "
            + "a with(NOLOCK) join unit b with(NOLOCK) on a.tobj_key=b.unit_key join mike_chg_sn "
            + "e on b.unit_key=e.unit_key Where e.old_serial_number<>e.new_serial_number and "
            + "e.change_time>=' " + beginDate + "' and e.change_time<' " + endDate + "' "
            + "and b.part_number like 'HW%' and left(b.serial_number,2)<>'03' and a.part_serial is not null "
            + "union all select a.h3c_sn,a.serial_number,a.pack_time,b.part_number,'Normal' as status  "
            + "From mike_h3c_3130_rec a with(NOLOCK) left outer join unit b with(NOLOCK) on "
            + "a.serial_number=b.serial_number "
            + "Where a.pack_time>=' " + beginDate + "' and a.pack_time<' " + endDate
            + " ' and a.pack_time is not null and left(b.part_number,2)='HW' "
            + "union all select a.authorization_book,a.serial_number,a.operate_date,b.part_number,"
            + "'Normal' as status From H3C_authorization a with(NOLOCK) left outer join unit "
            + "b with(NOLOCK) on a.unit_key=b.unit_key "
            + "Where a.operate_date>=' " + beginDate + "' and a.operate_date<'  " + endDate
            + "' and a.operate_date is not null and left(b.part_number,2)='HW'";

    Query insertData = entityManager.createNativeQuery(sql);
    insertData.executeUpdate();

    String sqlQuery = "select * from ##lbasedata3_temp";
    Query query = entityManager.createNativeQuery(sqlQuery);
    List<Object[]> resultList = query.getResultList();

    String sqlDrop = "drop table ##lbasedata3_temp";
    Query dropQuery = entityManager.createNativeQuery(sqlDrop);
    dropQuery.executeUpdate();

    List<SnPcbRelationDto> snPcbRelationDtos = new ArrayList<>();
    List<SnPcbRelationModel> snPcbRelationModels = new ArrayList<>();
    try {
      snPcbRelationModels = CommonUtils.castEntity(resultList, SnPcbRelationModel.class);
    } catch (Exception e) {
      e.printStackTrace();
    }
    if (snPcbRelationModels.size() > 0) {
      snPcbRelationModels
          .forEach(snPcbRelationModel -> snPcbRelationDtos
              .add(SnPcbRelationDtoUtil.createSnPcbRelationDto(snPcbRelationModel)));
      snPcbRelationDtos.forEach(snPcbRelationDto -> {
        SnPcbRelationEntity snPcbRelationEntity = new SnPcbRelationEntity();
        BeanUtils.copyProperties(snPcbRelationDto, snPcbRelationEntity);
        snPcbRelationEntity.setCreationTime(date);
        snPcbRelationRepository.save(snPcbRelationEntity);
      });
      String url = HOST_IP + "api/SN_PCB_RELATION/AddListModelSN_PCB_RELATION";
      String data = JSON.toJSONString(snPcbRelationDtos);
      return HttpUtil.sendInfo(url, data);
    } else {
      return "No data send";
    }
  }


  //send code data to h3c
  public String sendSnVerificationMarkData(Date date) throws IOException {
    String endDate = DateUtil.formatDate(date);
    String beginDate = DateUtil.getBeforeTimeByMinute(date, 20);
    String sql =
        "select c.order_number,substring(b.part_number,patindex('%0%',b.part_number),8),case when"
            + " charindex('_TASK_',b.serial_number)>0 then substring(b.serial_number,0,"
            + "charindex('_TASK_',b.serial_number)) else b.serial_number end as serial_number,"
            + "b.uda_9,a.complete_time from tracked_object_history a with(NOLOCK) join unit b "
            + "with(NOLOCK) on a.tobj_key=b.unit_key join work_order c with(NOLOCK) on "
            + "b.order_key=c.order_key left outer join unit d with(NOLOCK) on a.tobj_key=d.unit_key "
            + "where a.op_name='PACK' and a.complete_time >= '" + beginDate
            + "' and a.complete_time < '" + endDate
            + "' and (b.uda_9 like '66%' or b.uda_9 like '88%') and left(d.part_number,2)='HW' ";

    Query query = entityManager.createNativeQuery(sql);
    List<Object[]> resultList = query.getResultList();

    String sqlQuery = "select c.order_number,substring(b.part_number,patindex('%0%',b.part_number),"
        + "8),case when charindex('_TASK_',b.serial_number)>0 then substring(b.serial_number,0,"
        + "charindex('_TASK_',b.serial_number)) else b.serial_number end as serial_number,b.uda_9,"
        + "a.change_time from mike_chg_sn a with(NOLOCK) join unit b with(NOLOCK) on "
        + "a.unit_key=b.unit_key join work_order c with(NOLOCK) on b.order_key=c.order_key "
        + "where a.old_serial_number<>a.new_serial_number and a.change_time>='" + beginDate
        + "' and a.change_time<'" + endDate + "' and (b.uda_9 like '66%' or b.uda_9 like '88%')"
        + " and left(b.part_number,2)='HW'";
    Query queryNew = entityManager.createNativeQuery(sqlQuery);
    List<Object[]> resultList1 = queryNew.getResultList();

    if (null != resultList1 && resultList1.size() > 0) {
      for (int i = 0; i < resultList1.size(); i++) {
        resultList.add(resultList1.get(i));
      }
    }

    List<SnVerificationMarkDto> snVerificationMarkDtos = new ArrayList<>();
    List<SnVerificationMarkModel> snVerificationMarkModels = new ArrayList<>();
    try {
      snVerificationMarkModels = CommonUtils.castEntity(resultList, SnVerificationMarkModel.class);
    } catch (Exception e) {
      e.printStackTrace();
    }
    if (snVerificationMarkModels.size() > 0) {
      snVerificationMarkModels
          .forEach(snVerificationMarkModel -> snVerificationMarkDtos
              .add(SnVerificationMarkDtoUtil
                  .createSnVerificationMarkDto(snVerificationMarkModel)));
      snVerificationMarkDtos.forEach(snVerificationMarkDto -> {
        SnVerificationMarkEntity snVerificationMarkEntity = new SnVerificationMarkEntity();
        BeanUtils.copyProperties(snVerificationMarkDto, snVerificationMarkEntity);
        snVerificationMarkEntity.setCreationTime(date);
        snVerificationMarkRepository.save(snVerificationMarkEntity);
      });
      String url = HOST_IP + "api/SN_VERIFICATION_MARK/AddListModelSN_VERIFICATION_MARK";
      String data = JSON.toJSONString(snVerificationMarkDtos);
      return HttpUtil.sendInfo(url, data);
    } else {
      return "No data send";
    }
  }

  //send HP data to h3c
  public String sendCustSerialRelationData(Date date) throws IOException {
    String endDate = DateUtil.formatDate(date);
    String beginDate = DateUtil.getBeforeTimeByMinute(date, 20);
    String sql =
        "select case when charindex('_TASK_',a.serial_number)>0 then substring(a.serial_number,0,"
            + "charindex('_TASK_',a.serial_number)) else a.serial_number end as serial_number,"
            + "b.component_SN,b.creation_time from unit a with (nolock),dc_component_SN b with "
            + "(nolock) Where a.unit_key = b.unit_key and left(a.part_number,2)='HW' and "
            + "b.remark='HP' and b.creation_time>='" + beginDate + "' and b.creation_time<'"
            + endDate + "' "
            + "union all select a.new_serial_number,b.component_SN,b.creation_time "
            + " from mike_chg_sn a with (nolock),dc_component_SN b with (nolock) Where a.unit_key "
            + "= b.unit_key and a.old_serial_number<>a.new_serial_number and b.remark='HP' "
            + "and a.change_time>='" + beginDate + "' and a.change_time<'" + endDate + "' ";

    Query query = entityManager.createNativeQuery(sql);
    List<Object[]> resultList = query.getResultList();

    List<CustSerialRelationDto> custSerialRelationDtos = new ArrayList<>();
    List<CustSerialRelationModel> custSerialRelationModels = new ArrayList<>();
    try {
      custSerialRelationModels = CommonUtils.castEntity(resultList, CustSerialRelationModel.class);
    } catch (Exception e) {
      e.printStackTrace();
    }
    if (custSerialRelationModels.size() > 0) {
      custSerialRelationModels
          .forEach(custSerialRelationModel -> custSerialRelationDtos
              .add(CustSerialRelationDtoUtil
                  .createCustSerialRelationDto(custSerialRelationModel)));
      custSerialRelationDtos.forEach(custSerialRelationDto -> {
        CustSerialRelationEntity custSerialRelationEntity = new CustSerialRelationEntity();
        BeanUtils.copyProperties(custSerialRelationDto, custSerialRelationEntity);
        custSerialRelationEntity.setCreationTime(date);
        custSerialRelationRepository.save(custSerialRelationEntity);
      });
      String url = HOST_IP + "api/CUST_SERIAL_RELATION/AddListModelCUST_SERIAL_RELATION";
      String data = JSON.toJSONString(custSerialRelationDtos);
      return HttpUtil.sendInfo(url, data);
    } else {
      return "No data send";
    }
  }

  //send imei data to h3c
  public String sendSnImeiData(Date date) throws IOException {
    String endDate = DateUtil.formatDate(date);
    String beginDate = DateUtil.getBeforeTimeByMinute(date, 20);
    String sql =
        "select case when charindex('_TASK_',a.serial_number)>0 then substring(a.serial_number,"
            + "0,charindex('_TASK_',a.serial_number)) else a.serial_number end as serial_number,"
            + "b.component_SN,b.creation_time from unit a with (nolock),dc_component_SN b "
            + "with (nolock) Where a.unit_key = b.unit_key and left(a.part_number,2)='HW' " +
            "and b.remark='GPSSupply' and b.creation_time>='" + beginDate
            + "' and b.creation_time<'"
            + endDate + "' ";

    Query query = entityManager.createNativeQuery(sql);
    List<Object[]> resultList = query.getResultList();

    List<SnImeiDto> snImeiDtos = new ArrayList<>();
    List<SnImeiModel> snImeiModels = new ArrayList<>();
    try {
      snImeiModels = CommonUtils.castEntity(resultList, SnImeiModel.class);
    } catch (Exception e) {
      e.printStackTrace();
    }
    if (snImeiModels.size() > 0) {
      snImeiModels
          .forEach(snImeiModel -> snImeiDtos.add(SnImeiDtoUtil.createSnImeiDto(snImeiModel)));
      snImeiDtos.forEach(snImeiDto -> {
        SnImeiEntity snImeiEntity = new SnImeiEntity();
        BeanUtils.copyProperties(snImeiDto, snImeiEntity);
        snImeiEntity.setCreationTime(date);
        snImeiRepository.save(snImeiEntity);
      });
      String url = HOST_IP + "api/SN_IMEI/AddListModelSN_IMEI";
      String data = JSON.toJSONString(snImeiDtos);
      return HttpUtil.sendInfo(url, data);
    } else {
      return "No data send";
    }
  }

  //send EC data to h3c
  public String sendCmEcData(Date date) throws IOException {
    String endDate = DateUtil.formatDate(date);
    String beginDate = DateUtil.getBeforeTimeByMinute(date, 20);
    String sql =
        "select case when charindex('_TASK_',a.serial_number)>0 then substring(a.serial_number,0,"
            + "charindex('_TASK_',a.serial_number)) else a.serial_number end as serial_number,"
            + "a.EC,a.creation_time,a.remark from H3C_EC a with (nolock) Where a.creation_time>='"
            + beginDate + "' and a.creation_time<'" + endDate + "' ";

    Query query = entityManager.createNativeQuery(sql);
    List<Object[]> resultList = query.getResultList();

    List<CmEcDto> cmEcDtos = new ArrayList<>();
    List<CmEcModel> cmEcModels = new ArrayList<>();
    try {
      cmEcModels = CommonUtils.castEntity(resultList, CmEcModel.class);
    } catch (Exception e) {
      e.printStackTrace();
    }
    if (cmEcModels.size() > 0) {
      cmEcModels
          .forEach(cmEcModel -> cmEcDtos
              .add(CmEcDtoUtil
                  .createCmEcDto(cmEcModel)));
      cmEcDtos.forEach(cmEcDto -> {
        CmEcEntity cmEcEntity = new CmEcEntity();
        BeanUtils.copyProperties(cmEcDto, cmEcEntity);
        cmEcEntity.setCreationTime(date);
        cmEcRepository.save(cmEcEntity);
      });
      String url = HOST_IP + "api/CM_EC/AddListModelCM_EC";
      String data = JSON.toJSONString(cmEcDtos);
      return HttpUtil.sendInfo(url, data);
    } else {
      return "No data send";
    }
  }

  //send ship data to h3c
  public String sendSnLabelData(Date date) throws IOException {
    String endDate = DateUtil.formatDate(date);
    String beginDate = DateUtil.getBeforeTimeByMinute(date, 20);
    String sql =
        "SELECT b.serial_number,CASE WHEN charindex('_TASK_', b.serial_number) > 0 THEN "
            + "substring(b.serial_number, 0, charindex('_TASK_', b.serial_number)) ELSE "
            + "b.serial_number END AS serial_number1, b.part_number, 'B', b.part_revision , "
            + "(select software_version from afg_b_h3c_upload with(NOLOCK) where "
            + "serial_number=(CASE WHEN charindex('_TASK_', b.serial_number) > 0 "
            + "THEN substring(b.serial_number, 0, charindex('_TASK_', b.serial_number)) ELSE "
            + "b.serial_number END)) as software_version , (select power_code from afg_b_h3c_upload "
            + "with(NOLOCK) where serial_number=(CASE WHEN charindex('_TASK_', b.serial_number) > 0"
            + " THEN substring(b.serial_number, 0, charindex('_TASK_', b.serial_number)) ELSE "
            + "b.serial_number END)) as power_code , (select power_origin from afg_b_h3c_upload "
            + "with(NOLOCK) where serial_number=(CASE WHEN charindex('_TASK_', b.serial_number) > 0 "
            + "THEN substring(b.serial_number, 0, charindex('_TASK_', b.serial_number)) ELSE "
            + "b.serial_number END)) as power_origin , (select QualityGrade from H3C_QualityGrade "
            + "with(NOLOCK) where serial_number=(CASE WHEN charindex('_TASK_', b.serial_number) > 0 "
            + "THEN substring(b.serial_number, 0, charindex('_TASK_', b.serial_number)) ELSE "
            + "b.serial_number END)) as QualityGrade , (select count(*) from H3C_R4_Exclude "
            + "with(NOLOCK) where serial_number=(CASE WHEN charindex('_TASK_', b.serial_number) > 0 "
            + "THEN substring(b.serial_number, 0, charindex('_TASK_', b.serial_number)) ELSE "
            + "b.serial_number END)) as R4_Exclude , (select [5000_status] from afg_b_h3c_upload "
            + "with(NOLOCK) where serial_number=(CASE WHEN charindex('_TASK_', b.serial_number) > 0"
            + " THEN substring(b.serial_number, 0, charindex('_TASK_', b.serial_number)) ELSE "
            + "b.serial_number END)) as [5000_status] , a.complete_time "
            + " , (select PB from afg_b_h3c_upload with(NOLOCK) where serial_number=(CASE WHEN "
            + "charindex('_TASK_', b.serial_number) > 0 THEN substring(b.serial_number, 0, "
            + "charindex('_TASK_', b.serial_number)) ELSE b.serial_number END)) as PB "
            + ", (select order_number from work_order with(NOLOCK) where order_key=b.order_key) as order_number, b.unit_key "
            + ", (select count(*) from H3C_PB_ASSIGN with(NOLOCK) where part_number=b.part_number) as PB_ASSIGN "
            + ", STUFF((select ','+pb from afg_b_h3c_upload with(NOLOCK) where serial_number in ( "
            + " select CASE WHEN charindex('_TASK_', cc03.part_serial) > 0 THEN substring(cc03.part_serial, 0, "
            + "charindex('_TASK_', cc03.part_serial)) ELSE cc03.part_serial END AS part_serial from unit u with(NOLOCK) "
            + " left outer join consumed_part cc03 with(NOLOCK) on u.unit_key=cc03.tobj_key "
            + " where u.serial_number=b.serial_number and cc03.status='Consumed' and left(cc03.part_serial,2)='02' "
            + " Union All "
            + " select CASE WHEN charindex('_TASK_', ccc02.part_serial) > 0 THEN substring(ccc02.part_serial, 0, "
            + "charindex('_TASK_', ccc02.part_serial)) ELSE ccc02.part_serial END AS part_serial from unit u21 with(NOLOCK) "
            + " left outer join consumed_part ccc03 with(NOLOCK) on u21.unit_key=ccc03.tobj_key and "
            + "ccc03.status='Consumed' left outer join unit u03 with(NOLOCK) on u03.serial_number = ccc03.part_serial left outer "
            + "join consumed_part ccc02 on ccc02.tobj_key=u03.unit_key and ccc02.status='Consumed' "
            + " where u21.serial_number=b.serial_number and left(ccc02.part_serial,2)='02') FOR XML PATH('')) ,1,1,'') as PB_02Part  "
            + " FROM TRACKED_OBJECT_HISTORY a with(NOLOCK) "
            + " LEFT OUTER JOIN UNIT b with(NOLOCK) ON a.tobj_key = b.unit_key "
            + " WHERE left(b.part_number,2) = 'HW' "
            + " and a.complete_time >= '" + beginDate + "' and a.complete_time < '" + endDate + "' "
            + " and (a.op_name like '%(FGI)' or a.op_name='Pack') and a.complete_reason like 'PASS%' ";

    Query query = entityManager.createNativeQuery(sql);
    List<Object[]> resultList = query.getResultList();

    List<SnLabelDataDto> snLabelDataDtos = new ArrayList<>();
    List<SnLabelDataModel> snLabelDataModels = new ArrayList<>();
    try {
      //SnLabelDataModel snLabelDataModel = new SnLabelDataModel();
      snLabelDataModels = CommonUtils.castEntity(resultList, SnLabelDataModel.class);
    } catch (Exception e) {
      e.printStackTrace();
    }
    if (snLabelDataModels.size() > 0) {
      snLabelDataModels.forEach(snLabelDataModel -> snLabelDataDtos
          .add(SnLabelDataDtoUtil.createSnLabelDataDto(snLabelDataModel)));
      snLabelDataDtos.forEach(snLabelDataDto -> {
        SnLabelDataEntity snLabelDataEntity = new SnLabelDataEntity();
        BeanUtils.copyProperties(snLabelDataDto, snLabelDataEntity);
        snLabelDataEntity.setCreationTime(date);
        snLabelDataRepository.save(snLabelDataEntity);
      });
      String url = HOST_IP + "api/SN_LABEL_DATA/AddListModelSN_LABEL_DATA";
      String data = JSON.toJSONString(snLabelDataDtos);
      return HttpUtil.sendInfo(url, data);
    } else {
      return "No data send";
    }
  }

  //send h3c api json data manually
  public ResponseDto sendDataManually(String runTime, String apiName) {
    ResponseDto responseDto = new ResponseDto();
    H3CApiErrorResult errorResult = h3CApiErrorResultRepository
        .findH3CApiErrorResultsByApiNameAndRunTime(apiName, runTime);
    if (null == errorResult) {
      responseDto.setResult("error");
      responseDto.setResultMsg("没查到此api在" + runTime + "漏传数据的记录");
      return responseDto;
    }
    Date runDate = DateUtil.parseDate(runTime);
    String result = "";
    try {
      switch (apiName) {
        case "SnDetailProcessData":
          result = sendSnDetailProcessData(runDate);
          break;
        case "SnDetailTestData":
          result = sendSnDetailTestData(runDate);
          break;
        case "LotReturnData":
          result = sendLotReturnData(runDate);
          break;
        case "DefectRepairData":
          result = sendDefectRepairData(runDate);
          break;
        case "ProdFitDefect":
          result = sendProdFitDefect(runDate);
          break;
        case "SnPcbRelationData":
          result = sendSnPcbRelationData(runDate);
          break;
        case "ZcbPcbRelationData":
          result = sendZcbPcbRelationData(runDate);
          break;
        case "SnVerificationMarkData":
          result = sendSnVerificationMarkData(runDate);
          break;
        case "CustSerialRelationData":
          result = sendCustSerialRelationData(runDate);
          break;
        case "SnLabelData":
          result = sendSnLabelData(runDate);
          break;
        case "SnImeiData":
          result = sendSnImeiData(runDate);
          break;
        case "CmEcData":
          result = sendCmEcData(runDate);
          break;
        default:
          break;
      }
    } catch (Exception e) {
      e.printStackTrace();
      errorResult.setException(e.toString());
      h3CApiErrorResultRepository.save(errorResult);
      responseDto.setResult("error");
      responseDto.setResultMsg("send data manually failed:" + e.toString());
      return responseDto;
    }
    if (null != result && result.length() > 0) {
      JSONObject jsonObject = JSONObject.parseObject(result);
      if (100 == jsonObject.getIntValue("code")) {
        h3CApiErrorResultRepository.deleteH3CApiErrorResultsByApiNameAndRunTime(apiName, runTime);
        responseDto.setResult("success");
        responseDto.setResultMsg("补跑成功!");
        return responseDto;
      } else {
        errorResult.setMsg(jsonObject.getString("msg"));
        h3CApiErrorResultRepository.save(errorResult);
        responseDto.setResult("error");
        responseDto.setResultMsg("send data manually failed:" + jsonObject.getString("msg"));
        return responseDto;
      }
    } else if (result.equals("No data send")) {
      h3CApiErrorResultRepository.deleteH3CApiErrorResultsByApiNameAndRunTime(apiName, runTime);
      responseDto.setResult("success");
      responseDto.setResultMsg("补跑成功!");
      return responseDto;
    }
    responseDto.setResult("error");
    responseDto.setResultMsg("send data manually failed:" + result);
    return responseDto;
  }

  public List<H3CApiErrorResultDto> findErrorResult() {
    List<H3CApiErrorResult> errorResults = h3CApiErrorResultRepository.findAll();
    List<H3CApiErrorResultDto> errorResultDtos = new ArrayList<>();
    if (null != errorResults && errorResults.size() > 0) {
      errorResults.forEach(
          h3CApiErrorResult -> errorResultDtos.add(new H3CApiErrorResultDto(h3CApiErrorResult)));
    }
    return errorResultDtos;
  }


  public static void main(String[] args) throws Exception {
    // H3CDataTransmissionService h3CDataTransmissionService = new H3CDataTransmissionService();
    //String result = h3CDataTransmissionService.sendLotReturnData(new Date());
//    List<Map<String, Object>> result = DB2Util
//        .db2Query("jdbc:db2://10.11.5.3:50000/cgsdw", "cgsapp", "T0mcat4Fun",
//            "SELECT * FROM CGSPCM.DAILY_PRODUCTION fetch first 10 rows only");
//    System.out.println("");
    SendEmailUtil.sendEmail("CN_SUZ_IT_MES@asteelflash.com,Pubcmdata@h3c.com", "test", "test");
    //System.out.println(DateUtil.getBeforeTimeByMinute(new Date(), 20));
  }


}
