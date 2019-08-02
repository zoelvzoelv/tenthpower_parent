package com.tenthpower.service;

import com.tenthpower.dao.LabelDao;
import com.tenthpower.dto.lable.CityVo;
import com.tenthpower.dto.lable.LabelVo;
import com.tenthpower.pojo.City;
import com.tenthpower.pojo.Label;
import com.tenthpower.util.BeanCopierEx;
import com.tenthpower.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LabelService {

    @Autowired
    private LabelDao labelDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 查询所有的
     */
    public List<LabelVo> findAll() throws Exception {
        List<LabelVo> result = new ArrayList<LabelVo>();
        List<Label> sqlResult = labelDao.findAll();
        result = BeanCopierEx.copy(sqlResult,LabelVo.class);
        return result;
    }

    /**
     * 通过id 查询
     */
    public LabelVo findById(String id){
        LabelVo result = new LabelVo();
        Label sqlResult = labelDao.findById(id).get();
        BeanCopierEx.copy(sqlResult,result);
        return result;
    }

    /**
     * 添加
     */
    public void add(LabelVo labelVo){
        Label label = new Label();
        BeanCopierEx.copy(labelVo, label);
        label.setId(idWorker.nextId());//设置ID
        labelDao.save(label);
    }

    /**
     * 更新
     */
    public void update(LabelVo labelVo){
        Label label = new Label();
        BeanCopierEx.copy(labelVo, label);
        labelDao.save(label);
    }

    /**
     * 删除
     */
    public void deleteById(String id){
        labelDao.deleteById(id);
    }
}
