package com.ruoyi.talents.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户对象 user
 *
 * @author ruoyi
 * @date 2021-06-11
 */
public class User extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private int id;

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

    public void setId(int id)
    {
        this.id = id;
    }

    public int getId()
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
    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserName()
    {
        return userName;
    }
    public void setPortrait(String portrait)
    {
        this.portrait = portrait;
    }

    public String getPortrait()
    {
        return portrait;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPassword()
    {
        return password;
    }
    public void setIdNumberType(String idNumberType)
    {
        this.idNumberType = idNumberType;
    }

    public String getIdNumberType()
    {
        return idNumberType;
    }
    public void setUserIdNumber(String userIdNumber)
    {
        this.userIdNumber = userIdNumber;
    }

    public String getUserIdNumber()
    {
        return userIdNumber;
    }
    public void setBirthDate(Date birthDate)
    {
        this.birthDate = birthDate;
    }

    public Date getBirthDate()
    {
        return birthDate;
    }
    public void setAge(String age)
    {
        this.age = age;
    }

    public String getAge()
    {
        return age;
    }
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return email;
    }
    public void setOfficePhone(String officePhone)
    {
        this.officePhone = officePhone;
    }

    public String getOfficePhone()
    {
        return officePhone;
    }
    public void setHomeTelephone(String homeTelephone)
    {
        this.homeTelephone = homeTelephone;
    }

    public String getHomeTelephone()
    {
        return homeTelephone;
    }
    public void setUserSex(String userSex)
    {
        this.userSex = userSex;
    }

    public String getUserSex()
    {
        return userSex;
    }
    public void setNationality(String nationality)
    {
        this.nationality = nationality;
    }

    public String getNationality()
    {
        return nationality;
    }
    public void setNation(String nation)
    {
        this.nation = nation;
    }

    public String getNation()
    {
        return nation;
    }
    public void setPostalCode(String postalCode)
    {
        this.postalCode = postalCode;
    }

    public String getPostalCode()
    {
        return postalCode;
    }
    public void setPoliticsStatus(String politicsStatus)
    {
        this.politicsStatus = politicsStatus;
    }

    public String getPoliticsStatus()
    {
        return politicsStatus;
    }
    public void setProfessional(String professional)
    {
        this.professional = professional;
    }

    public String getProfessional()
    {
        return professional;
    }
    public void setDwellRegion(String dwellRegion)
    {
        this.dwellRegion = dwellRegion;
    }

    public String getDwellRegion()
    {
        return dwellRegion;
    }
    public void setDwellSite(String dwellSite)
    {
        this.dwellSite = dwellSite;
    }

    public String getDwellSite()
    {
        return dwellSite;
    }
    public void setSpecialtyType(String specialtyType)
    {
        this.specialtyType = specialtyType;
    }

    public String getSpecialtyType()
    {
        return specialtyType;
    }
    public void setJobNature(String jobNature)
    {
        this.jobNature = jobNature;
    }

    public String getJobNature()
    {
        return jobNature;
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
    public void setCompanyRegion(String companyRegion)
    {
        this.companyRegion = companyRegion;
    }

    public String getCompanyRegion()
    {
        return companyRegion;
    }
    public void setCreditCode(String creditCode)
    {
        this.creditCode = creditCode;
    }

    public String getCreditCode()
    {
        return creditCode;
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
    public void setCompanySite(String companySite)
    {
        this.companySite = companySite;
    }

    public String getCompanySite()
    {
        return companySite;
    }
    public void setHighestEducation(String highestEducation)
    {
        this.highestEducation = highestEducation;
    }

    public String getHighestEducation()
    {
        return highestEducation;
    }
    public void setGraduateAcademy(String graduateAcademy)
    {
        this.graduateAcademy = graduateAcademy;
    }

    public String getGraduateAcademy()
    {
        return graduateAcademy;
    }
    public void setMajor(String major)
    {
        this.major = major;
    }

    public String getMajor()
    {
        return major;
    }
    public void setHighestDegree(String highestDegree)
    {
        this.highestDegree = highestDegree;
    }

    public String getHighestDegree()
    {
        return highestDegree;
    }
    public void setAwardAcademy(String awardAcademy)
    {
        this.awardAcademy = awardAcademy;
    }

    public String getAwardAcademy()
    {
        return awardAcademy;
    }
    public void setMajorAcademy(String majorAcademy)
    {
        this.majorAcademy = majorAcademy;
    }

    public String getMajorAcademy()
    {
        return majorAcademy;
    }
    public void setIsAcademician(String isAcademician)
    {
        this.isAcademician = isAcademician;
    }

    public String getIsAcademician()
    {
        return isAcademician;
    }
    public void setIsDoctoralSupervisor(String isDoctoralSupervisor)
    {
        this.isDoctoralSupervisor = isDoctoralSupervisor;
    }

    public String getIsDoctoralSupervisor()
    {
        return isDoctoralSupervisor;
    }
    public void setLanguage(String language)
    {
        this.language = language;
    }

    public String getLanguage()
    {
        return language;
    }
    public void setDegree(String degree)
    {
        this.degree = degree;
    }

    public String getDegree()
    {
        return degree;
    }
    public void setStandard(String standard)
    {
        this.standard = standard;
    }

    public String getStandard()
    {
        return standard;
    }
    public void setReviewExperience(String reviewExperience)
    {
        this.reviewExperience = reviewExperience;
    }

    public String getReviewExperience()
    {
        return reviewExperience;
    }
    public void setMainIndustry(String mainIndustry)
    {
        this.mainIndustry = mainIndustry;
    }

    public String getMainIndustry()
    {
        return mainIndustry;
    }
    public void setElseIndustry(String elseIndustry)
    {
        this.elseIndustry = elseIndustry;
    }

    public String getElseIndustry()
    {
        return elseIndustry;
    }
    public void setFundSubject(String fundSubject)
    {
        this.fundSubject = fundSubject;
    }

    public String getFundSubject()
    {
        return fundSubject;
    }
    public void setInternationalDiscipline(String internationalDiscipline)
    {
        this.internationalDiscipline = internationalDiscipline;
    }

    public String getInternationalDiscipline()
    {
        return internationalDiscipline;
    }
    public void setEducationSubject(String educationSubject)
    {
        this.educationSubject = educationSubject;
    }

    public String getEducationSubject()
    {
        return educationSubject;
    }
    public void setIndustries(String industries)
    {
        this.industries = industries;
    }

    public String getIndustries()
    {
        return industries;
    }
    public void setResearchDirection(String researchDirection)
    {
        this.researchDirection = researchDirection;
    }

    public String getResearchDirection()
    {
        return researchDirection;
    }
    public void setWorkContent(String workContent)
    {
        this.workContent = workContent;
    }

    public String getWorkContent()
    {
        return workContent;
    }
    public void setMainContribution(String mainContribution)
    {
        this.mainContribution = mainContribution;
    }

    public String getMainContribution()
    {
        return mainContribution;
    }
    public void setRewardsPunishment(String rewardsPunishment)
    {
        this.rewardsPunishment = rewardsPunishment;
    }

    public String getRewardsPunishment()
    {
        return rewardsPunishment;
    }
    public void setAvoidCompany(String avoidCompany)
    {
        this.avoidCompany = avoidCompany;
    }

    public String getAvoidCompany()
    {
        return avoidCompany;
    }
    public void setResultsOrPatents(String resultsOrPatents)
    {
        this.resultsOrPatents = resultsOrPatents;
    }

    public String getResultsOrPatents()
    {
        return resultsOrPatents;
    }
    public void setHonorsOrTitles(String honorsOrTitles)
    {
        this.honorsOrTitles = honorsOrTitles;
    }

    public String getHonorsOrTitles()
    {
        return honorsOrTitles;
    }
    public void setResumeSite(String resumeSite)
    {
        this.resumeSite = resumeSite;
    }

    public String getResumeSite()
    {
        return resumeSite;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("userId", getUserId())
                .append("userName", getUserName())
                .append("portrait", getPortrait())
                .append("password", getPassword())
                .append("idNumberType", getIdNumberType())
                .append("userIdNumber", getUserIdNumber())
                .append("birthDate", getBirthDate())
                .append("age", getAge())
                .append("phoneNumber", getPhoneNumber())
                .append("email", getEmail())
                .append("officePhone", getOfficePhone())
                .append("homeTelephone", getHomeTelephone())
                .append("userSex", getUserSex())
                .append("nationality", getNationality())
                .append("nation", getNation())
                .append("postalCode", getPostalCode())
                .append("politicsStatus", getPoliticsStatus())
                .append("professional", getProfessional())
                .append("dwellRegion", getDwellRegion())
                .append("dwellSite", getDwellSite())
                .append("specialtyType", getSpecialtyType())
                .append("jobNature", getJobNature())
                .append("companyName", getCompanyName())
                .append("companyType", getCompanyType())
                .append("companyRegion", getCompanyRegion())
                .append("creditCode", getCreditCode())
                .append("secondLevelDepartment", getSecondLevelDepartment())
                .append("position", getPosition())
                .append("companySite", getCompanySite())
                .append("highestEducation", getHighestEducation())
                .append("graduateAcademy", getGraduateAcademy())
                .append("major", getMajor())
                .append("highestDegree", getHighestDegree())
                .append("awardAcademy", getAwardAcademy())
                .append("majorAcademy", getMajorAcademy())
                .append("isAcademician", getIsAcademician())
                .append("isDoctoralSupervisor", getIsDoctoralSupervisor())
                .append("language", getLanguage())
                .append("degree", getDegree())
                .append("standard", getStandard())
                .append("reviewExperience", getReviewExperience())
                .append("mainIndustry", getMainIndustry())
                .append("elseIndustry", getElseIndustry())
                .append("fundSubject", getFundSubject())
                .append("internationalDiscipline", getInternationalDiscipline())
                .append("educationSubject", getEducationSubject())
                .append("industries", getIndustries())
                .append("researchDirection", getResearchDirection())
                .append("workContent", getWorkContent())
                .append("mainContribution", getMainContribution())
                .append("rewardsPunishment", getRewardsPunishment())
                .append("avoidCompany", getAvoidCompany())
                .append("resultsOrPatents", getResultsOrPatents())
                .append("honorsOrTitles", getHonorsOrTitles())
                .append("resumeSite", getResumeSite())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("status", getStatus())
                .toString();
    }
}
