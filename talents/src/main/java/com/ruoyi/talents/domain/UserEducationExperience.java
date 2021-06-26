package com.ruoyi.talents.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户教育经历对象 user_education_experience
 * 
 * @author ruoyi
 * @date 2021-06-26
 */
public class UserEducationExperience extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 用户id */
    @Excel(name = "用户id")
    private String userId;

    /** 学校名称 */
    @Excel(name = "学校名称")
    private String schoolName;

    /** 学历 */
    @Excel(name = "学历")
    private String education;

    /** 学位 */
    @Excel(name = "学位")
    private String degree;

    /** 专业 */
    @Excel(name = "专业")
    private String major;

    /** 求学时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "求学时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date schoolTime;

    /** 学校地址 */
    @Excel(name = "学校地址")
    private String schoolSite;

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
    public void setSchoolName(String schoolName) 
    {
        this.schoolName = schoolName;
    }

    public String getSchoolName() 
    {
        return schoolName;
    }
    public void setEducation(String education) 
    {
        this.education = education;
    }

    public String getEducation() 
    {
        return education;
    }
    public void setDegree(String degree) 
    {
        this.degree = degree;
    }

    public String getDegree() 
    {
        return degree;
    }
    public void setMajor(String major) 
    {
        this.major = major;
    }

    public String getMajor() 
    {
        return major;
    }
    public void setSchoolTime(Date schoolTime) 
    {
        this.schoolTime = schoolTime;
    }

    public Date getSchoolTime() 
    {
        return schoolTime;
    }
    public void setSchoolSite(String schoolSite) 
    {
        this.schoolSite = schoolSite;
    }

    public String getSchoolSite() 
    {
        return schoolSite;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("schoolName", getSchoolName())
            .append("education", getEducation())
            .append("degree", getDegree())
            .append("major", getMajor())
            .append("schoolTime", getSchoolTime())
            .append("schoolSite", getSchoolSite())
            .toString();
    }
}
