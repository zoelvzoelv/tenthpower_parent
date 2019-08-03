package com.tenthpower.dto.lable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "城市")
public class LabelVo implements Serializable {

    private static final long serialVersionUID = -6019095294378822433L;

    @ApiModelProperty(value = "主键Id")
    private String id;

    @ApiModelProperty(value = "标签名称")
    private String labelname;

    @ApiModelProperty(value = "状态")
    private String state;

    @ApiModelProperty(value = "使用数量")
    private Long count;

    @ApiModelProperty(value = "粉丝数")
    private Long fans;

    @ApiModelProperty(value = "是否推荐")
    private Integer recommend;
}
