package com.ruoyi.talents.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.talents.domain.UserEducationExperience;
import com.ruoyi.talents.domain.UserOccupational;
import com.ruoyi.talents.domain.UserWorkExperience;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ExportUserVo {
    private static final long serialVersionUID = 1L;

    /** id*/
    @Excel(name = "id")
    private Long id;

    /** 用户姓名 */
    @Excel(name = "用户姓名")
    private String userName;

    /** 证件类型 */
    @Excel(name = "证件类型", readConverterExp = "0=身份证,1=港澳居民来往内地通行证,2=港澳台居民居住证,3=外国人永久居留居住证,4=台湾居民来往大陆通行证,5=其它,6=中国护照")
    private String idNumberType;

    /** 证件号码 */
    @Excel(name = "证件号码")
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

    /** 性别(0:男1:女) */
    @Excel(name = "性别" , readConverterExp = "0=男,1=女,2=未知")
    private String userSex;

    /** 国籍 */
    @Excel(name = "国籍" , readConverterExp = "1=中国,2=中国(澳门),3=中国(台湾),4=中国(香港),5=其它")
    private String nationality;

    /** 民族 */
    @Excel(name = "民族" , readConverterExp = "1=汉族,2=蒙古族,3=回族,4=藏族,5=维吾尔族,6=苗族,7=彝族8=壮族,9=布依族,10=朝鲜族,11=满族,12=侗族,13=瑶族,14=白族," +
            "15=土家族,16=哈尼族,17=哈萨克族,18=傣族,19=黎族,20=僳僳族,21=佤族,22=畲族,23=高山族,24=拉祜族,25=水族,26=东乡族,27=纳西族,28=景颇族,29=柯尔克孜族," +
            "30=土族,31=达斡尔族," + "32=仫佬族,33=羌族,34=布朗族,35=撒拉族,36=毛南族,37=仡佬族,38=锡伯族,39=阿昌族,40=普米族,41=塔吉克族,42=怒族,43=乌孜别克族," +
            "44=俄罗斯族,45=鄂温克族,46=德昂族,47=保安族,48=裕固族,49=京族,50=塔塔尔族,51=独龙族,52=鄂伦春族,53=赫哲族,54=门巴族,55=珞巴族,56=基诺族,57=其它")
    private String nation;

    /** 邮政编码 */
    @Excel(name = "邮政编码")
    private String postalCode;

    /** 政治面貌 */
    @Excel(name = "政治面貌" , readConverterExp = "1=中共党员,2=中共预备党员,3=共青团,4=其它党派人士,5=无党派人员")
    private String politicsStatus;

    /** 职称 */
    @Excel(name = "职称" , readConverterExp = "1=正高级,2=副高级,3=中级,4=初级及以下")
    private String professional;

    /** 居住地区 */
    @Excel(name = "居住地区" , readConverterExp = "1=福田区,2=罗湖区,3=南山区,4=宝安区,5=龙华区,6=龙岗区,7=大鹏新区8=盐田区,9=坪山区,10=光明区,11=深汕特别合作区,12=非深圳地区")
    private String dwellRegion;

    /** 居住地址 */
    @Excel(name = "居住地址")
    private String dwellSite;

    /** 专业类别 */
    @Excel(name = "专业类别" , readConverterExp = "1=专业技术类,2=人力资源类")
    private String specialtyType;

    /** 工作性质 */
    @Excel(name = "工作性质" , readConverterExp = "1=基础研究,2=科技管理,3=法律实务,4=企业管理,5=投资融资,6=财务管理,7=应用研究8=战略咨询,9=试验发展")
    private String jobNature;

    /** 单位名称 */
    @Excel(name = "单位名称")
    private String companyName;

    /** 单位类型 */
    @Excel(name = "单位类型" , readConverterExp = "1=政府机关,2=大专院校,3=研究院校,4=其它事业单位,5=国有企业,6=集体私有制企业,7=私营企业,8=港澳台投资企业,9=外商投资企业,10=合资企业,11=个体经营,12=其它所有制企业,13=社会团休,14=其它企业")
    private String companyType;

    /** 单位地区 */
    @Excel(name = "单位地区" , readConverterExp = "1=福田区,2=罗湖区,3=南山区,4=宝安区,5=龙华区,6=龙岗区,7=大鹏新区8=盐田区,9=坪山区,10=光明区,11=深汕特别合作区,12=其它地区")
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
    @Excel(name = "最高学历" , readConverterExp = "1=博士研究生,2=硕士研究生,3=大学本科,4=大学专科,5=其它")
    private String highestEducation;

    /** 毕业院校 */
    @Excel(name = "毕业院校")
    private String graduateAcademy;

    /** 学历所学专业 */
    @Excel(name = "所学专业")
    private String major;

    /**1=,2=,3=,4=,5=,6=,7=8=,9=,10=,11=,12=,13=,14=,15=,16=,17=,18=,19=,20=,21=,22=,23=,24=,25=,26=,27=,28=,29=,30=,31=
     * ,32=,33=,34=,35=,36=,37=,38=,39=,40=,41=,42=,43=,44=,45=,46=,47=,48=,49=,50=,51=,52=,53=,54=,55=,56=,57=,58=
     * ,59=,60=,61=,62=,63=,64=,65=,66=,67=*/
    /** 最高学位 */
    @Excel(name = "最高学位" , readConverterExp = "1=名誉博士,2=博士,3=哲学博士,4=经济学博士,5=法学博士,6=教育学博士,7=文学博士,8=历史学博士,9=理学博士,10=工学博士,11=农学博士," +
            "12=医学博士,13=军事学博士,14=管理学博士,15=临床医学博士,16=兽医博士,17=口腔医学博士,18=副博士,19=哲学副博士,20=经济学副博士,21=法学副博士,22=教育学副博士,23=文学副博士," +
            "24=历史学副博士,25=理学副博士,26=工学副博士,27=农学副博士,28=医学副博士,29=军事学副博士,30=硕士,31=哲学硕士,32=经济学硕士,33=法学硕士,34=教育学硕士,35=文学硕士,36=历史学硕士," +
            "37=理学硕士,38=工学硕士,39=农学硕士,40=医学硕士,41=军事学硕士,42=管理学硕士,43=工商管理硕士,44=工程硕士,45=法律硕士,46=教育硕士,47=建筑学硕士,48=临床医学硕士,49=农业推广硕士," +
            "50=兽医硕士,51=公共管理硕士,52=口腔医学硕士,53=公共卫生硕士,54=学士,55=哲学学士,56=经济学学士,57=法学学士,58=教育学学士,59=文学学士,60=历史学学士,61=理学学士,62=工学学士," +
            "63=农学学士,64=医学学士,65=军事学学士,66=管理学学士,67=建筑学学士")
    private String highestDegree;

    /** 授予院校 */
    @Excel(name = "授予院校")
    private String awardAcademy;

    /** 学位所学专业 */
    @Excel(name = "所学专业")
    private String majorAcademy;

    /** 是否博士生导师 */
    @Excel(name = "是否博士生导师")
    private String isDoctoralSupervisor;

    /** 是否两院院士 */
    @Excel(name = "是否两院院士")
    private String isAcademician;

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

    /** 工作经历 */
    @Excel(name = "工作经历")
    private List<UserWorkExperience> workExperience;

    /** 教育经历 */
    @Excel(name = "教育经历")
    private List<UserEducationExperience> experience;

    /** 用户职业资格对象 */
    @Excel(name = "职业资格")
    private List<UserOccupational> occupational;

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
}
