package com.tenthpower.service;

import com.tenthpower.dao.GatheringDao;
import com.tenthpower.dto.gathering.GatheringVo;
import com.tenthpower.pojo.Gathering;
import com.tenthpower.util.BeanCopierEx;
import com.tenthpower.util.IdWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GatheringService {

    private final Logger log = LoggerFactory.getLogger(GatheringService.class);

    @Autowired
    private GatheringDao gatheringDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 查询所有的
     */
    public List<GatheringVo> findAll() throws Exception {
        List<GatheringVo> result = new ArrayList<GatheringVo>();
        List<Gathering> sqlResult = gatheringDao.findAll();
        result = BeanCopierEx.copy(sqlResult,GatheringVo.class);
        return result;
    }

    /**
     * 通过id 查询
     */
    @Cacheable(value="gathering",key="#id")
    public GatheringVo findById(String id){
        GatheringVo result = new GatheringVo();
        Gathering sqlResult = gatheringDao.findById(id).get();
        BeanCopierEx.copy(sqlResult,result);
        return result;
    }

    /**
     * 添加
     */
    public void add(GatheringVo gatheringVo){
        Gathering friend = new Gathering();
        BeanCopierEx.copy(gatheringVo, friend);
        friend.setId(idWorker.nextId());//设置ID
        gatheringDao.save(friend);
    }

    /**
     * 更新
     */
    @CacheEvict(value="gathering",key="#gathering.id")
    public void update(GatheringVo gatheringVo){
        Gathering friend = new Gathering();
        BeanCopierEx.copy(gatheringVo, friend);
        gatheringDao.save(friend);
    }

    /**
     * 删除
     */
    @CacheEvict(value="gathering",key="#gathering.id")
    public void deleteById(String id){
        gatheringDao.deleteById(id);
    }
}
