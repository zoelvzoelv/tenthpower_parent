package com.tenthpower.dto.recruit;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "职位")
public class RecruitVo implements Serializable {

    private static final long serialVersionUID = -6012929095434378823L;

    @ApiModelProperty(value = "主键Id")
    private String id;

    @ApiModelProperty(value = "职位名称")
    private String jobname;

    @ApiModelProperty(value = "薪资范围")
    private String salary;

    @ApiModelProperty(value = "经验要求")
    private String condition;

    @ApiModelProperty(value = "学历要求")
    private String education;

    @ApiModelProperty(value = "任职方式")
    private String type;

    @ApiModelProperty(value = "办公地址")
    private String address;

    @ApiModelProperty(value = "企业ID")
    private String eid;

    @ApiModelProperty(value = "创建日期")
    private String createtime;

    @ApiModelProperty(value = "状态")
    private Integer state;

    @ApiModelProperty(value = "网址")
    private String url;

    @ApiModelProperty(value = "标签")
    private String label;

    @ApiModelProperty(value = "职位描述")
    private String content1;

    @ApiModelProperty(value = "职位要求")
    private String content2;

}
