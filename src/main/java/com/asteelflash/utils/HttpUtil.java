package com.asteelflash.utils;

import com.alibaba.fastjson.JSON;
import com.asteelflash.dto.SnDetailDto;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * Created by hunter.fei on 2018/6/5.
 */
public class HttpUtil {

  public static String sendInfo(String url, String data) throws IOException {
    CloseableHttpClient client = HttpClients.createDefault();
    HttpPost post = new HttpPost(url);
    StringEntity myEntity = new StringEntity(data,
        ContentType.APPLICATION_JSON);// 构造请求数据
    post.setEntity(myEntity);// 设置请求体
    String responseContent = null; // 响应内容
    CloseableHttpResponse response = null;

    response = client.execute(post);
    if (response.getStatusLine().getStatusCode() == 200) {
      HttpEntity entity = response.getEntity();
      responseContent = EntityUtils.toString(entity, "UTF-8");
    }

    try {
      if (response != null) {
        response.close();
      }

    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (client != null) {
          client.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    return responseContent;
  }

  public static void main(String[] args) throws IOException {
    SnDetailDto snDetailDto = new SnDetailDto();
    snDetailDto.setCLASS_CODE("test1");
    snDetailDto.setCREATION_DATE("2018-06-15 08:56:00");
    snDetailDto.setDEFECT_CODE("test2");
    snDetailDto.setEMP_NO("test3");
    snDetailDto.setERP_IMPORT_FLAG("test4");
    snDetailDto.setERR_DESC("test5");
    snDetailDto.setFACTORY_CODE("test6");
    snDetailDto.setERR_FLAG("test7");
    snDetailDto.setFILE_NAME("test8");
    snDetailDto.setIN_STATION_TIME("2018-06-15 08:59:00");
    snDetailDto.setLAST_UPDATE_DATE("2018-06-15 08:59:00");
    snDetailDto.setLINE_CODE("test10");
    snDetailDto.setMO_NUMBER("test11");
    snDetailDto.setPASS_COUNT(1);
    snDetailDto.setTEST_ID("test12");
    snDetailDto.setTEST_DESC("test13");
    snDetailDto.setSERIAL_NUMBER("test14");
    snDetailDto.setSECTION_CODE("test15");
    snDetailDto.setPCB_NUMBER("test16");
    snDetailDto.setOUT_FROM("test17");
    List<SnDetailDto> snDetailDtos = new ArrayList<>();
    snDetailDtos.add(snDetailDto);

    String result = sendInfo("http://10.11.1.157:90/api/SN_DETAIL/AddListModelSN_DETAIL",
        JSON.toJSONString(snDetailDtos));
    System.out.println(result);
  }
}
