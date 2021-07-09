package com.ruoyi.talents.controller;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.framework.web.service.TokenService;
import com.ruoyi.talents.domain.User;
import com.ruoyi.talents.service.IUserService;
import io.swagger.annotations.Api;
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
    @GetMapping("/statisticsList")
    @ApiOperation(httpMethod = "GET",value = "申报数据统计")
    public Map statisticsList()
    {
        return userService.statisticsList();
    }



}
