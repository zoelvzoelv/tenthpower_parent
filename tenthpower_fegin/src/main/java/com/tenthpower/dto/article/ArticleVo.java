package com.tenthpower.dto.article;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "文章")
public class ArticleVo implements Serializable {

    private static final long serialVersionUID = -6019095292434378823L;

    @ApiModelProperty(value = "主键Id")
    private String id;

    @ApiModelProperty(value = "专栏ID")
    private String columnid;

    @ApiModelProperty(value = "用户ID")
    private String userid;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "文章正文")
    private String content;

    @ApiModelProperty(value = "文章封面")
    private String image;

    @ApiModelProperty(value = "发表日期")
    private Date createtime;

    @ApiModelProperty(value = "修改日期")
    private Date updatetime;

    @ApiModelProperty(value = "是否公开")
    private Integer ispublic;

    @ApiModelProperty(value = "是否置顶")
    private Integer istop;

    @ApiModelProperty(value = "浏览量")
    private Integer visits;

    @ApiModelProperty(value = "点赞数")
    private Integer thumbup;

    @ApiModelProperty(value = "评论数")
    private Integer comment;

    @ApiModelProperty(value = "审核状态")
    private Integer state;

    @ApiModelProperty(value = "所属频道")
    private String channelid;

    @ApiModelProperty(value = "URL")
    private String url;

    @ApiModelProperty(value = "类型")
    private Integer type;

}
