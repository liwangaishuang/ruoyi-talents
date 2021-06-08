package com.ruoyi.talents.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.talents.domain.User;
import com.ruoyi.talents.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * 用户Controller
 * 
 * @author ruoyi
 * @date 2021-06-07
 */
@RestController
@RequestMapping("/declare/specialist")
@Api(value = "用户",tags = "用户")
public class UserController extends BaseController
{
    @Autowired
    private IUserService userService;

    /**
     * 查询用户列表
     */
    @ApiOperation(httpMethod = "GET",value = "查询用户列表")
    @GetMapping("/list")
    public TableDataInfo list(User user)
    {
        startPage();
        List<User> list = userService.selectUserList(user);
        return getDataTable(list);
    }

    /**
     * 导出用户列表
     */
    @ApiOperation(httpMethod = "GET",value = "导出用户列表")
    @Log(title = "用户", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(User user)
    {
        List<User> list = userService.selectUserList(user);
        ExcelUtil<User> util = new ExcelUtil<User>(User.class);
        return util.exportExcel(list, "用户数据");
    }

    /**
     * 获取用户详细信息
     */
    @ApiOperation(httpMethod = "GET",value = "获取用户详细信息")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(userService.selectUserById(id));
    }

    /**
     * 新增用户
     */
    @ApiOperation(httpMethod = "POST",value = "新增用户")
    @Log(title = "用户", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody User user)
    {
        return toAjax(userService.insertUser(user));
    }

    /**
     * 修改用户
     */
    @ApiOperation(httpMethod = "PUT",value = "修改用户")
    @Log(title = "用户", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody User user)
    {
        return toAjax(userService.updateUser(user));
    }

    /**
     * 删除用户
     */
    @ApiOperation(httpMethod = "DELETE",value = "删除用户")
    @Log(title = "用户", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(userService.deleteUserByIds(ids));
    }
}
