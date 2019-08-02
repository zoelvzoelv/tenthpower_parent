package com.tenthpower.dto.friend;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "好友")
public class FriendVo implements Serializable {

    private static final long serialVersionUID = -2301963437880952924L;

    @ApiModelProperty(value = "主键Id")
    private String id;

    @ApiModelProperty(value = "用户ID")
    private String userid;

    @ApiModelProperty(value = "好友ID")
    private String friendid;

    @ApiModelProperty(value = "是否互相喜欢")
    private Integer islike;

}
