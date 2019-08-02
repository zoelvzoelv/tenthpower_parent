package com.tenthpower.dto.qa;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "问题")
public class ProblemVo implements Serializable {

    private static final long serialVersionUID = -6012929095434378823L;

    @ApiModelProperty(value = "主键Id")
    private String id;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "创建日期")
    private Date createtime;

    @ApiModelProperty(value = "修改日期")
    private Date updatetime;

    @ApiModelProperty(value = "用户ID")
    private String userid;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "浏览量")
    private Long visits;

    @ApiModelProperty(value = "点赞数")
    private Long thumbup;

    @ApiModelProperty(value = "回复数")
    private Long reply;

    @ApiModelProperty(value = "是否解决")
    private Integer solve;

    @ApiModelProperty(value = "回复人昵称")
    private String replyname;

    @ApiModelProperty(value = "回复日期")
    private Date replytime;

}
