package com.ruoyi.talents.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
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

@Data
public class UserEducationExperience
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

    /** 求学结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "求学结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endSchoolTime;

    /** 学校地址 */
    @Excel(name = "学校地址")
    private String schoolSite;
}
