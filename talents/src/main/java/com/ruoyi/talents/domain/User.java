package com.ruoyi.talents.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * 用户对象 user
 *
 * @author ruoyi
 * @date 2021-06-11
 */
@Data
public class User extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 用户表id */
    @Excel(name = "用户表id")
    private String userId;

    /** 用户姓名 */
    @Excel(name = "用户姓名")
    private String userName;

    /** 头像 */
    @Excel(name = "头像")
    private String portrait;

    /** 登陆密码 */
    @Excel(name = "登陆密码")
    private String password;

    /** 证件类型 */
    @Excel(name = "证件类型")
    private String idNumberType;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String userIdNumber;

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

    /** 性别(1:男2:女) */
    @Excel(name = "性别(1:男2:女)")
    private String userSex;

    /** 国籍 */
    @Excel(name = "国籍")
    private String nationality;

    /** 民族 */
    @Excel(name = "民族")
    private String nation;

    /** 邮政编码 */
    @Excel(name = "邮政编码")
    private String postalCode;

    /** 政治面貌 */
    @Excel(name = "政治面貌")
    private String politicsStatus;

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

    /** 单位地区 */
    @Excel(name = "单位地区")
    private String companyRegion;

    /** 统一社会信用代码 */
    @Excel(name = "统一社会信用代码")
    private String creditCode;

    /** 二级部门 */
    @Excel(name = "二级部门")
    private String secondLevelDepartment;

    /** 职务 */
    @Excel(name = "职务")
    private String position;

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

    /** 学位所学专业 */
    @Excel(name = "学位所学专业")
    private String majorAcademy;

    /** 是否两院院士 */
    @Excel(name = "是否两院院士")
    private String isAcademician;

    /** 是否博士生导师 */
    @Excel(name = "是否博士生导师")
    private String isDoctoralSupervisor;

    /** 熟悉外语语种 */
    @Excel(name = "熟悉外语语种")
    private String language;

    /** 熟悉程度 */
    @Excel(name = "熟悉程度")
    private String degree;

    /** 入库标准 */
    @Excel(name = "入库标准")
    private String standard;

    /** 参与评审/公共服务经历 */
    @Excel(name = "参与评审/公共服务经历")
    private String reviewExperience;

    /** 主要行业领域 */
    @Excel(name = "主要行业领域")
    private String mainIndustry;

    /** 其他行业领域 */
    @Excel(name = "其他行业领域")
    private String elseIndustry;

    /** 基金学科 */
    @Excel(name = "基金学科")
    private String fundSubject;

    /** 国际学科 */
    @Excel(name = "国际学科")
    private String internationalDiscipline;

    /** 教育学科 */
    @Excel(name = "教育学科")
    private String educationSubject;

    /** 工业行业 */
    @Excel(name = "工业行业")
    private String industries;

    /** 研究方向或关键词 */
    @Excel(name = "研究方向或关键词")
    private String researchDirection;

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

    /** 申报状态(0:暂存 1:未审核 2:已审核 3:已删除) */
    @Excel(name = "申报状态(0:暂存 1:未审核 2:已审核 3:已删除)")
    private String status;

    /** 用户教育经历对象 */
    @Excel(name = "用户教育经历对象")
    private UserEducationExperience experience;

    /** 用户职业资格对象 */
    @Excel(name = "用户职业资格对象")
    private UserOccupational occupational;

    /** 用户工作经历对象 */
    @Excel(name = "用户工作经历对象")
    private UserWorkExperience workExperience;
}
