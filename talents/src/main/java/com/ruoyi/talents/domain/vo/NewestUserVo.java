package com.ruoyi.talents.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author:lw
 * @description:登陆后拿到当前用户user_id得到最新填报信息状态
 * @Date: 2021/7/8
 */

@Data
public class NewestUserVo {

    @ApiModelProperty(value = "申报状态(0:暂存 1:未审核 2:已审核)")
    private String status;

    @ApiModelProperty(value = "审批结果(0:通过 1:不通过)")
    private String examineStatus;

    @ApiModelProperty(value = "是否移除(0:未移除1:已移除)")
    private String isRemove;

}
