package com.tenthpower.dto.lable;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "城市")
public class CityVo implements Serializable {

    private static final long serialVersionUID = -6292190954343078823L;

    @ApiModelProperty(value = "主键Id")
    private String id;

    @ApiModelProperty(value = "城市名称")
    private String name;

    @ApiModelProperty(value = "是否热门")
    private Integer ishot;

}
