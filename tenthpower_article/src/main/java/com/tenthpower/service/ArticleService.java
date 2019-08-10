package com.tenthpower.service;

import com.tenthpower.constants.VoConstants;
import com.tenthpower.dao.ArticleDao;
import com.tenthpower.dto.article.ArticleVo;
import com.tenthpower.pojo.Article;
import com.tenthpower.util.BeanCopierEx;
import com.tenthpower.util.IdWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class ArticleService {

    private final Logger log = LoggerFactory.getLogger(ArticleService.class);

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 查询所有的文章
     */
    public List<ArticleVo> findAll() throws Exception {
        List<ArticleVo> result = new ArrayList<ArticleVo>();
        List<Article> sqlResult = articleDao.findAll();
        result = BeanCopierEx.copy(sqlResult,ArticleVo.class);
        return result;
    }

    /**
     * 通过id 查询文章
     */
    public ArticleVo findById(String id){
        //从缓存中提取
        ArticleVo result = (ArticleVo) redisTemplate.opsForValue().get("article_"+id);
        log.info("从redis里面获取key=[article_{}]的数据信息=[{}]", id, result);
        // 如果缓存没有则到数据库查询并放入缓存
        if (null == result) {
            Article article = articleDao.findById(id).get();
            result = new ArticleVo();
            BeanCopierEx.copy(article, result);
            redisTemplate.opsForValue().set("article_" + id, result,10, TimeUnit.MINUTES);
            log.info("从redis里面添加key=[article_{}]的数据信息=[{}]", id, result);
        }
        return result;
    }

    /**
     * 添加文章
     */
    public void add(ArticleVo articleVo){
        Article article = new Article();
        String id = idWorker.nextId();
        articleVo.setId(id);
        BeanCopierEx.copy(articleVo, article);
        redisTemplate.opsForValue().set("article_" + id, articleVo, 10, TimeUnit.MINUTES);
        log.info("从redis里面添加key=[article_{}]的数据信息=[{}]", id, articleVo);
        articleDao.save(article);
    }

    /**
     * 更新文章
     */
    public void update(ArticleVo articleVo){
        Article article = new Article();
        BeanCopierEx.copy(articleVo, article);
        articleDao.save(article);
        // 删除缓存
        redisTemplate.opsForValue().set("article_" + articleVo.getId(), articleVo,10, TimeUnit.MINUTES);
        log.info("从redis 里面添加/更新key=[article_{}]的数据信息=[{}]", articleVo.getId(), articleVo);
    }

    /**
     * 删除文章
     */
    public void deleteById(String id){
        articleDao.deleteById(id);
        // 删除缓存
        boolean flag = redisTemplate.delete( "article_" + id );
        log.info("从redis 里面删除key=[article_{}]的数据结果=[{}]", id, flag);
    }

    /**
     * 文章审核
     * @param id
     */
    @Transactional
    public void examine(String id){
        // 文章设置成审核通过
        articleDao.updateState(id, VoConstants.ARTICLE_STATE);
        boolean flag = redisTemplate.delete( "article_" + id );
        log.info("审核通过:从redis 里面删除key=[article_{}]的数据结果=[{}]", id, flag);
    }

    /**
     * 文章点赞
     * @param id
     * @return
     */
    @Transactional
    public int updateThumbup(String id){
        int result = articleDao.updateThumbup(id);
        boolean flag = redisTemplate.delete( "article_" + id );
        log.info("章点赞:从redis 里面删除key=[article_{}]的数据结果=[{}]", id, flag);
        return result;
    }

}
