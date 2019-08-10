package com.tenthpower.controller;

import com.tenthpower.dto.lable.LabelVo;
import com.tenthpower.entity.PageResult;
import com.tenthpower.entity.Result;
import com.tenthpower.entity.StatusCode;
import com.tenthpower.pojo.Label;
import com.tenthpower.service.LabelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/label")
@Api(value="标签", tags = "LabelController")
public class LabelController {

    @Autowired
    private LabelService labelService;

    /**
     * 查询全部
     * @return
     */
    @GetMapping(value="")
    @ApiOperation(value="查询全部")
    public Result findAll() throws Exception {
        return new Result(true, StatusCode.OK,"查询成功",labelService.findAll() );
    }
    /**
     * 根据ID查询
     * @param id
     * @return
     */
    @GetMapping(value="/{id}")
    @ApiOperation(value="根据ID查询")
    public Result findById(@PathVariable String id){
        return new Result(true,StatusCode.OK,"查询成功",labelService.findById(id));
    }
    /**
     * 增加
     * @param
     * @return
     */
    @PostMapping(value="")
    @ApiOperation(value="增加")
    public Result add( @RequestBody LabelVo labelVo){
        labelService.add(labelVo);
        return new Result(true,StatusCode.OK,"增加成功");
    }
    /**
     * 修改
     * @param
     * @return
     */
    @PutMapping(value="/{id}")
    @ApiOperation(value="修改")
    public Result update( @RequestBody LabelVo labelVo,@PathVariable String id){
        labelVo.setId(id);
        labelService.update(labelVo);
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
        labelService.deleteById(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /**
     * 根据条件查询
     * @param labelVo
     * @return
     */
    @RequestMapping(value="/search",method = RequestMethod.POST)
    public Result findSearch(@RequestBody LabelVo labelVo){
        return new Result(true,StatusCode.OK,"查询成功",labelService.findSearch(labelVo));
    }

    /**
     * 条件+分页查询
     * @param labelVo
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value="/search/{page}/{size}",method =
            RequestMethod.POST)
    public Result findSearch(@RequestBody LabelVo labelVo,@PathVariable int page, @PathVariable int size){
        Page pageList= labelService.findSearch(labelVo,page,size);
        return new Result(true,StatusCode.OK,"查询成功",new PageResult<>(pageList.getTotalElements(),pageList.getContent()));
    }

}
