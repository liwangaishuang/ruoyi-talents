package com.ruoyi.talents.controller;

import java.util.List;

import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.talents.utils.WordUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import com.ruoyi.framework.web.service.TokenService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.talents.domain.User;
import com.ruoyi.talents.service.IUserService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

import javax.servlet.http.HttpServletResponse;

/**
 * 用户Controller
 *
 * @author ruoyi
 * @date 2021-06-11
 */
@RestController
@RequestMapping("/declare/specialist")
@Api(value = "填报用户",tags = "填报用户")
public class UserController extends BaseController
{
    @Autowired
    private IUserService userService;

    @Autowired
    private TokenService tokenService;
    /**
     * 查询用户列表
     */
    @PreAuthorize("@ss.hasPermi('talents:self:list')")
    @GetMapping("/list")
    @ApiOperation(httpMethod = "GET",value = "查询用户列表")
    public TableDataInfo list(User user)
    {
        startPage();
        List<User> list = userService.selectUserList(user);
        return getDataTable(list);
    }

    /**
     * 导出用户列表
     */
    @PreAuthorize("@ss.hasPermi('talents:self:export')")
    @Log(title = "用户", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    @ApiOperation(httpMethod = "GET",value = "导出用户列表")
    public AjaxResult export(User user)
    {
        List<User> list = userService.selectUserList(user);
        ExcelUtil<User> util = new ExcelUtil<User>(User.class);
        return util.exportExcel(list, "用户数据");
    }

    /**
     * 获取用户详细信息
     */
    @PreAuthorize("@ss.hasPermi('talents:self:query')")
    @GetMapping(value = "/{id}")
    @ApiOperation(httpMethod = "GET",value = "获取用户详细信息")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(userService.selectUserById(id));
    }

    /**
     * 新增用户
     */
    @PreAuthorize("@ss.hasPermi('talents:self:add')")
    @Log(title = "用户", businessType = BusinessType.INSERT)
    @PostMapping
    @ApiOperation(httpMethod = "POST",value = "新增用户")
    public Long add(@RequestBody User user)
    {
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        String id = loginUser.getUser().getUserId()+"";
        user.setUserId(id);
        userService.insertUser(user);
        return user.getId();
    }

    /**
     * 修改用户
     */
    @PreAuthorize("@ss.hasPermi('talents:self:edit')")
    @Log(title = "用户", businessType = BusinessType.UPDATE)
    @PutMapping
    @ApiOperation(httpMethod = "PUT",value = "修改用户")
    public AjaxResult edit(@RequestBody User user)
    {
        return toAjax(userService.updateUser(user));
    }

    /**
     * 删除用户
     */
    @PreAuthorize("@ss.hasPermi('talents:self:remove')")
    @Log(title = "用户", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    @ApiOperation(httpMethod = "DELETE",value = "删除用户")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(userService.deleteUserByIds(ids));
    }



    /**
     * 导出用户word
     */
    @GetMapping("/exportWord")
    @ApiOperation(httpMethod = "GET",value = "导出用户word")
    public AjaxResult exportWord(HttpServletResponse response, User user)
    {
        User user1 = userService.selectUserById(user.getId()+"");
        return WordUtil.exportWord(user1,response);
    }
}
