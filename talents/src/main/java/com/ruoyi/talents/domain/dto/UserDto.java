package com.ruoyi.talents.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.talents.domain.UserEducationExperience;
import com.ruoyi.talents.domain.UserOccupational;
import com.ruoyi.talents.domain.UserWorkExperience;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 用户对象 user
 *
 * @author ruoyi
 * @date 2021-06-11
 */
@Data
public class UserDto
{
    private static final long serialVersionUID = 1L;

    /** userId */
    @Excel(name = "userId")
    private String userId;

    /** 用户姓名 */
    @Excel(name = "用户姓名")
    private String userName;

    /** 用户姓名 */
    @Excel(name = "用户姓名")
    private String nickName;

    /** 单位名称 */
    @Excel(name = "单位名称")
    private String companyName;

    /** 单位地区 */
    @Excel(name = "单位地区")
    private String companyRegion;

    /** 单位类型 */
    @Excel(name = "单位类型")
    private String companyType;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String phoneNumber;

    /** 帐号状态 */
    @Excel(name = "帐号状态")
    private String status;





    /** 搜索值 *//*
    private String searchValue;

    *//** 创建者 *//*
    private String createBy;

    *//** 创建时间 *//*
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    *//** 更新者 *//*
    private String updateBy;

    *//** 更新时间 *//*
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    *//** 备注 *//*
    private String remark;*/
}
