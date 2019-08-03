package com.tenthpower.service;

import com.tenthpower.dao.ChannelDao;
import com.tenthpower.dto.article.ChannelVo;
import com.tenthpower.pojo.Channel;
import com.tenthpower.util.BeanCopierEx;
import com.tenthpower.util.IdWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChannelService {

    private final Logger log = LoggerFactory.getLogger(ChannelService.class);


    @Autowired
    private ChannelDao channelDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 查询所有的
     */
    public List<ChannelVo> findAll() throws Exception  {
        List<ChannelVo> result = new ArrayList<ChannelVo>();
        List<Channel> sqlResult = channelDao.findAll();
        result = BeanCopierEx.copy(sqlResult,ChannelVo.class);
        return result;
    }

    /**
     * 通过id查询
     */
    public ChannelVo findById(String id){
        ChannelVo result = new ChannelVo();
        Channel sqlResult = channelDao.findById(id).get();
        BeanCopierEx.copy(sqlResult, result);
        return result;
    }

    /**
     * 新增
     */
    public void add(ChannelVo channelVo){
        Channel channel = new Channel();
        BeanCopierEx.copy(channelVo, channel);
        channel.setId(idWorker.nextId());//设置ID
        channelDao.save(channel);
    }

    public void update(ChannelVo channelVo){
        Channel channel = new Channel();
        BeanCopierEx.copy(channelVo, channel);
        channelDao.save(channel);
    }

    /**
     * 通过Id删除
     */
    public void deleteById(String id){
        channelDao.deleteById(id);
    }
}
