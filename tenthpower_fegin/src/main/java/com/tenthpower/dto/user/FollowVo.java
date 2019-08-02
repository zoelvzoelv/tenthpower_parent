package com.tenthpower.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "关注")
public class FollowVo implements Serializable {

    private static final long serialVersionUID = -6012929095434378823L;

    @ApiModelProperty(value = "主键Id")
    private String id;

    @ApiModelProperty(value = "用户ID")
    private String userid;

    @ApiModelProperty(value = "被关注用户ID")
    private String targetuser;

}
