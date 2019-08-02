package com.tenthpower.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "登陆账号")
public class AdminVo implements Serializable {

    private static final long serialVersionUID = -6012929095434378823L;

    @ApiModelProperty(value = "主键Id")
    private String id;

    @ApiModelProperty(value = "登陆名称")
    private String loginname;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "状态")
    private String state;

}
