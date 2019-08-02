package com.tenthpower.service;

import com.tenthpower.dao.UsergathDao;
import com.tenthpower.dto.gathering.UsergathVo;
import com.tenthpower.pojo.Usergath;
import com.tenthpower.util.BeanCopierEx;
import com.tenthpower.util.IdWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsergathService {

    private final Logger log = LoggerFactory.getLogger(UsergathService.class);

    @Autowired
    private UsergathDao usergathDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 查询所有的
     */
    public List<UsergathVo> findAll() throws Exception {
        List<UsergathVo> result = new ArrayList<UsergathVo>();
        List<Usergath> sqlResult = usergathDao.findAll();
        result = BeanCopierEx.copy(sqlResult, UsergathVo.class);
        return result;
    }

    /**
     * 通过id 查询
     */
    public UsergathVo findById(String id){
        UsergathVo result = new UsergathVo();
        Usergath sqlResult = usergathDao.findById(id).get();
        BeanCopierEx.copy(sqlResult,result);
        return result;
    }

    /**
     * 添加
     */
    public void add(UsergathVo friendVo){
        Usergath friend = new Usergath();
        BeanCopierEx.copy(friendVo, friend);
        friend.setId(idWorker.nextId());//设置ID
        usergathDao.save(friend);
    }

    /**
     * 更新
     */
    public void update(UsergathVo friendVo){
        Usergath friend = new Usergath();
        BeanCopierEx.copy(friendVo, friend);
        usergathDao.save(friend);
    }

    /**
     * 删除文章
     */
    public void deleteById(String id){
        usergathDao.deleteById(id);
    }
}
