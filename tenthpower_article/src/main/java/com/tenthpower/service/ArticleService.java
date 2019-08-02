package com.tenthpower.service;

import com.tenthpower.dao.ArticleDao;
import com.tenthpower.dto.article.ArticleVo;
import com.tenthpower.pojo.Article;
import com.tenthpower.util.BeanCopierEx;
import com.tenthpower.util.IdWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {

    private final Logger log = LoggerFactory.getLogger(ArticleService.class);

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private IdWorker idWorker;

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
        ArticleVo result = new ArticleVo();
        Article sqlResult = articleDao.findById(id).get();
        BeanCopierEx.copy(sqlResult,result);
        return result;
    }

    /**
     * 添加文章
     */
    public void add(ArticleVo articleVo){
        Article article = new Article();
        BeanCopierEx.copy(articleVo, article);
        article.setId(idWorker.nextId());//设置ID
        articleDao.save(article);
    }

    /**
     * 更新文章
     */
    public void update(ArticleVo articleVo){
        Article article = new Article();
        BeanCopierEx.copy(articleVo, article);
        articleDao.save(article);
    }

    /**
     * 删除文章
     */
    public void deleteById(String id){
        articleDao.deleteById(id);
    }
}
