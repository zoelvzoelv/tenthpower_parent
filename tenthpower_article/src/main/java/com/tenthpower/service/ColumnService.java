package com.tenthpower.service;

import com.tenthpower.dao.ColumnDao;
import com.tenthpower.dto.article.ColumnVo;
import com.tenthpower.pojo.Column;
import com.tenthpower.util.BeanCopierEx;
import com.tenthpower.util.IdWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ColumnService {

    private final Logger log = LoggerFactory.getLogger(ColumnService.class);

    @Autowired
    private ColumnDao columnDao;

    @Autowired
    private IdWorker idWorker;


    public List<ColumnVo> findAll() throws Exception {
        List<ColumnVo> result = new ArrayList<ColumnVo>();
        List<Column> sqlResult = columnDao.findAll();
        result = BeanCopierEx.copy(sqlResult,ColumnVo.class);
        return result;
    }


    public ColumnVo findById(String id){
        ColumnVo result = new ColumnVo();
        Column sqlResult = columnDao.findById(id).get();
        BeanCopierEx.copy(sqlResult,result);
        return result;
    }


    public void add(ColumnVo columnVo){
        Column column = new Column();
        BeanCopierEx.copy(columnVo, column);
        column.setId(idWorker.nextId());//设置ID
        columnDao.save(column);
    }

    public void update(ColumnVo columnVo){
        Column column = new Column();
        BeanCopierEx.copy(columnVo, column);
        columnDao.save(column);
    }


    public void deleteById(String id){
        columnDao.deleteById(id);
    }
}
