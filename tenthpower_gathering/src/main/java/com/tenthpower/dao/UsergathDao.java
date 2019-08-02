package com.tenthpower.dao;

import com.tenthpower.pojo.Gathering;
import com.tenthpower.pojo.Usergath;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * JpaRepository提供了基本的增删改查
 * JpaSpecificationExecutor用于做复杂的条件查询
 */
public interface UsergathDao extends JpaRepository<Usergath, String>, JpaSpecificationExecutor<Usergath> {

}
