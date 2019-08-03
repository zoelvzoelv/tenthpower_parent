package com.tenthpower.service;

import com.tenthpower.dao.ProblemDao;
import com.tenthpower.dto.qa.ProblemVo;
import com.tenthpower.pojo.Problem;
import com.tenthpower.util.BeanCopierEx;
import com.tenthpower.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProblemService {

    @Autowired
    private ProblemDao problemDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 查询所有的
     */
    public List<ProblemVo> findAll() throws Exception {
        List<ProblemVo> result = new ArrayList<ProblemVo>();
        List<Problem> sqlResult = problemDao.findAll();
        result = BeanCopierEx.copy(sqlResult,ProblemVo.class);
        return result;
    }

    /**
     * 通过id 查询
     */
    public ProblemVo findById(String id){
        ProblemVo result = new ProblemVo();
        Problem sqlResult = problemDao.findById(id).get();
        BeanCopierEx.copy(sqlResult,result);
        return result;
    }

    /**
     * 添加
     */
    public void add(ProblemVo problemVo){
        Problem problem = new Problem();
        BeanCopierEx.copy(problemVo, problem);
        problem.setId(idWorker.nextId());//设置ID
        problemDao.save(problem);
    }

    /**
     * 更新
     */
    public void update(ProblemVo problemVo){
        Problem problem = new Problem();
        BeanCopierEx.copy(problemVo, problem);
        problemDao.save(problem);
    }

    /**
     * 删除
     */
    public void deleteById(String id){
        problemDao.deleteById(id);
    }
}
