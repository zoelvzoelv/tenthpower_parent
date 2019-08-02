package com.tenthpower.dto.article;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "频道")
public class ChannelVo implements Serializable {

    private static final long serialVersionUID = -6043781909435292823L;

    @ApiModelProperty(value = "主键Id")
    private String id;

    @ApiModelProperty(value = "频道名称")
    private String name;

    @ApiModelProperty(value = "状态")
    private Integer state;

}
