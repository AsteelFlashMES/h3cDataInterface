package com.asteelflash.service;

import com.alibaba.fastjson.JSONObject;
import com.asteelflash.dto.ResponseDto;
import com.asteelflash.entity.H3CApiErrorResult;
import com.asteelflash.repository.H3CApiErrorResultRepository;
import com.asteelflash.utils.DateUtil;
import com.asteelflash.utils.SendEmailUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Created by hunter.fei on 2018/8/10.
 */
@Configuration
@EnableScheduling
public class TimeTask {

  private final Logger logger = LoggerFactory.getLogger(getClass());

  @Resource
  private H3CDataTransmissionService h3CDataTransmissionService;

  @Resource
  private H3CApiErrorResultRepository h3CApiErrorResultRepository;

  private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  private static String toAddress = "CN_SUZ_IT_MES@asteelflash.com,Pubcmdata@h3c.com,"
      + "Jimi.He@asteelflash.com,yulan.xing@asteelflash.com,Amor.gu@asteelflash.com";

  @Scheduled(cron = "0 10/20 * * * ?") // 每20分钟执行一次
  public void sendData1() {
    Date date = new Date();

    logger.info("push data to h3c job 1,start time:" + DateUtil.formatDate(date));
//    String strDate = "2018-10-27 01:45:00";
//    Date newDate = DateUtil.parseDate(strDate);

    try {
      String result = h3CDataTransmissionService.sendSnDetailProcessData(date);
      logger.info("result of send data is:" + result + "###############################");
      if (null != result && result.length() > 0 && !result.equals("No data send")) {
        JSONObject jsonObject = JSONObject.parseObject(result);
        if (100 != jsonObject.getIntValue("code")) {
          h3CApiErrorResultRepository.save(createH3CApiErrorResult(jsonObject.getString("msg"),
              null, "SnDetailProcessData", date));
        }
      }
    } catch (Exception e) {
      h3CApiErrorResultRepository.save(createH3CApiErrorResult(null, e.toString(),
          "SnDetailProcessData", date));
    }
    try {
      String result = h3CDataTransmissionService.sendSnDetailTestData(date);
      logger.info("result of send data is:" + result + "###########.####################");
      if (null != result && result.length() > 0 && !result.equals("No data send")) {
        JSONObject jsonObject = JSONObject.parseObject(result);
        if (100 != jsonObject.getIntValue("code")) {
          h3CApiErrorResultRepository.save(createH3CApiErrorResult(jsonObject.getString("msg"),
              null, "SnDetailTestData", date));
        }
      }
    } catch (Exception e) {
      h3CApiErrorResultRepository
          .save(createH3CApiErrorResult(null, e.toString(), "SnDetailTestData", date));

    }
    try {
      String result = h3CDataTransmissionService.sendLotReturnData(date);
      logger.info("result of send data is:" + result + "###############################");
      if (null != result && result.length() > 0 && !result.equals("No data send")) {
        JSONObject jsonObject = JSONObject.parseObject(result);
        if (100 != jsonObject.getIntValue("code")) {
          h3CApiErrorResultRepository.save(createH3CApiErrorResult(jsonObject.getString("msg"),
              null, "LotReturnData", date));
        }
      }
    } catch (Exception e) {
      h3CApiErrorResultRepository.save(
          createH3CApiErrorResult(null, e.toString(), "LotReturnData", date));
    }
    try {
      String result = h3CDataTransmissionService.sendDefectRepairData(date);
      logger.info("result of send data is:" + result + "###############################");
      if (null != result && result.length() > 0 && !result.equals("No data send")) {
        JSONObject jsonObject = JSONObject.parseObject(result);
        if (100 != jsonObject.getIntValue("code")) {
          h3CApiErrorResultRepository.save(
              createH3CApiErrorResult(jsonObject.getString("msg"), null, "DefectRepairData", date));
        }
      }
    } catch (Exception e) {
      h3CApiErrorResultRepository.save(
          createH3CApiErrorResult(null, e.toString(), "DefectRepairData", date));

    }
    try {
      String result = h3CDataTransmissionService.sendProdFitDefect(date);
      logger.info("result of send data is:" + result + "###############################");
      if (null != result && result.length() > 0 && !result.equals("No data send")) {
        JSONObject jsonObject = JSONObject.parseObject(result);
        if (100 != jsonObject.getIntValue("code")) {
          h3CApiErrorResultRepository.save(
              createH3CApiErrorResult(jsonObject.getString("msg"), null, "ProdFitDefect", date));
        }
      }
    } catch (Exception e) {
      h3CApiErrorResultRepository.save(
          createH3CApiErrorResult(null, e.toString(), "ProdFitDefect", date));
    }
////    logger.info("result of send data is:" + h3CDataTransmissionService.sendWipKeyPartsData(date)
////        + "###############################");
    try {
      String result = h3CDataTransmissionService.sendSnPcbRelationData(date);
      logger.info("result of send data is:" + result + "###############################");
      if (null != result && result.length() > 0 && !result.equals("No data send")) {
        JSONObject jsonObject = JSONObject.parseObject(result);
        if (100 != jsonObject.getIntValue("code")) {
          h3CApiErrorResultRepository.save(createH3CApiErrorResult(
              jsonObject.getString("msg"), null, "SnPcbRelationData", date));
        }
      }
    } catch (Exception e) {
      h3CApiErrorResultRepository.save(createH3CApiErrorResult(
          null, e.toString(), "SnPcbRelationData", date));
    }
    logger.info("push h3c data job 1 end，end time:" + DateUtil.formatDate(new Date()));

  }

