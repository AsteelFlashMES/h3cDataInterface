package com.asteelflash.repository;

import com.asteelflash.entity.H3CApiErrorResult;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by hunter.fei on 2018/10/16.
 */
public interface H3CApiErrorResultRepository extends JpaRepository<H3CApiErrorResult, String> {

  void deleteH3CApiErrorResultsByApiNameAndRunTime(@Param("apiName") String apiName,
      @Param("runTime") String rumTime);

  H3CApiErrorResult findH3CApiErrorResultsByApiNameAndRunTime(
      @Param("apiName") String apiName, @Param("runTime") String runTime);

}
