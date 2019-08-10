package com.tenthpower.dao;

import com.tenthpower.pojo.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * JpaRepository提供了基本的增删改查
 * JpaSpecificationExecutor用于做复杂的条件查询
 */
public interface ArticleDao extends JpaRepository<Article, String>, JpaSpecificationExecutor<Article> {

    /**
     * 审核/下架
     */
    @Modifying
    @Query("update Article set state= :state where id= :id")
    public void updateState(@Param("id") String id, @Param("state") Integer state);

    /**
     * 点赞
     */
    @Modifying
    @Query("update Article a set thumbup = thumbup + 1 where id= :id")
    public int updateThumbup(@Param("id") String id);

}