  @Scheduled(cron = "0 15/20 * * * ?") // 每20分钟执行一次
  public void sendData2() {
    Date date = new Date();

//    String strDate = "2018-10-29 15:30:00";
//    Date newDate = DateUtil.parseDate(strDate);

    logger.info("Push data to h3c job 2,start time:" + DateUtil.formatDate(date));
    try {
      String result = h3CDataTransmissionService.sendZcbPcbRelationData(date);
      logger.info("result of send data is:" + result + "###############################");
      if (null != result && result.length() > 0 && !result.equals("No data send")) {
        JSONObject jsonObject = JSONObject.parseObject(result);
        if (100 != jsonObject.getIntValue("code")) {
          h3CApiErrorResultRepository.save(createH3CApiErrorResult(jsonObject.getString("msg"),
              null, "ZcbPcbRelationData", date));
        }
      }
    } catch (Exception e) {
      h3CApiErrorResultRepository.save(createH3CApiErrorResult(null, e.toString(),
          "ZcbPcbRelationData", date));
    }
    try {
      String result = h3CDataTransmissionService.sendSnVerificationMarkData(date);
      logger.info(
          "result of send data is:" + result + "###############################");
      if (null != result && result.length() > 0 && !result.equals("No data send")) {
        JSONObject jsonObject = JSONObject.parseObject(result);
        if (100 != jsonObject.getIntValue("code")) {
          h3CApiErrorResultRepository.save(createH3CApiErrorResult(jsonObject.getString("msg"),
              null, "SnVerificationMarkData", date));
        }
      }
    } catch (Exception e) {
      h3CApiErrorResultRepository.save(createH3CApiErrorResult(null, e.toString(),
          "SnVerificationMarkData", date));
    }
    try {
      String result = h3CDataTransmissionService.sendCustSerialRelationData(date);
      logger.info("result of send data is:" + result + "###############################");
      if (null != result && result.length() > 0 && !result.equals("No data send")) {
        JSONObject jsonObject = JSONObject.parseObject(result);
        if (100 != jsonObject.getIntValue("code")) {
          h3CApiErrorResultRepository.save(createH3CApiErrorResult(jsonObject.getString("msg"),
              null, "CustSerialRelationData", date));
        }
      }
    } catch (Exception e) {
      h3CApiErrorResultRepository.save(createH3CApiErrorResult(null,
          e.toString(), "CustSerialRelationData", date));
    }
    try {
      String result = h3CDataTransmissionService.sendSnLabelData(date);
      logger.info("result of send data is:" + result + "###############################");
      if (null != result && result.length() > 0 && !result.equals("No data send")) {
        JSONObject jsonObject = JSONObject.parseObject(result);
        if (100 != jsonObject.getIntValue("code")) {
          h3CApiErrorResultRepository.save(createH3CApiErrorResult(jsonObject.getString("msg"),
              null, "SnLabelData", date));
        }
      }
    } catch (Exception e) {
      h3CApiErrorResultRepository.save(createH3CApiErrorResult(null, e.toString(),
          "SnLabelData", date));
    }
    try {
      String result = h3CDataTransmissionService.sendSnImeiData(date);
      logger.info("result of send data is:" + result + "###############################");
      if (null != result && result.length() > 0 && !result.equals("No data send")) {
        JSONObject jsonObject = JSONObject.parseObject(result);
        if (100 != jsonObject.getIntValue("code")) {
          h3CApiErrorResultRepository.save(createH3CApiErrorResult(jsonObject.getString("msg"),
              null, "SnImeiData", date));
        }
      }
    } catch (Exception e) {
      h3CApiErrorResultRepository.save(createH3CApiErrorResult(null,
          e.toString(), "SnImeiData", date));
    }
    try {
      String result = h3CDataTransmissionService.sendCmEcData(date);
      logger.info("result of send data is:" + result + "###############################");
      if (null != result && result.length() > 0 && !result.equals("No data send")) {
        JSONObject jsonObject = JSONObject.parseObject(result);
        if (100 != jsonObject.getIntValue("code")) {
          h3CApiErrorResultRepository.save(createH3CApiErrorResult(jsonObject.getString("msg"),
              null, "CmEcData", date));
        }
      }
    } catch (Exception e) {
      h3CApiErrorResultRepository.save(createH3CApiErrorResult(null, e.toString(),
          "CmEcData", date));
    }

    logger.info("push h3c data job 2 end，end time:" + DateUtil.formatDate(new Date()));
  }


