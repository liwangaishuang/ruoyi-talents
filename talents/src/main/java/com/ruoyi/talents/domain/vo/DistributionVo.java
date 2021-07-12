package com.ruoyi.talents.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author:lw
 * @description:首页 人才/企业区域分布
 * @Date: 2021/7/8
 */

@Data
public class DistributionVo {

    @ApiModelProperty(value = "类型")
    private String type;

    @ApiModelProperty(value = "福田")
    private String ft;

    @ApiModelProperty(value = "罗湖")
    private String lhu;

    @ApiModelProperty(value = "南山")
    private String ns;

    @ApiModelProperty(value = "宝安")
    private String ba;

    @ApiModelProperty(value = "龙华")
    private String lhua;

    @ApiModelProperty(value = "龙岗")
    private String lg;

    @ApiModelProperty(value = "大鹏")
    private String dp;

    @ApiModelProperty(value = "盐田")
    private String yt;

    @ApiModelProperty(value = "坪山")
    private String ps;

    @ApiModelProperty(value = "光明")
    private String gm;

    @ApiModelProperty(value = "深汕")
    private String ss;

    @ApiModelProperty(value = "其他")
    private String qt;

}
