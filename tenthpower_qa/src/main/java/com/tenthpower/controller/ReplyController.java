package com.tenthpower.controller;

import com.tenthpower.dto.qa.ReplyVo;
import com.tenthpower.entity.Result;
import com.tenthpower.entity.StatusCode;
import com.tenthpower.service.ReplyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reply")
@Api(value="问题回答", tags = "ReplyController")
public class ReplyController {

    @Autowired
    private ReplyService replyService;

    /**
     * 查询全部
     * @return
     */
    @GetMapping(value="")
    @ApiOperation(value="查询全部")
    public Result findAll() throws Exception {
        return new Result(true, StatusCode.OK,"查询成功",replyService.findAll() );
    }
    /**
     * 根据ID查询
     * @param id
     * @return
     */
    @GetMapping(value="/{id}")
    @ApiOperation(value="根据ID查询")
    public Result findById(@PathVariable String id){
        return new Result(true,StatusCode.OK,"查询成功",replyService.findById(id));
    }
    /**
     * 增加
     * @param
     * @return
     */
    @PostMapping(value="")
    @ApiOperation(value="增加")
    public Result add( @RequestBody ReplyVo replyVo){
        replyService.add(replyVo);
        return new Result(true,StatusCode.OK,"增加成功");
    }
    /**
     * 修改
     * @param
     * @return
     */
    @PutMapping(value="/{id}")
    @ApiOperation(value="修改")
    public Result update( @RequestBody ReplyVo replyVo,@PathVariable String id){
        replyVo.setId(id);
        replyService.update(replyVo);
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
        replyService.deleteById(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }
}