  @Scheduled(cron = "0 0/60 * * * ?") // 每60分钟执行一次
  public void autoHandleErrorData() {
    List<H3CApiErrorResult> h3CApiErrorResultList = h3CApiErrorResultRepository.findAll();
    if (null != h3CApiErrorResultList && h3CApiErrorResultList.size() > 0) {
      for (H3CApiErrorResult h3CApiErrorResult : h3CApiErrorResultList) {
        ResponseDto responseDto = h3CDataTransmissionService
            .sendDataManually(h3CApiErrorResult.getRunTime(), h3CApiErrorResult.getApiName());
        if (!responseDto.getResult().equals("success")) {
          h3CApiErrorResult.setFailQty(h3CApiErrorResult.getFailQty() + 1);
          if (h3CApiErrorResult.getFailQty() > 2) {
            try {
              SendEmailUtil.sendEmail(
                  toAddress,
                  "H3C_REPORT_API_INTERFACE",
                  h3CApiErrorResult.getApiName() + "send data failed,run time is: "
                      + h3CApiErrorResult.getRunTime());
            } catch (Exception e) {
              e.printStackTrace();
            }
          }
          h3CApiErrorResultRepository.save(h3CApiErrorResult);
        }
      }
    }
  }

  private H3CApiErrorResult createH3CApiErrorResult(String msg, String exception, String apiName,
      Date runTime) {
    H3CApiErrorResult h3CApiErrorResult = new H3CApiErrorResult();
    h3CApiErrorResult.setApiName(apiName);
    h3CApiErrorResult.setMsg(msg);
    h3CApiErrorResult.setException(exception);
    h3CApiErrorResult.setRunTime(format.format(runTime));
    h3CApiErrorResult.setCreationTime(new Date());
    h3CApiErrorResult.setFailQty(0);
    return h3CApiErrorResult;
  }
}
