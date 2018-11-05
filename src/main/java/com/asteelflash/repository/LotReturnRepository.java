package com.asteelflash.repository;

import com.asteelflash.entity.DtoEntity.LotReturnEntity;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by hunter.fei on 2018/10/25.
 */
public interface LotReturnRepository extends JpaRepository<LotReturnEntity, String> {
  List<LotReturnEntity> findByCreationTime(@Param("creationTime") Date creationTime);

}
