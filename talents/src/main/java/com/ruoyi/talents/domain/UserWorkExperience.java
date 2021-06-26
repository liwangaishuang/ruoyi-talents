package com.ruoyi.talents.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
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

    /** 单位地址 */
    @Excel(name = "单位地址")
    private String companySite;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setCompanyName(String companyName) 
    {
        this.companyName = companyName;
    }

    public String getCompanyName() 
    {
        return companyName;
    }
    public void setCompanyType(String companyType) 
    {
        this.companyType = companyType;
    }

    public String getCompanyType() 
    {
        return companyType;
    }
    public void setSecondLevelDepartment(String secondLevelDepartment) 
    {
        this.secondLevelDepartment = secondLevelDepartment;
    }

    public String getSecondLevelDepartment() 
    {
        return secondLevelDepartment;
    }
    public void setPosition(String position) 
    {
        this.position = position;
    }

    public String getPosition() 
    {
        return position;
    }
    public void setWorkingTime(Date workingTime) 
    {
        this.workingTime = workingTime;
    }

    public Date getWorkingTime() 
    {
        return workingTime;
    }
    public void setCompanySite(String companySite) 
    {
        this.companySite = companySite;
    }

    public String getCompanySite() 
    {
        return companySite;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("companyName", getCompanyName())
            .append("companyType", getCompanyType())
            .append("secondLevelDepartment", getSecondLevelDepartment())
            .append("position", getPosition())
            .append("workingTime", getWorkingTime())
            .append("companySite", getCompanySite())
            .toString();
    }
}
