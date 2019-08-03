package com.tenthpower.service;

import com.tenthpower.dao.EnterpriseDao;
import com.tenthpower.dto.recruit.EnterpriseVo;
import com.tenthpower.pojo.Enterprise;
import com.tenthpower.util.BeanCopierEx;
import com.tenthpower.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnterpriseService {

    @Autowired
    private EnterpriseDao enterpriseDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 查询所有的
     */
    public List<EnterpriseVo> findAll() throws Exception {
        List<EnterpriseVo> result = new ArrayList<EnterpriseVo>();
        List<Enterprise> sqlResult = enterpriseDao.findAll();
        result = BeanCopierEx.copy(sqlResult,EnterpriseVo.class);
        return result;
    }

    /**
     * 通过id 查询
     */
    public EnterpriseVo findById(String id){
        EnterpriseVo result = new EnterpriseVo();
        Enterprise sqlResult = enterpriseDao.findById(id).get();
        BeanCopierEx.copy(sqlResult,result);
        return result;
    }

    /**
     * 添加
     */
    public void add(EnterpriseVo enterpriseVo){
        Enterprise enterprise = new Enterprise();
        BeanCopierEx.copy(enterpriseVo, enterprise);
        enterprise.setId(idWorker.nextId());//设置ID
        enterpriseDao.save(enterprise);
    }

    /**
     * 更新
     */
    public void update(EnterpriseVo enterpriseVo){
        Enterprise enterprise = new Enterprise();
        BeanCopierEx.copy(enterpriseVo, enterprise);
        enterpriseDao.save(enterprise);
    }

    /**
     * 删除
     */
    public void deleteById(String id){
        enterpriseDao.deleteById(id);
    }
}
