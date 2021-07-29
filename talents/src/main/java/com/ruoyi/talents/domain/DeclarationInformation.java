package com.ruoyi.talents.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 申报信息对象 declaration_information
 * 
 * @author ruoyi
 * @date 2021-07-19
 */



@Data
public class DeclarationInformation {
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 用户id */
    @Excel(name = "用户id")
    private String userId;

    /** 申报id */
    @Excel(name = "申报id")
    private String declarationId;

    /** 操作人 */
    @Excel(name = "操作人")
    private String operator;

    /** 操作内容 */
    @Excel(name = "操作内容")
    private String operationalContext;

    /** 申报状态 */
    @Excel(name = "申报状态")
    private String applicationStatus;

    /** 备注 */
    @Excel(name = "备注")
    private String remark;

    /** 是否审核通过(0:通过 1:不通过) */
    @Excel(name = "是否审核通过(0:通过 1:不通过)")
    private String isPass;

    /** 是否移除*/
    @Excel(name = "是否移除(0:未移除1:已移除)")
    private String isRemove;

    /** 创建时间 */
    @Excel(name = "创建时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
}
