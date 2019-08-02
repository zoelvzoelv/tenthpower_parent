package com.tenthpower.dto.article;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "专栏")
public class ColumnVo implements Serializable {

    private static final long serialVersionUID = -6019095292434378823L;

    @ApiModelProperty(value = "主键Id")
    private String id;

    @ApiModelProperty(value = "专栏名称")
    private String name;

    @ApiModelProperty(value = "专栏简介")
    private String summary;

    @ApiModelProperty(value = "用户ID")
    private String userid;

    @ApiModelProperty(value = "申请日期")
    private Date createtime;

    @ApiModelProperty(value = "审核日期")
    private Date checktime;

    @ApiModelProperty(value = "状态")
    private Integer state;

}
