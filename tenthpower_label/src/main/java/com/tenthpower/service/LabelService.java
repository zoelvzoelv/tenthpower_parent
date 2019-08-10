package com.tenthpower.service;

import com.tenthpower.dao.LabelDao;
import com.tenthpower.dto.lable.LabelVo;
import com.tenthpower.pojo.Label;
import com.tenthpower.util.BeanCopierEx;
import com.tenthpower.util.IdWorker;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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

    /**
     * 搜索
     */
    public List<LabelVo> findSearch(LabelVo labelVo){
        Specification specification= createSpecification(labelVo);
        return labelDao.findAll(specification);
    }

    /**
     * 分页加搜索
     */
    public Page<LabelVo> findSearch(LabelVo labelVo, int page, int size){
        Specification specification= createSpecification(labelVo);
        PageRequest pageRequest = PageRequest.of(page-1,size);
        return labelDao.findAll(specification ,pageRequest);
    }

    /**
     * 构建查询条件
     * @param labelVo
     * @return
     */
    private Specification<Label> createSpecification(LabelVo labelVo){
        return new Specification<Label>() {
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?>
                    criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicateList=new ArrayList<>();
                if (StringUtils.isNotBlank(labelVo.getLabelname())) {
                    predicateList.add(cb.like(root.get("labelname").as(String.class),"%"+labelVo.getLabelname()+"%"));
                }
                if(labelVo.getState() != null){
                    predicateList.add(cb.equal(root.get("state").as(Integer.class),labelVo.getState()));
                }
                if(labelVo.getState() != null){
                    predicateList.add(cb.equal(root.get("state").as(Integer.class),labelVo.getState()));
                }
                if(labelVo.getRecommend() != null){
                    predicateList.add(cb.equal(root.get("recommend").as(Integer.class),labelVo.getRecommend()));
                }
                return cb.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        };
    }

}
