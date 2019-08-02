package com.tenthpower.dao;

import com.tenthpower.pojo.Pl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * JpaRepository提供了基本的增删改查
 * JpaSpecificationExecutor用于做复杂的条件查询
 */
public interface PlDao extends JpaRepository<Pl, String>, JpaSpecificationExecutor<Pl> {

}
