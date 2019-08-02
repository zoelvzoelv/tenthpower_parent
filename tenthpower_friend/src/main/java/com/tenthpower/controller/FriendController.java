package com.tenthpower.controller;

import com.tenthpower.dto.friend.FriendVo;
import com.tenthpower.entity.Result;
import com.tenthpower.entity.StatusCode;
import com.tenthpower.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/friend")
public class FriendController {

    @Autowired
    private FriendService friendService;

    /**
     * 查询全部列表
     * @return
     */
    @RequestMapping(value="/",method = RequestMethod.GET)
    public Result findAll() throws Exception {
        return new Result(true, StatusCode.OK,"查询成功",friendService.findAll() );
    }
    /**
     * 根据ID查询
     * @param id
     * @return
     */
    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public Result findById(@PathVariable String id){
        return new Result(true,StatusCode.OK,"查询成功",friendService.findById(id));
    }
    /**
     * 增加
     * @param
     * @return
     */
    @RequestMapping(value="/",method = RequestMethod.POST)
    public Result add( @RequestBody FriendVo friendVo){
        friendService.add(friendVo);
        return new Result(true,StatusCode.OK,"增加成功");
    }
    /**
     * 修改
     * @param
     * @return
     */
    @RequestMapping(value="/{id}" ,method = RequestMethod.PUT)
    public Result update(@RequestBody FriendVo friendVo, @PathVariable String
            id){
        friendVo.setId(id);
        friendService.update(friendVo);
        return new Result(true,StatusCode.OK,"修改成功");
    }
    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping(value="/{id}" ,method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable String id){
        friendService.deleteById(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }
}
