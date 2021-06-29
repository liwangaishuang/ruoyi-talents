package com.ruoyi.talents.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户职业资格对象 user_occupational
 * 
 * @author ruoyi
 * @date 2021-06-26
 */
public class UserOccupational
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 用户id */
    @Excel(name = "用户id")
    private String userId;

    /** 类别 */
    @Excel(name = "类别")
    private String category;

    /** 职称名称 */
    @Excel(name = "职称名称")
    private String titleName;

    /** 证书编号 */
    @Excel(name = "证书编号")
    private String titleNumber;

    /** 职称等级 */
    @Excel(name = "职称等级")
    private String titleGrade;

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
    public void setCategory(String category) 
    {
        this.category = category;
    }

    public String getCategory() 
    {
        return category;
    }
    public void setTitleName(String titleName) 
    {
        this.titleName = titleName;
    }

    public String getTitleName() 
    {
        return titleName;
    }
    public void setTitleNumber(String titleNumber) 
    {
        this.titleNumber = titleNumber;
    }

    public String getTitleNumber() 
    {
        return titleNumber;
    }
    public void setTitleGrade(String titleGrade) 
    {
        this.titleGrade = titleGrade;
    }

    public String getTitleGrade() 
    {
        return titleGrade;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("category", getCategory())
            .append("titleName", getTitleName())
            .append("titleNumber", getTitleNumber())
            .append("titleGrade", getTitleGrade())
            .toString();
    }
}
