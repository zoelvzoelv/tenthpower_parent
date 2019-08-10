package com.tenthpower.controller;

import com.tenthpower.dto.qa.ProblemVo;
import com.tenthpower.entity.PageResult;
import com.tenthpower.entity.Result;
import com.tenthpower.entity.StatusCode;
import com.tenthpower.service.ProblemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/problem")
@Api(value="问题", tags = "ProblemController")
public class ProblemController {

    @Autowired
    private ProblemService problemService;

    /**
     * 查询全部
     * @return
     */
    @GetMapping(value="")
    @ApiOperation(value="查询全部")
    public Result findAll() throws Exception {
        return new Result(true, StatusCode.OK,"查询成功",problemService.findAll() );
    }
    /**
     * 根据ID查询
     * @param id
     * @return
     */
    @GetMapping(value="/{id}")
    @ApiOperation(value="根据ID查询")
    public Result findById(@PathVariable String id){
        return new Result(true,StatusCode.OK,"查询成功",problemService.findById(id));
    }
    /**
     * 增加
     * @param
     * @return
     */
    @PostMapping(value="")
    @ApiOperation(value="增加")
    public Result add( @RequestBody ProblemVo problemVo){
        problemService.add(problemVo);
        return new Result(true,StatusCode.OK,"增加成功");
    }
    /**
     * 修改
     * @param
     * @return
     */
    @PutMapping(value="/{id}")
    @ApiOperation(value="修改")
    public Result update( @RequestBody ProblemVo problemVo,@PathVariable String id){
        problemVo.setId(id);
        problemService.update(problemVo);
        return new Result(true,StatusCode.OK,"修改成功");
    }
    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping(value="/{id}")
    @ApiOperation(value="删除")
    public Result deleteById(@PathVariable String id){
        problemService.deleteById(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /**
     * 根据标签ID查询最新问题列表
     * @param labelid
     * @return
     */
    @GetMapping(value="/newlist/{labelid}/{page}/{size}")
    @ApiOperation(value="根据标签ID查询最新问题列表")
    public Result findNewListByLabelId(@PathVariable String labelid,@PathVariable int page,@PathVariable int size) throws Exception {
        Page<ProblemVo> pageList = problemService.findNewListByLabelId(labelid, page, size);
        PageResult<ProblemVo> pageResult = new PageResult<>(pageList.getTotalElements(), pageList.getContent());
        return new Result(true, StatusCode.OK, "查询成功",pageResult);
    }

    /**
     * 根据标签ID查询热门问题列表
     * @param labelId
     * @return
     */
    @GetMapping(value="/hotlist/{labelid}/{page}/{size}")
    @ApiOperation(value="根据标签ID查询热门问题列表")
    public Result findHotListByLabelId(@PathVariable String labelId,@PathVariable int page,@PathVariable int size) throws Exception {
        Page<ProblemVo> pageList =problemService.findHotListByLabelId(labelId, page, size);
        PageResult<ProblemVo> pageResult = new PageResult<>(pageList.getTotalElements(), pageList.getContent());
        return new Result(true, StatusCode.OK, "查询成功",pageResult);
    }

    /**
     * 根据标签ID查询等待回答列表
     * @param labelId
     * @return
     */
    @GetMapping(value="/waitlist/{labelid}/{page}/{size}")
    @ApiOperation(value="根据标签ID查询等待回答列表")
    public Result findWaitListByLabelId(@PathVariable String labelId,@PathVariable int page,@PathVariable int size) throws Exception {
        Page<ProblemVo> pageList = problemService.findWaitListByLabelId(labelId, page, size);
        PageResult<ProblemVo> pageResult = new PageResult<>(pageList.getTotalElements(), pageList.getContent());
        return new Result(true, StatusCode.OK, "查询成功",pageResult);
    }


}
