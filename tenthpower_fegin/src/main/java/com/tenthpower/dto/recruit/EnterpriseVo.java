package com.tenthpower.dto.recruit;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "企业")
public class EnterpriseVo implements Serializable {

    private static final long serialVersionUID = -6012929095434378823L;

    @ApiModelProperty(value = "主键Id")
    private String id;

    @ApiModelProperty(value = "企业名称")
    private String name;

    @ApiModelProperty(value = "企业简介")
    private String summary;

    @ApiModelProperty(value = "企业地址")
    private String address;

    @ApiModelProperty(value = "标签列表")
    private String labels;

    @ApiModelProperty(value = "坐标")
    private String coordinate;

    @ApiModelProperty(value = "是否热门")
    private Integer ishot;

    @ApiModelProperty(value = "LOGO")
    private String logo;

    @ApiModelProperty(value = "职位数")
    private Integer jobcount;

    @ApiModelProperty(value = "URL")
    private String url;

}
