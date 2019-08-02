package com.tenthpower.dto.gathering;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "活动")
public class GatheringVo implements Serializable {

    private static final long serialVersionUID = -6019095292434378823L;

    @ApiModelProperty(value = "主键Id")
    private String id;

    @ApiModelProperty(value = "活动名称")
    private String name;

    @ApiModelProperty(value = "大会简介")
    private String summary;

    @ApiModelProperty(value = "详细说明")
    private String detail;

    @ApiModelProperty(value = "主办方")
    private String sponsor;

    @ApiModelProperty(value = "活动图片")
    private String image;

    @ApiModelProperty(value = "开始时间")
    private Date starttime;

    @ApiModelProperty(value = "截止时间")
    private Date endtime;

    @ApiModelProperty(value = "举办地点")
    private String address;

    @ApiModelProperty(value = "报名截止")
    private Date enrolltime;

    @ApiModelProperty(value = "是否可见")
    private Integer state;

    @ApiModelProperty(value = "城市")
    private String city;

}
