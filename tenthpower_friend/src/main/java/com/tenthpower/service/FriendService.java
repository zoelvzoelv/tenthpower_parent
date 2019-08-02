package com.tenthpower.service;

import com.tenthpower.dao.FriendDao;
import com.tenthpower.dto.article.ArticleVo;
import com.tenthpower.dto.friend.FriendVo;
import com.tenthpower.pojo.Friend;
import com.tenthpower.util.BeanCopierEx;
import com.tenthpower.util.IdWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FriendService {

    private final Logger log = LoggerFactory.getLogger(FriendService.class);

    @Autowired
    private FriendDao friendDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 查询所有的
     */
    public List<FriendVo> findAll() throws Exception {
        List<FriendVo> result = new ArrayList<FriendVo>();
        List<Friend> sqlResult = friendDao.findAll();
        result = BeanCopierEx.copy(sqlResult,FriendVo.class);
        return result;
    }

    /**
     * 通过id 查询
     */
    public FriendVo findById(String id){
        FriendVo result = new FriendVo();
        Friend sqlResult = friendDao.findById(id).get();
        BeanCopierEx.copy(sqlResult,result);
        return result;
    }

    /**
     * 添加
     */
    public void add(FriendVo friendVo){
        Friend friend = new Friend();
        BeanCopierEx.copy(friendVo, friend);
        friend.setId(idWorker.nextId());//设置ID
        friendDao.save(friend);
    }

    /**
     * 更新
     */
    public void update(FriendVo friendVo){
        Friend friend = new Friend();
        BeanCopierEx.copy(friendVo, friend);
        friendDao.save(friend);
    }

    /**
     * 删除文章
     */
    public void deleteById(String id){
        friendDao.deleteById(id);
    }
}
