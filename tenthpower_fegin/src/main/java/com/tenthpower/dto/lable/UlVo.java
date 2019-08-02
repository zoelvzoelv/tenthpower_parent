package com.tenthpower.dto.lable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "用户标签")
public class UlVo implements Serializable {

    private static final long serialVersionUID = -6019095292434378823L;

    @ApiModelProperty(value = "主键Id")
    private String id;

    @ApiModelProperty(value = "用户Id")
    private String userid;

    @ApiModelProperty(value = "标签Id")
    private Integer labelid;

}
