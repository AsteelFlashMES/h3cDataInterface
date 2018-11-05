package com.asteelflash.repository;

import com.asteelflash.entity.DtoEntity.WipKeyPartsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by hunter.fei on 2018/10/25.
 */
public interface WipKeyPartRepository extends JpaRepository<WipKeyPartsEntity,String> {

}
