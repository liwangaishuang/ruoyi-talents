package com.ruoyi.talents.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import lombok.Data;

import java.util.Date;

/**
 * 用户对象 user
 * 
 * @author ruoyi
 * @date 2021-06-07
 */
@Data
public class User{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private String id;

    /** 用户姓名 */
    @Excel(name = "用户姓名")
    private String userName;

    /** 登陆密码 */
    @Excel(name = "登陆密码")
    private String password;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String userIdNumber;

    /** 性别(1:男2:女) */
    @Excel(name = "性别(1:男2:女)")
    private String userSex;

    /** 出生日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出生日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date birthDate;

    /** 年龄 */
    @Excel(name = "年龄")
    private String age;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String phoneNumber;

    /** 邮箱地址 */
    @Excel(name = "邮箱地址")
    private String email;

    /** 办公电话 */
    @Excel(name = "办公电话")
    private String officePhone;

    /** 家庭电话 */
    @Excel(name = "家庭电话")
    private String homeTelephone;

    /** 国籍 */
    @Excel(name = "国籍")
    private String nationality;

    /** 民族 */
    @Excel(name = "民族")
    private String nation;

    /** 政治面貌 */
    @Excel(name = "政治面貌")
    private String politicsStatus;

    /** 邮政编码 */
    @Excel(name = "邮政编码")
    private String postalCode;

    /** 职称 */
    @Excel(name = "职称")
    private String professional;

    /** 居住地区 */
    @Excel(name = "居住地区")
    private String dwellRegion;

    /** 居住地址 */
    @Excel(name = "居住地址")
    private String dwellSite;

    /** 专业类别 */
    @Excel(name = "专业类别")
    private String specialtyType;

    /** 工作性质 */
    @Excel(name = "工作性质")
    private String jobNature;

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

    /** 单位地区 */
    @Excel(name = "单位地区")
    private String companyRegion;

    /** 单位地址 */
    @Excel(name = "单位地址")
    private String companySite;

    /** 最高学历 */
    @Excel(name = "最高学历")
    private String highestEducation;

    /** 毕业院校 */
    @Excel(name = "毕业院校")
    private String graduateAcademy;

    /** 学历所学专业 */
    @Excel(name = "学历所学专业")
    private String major;

    /** 最高学位 */
    @Excel(name = "最高学位")
    private String highestDegree;

    /** 授予院校 */
    @Excel(name = "授予院校")
    private String awardAcademy;

    /** 是否两院院士 */
    @Excel(name = "是否两院院士")
    private String isAcademician;

    /** 是否博士生导师 */
    @Excel(name = "是否博士生导师")
    private String isDoctoralSupervisor;

    /** 熟悉外语语种 */
    @Excel(name = "熟悉外语语种")
    private String language;

    /** 学位所学专业 */
    @Excel(name = "学位所学专业")
    private String majorAcademy;

    /** 熟悉程度 */
    @Excel(name = "熟悉程度")
    private String degree;

    /** 主要行业领域 */
    @Excel(name = "主要行业领域")
    private String mainIndustry;

    /** 其他行业领域 */
    @Excel(name = "其他行业领域")
    private String elseIndustry;

    /** 研究或工作内容 */
    @Excel(name = "研究或工作内容")
    private String workContent;

    /** 主要业绩及贡献 */
    @Excel(name = "主要业绩及贡献")
    private String mainContribution;

    /** 奖惩情况 */
    @Excel(name = "奖惩情况")
    private String rewardsPunishment;

    /** 参与评审需回避单位 */
    @Excel(name = "参与评审需回避单位")
    private String avoidCompany;

    /** 成果或专利 */
    @Excel(name = "成果或专利")
    private String resultsOrPatents;

    /** 荣誉或头衔 */
    @Excel(name = "荣誉或头衔")
    private String honorsOrTitles;

    /** 简历地址 */
    @Excel(name = "简历地址")
    private String resumeSite;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createTime;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updateTime;


}
