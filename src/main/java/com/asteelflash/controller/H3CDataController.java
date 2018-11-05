package com.asteelflash.controller;

import com.asteelflash.dto.H3CApiErrorResultDto;
import com.asteelflash.dto.LotReturnDto;
import com.asteelflash.dto.ResponseDto;
import com.asteelflash.dto.SnDetailDto;
import com.asteelflash.entity.BaseEntity;
import com.asteelflash.service.H3CDataTransmissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hunter.fei on 2018/10/17.
 */
@EnableAutoConfiguration
@RestController
@RequestMapping(value = "/api/h3c")
@Api(value = "send h3c data manually interface", consumes = "application/json")
public class H3CDataController {

  @Autowired
  private H3CDataTransmissionService h3CDataTransmissionService;

  @ApiOperation(value = "手动发送H3C接口数据", response = ResponseDto.class)
  @RequestMapping(value = "/sendData", method = RequestMethod.POST)
  public ResponseDto sendDataManually(@RequestParam(value = "runTime") String runTime,
      @RequestParam(value = "apiName") String apiName) {
    return h3CDataTransmissionService.sendDataManually(runTime, apiName);
  }

  @ApiOperation(value = "查询数据未能正常发送时间段", response = H3CApiErrorResultDto.class)
  @RequestMapping(value = "/findErrorResult", method = RequestMethod.GET)
  public List<H3CApiErrorResultDto> findErrorResult() {
    return h3CDataTransmissionService.findErrorResult();
  }


}
