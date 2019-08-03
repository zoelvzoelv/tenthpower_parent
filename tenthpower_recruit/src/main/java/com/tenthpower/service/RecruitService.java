package com.tenthpower.service;

import com.tenthpower.dao.RecruitDao;
import com.tenthpower.dto.recruit.RecruitVo;
import com.tenthpower.pojo.Recruit;
import com.tenthpower.util.BeanCopierEx;
import com.tenthpower.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecruitService {

    @Autowired
    private RecruitDao recruitDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 查询所有的
     */
    public List<RecruitVo> findAll() throws Exception {
        List<RecruitVo> result = new ArrayList<RecruitVo>();
        List<Recruit> sqlResult = recruitDao.findAll();
        result = BeanCopierEx.copy(sqlResult,RecruitVo.class);
        return result;
    }

    /**
     * 通过id 查询
     */
    public RecruitVo findById(String id){
        RecruitVo result = new RecruitVo();
        Recruit sqlResult = recruitDao.findById(id).get();
        BeanCopierEx.copy(sqlResult,result);
        return result;
    }

    /**
     * 添加
     */
    public void add(RecruitVo recruitVo){
        Recruit recruit = new Recruit();
        BeanCopierEx.copy(recruitVo, recruit);
        recruit.setId(idWorker.nextId());//设置ID
        recruitDao.save(recruit);
    }

    /**
     * 更新
     */
    public void update(RecruitVo recruitVo){
        Recruit recruit = new Recruit();
        BeanCopierEx.copy(recruitVo, recruit);
        recruitDao.save(recruit);
    }

    /**
     * 删除
     */
    public void deleteById(String id){
        recruitDao.deleteById(id);
    }
}
