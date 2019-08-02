package com.tenthpower.dao;

import com.tenthpower.pojo.Article;
import com.tenthpower.pojo.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * JpaRepository提供了基本的增删改查
 * JpaSpecificationExecutor用于做复杂的条件查询
 */
public interface ChannelDao extends JpaRepository<Channel, String>, JpaSpecificationExecutor<Channel> {

}
