package com.ruoyi.talents.controller;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.framework.web.service.TokenService;
import com.ruoyi.talents.domain.User;
import com.ruoyi.talents.domain.vo.DistributionVo;
import com.ruoyi.talents.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author LiWang
 */
@RestController
@RequestMapping("/home")
@Api(value = "首页查询",tags = "首页查询")
public class HomeController extends BaseController
{
    @Autowired
    private IUserService userService;

    @Autowired
    private TokenService tokenService;

    /**
     * 申报数据统计
     */
    @GetMapping("/statistics")
    @ApiOperation(httpMethod = "GET",value = "申报数据统计")
    public Map statistics() {
        return userService.statisticsList();
    }

    /**
     * 人才/企业区域分布
     */
    @GetMapping("/distribution")
    @ApiOperation(httpMethod = "GET",value = "人才/企业区域分布")
    public List<DistributionVo> distribution() {
        return userService.distributionList();
    }

    /**
     * 年龄与性别分布
     */
    @GetMapping("/ageAndSex")
    @ApiOperation(httpMethod = "GET",value = "年龄与性别分布")
    public Map ageAndSex() {
        return userService.ageAndSexList();
    }

    /**
     * 学历分布和专业类别
     */
    @GetMapping("/specialityAndEducation")
    @ApiOperation(httpMethod = "GET",value = "学历分布和专业类别")
    public Map specialityAndEducation() {
        return userService.specialityAndEducationMap();
    }

    /**
     * 申报趋势
     */
    @GetMapping("/trendList")
    @ApiOperation(httpMethod = "GET",value = "申报趋势")
    @ApiImplicitParam(name = "isMonth",value = "(0:月度1:年度)",dataType = "int")
    public List trendList(int isMonth) {
        return userService.trendList(isMonth);
    }

    /**
     * 单位类别
     */
    @GetMapping("/companyType")
    @ApiOperation(httpMethod = "GET",value = "单位类别")
    @ApiImplicitParam(name = "type",value = "",dataType = "int")
    public List companyType(String type) {
        return userService.companyType(type);
    }

    /**
     * 人才专家行业领域分布
     */
    @GetMapping("/companyRegion")
    @ApiOperation(httpMethod = "GET",value = "人才专家行业领域分布")
    @ApiImplicitParam(name = "type",value = "",dataType = "int")
    public List companyRegion(String type) {
        return userService.companyRegion(type);
    }




}
