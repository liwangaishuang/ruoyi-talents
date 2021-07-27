package com.ruoyi.talents.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.talents.domain.dto.UserDto;
import com.ruoyi.talents.domain.vo.ExportUserVo;
import com.ruoyi.talents.service.IDeclarationInformationService;
import com.ruoyi.talents.utils.WordUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.BeanUtils;
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
    private IDeclarationInformationService informationService;

    @Autowired
    private TokenService tokenService;
    /**
     * 查询列表
     */
    @GetMapping("/list")
    @ApiOperation(httpMethod = "GET",value = "查询列表")
    public TableDataInfo list(User user)
    {
        startPage();
        List<User> list = userService.selectUserList(user);
        return getDataTable(list);
    }

    /**
     * 查询人才专家库列表
     */
    @GetMapping("/specialist/list")
    @ApiOperation(httpMethod = "GET",value = "查询人才专家库列表")
    public TableDataInfo specialistList(User user)
    {
        System.out.println(user);
        startPage();
        List<User> list = userService.selectSpecialistList(user);
        return getDataTable(list);
    }

    /**
     * 查询人才移除管理列表
     */
    @GetMapping("/remove/list")
    @ApiOperation(httpMethod = "GET",value = "查询人才移除管理列表")
    public TableDataInfo selectRemoveList(User user)
    {
        System.out.println(user);
        startPage();
        List<User> list = userService.selectRemoveList(user);
        return getDataTable(list);
    }

    /**
     * 查询人才申报审批列表
     */
    @GetMapping("/examine/list")
    @ApiOperation(httpMethod = "GET",value = "查询人才申报审批列表")
    public TableDataInfo examineList(User user)
    {
        startPage();
        List<User> list = userService.selectExamineList(user);
        return getDataTable(list);
    }

    /**
     * 注册用户
     */
    @GetMapping("/registered/list")
    @ApiOperation(httpMethod = "GET",value = "注册用户")
    public TableDataInfo registeredList(UserDto userDto)
    {
        startPage();
        List<UserDto> list = userService.selectRegisteredList(userDto);
        return getDataTable(list);
    }

    /**
     * 导出人才管理用户
     */
    @PreAuthorize("@ss.hasPermi('declare:self:export')")
    @Log(title = "用户", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    @ApiOperation(httpMethod = "GET",value = "导出人才管理用户")
    public AjaxResult export(User user) {
        List<ExportUserVo> list = userService.selectUserList2(user);
        ExcelUtil<ExportUserVo> util = new ExcelUtil<ExportUserVo>(ExportUserVo.class);
        return util.exportExcel(list, "用户数据");
    }

    /**
     * 导出人才移除用户
     */
    @Log(title = "用户", businessType = BusinessType.EXPORT)
    @GetMapping("/exportRemove")
    @ApiOperation(httpMethod = "GET",value = "导出人才移除用户")
    public AjaxResult exportRemove(User user) {
        List<ExportUserVo> list = userService.selectUserList3(user);
        ExcelUtil<ExportUserVo> util = new ExcelUtil<ExportUserVo>(ExportUserVo.class);
        return util.exportExcel(list, "用户数据");
    }

    /**
     * 获取用户详细信息
     */
    @PreAuthorize("@ss.hasRole('declare')")
    @GetMapping(value = "/{id}")
    @ApiOperation(httpMethod = "GET",value = "获取用户详细信息")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(userService.selectUserById(id));
    }

    /**
     * 获取用户最近的详细信息
     */
    @GetMapping(value = "/newest")
    @ApiOperation(httpMethod = "GET",value = "获取用户最近的详细信息")
    public AjaxResult getNewestInfo()
    {
        return AjaxResult.success(userService.getNewestInfo());
    }

    /**
     * 新增用户
     */
    @PreAuthorize("@ss.hasRole('declare')")
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
    @PreAuthorize("@ss.hasPermi('declare:self:edit')")
    @Log(title = "用户", businessType = BusinessType.UPDATE)
    @PutMapping
    @ApiOperation(httpMethod = "PUT",value = "修改用户")
    public AjaxResult edit(@RequestBody User user)
    {
        return toAjax(userService.updateUser(user));
    }

    /**
     * 注册用户审批
     */
    @Log(title = "注册用户审批", businessType = BusinessType.UPDATE)
    @PutMapping(value = "/examine")
    @ApiOperation(httpMethod = "PUT",value = "修改用户")
    public AjaxResult examineUser(@RequestBody Map map)
    {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id",map.get("id"));
        hashMap.put("examineStatus",map.get("examineStatus"));
        hashMap.put("auditExplain",map.get("auditExplain"));
        return toAjax(userService.examineUser(hashMap));
    }

    /**
     * 移除专家库
     */
    @Log(title = "移除专家库", businessType = BusinessType.UPDATE)
    @PutMapping(value = "/remove")
    @ApiOperation(httpMethod = "PUT",value = "移除专家库")
    public AjaxResult removeUser(@RequestBody Map map)
    {
        return toAjax(userService.removeUser(map));
    }

    /**
     * 移回专家库
     */
    @Log(title = "移回专家库", businessType = BusinessType.UPDATE)
    @PutMapping(value = "/retract/{ids}")
    @ApiOperation(httpMethod = "PUT",value = "移回专家库")
    public AjaxResult retractUser(@PathVariable Long[] ids)
    {
        return toAjax(userService.retractUserById(ids));
    }

    /**
     * 修改用户密码
     */
    @Log(title = "修改用户密码", businessType = BusinessType.UPDATE)
    @PutMapping("/edit")
    @ApiOperation(httpMethod = "PUT",value = "修改用户密码")
    public AjaxResult editPassword(@RequestBody SysUser sysUser)
    {
        return toAjax(userService.editPassword(sysUser));
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


    /**
     * 获取当前登录用户的申报进度
     */
    @GetMapping(value = "/schedule")
    @ApiOperation(httpMethod = "GET",value = "获取当前登录用户的申报进度")
    public AjaxResult getScheduleInfo() {
        return AjaxResult.success(informationService.getScheduleInfo());
    }

    /**
     * 申报进度过程
     */
    @GetMapping(value = "/declareProcess")
    @ApiOperation(httpMethod = "GET",value = "申报进度过程")
    public AjaxResult declareProcess() {
        return AjaxResult.success(informationService.declareProcess());
    }
}
