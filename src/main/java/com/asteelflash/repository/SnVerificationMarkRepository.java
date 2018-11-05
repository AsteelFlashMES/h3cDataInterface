package com.asteelflash.repository;

import com.asteelflash.entity.DtoEntity.SnVerificationMarkEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by hunter.fei on 2018/10/25.
 */
public interface SnVerificationMarkRepository extends
    JpaRepository<SnVerificationMarkEntity, String> {

}
