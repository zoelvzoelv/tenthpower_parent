package com.tenthpower.dto.gathering;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "活动点击记录")
public class UsergathVo implements Serializable {

    private static final long serialVersionUID = -6019095292434378823L;

    @ApiModelProperty(value = "主键Id")
    private String id;

    @ApiModelProperty(value = "用户Id")
    private String userid;

    @ApiModelProperty(value = "活动Id")
    private String gathid;

    @ApiModelProperty(value = "点击时间")
    private Date exetime;

}
