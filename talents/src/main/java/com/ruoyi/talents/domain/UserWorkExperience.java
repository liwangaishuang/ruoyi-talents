package com.ruoyi.talents.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户工作经历对象 user_work_experience
 * 
 * @author ruoyi
 * @date 2021-06-26
 */
@Data
public class UserWorkExperience extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 用户id */
    @Excel(name = "用户id")
    private String userId;

    /** 单位名称 */
    @Excel(name = "单位名称")
    private String companyName;

    /** 单位类型 */
    @Excel(name = "单位类型")
    private String companyType;

    /** 二级部门 */
    @Excel(name = "二级部门")
    private String secondLevelDepartment;

    /** 职务 */
    @Excel(name = "职务")
    private String position;

    /** 在职时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "在职时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date workingTime;

    /** 在职时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "在职结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endWorkingTime;

    /** 单位地址 */
    @Excel(name = "单位地址")
    private String companySite;

}
