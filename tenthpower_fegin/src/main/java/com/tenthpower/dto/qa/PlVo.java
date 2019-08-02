package com.tenthpower.dto.qa;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "问题标签")
public class PlVo implements Serializable {

    private static final long serialVersionUID = -6012929095434378823L;

    @ApiModelProperty(value = "主键Id")
    private String id;

    @ApiModelProperty(value = "问题Id")
    private String problemid;

    @ApiModelProperty(value = "标签Id")
    private Integer labelid;

}
