package com.tenthpower.service;

import com.tenthpower.dao.CityDao;
import com.tenthpower.dto.lable.CityVo;
import com.tenthpower.pojo.City;
import com.tenthpower.util.BeanCopierEx;
import com.tenthpower.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityDao cityDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 查询所有的
     */
    public List<CityVo> findAll() throws Exception {
        List<CityVo> result = new ArrayList<CityVo>();
        List<City> sqlResult = cityDao.findAll();
        result = BeanCopierEx.copy(sqlResult,CityVo.class);
        return result;
    }

    /**
     * 通过id 查询
     */
    public CityVo findById(String id){
        CityVo result = new CityVo();
        City sqlResult = cityDao.findById(id).get();
        BeanCopierEx.copy(sqlResult,result);
        return result;
    }

    /**
     * 添加
     */
    public void add(CityVo cityVo){
        City city = new City();
        BeanCopierEx.copy(cityVo, city);
        city.setId(idWorker.nextId());//设置ID
        cityDao.save(city);
    }

    /**
     * 更新
     */
    public void update(CityVo cityVo){
        City city = new City();
        BeanCopierEx.copy(cityVo, city);
        cityDao.save(city);
    }

    /**
     * 删除
     */
    public void deleteById(String id){
        cityDao.deleteById(id);
    }
}
