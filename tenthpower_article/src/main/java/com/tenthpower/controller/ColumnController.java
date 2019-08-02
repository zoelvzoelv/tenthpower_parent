package com.tenthpower.controller;

import com.tenthpower.dto.article.ChannelVo;
import com.tenthpower.dto.article.ColumnVo;
import com.tenthpower.entity.Result;
import com.tenthpower.entity.StatusCode;
import com.tenthpower.service.ChannelService;
import com.tenthpower.service.ColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/column")
public class ColumnController {

    @Autowired
    private ColumnService columnService;

    /**
     * 查询全部列表
     * @return
     */
    @RequestMapping(value="/",method = RequestMethod.GET)
    public Result findAll() throws Exception {
        return new Result(true, StatusCode.OK,"查询成功",columnService.findAll() );
    }
    /**
     * 根据ID查询
     * @param id
     * @return
     */
    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public Result findById(@PathVariable String id){
        return new Result(true,StatusCode.OK,"查询成功",columnService.findById(id));
    }
    /**
     * 增加
     * @param
     * @return
     */
    @RequestMapping(value="/",method = RequestMethod.POST)
    public Result add( @RequestBody ColumnVo columnVo){
        columnService.add(columnVo);
        return new Result(true,StatusCode.OK,"增加成功");
    }
    /**
     * 修改
     * @param
     * @return
     */
    @RequestMapping(value="/{id}" ,method = RequestMethod.PUT)
    public Result update(@RequestBody ColumnVo columnVo, @PathVariable String
            id){
        columnVo.setId(id);
        columnService.update(columnVo);
        return new Result(true,StatusCode.OK,"修改成功");
    }
    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping(value="/{id}" ,method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable String id){
        columnService.deleteById(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }
}
