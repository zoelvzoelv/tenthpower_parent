package com.tenthpower.dao;

import com.tenthpower.pojo.Recruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * JpaRepository提供了基本的增删改查
 * JpaSpecificationExecutor用于做复杂的条件查询
 */
public interface RecruitDao extends JpaRepository<Recruit, String>, JpaSpecificationExecutor<Recruit> {

    /**
     * 查询最新职位列表(按创建日期降序排序): 查询状态为state
     */
    public List<Recruit> findTop4ByStateOrderByCreatetimeDesc(Integer state);

    /**
     * 最新职位列表：查询状态不为0并以创建日期降序排序，查询前12条记录
     * @param state
     * @return
     */
    public List<Recruit> findTop12ByStateNotOrderByCreatetimeDesc(Integer state);

}
